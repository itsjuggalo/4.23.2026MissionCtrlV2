package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f6375c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static n1 f6376d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f6378b = new h2.g();

    public n(Context context) {
        this.f6377a = context;
    }

    public static /* synthetic */ Task a(Context context, Intent intent, boolean z10, Task task) {
        return (t5.n.e() && ((Integer) task.getResult()).intValue() == 402) ? e(context, intent, z10).continueWith(new h2.g(), new Continuation() { // from class: com.google.firebase.messaging.l
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return Integer.valueOf(RCHTTPStatusCodes.FORBIDDEN);
            }
        }) : task;
    }

    public static /* synthetic */ Integer c(Task task) {
        return -1;
    }

    public static Task e(Context context, Intent intent, boolean z10) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        n1 n1VarF = f(context, "com.google.firebase.MESSAGING_EVENT");
        if (!z10) {
            return n1VarF.d(intent).continueWith(new h2.g(), new Continuation() { // from class: com.google.firebase.messaging.m
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return n.c(task);
                }
            });
        }
        if (x0.b().e(context)) {
            i1.e(context, n1VarF, intent);
        } else {
            n1VarF.d(intent);
        }
        return Tasks.forResult(-1);
    }

    public static n1 f(Context context, String str) {
        n1 n1Var;
        synchronized (f6375c) {
            try {
                if (f6376d == null) {
                    f6376d = new n1(context, str);
                }
                n1Var = f6376d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return n1Var;
    }

    public Task g(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return h(this.f6377a, intent);
    }

    public Task h(final Context context, final Intent intent) {
        boolean z10 = t5.n.e() && context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z11 = (intent.getFlags() & 268435456) != 0;
        return (!z10 || z11) ? Tasks.call(this.f6378b, new Callable() { // from class: com.google.firebase.messaging.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(x0.b().g(context, intent));
            }
        }).continueWithTask(this.f6378b, new Continuation() { // from class: com.google.firebase.messaging.k
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return n.a(context, intent, z11, task);
            }
        }) : e(context, intent, z11);
    }
}
