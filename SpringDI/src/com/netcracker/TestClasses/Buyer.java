package com.netcracker.TestClasses;

import java.util.concurrent.atomic.AtomicLong;

public class Buyer {

    private boolean vip;

    public Buyer() {
    }

    public void setVip(boolean vip) {
        this.vip = vip;
        System.out.println("Buyer.setVip");
        System.out.println("vip = " + vip);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "vip=" + vip +
                '}';
    }
}
