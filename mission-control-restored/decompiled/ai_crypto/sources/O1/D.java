package O1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class D {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static D f4052e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f4054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x f4055c = new x(this, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4056d = 1;

    public D(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f4054b = scheduledExecutorService;
        this.f4053a = context.getApplicationContext();
    }

    public static synchronized D b(Context context) {
        try {
            if (f4052e == null) {
                zze.zza();
                f4052e = new D(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new X1.b("MessengerIpcClient"))));
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4052e;
    }

    public final Task c(int i7, Bundle bundle) {
        return g(new z(f(), i7, bundle));
    }

    public final Task d(int i7, Bundle bundle) {
        return g(new C(f(), i7, bundle));
    }

    public final synchronized int f() {
        int i7;
        i7 = this.f4056d;
        this.f4056d = i7 + 1;
        return i7;
    }

    public final synchronized Task g(A a7) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(a7.toString()));
            }
            if (!this.f4055c.g(a7)) {
                x xVar = new x(this, null);
                this.f4055c = xVar;
                xVar.g(a7);
            }
        } catch (Throwable th) {
            throw th;
        }
        return a7.f4049b.getTask();
    }
}
