package com.google.firebase.appcheck.debug.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public class StorageHelper {
    static final String DEBUG_SECRET_KEY = "com.google.firebase.appcheck.debug.DEBUG_SECRET";
    static final String PREFS_TEMPLATE = "com.google.firebase.appcheck.debug.store.%s";
    private final SharedPreferences sharedPreferences;

    public StorageHelper(Context context, String str) {
        AbstractC0940s.k(context);
        AbstractC0940s.e(str);
        this.sharedPreferences = context.getSharedPreferences(String.format(PREFS_TEMPLATE, str), 0);
    }

    public String retrieveDebugSecret() {
        return this.sharedPreferences.getString(DEBUG_SECRET_KEY, null);
    }

    public void saveDebugSecret(String str) {
        this.sharedPreferences.edit().putString(DEBUG_SECRET_KEY, str).apply();
    }
}
