package com.open.sentinel.feign;

/**
 * @author liuxiaowei
 * @date 2022年10月11日 13:09
 * @Description
 */
public class ProviderFeignClientFallback implements ProviderFeignClient{

    private Throwable throwable;

    public ProviderFeignClientFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String echo() {
        return "fallback:" + throwable.getClass().getSimpleName();
    }
}
