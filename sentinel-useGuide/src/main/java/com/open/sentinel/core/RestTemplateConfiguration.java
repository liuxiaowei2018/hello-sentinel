package com.open.sentinel.core;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 13:18
 * @Description 通过 @SentinelRestTemplate 注解，声明 Sentinel 对 RestTemplate 的支持
 * @SentinelRestTemplate 注解提供了 blockHandler、blockHandlerClass、fallback、fallbackClass 属性，作用和 @SentinelResource 注解是一致的
 */
@Configuration
public class RestTemplateConfiguration {

    @Bean
    @SentinelRestTemplate
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
