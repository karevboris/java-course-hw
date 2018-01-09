package com.netcracker.TestClasses;

public class Factory {
    private static Factory factory = new Factory();
    private static MyFactory myFactory = new MyFactory();

    private Factory() {
    }

    public static Factory getFactory() {
        return factory;
    }

    public MyFactory getMyFactory() {
        return myFactory;
    }
}
