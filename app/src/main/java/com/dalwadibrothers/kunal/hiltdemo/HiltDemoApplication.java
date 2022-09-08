package com.dalwadibrothers.kunal.hiltdemo;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;


/*
Step 1:

1. Make application class and extend application
2. Also put that application class name in AndroidManifest.xml
3. Add @HiltAndroidApp annotation on Application class.

 */

@HiltAndroidApp
public class HiltDemoApplication extends Application {
}
