package com.dalwadibrothers.kunal.hiltdemo;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ActivityScoped;

/*

https://developer.android.com/training/dependency-injection/hilt-android#generated-components

Scoping :

Scopes are like a tiered system in Hilt.
Scopes basically decide how long will that dependency be held by Hilt
In other words, how long will the dependency live(or be alive) in the graph.

@Singleton == Application level scope == it will be alive throughout the application and until the application itself dies.
@ActivityRetainedScope == ViewModel level scope == it will be alive beyond Activity but not as long as @Singleton.
@ActivityScoped ==  will keep the dependency alive as long as the Activity is alive.
@FragmentScoped == as long as the Fragment is alive.
@ViewScoped == As long as the View is alive.
@ServiceScoped
 */
@ActivityScoped
public class SomeClass {

    private static final String TAG = SomeClass.class.getSimpleName();
    private SomeOtherClass someOtherClass;
    private SomeInterface someInterface1;
    private SomeInterface someInterface2;

    //Constructor injection
    @Inject
    public SomeClass(SomeOtherClass someOtherClass, SomeInterfaceImpl1 someInterfaceImpl1, SomeInterfaceImpl2 someInterfaceImpl2)
    {
        this.someOtherClass = someOtherClass;
        this.someInterface1 = someInterfaceImpl1;
        this.someInterface2 = someInterfaceImpl2;
    }

    public String doSomething()
    {
        return "I did something";
    }

    public String doSomeOtherThing()
    {
        return someOtherClass.doSomeOtherThing();
    }

    public String doRandomThing1()
    {
        return someInterface1.randomFunction();
    }

    public String doRandomThing2()
    {
        return someInterface2.randomFunction();
    }

}
