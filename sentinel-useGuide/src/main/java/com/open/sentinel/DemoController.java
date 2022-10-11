package com.open.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 12:12
 * @Description
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    /**
     * 【流量控制】
     *
     * @return java.lang.String
     */
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    /**
     * 【熔断降级】
     *
     * @return java.lang.String
     */
    @GetMapping("/sleep")
    public String sleep() throws InterruptedException {
        Thread.sleep(100L);
        return "sleep";
    }

    /**
     * 【热点参数限流】
     *
     * @param id
     * @return java.lang.String
     */
    @GetMapping("/product_info")
    @SentinelResource("demo_product_info_hot")
    public String productInfo(Integer id) {

        // 在方法上，添加 @SentinelResource 注解，自定义了 demo_product_info_hot 资源。
        return "商品编号：" + id;

        // ps. 在当前示例的热点规则下:
        // 针对每个 id 对应的 http://127.0.0.1:19450/demo/product_info?id=${id} 接口，在每 60 秒内，分别允许访问 10 次。
        // 针对 id = 1 的情况，作为特殊（例外）配置，在每 60 秒内，仅允许访问 1 次
    }


}
