package com.google.android.gms.common.internal;

import Q1.C0790b;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1288h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f15005a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f15006b = 9;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static k0 f15007c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static HandlerThread f15008d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Executor f15009e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f15010f = false;

    public static AbstractC1288h a(Context context) {
        synchronized (f15005a) {
            try {
                if (f15007c == null) {
                    f15007c = new k0(context.getApplicationContext(), f15010f ? b().getLooper() : context.getMainLooper(), f15009e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f15007c;
    }

    public static HandlerThread b() {
        synchronized (f15005a) {
            try {
                HandlerThread handlerThread = f15008d;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", f15006b);
                f15008d = handlerThread2;
                handlerThread2.start();
                return f15008d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract C0790b c(g0 g0Var, ServiceConnection serviceConnection, String str, Executor executor);

    public abstract void d(g0 g0Var, ServiceConnection serviceConnection, String str);

    public final void e(String str, String str2, int i8, ServiceConnection serviceConnection, String str3, boolean z7) {
        d(new g0(str, str2, 4225, z7), serviceConnection, str3);
    }
}
