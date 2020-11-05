package com.wanghanbing.learn;

import com.wanghanbing.learn.filter.StringFilter;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = StringFilter.class)
public interface ExtendMapperConvert extends MapperConvert {
}