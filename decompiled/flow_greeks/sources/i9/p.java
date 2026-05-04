package i9;

import ab.a;
import bb.a0;
import bb.e0;
import bb.k;
import bb.p;
import g9.b1;
import j9.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l9.a;
import l9.b;
import l9.c;
import l9.d;
import l9.e;
import za.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m9.o0 f12108a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f12110b;

        static {
            int[] iArr = new int[c.EnumC0277c.values().length];
            f12110b = iArr;
            try {
                iArr[c.EnumC0277c.DOCUMENTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12110b[c.EnumC0277c.QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[a.c.values().length];
            f12109a = iArr2;
            try {
                iArr2[a.c.DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12109a[a.c.NO_DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12109a[a.c.UNKNOWN_DOCUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public p(m9.o0 o0Var) {
        this.f12108a = o0Var;
    }

    public f9.i a(ab.a aVar) {
        return new f9.i(this.f12108a.u(aVar.e0(), aVar.f0()), aVar.d0().equals(a.c.FIRST) ? b1.a.LIMIT_TO_FIRST : b1.a.LIMIT_TO_LAST);
    }

    public final j9.r b(bb.k kVar, boolean z10) {
        j9.r rVarP = j9.r.p(this.f12108a.l(kVar.g0()), this.f12108a.y(kVar.h0()), j9.s.h(kVar.e0()));
        return z10 ? rVarP.t() : rVarP;
    }

    public List c(za.a aVar) {
        ArrayList arrayList = new ArrayList();
        for (a.c cVar : aVar.e0()) {
            arrayList.add(p.c.b(j9.q.B(cVar.d0()), cVar.f0().equals(a.c.d.ARRAY_CONFIG) ? p.c.a.CONTAINS : cVar.e0().equals(a.c.EnumC0483c.ASCENDING) ? p.c.a.ASCENDING : p.c.a.DESCENDING));
        }
        return arrayList;
    }

    public j9.r d(l9.a aVar) {
        int i10 = a.f12109a[aVar.f0().ordinal()];
        if (i10 == 1) {
            return b(aVar.e0(), aVar.g0());
        }
        if (i10 == 2) {
            return g(aVar.h0(), aVar.g0());
        }
        if (i10 == 3) {
            return i(aVar.i0());
        }
        throw n9.b.a("Unknown MaybeDocument %s", aVar);
    }

    public k9.f e(bb.e0 e0Var) {
        return this.f12108a.o(e0Var);
    }

    public k9.g f(l9.e eVar) {
        int iK0 = eVar.k0();
        a7.s sVarW = this.f12108a.w(eVar.l0());
        int iJ0 = eVar.j0();
        ArrayList arrayList = new ArrayList(iJ0);
        for (int i10 = 0; i10 < iJ0; i10++) {
            arrayList.add(this.f12108a.o(eVar.i0(i10)));
        }
        ArrayList arrayList2 = new ArrayList(eVar.n0());
        int i11 = 0;
        while (i11 < eVar.n0()) {
            bb.e0 e0VarM0 = eVar.m0(i11);
            int i12 = i11 + 1;
            if (i12 >= eVar.n0() || !eVar.m0(i12).r0()) {
                arrayList2.add(this.f12108a.o(e0VarM0));
            } else {
                n9.b.d(eVar.m0(i11).s0(), "TransformMutation should be preceded by a patch or set mutation", new Object[0]);
                e0.b bVarV0 = bb.e0.v0(e0VarM0);
                Iterator it = eVar.m0(i12).l0().b0().iterator();
                while (it.hasNext()) {
                    bVarV0.x((p.c) it.next());
                }
                arrayList2.add(this.f12108a.o((bb.e0) bVarV0.n()));
                i11 = i12;
            }
            i11++;
        }
        return new k9.g(iK0, sVarW, arrayList, arrayList2);
    }

    public final j9.r g(l9.b bVar, boolean z10) {
        j9.r rVarR = j9.r.r(this.f12108a.l(bVar.d0()), this.f12108a.y(bVar.e0()));
        return z10 ? rVarR.t() : rVarR;
    }

    public n4 h(l9.c cVar) {
        g9.g1 g1VarE;
        int iP0 = cVar.p0();
        j9.v vVarY = this.f12108a.y(cVar.o0());
        j9.v vVarY2 = this.f12108a.y(cVar.k0());
        com.google.protobuf.i iVarN0 = cVar.n0();
        long jL0 = cVar.l0();
        int i10 = a.f12110b[cVar.q0().ordinal()];
        if (i10 == 1) {
            g1VarE = this.f12108a.e(cVar.j0());
        } else {
            if (i10 != 2) {
                throw n9.b.a("Unknown targetType %d", cVar.q0());
            }
            g1VarE = this.f12108a.t(cVar.m0());
        }
        return new n4(g1VarE, iP0, jL0, k1.LISTEN, vVarY, vVarY2, iVarN0, null);
    }

    public final j9.r i(l9.d dVar) {
        return j9.r.s(this.f12108a.l(dVar.d0()), this.f12108a.y(dVar.e0()));
    }

    public ab.a j(f9.i iVar) {
        a0.d dVarS = this.f12108a.S(iVar.b());
        a.b bVarG0 = ab.a.g0();
        bVarG0.x(iVar.a().equals(b1.a.LIMIT_TO_FIRST) ? a.c.FIRST : a.c.LAST);
        bVarG0.y(dVarS.d0());
        bVarG0.z(dVarS.e0());
        return (ab.a) bVarG0.n();
    }

    public final bb.k k(j9.h hVar) {
        k.b bVarK0 = bb.k.k0();
        bVarK0.y(this.f12108a.L(hVar.getKey()));
        bVarK0.x(hVar.getData().k());
        bVarK0.z(this.f12108a.W(hVar.k().b()));
        return (bb.k) bVarK0.n();
    }

    public za.a l(List list) {
        a.b bVarF0 = za.a.f0();
        bVarF0.y(a.d.COLLECTION_GROUP);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p.c cVar = (p.c) it.next();
            a.c.b bVarG0 = a.c.g0();
            bVarG0.y(cVar.c().c());
            if (cVar.h() == p.c.a.CONTAINS) {
                bVarG0.x(a.c.EnumC0481a.CONTAINS);
            } else if (cVar.h() == p.c.a.ASCENDING) {
                bVarG0.z(a.c.EnumC0483c.ASCENDING);
            } else {
                bVarG0.z(a.c.EnumC0483c.DESCENDING);
            }
            bVarF0.x(bVarG0);
        }
        return (za.a) bVarF0.n();
    }

    public l9.a m(j9.h hVar) {
        a.b bVarJ0 = l9.a.j0();
        if (hVar.i()) {
            bVarJ0.z(p(hVar));
        } else if (hVar.b()) {
            bVarJ0.x(k(hVar));
        } else {
            if (!hVar.j()) {
                throw n9.b.a("Cannot encode invalid document %s", hVar);
            }
            bVarJ0.A(r(hVar));
        }
        bVarJ0.y(hVar.c());
        return (l9.a) bVarJ0.n();
    }

    public bb.e0 n(k9.f fVar) {
        return this.f12108a.O(fVar);
    }

    public l9.e o(k9.g gVar) {
        e.b bVarO0 = l9.e.o0();
        bVarO0.z(gVar.e());
        bVarO0.A(this.f12108a.W(gVar.g()));
        Iterator it = gVar.d().iterator();
        while (it.hasNext()) {
            bVarO0.x(this.f12108a.O((k9.f) it.next()));
        }
        Iterator it2 = gVar.h().iterator();
        while (it2.hasNext()) {
            bVarO0.y(this.f12108a.O((k9.f) it2.next()));
        }
        return (l9.e) bVarO0.n();
    }

    public final l9.b p(j9.h hVar) {
        b.C0276b c0276bF0 = l9.b.f0();
        c0276bF0.x(this.f12108a.L(hVar.getKey()));
        c0276bF0.y(this.f12108a.W(hVar.k().b()));
        return (l9.b) c0276bF0.n();
    }

    public l9.c q(n4 n4Var) {
        k1 k1Var = k1.LISTEN;
        n9.b.d(k1Var.equals(n4Var.c()), "Only queries with purpose %s may be stored, got %s", k1Var, n4Var.c());
        c.b bVarR0 = l9.c.r0();
        bVarR0.E(n4Var.h()).A(n4Var.e()).z(this.f12108a.Y(n4Var.b())).D(this.f12108a.Y(n4Var.f())).C(n4Var.d());
        g9.g1 g1VarG = n4Var.g();
        if (g1VarG.s()) {
            bVarR0.y(this.f12108a.F(g1VarG));
        } else {
            bVarR0.B(this.f12108a.S(g1VarG));
        }
        return (l9.c) bVarR0.n();
    }

    public final l9.d r(j9.h hVar) {
        d.b bVarF0 = l9.d.f0();
        bVarF0.x(this.f12108a.L(hVar.getKey()));
        bVarF0.y(this.f12108a.W(hVar.k().b()));
        return (l9.d) bVarF0.n();
    }
}
