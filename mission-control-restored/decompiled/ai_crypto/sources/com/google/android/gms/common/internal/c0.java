package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f11055a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f11056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f11057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f11058d;

    public static int a(Context context) {
        b(context);
        return f11058d;
    }

    public static void b(Context context) {
        synchronized (f11055a) {
            try {
                if (f11056b) {
                    return;
                }
                f11056b = true;
                try {
                    Bundle bundle = Y1.f.a(context).c(context.getPackageName(), 128).metaData;
                    if (bundle == null) {
                        return;
                    }
                    f11057c = bundle.getString("com.google.app.id");
                    f11058d = bundle.getInt("com.google.android.gms.version");
                } catch (PackageManager.NameNotFoundException e7) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
