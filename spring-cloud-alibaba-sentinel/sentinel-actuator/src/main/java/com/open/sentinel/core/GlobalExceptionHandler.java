package com.open.sentinel.core;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 12:17
 * @Description
 */
@Component
@ControllerAdvice(basePackages = "com.open.sentinel")
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BlockException.class)
    public JSONObject blockExceptionHandler(BlockException blockException) {
        return new JSONObject().fluentPut("code", 1024)
                .fluentPut("msg", "请求被拦截，拦截类型为 " + blockException.getClass().getSimpleName());
    }

}

