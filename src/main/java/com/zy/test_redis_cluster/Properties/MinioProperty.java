package com.zy.test_redis_cluster.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "spring.minio")
public class MinioProperty {
    @Value("${spring.minio.endpoint}")
    private String endpoint;

    @Value("${spring.minio.port}")
    private Integer port;

    @Value("${spring.minio.accessKey}")
    private String accessKey;

    @Value("${spring.minio.secretKey}")
    private String secretKey;

    public String getEndpoint() {
        return endpoint;
    }

    public Integer getPort() {
        return port;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
