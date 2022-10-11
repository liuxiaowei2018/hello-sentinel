package com.open.sentinel.core;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 12:15
 * @Description
 * 在 SentinelWebInterceptor 拦截器中，当请求满足配置的 Sentinel block 的条件时，Sentinel 会抛出 BlockException 异常。
 * 通过定义 BlockExceptionHandler 接口的实现类，可以实现对 BlockException 的异常处理。
 */
@Component
public class CustomBlockExceptionHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        // 抛出异常由全局异常管理
        throw e;
    }
}
