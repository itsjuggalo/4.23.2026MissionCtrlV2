package W2;

import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f5408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f5409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f5410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile ScheduledFuture f5411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f5412e = -1;

    public h(e eVar, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.f5408a = (e) AbstractC1207s.k(eVar);
        this.f5409b = executor;
        this.f5410c = scheduledExecutorService;
    }

    public void c() {
        if (this.f5411d == null || this.f5411d.isDone()) {
            return;
        }
        this.f5411d.cancel(false);
    }

    public final long d() {
        if (this.f5412e == -1) {
            return 30L;
        }
        if (this.f5412e * 2 < 960) {
            return this.f5412e * 2;
        }
        return 960L;
    }

    public final /* synthetic */ void e(Exception exc) {
        h();
    }

    public final void f() {
        this.f5408a.f().addOnFailureListener(this.f5409b, new OnFailureListener() { // from class: W2.g
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f5407a.e(exc);
            }
        });
    }

    public void g(long j7) {
        c();
        this.f5412e = -1L;
        this.f5411d = this.f5410c.schedule(new f(this), Math.max(0L, j7), TimeUnit.MILLISECONDS);
    }

    public final void h() {
        c();
        this.f5412e = d();
        this.f5411d = this.f5410c.schedule(new f(this), this.f5412e, TimeUnit.SECONDS);
    }
}
