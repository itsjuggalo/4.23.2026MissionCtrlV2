package g9;

import g9.a1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a1 f10152l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a1 f10153m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f10155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g1 f10156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g1 f10157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f10158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j9.t f10159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f10160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f10161h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f10162i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f10163j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f10164k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        LIMIT_TO_FIRST,
        LIMIT_TO_LAST
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f10168a;

        public b(List list) {
            boolean z10;
            Iterator it = list.iterator();
            loop0: while (true) {
                z10 = false;
                while (it.hasNext()) {
                    z10 = (z10 || ((a1) it.next()).c().equals(j9.q.f14256b)) ? true : z10;
                }
            }
            if (!z10) {
                throw new IllegalArgumentException("QueryComparator needs to have a key ordering");
            }
            this.f10168a = list;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(j9.h hVar, j9.h hVar2) {
            Iterator it = this.f10168a.iterator();
            while (it.hasNext()) {
                int iA = ((a1) it.next()).a(hVar, hVar2);
                if (iA != 0) {
                    return iA;
                }
            }
            return 0;
        }
    }

    static {
        a1.a aVar = a1.a.ASCENDING;
        j9.q qVar = j9.q.f14256b;
        f10152l = a1.d(aVar, qVar);
        f10153m = a1.d(a1.a.DESCENDING, qVar);
    }

    public b1(j9.t tVar, String str, List list, List list2, long j10, a aVar, i iVar, i iVar2) {
        this.f10159f = tVar;
        this.f10160g = str;
        this.f10154a = list2;
        this.f10158e = list;
        this.f10161h = j10;
        this.f10162i = aVar;
        this.f10163j = iVar;
        this.f10164k = iVar2;
    }

    public static b1 b(j9.t tVar) {
        return new b1(tVar, null);
    }

    public b1 A(a1 a1Var) {
        n9.b.d(!r(), "No ordering is allowed for document query", new Object[0]);
        ArrayList arrayList = new ArrayList(this.f10154a);
        arrayList.add(a1Var);
        return new b1(this.f10159f, this.f10160g, this.f10158e, arrayList, this.f10161h, this.f10162i, this.f10163j, this.f10164k);
    }

    public b1 B(i iVar) {
        return new b1(this.f10159f, this.f10160g, this.f10158e, this.f10154a, this.f10161h, this.f10162i, iVar, this.f10164k);
    }

    public synchronized g1 C() {
        try {
            if (this.f10157d == null) {
                this.f10157d = E(this.f10154a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f10157d;
    }

    public synchronized g1 D() {
        try {
            if (this.f10156c == null) {
                this.f10156c = E(m());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f10156c;
    }

    public final synchronized g1 E(List list) {
        if (this.f10162i == a.LIMIT_TO_FIRST) {
            return new g1(n(), f(), i(), list, this.f10161h, o(), g());
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a1 a1Var = (a1) it.next();
            a1.a aVarB = a1Var.b();
            a1.a aVar = a1.a.DESCENDING;
            if (aVarB == aVar) {
                aVar = a1.a.ASCENDING;
            }
            arrayList.add(a1.d(aVar, a1Var.c()));
        }
        i iVar = this.f10164k;
        i iVar2 = iVar != null ? new i(iVar.b(), this.f10164k.c()) : null;
        i iVar3 = this.f10163j;
        return new g1(n(), f(), i(), arrayList, this.f10161h, iVar2, iVar3 != null ? new i(iVar3.b(), this.f10163j.c()) : null);
    }

    public b1 a(j9.t tVar) {
        return new b1(tVar, null, this.f10158e, this.f10154a, this.f10161h, this.f10162i, this.f10163j, this.f10164k);
    }

    public Comparator c() {
        return new b(m());
    }

    public b1 d(i iVar) {
        return new b1(this.f10159f, this.f10160g, this.f10158e, this.f10154a, this.f10161h, this.f10162i, this.f10163j, iVar);
    }

    public b1 e(q qVar) {
        n9.b.d(!r(), "No filter is allowed for document query", new Object[0]);
        ArrayList arrayList = new ArrayList(this.f10158e);
        arrayList.add(qVar);
        return new b1(this.f10159f, this.f10160g, arrayList, this.f10154a, this.f10161h, this.f10162i, this.f10163j, this.f10164k);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b1.class != obj.getClass()) {
            return false;
        }
        b1 b1Var = (b1) obj;
        if (this.f10162i != b1Var.f10162i) {
            return false;
        }
        return D().equals(b1Var.D());
    }

    public String f() {
        return this.f10160g;
    }

    public i g() {
        return this.f10164k;
    }

    public List h() {
        return this.f10154a;
    }

    public int hashCode() {
        return (D().hashCode() * 31) + this.f10162i.hashCode();
    }

    public List i() {
        return this.f10158e;
    }

    public SortedSet j() {
        TreeSet treeSet = new TreeSet();
        Iterator it = i().iterator();
        while (it.hasNext()) {
            for (p pVar : ((q) it.next()).c()) {
                if (pVar.i()) {
                    treeSet.add(pVar.f());
                }
            }
        }
        return treeSet;
    }

    public long k() {
        return this.f10161h;
    }

    public a l() {
        return this.f10162i;
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:506)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:509)
        */
    public synchronized java.util.List m() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.List r0 = r6.f10155b     // Catch: java.lang.Throwable -> L2e
            if (r0 != 0) goto L9b
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L2e
            r0.<init>()     // Catch: java.lang.Throwable -> L2e
            java.util.HashSet r1 = new java.util.HashSet     // Catch: java.lang.Throwable -> L2e
            r1.<init>()     // Catch: java.lang.Throwable -> L2e
            java.util.List r2 = r6.f10154a     // Catch: java.lang.Throwable -> L2e
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L2e
        L15:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L30
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L2e
            g9.a1 r3 = (g9.a1) r3     // Catch: java.lang.Throwable -> L2e
            r0.add(r3)     // Catch: java.lang.Throwable -> L2e
            j9.q r3 = r3.f10143b     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = r3.c()     // Catch: java.lang.Throwable -> L2e
            r1.add(r3)     // Catch: java.lang.Throwable -> L2e
            goto L15
        L2e:
            r0 = move-exception
            goto L9f
        L30:
            java.util.List r2 = r6.f10154a     // Catch: java.lang.Throwable -> L2e
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L2e
            if (r2 <= 0) goto L4b
            java.util.List r2 = r6.f10154a     // Catch: java.lang.Throwable -> L2e
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L2e
            int r3 = r3 + (-1)
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L2e
            g9.a1 r2 = (g9.a1) r2     // Catch: java.lang.Throwable -> L2e
            g9.a1$a r2 = r2.b()     // Catch: java.lang.Throwable -> L2e
            goto L4d
        L4b:
            g9.a1$a r2 = g9.a1.a.ASCENDING     // Catch: java.lang.Throwable -> L2e
        L4d:
            java.util.SortedSet r3 = r6.j()     // Catch: java.lang.Throwable -> L2e
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L2e
        L55:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L2e
            if (r4 == 0) goto L79
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L2e
            j9.q r4 = (j9.q) r4     // Catch: java.lang.Throwable -> L2e
            java.lang.String r5 = r4.c()     // Catch: java.lang.Throwable -> L2e
            boolean r5 = r1.contains(r5)     // Catch: java.lang.Throwable -> L2e
            if (r5 != 0) goto L55
            boolean r5 = r4.G()     // Catch: java.lang.Throwable -> L2e
            if (r5 != 0) goto L55
            g9.a1 r4 = g9.a1.d(r2, r4)     // Catch: java.lang.Throwable -> L2e
            r0.add(r4)     // Catch: java.lang.Throwable -> L2e
            goto L55
        L79:
            j9.q r3 = j9.q.f14256b     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = r3.c()     // Catch: java.lang.Throwable -> L2e
            boolean r1 = r1.contains(r3)     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L95
            g9.a1$a r1 = g9.a1.a.ASCENDING     // Catch: java.lang.Throwable -> L2e
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L90
            g9.a1 r1 = g9.b1.f10152l     // Catch: java.lang.Throwable -> L2e
            goto L92
        L90:
            g9.a1 r1 = g9.b1.f10153m     // Catch: java.lang.Throwable -> L2e
        L92:
            r0.add(r1)     // Catch: java.lang.Throwable -> L2e
        L95:
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)     // Catch: java.lang.Throwable -> L2e
            r6.f10155b = r0     // Catch: java.lang.Throwable -> L2e
        L9b:
            java.util.List r0 = r6.f10155b     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r6)
            return r0
        L9f:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.b1.m():java.util.List");
    }

    public j9.t n() {
        return this.f10159f;
    }

    public i o() {
        return this.f10163j;
    }

    public boolean p() {
        return this.f10161h != -1;
    }

    public boolean q() {
        return this.f10160g != null;
    }

    public boolean r() {
        return j9.k.v(this.f10159f) && this.f10160g == null && this.f10158e.isEmpty();
    }

    public b1 s(long j10) {
        return new b1(this.f10159f, this.f10160g, this.f10158e, this.f10154a, j10, a.LIMIT_TO_FIRST, this.f10163j, this.f10164k);
    }

    public b1 t(long j10) {
        return new b1(this.f10159f, this.f10160g, this.f10158e, this.f10154a, j10, a.LIMIT_TO_LAST, this.f10163j, this.f10164k);
    }

    public String toString() {
        return "Query(target=" + D().toString() + ";limitType=" + this.f10162i.toString() + ")";
    }

    public boolean u(j9.h hVar) {
        return hVar.b() && z(hVar) && y(hVar) && x(hVar) && w(hVar);
    }

    public boolean v() {
        return this.f10158e.isEmpty() && this.f10161h == -1 && this.f10163j == null && this.f10164k == null && (h().isEmpty() || (h().size() == 1 && ((a1) h().get(0)).f10143b.G()));
    }

    public final boolean w(j9.h hVar) {
        i iVar = this.f10163j;
        if (iVar != null && !iVar.f(m(), hVar)) {
            return false;
        }
        i iVar2 = this.f10164k;
        return iVar2 == null || iVar2.e(m(), hVar);
    }

    public final boolean x(j9.h hVar) {
        Iterator it = this.f10158e.iterator();
        while (it.hasNext()) {
            if (!((q) it.next()).d(hVar)) {
                return false;
            }
        }
        return true;
    }

    public final boolean y(j9.h hVar) {
        for (a1 a1Var : m()) {
            if (!a1Var.c().equals(j9.q.f14256b) && hVar.h(a1Var.f10143b) == null) {
                return false;
            }
        }
        return true;
    }

    public final boolean z(j9.h hVar) {
        j9.t tVarS = hVar.getKey().s();
        return this.f10160g != null ? hVar.getKey().u(this.f10160g) && this.f10159f.s(tVarS) : j9.k.v(this.f10159f) ? this.f10159f.equals(tVarS) : this.f10159f.s(tVarS) && this.f10159f.u() == tVarS.u() - 1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b1(j9.t tVar, String str) {
        List list = Collections.EMPTY_LIST;
        this(tVar, str, list, list, -1L, a.LIMIT_TO_FIRST, null, null);
    }
}
