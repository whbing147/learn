package com.wanghanbing.learn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ClassLoaderTree {

    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTree.class.getClassLoader();
        int count = 0;
        while (loader != null) {
            System.out.println(count+ loader.toString());
            loader = loader.getParent();
            count++;
        }
        Deque<String> queue = new LinkedList<>();

    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        return judge(s, 0, s.length() -1);
    }

    public boolean judge(String s, int left, int right) {
        if (left == right) {
            return true;
        } else if (!Character.isLowerCase(s.charAt(left)) && !Character.isUpperCase(s.charAt(left))) {
            return judge(s, left+1, right);
        } else if(!Character.isLowerCase(s.charAt(right)) && !Character.isUpperCase(s.charAt(right))) {
            return judge(s, left, right-1);
        } else if(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
            return judge(s, left+1, right-1);
        } else {
            return false;
        }
    }
}