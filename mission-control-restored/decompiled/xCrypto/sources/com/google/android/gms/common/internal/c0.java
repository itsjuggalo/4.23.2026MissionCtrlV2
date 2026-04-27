package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f9872a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f9873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f9874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f9875d;

    public static int a(Context context) {
        b(context);
        return f9875d;
    }

    public static void b(Context context) {
        synchronized (f9872a) {
            try {
                if (f9873b) {
                    return;
                }
                f9873b = true;
                try {
                    Bundle bundle = I1.f.a(context).c(context.getPackageName(), UserMetadata.MAX_ROLLOUT_ASSIGNMENTS).metaData;
                    if (bundle == null) {
                        return;
                    }
                    f9874c = bundle.getString("com.google.app.id");
                    f9875d = bundle.getInt("com.google.android.gms.version");
                } catch (PackageManager.NameNotFoundException e4) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
