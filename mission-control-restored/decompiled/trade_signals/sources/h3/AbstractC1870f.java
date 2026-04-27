package h3;

import com.google.android.gms.common.internal.AbstractC1294n;
import d3.C1633i;
import f3.C1746c;
import f3.C1749f;
import f3.InterfaceC1747d;
import f3.InterfaceC1751h;
import h3.InterfaceC1857A;
import j3.C2211d;
import j3.InterfaceC2212e;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import k3.AbstractC2269c;
import o3.C2460c;
import o3.InterfaceC2461d;

/* JADX INFO: renamed from: h3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1870f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC2461d f18434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC1874j f18435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC1857A f18436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC1857A f18437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r f18438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f18440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f18441h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18443j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public G2.f f18445l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public InterfaceC2212e f18446m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public InterfaceC1876l f18449p;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public InterfaceC2461d.a f18442i = InterfaceC2461d.a.INFO;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f18444k = 10485760;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f18447n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f18448o = false;

    /* JADX INFO: renamed from: h3.f$a */
    public class a implements InterfaceC1857A.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScheduledExecutorService f18450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1747d.a f18451b;

        public a(ScheduledExecutorService scheduledExecutorService, InterfaceC1747d.a aVar) {
            this.f18450a = scheduledExecutorService;
            this.f18451b = aVar;
        }

        @Override // h3.InterfaceC1857A.a
        public void a(final String str) {
            ScheduledExecutorService scheduledExecutorService = this.f18450a;
            final InterfaceC1747d.a aVar = this.f18451b;
            scheduledExecutorService.execute(new Runnable() { // from class: h3.e
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a(str);
                }
            });
        }
    }

    public static /* synthetic */ void D(InterfaceC1857A interfaceC1857A, ScheduledExecutorService scheduledExecutorService, boolean z7, InterfaceC1747d.a aVar) {
        interfaceC1857A.a(z7, new a(scheduledExecutorService, aVar));
    }

    public static InterfaceC1747d H(final InterfaceC1857A interfaceC1857A, final ScheduledExecutorService scheduledExecutorService) {
        return new InterfaceC1747d() { // from class: h3.d
            @Override // f3.InterfaceC1747d
            public final void a(boolean z7, InterfaceC1747d.a aVar) {
                AbstractC1870f.D(interfaceC1857A, scheduledExecutorService, z7, aVar);
            }
        };
    }

    public final synchronized void A() {
        this.f18449p = new C1633i(this.f18445l);
    }

    public boolean B() {
        return this.f18447n;
    }

    public boolean C() {
        return this.f18443j;
    }

    public InterfaceC1751h E(C1749f c1749f, InterfaceC1751h.a aVar) {
        return u().d(this, n(), c1749f, aVar);
    }

    public void F() {
        if (this.f18448o) {
            G();
            this.f18448o = false;
        }
    }

    public final void G() {
        this.f18435b.a();
        this.f18438e.a();
    }

    public void b() {
        if (B()) {
            throw new c3.d("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    public final String c(String str) {
        return "Firebase/5/" + c3.h.g() + "/" + str;
    }

    public final void d() {
        AbstractC1294n.k(this.f18437d, "You must register an appCheckTokenProvider before initializing Context.");
    }

    public final void e() {
        AbstractC1294n.k(this.f18436c, "You must register an authTokenProvider before initializing Context.");
    }

    public final void f() {
        if (this.f18435b == null) {
            this.f18435b = u().f(this);
        }
    }

    public final void g() {
        if (this.f18434a == null) {
            this.f18434a = u().a(this, this.f18442i, this.f18440g);
        }
    }

    public final void h() {
        if (this.f18438e == null) {
            this.f18438e = this.f18449p.g(this);
        }
    }

    public final void i() {
        if (this.f18439f == null) {
            this.f18439f = "default";
        }
    }

    public final void j() {
        if (this.f18441h == null) {
            this.f18441h = c(u().e(this));
        }
    }

    public synchronized void k() {
        if (!this.f18447n) {
            this.f18447n = true;
            z();
        }
    }

    public InterfaceC1857A l() {
        return this.f18437d;
    }

    public InterfaceC1857A m() {
        return this.f18436c;
    }

    public C1746c n() {
        return new C1746c(r(), H(m(), p()), H(l(), p()), p(), C(), c3.h.g(), y(), this.f18445l.r().c(), w().getAbsolutePath());
    }

    public InterfaceC1874j o() {
        return this.f18435b;
    }

    public final ScheduledExecutorService p() {
        r rVarV = v();
        if (rVarV instanceof AbstractC2269c) {
            return ((AbstractC2269c) rVarV).d();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }

    public C2460c q(String str) {
        return new C2460c(this.f18434a, str);
    }

    public InterfaceC2461d r() {
        return this.f18434a;
    }

    public long s() {
        return this.f18444k;
    }

    public InterfaceC2212e t(String str) {
        InterfaceC2212e interfaceC2212e = this.f18446m;
        if (interfaceC2212e != null) {
            return interfaceC2212e;
        }
        if (!this.f18443j) {
            return new C2211d();
        }
        InterfaceC2212e interfaceC2212eB = this.f18449p.b(this, str);
        if (interfaceC2212eB != null) {
            return interfaceC2212eB;
        }
        throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
    }

    public final InterfaceC1876l u() {
        if (this.f18449p == null) {
            A();
        }
        return this.f18449p;
    }

    public r v() {
        return this.f18438e;
    }

    public File w() {
        return u().c();
    }

    public String x() {
        return this.f18439f;
    }

    public String y() {
        return this.f18441h;
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
