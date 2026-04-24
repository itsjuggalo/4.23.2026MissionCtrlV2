package P1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import d2.AbstractC1623e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import l2.AbstractC2328l;

/* JADX INFO: loaded from: classes.dex */
public final class D {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static D f6286e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f6288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x f6289c = new x(this, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6290d = 1;

    public D(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f6288b = scheduledExecutorService;
        this.f6287a = context.getApplicationContext();
    }

    public static synchronized D b(Context context) {
        try {
            if (f6286e == null) {
                AbstractC1623e.a();
                f6286e = new D(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new X1.a("MessengerIpcClient"))));
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6286e;
    }

    public final AbstractC2328l c(int i8, Bundle bundle) {
        return g(new z(f(), i8, bundle));
    }

    public final AbstractC2328l d(int i8, Bundle bundle) {
        return g(new C(f(), i8, bundle));
    }

    public final synchronized int f() {
        int i8;
        i8 = this.f6290d;
        this.f6290d = i8 + 1;
        return i8;
    }

    public final synchronized AbstractC2328l g(A a8) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(a8.toString()));
            }
            if (!this.f6289c.g(a8)) {
                x xVar = new x(this, null);
                this.f6289c = xVar;
                xVar.g(a8);
            }
        } catch (Throwable th) {
            throw th;
        }
        return a8.f6283b.a();
    }
}
