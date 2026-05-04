package j8;

import h8.d;
import h8.h;
import j8.b0;
import j8.g;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import q8.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q8.d f13979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f13980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f13981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b0 f13982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f13983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f13984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f13985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f13986h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13988j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a7.g f13990l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l8.e f13991m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public m f13994p;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d.a f13987i = d.a.INFO;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f13989k = 10485760;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13992n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13993o = false;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements b0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScheduledExecutorService f13995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.a f13996b;

        public a(ScheduledExecutorService scheduledExecutorService, d.a aVar) {
            this.f13995a = scheduledExecutorService;
            this.f13996b = aVar;
        }

        @Override // j8.b0.a
        public void a(final String str) {
            ScheduledExecutorService scheduledExecutorService = this.f13995a;
            final d.a aVar = this.f13996b;
            scheduledExecutorService.execute(new Runnable() { // from class: j8.e
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a(str);
                }
            });
        }

        @Override // j8.b0.a
        public void onError(final String str) {
            ScheduledExecutorService scheduledExecutorService = this.f13995a;
            final d.a aVar = this.f13996b;
            scheduledExecutorService.execute(new Runnable() { // from class: j8.f
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.onError(str);
                }
            });
        }
    }

    public static h8.d G(final b0 b0Var, final ScheduledExecutorService scheduledExecutorService) {
        return new h8.d() { // from class: j8.d
            @Override // h8.d
            public final void a(boolean z10, d.a aVar) {
                b0Var.a(z10, new g.a(scheduledExecutorService, aVar));
            }
        };
    }

    public final synchronized void A() {
        this.f13994p = new f8.p(this.f13990l);
    }

    public boolean B() {
        return this.f13992n;
    }

    public boolean C() {
        return this.f13988j;
    }

    public h8.h D(h8.f fVar, h.a aVar) {
        return u().c(this, n(), fVar, aVar);
    }

    public void E() {
        if (this.f13993o) {
            F();
            this.f13993o = false;
        }
    }

    public final void F() {
        this.f13980b.a();
        this.f13983e.a();
    }

    public void b() {
        if (B()) {
            throw new e8.d("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    public final String c(String str) {
        return "Firebase/5/" + e8.h.i() + "/" + str;
    }

    public final void d() {
        com.google.android.gms.common.internal.s.l(this.f13982d, "You must register an appCheckTokenProvider before initializing Context.");
    }

    public final void e() {
        com.google.android.gms.common.internal.s.l(this.f13981c, "You must register an authTokenProvider before initializing Context.");
    }

    public final void f() {
        if (this.f13980b == null) {
            this.f13980b = u().a(this);
        }
    }

    public final void g() {
        if (this.f13979a == null) {
            this.f13979a = u().g(this, this.f13987i, this.f13985g);
        }
    }

    public final void h() {
        if (this.f13983e == null) {
            this.f13983e = this.f13994p.e(this);
        }
    }

    public final void i() {
        if (this.f13984f == null) {
            this.f13984f = "default";
        }
    }

    public final void j() {
        if (this.f13986h == null) {
            this.f13986h = c(u().f(this));
        }
    }

    public synchronized void k() {
        if (!this.f13992n) {
            this.f13992n = true;
            z();
        }
    }

    public b0 l() {
        return this.f13982d;
    }

    public b0 m() {
        return this.f13981c;
    }

    public h8.c n() {
        return new h8.c(r(), G(m(), p()), G(l(), p()), p(), C(), e8.h.i(), y(), this.f13990l.r().c(), w().getAbsolutePath());
    }

    public k o() {
        return this.f13980b;
    }

    public final ScheduledExecutorService p() {
        s sVarV = v();
        if (sVarV instanceof m8.c) {
            return ((m8.c) sVarV).d();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }

    public q8.c q(String str) {
        return new q8.c(this.f13979a, str);
    }

    public q8.d r() {
        return this.f13979a;
    }

    public long s() {
        return this.f13989k;
    }

    public l8.e t(String str) {
        l8.e eVar = this.f13991m;
        if (eVar != null) {
            return eVar;
        }
        if (!this.f13988j) {
            return new l8.d();
        }
        l8.e eVarD = this.f13994p.d(this, str);
        if (eVarD != null) {
            return eVarD;
        }
        throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
    }

    public final m u() {
        if (this.f13994p == null) {
            A();
        }
        return this.f13994p;
    }

    public s v() {
        return this.f13983e;
    }

    public File w() {
        return u().b();
    }

    public String x() {
        return this.f13984f;
    }

    public String y() {
        return this.f13986h;
    }

    public final void z() {
        g();
        u();
        j();
        f();
        h();
        i();
        e();
        d();
    }
}
