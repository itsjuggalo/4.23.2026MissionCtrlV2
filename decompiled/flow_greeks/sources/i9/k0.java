package i9;

import android.util.SparseArray;
import i9.q0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements f9.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f12009o = TimeUnit.MINUTES.toSeconds(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h1 f12010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f12011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f12012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e1 f12013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i9.b f12014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o1 f12015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o f12016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j1 f12017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n1 f12018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m4 f12019j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i9.a f12020k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SparseArray f12021l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f12022m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final g9.h1 f12023n;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n4 f12024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12025b;

        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f12026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f12027b;

        public c(Map map, Set set) {
            this.f12026a = map;
            this.f12027b = set;
        }
    }

    public k0(h1 h1Var, j1 j1Var, e9.j jVar) {
        n9.b.d(h1Var.j(), "LocalStore was passed an unstarted persistence implementation", new Object[0]);
        this.f12010a = h1Var;
        this.f12017h = j1Var;
        this.f12011b = h1Var.c();
        m4 m4VarI = h1Var.i();
        this.f12019j = m4VarI;
        this.f12020k = h1Var.a();
        this.f12023n = g9.h1.b(m4VarI.d());
        this.f12015f = h1Var.h();
        n1 n1Var = new n1();
        this.f12018i = n1Var;
        this.f12021l = new SparseArray();
        this.f12022m = new HashMap();
        h1Var.g().h(n1Var);
        O(jVar);
    }

    public static g9.g1 P(String str) {
        return g9.b1.b(j9.t.B("__bundle__/docs/" + str)).D();
    }

    public static boolean X(n4 n4Var, n4 n4Var2, m9.v0 v0Var) {
        if (n4Var.d().isEmpty()) {
            return true;
        }
        long jH = n4Var2.f().b().h() - n4Var.f().b().h();
        long j10 = f12009o;
        if (jH < j10 && n4Var2.b().b().h() - n4Var.b().b().h() < j10) {
            return v0Var != null && (v0Var.b().size() + v0Var.c().size()) + v0Var.d().size() > 0;
        }
        return true;
    }

    public static /* synthetic */ g8.c d(k0 k0Var, int i10) {
        k9.g gVarI = k0Var.f12013d.i(i10);
        n9.b.d(gVarI != null, "Attempt to reject nonexistent batch!", new Object[0]);
        k0Var.f12013d.c(gVarI);
        k0Var.f12013d.b();
        k0Var.f12014e.d(i10);
        k0Var.f12016g.o(gVarI.f());
        return k0Var.f12016g.d(gVarI.f());
    }

    public static /* synthetic */ void e(k0 k0Var, int i10) {
        n4 n4Var = (n4) k0Var.f12021l.get(i10);
        n9.b.d(n4Var != null, "Tried to release nonexistent target: %s", Integer.valueOf(i10));
        Iterator it = k0Var.f12018i.h(i10).iterator();
        while (it.hasNext()) {
            k0Var.f12010a.g().d((j9.k) it.next());
        }
        k0Var.f12010a.g().o(n4Var);
        k0Var.f12021l.remove(i10);
        k0Var.f12022m.remove(n4Var.g());
    }

    public static /* synthetic */ void f(k0 k0Var, List list) {
        k0Var.getClass();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            l0 l0Var = (l0) it.next();
            int iD = l0Var.d();
            k0Var.f12018i.b(l0Var.b(), iD);
            g8.e eVarC = l0Var.c();
            Iterator it2 = eVarC.iterator();
            while (it2.hasNext()) {
                k0Var.f12010a.g().d((j9.k) it2.next());
            }
            k0Var.f12018i.g(eVarC, iD);
            if (!l0Var.e()) {
                n4 n4Var = (n4) k0Var.f12021l.get(iD);
                n9.b.d(n4Var != null, "Can't set limbo-free snapshot version for unknown target: %s", Integer.valueOf(iD));
                n4 n4VarJ = n4Var.j(n4Var.f());
                k0Var.f12021l.put(iD, n4VarJ);
                if (X(n4Var, n4VarJ, null)) {
                    k0Var.f12019j.h(n4VarJ);
                }
            }
        }
    }

    public static /* synthetic */ n g(k0 k0Var, Set set, List list, a7.s sVar) {
        Map mapB = k0Var.f12015f.b(set);
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : mapB.entrySet()) {
            if (!((j9.r) entry.getValue()).o()) {
                hashSet.add((j9.k) entry.getKey());
            }
        }
        Map mapL = k0Var.f12016g.l(mapB);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k9.f fVar = (k9.f) it.next();
            j9.s sVarD = fVar.d(((g1) mapL.get(fVar.g())).a());
            if (sVarD != null) {
                arrayList.add(new k9.l(fVar.g(), sVarD, sVarD.j(), k9.m.a(true)));
            }
        }
        k9.g gVarA = k0Var.f12013d.a(sVar, arrayList, list);
        k0Var.f12014e.e(gVarA.e(), gVarA.a(mapL, hashSet));
        return n.a(gVarA.e(), mapL);
    }

    public static /* synthetic */ Boolean i(k0 k0Var, f9.e eVar) {
        f9.e eVarA = k0Var.f12020k.a(eVar.a());
        return Boolean.valueOf(eVarA != null && eVarA.b().compareTo(eVar.b()) >= 0);
    }

    public static /* synthetic */ g8.c j(k0 k0Var, m9.n0 n0Var, j9.v vVar) {
        k0Var.getClass();
        Map mapD = n0Var.d();
        long jI = k0Var.f12010a.g().i();
        for (Map.Entry entry : mapD.entrySet()) {
            Integer num = (Integer) entry.getKey();
            int iIntValue = num.intValue();
            m9.v0 v0Var = (m9.v0) entry.getValue();
            n4 n4Var = (n4) k0Var.f12021l.get(iIntValue);
            if (n4Var != null) {
                k0Var.f12019j.b(v0Var.d(), iIntValue);
                k0Var.f12019j.e(v0Var.b(), iIntValue);
                n4 n4VarL = n4Var.l(jI);
                if (n0Var.e().containsKey(num)) {
                    com.google.protobuf.i iVar = com.google.protobuf.i.f6998b;
                    j9.v vVar2 = j9.v.f14278b;
                    n4VarL = n4VarL.k(iVar, vVar2).j(vVar2);
                } else if (!v0Var.e().isEmpty()) {
                    n4VarL = n4VarL.k(v0Var.e(), n0Var.c());
                }
                k0Var.f12021l.put(iIntValue, n4VarL);
                if (X(n4Var, n4VarL, v0Var)) {
                    k0Var.f12019j.h(n4VarL);
                }
            }
        }
        Map mapA = n0Var.a();
        Set setB = n0Var.b();
        for (j9.k kVar : mapA.keySet()) {
            if (setB.contains(kVar)) {
                k0Var.f12010a.g().m(kVar);
            }
        }
        c cVarR = k0Var.R(mapA);
        Map map = cVarR.f12026a;
        j9.v vVarG = k0Var.f12019j.g();
        if (!vVar.equals(j9.v.f14278b)) {
            n9.b.d(vVar.compareTo(vVarG) >= 0, "Watch stream reverted to previous snapshot?? (%s < %s)", vVar, vVarG);
            k0Var.f12019j.j(vVar);
        }
        return k0Var.f12016g.j(map, cVarR.f12027b);
    }

    public static /* synthetic */ void l(k0 k0Var, f9.j jVar, n4 n4Var, int i10, g8.e eVar) {
        k0Var.getClass();
        if (jVar.c().compareTo(n4Var.f()) > 0) {
            n4 n4VarK = n4Var.k(com.google.protobuf.i.f6998b, jVar.c());
            k0Var.f12021l.append(i10, n4VarK);
            k0Var.f12019j.h(n4VarK);
            k0Var.f12019j.i(i10);
            k0Var.f12019j.e(eVar, i10);
        }
        k0Var.f12020k.c(jVar);
    }

    public static /* synthetic */ g8.c m(k0 k0Var, g8.c cVar, n4 n4Var) {
        k0Var.getClass();
        g8.e eVarH = j9.k.h();
        HashMap map = new HashMap();
        Iterator it = cVar.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            j9.k kVar = (j9.k) entry.getKey();
            j9.r rVar = (j9.r) entry.getValue();
            if (rVar.b()) {
                eVarH = eVarH.e(kVar);
            }
            map.put(kVar, rVar);
        }
        k0Var.f12019j.i(n4Var.h());
        k0Var.f12019j.e(eVarH, n4Var.h());
        c cVarR = k0Var.R(map);
        return k0Var.f12016g.j(cVarR.f12026a, cVarR.f12027b);
    }

    public static /* synthetic */ g8.c n(k0 k0Var, k9.h hVar) {
        k0Var.getClass();
        k9.g gVarB = hVar.b();
        k0Var.f12013d.f(gVarB, hVar.f());
        k0Var.y(hVar);
        k0Var.f12013d.b();
        k0Var.f12014e.d(hVar.b().e());
        k0Var.f12016g.o(k0Var.F(hVar));
        return k0Var.f12016g.d(gVarB.f());
    }

    public static /* synthetic */ void p(k0 k0Var, b bVar, g9.g1 g1Var) {
        int iC = k0Var.f12023n.c();
        bVar.f12025b = iC;
        n4 n4Var = new n4(g1Var, iC, k0Var.f12010a.g().i(), k1.LISTEN);
        bVar.f12024a = n4Var;
        k0Var.f12019j.c(n4Var);
    }

    public static /* synthetic */ void r(k0 k0Var, List list) {
        Collection collectionE = k0Var.f12012c.e();
        Comparator comparator = j9.p.f14249b;
        final m mVar = k0Var.f12012c;
        Objects.requireNonNull(mVar);
        n9.n nVar = new n9.n() { // from class: i9.s
            @Override // n9.n
            public final void accept(Object obj) {
                mVar.b((j9.p) obj);
            }
        };
        final m mVar2 = k0Var.f12012c;
        Objects.requireNonNull(mVar2);
        n9.g0.p(collectionE, list, comparator, nVar, new n9.n() { // from class: i9.t
            @Override // n9.n
            public final void accept(Object obj) {
                mVar2.d((j9.p) obj);
            }
        });
    }

    public void A(final List list) {
        this.f12010a.l("Configure indexes", new Runnable() { // from class: i9.d0
            @Override // java.lang.Runnable
            public final void run() {
                k0.r(this.f11889a, list);
            }
        });
    }

    public void B() {
        this.f12010a.l("Delete All Indexes", new Runnable() { // from class: i9.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11867a.f12012c.i();
            }
        });
    }

    public l1 C(g9.b1 b1Var, boolean z10) {
        g8.e eVarF;
        j9.v vVarB;
        n4 n4VarL = L(b1Var.D());
        j9.v vVar = j9.v.f14278b;
        g8.e eVarH = j9.k.h();
        if (n4VarL != null) {
            vVarB = n4VarL.b();
            eVarF = this.f12019j.f(n4VarL.h());
        } else {
            eVarF = eVarH;
            vVarB = vVar;
        }
        j1 j1Var = this.f12017h;
        if (z10) {
            vVar = vVarB;
        }
        return new l1(j1Var.e(b1Var, vVar, eVarF), eVarF);
    }

    public int D() {
        return this.f12013d.h();
    }

    public m E() {
        return this.f12012c;
    }

    public final Set F(k9.h hVar) {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < hVar.e().size(); i10++) {
            if (!((k9.i) hVar.e().get(i10)).a().isEmpty()) {
                hashSet.add(((k9.f) hVar.b().h().get(i10)).g());
            }
        }
        return hashSet;
    }

    public j9.v G() {
        return this.f12019j.g();
    }

    public com.google.protobuf.i H() {
        return this.f12013d.j();
    }

    public o I() {
        return this.f12016g;
    }

    public f9.j J(final String str) {
        return (f9.j) this.f12010a.k("Get named query", new n9.y() { // from class: i9.e0
            @Override // n9.y
            public final Object get() {
                return this.f11905a.f12020k.d(str);
            }
        });
    }

    public k9.g K(int i10) {
        return this.f12013d.g(i10);
    }

    public n4 L(g9.g1 g1Var) {
        Integer num = (Integer) this.f12022m.get(g1Var);
        return num != null ? (n4) this.f12021l.get(num.intValue()) : this.f12019j.a(g1Var);
    }

    public g8.c M(e9.j jVar) {
        List listK = this.f12013d.k();
        O(jVar);
        Z();
        a0();
        List listK2 = this.f12013d.k();
        g8.e eVarH = j9.k.h();
        Iterator it = Arrays.asList(listK, listK2).iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
                Iterator it3 = ((k9.g) it2.next()).h().iterator();
                while (it3.hasNext()) {
                    eVarH = eVarH.e(((k9.f) it3.next()).g());
                }
            }
        }
        return this.f12016g.d(eVarH);
    }

    public boolean N(final f9.e eVar) {
        return ((Boolean) this.f12010a.k("Has newer bundle", new n9.y() { // from class: i9.c0
            @Override // n9.y
            public final Object get() {
                return k0.i(this.f11880a, eVar);
            }
        })).booleanValue();
    }

    public final void O(e9.j jVar) {
        m mVarD = this.f12010a.d(jVar);
        this.f12012c = mVarD;
        this.f12013d = this.f12010a.e(jVar, mVarD);
        i9.b bVarB = this.f12010a.b(jVar);
        this.f12014e = bVarB;
        this.f12016g = new o(this.f12015f, this.f12013d, bVarB, this.f12012c);
        this.f12015f.e(this.f12012c);
        this.f12017h.f(this.f12016g, this.f12012c);
    }

    public void Q(final List list) {
        this.f12010a.l("notifyLocalViewChanges", new Runnable() { // from class: i9.j0
            @Override // java.lang.Runnable
            public final void run() {
                k0.f(this.f11989a, list);
            }
        });
    }

    public final c R(Map map) {
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Map mapB = this.f12015f.b(map.keySet());
        for (Map.Entry entry : map.entrySet()) {
            j9.k kVar = (j9.k) entry.getKey();
            j9.r rVar = (j9.r) entry.getValue();
            j9.r rVar2 = (j9.r) mapB.get(kVar);
            if (rVar.b() != rVar2.b()) {
                hashSet.add(kVar);
            }
            if (rVar.i() && rVar.k().equals(j9.v.f14278b)) {
                arrayList.add(rVar.getKey());
                map2.put(kVar, rVar);
            } else if (!rVar2.o() || rVar.k().compareTo(rVar2.k()) > 0 || (rVar.k().compareTo(rVar2.k()) == 0 && rVar2.e())) {
                n9.b.d(!j9.v.f14278b.equals(rVar.f()), "Cannot add a document when the remote version is zero", new Object[0]);
                this.f12015f.d(rVar, rVar.f());
                map2.put(kVar, rVar);
            } else {
                n9.v.a("LocalStore", "Ignoring outdated watch update for %s.Current version: %s  Watch version: %s", kVar, rVar2.k(), rVar.k());
            }
        }
        this.f12015f.removeAll(arrayList);
        return new c(map2, hashSet);
    }

    public j9.h S(j9.k kVar) {
        return this.f12016g.c(kVar);
    }

    public g8.c T(final int i10) {
        return (g8.c) this.f12010a.k("Reject batch", new n9.y() { // from class: i9.y
            @Override // n9.y
            public final Object get() {
                return k0.d(this.f12216a, i10);
            }
        });
    }

    public void U(final int i10) {
        this.f12010a.l("Release target", new Runnable() { // from class: i9.w
            @Override // java.lang.Runnable
            public final void run() {
                k0.e(this.f12187a, i10);
            }
        });
    }

    public void V(boolean z10) {
        this.f12017h.j(z10);
    }

    public void W(final com.google.protobuf.i iVar) {
        this.f12010a.l("Set stream token", new Runnable() { // from class: i9.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f12177a.f12013d.e(iVar);
            }
        });
    }

    public void Y() {
        this.f12010a.f().run();
        Z();
        a0();
    }

    public final void Z() {
        this.f12010a.l("Start IndexManager", new Runnable() { // from class: i9.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11932a.f12012c.start();
            }
        });
    }

    @Override // f9.a
    public g8.c a(final g8.c cVar, String str) {
        final n4 n4VarW = w(P(str));
        return (g8.c) this.f12010a.k("Apply bundle documents", new n9.y() { // from class: i9.q
            @Override // n9.y
            public final Object get() {
                return k0.m(this.f12117a, cVar, n4VarW);
            }
        });
    }

    public final void a0() {
        this.f12010a.l("Start MutationQueue", new Runnable() { // from class: i9.h0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11951a.f12013d.start();
            }
        });
    }

    @Override // f9.a
    public void b(final f9.j jVar, final g8.e eVar) {
        final n4 n4VarW = w(jVar.a().b());
        final int iH = n4VarW.h();
        this.f12010a.l("Saved named query", new Runnable() { // from class: i9.g0
            @Override // java.lang.Runnable
            public final void run() {
                k0.l(this.f11938a, jVar, n4VarW, iH, eVar);
            }
        });
    }

    public n b0(final List list) {
        final a7.s sVarI = a7.s.i();
        final HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(((k9.f) it.next()).g());
        }
        return (n) this.f12010a.k("Locally write mutations", new n9.y() { // from class: i9.r
            @Override // n9.y
            public final Object get() {
                return k0.g(this.f12141a, hashSet, list, sVarI);
            }
        });
    }

    @Override // f9.a
    public void c(final f9.e eVar) {
        this.f12010a.l("Save bundle", new Runnable() { // from class: i9.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11962a.f12020k.b(eVar);
            }
        });
    }

    public g8.c v(final k9.h hVar) {
        return (g8.c) this.f12010a.k("Acknowledge batch", new n9.y() { // from class: i9.a0
            @Override // n9.y
            public final Object get() {
                return k0.n(this.f11863a, hVar);
            }
        });
    }

    public n4 w(final g9.g1 g1Var) {
        int iH;
        n4 n4VarA = this.f12019j.a(g1Var);
        if (n4VarA != null) {
            iH = n4VarA.h();
        } else {
            final b bVar = new b();
            this.f12010a.l("Allocate target", new Runnable() { // from class: i9.x
                @Override // java.lang.Runnable
                public final void run() {
                    k0.p(this.f12200a, bVar, g1Var);
                }
            });
            iH = bVar.f12025b;
            n4VarA = bVar.f12024a;
        }
        if (this.f12021l.get(iH) == null) {
            this.f12021l.put(iH, n4VarA);
            this.f12022m.put(g1Var, Integer.valueOf(iH));
        }
        return n4VarA;
    }

    public g8.c x(final m9.n0 n0Var) {
        final j9.v vVarC = n0Var.c();
        return (g8.c) this.f12010a.k("Apply remote event", new n9.y() { // from class: i9.z
            @Override // n9.y
            public final Object get() {
                return k0.j(this.f12230a, n0Var, vVarC);
            }
        });
    }

    public final void y(k9.h hVar) {
        k9.g gVarB = hVar.b();
        for (j9.k kVar : gVarB.f()) {
            j9.r rVarF = this.f12015f.f(kVar);
            j9.v vVar = (j9.v) hVar.d().c(kVar);
            n9.b.d(vVar != null, "docVersions should contain every doc in the write.", new Object[0]);
            if (rVarF.k().compareTo(vVar) < 0) {
                gVarB.c(rVarF, hVar);
                if (rVarF.o()) {
                    this.f12015f.d(rVarF, hVar.c());
                }
            }
        }
        this.f12013d.c(gVarB);
    }

    public q0.c z(final q0 q0Var) {
        return (q0.c) this.f12010a.k("Collect garbage", new n9.y() { // from class: i9.u
            @Override // n9.y
            public final Object get() {
                return q0Var.f(this.f12166a.f12021l);
            }
        });
    }
}
