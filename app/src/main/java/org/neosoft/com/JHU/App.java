package org.neosoft.com.JHU;

import android.app.Application;
import android.content.Context;

/**
 * Created by Neyomal on 12/29/2016.
 */

public class App extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext=this;
        //Stetho.initializeWithDefaults(this);
    }

    public static  Context getsContext(){
        return sContext;
    }
}
