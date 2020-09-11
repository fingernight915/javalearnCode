package com.study.testcode.jvm;

/**
 * @author fingernight
 * @version 1.0
 * @date 2020/9/9 10:08 下午
 */
public class RefrenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /**
     * 占内存 以便在GC日志中能看清楚是否被回收过
     * com.study.testcode.jv.RefrenceCountingGC
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args){
        RefrenceCountingGC objA = new RefrenceCountingGC();
        RefrenceCountingGC objB = new RefrenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //垃圾回收
        System.gc();
    }
}
