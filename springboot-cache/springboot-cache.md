
# spring-cache

## 一：Spring缓存抽象
Spring从3.1开始定义了
org.springframework.cache.Cache
org.springframework.cache.CacheManager
接口来统一不同的缓存技术；并支持使用JCache(JSR-107)注解简化我们开发；

Cache接口为缓存的组件规范定义,包含缓存的各种操作集合；

Cache接口下Spring提供了各种xxxCache的实现;
如RedisCache,EhCacheCache ,ConcurrentMapCache等；

每次调用需要缓存功能的方法时,Spring会检查检查指定参数的指定的目标方法是否已经被调用过;
如果有就直接从缓存中获取方法调用后的结果,如果没有就调用方法并缓存结果后返回给用户。
下次调用直接从缓存中获取。

使用Spring缓存抽象时我们需要关注以下两点；
1. 确定方法需要被缓存以及他们的缓存策略
2. 从缓存中读取之前缓存存储的数据


## 二：缓存注解

### @CacheConfig
当需要缓存的地方越来越多,可以使用`@CacheConfig(cacheNames = {"myCache"})`注解来统一指定value的值,这时可省略value
如果在方法依旧写上了value,那么依然以方法的value值为准
```
String keyGenerator() default "";  //key的生成器。key/keyGenerator二选一使用
String cacheManager() default "";  //指定缓存管理器
String cacheResolver() default ""; //或者指定获取解析器
```


### @Cacheable
```
String[] cacheNames() default {}; //和value注解差不多,二选一
String keyGenerator() default ""; //key的生成器。key/keyGenerator二选一使用
String cacheManager() default ""; //指定缓存管理器
String cacheResolver() default ""; //或者指定获取解析器
String condition() default ""; //条件符合则缓存
String unless() default ""; //条件符合则不缓存
boolean sync() default false; //是否使用异步模式
```


### @CachePut
@CachePut注解的作用 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的是，它每次都会触发真实方法的调用 。
简单来说就是用户更新缓存数据。
但需要注意的是该注解的value 和 key 必须与要更新的缓存相同，也就是与@Cacheable 相同。
```
String[] cacheNames() default {}; //与value二选一
String keyGenerator() default "";  //key的生成器。key/keyGenerator二选一使用
String cacheManager() default "";  //指定缓存管理器
String cacheResolver() default ""; //或者指定获取解析器
String condition() default ""; //条件符合则缓存
String unless() default ""; //条件符合则不缓存
```


### @CacheEvict
@CachEvict 的作用 主要针对方法配置，能够根据一定的条件对缓存进行清空 。
```
allEntries //是否清空所有缓存内容，缺省为 false，如果指定为 true，则方法调用后将立即清空所有缓存
            //@CachEvict(value=”testcache”,allEntries=true)
beforeInvocation //是否在方法执行前就清空，缺省为 false，如果指定为 true，则在方法还没有执行的时候就清空缓存，缺省情况下，如果方法执行抛出异常，则不会清空缓存
                    //@CachEvict(value=”testcache”，beforeInvocation=true)
```

```
String[] cacheNames() default {}; //与value二选一
String keyGenerator() default "";  //key的生成器。key/keyGenerator二选一使用
String cacheManager() default "";  //指定缓存管理器
String cacheResolver() default ""; //或者指定获取解析器
String condition() default ""; //条件符合则清空
```











