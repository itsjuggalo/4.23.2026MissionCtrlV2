package U3;

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

/* JADX INFO: renamed from: U3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0700m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f4932c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static k0 f4933d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f4935b = new B0.k();

    public C0700m(Context context) {
        this.f4934a = context;
    }

    public static Task e(Context context, Intent intent, boolean z7) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        k0 k0VarF = f(context, "com.google.firebase.MESSAGING_EVENT");
        if (!z7) {
            return k0VarF.d(intent).continueWith(new B0.k(), new Continuation() { // from class: U3.l
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return C0700m.g(task);
                }
            });
        }
        if (V.b().e(context)) {
            f0.f(context, k0VarF, intent);
        } else {
            k0VarF.d(intent);
        }
        return Tasks.forResult(-1);
    }

    public static k0 f(Context context, String str) {
        k0 k0Var;
        synchronized (f4932c) {
            try {
                if (f4933d == null) {
                    f4933d = new k0(context, str);
                }
                k0Var = f4933d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return k0Var;
    }

    public static /* synthetic */ Integer g(Task task) {
        return -1;
    }

    public static /* synthetic */ Integer h(Context context, Intent intent) {
        return Integer.valueOf(V.b().g(context, intent));
    }

    public static /* synthetic */ Integer i(Task task) {
        return Integer.valueOf(RCHTTPStatusCodes.FORBIDDEN);
    }

    public static /* synthetic */ Task j(Context context, Intent intent, boolean z7, Task task) {
        return (W1.m.e() && ((Integer) task.getResult()).intValue() == 402) ? e(context, intent, z7).continueWith(new B0.k(), new Continuation() { // from class: U3.k
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return C0700m.i(task2);
            }
        }) : task;
    }

    public Task k(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return l(this.f4934a, intent);
    }

    public Task l(final Context context, final Intent intent) {
        boolean z7 = W1.m.e() && context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z8 = (intent.getFlags() & 268435456) != 0;
        return (!z7 || z8) ? Tasks.call(this.f4935b, new Callable() { // from class: U3.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C0700m.h(context, intent);
            }
        }).continueWithTask(this.f4935b, new Continuation() { // from class: U3.j
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return C0700m.j(context, intent, z8, task);
            }
        }) : e(context, intent, z8);
    }
}
