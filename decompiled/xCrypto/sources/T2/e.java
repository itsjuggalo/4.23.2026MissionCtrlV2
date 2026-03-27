package T2;

import K2.EnumC0368p;
import K2.S;
import K2.l0;
import Z1.m;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends T2.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final S.j f5106p = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final S f5107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final S.e f5108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public S.c f5109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public S f5110j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public S.c f5111k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public S f5112l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public EnumC0368p f5113m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public S.j f5114n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5115o;

    public class b extends T2.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public S f5117a;

        public b() {
        }

        @Override // T2.c, K2.S.e
        public void f(EnumC0368p enumC0368p, S.j jVar) {
            if (this.f5117a == e.this.f5112l) {
                m.u(e.this.f5115o, "there's pending lb while current lb has been out of READY");
                e.this.f5113m = enumC0368p;
                e.this.f5114n = jVar;
                if (enumC0368p == EnumC0368p.READY) {
                    e.this.q();
                    return;
                }
                return;
            }
            if (this.f5117a == e.this.f5110j) {
                e.this.f5115o = enumC0368p == EnumC0368p.READY;
                if (e.this.f5115o || e.this.f5112l == e.this.f5107g) {
                    e.this.f5108h.f(enumC0368p, jVar);
                } else {
                    e.this.q();
                }
            }
        }

        @Override // T2.c
        public S.e g() {
            return e.this.f5108h;
        }
    }

    public class c extends S.j {
        @Override // K2.S.j
        public S.f a(S.g gVar) {
            return S.f.g();
        }

        public String toString() {
            return "BUFFER_PICKER";
        }
    }

    public e(S.e eVar) {
        a aVar = new a();
        this.f5107g = aVar;
        this.f5110j = aVar;
        this.f5112l = aVar;
        this.f5108h = (S.e) m.o(eVar, "helper");
    }

    @Override // K2.S
    public void f() {
        this.f5112l.f();
        this.f5110j.f();
    }

    @Override // T2.b
    public S g() {
        S s4 = this.f5112l;
        return s4 == this.f5107g ? this.f5110j : s4;
    }

    public final void q() {
        this.f5108h.f(this.f5113m, this.f5114n);
        this.f5110j.f();
        this.f5110j = this.f5112l;
        this.f5109i = this.f5111k;
        this.f5112l = this.f5107g;
        this.f5111k = null;
    }

    public void r(S.c cVar) {
        m.o(cVar, "newBalancerFactory");
        if (cVar.equals(this.f5111k)) {
            return;
        }
        this.f5112l.f();
        this.f5112l = this.f5107g;
        this.f5111k = null;
        this.f5113m = EnumC0368p.CONNECTING;
        this.f5114n = f5106p;
        if (cVar.equals(this.f5109i)) {
            return;
        }
        b bVar = new b();
        S sA = cVar.a(bVar);
        bVar.f5117a = sA;
        this.f5112l = sA;
        this.f5111k = cVar;
        if (this.f5115o) {
            return;
        }
        q();
    }

    public class a extends S {
        public a() {
        }

        @Override // K2.S
        public void c(l0 l0Var) {
            e.this.f5108h.f(EnumC0368p.TRANSIENT_FAILURE, new S.d(S.f.f(l0Var)));
        }

        @Override // K2.S
        public void d(S.h hVar) {
            throw new IllegalStateException("GracefulSwitchLoadBalancer must switch to a load balancing policy before handling ResolvedAddresses");
        }

        @Override // K2.S
        public void f() {
        }
    }
}
