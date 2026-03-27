package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f14938a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f14939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f14940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f14941d;

    public static int a(Context context) {
        b(context);
        return f14941d;
    }

    public static void b(Context context) {
        synchronized (f14938a) {
            try {
                if (f14939b) {
                    return;
                }
                f14939b = true;
                try {
                    Bundle bundle = Y1.f.a(context).c(context.getPackageName(), 128).metaData;
                    if (bundle == null) {
                        return;
                    }
                    f14940c = bundle.getString("com.google.app.id");
                    f14941d = bundle.getInt("com.google.android.gms.version");
                } catch (PackageManager.NameNotFoundException e8) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e8);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
