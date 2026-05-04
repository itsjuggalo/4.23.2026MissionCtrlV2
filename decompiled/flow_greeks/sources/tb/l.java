package tb;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import rb.o1;
import tb.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements d2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f21468f = Logger.getLogger(l.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f21469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rb.o1 f21470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.a f21471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f21472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o1.d f21473e;

    public l(j.a aVar, ScheduledExecutorService scheduledExecutorService, rb.o1 o1Var) {
        this.f21471c = aVar;
        this.f21469a = scheduledExecutorService;
        this.f21470b = o1Var;
    }

    public static /* synthetic */ void b(l lVar) {
        o1.d dVar = lVar.f21473e;
        if (dVar != null && dVar.b()) {
            lVar.f21473e.a();
        }
        lVar.f21472d = null;
    }

    @Override // tb.d2
    public void a(Runnable runnable) {
        this.f21470b.f();
        if (this.f21472d == null) {
            this.f21472d = this.f21471c.get();
        }
        o1.d dVar = this.f21473e;
        if (dVar == null || !dVar.b()) {
            long jA = this.f21472d.a();
            this.f21473e = this.f21470b.d(runnable, jA, TimeUnit.NANOSECONDS, this.f21469a);
            f21468f.log(Level.FINE, "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(jA));
        }
    }

    @Override // tb.d2
    public void reset() {
        this.f21470b.f();
        this.f21470b.execute(new Runnable() { // from class: tb.k
            @Override // java.lang.Runnable
            public final void run() {
                l.b(this.f21456a);
            }
        });
    }
}
