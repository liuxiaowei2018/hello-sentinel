package com.open.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 14:37
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelGuideApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelGuideApplication.class, args);
    }
}
