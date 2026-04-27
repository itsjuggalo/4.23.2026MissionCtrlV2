package t5;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import r5.p0;
import t5.InterfaceC2681j;

/* JADX INFO: renamed from: t5.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2685l implements E0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f24008f = Logger.getLogger(C2685l.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f24009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r5.p0 f24010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2681j.a f24011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC2681j f24012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p0.d f24013e;

    public C2685l(InterfaceC2681j.a aVar, ScheduledExecutorService scheduledExecutorService, r5.p0 p0Var) {
        this.f24011c = aVar;
        this.f24009a = scheduledExecutorService;
        this.f24010b = p0Var;
    }

    @Override // t5.E0
    public void a(Runnable runnable) {
        this.f24010b.e();
        if (this.f24012d == null) {
            this.f24012d = this.f24011c.get();
        }
        p0.d dVar = this.f24013e;
        if (dVar == null || !dVar.b()) {
            long jA = this.f24012d.a();
            this.f24013e = this.f24010b.c(runnable, jA, TimeUnit.NANOSECONDS, this.f24009a);
            f24008f.log(Level.FINE, "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(jA));
        }
    }

    public final /* synthetic */ void c() {
        p0.d dVar = this.f24013e;
        if (dVar != null && dVar.b()) {
            this.f24013e.a();
        }
        this.f24012d = null;
    }

    @Override // t5.E0
    public void reset() {
        this.f24010b.e();
        this.f24010b.execute(new Runnable() { // from class: t5.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f23993a.c();
            }
        });
    }
}
