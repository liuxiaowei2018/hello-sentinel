package com.open.sentinel.test;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 12:12
 * @Description
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    // 测试【流量控制】
    @GetMapping("/echo")
    public String echo() {
        return "echo";
    }
    @GetMapping("/test")
    public String test() {
        return "test";
    }

    // 测试【熔断降级】
    @GetMapping("/sleep")
    public String sleep() throws InterruptedException {
        Thread.sleep(100L);
        return "sleep";
    }

    // 测试【热点参数限流】
    @GetMapping("/product_info")
    @SentinelResource("demo_product_info_hot")
    public String productInfo(Integer id) {
        // 在方法上，添加 @SentinelResource 注解，自定义了 demo_product_info_hot 资源。
        return "商品编号：" + id;

        // ps. 在当前示例的热点规则下:
        // 针对每个 id 对应的 http://127.0.0.1:19450/demo/product_info?id=${id} 接口，在每 60 秒内，分别允许访问 10 次。
        // 针对 id = 1 的情况，作为特殊（例外）配置，在每 60 秒内，仅允许访问 1 次
    }

    // 测试「Sentinel 客户端 API」自定义调用
    @GetMapping("/entry_demo")
    public String entryDemo() {
        Entry entry = null;
        try {
            // 访问资源
            entry = SphU.entry("entry_demo");

            // ... 执行业务逻辑

            return "执行成功";
        } catch (BlockException ex) {
            return "被拒绝";
        } finally {
            // 释放资源
            if (entry != null) {
                entry.exit();
            }
        }
    }

    // 测试「Sentinel @SentinelResource 注解」
    @GetMapping("/annotations_demo")
    @SentinelResource(value = "annotations_demo_resource",
            blockHandler = "blockHandler",
            fallback = "fallback")
    public String annotationsDemo(@RequestParam(required = false) Integer id) throws InterruptedException {
        if (id == null) {
            throw new IllegalArgumentException("id 参数不允许为空");
        }
        // blockHandler 和 fallback 都配置的情况下，BlockException 异常分配给 blockHandler 处理，其它异常分配给 fallback 处理
        return "success...";
    }

    // BlockHandler 处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String blockHandler(Integer id, BlockException ex) {
        return "block：" + ex.getClass().getSimpleName();
    }

    // Fallback 处理函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public String fallback(Integer id, Throwable throwable) {
        return "fallback：" + throwable.getMessage();
    }

}
