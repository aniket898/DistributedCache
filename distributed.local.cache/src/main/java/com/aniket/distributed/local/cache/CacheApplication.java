package com.aniket.distributed.local.cache;

import com.aniket.distributed.local.cache.service.MessagePublisher;
import com.aniket.distributed.local.cache.service.RedisMessagePublisher;
import com.aniket.distributed.local.cache.service.RedisMessageSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import java.util.Arrays;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@ImportResource(value = { "classpath:application-config.xml"})
public class CacheApplication extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(CacheApplication.class);
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CacheApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}

	@Value("${spring.redis.cluster.nodes}")
	private String redisClusterNodes;

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory(new RedisClusterConfiguration(Arrays.asList(redisClusterNodes.split(","))));
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		return template;
	}

	@Bean("taxiRideTopicAdapter")
	MessageListenerAdapter taxiRideTopicAdapter() {
		return new MessageListenerAdapter(new RedisMessageSubscriber(), "receiveTaxiRideTopicNotifications");
	}

	@Bean("keyspaceTopicAdapter")
	MessageListenerAdapter keyspaceTopicAdapter() {
		return new MessageListenerAdapter(new RedisMessageSubscriber(), "receiveKeyspaceTopicNotifications");
	}

	@Bean
	RedisMessageListenerContainer redisContainer(@Qualifier("taxiRideTopicAdapter") MessageListenerAdapter taxiRideTopicAdapter,
												 @Qualifier("keyspaceTopicAdapter") MessageListenerAdapter keyspaceTopicAdapter) {
		final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(jedisConnectionFactory());
		container.addMessageListener(taxiRideTopicAdapter, taxiRideTopic());
		container.addMessageListener(keyspaceTopicAdapter, keyspaceTopic());
		return container;
	}

	@Bean
	MessagePublisher redisTaxiRideTopicPublisher(@Qualifier("taxiRideTopic") PatternTopic taxiRideTopic) {
		return new RedisMessagePublisher(redisTemplate(), taxiRideTopic);
	}


	@Bean("taxiRideTopic")
	PatternTopic taxiRideTopic() {
		return new PatternTopic("taxiride");
	}

	@Bean("keyspaceTopic")
	PatternTopic keyspaceTopic() {
		return new PatternTopic("__keyevent@*");
	}
}
