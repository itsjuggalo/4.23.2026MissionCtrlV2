package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.TimeUnit;
import k2.C2266a;
import l2.AbstractC2328l;
import l2.InterfaceC2322f;

/* JADX INFO: loaded from: classes.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f15769a = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f15770b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C2266a f15771c;

    public static void b(Context context) {
        if (f15771c == null) {
            C2266a c2266a = new C2266a(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f15771c = c2266a;
            c2266a.d(true);
        }
    }

    public static void c(Intent intent) {
        synchronized (f15770b) {
            try {
                if (f15771c != null && d(intent)) {
                    g(intent, false);
                    f15771c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean d(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    public static void f(Context context, q0 q0Var, final Intent intent) {
        synchronized (f15770b) {
            try {
                b(context);
                boolean zD = d(intent);
                g(intent, true);
                if (!zD) {
                    f15771c.a(f15769a);
                }
                q0Var.d(intent).c(new InterfaceC2322f() { // from class: com.google.firebase.messaging.k0
                    @Override // l2.InterfaceC2322f
                    public final void a(AbstractC2328l abstractC2328l) {
                        l0.c(intent);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void g(Intent intent, boolean z7) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z7);
    }

    public static ComponentName h(Context context, Intent intent) {
        synchronized (f15770b) {
            try {
                b(context);
                boolean zD = d(intent);
                g(intent, true);
                ComponentName componentNameStartService = context.startService(intent);
                if (componentNameStartService == null) {
                    return null;
                }
                if (!zD) {
                    f15771c.a(f15769a);
                }
                return componentNameStartService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
