package aa;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y2 f480d = y2.b0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2 f481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final da.a f482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public cc.j f483c = cc.j.g();

    public i3(q2 q2Var, da.a aVar) {
        this.f481a = q2Var;
        this.f482b = aVar;
    }

    public static /* synthetic */ boolean b(i3 i3Var, ea.m mVar, x2 x2Var) {
        return i3Var.o(x2Var, mVar) || x2Var.g0() < mVar.b();
    }

    public static /* synthetic */ boolean d(i3 i3Var, ea.m mVar, x2 x2Var) {
        return !i3Var.o(x2Var, mVar);
    }

    public static /* synthetic */ y2 f(y2 y2Var, ea.m mVar, x2 x2Var) {
        return (y2) y2.g0(y2Var).x(mVar.c(), l(x2Var)).n();
    }

    public static /* synthetic */ cc.d h(final i3 i3Var, final ea.m mVar, final y2 y2Var) {
        i3Var.getClass();
        return cc.o.i(y2Var.c0(mVar.c(), i3Var.q())).e(new ic.g() { // from class: aa.c3
            @Override // ic.g
            public final boolean test(Object obj) {
                return i3.d(this.f401a, mVar, (x2) obj);
            }
        }).l(cc.o.i(i3Var.q())).j(new ic.e() { // from class: aa.d3
            @Override // ic.e
            public final Object apply(Object obj) {
                return i3.f(y2Var, mVar, (x2) obj);
            }
        }).f(new ic.e() { // from class: aa.e3
            @Override // ic.e
            public final Object apply(Object obj) {
                i3 i3Var2 = this.f441a;
                y2 y2Var2 = (y2) obj;
                return i3Var2.f481a.d(y2Var2).d(new ic.a() { // from class: aa.h3
                    @Override // ic.a
                    public final void run() {
                        i3Var2.n(y2Var2);
                    }
                });
            }
        });
    }

    public static /* synthetic */ x2 i(i3 i3Var, ea.m mVar, y2 y2Var) {
        i3Var.getClass();
        return y2Var.c0(mVar.c(), i3Var.q());
    }

    public static x2 l(x2 x2Var) {
        return (x2) x2.i0(x2Var).x().z(x2Var.g0() + 1).n();
    }

    public final void j() {
        this.f483c = cc.j.g();
    }

    public final cc.j k() {
        return this.f483c.x(this.f481a.c(y2.h0()).f(new ic.d() { // from class: aa.a3
            @Override // ic.d
            public final void accept(Object obj) {
                this.f385a.n((y2) obj);
            }
        })).e(new ic.d() { // from class: aa.b3
            @Override // ic.d
            public final void accept(Object obj) {
                this.f388a.j();
            }
        });
    }

    public cc.b m(final ea.m mVar) {
        return k().d(f480d).j(new ic.e() { // from class: aa.z2
            @Override // ic.e
            public final Object apply(Object obj) {
                return i3.h(this.f604a, mVar, (y2) obj);
            }
        });
    }

    public final void n(y2 y2Var) {
        this.f483c = cc.j.n(y2Var);
    }

    public final boolean o(x2 x2Var, ea.m mVar) {
        return this.f482b.a() - x2Var.f0() > mVar.d();
    }

    public cc.s p(final ea.m mVar) {
        return k().x(cc.j.n(y2.b0())).o(new ic.e() { // from class: aa.f3
            @Override // ic.e
            public final Object apply(Object obj) {
                return i3.i(this.f460a, mVar, (y2) obj);
            }
        }).h(new ic.g() { // from class: aa.g3
            @Override // ic.g
            public final boolean test(Object obj) {
                return i3.b(this.f469a, mVar, (x2) obj);
            }
        }).m();
    }

    public final x2 q() {
        return (x2) x2.h0().z(0L).y(this.f482b.a()).n();
    }
}
