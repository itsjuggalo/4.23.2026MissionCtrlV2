package U3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;
import m2.C2233a;

/* JADX INFO: loaded from: classes.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f4903a = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f4904b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C2233a f4905c;

    public static void b(Context context) {
        if (f4905c == null) {
            C2233a c2233a = new C2233a(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f4905c = c2233a;
            c2233a.d(true);
        }
    }

    public static void c(Intent intent) {
        synchronized (f4904b) {
            try {
                if (f4905c != null && d(intent)) {
                    g(intent, false);
                    f4905c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean d(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    public static void f(Context context, k0 k0Var, final Intent intent) {
        synchronized (f4904b) {
            try {
                b(context);
                boolean zD = d(intent);
                g(intent, true);
                if (!zD) {
                    f4905c.a(f4903a);
                }
                k0Var.d(intent).addOnCompleteListener(new OnCompleteListener() { // from class: U3.e0
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        f0.c(intent);
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
        synchronized (f4904b) {
            try {
                b(context);
                boolean zD = d(intent);
                g(intent, true);
                ComponentName componentNameStartService = context.startService(intent);
                if (componentNameStartService == null) {
                    return null;
                }
                if (!zD) {
                    f4905c.a(f4903a);
                }
                return componentNameStartService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
