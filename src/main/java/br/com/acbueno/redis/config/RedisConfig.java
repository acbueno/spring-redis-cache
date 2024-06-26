package br.com.acbueno.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import br.com.acbueno.redis.entity.Car;

@Configuration
public class RedisConfig {

  @Bean
  public RedisTemplate<String, Car> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Car> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Car.class));
    return redisTemplate;
  }

}
