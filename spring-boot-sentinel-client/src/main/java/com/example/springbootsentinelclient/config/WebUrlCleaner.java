package com.example.springbootsentinelclient.config;

/**
 * @author xiegaobing
 * @description:
 * @date 2022/12/13 4:48 下午
 */

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;

import java.util.regex.Pattern;

/**
 * 一些接口采用了 @PathVariable 注解，每一个url都会被识别成资源，但是sentinel最多支持6000个，所以需要处理
 * 例如：/name/{id}可能会有/name/1、/name/2、/name/3，如果不处理就是三个资源，但是其实这是一个资源，所有在这里统一处理
 *
 * @Date 2022/8/3 16:31
 */
public class WebUrlCleaner implements UrlCleaner {

    /**
     * 正则匹配
     */
    private static String PATTERN_SENTINEL_TEST_NAME = "^/name/[0-9a-zA-Z]+$";
    private static String SENTINEL_RESOURCE_SENTINEL_TEST_NAME = "/name/*";

    private static Pattern pattern = Pattern.compile(PATTERN_SENTINEL_TEST_NAME);


    @Override
    public String clean(String originUrl) {
        if (pattern.matcher(originUrl).matches()) {
            return SENTINEL_RESOURCE_SENTINEL_TEST_NAME;
        } else {
            return originUrl;
        }
    }
}
