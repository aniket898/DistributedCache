# DistributedCache with Local Cache Invalidation

Often times, projects need a large distributed cache along with application server side local in memory cache for faster fetching of data.
It is difficult to keep all local caches in sync with changes which may occur at :
	1.	Any local application server cache
	2.	At the distributed cache directly
This is a well known problem of local cache invalidation.

In order to resolve this problem, this project proposes Redis as a distributed cache. For local cache, we will try to experiment with MapDB, EhCache etc.
We want to explore off heap cache too to check if GC performance improves.
To keep the local caches in sync, the Redis pub-sub will be used.