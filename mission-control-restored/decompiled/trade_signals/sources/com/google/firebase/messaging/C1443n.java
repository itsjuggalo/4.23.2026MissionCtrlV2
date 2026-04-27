package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.InterfaceC2319c;
import w0.ExecutorC2893k;

/* JADX INFO: renamed from: com.google.firebase.messaging.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1443n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f15773c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static q0 f15774d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f15776b = new ExecutorC2893k();

    public C1443n(Context context) {
        this.f15775a = context;
    }

    public static AbstractC2328l e(Context context, Intent intent, boolean z7) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        q0 q0VarF = f(context, "com.google.firebase.MESSAGING_EVENT");
        if (!z7) {
            return q0VarF.d(intent).h(new ExecutorC2893k(), new InterfaceC2319c() { // from class: com.google.firebase.messaging.m
                @Override // l2.InterfaceC2319c
                public final Object a(AbstractC2328l abstractC2328l) {
                    return C1443n.g(abstractC2328l);
                }
            });
        }
        if (a0.b().e(context)) {
            l0.f(context, q0VarF, intent);
        } else {
            q0VarF.d(intent);
        }
        return AbstractC2331o.e(-1);
    }

    public static q0 f(Context context, String str) {
        q0 q0Var;
        synchronized (f15773c) {
            try {
                if (f15774d == null) {
                    f15774d = new q0(context, str);
                }
                q0Var = f15774d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return q0Var;
    }

    public static /* synthetic */ Integer g(AbstractC2328l abstractC2328l) {
        return -1;
    }

    public static /* synthetic */ Integer h(Context context, Intent intent) {
        return Integer.valueOf(a0.b().g(context, intent));
    }

    public static /* synthetic */ Integer i(AbstractC2328l abstractC2328l) {
        return Integer.valueOf(RCHTTPStatusCodes.FORBIDDEN);
    }

    public static /* synthetic */ AbstractC2328l j(Context context, Intent intent, boolean z7, AbstractC2328l abstractC2328l) {
        return (W1.l.e() && ((Integer) abstractC2328l.k()).intValue() == 402) ? e(context, intent, z7).h(new ExecutorC2893k(), new InterfaceC2319c() { // from class: com.google.firebase.messaging.l
            @Override // l2.InterfaceC2319c
            public final Object a(AbstractC2328l abstractC2328l2) {
                return C1443n.i(abstractC2328l2);
            }
        }) : abstractC2328l;
    }

    public AbstractC2328l k(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return l(this.f15775a, intent);
    }

    public AbstractC2328l l(final Context context, final Intent intent) {
        boolean z7 = W1.l.e() && context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z8 = (intent.getFlags() & 268435456) != 0;
        return (!z7 || z8) ? AbstractC2331o.c(this.f15776b, new Callable() { // from class: com.google.firebase.messaging.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C1443n.h(context, intent);
            }
        }).i(this.f15776b, new InterfaceC2319c() { // from class: com.google.firebase.messaging.k
            @Override // l2.InterfaceC2319c
            public final Object a(AbstractC2328l abstractC2328l) {
                return C1443n.j(context, intent, z8, abstractC2328l);
            }
        }) : e(context, intent, z8);
    }
}
