package ir.behi.session_with_redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@PropertySource(value = "classpath:config.yml")
public class RedisConfig {
    @Value("${my.redis.host}")
    private String redisHost;
    @Value("${my.redis.password}")
    private String redisPassword;
    @Value("${my.redis.port}")
    private Integer redisPort;

    @Bean
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration configuration=new RedisStandaloneConfiguration();
        configuration.setHostName(redisHost);
        configuration.setPort(redisPort);
        configuration.setPassword(redisPassword);
        return new JedisConnectionFactory(configuration);
    }
}
