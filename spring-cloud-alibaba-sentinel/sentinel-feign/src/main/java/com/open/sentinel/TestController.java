package com.open.sentinel;

import com.open.sentinel.feign.ProviderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 13:07
 * @Description
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ProviderFeignClient providerFeignClient;

    @GetMapping("/echo")
    public String echo() {
        return providerFeignClient.echo();
    }
}
