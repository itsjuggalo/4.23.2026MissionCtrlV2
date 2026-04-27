package y1;

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
    public static D f15854e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f15856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x f15857c = new x(this, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15858d = 1;

    public D(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f15856b = scheduledExecutorService;
        this.f15855a = context.getApplicationContext();
    }

    public static synchronized D b(Context context) {
        try {
            if (f15854e == null) {
                zze.zza();
                f15854e = new D(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new H1.b("MessengerIpcClient"))));
            }
        } catch (Throwable th) {
            throw th;
        }
        return f15854e;
    }

    public final Task c(int i4, Bundle bundle) {
        return g(new z(f(), i4, bundle));
    }

    public final Task d(int i4, Bundle bundle) {
        return g(new C(f(), i4, bundle));
    }

    public final synchronized int f() {
        int i4;
        i4 = this.f15858d;
        this.f15858d = i4 + 1;
        return i4;
    }

    public final synchronized Task g(AbstractC1937A abstractC1937A) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(abstractC1937A.toString()));
            }
            if (!this.f15857c.g(abstractC1937A)) {
                x xVar = new x(this, null);
                this.f15857c = xVar;
                xVar.g(abstractC1937A);
            }
        } catch (Throwable th) {
            throw th;
        }
        return abstractC1937A.f15851b.getTask();
    }
}
