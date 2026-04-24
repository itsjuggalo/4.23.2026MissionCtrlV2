package com.google.android.gms.common.internal;

import P1.C0648b;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1198i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f11103a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f11104b = 9;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static u0 f11105c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static HandlerThread f11106d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Executor f11107e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f11108f = false;

    public static AbstractC1198i b(Context context) {
        synchronized (f11103a) {
            try {
                if (f11105c == null) {
                    f11105c = new u0(context.getApplicationContext(), f11108f ? c().getLooper() : context.getMainLooper(), f11107e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f11105c;
    }

    public static HandlerThread c() {
        synchronized (f11103a) {
            try {
                HandlerThread handlerThread = f11106d;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", f11104b);
                f11106d = handlerThread2;
                handlerThread2.start();
                return f11106d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str, Executor executor) {
        return e(new q0(componentName, 4225), serviceConnection, str, executor).E();
    }

    public void d(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        f(new q0(componentName, 4225), serviceConnection, str);
    }

    public abstract C0648b e(q0 q0Var, ServiceConnection serviceConnection, String str, Executor executor);

    public abstract void f(q0 q0Var, ServiceConnection serviceConnection, String str);

    public final void g(String str, String str2, int i7, ServiceConnection serviceConnection, String str3, boolean z7) {
        f(new q0(str, str2, 4225, z7), serviceConnection, str3);
    }
}
