package A5;

import H2.m;
import r5.EnumC2600p;
import r5.S;
import r5.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends A5.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final S.j f269p = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final S f270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final S.e f271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public S.c f272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public S f273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public S.c f274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public S f275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public EnumC2600p f276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public S.j f277n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f278o;

    public class b extends A5.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public S f280a;

        public b() {
        }

        @Override // A5.c, r5.S.e
        public void f(EnumC2600p enumC2600p, S.j jVar) {
            if (this.f280a == e.this.f275l) {
                m.u(e.this.f278o, "there's pending lb while current lb has been out of READY");
                e.this.f276m = enumC2600p;
                e.this.f277n = jVar;
                if (enumC2600p == EnumC2600p.READY) {
                    e.this.q();
                    return;
                }
                return;
            }
            if (this.f280a == e.this.f273j) {
                e.this.f278o = enumC2600p == EnumC2600p.READY;
                if (e.this.f278o || e.this.f275l == e.this.f270g) {
                    e.this.f271h.f(enumC2600p, jVar);
                } else {
                    e.this.q();
                }
            }
        }

        @Override // A5.c
        public S.e g() {
            return e.this.f271h;
        }
    }

    public class c extends S.j {
        @Override // r5.S.j
        public S.f a(S.g gVar) {
            return S.f.g();
        }

        public String toString() {
            return "BUFFER_PICKER";
        }
    }

    public e(S.e eVar) {
        a aVar = new a();
        this.f270g = aVar;
        this.f273j = aVar;
        this.f275l = aVar;
        this.f271h = (S.e) m.o(eVar, "helper");
    }

    @Override // r5.S
    public void f() {
        this.f275l.f();
        this.f273j.f();
    }

    @Override // A5.b
    public S g() {
        S s7 = this.f275l;
        return s7 == this.f270g ? this.f273j : s7;
    }

    public final void q() {
        this.f271h.f(this.f276m, this.f277n);
        this.f273j.f();
        this.f273j = this.f275l;
        this.f272i = this.f274k;
        this.f275l = this.f270g;
        this.f274k = null;
    }

    public void r(S.c cVar) {
        m.o(cVar, "newBalancerFactory");
        if (cVar.equals(this.f274k)) {
            return;
        }
        this.f275l.f();
        this.f275l = this.f270g;
        this.f274k = null;
        this.f276m = EnumC2600p.CONNECTING;
        this.f277n = f269p;
        if (cVar.equals(this.f272i)) {
            return;
        }
        b bVar = new b();
        S sA = cVar.a(bVar);
        bVar.f280a = sA;
        this.f275l = sA;
        this.f274k = cVar;
        if (this.f278o) {
            return;
        }
        q();
    }

    public class a extends S {
        public a() {
        }

        @Override // r5.S
        public void c(l0 l0Var) {
            e.this.f271h.f(EnumC2600p.TRANSIENT_FAILURE, new S.d(S.f.f(l0Var)));
        }

        @Override // r5.S
        public void d(S.h hVar) {
            throw new IllegalStateException("GracefulSwitchLoadBalancer must switch to a load balancing policy before handling ResolvedAddresses");
        }

        @Override // r5.S
        public void f() {
        }
    }
}
