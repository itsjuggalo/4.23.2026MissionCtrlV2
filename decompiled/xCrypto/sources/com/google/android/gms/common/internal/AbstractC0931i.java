package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;
import z1.C1984b;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0931i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f9920a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f9921b = 9;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static u0 f9922c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static HandlerThread f9923d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Executor f9924e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f9925f = false;

    public static AbstractC0931i b(Context context) {
        synchronized (f9920a) {
            try {
                if (f9922c == null) {
                    f9922c = new u0(context.getApplicationContext(), f9925f ? c().getLooper() : context.getMainLooper(), f9924e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f9922c;
    }

    public static HandlerThread c() {
        synchronized (f9920a) {
            try {
                HandlerThread handlerThread = f9923d;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", f9921b);
                f9923d = handlerThread2;
                handlerThread2.start();
                return f9923d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str, Executor executor) {
        return e(new q0(componentName, 4225), serviceConnection, str, executor).n();
    }

    public void d(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        f(new q0(componentName, 4225), serviceConnection, str);
    }

    public abstract C1984b e(q0 q0Var, ServiceConnection serviceConnection, String str, Executor executor);

    public abstract void f(q0 q0Var, ServiceConnection serviceConnection, String str);

    public final void g(String str, String str2, int i4, ServiceConnection serviceConnection, String str3, boolean z4) {
        f(new q0(str, str2, 4225, z4), serviceConnection, str3);
    }
}
