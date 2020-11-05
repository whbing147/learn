package com.wanghanbing.learn;

import com.wanghanbing.learn.model.Student;
import com.wanghanbing.learn.model.Teach;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapperConvert {

    MapperConvert INSTANCE= Mappers.getMapper(MapperConvert.class);

    void convert(Student student, @MappingTarget Teach teach);
}