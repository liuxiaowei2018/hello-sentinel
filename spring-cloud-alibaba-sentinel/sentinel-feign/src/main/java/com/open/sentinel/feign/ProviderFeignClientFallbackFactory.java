package com.open.sentinel.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 13:09
 * @Description
 */
@Component
public class ProviderFeignClientFallbackFactory implements FallbackFactory<ProviderFeignClientFallback> {

    @Override
    public ProviderFeignClientFallback create(Throwable throwable) {
        // 可以给 ProviderFeignClientFallback 提供具体的 throwable 异常
        return new ProviderFeignClientFallback(throwable);
    }
}
