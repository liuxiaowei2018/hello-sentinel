package com.open.sentinel.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 13:08
 * @Description
 */
@FeignClient(name = "sentinel-actuator", url = "http://127.0.0.1:19450",
        fallbackFactory = ProviderFeignClientFallbackFactory.class)
public interface ProviderFeignClient {

    @GetMapping("/demo/echo")
    String echo();
}
