package com.wanghanbing.learn;

import org.apache.lucene.util.RamUsageEstimator;

import java.util.ArrayList;
import java.util.List;

public class TestJVM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println("hello jvm");
        System.out.println(RamUsageEstimator.sizeOf(new People()));
        System.out.println(RamUsageEstimator.humanSizeOf(new People()));
        System.out.println(RamUsageEstimator.shallowSizeOf(new People()));
    }
}

class People{
    int age = 20;
    String name = "Xiaoming";
}
class Person extends People{
    boolean married = false;
    long birthday = 128902093242L;
    char tag = 'c';
    double sallary = 1200.00d;
}