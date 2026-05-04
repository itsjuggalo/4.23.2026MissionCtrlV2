package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f5805a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f5806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f5807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f5808d;

    public static int a(Context context) {
        b(context);
        return f5808d;
    }

    public static void b(Context context) {
        synchronized (f5805a) {
            try {
                if (f5806b) {
                    return;
                }
                f5806b = true;
                try {
                    Bundle bundle = v5.d.a(context).c(context.getPackageName(), 128).metaData;
                    if (bundle == null) {
                        return;
                    }
                    f5807c = bundle.getString("com.google.app.id");
                    f5808d = bundle.getInt("com.google.android.gms.version");
                } catch (PackageManager.NameNotFoundException e10) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
