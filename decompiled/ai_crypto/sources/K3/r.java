package K3;

import K3.C0617g;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0617g f3455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0617g.d f3456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f3458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f3462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public C0617g.b f3463i;

    public r(C0617g c0617g, C0617g.d dVar, long j7, double d7, long j8) {
        this.f3455a = c0617g;
        this.f3456b = dVar;
        this.f3457c = j7;
        this.f3458d = d7;
        this.f3459e = j8;
        this.f3460f = j8;
        this.f3462h = new Date().getTime();
        f();
    }

    public void b(final Runnable runnable) {
        c();
        long jD = this.f3461g + d();
        long jMax = Math.max(0L, new Date().getTime() - this.f3462h);
        long jMax2 = Math.max(0L, jD - jMax);
        if (this.f3461g > 0) {
            x.a(getClass().getSimpleName(), "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)", Long.valueOf(jMax2), Long.valueOf(this.f3461g), Long.valueOf(jD), Long.valueOf(jMax));
        }
        this.f3463i = this.f3455a.k(this.f3456b, jMax2, new Runnable() { // from class: K3.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f3453a.e(runnable);
            }
        });
        long j7 = (long) (this.f3461g * this.f3458d);
        this.f3461g = j7;
        long j8 = this.f3457c;
        if (j7 < j8) {
            this.f3461g = j8;
        } else {
            long j9 = this.f3460f;
            if (j7 > j9) {
                this.f3461g = j9;
            }
        }
        this.f3460f = this.f3459e;
    }

    public void c() {
        C0617g.b bVar = this.f3463i;
        if (bVar != null) {
            bVar.c();
            this.f3463i = null;
        }
    }

    public final long d() {
        return (long) ((Math.random() - 0.5d) * this.f3461g);
    }

    public final /* synthetic */ void e(Runnable runnable) {
        this.f3462h = new Date().getTime();
        runnable.run();
    }

    public void f() {
        this.f3461g = 0L;
    }

    public void g() {
        this.f3461g = this.f3460f;
    }

    public void h(long j7) {
        this.f3460f = j7;
    }

    public r(C0617g c0617g, C0617g.d dVar) {
        this(c0617g, dVar, 1000L, 1.5d, 60000L);
    }
}
