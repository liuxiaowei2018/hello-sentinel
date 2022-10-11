package com.open.sentinel.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 13:19
 * @Description
 */
@RestController
@RequestMapping("/rest")
public class TestRestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/echo")
    public String echo() {
        return restTemplate.getForObject("http://127.0.0.1:19450/demo/echo", String.class);
    }
}
