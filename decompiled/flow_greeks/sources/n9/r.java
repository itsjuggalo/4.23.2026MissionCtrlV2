package n9;

import java.util.Date;
import n9.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f16967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g.d f16968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f16969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f16970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f16971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f16972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f16973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f16974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g.b f16975i;

    public r(g gVar, g.d dVar, long j10, double d10, long j11) {
        this.f16967a = gVar;
        this.f16968b = dVar;
        this.f16969c = j10;
        this.f16970d = d10;
        this.f16971e = j11;
        this.f16972f = j11;
        this.f16974h = new Date().getTime();
        e();
    }

    public static /* synthetic */ void a(r rVar, Runnable runnable) {
        rVar.getClass();
        rVar.f16974h = new Date().getTime();
        runnable.run();
    }

    public void b(final Runnable runnable) {
        c();
        long jD = this.f16973g + d();
        long jMax = Math.max(0L, new Date().getTime() - this.f16974h);
        long jMax2 = Math.max(0L, jD - jMax);
        if (this.f16973g > 0) {
            v.a(getClass().getSimpleName(), "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)", Long.valueOf(jMax2), Long.valueOf(this.f16973g), Long.valueOf(jD), Long.valueOf(jMax));
        }
        this.f16975i = this.f16967a.k(this.f16968b, jMax2, new Runnable() { // from class: n9.q
            @Override // java.lang.Runnable
            public final void run() {
                r.a(this.f16965a, runnable);
            }
        });
        long j10 = (long) (this.f16973g * this.f16970d);
        this.f16973g = j10;
        long j11 = this.f16969c;
        if (j10 < j11) {
            this.f16973g = j11;
        } else {
            long j12 = this.f16972f;
            if (j10 > j12) {
                this.f16973g = j12;
            }
        }
        this.f16972f = this.f16971e;
    }

    public void c() {
        g.b bVar = this.f16975i;
        if (bVar != null) {
            bVar.c();
            this.f16975i = null;
        }
    }

    public final long d() {
        return (long) ((Math.random() - 0.5d) * this.f16973g);
    }

    public void e() {
        this.f16973g = 0L;
    }

    public void f() {
        this.f16973g = this.f16972f;
    }

    public void g(long j10) {
        this.f16972f = j10;
    }

    public r(g gVar, g.d dVar) {
        this(gVar, dVar, 1000L, 1.5d, 60000L);
    }
}
