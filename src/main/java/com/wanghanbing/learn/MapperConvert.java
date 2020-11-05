package com.wanghanbing.learn;

import com.wanghanbing.learn.model.Student;
import com.wanghanbing.learn.model.Teach;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,nullValueCheckStrategy=NullValueCheckStrategy.ALWAYS)
public interface MapperConvert {

    MapperConvert INSTANCE= Mappers.getMapper(MapperConvert.class);

    void convert(Student student, @MappingTarget Teach teach);

    Teach convertTo(Student student);
}