package com.dalwadibrothers.kunal.hiltdemo;

import javax.inject.Inject;

public class SomeInterfaceImpl1 implements SomeInterface{

    private static final String TAG = SomeInterfaceImpl1.class.getSimpleName();

    @Inject
    public SomeInterfaceImpl1() {
    }

    @Override
    public String randomFunction() {
       return "SomeInterfaceImpl class executed";
    }
}
