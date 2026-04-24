package h3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k3.AbstractC2279m;
import k3.InterfaceC2275i;
import m3.C2374a;
import p3.C2548b;
import p3.C2553g;
import p3.C2559m;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: h3.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1862F {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final InterfaceC2275i f18403d = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1866b f18404a = C1866b.F();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f18405b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f18406c = -1L;

    /* JADX INFO: renamed from: h3.F$a */
    public class a implements InterfaceC2275i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f18407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f18408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ C1875k f18409d;

        public a(boolean z7, List list, C1875k c1875k) {
            this.f18407b = z7;
            this.f18408c = list;
            this.f18409d = c1875k;
        }

        @Override // k3.InterfaceC2275i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(C1858B c1858b) {
            return (c1858b.f() || this.f18407b) && !this.f18408c.contains(Long.valueOf(c1858b.d())) && (c1858b.c().M(this.f18409d) || this.f18409d.M(c1858b.c()));
        }
    }

    /* JADX INFO: renamed from: h3.F$b */
    public class b implements InterfaceC2275i {
        @Override // k3.InterfaceC2275i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(C1858B c1858b) {
            return c1858b.f();
        }
    }

    public static C1866b j(List list, InterfaceC2275i interfaceC2275i, C1875k c1875k) {
        C1875k c1875kR;
        InterfaceC2560n interfaceC2560nB;
        C1875k c1875kR2;
        C1866b c1866bF = C1866b.F();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1858B c1858b = (C1858B) it.next();
            if (interfaceC2275i.a(c1858b)) {
                C1875k c1875kC = c1858b.c();
                if (!c1858b.e()) {
                    if (c1875k.M(c1875kC)) {
                        c1875kR2 = C1875k.R(c1875k, c1875kC);
                    } else if (c1875kC.M(c1875k)) {
                        C1875k c1875kR3 = C1875k.R(c1875kC, c1875k);
                        if (c1875kR3.isEmpty()) {
                            c1875kR2 = C1875k.O();
                        } else {
                            interfaceC2560nB = c1858b.a().K(c1875kR3);
                            if (interfaceC2560nB != null) {
                                c1875kR = C1875k.O();
                                c1866bF = c1866bF.a(c1875kR, interfaceC2560nB);
                            }
                        }
                    }
                    c1866bF = c1866bF.e(c1875kR2, c1858b.a());
                } else if (c1875k.M(c1875kC)) {
                    c1875kR = C1875k.R(c1875k, c1875kC);
                    interfaceC2560nB = c1858b.b();
                    c1866bF = c1866bF.a(c1875kR, interfaceC2560nB);
                } else if (c1875kC.M(c1875k)) {
                    c1866bF = c1866bF.a(C1875k.O(), c1858b.b().s(C1875k.R(c1875kC, c1875k)));
                }
            }
        }
        return c1866bF;
    }

    public void a(C1875k c1875k, C1866b c1866b, Long l8) {
        AbstractC2279m.f(l8.longValue() > this.f18406c.longValue());
        this.f18405b.add(new C1858B(l8.longValue(), c1875k, c1866b));
        this.f18404a = this.f18404a.e(c1875k, c1866b);
        this.f18406c = l8;
    }

    public void b(C1875k c1875k, InterfaceC2560n interfaceC2560n, Long l8, boolean z7) {
        AbstractC2279m.f(l8.longValue() > this.f18406c.longValue());
        this.f18405b.add(new C1858B(l8.longValue(), c1875k, interfaceC2560n, z7));
        if (z7) {
            this.f18404a = this.f18404a.a(c1875k, interfaceC2560n);
        }
        this.f18406c = l8;
    }

    public InterfaceC2560n c(C1875k c1875k, C2548b c2548b, C2374a c2374a) {
        C1875k c1875kK = c1875k.K(c2548b);
        InterfaceC2560n interfaceC2560nK = this.f18404a.K(c1875kK);
        if (interfaceC2560nK != null) {
            return interfaceC2560nK;
        }
        if (c2374a.c(c2548b)) {
            return this.f18404a.n(c1875kK).f(c2374a.b().z(c2548b));
        }
        return null;
    }

    public InterfaceC2560n d(C1875k c1875k, InterfaceC2560n interfaceC2560n, List list, boolean z7) {
        if (list.isEmpty() && !z7) {
            InterfaceC2560n interfaceC2560nK = this.f18404a.K(c1875k);
            if (interfaceC2560nK != null) {
                return interfaceC2560nK;
            }
            C1866b c1866bN = this.f18404a.n(c1875k);
            if (c1866bN.isEmpty()) {
                return interfaceC2560n;
            }
            if (interfaceC2560n == null && !c1866bN.M(C1875k.O())) {
                return null;
            }
            if (interfaceC2560n == null) {
                interfaceC2560n = C2553g.M();
            }
            return c1866bN.f(interfaceC2560n);
        }
        C1866b c1866bN2 = this.f18404a.n(c1875k);
        if (!z7 && c1866bN2.isEmpty()) {
            return interfaceC2560n;
        }
        if (!z7 && interfaceC2560n == null && !c1866bN2.M(C1875k.O())) {
            return null;
        }
        C1866b c1866bJ = j(this.f18405b, new a(z7, list, c1875k), c1875k);
        if (interfaceC2560n == null) {
            interfaceC2560n = C2553g.M();
        }
        return c1866bJ.f(interfaceC2560n);
    }

    public InterfaceC2560n e(C1875k c1875k, InterfaceC2560n interfaceC2560n) {
        InterfaceC2560n interfaceC2560nM = C2553g.M();
        InterfaceC2560n<C2559m> interfaceC2560nK = this.f18404a.K(c1875k);
        if (interfaceC2560nK != null) {
            if (!interfaceC2560nK.x()) {
                for (C2559m c2559m : interfaceC2560nK) {
                    interfaceC2560nM = interfaceC2560nM.A(c2559m.c(), c2559m.d());
                }
            }
            return interfaceC2560nM;
        }
        C1866b c1866bN = this.f18404a.n(c1875k);
        Iterator it = interfaceC2560n.iterator();
        while (it.hasNext()) {
            C2559m c2559m2 = (C2559m) it.next();
            interfaceC2560nM = interfaceC2560nM.A(c2559m2.c(), c1866bN.n(new C1875k(c2559m2.c())).f(c2559m2.d()));
        }
        for (C2559m c2559m3 : c1866bN.J()) {
            interfaceC2560nM = interfaceC2560nM.A(c2559m3.c(), c2559m3.d());
        }
        return interfaceC2560nM;
    }

    public InterfaceC2560n f(C1875k c1875k, C1875k c1875k2, InterfaceC2560n interfaceC2560n, InterfaceC2560n interfaceC2560n2) {
        AbstractC2279m.g((interfaceC2560n == null && interfaceC2560n2 == null) ? false : true, "Either existingEventSnap or existingServerSnap must exist");
        C1875k c1875kJ = c1875k.J(c1875k2);
        if (this.f18404a.M(c1875kJ)) {
            return null;
        }
        C1866b c1866bN = this.f18404a.n(c1875kJ);
        return c1866bN.isEmpty() ? interfaceC2560n2.s(c1875k2) : c1866bN.f(interfaceC2560n2.s(c1875k2));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p3.C2559m g(h3.C1875k r3, p3.InterfaceC2560n r4, p3.C2559m r5, boolean r6, p3.AbstractC2554h r7) {
        /*
            r2 = this;
            h3.b r0 = r2.f18404a
            h3.b r3 = r0.n(r3)
            h3.k r0 = h3.C1875k.O()
            p3.n r0 = r3.K(r0)
            r1 = 0
            if (r0 == 0) goto L12
            goto L18
        L12:
            if (r4 == 0) goto L38
            p3.n r0 = r3.f(r4)
        L18:
            java.util.Iterator r3 = r0.iterator()
        L1c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L38
            java.lang.Object r4 = r3.next()
            p3.m r4 = (p3.C2559m) r4
            int r0 = r7.a(r4, r5, r6)
            if (r0 <= 0) goto L1c
            if (r1 == 0) goto L36
            int r0 = r7.a(r4, r1, r6)
            if (r0 >= 0) goto L1c
        L36:
            r1 = r4
            goto L1c
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.C1862F.g(h3.k, p3.n, p3.m, boolean, p3.h):p3.m");
    }

    public C1863G h(C1875k c1875k) {
        return new C1863G(c1875k, this);
    }

    public C1858B i(long j8) {
        for (C1858B c1858b : this.f18405b) {
            if (c1858b.d() == j8) {
                return c1858b;
            }
        }
        return null;
    }

    public List k() {
        ArrayList arrayList = new ArrayList(this.f18405b);
        this.f18404a = C1866b.F();
        this.f18405b = new ArrayList();
        return arrayList;
    }

    public final boolean l(C1858B c1858b, C1875k c1875k) {
        if (c1858b.e()) {
            return c1858b.c().M(c1875k);
        }
        Iterator it = c1858b.a().iterator();
        while (it.hasNext()) {
            if (c1858b.c().J((C1875k) ((Map.Entry) it.next()).getKey()).M(c1875k)) {
                return true;
            }
        }
        return false;
    }

    public boolean m(long j8) {
        C1858B c1858b;
        Iterator it = this.f18405b.iterator();
        int i8 = 0;
        while (true) {
            if (!it.hasNext()) {
                c1858b = null;
                break;
            }
            c1858b = (C1858B) it.next();
            if (c1858b.d() == j8) {
                break;
            }
            i8++;
        }
        AbstractC2279m.g(c1858b != null, "removeWrite called with nonexistent writeId");
        this.f18405b.remove(c1858b);
        boolean zF = c1858b.f();
        boolean z7 = false;
        for (int size = this.f18405b.size() - 1; zF && size >= 0; size--) {
            C1858B c1858b2 = (C1858B) this.f18405b.get(size);
            if (c1858b2.f()) {
                if (size >= i8 && l(c1858b2, c1858b.c())) {
                    zF = false;
                } else if (c1858b.c().M(c1858b2.c())) {
                    z7 = true;
                }
            }
        }
        if (!zF) {
            return false;
        }
        if (z7) {
            n();
            return true;
        }
        if (c1858b.e()) {
            this.f18404a = this.f18404a.N(c1858b.c());
        } else {
            Iterator it2 = c1858b.a().iterator();
            while (it2.hasNext()) {
                this.f18404a = this.f18404a.N(c1858b.c().J((C1875k) ((Map.Entry) it2.next()).getKey()));
            }
        }
        return true;
    }

    public final void n() {
        long jD;
        this.f18404a = j(this.f18405b, f18403d, C1875k.O());
        if (this.f18405b.size() > 0) {
            jD = ((C1858B) this.f18405b.get(r0.size() - 1)).d();
        } else {
            jD = -1;
        }
        this.f18406c = Long.valueOf(jD);
    }

    public InterfaceC2560n o(C1875k c1875k) {
        return this.f18404a.K(c1875k);
    }
}
