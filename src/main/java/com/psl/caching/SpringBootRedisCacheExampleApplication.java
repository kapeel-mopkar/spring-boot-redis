package com.psl.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@SpringBootApplication
public class SpringBootRedisCacheExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisCacheExampleApplication.class, args);
	}
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		return new JedisConnectionFactory();
	}
	
	@Bean
	RedisTemplate<String, Object> redisTemplate(){
		//		RedisTemplate<String,Item> redisTemplate = new RedisTemplate<String, Item>();
		//		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		//		return redisTemplate;
		
		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
	    return template;
	}

}
