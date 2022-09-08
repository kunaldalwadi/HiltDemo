package com.dalwadibrothers.kunal.hiltdemo;

import javax.inject.Inject;

public class SomeInterfaceImpl2 implements SomeInterface{

    @Inject
    public SomeInterfaceImpl2() {
    }

    @Override
    public String randomFunction() {
        return "This is randomFunction from SomeInterfaceImpl2";
    }
}
