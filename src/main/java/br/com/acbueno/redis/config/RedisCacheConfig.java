package br.com.acbueno.redis.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@SuppressWarnings("deprecation")
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

  @Bean
  public RedisCacheConfiguration cacheConfiguration() {
    //@formatter:off
    return RedisCacheConfiguration.defaultCacheConfig()
        .serializeValuesWith(RedisSerializationContext.SerializationPair
            .fromSerializer(new GenericJackson2JsonRedisSerializer()));
   //@formatter:on
  }

  @Bean
  public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
    // @formatter:off
    return RedisCacheManager
        .builder(redisConnectionFactory)
        .cacheDefaults(cacheConfiguration())
        .build();
    //@formatter:on
  }

  @Override
  public CacheErrorHandler errorHandler() {
    return new SimpleCacheErrorHandler();
  }

}
