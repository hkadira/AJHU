package org.neosoft.com.JHU.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.neosoft.com.JHU.App;

/**
 * Created by Neyomal on 3/1/2017.
 */

public class LocalRepository{
    private static final String TAG = "Local repository";

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String AUTH_TOKEN = "false";

    private static LocalRepository sLocalRepo;
    private SharedPreferences mSharedPreferences;

    private Context context;

    private LocalRepository(){
        this.context= context;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.getsContext());
        //mSharedPreferences = context.getSharedPreferences("JBU",context.MODE_PRIVATE);
    }

    public void clearSession() {
        mSharedPreferences.edit().clear().apply();
    }

    public static LocalRepository getInstance() {
        if (sLocalRepo == null) {
            sLocalRepo = new LocalRepository();
        }
        return sLocalRepo;
    }

    //Save User
    public void saveUser(String userName, String password, boolean status) {
        mSharedPreferences.edit()
                .putBoolean(AUTH_TOKEN, status)
                .putString(USERNAME, userName)
                .putString(PASSWORD, password)
                .apply();
    }

    public boolean isAuthenticated() {
        //return !TextUtils.isEmpty(mSharedPreferences.getString(AUTH_TOKEN, ""));
        return mSharedPreferences.getBoolean(AUTH_TOKEN, false);
    }

    public boolean getAuthToken() {
        return mSharedPreferences.getBoolean(AUTH_TOKEN, false);
    }

}

