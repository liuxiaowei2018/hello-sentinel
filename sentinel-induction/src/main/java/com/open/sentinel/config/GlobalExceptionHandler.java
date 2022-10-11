package com.open.sentinel.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 11:11
 * @Description
 */
@ControllerAdvice(basePackages = "com.open.sentinel.test")
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BlockException.class)
    public String blockExceptionHandler(BlockException blockException) {
        return "请求过于频繁";
    }
}
