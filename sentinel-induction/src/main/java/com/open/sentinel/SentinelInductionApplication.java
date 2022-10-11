package com.open.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 11:07
 * @Description
 */
@SpringBootApplication
public class SentinelInductionApplication {
    public static void main(String[] args) {
        System.setProperty("project.name", "sentinel-induction");
        SpringApplication.run(SentinelInductionApplication.class, args);
    }
}
