package com.wanghanbing.learn.gc;

public class ReferenceCountingGc {

    public Object instance = null;
    private static final int _1MB = 512 * 1024;
    private byte[] bytesSize = new byte[_1MB];

    public static void main(String[] args) {
        ReferenceCountingGc objectA = new ReferenceCountingGc();
        ReferenceCountingGc objectB = new ReferenceCountingGc();
        //ReferenceCountingGc objectC = new ReferenceCountingGc();
        //ReferenceCountingGc objectD = new ReferenceCountingGc();

        objectA.instance = objectB;
        objectB.instance = objectA;
        //objectC.instance = objectD;
        //objectD.instance = objectC;

        objectA = null;
        objectB = null;
        //objectB = null;
        //objectB = null;

        System.gc();
        System.gc();
        System.gc();
    }

}