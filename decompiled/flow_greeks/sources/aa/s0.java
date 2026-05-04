package aa;

import hb.c;
import ib.b;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ib.b f572c = ib.b.e0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2 f573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cc.j f574b = cc.j.g();

    public s0(q2 q2Var) {
        this.f573a = q2Var;
    }

    public static /* synthetic */ cc.d b(final s0 s0Var, HashSet hashSet, ib.b bVar) {
        s0Var.getClass();
        h2.a("Existing impressions: " + bVar.toString());
        b.C0229b c0229bF0 = ib.b.f0();
        for (ib.a aVar : bVar.d0()) {
            if (!hashSet.contains(aVar.c0())) {
                c0229bF0.x(aVar);
            }
        }
        final ib.b bVar2 = (ib.b) c0229bF0.n();
        h2.a("New cleared impression list: " + bVar2.toString());
        return s0Var.f573a.d(bVar2).d(new ic.a() { // from class: aa.r0
            @Override // ic.a
            public final void run() {
                this.f567a.k(bVar2);
            }
        });
    }

    public static /* synthetic */ cc.d d(final s0 s0Var, ib.a aVar, ib.b bVar) {
        s0Var.getClass();
        final ib.b bVarG = g(bVar, aVar);
        return s0Var.f573a.d(bVarG).d(new ic.a() { // from class: aa.q0
            @Override // ic.a
            public final void run() {
                this.f561a.k(bVarG);
            }
        });
    }

    public static ib.b g(ib.b bVar, ib.a aVar) {
        return (ib.b) ib.b.g0(bVar).x(aVar).n();
    }

    public cc.b h(ib.e eVar) {
        final HashSet hashSet = new HashSet();
        for (hb.c cVar : eVar.d0()) {
            hashSet.add(cVar.e0().equals(c.EnumC0206c.VANILLA_PAYLOAD) ? cVar.h0().b0() : cVar.c0().b0());
        }
        h2.a("Potential impressions to clear: " + hashSet.toString());
        return j().d(f572c).j(new ic.e() { // from class: aa.m0
            @Override // ic.e
            public final Object apply(Object obj) {
                return s0.b(this.f514a, hashSet, (ib.b) obj);
            }
        });
    }

    public final void i() {
        this.f574b = cc.j.g();
    }

    public cc.j j() {
        return this.f574b.x(this.f573a.c(ib.b.h0()).f(new ic.d() { // from class: aa.k0
            @Override // ic.d
            public final void accept(Object obj) {
                this.f497a.k((ib.b) obj);
            }
        })).e(new ic.d() { // from class: aa.l0
            @Override // ic.d
            public final void accept(Object obj) {
                this.f506a.i();
            }
        });
    }

    public final void k(ib.b bVar) {
        this.f574b = cc.j.n(bVar);
    }

    public cc.s l(hb.c cVar) {
        return j().o(new ic.e() { // from class: aa.n0
            @Override // ic.e
            public final Object apply(Object obj) {
                return ((ib.b) obj).d0();
            }
        }).k(new ic.e() { // from class: aa.o0
            @Override // ic.e
            public final Object apply(Object obj) {
                return cc.o.h((List) obj);
            }
        }).j(new ic.e() { // from class: aa.p0
            @Override // ic.e
            public final Object apply(Object obj) {
                return ((ib.a) obj).c0();
            }
        }).d(cVar.e0().equals(c.EnumC0206c.VANILLA_PAYLOAD) ? cVar.h0().b0() : cVar.c0().b0());
    }

    public cc.b m(final ib.a aVar) {
        return j().d(f572c).j(new ic.e() { // from class: aa.j0
            @Override // ic.e
            public final Object apply(Object obj) {
                return s0.d(this.f486a, aVar, (ib.b) obj);
            }
        });
    }
}
