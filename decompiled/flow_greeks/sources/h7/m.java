package h7;

import com.google.android.gms.tasks.OnFailureListener;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f11074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f11075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f11076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile ScheduledFuture f11077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f11078e = -1;

    public m(j jVar, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.f11074a = (j) com.google.android.gms.common.internal.s.k(jVar);
        this.f11075b = executor;
        this.f11076c = scheduledExecutorService;
    }

    public void c() {
        if (this.f11077d == null || this.f11077d.isDone()) {
            return;
        }
        this.f11077d.cancel(false);
    }

    public final long d() {
        if (this.f11078e == -1) {
            return 30L;
        }
        if (this.f11078e * 2 < 960) {
            return this.f11078e * 2;
        }
        return 960L;
    }

    public final void e() {
        this.f11074a.q().addOnFailureListener(this.f11075b, new OnFailureListener() { // from class: h7.l
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.f11073a.g();
            }
        });
    }

    public void f(long j10) {
        c();
        this.f11078e = -1L;
        this.f11077d = this.f11076c.schedule(new k(this), Math.max(0L, j10), TimeUnit.MILLISECONDS);
    }

    public final void g() {
        c();
        this.f11078e = d();
        this.f11077d = this.f11076c.schedule(new k(this), this.f11078e, TimeUnit.SECONDS);
    }
}
