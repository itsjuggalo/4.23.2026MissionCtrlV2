package l5;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static d0 f15448e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f15450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x f15451c = new x(this, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15452d = 1;

    public d0(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f15450b = scheduledExecutorService;
        this.f15449a = context.getApplicationContext();
    }

    public static synchronized d0 b(Context context) {
        try {
            if (f15448e == null) {
                zze.zza();
                f15448e = new d0(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new u5.b("MessengerIpcClient"))));
            }
        } catch (Throwable th) {
            throw th;
        }
        return f15448e;
    }

    public final Task c(int i10, Bundle bundle) {
        return g(new z(f(), i10, bundle));
    }

    public final Task d(int i10, Bundle bundle) {
        return g(new c0(f(), i10, bundle));
    }

    public final synchronized int f() {
        int i10;
        i10 = this.f15452d;
        this.f15452d = i10 + 1;
        return i10;
    }

    public final synchronized Task g(a0 a0Var) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(a0Var.toString()));
            }
            if (!this.f15451c.g(a0Var)) {
                x xVar = new x(this, null);
                this.f15451c = xVar;
                xVar.g(a0Var);
            }
        } catch (Throwable th) {
            throw th;
        }
        return a0Var.f15432b.getTask();
    }
}
