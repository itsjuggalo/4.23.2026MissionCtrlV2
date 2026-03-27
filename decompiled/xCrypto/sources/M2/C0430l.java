package M2;

import K2.p0;
import M2.InterfaceC0426j;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: M2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0430l implements E0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f2457f = Logger.getLogger(C0430l.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f2458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final K2.p0 f2459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0426j.a f2460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0426j f2461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p0.d f2462e;

    public C0430l(InterfaceC0426j.a aVar, ScheduledExecutorService scheduledExecutorService, K2.p0 p0Var) {
        this.f2460c = aVar;
        this.f2458a = scheduledExecutorService;
        this.f2459b = p0Var;
    }

    public static /* synthetic */ void b(C0430l c0430l) {
        p0.d dVar = c0430l.f2462e;
        if (dVar != null && dVar.b()) {
            c0430l.f2462e.a();
        }
        c0430l.f2461d = null;
    }

    @Override // M2.E0
    public void a(Runnable runnable) {
        this.f2459b.e();
        if (this.f2461d == null) {
            this.f2461d = this.f2460c.get();
        }
        p0.d dVar = this.f2462e;
        if (dVar == null || !dVar.b()) {
            long jA = this.f2461d.a();
            this.f2462e = this.f2459b.c(runnable, jA, TimeUnit.NANOSECONDS, this.f2458a);
            f2457f.log(Level.FINE, "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(jA));
        }
    }

    @Override // M2.E0
    public void reset() {
        this.f2459b.e();
        this.f2459b.execute(new Runnable() { // from class: M2.k
            @Override // java.lang.Runnable
            public final void run() {
                C0430l.b(this.f2442a);
            }
        });
    }
}
