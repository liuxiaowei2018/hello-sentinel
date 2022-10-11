package com.open.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 12:12
 * @Description
 */
@SpringBootApplication
@EnableFeignClients
public class SentinelFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelFeignApplication.class, args);
    }
}
