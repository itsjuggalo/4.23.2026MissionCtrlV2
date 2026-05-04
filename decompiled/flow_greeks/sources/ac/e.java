package ac;

import p6.n;
import rb.k1;
import rb.p;
import rb.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends ac.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final r0.j f613p = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r0 f614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r0.e f615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r0.c f616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r0 f617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public r0.c f618k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public r0 f619l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p f620m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public r0.j f621n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f622o;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends ac.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public r0 f624a;

        public b() {
        }

        @Override // ac.c, rb.r0.e
        public void f(p pVar, r0.j jVar) {
            if (this.f624a == e.this.f619l) {
                n.u(e.this.f622o, "there's pending lb while current lb has been out of READY");
                e.this.f620m = pVar;
                e.this.f621n = jVar;
                if (pVar == p.READY) {
                    e.this.q();
                    return;
                }
                return;
            }
            if (this.f624a == e.this.f617j) {
                e.this.f622o = pVar == p.READY;
                if (e.this.f622o || e.this.f619l == e.this.f614g) {
                    e.this.f615h.f(pVar, jVar);
                } else {
                    e.this.q();
                }
            }
        }

        @Override // ac.c
        public r0.e g() {
            return e.this.f615h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends r0.j {
        @Override // rb.r0.j
        public r0.f a(r0.g gVar) {
            return r0.f.g();
        }

        public String toString() {
            return "BUFFER_PICKER";
        }
    }

    public e(r0.e eVar) {
        a aVar = new a();
        this.f614g = aVar;
        this.f617j = aVar;
        this.f619l = aVar;
        this.f615h = (r0.e) n.o(eVar, "helper");
    }

    @Override // rb.r0
    public void f() {
        this.f619l.f();
        this.f617j.f();
    }

    @Override // ac.b
    public r0 g() {
        r0 r0Var = this.f619l;
        return r0Var == this.f614g ? this.f617j : r0Var;
    }

    public final void q() {
        this.f615h.f(this.f620m, this.f621n);
        this.f617j.f();
        this.f617j = this.f619l;
        this.f616i = this.f618k;
        this.f619l = this.f614g;
        this.f618k = null;
    }

    public void r(r0.c cVar) {
        n.o(cVar, "newBalancerFactory");
        if (cVar.equals(this.f618k)) {
            return;
        }
        this.f619l.f();
        this.f619l = this.f614g;
        this.f618k = null;
        this.f620m = p.CONNECTING;
        this.f621n = f613p;
        if (cVar.equals(this.f616i)) {
            return;
        }
        b bVar = new b();
        r0 r0VarA = cVar.a(bVar);
        bVar.f624a = r0VarA;
        this.f619l = r0VarA;
        this.f618k = cVar;
        if (this.f622o) {
            return;
        }
        q();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends r0 {
        public a() {
        }

        @Override // rb.r0
        public void c(k1 k1Var) {
            e.this.f615h.f(p.TRANSIENT_FAILURE, new r0.d(r0.f.f(k1Var)));
        }

        @Override // rb.r0
        public void d(r0.h hVar) {
            throw new IllegalStateException("GracefulSwitchLoadBalancer must switch to a load balancing policy before handling ResolvedAddresses");
        }

        @Override // rb.r0
        public void f() {
        }
    }
}
