package N3;

import java.util.HashSet;
import java.util.List;
import q4.c;
import r4.C2676a;
import r4.C2677b;

/* JADX INFO: loaded from: classes.dex */
public class T {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2677b f5631c = C2677b.W();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R0 f5632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public P4.j f5633b = P4.j.g();

    public T(R0 r02) {
        this.f5632a = r02;
    }

    public static C2677b g(C2677b c2677b, C2676a c2676a) {
        return (C2677b) C2677b.Y(c2677b).x(c2676a).o();
    }

    public P4.b h(r4.e eVar) {
        final HashSet hashSet = new HashSet();
        for (q4.c cVar : eVar.V()) {
            hashSet.add(cVar.W().equals(c.EnumC0385c.VANILLA_PAYLOAD) ? cVar.Z().T() : cVar.U().T());
        }
        I0.a("Potential impressions to clear: " + hashSet.toString());
        return j().d(f5631c).j(new V4.e() { // from class: N3.M
            @Override // V4.e
            public final Object apply(Object obj) {
                return this.f5604a.n(hashSet, (C2677b) obj);
            }
        });
    }

    public final void i() {
        this.f5633b = P4.j.g();
    }

    public P4.j j() {
        return this.f5633b.x(this.f5632a.e(C2677b.Z()).f(new V4.d() { // from class: N3.K
            @Override // V4.d
            public final void accept(Object obj) {
                this.f5597a.p((C2677b) obj);
            }
        })).e(new V4.d() { // from class: N3.L
            @Override // V4.d
            public final void accept(Object obj) {
                this.f5601a.o((Throwable) obj);
            }
        });
    }

    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void p(C2677b c2677b) {
        this.f5633b = P4.j.n(c2677b);
    }

    public P4.s l(q4.c cVar) {
        return j().o(new V4.e() { // from class: N3.N
            @Override // V4.e
            public final Object apply(Object obj) {
                return ((C2677b) obj).V();
            }
        }).k(new V4.e() { // from class: N3.O
            @Override // V4.e
            public final Object apply(Object obj) {
                return P4.o.p((List) obj);
            }
        }).r(new V4.e() { // from class: N3.P
            @Override // V4.e
            public final Object apply(Object obj) {
                return ((C2676a) obj).U();
            }
        }).g(cVar.W().equals(c.EnumC0385c.VANILLA_PAYLOAD) ? cVar.Z().T() : cVar.U().T());
    }

    public final /* synthetic */ P4.d n(HashSet hashSet, C2677b c2677b) {
        I0.a("Existing impressions: " + c2677b.toString());
        C2677b.C0392b c0392bX = C2677b.X();
        for (C2676a c2676a : c2677b.V()) {
            if (!hashSet.contains(c2676a.U())) {
                c0392bX.x(c2676a);
            }
        }
        final C2677b c2677b2 = (C2677b) c0392bX.o();
        I0.a("New cleared impression list: " + c2677b2.toString());
        return this.f5632a.f(c2677b2).g(new V4.a() { // from class: N3.S
            @Override // V4.a
            public final void run() {
                this.f5628a.m(c2677b2);
            }
        });
    }

    public final /* synthetic */ void o(Throwable th) {
        i();
    }

    public final /* synthetic */ P4.d q(C2676a c2676a, C2677b c2677b) {
        final C2677b c2677bG = g(c2677b, c2676a);
        return this.f5632a.f(c2677bG).g(new V4.a() { // from class: N3.Q
            @Override // V4.a
            public final void run() {
                this.f5622a.p(c2677bG);
            }
        });
    }

    public P4.b r(final C2676a c2676a) {
        return j().d(f5631c).j(new V4.e() { // from class: N3.J
            @Override // V4.e
            public final Object apply(Object obj) {
                return this.f5593a.q(c2676a, (C2677b) obj);
            }
        });
    }
}
