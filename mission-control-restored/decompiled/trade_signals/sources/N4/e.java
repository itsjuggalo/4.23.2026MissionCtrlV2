package N4;

import F4.EnumC0502p;
import F4.P;
import F4.j0;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends N4.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final P.j f5760p = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final P f5761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final P.e f5762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public P.c f5763i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public P f5764j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public P.c f5765k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public P f5766l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public EnumC0502p f5767m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public P.j f5768n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5769o;

    public class b extends N4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public P f5771a;

        public b() {
        }

        @Override // N4.c, F4.P.e
        public void f(EnumC0502p enumC0502p, P.j jVar) {
            if (this.f5771a == e.this.f5766l) {
                AbstractC2848n.u(e.this.f5769o, "there's pending lb while current lb has been out of READY");
                e.this.f5767m = enumC0502p;
                e.this.f5768n = jVar;
                if (enumC0502p != EnumC0502p.READY) {
                    return;
                }
            } else {
                if (this.f5771a != e.this.f5764j) {
                    return;
                }
                e.this.f5769o = enumC0502p == EnumC0502p.READY;
                if (e.this.f5769o || e.this.f5766l == e.this.f5761g) {
                    e.this.f5762h.f(enumC0502p, jVar);
                    return;
                }
            }
            e.this.q();
        }

        @Override // N4.c
        public P.e g() {
            return e.this.f5762h;
        }
    }

    public class c extends P.j {
        @Override // F4.P.j
        public P.f a(P.g gVar) {
            return P.f.g();
        }

        public String toString() {
            return "BUFFER_PICKER";
        }
    }

    public e(P.e eVar) {
        a aVar = new a();
        this.f5761g = aVar;
        this.f5764j = aVar;
        this.f5766l = aVar;
        this.f5762h = (P.e) AbstractC2848n.o(eVar, "helper");
    }

    @Override // F4.P
    public void f() {
        this.f5766l.f();
        this.f5764j.f();
    }

    @Override // N4.b
    public P g() {
        P p8 = this.f5766l;
        return p8 == this.f5761g ? this.f5764j : p8;
    }

    public final void q() {
        this.f5762h.f(this.f5767m, this.f5768n);
        this.f5764j.f();
        this.f5764j = this.f5766l;
        this.f5763i = this.f5765k;
        this.f5766l = this.f5761g;
        this.f5765k = null;
    }

    public void r(P.c cVar) {
        AbstractC2848n.o(cVar, "newBalancerFactory");
        if (cVar.equals(this.f5765k)) {
            return;
        }
        this.f5766l.f();
        this.f5766l = this.f5761g;
        this.f5765k = null;
        this.f5767m = EnumC0502p.CONNECTING;
        this.f5768n = f5760p;
        if (cVar.equals(this.f5763i)) {
            return;
        }
        b bVar = new b();
        P pA = cVar.a(bVar);
        bVar.f5771a = pA;
        this.f5766l = pA;
        this.f5765k = cVar;
        if (this.f5769o) {
            return;
        }
        q();
    }

    public class a extends P {
        public a() {
        }

        @Override // F4.P
        public void c(j0 j0Var) {
            e.this.f5762h.f(EnumC0502p.TRANSIENT_FAILURE, new P.d(P.f.f(j0Var)));
        }

        @Override // F4.P
        public void d(P.h hVar) {
            throw new IllegalStateException("GracefulSwitchLoadBalancer must switch to a load balancing policy before handling ResolvedAddresses");
        }

        @Override // F4.P
        public void f() {
        }
    }
}
