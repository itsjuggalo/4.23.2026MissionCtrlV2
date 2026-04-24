package U2;

import T2.t;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import s1.C0994k;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f3143c = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3142b = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3141a = new d(this);

    public final Task a(Runnable runnable) {
        return this.f3141a.a(new t(runnable, 1));
    }

    public final C0994k b(e eVar, long j4, Runnable runnable) {
        ScheduledFuture<?> scheduledFutureSchedule;
        if (this.f3143c.contains(eVar)) {
            j4 = 0;
        }
        System.currentTimeMillis();
        C0994k c0994k = new C0994k(this, runnable);
        d dVar = this.f3141a;
        E3.d dVar2 = new E3.d(c0994k, 10);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        synchronized (dVar) {
            scheduledFutureSchedule = !dVar.f3128b ? dVar.f3127a.schedule(dVar2, j4, timeUnit) : null;
        }
        c0994k.f9531c = scheduledFutureSchedule;
        this.f3142b.add(c0994k);
        return c0994k;
    }

    public final void c(Throwable th) {
        this.f3141a.f3127a.shutdownNow();
        new Handler(Looper.getMainLooper()).post(new E3.d(th, 9));
    }

    public final void d() {
        Thread threadCurrentThread = Thread.currentThread();
        d dVar = this.f3141a;
        Thread thread = dVar.f3129c;
        if (thread == threadCurrentThread) {
            return;
        }
        D1.b.n("We are running on the wrong thread. Expected to be on the AsyncQueue thread %s/%d but was %s/%d", thread.getName(), Long.valueOf(dVar.f3129c.getId()), threadCurrentThread.getName(), Long.valueOf(threadCurrentThread.getId()));
        throw null;
    }
}
