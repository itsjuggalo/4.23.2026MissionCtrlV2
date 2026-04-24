package p5;

import android.util.Log;
import p5.C2400d;
import p5.P;

/* JADX INFO: loaded from: classes2.dex */
public abstract class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.b f21660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2400d f21662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public V4.h f21663d;

    public static final class a implements C2400d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C2435i f21664a;

        public a(C2435i c2435i) {
            this.f21664a = c2435i;
        }

        public static final E5.E c(long j7, E5.p pVar) {
            if (E5.p.g(pVar.j())) {
                Log.e("PigeonProxyApiRegistrar", "Failed to remove Dart strong reference with identifier: " + j7);
            }
            return E5.E.f1657a;
        }

        @Override // p5.C2400d.b
        public void a(final long j7) {
            this.f21664a.e(j7, new Q5.k() { // from class: p5.O
                @Override // Q5.k
                public final Object invoke(Object obj) {
                    return P.a.c(j7, (E5.p) obj);
                }
            });
        }
    }

    public P(V4.b binaryMessenger) {
        kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
        this.f21660a = binaryMessenger;
        this.f21662c = C2400d.f21840l.a(new a(new C2435i(binaryMessenger)));
    }

    public abstract AbstractC2482p2 A();

    public abstract AbstractC2493r2 B();

    public abstract J2 C();

    public abstract N2 D();

    public abstract AbstractC2477o3 E();

    public abstract J3 F();

    public abstract L3 G();

    public N3 H() {
        return new N3(this);
    }

    public final void I() {
        C2435i.f21892b.d(this.f21660a, this.f21662c);
        K0.f21624b.f(this.f21660a, i());
        AbstractC2477o3.f21935b.y(this.f21660a, E());
        J2.f21617b.q(this.f21660a, C());
        AbstractC2437i1.f21895b.b(this.f21660a, p());
        J3.f21619b.c(this.f21660a, F());
        Q0.f21675b.b(this.f21660a, k());
        AbstractC2445j2.f21909b.g(this.f21660a, x());
        X0.f21762b.d(this.f21660a, m());
        N2.f21649b.c(this.f21660a, D());
        AbstractC2463m1.f21923b.c(this.f21660a, q());
        N0.f21646b.b(this.f21660a, j());
        R1.f21690b.g(this.f21660a, w());
        AbstractC2381a1.f21810b.b(this.f21660a, n());
        AbstractC2416f1.f21874b.d(this.f21660a, o());
        AbstractC2503t0.f21979b.b(this.f21660a, e());
        B0.f21548b.d(this.f21660a, g());
        J1.f21615b.c(this.f21660a, v());
        F1.f21589b.c(this.f21660a, u());
        B1.f21550b.e(this.f21660a, t());
        AbstractC2516v1.f22005b.f(this.f21660a, s());
        AbstractC2521w0.f22013b.b(this.f21660a, f());
    }

    public final void J() {
        C2435i.f21892b.d(this.f21660a, null);
        K0.f21624b.f(this.f21660a, null);
        AbstractC2477o3.f21935b.y(this.f21660a, null);
        J2.f21617b.q(this.f21660a, null);
        AbstractC2437i1.f21895b.b(this.f21660a, null);
        J3.f21619b.c(this.f21660a, null);
        Q0.f21675b.b(this.f21660a, null);
        AbstractC2445j2.f21909b.g(this.f21660a, null);
        X0.f21762b.d(this.f21660a, null);
        N2.f21649b.c(this.f21660a, null);
        AbstractC2463m1.f21923b.c(this.f21660a, null);
        N0.f21646b.b(this.f21660a, null);
        R1.f21690b.g(this.f21660a, null);
        AbstractC2381a1.f21810b.b(this.f21660a, null);
        AbstractC2416f1.f21874b.d(this.f21660a, null);
        AbstractC2503t0.f21979b.b(this.f21660a, null);
        B0.f21548b.d(this.f21660a, null);
        J1.f21615b.c(this.f21660a, null);
        F1.f21589b.c(this.f21660a, null);
        B1.f21550b.e(this.f21660a, null);
        AbstractC2516v1.f22005b.f(this.f21660a, null);
        AbstractC2521w0.f22013b.b(this.f21660a, null);
    }

    public final V4.b a() {
        return this.f21660a;
    }

    public final V4.h b() {
        if (this.f21663d == null) {
            this.f21663d = new N(this);
        }
        V4.h hVar = this.f21663d;
        kotlin.jvm.internal.r.c(hVar);
        return hVar;
    }

    public final boolean c() {
        return this.f21661b;
    }

    public final C2400d d() {
        return this.f21662c;
    }

    public abstract AbstractC2503t0 e();

    public abstract AbstractC2521w0 f();

    public abstract B0 g();

    public abstract D0 h();

    public abstract K0 i();

    public abstract N0 j();

    public abstract Q0 k();

    public abstract S0 l();

    public abstract X0 m();

    public abstract AbstractC2381a1 n();

    public abstract AbstractC2416f1 o();

    public abstract AbstractC2437i1 p();

    public abstract AbstractC2463m1 q();

    public C2475o1 r() {
        return new C2475o1(this);
    }

    public abstract AbstractC2516v1 s();

    public abstract B1 t();

    public abstract F1 u();

    public abstract J1 v();

    public abstract R1 w();

    public abstract AbstractC2445j2 x();

    public abstract AbstractC2458l2 y();

    public abstract AbstractC2470n2 z();
}
