package com.wanghanbing.learn.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Teach {
    private  int  id;
    private String  name;
    private String school;
}