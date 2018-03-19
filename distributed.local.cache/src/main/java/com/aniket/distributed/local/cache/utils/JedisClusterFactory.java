//package com.aniket.distributed.local.cache.utils;
//
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.FactoryBean;
//import org.springframework.beans.factory.InitializingBean;
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.JedisCluster;
//import java.util.HashSet;
//import java.util.Set;
//
//public class JedisClusterFactory implements FactoryBean<JedisCluster>, InitializingBean {
//
//    private static final Logger logger = LoggerFactory.getLogger(JedisClusterFactory.class);
//
//    private HashSet<String> redisHostsSet;
//    private JedisCluster jedisCluster;
//    private int timeout;
//    private int maxRedirections;
//    private GenericObjectPoolConfig genericObjectPoolConfig;
//
//    @Override
//    public JedisCluster getObject() throws Exception {
//        return jedisCluster;
//    }
//
//    @Override
//    public Class<? extends JedisCluster> getObjectType() {
//        return (this.jedisCluster != null ? this.jedisCluster.getClass() : JedisCluster.class);
//    }
//
//    @Override
//    public boolean isSingleton() {
//        return true;
//    }
//
//    private Set<HostAndPort> parseHostAndPort() throws Exception {
//        try {
//            Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
//            for (String key : redisHostsSet) {
//                String[] ipAndPort = key.split(":");
//                HostAndPort hap = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
//                hostAndPortSet.add(hap);
//            }
//            return hostAndPortSet;
//        } catch (IllegalArgumentException ex) {
//            logger.error("IllegalArgumentException Exception while creating JedisCluster",ex);
//            throw ex;
//        } catch (Exception ex) {
//            throw new Exception("Exception  while creating JedisCluster", ex);
//        }
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        Set<HostAndPort> haps = this.parseHostAndPort();
//        jedisCluster = new JedisCluster(haps, timeout, maxRedirections,genericObjectPoolConfig);
//
//    }
//
//
//    public void setTimeout(int timeout) {
//        this.timeout = timeout;
//    }
//
//    public void setMaxRedirections(int maxRedirections) {
//        this.maxRedirections = maxRedirections;
//    }
//
//
//    public void setGenericObjectPoolConfig(GenericObjectPoolConfig genericObjectPoolConfig) {
//        this.genericObjectPoolConfig = genericObjectPoolConfig;
//    }
//
//    public HashSet<String> getRedisHostsSet() {
//        return redisHostsSet;
//    }
//
//    public void setRedisHostsSet(HashSet<String> redisHostsSet) {
//        this.redisHostsSet = redisHostsSet;
//    }
//
//    public JedisCluster getJedisCluster() {
//        return jedisCluster;
//    }
//
//    public void setJedisCluster(JedisCluster jedisCluster) {
//        this.jedisCluster = jedisCluster;
//    }
//
//    public Integer getTimeout() {
//        return timeout;
//    }
//
//    public void setTimeout(Integer timeout) {
//        this.timeout = timeout;
//    }
//
//    public Integer getMaxRedirections() {
//        return maxRedirections;
//    }
//
//    public void setMaxRedirections(Integer maxRedirections) {
//        this.maxRedirections = maxRedirections;
//    }
//
//    public GenericObjectPoolConfig getGenericObjectPoolConfig() {
//        return genericObjectPoolConfig;
//    }
//}
