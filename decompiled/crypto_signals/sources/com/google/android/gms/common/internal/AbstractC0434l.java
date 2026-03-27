package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;
import u1.C1200b;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0434l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f5263a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static V f5264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static HandlerThread f5265c;

    public static V a(Context context) {
        synchronized (f5263a) {
            try {
                if (f5264b == null) {
                    f5264b = new V(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f5264b;
    }

    public abstract C1200b b(S s6, ServiceConnection serviceConnection, String str, Executor executor);

    public abstract void c(S s6, ServiceConnection serviceConnection);
}
