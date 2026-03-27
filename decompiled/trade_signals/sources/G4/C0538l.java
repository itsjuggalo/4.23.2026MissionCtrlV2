package G4;

import F4.n0;
import G4.InterfaceC0534j;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: G4.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0538l implements E0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f3035f = Logger.getLogger(C0538l.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f3036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final F4.n0 f3037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0534j.a f3038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0534j f3039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n0.d f3040e;

    public C0538l(InterfaceC0534j.a aVar, ScheduledExecutorService scheduledExecutorService, F4.n0 n0Var) {
        this.f3038c = aVar;
        this.f3036a = scheduledExecutorService;
        this.f3037b = n0Var;
    }

    @Override // G4.E0
    public void a(Runnable runnable) {
        this.f3037b.e();
        if (this.f3039d == null) {
            this.f3039d = this.f3038c.get();
        }
        n0.d dVar = this.f3040e;
        if (dVar == null || !dVar.b()) {
            long jA = this.f3039d.a();
            this.f3040e = this.f3037b.c(runnable, jA, TimeUnit.NANOSECONDS, this.f3036a);
            f3035f.log(Level.FINE, "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(jA));
        }
    }

    public final /* synthetic */ void c() {
        n0.d dVar = this.f3040e;
        if (dVar != null && dVar.b()) {
            this.f3040e.a();
        }
        this.f3039d = null;
    }

    @Override // G4.E0
    public void reset() {
        this.f3037b.e();
        this.f3037b.execute(new Runnable() { // from class: G4.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f3020a.c();
            }
        });
    }
}
