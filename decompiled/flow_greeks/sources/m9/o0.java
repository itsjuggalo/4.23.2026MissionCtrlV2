package m9;

import bb.a0;
import bb.b0;
import bb.e;
import bb.e0;
import bb.j;
import bb.k;
import bb.n;
import bb.p;
import bb.t;
import bb.v;
import bb.y;
import bb.z;
import com.google.firebase.firestore.a;
import com.google.protobuf.s1;
import g9.a1;
import g9.g1;
import g9.k;
import g9.p;
import i9.k1;
import i9.n4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k9.a;
import m9.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j9.f f16228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16229b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f16231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f16232c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f16233d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f16234e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f16235f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int[] f16236g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int[] f16237h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ int[] f16238i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ int[] f16239j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final /* synthetic */ int[] f16240k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ int[] f16241l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ int[] f16242m;

        static {
            int[] iArr = new int[t.c.values().length];
            f16242m = iArr;
            try {
                iArr[t.c.TARGET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16242m[t.c.DOCUMENT_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16242m[t.c.DOCUMENT_DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16242m[t.c.DOCUMENT_REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16242m[t.c.FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16242m[t.c.RESPONSETYPE_NOT_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[b0.c.values().length];
            f16241l = iArr2;
            try {
                iArr2[b0.c.NO_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16241l[b0.c.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16241l[b0.c.REMOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16241l[b0.c.CURRENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f16241l[b0.c.RESET.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f16241l[b0.c.UNRECOGNIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr3 = new int[z.e.values().length];
            f16240k = iArr3;
            try {
                iArr3[z.e.ASCENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f16240k[z.e.DESCENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr4 = new int[z.f.b.values().length];
            f16239j = iArr4;
            try {
                iArr4[z.f.b.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f16239j[z.f.b.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f16239j[z.f.b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f16239j[z.f.b.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f16239j[z.f.b.GREATER_THAN_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f16239j[z.f.b.GREATER_THAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f16239j[z.f.b.ARRAY_CONTAINS.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f16239j[z.f.b.IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f16239j[z.f.b.ARRAY_CONTAINS_ANY.ordinal()] = 9;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f16239j[z.f.b.NOT_IN.ordinal()] = 10;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr5 = new int[p.b.values().length];
            f16238i = iArr5;
            try {
                iArr5[p.b.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f16238i[p.b.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f16238i[p.b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f16238i[p.b.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f16238i[p.b.GREATER_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f16238i[p.b.GREATER_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f16238i[p.b.ARRAY_CONTAINS.ordinal()] = 7;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f16238i[p.b.IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f16238i[p.b.ARRAY_CONTAINS_ANY.ordinal()] = 9;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f16238i[p.b.NOT_IN.ordinal()] = 10;
            } catch (NoSuchFieldError unused34) {
            }
            int[] iArr6 = new int[z.k.b.values().length];
            f16237h = iArr6;
            try {
                iArr6[z.k.b.IS_NAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f16237h[z.k.b.IS_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f16237h[z.k.b.IS_NOT_NAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f16237h[z.k.b.IS_NOT_NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused38) {
            }
            int[] iArr7 = new int[z.h.b.values().length];
            f16236g = iArr7;
            try {
                iArr7[z.h.b.COMPOSITE_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f16236g[z.h.b.FIELD_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f16236g[z.h.b.UNARY_FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused41) {
            }
            int[] iArr8 = new int[z.d.b.values().length];
            f16235f = iArr8;
            try {
                iArr8[z.d.b.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f16235f[z.d.b.OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused43) {
            }
            int[] iArr9 = new int[k.a.values().length];
            f16234e = iArr9;
            try {
                iArr9[k.a.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f16234e[k.a.OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused45) {
            }
            int[] iArr10 = new int[k1.values().length];
            f16233d = iArr10;
            try {
                iArr10[k1.LISTEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f16233d[k1.EXISTENCE_FILTER_MISMATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f16233d[k1.EXISTENCE_FILTER_MISMATCH_BLOOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f16233d[k1.LIMBO_RESOLUTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused49) {
            }
            int[] iArr11 = new int[p.c.EnumC0056c.values().length];
            f16232c = iArr11;
            try {
                iArr11[p.c.EnumC0056c.SET_TO_SERVER_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f16232c[p.c.EnumC0056c.APPEND_MISSING_ELEMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f16232c[p.c.EnumC0056c.REMOVE_ALL_FROM_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f16232c[p.c.EnumC0056c.INCREMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused53) {
            }
            int[] iArr12 = new int[v.c.values().length];
            f16231b = iArr12;
            try {
                iArr12[v.c.UPDATE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f16231b[v.c.EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f16231b[v.c.CONDITIONTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused56) {
            }
            int[] iArr13 = new int[e0.c.values().length];
            f16230a = iArr13;
            try {
                iArr13[e0.c.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f16230a[e0.c.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f16230a[e0.c.VERIFY.ordinal()] = 3;
            } catch (NoSuchFieldError unused59) {
            }
        }
    }

    public o0(j9.f fVar) {
        this.f16228a = fVar;
        this.f16229b = Z(fVar).c();
    }

    public static j9.t Z(j9.f fVar) {
        return j9.t.A(Arrays.asList("projects", fVar.i(), "databases", fVar.h()));
    }

    public static j9.t a0(j9.t tVar) {
        n9.b.d(tVar.u() > 4 && tVar.o(4).equals("documents"), "Tried to deserialize invalid key %s", tVar);
        return (j9.t) tVar.v(5);
    }

    public static boolean d0(j9.t tVar) {
        return tVar.u() >= 4 && tVar.o(0).equals("projects") && tVar.o(2).equals("databases");
    }

    public y0 A(bb.t tVar) {
        y0.e eVar;
        int i10 = a.f16242m[tVar.f0().ordinal()];
        rb.k1 k1VarB0 = null;
        if (i10 == 1) {
            bb.b0 b0VarG0 = tVar.g0();
            int i11 = a.f16241l[b0VarG0.e0().ordinal()];
            if (i11 == 1) {
                eVar = y0.e.NoChange;
            } else if (i11 == 2) {
                eVar = y0.e.Added;
            } else if (i11 == 3) {
                eVar = y0.e.Removed;
                k1VarB0 = b0(b0VarG0.a0());
            } else if (i11 == 4) {
                eVar = y0.e.Current;
            } else {
                if (i11 != 5) {
                    throw new IllegalArgumentException("Unknown target change type");
                }
                eVar = y0.e.Reset;
            }
            return new y0.d(eVar, b0VarG0.g0(), b0VarG0.d0(), k1VarB0);
        }
        if (i10 == 2) {
            bb.l lVarB0 = tVar.b0();
            List listD0 = lVarB0.d0();
            List listC0 = lVarB0.c0();
            j9.k kVarL = l(lVarB0.b0().g0());
            j9.v vVarY = y(lVarB0.b0().h0());
            n9.b.d(!vVarY.equals(j9.v.f14278b), "Got a document change without an update time", new Object[0]);
            j9.r rVarP = j9.r.p(kVarL, vVarY, j9.s.h(lVarB0.b0().e0()));
            return new y0.b(listD0, listC0, rVarP.getKey(), rVarP);
        }
        if (i10 == 3) {
            bb.m mVarC0 = tVar.c0();
            List listD02 = mVarC0.d0();
            j9.r rVarR = j9.r.r(l(mVarC0.b0()), y(mVarC0.c0()));
            return new y0.b(Collections.EMPTY_LIST, listD02, rVarR.getKey(), rVarR);
        }
        if (i10 == 4) {
            bb.o oVarD0 = tVar.d0();
            return new y0.b(Collections.EMPTY_LIST, oVarD0.c0(), l(oVarD0.b0()), null);
        }
        if (i10 != 5) {
            throw new IllegalArgumentException("Unknown change type set");
        }
        bb.q qVarE0 = tVar.e0();
        return new y0.c(qVarE0.c0(), new r(qVarE0.a0(), qVarE0.d0()));
    }

    public z.h B(g9.k kVar) {
        ArrayList arrayList = new ArrayList(kVar.b().size());
        Iterator it = kVar.b().iterator();
        while (it.hasNext()) {
            arrayList.add(J((g9.q) it.next()));
        }
        if (arrayList.size() == 1) {
            return (z.h) arrayList.get(0);
        }
        z.d.a aVarH0 = z.d.h0();
        aVarH0.y(C(kVar.e()));
        aVarH0.x(arrayList);
        return (z.h) z.h.i0().x(aVarH0).n();
    }

    public z.d.b C(k.a aVar) {
        int i10 = a.f16234e[aVar.ordinal()];
        if (i10 == 1) {
            return z.d.b.AND;
        }
        if (i10 == 2) {
            return z.d.b.OR;
        }
        throw n9.b.a("Unrecognized composite filter type.", new Object[0]);
    }

    public bb.k D(j9.k kVar, j9.s sVar) {
        k.b bVarK0 = bb.k.k0();
        bVarK0.y(L(kVar));
        bVarK0.x(sVar.k());
        return (bb.k) bVarK0.n();
    }

    public final bb.n E(k9.d dVar) {
        n.b bVarG0 = bb.n.g0();
        Iterator it = dVar.c().iterator();
        while (it.hasNext()) {
            bVarG0.x(((j9.q) it.next()).c());
        }
        return (bb.n) bVarG0.n();
    }

    public a0.c F(g1 g1Var) {
        a0.c.a aVarG0 = a0.c.g0();
        aVarG0.x(R(g1Var.n()));
        return (a0.c) aVarG0.n();
    }

    public final z.f.b G(p.b bVar) {
        switch (a.f16238i[bVar.ordinal()]) {
            case 1:
                return z.f.b.LESS_THAN;
            case 2:
                return z.f.b.LESS_THAN_OR_EQUAL;
            case 3:
                return z.f.b.EQUAL;
            case 4:
                return z.f.b.NOT_EQUAL;
            case 5:
                return z.f.b.GREATER_THAN;
            case 6:
                return z.f.b.GREATER_THAN_OR_EQUAL;
            case 7:
                return z.f.b.ARRAY_CONTAINS;
            case 8:
                return z.f.b.IN;
            case 9:
                return z.f.b.ARRAY_CONTAINS_ANY;
            case 10:
                return z.f.b.NOT_IN;
            default:
                throw n9.b.a("Unknown operator %d", bVar);
        }
    }

    public final z.g H(j9.q qVar) {
        return (z.g) z.g.d0().x(qVar.c()).n();
    }

    public final p.c I(k9.e eVar) {
        k9.p pVarB = eVar.b();
        if (pVarB instanceof k9.n) {
            return (p.c) p.c.l0().y(eVar.a().c()).B(p.c.b.REQUEST_TIME).n();
        }
        if (pVarB instanceof a.b) {
            return (p.c) p.c.l0().y(eVar.a().c()).x(bb.b.j0().x(((a.b) pVarB).f())).n();
        }
        if (pVarB instanceof a.C0254a) {
            return (p.c) p.c.l0().y(eVar.a().c()).A(bb.b.j0().x(((a.C0254a) pVarB).f())).n();
        }
        if (pVarB instanceof k9.j) {
            return (p.c) p.c.l0().y(eVar.a().c()).z(((k9.j) pVarB).d()).n();
        }
        throw n9.b.a("Unknown transform: %s", pVarB);
    }

    public z.h J(g9.q qVar) {
        if (qVar instanceof g9.p) {
            return X((g9.p) qVar);
        }
        if (qVar instanceof g9.k) {
            return B((g9.k) qVar);
        }
        throw n9.b.a("Unrecognized filter type %s", qVar.toString());
    }

    public final z.h K(List list) {
        return J(new g9.k(list, k.a.AND));
    }

    public String L(j9.k kVar) {
        return T(this.f16228a, kVar.s());
    }

    public final String M(k1 k1Var) {
        int i10 = a.f16233d[k1Var.ordinal()];
        if (i10 == 1) {
            return null;
        }
        if (i10 == 2) {
            return "existence-filter-mismatch";
        }
        if (i10 == 3) {
            return "existence-filter-mismatch-bloom";
        }
        if (i10 == 4) {
            return "limbo-document";
        }
        throw n9.b.a("Unrecognized query purpose: %s", k1Var);
    }

    public Map N(n4 n4Var) {
        String strM = M(n4Var.c());
        if (strM == null) {
            return null;
        }
        HashMap map = new HashMap(1);
        map.put("goog-listen-tags", strM);
        return map;
    }

    public bb.e0 O(k9.f fVar) {
        e0.b bVarU0 = bb.e0.u0();
        if (fVar instanceof k9.o) {
            bVarU0.A(D(fVar.g(), ((k9.o) fVar).o()));
        } else if (fVar instanceof k9.l) {
            bVarU0.A(D(fVar.g(), ((k9.l) fVar).q()));
            bVarU0.B(E(fVar.e()));
        } else if (fVar instanceof k9.c) {
            bVarU0.z(L(fVar.g()));
        } else {
            if (!(fVar instanceof k9.q)) {
                throw n9.b.a("unknown mutation type %s", fVar.getClass());
            }
            bVarU0.C(L(fVar.g()));
        }
        Iterator it = fVar.f().iterator();
        while (it.hasNext()) {
            bVarU0.x(I((k9.e) it.next()));
        }
        if (!fVar.h().d()) {
            bVarU0.y(Q(fVar.h()));
        }
        return (bb.e0) bVarU0.n();
    }

    public final z.i P(g9.a1 a1Var) {
        z.i.a aVarE0 = z.i.e0();
        if (a1Var.b().equals(a1.a.ASCENDING)) {
            aVarE0.x(z.e.ASCENDING);
        } else {
            aVarE0.x(z.e.DESCENDING);
        }
        aVarE0.y(H(a1Var.c()));
        return (z.i) aVarE0.n();
    }

    public final bb.v Q(k9.m mVar) {
        n9.b.d(!mVar.d(), "Can't serialize an empty precondition", new Object[0]);
        v.b bVarG0 = bb.v.g0();
        if (mVar.c() != null) {
            return (bb.v) bVarG0.y(Y(mVar.c())).n();
        }
        if (mVar.b() != null) {
            return (bb.v) bVarG0.x(mVar.b().booleanValue()).n();
        }
        throw n9.b.a("Unknown Precondition", new Object[0]);
    }

    public final String R(j9.t tVar) {
        return T(this.f16228a, tVar);
    }

    public a0.d S(g1 g1Var) {
        a0.d.a aVarF0 = a0.d.f0();
        z.b bVarX0 = bb.z.x0();
        j9.t tVarN = g1Var.n();
        if (g1Var.d() != null) {
            n9.b.d(tVarN.u() % 2 == 0, "Collection Group queries should be within a document path or root.", new Object[0]);
            aVarF0.x(R(tVarN));
            z.c.a aVarE0 = z.c.e0();
            aVarE0.y(g1Var.d());
            aVarE0.x(true);
            bVarX0.x(aVarE0);
        } else {
            n9.b.d(tVarN.u() % 2 != 0, "Document queries with filters are not supported.", new Object[0]);
            aVarF0.x(R((j9.t) tVarN.w()));
            z.c.a aVarE02 = z.c.e0();
            aVarE02.y(tVarN.m());
            bVarX0.x(aVarE02);
        }
        if (g1Var.h().size() > 0) {
            bVarX0.C(K(g1Var.h()));
        }
        Iterator it = g1Var.m().iterator();
        while (it.hasNext()) {
            bVarX0.y(P((g9.a1) it.next()));
        }
        if (g1Var.r()) {
            bVarX0.A(com.google.protobuf.z.d0().x((int) g1Var.j()));
        }
        if (g1Var.p() != null) {
            j.b bVarG0 = bb.j.g0();
            bVarG0.x(g1Var.p().b());
            bVarG0.y(g1Var.p().c());
            bVarX0.B(bVarG0);
        }
        if (g1Var.f() != null) {
            j.b bVarG02 = bb.j.g0();
            bVarG02.x(g1Var.f().b());
            bVarG02.y(!g1Var.f().c());
            bVarX0.z(bVarG02);
        }
        aVarF0.y(bVarX0);
        return (a0.d) aVarF0.n();
    }

    public final String T(j9.f fVar, j9.t tVar) {
        return ((j9.t) ((j9.t) Z(fVar).b("documents")).a(tVar)).c();
    }

    public bb.y U(a0.d dVar, List list, HashMap map) {
        y.c cVarE0 = bb.y.e0();
        cVarE0.y(dVar.e0());
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        int i10 = 1;
        while (it.hasNext()) {
            com.google.firebase.firestore.a aVar = (com.google.firebase.firestore.a) it.next();
            if (!hashSet.contains(aVar.c())) {
                hashSet.add(aVar.c());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("aggregate_");
                int i11 = i10 + 1;
                sb2.append(i10);
                String string = sb2.toString();
                map.put(string, aVar.c());
                y.b.C0058b c0058bE0 = y.b.e0();
                z.g gVar = (z.g) z.g.d0().x(aVar.d()).n();
                if (aVar instanceof a.c) {
                    c0058bE0.z(y.b.c.a0());
                } else if (aVar instanceof a.d) {
                    c0058bE0.A((y.b.d) y.b.d.b0().x(gVar).n());
                } else {
                    if (!(aVar instanceof a.b)) {
                        throw new RuntimeException("Unsupported aggregation");
                    }
                    c0058bE0.y((y.b.a) y.b.a.b0().x(gVar).n());
                }
                c0058bE0.x(string);
                arrayList.add((y.b) c0058bE0.n());
                i10 = i11;
            }
        }
        cVarE0.x(arrayList);
        return (bb.y) cVarE0.n();
    }

    public bb.a0 V(n4 n4Var) {
        a0.b bVarG0 = bb.a0.g0();
        g1 g1VarG = n4Var.g();
        if (g1VarG.s()) {
            bVarG0.x(F(g1VarG));
        } else {
            bVarG0.z(S(g1VarG));
        }
        bVarG0.C(n4Var.h());
        if (!n4Var.d().isEmpty() || n4Var.f().compareTo(j9.v.f14278b) <= 0) {
            bVarG0.B(n4Var.d());
        } else {
            bVarG0.A(W(n4Var.f().b()));
        }
        if (n4Var.a() != null && (!n4Var.d().isEmpty() || n4Var.f().compareTo(j9.v.f14278b) > 0)) {
            bVarG0.y(com.google.protobuf.z.d0().x(n4Var.a().intValue()));
        }
        return (bb.a0) bVarG0.n();
    }

    public s1 W(a7.s sVar) {
        s1.b bVarF0 = s1.f0();
        bVarF0.y(sVar.h());
        bVarF0.x(sVar.b());
        return (s1) bVarF0.n();
    }

    public z.h X(g9.p pVar) {
        p.b bVarG = pVar.g();
        p.b bVar = p.b.EQUAL;
        if (bVarG == bVar || pVar.g() == p.b.NOT_EQUAL) {
            z.k.a aVarF0 = z.k.f0();
            aVarF0.x(H(pVar.f()));
            if (j9.y.z(pVar.h())) {
                aVarF0.y(pVar.g() == bVar ? z.k.b.IS_NAN : z.k.b.IS_NOT_NAN);
                return (z.h) z.h.i0().z(aVarF0).n();
            }
            if (j9.y.A(pVar.h())) {
                aVarF0.y(pVar.g() == bVar ? z.k.b.IS_NULL : z.k.b.IS_NOT_NULL);
                return (z.h) z.h.i0().z(aVarF0).n();
            }
        }
        z.f.a aVarH0 = z.f.h0();
        aVarH0.x(H(pVar.f()));
        aVarH0.y(G(pVar.g()));
        aVarH0.z(pVar.h());
        return (z.h) z.h.i0().y(aVarH0).n();
    }

    public s1 Y(j9.v vVar) {
        return W(vVar.b());
    }

    public String a() {
        return this.f16229b;
    }

    public g9.k b(z.d dVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = dVar.f0().iterator();
        while (it.hasNext()) {
            arrayList.add(i((z.h) it.next()));
        }
        return new g9.k(arrayList, c(dVar.g0()));
    }

    public final rb.k1 b0(jb.a aVar) {
        return rb.k1.i(aVar.a0()).r(aVar.c0());
    }

    public k.a c(z.d.b bVar) {
        int i10 = a.f16235f[bVar.ordinal()];
        if (i10 == 1) {
            return k.a.AND;
        }
        if (i10 == 2) {
            return k.a.OR;
        }
        throw n9.b.a("Only AND and OR composite filter types are supported.", new Object[0]);
    }

    public boolean c0(j9.t tVar) {
        return d0(tVar) && tVar.o(1).equals(this.f16228a.i()) && tVar.o(3).equals(this.f16228a.h());
    }

    public final k9.d d(bb.n nVar) {
        int iF0 = nVar.f0();
        HashSet hashSet = new HashSet(iF0);
        for (int i10 = 0; i10 < iF0; i10++) {
            hashSet.add(j9.q.B(nVar.e0(i10)));
        }
        return k9.d.b(hashSet);
    }

    public g1 e(a0.c cVar) {
        int iF0 = cVar.f0();
        n9.b.d(iF0 == 1, "DocumentsTarget contained other than 1 document %d", Integer.valueOf(iF0));
        return g9.b1.b(s(cVar.e0(0))).D();
    }

    public g9.p f(z.f fVar) {
        return g9.p.e(j9.q.B(fVar.e0().c0()), g(fVar.f0()), fVar.g0());
    }

    public final p.b g(z.f.b bVar) {
        switch (a.f16239j[bVar.ordinal()]) {
            case 1:
                return p.b.LESS_THAN;
            case 2:
                return p.b.LESS_THAN_OR_EQUAL;
            case 3:
                return p.b.EQUAL;
            case 4:
                return p.b.NOT_EQUAL;
            case 5:
                return p.b.GREATER_THAN_OR_EQUAL;
            case 6:
                return p.b.GREATER_THAN;
            case 7:
                return p.b.ARRAY_CONTAINS;
            case 8:
                return p.b.IN;
            case 9:
                return p.b.ARRAY_CONTAINS_ANY;
            case 10:
                return p.b.NOT_IN;
            default:
                throw n9.b.a("Unhandled FieldFilter.operator %d", bVar);
        }
    }

    public final k9.e h(p.c cVar) {
        int i10 = a.f16232c[cVar.k0().ordinal()];
        if (i10 == 1) {
            n9.b.d(cVar.j0() == p.c.b.REQUEST_TIME, "Unknown transform setToServerValue: %s", cVar.j0());
            return new k9.e(j9.q.B(cVar.g0()), k9.n.d());
        }
        if (i10 == 2) {
            return new k9.e(j9.q.B(cVar.g0()), new a.b(cVar.f0().h()));
        }
        if (i10 == 3) {
            return new k9.e(j9.q.B(cVar.g0()), new a.C0254a(cVar.i0().h()));
        }
        if (i10 == 4) {
            return new k9.e(j9.q.B(cVar.g0()), new k9.j(cVar.h0()));
        }
        throw n9.b.a("Unknown FieldTransform proto: %s", cVar);
    }

    public g9.q i(z.h hVar) {
        int i10 = a.f16236g[hVar.g0().ordinal()];
        if (i10 == 1) {
            return b(hVar.d0());
        }
        if (i10 == 2) {
            return f(hVar.f0());
        }
        if (i10 == 3) {
            return x(hVar.h0());
        }
        throw n9.b.a("Unrecognized Filter.filterType %d", hVar.g0());
    }

    public final List j(z.h hVar) {
        g9.q qVarI = i(hVar);
        if (qVarI instanceof g9.k) {
            g9.k kVar = (g9.k) qVarI;
            if (kVar.i()) {
                return kVar.b();
            }
        }
        return Collections.singletonList(qVarI);
    }

    public final j9.r k(bb.e eVar) {
        n9.b.d(eVar.e0().equals(e.c.FOUND), "Tried to deserialize a found document from a missing document.", new Object[0]);
        j9.k kVarL = l(eVar.b0().g0());
        j9.s sVarH = j9.s.h(eVar.b0().e0());
        j9.v vVarY = y(eVar.b0().h0());
        n9.b.d(!vVarY.equals(j9.v.f14278b), "Got a document response with no snapshot version", new Object[0]);
        return j9.r.p(kVarL, vVarY, sVarH);
    }

    public j9.k l(String str) {
        j9.t tVarV = v(str);
        n9.b.d(tVarV.o(1).equals(this.f16228a.i()), "Tried to deserialize key from different project.", new Object[0]);
        n9.b.d(tVarV.o(3).equals(this.f16228a.h()), "Tried to deserialize key from different database.", new Object[0]);
        return j9.k.k(a0(tVarV));
    }

    public j9.r m(bb.e eVar) {
        if (eVar.e0().equals(e.c.FOUND)) {
            return k(eVar);
        }
        if (eVar.e0().equals(e.c.MISSING)) {
            return n(eVar);
        }
        throw new IllegalArgumentException("Unknown result case: " + eVar.e0());
    }

    public final j9.r n(bb.e eVar) {
        n9.b.d(eVar.e0().equals(e.c.MISSING), "Tried to deserialize a missing document from a found document.", new Object[0]);
        j9.k kVarL = l(eVar.c0());
        j9.v vVarY = y(eVar.d0());
        n9.b.d(!vVarY.equals(j9.v.f14278b), "Got a no document response with no snapshot version", new Object[0]);
        return j9.r.r(kVarL, vVarY);
    }

    public k9.f o(bb.e0 e0Var) {
        k9.m mVarR = e0Var.q0() ? r(e0Var.i0()) : k9.m.f14793c;
        ArrayList arrayList = new ArrayList();
        Iterator it = e0Var.o0().iterator();
        while (it.hasNext()) {
            arrayList.add(h((p.c) it.next()));
        }
        int i10 = a.f16230a[e0Var.k0().ordinal()];
        if (i10 == 1) {
            return e0Var.t0() ? new k9.l(l(e0Var.m0().g0()), j9.s.h(e0Var.m0().e0()), d(e0Var.n0()), mVarR, arrayList) : new k9.o(l(e0Var.m0().g0()), j9.s.h(e0Var.m0().e0()), mVarR, arrayList);
        }
        if (i10 == 2) {
            return new k9.c(l(e0Var.j0()), mVarR);
        }
        if (i10 == 3) {
            return new k9.q(l(e0Var.p0()), mVarR);
        }
        throw n9.b.a("Unknown mutation operation: %d", e0Var.k0());
    }

    public k9.i p(bb.h0 h0Var, j9.v vVar) {
        j9.v vVarY = y(h0Var.c0());
        if (!j9.v.f14278b.equals(vVarY)) {
            vVar = vVarY;
        }
        int iB0 = h0Var.b0();
        ArrayList arrayList = new ArrayList(iB0);
        for (int i10 = 0; i10 < iB0; i10++) {
            arrayList.add(h0Var.a0(i10));
        }
        return new k9.i(vVar, arrayList);
    }

    public final g9.a1 q(z.i iVar) {
        a1.a aVar;
        j9.q qVarB = j9.q.B(iVar.d0().c0());
        int i10 = a.f16240k[iVar.c0().ordinal()];
        if (i10 == 1) {
            aVar = a1.a.ASCENDING;
        } else {
            if (i10 != 2) {
                throw n9.b.a("Unrecognized direction %d", iVar.c0());
            }
            aVar = a1.a.DESCENDING;
        }
        return g9.a1.d(aVar, qVarB);
    }

    public final k9.m r(bb.v vVar) {
        int i10 = a.f16231b[vVar.c0().ordinal()];
        if (i10 == 1) {
            return k9.m.f(y(vVar.f0()));
        }
        if (i10 == 2) {
            return k9.m.a(vVar.e0());
        }
        if (i10 == 3) {
            return k9.m.f14793c;
        }
        throw n9.b.a("Unknown precondition", new Object[0]);
    }

    public final j9.t s(String str) {
        j9.t tVarV = v(str);
        return tVarV.u() == 4 ? j9.t.f14277b : a0(tVarV);
    }

    public g1 t(a0.d dVar) {
        return u(dVar.d0(), dVar.e0());
    }

    public g1 u(String str, bb.z zVar) {
        j9.t tVar;
        String strD0;
        List arrayList;
        j9.t tVarS = s(str);
        int iN0 = zVar.n0();
        if (iN0 <= 0) {
            tVar = tVarS;
            strD0 = null;
        } else {
            n9.b.d(iN0 == 1, "StructuredQuery.from with more than one collection is not supported.", new Object[0]);
            z.c cVarM0 = zVar.m0(0);
            if (cVarM0.c0()) {
                tVar = tVarS;
                strD0 = cVarM0.d0();
            } else {
                tVarS = (j9.t) tVarS.b(cVarM0.d0());
                tVar = tVarS;
                strD0 = null;
            }
        }
        List listJ = zVar.w0() ? j(zVar.s0()) : Collections.EMPTY_LIST;
        int iQ0 = zVar.q0();
        if (iQ0 > 0) {
            arrayList = new ArrayList(iQ0);
            for (int i10 = 0; i10 < iQ0; i10++) {
                arrayList.add(q(zVar.p0(i10)));
            }
        } else {
            arrayList = Collections.EMPTY_LIST;
        }
        return new g1(tVar, strD0, listJ, arrayList, zVar.u0() ? zVar.o0().c0() : -1L, zVar.v0() ? new g9.i(zVar.r0().h(), zVar.r0().e0()) : null, zVar.t0() ? new g9.i(zVar.l0().h(), !zVar.l0().e0()) : null);
    }

    public final j9.t v(String str) {
        j9.t tVarB = j9.t.B(str);
        n9.b.d(d0(tVarB), "Tried to deserialize invalid key %s", tVarB);
        return tVarB;
    }

    public a7.s w(s1 s1Var) {
        return new a7.s(s1Var.e0(), s1Var.d0());
    }

    public final g9.q x(z.k kVar) {
        j9.q qVarB = j9.q.B(kVar.d0().c0());
        int i10 = a.f16237h[kVar.e0().ordinal()];
        if (i10 == 1) {
            return g9.p.e(qVarB, p.b.EQUAL, j9.y.f14284a);
        }
        if (i10 == 2) {
            return g9.p.e(qVarB, p.b.EQUAL, j9.y.f14285b);
        }
        if (i10 == 3) {
            return g9.p.e(qVarB, p.b.NOT_EQUAL, j9.y.f14284a);
        }
        if (i10 == 4) {
            return g9.p.e(qVarB, p.b.NOT_EQUAL, j9.y.f14285b);
        }
        throw n9.b.a("Unrecognized UnaryFilter.operator %d", kVar.e0());
    }

    public j9.v y(s1 s1Var) {
        return (s1Var.e0() == 0 && s1Var.d0() == 0) ? j9.v.f14278b : new j9.v(w(s1Var));
    }

    public j9.v z(bb.t tVar) {
        return tVar.f0() != t.c.TARGET_CHANGE ? j9.v.f14278b : tVar.g0().f0() != 0 ? j9.v.f14278b : y(tVar.g0().c0());
    }
}
