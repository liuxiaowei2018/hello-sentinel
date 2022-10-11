package com.open.sentinel.core;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 12:16
 * @Description
 */
@Component
public class CustomRequestOriginParser implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest request) {

        // 1.从 Header 中，获得请求来源
        String origin = request.getHeader("s-user");
        // 2.如果为空，给一个默认的
        if (StringUtils.isEmpty(origin)) {
            origin = "default";
        }
        return origin;
    }
}
