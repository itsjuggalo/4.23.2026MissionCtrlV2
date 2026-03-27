package N3;

/* JADX INFO: loaded from: classes.dex */
public class j1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Z0 f5693d = Z0.T();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R0 f5694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q3.a f5695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public P4.j f5696c = P4.j.g();

    public j1(R0 r02, Q3.a aVar) {
        this.f5694a = r02;
        this.f5695b = aVar;
    }

    public static Y0 l(Y0 y02) {
        return (Y0) Y0.a0(y02).x().z(y02.Y() + 1).o();
    }

    public static /* synthetic */ Z0 s(Z0 z02, R3.m mVar, Y0 y02) {
        return (Z0) Z0.Y(z02).x(mVar.c(), l(y02)).o();
    }

    public final void j() {
        this.f5696c = P4.j.g();
    }

    public final P4.j k() {
        return this.f5696c.x(this.f5694a.e(Z0.Z()).f(new V4.d() { // from class: N3.b1
            @Override // V4.d
            public final void accept(Object obj) {
                this.f5657a.t((Z0) obj);
            }
        })).e(new V4.d() { // from class: N3.c1
            @Override // V4.d
            public final void accept(Object obj) {
                this.f5662a.q((Throwable) obj);
            }
        });
    }

    public P4.b m(final R3.m mVar) {
        return k().d(f5693d).j(new V4.e() { // from class: N3.a1
            @Override // V4.e
            public final Object apply(Object obj) {
                return this.f5651a.v(mVar, (Z0) obj);
            }
        });
    }

    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final void t(Z0 z02) {
        this.f5696c = P4.j.n(z02);
    }

    public final boolean o(Y0 y02, R3.m mVar) {
        return this.f5695b.a() - y02.X() > mVar.d();
    }

    public P4.s p(final R3.m mVar) {
        return k().x(P4.j.n(Z0.T())).o(new V4.e() { // from class: N3.g1
            @Override // V4.e
            public final Object apply(Object obj) {
                return this.f5681a.w(mVar, (Z0) obj);
            }
        }).h(new V4.g() { // from class: N3.h1
            @Override // V4.g
            public final boolean test(Object obj) {
                return this.f5685a.x(mVar, (Y0) obj);
            }
        }).m();
    }

    public final /* synthetic */ void q(Throwable th) {
        j();
    }

    public final /* synthetic */ boolean r(R3.m mVar, Y0 y02) {
        return !o(y02, mVar);
    }

    public final /* synthetic */ P4.d u(final Z0 z02) {
        return this.f5694a.f(z02).g(new V4.a() { // from class: N3.i1
            @Override // V4.a
            public final void run() {
                this.f5689a.t(z02);
            }
        });
    }

    public final /* synthetic */ P4.d v(final R3.m mVar, final Z0 z02) {
        return P4.o.q(z02.U(mVar.c(), y())).i(new V4.g() { // from class: N3.d1
            @Override // V4.g
            public final boolean test(Object obj) {
                return this.f5670a.r(mVar, (Y0) obj);
            }
        }).t(P4.o.q(y())).r(new V4.e() { // from class: N3.e1
            @Override // V4.e
            public final Object apply(Object obj) {
                return j1.s(z02, mVar, (Y0) obj);
            }
        }).n(new V4.e() { // from class: N3.f1
            @Override // V4.e
            public final Object apply(Object obj) {
                return this.f5678a.u((Z0) obj);
            }
        });
    }

    public final /* synthetic */ Y0 w(R3.m mVar, Z0 z02) {
        return z02.U(mVar.c(), y());
    }

    public final /* synthetic */ boolean x(R3.m mVar, Y0 y02) {
        return o(y02, mVar) || y02.Y() < mVar.b();
    }

    public final Y0 y() {
        return (Y0) Y0.Z().z(0L).y(this.f5695b.a()).o();
    }
}
