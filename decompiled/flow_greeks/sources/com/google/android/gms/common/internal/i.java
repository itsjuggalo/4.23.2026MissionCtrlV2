package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f5727a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f5728b = 9;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static o1 f5729c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static HandlerThread f5730d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Executor f5731e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f5732f = false;

    public static i a(Context context) {
        synchronized (f5727a) {
            try {
                if (f5729c == null) {
                    f5729c = new o1(context.getApplicationContext(), f5732f ? b().getLooper() : context.getMainLooper(), f5731e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f5729c;
    }

    public static HandlerThread b() {
        synchronized (f5727a) {
            try {
                HandlerThread handlerThread = f5730d;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", f5728b);
                f5730d = handlerThread2;
                handlerThread2.start();
                return f5730d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract m5.b c(l1 l1Var, ServiceConnection serviceConnection, String str, Executor executor);

    public final void d(String str, String str2, int i10, ServiceConnection serviceConnection, String str3, boolean z10) {
        e(new l1(str, str2, 4225, z10), serviceConnection, str3);
    }

    public abstract void e(l1 l1Var, ServiceConnection serviceConnection, String str);
}
