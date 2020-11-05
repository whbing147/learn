package com.wanghanbing.learn.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class StringFilter {

    public String filterEmpyt2Null(String source) {
        if (StringUtils.isEmpty(StringUtils.trim(source))) {
            return null;
        }
        return source;
    }
}