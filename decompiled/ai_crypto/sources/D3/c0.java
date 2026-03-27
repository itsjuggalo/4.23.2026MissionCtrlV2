package D3;

import D3.b0;
import K3.AbstractC0612b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b0 f1261l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b0 f1262m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f1264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f1265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h0 f1266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f1267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final G3.t f1268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f1270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f1271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C0439i f1272j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0439i f1273k;

    public enum a {
        LIMIT_TO_FIRST,
        LIMIT_TO_LAST
    }

    public static class b implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f1277a;

        public b(List list) {
            boolean z7;
            Iterator it = list.iterator();
            loop0: while (true) {
                z7 = false;
                while (it.hasNext()) {
                    z7 = (z7 || ((b0) it.next()).c().equals(G3.q.f2455b)) ? true : z7;
                }
            }
            if (!z7) {
                throw new IllegalArgumentException("QueryComparator needs to have a key ordering");
            }
            this.f1277a = list;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(G3.h hVar, G3.h hVar2) {
            Iterator it = this.f1277a.iterator();
            while (it.hasNext()) {
                int iA = ((b0) it.next()).a(hVar, hVar2);
                if (iA != 0) {
                    return iA;
                }
            }
            return 0;
        }
    }

    static {
        b0.a aVar = b0.a.ASCENDING;
        G3.q qVar = G3.q.f2455b;
        f1261l = b0.d(aVar, qVar);
        f1262m = b0.d(b0.a.DESCENDING, qVar);
    }

    public c0(G3.t tVar, String str, List list, List list2, long j7, a aVar, C0439i c0439i, C0439i c0439i2) {
        this.f1268f = tVar;
        this.f1269g = str;
        this.f1263a = list2;
        this.f1267e = list;
        this.f1270h = j7;
        this.f1271i = aVar;
        this.f1272j = c0439i;
        this.f1273k = c0439i2;
    }

    public static c0 b(G3.t tVar) {
        return new c0(tVar, null);
    }

    public c0 A(b0 b0Var) {
        AbstractC0612b.d(!r(), "No ordering is allowed for document query", new Object[0]);
        ArrayList arrayList = new ArrayList(this.f1263a);
        arrayList.add(b0Var);
        return new c0(this.f1268f, this.f1269g, this.f1267e, arrayList, this.f1270h, this.f1271i, this.f1272j, this.f1273k);
    }

    public c0 B(C0439i c0439i) {
        return new c0(this.f1268f, this.f1269g, this.f1267e, this.f1263a, this.f1270h, this.f1271i, c0439i, this.f1273k);
    }

    public synchronized h0 C() {
        try {
            if (this.f1266d == null) {
                this.f1266d = E(this.f1263a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f1266d;
    }

    public synchronized h0 D() {
        try {
            if (this.f1265c == null) {
                this.f1265c = E(m());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f1265c;
    }

    public final synchronized h0 E(List list) {
        if (this.f1271i == a.LIMIT_TO_FIRST) {
            return new h0(n(), f(), i(), list, this.f1270h, o(), g());
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b0 b0Var = (b0) it.next();
            b0.a aVarB = b0Var.b();
            b0.a aVar = b0.a.DESCENDING;
            if (aVarB == aVar) {
                aVar = b0.a.ASCENDING;
            }
            arrayList.add(b0.d(aVar, b0Var.c()));
        }
        C0439i c0439i = this.f1273k;
        C0439i c0439i2 = c0439i != null ? new C0439i(c0439i.b(), this.f1273k.c()) : null;
        C0439i c0439i3 = this.f1272j;
        return new h0(n(), f(), i(), arrayList, this.f1270h, c0439i2, c0439i3 != null ? new C0439i(c0439i3.b(), this.f1272j.c()) : null);
    }

    public c0 a(G3.t tVar) {
        return new c0(tVar, null, this.f1267e, this.f1263a, this.f1270h, this.f1271i, this.f1272j, this.f1273k);
    }

    public Comparator c() {
        return new b(m());
    }

    public c0 d(C0439i c0439i) {
        return new c0(this.f1268f, this.f1269g, this.f1267e, this.f1263a, this.f1270h, this.f1271i, this.f1272j, c0439i);
    }

    public c0 e(AbstractC0447q abstractC0447q) {
        AbstractC0612b.d(!r(), "No filter is allowed for document query", new Object[0]);
        ArrayList arrayList = new ArrayList(this.f1267e);
        arrayList.add(abstractC0447q);
        return new c0(this.f1268f, this.f1269g, arrayList, this.f1263a, this.f1270h, this.f1271i, this.f1272j, this.f1273k);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c0.class != obj.getClass()) {
            return false;
        }
        c0 c0Var = (c0) obj;
        if (this.f1271i != c0Var.f1271i) {
            return false;
        }
        return D().equals(c0Var.D());
    }

    public String f() {
        return this.f1269g;
    }

    public C0439i g() {
        return this.f1273k;
    }

    public List h() {
        return this.f1263a;
    }

    public int hashCode() {
        return (D().hashCode() * 31) + this.f1271i.hashCode();
    }

    public List i() {
        return this.f1267e;
    }

    public SortedSet j() {
        TreeSet treeSet = new TreeSet();
        Iterator it = i().iterator();
        while (it.hasNext()) {
            for (C0446p c0446p : ((AbstractC0447q) it.next()).c()) {
                if (c0446p.i()) {
                    treeSet.add(c0446p.f());
                }
            }
        }
        return treeSet;
    }

    public long k() {
        return this.f1270h;
    }

    public a l() {
        return this.f1271i;
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
            java.util.List r0 = r6.f1264b     // Catch: java.lang.Throwable -> L2e
            if (r0 != 0) goto L9b
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L2e
            r0.<init>()     // Catch: java.lang.Throwable -> L2e
            java.util.HashSet r1 = new java.util.HashSet     // Catch: java.lang.Throwable -> L2e
            r1.<init>()     // Catch: java.lang.Throwable -> L2e
            java.util.List r2 = r6.f1263a     // Catch: java.lang.Throwable -> L2e
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L2e
        L15:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L30
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L2e
            D3.b0 r3 = (D3.b0) r3     // Catch: java.lang.Throwable -> L2e
            r0.add(r3)     // Catch: java.lang.Throwable -> L2e
            G3.q r3 = r3.f1254b     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = r3.c()     // Catch: java.lang.Throwable -> L2e
            r1.add(r3)     // Catch: java.lang.Throwable -> L2e
            goto L15
        L2e:
            r0 = move-exception
            goto L9f
        L30:
            java.util.List r2 = r6.f1263a     // Catch: java.lang.Throwable -> L2e
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L2e
            if (r2 <= 0) goto L4b
            java.util.List r2 = r6.f1263a     // Catch: java.lang.Throwable -> L2e
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L2e
            int r3 = r3 + (-1)
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L2e
            D3.b0 r2 = (D3.b0) r2     // Catch: java.lang.Throwable -> L2e
            D3.b0$a r2 = r2.b()     // Catch: java.lang.Throwable -> L2e
            goto L4d
        L4b:
            D3.b0$a r2 = D3.b0.a.ASCENDING     // Catch: java.lang.Throwable -> L2e
        L4d:
            java.util.SortedSet r3 = r6.j()     // Catch: java.lang.Throwable -> L2e
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L2e
        L55:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L2e
            if (r4 == 0) goto L79
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L2e
            G3.q r4 = (G3.q) r4     // Catch: java.lang.Throwable -> L2e
            java.lang.String r5 = r4.c()     // Catch: java.lang.Throwable -> L2e
            boolean r5 = r1.contains(r5)     // Catch: java.lang.Throwable -> L2e
            if (r5 != 0) goto L55
            boolean r5 = r4.x()     // Catch: java.lang.Throwable -> L2e
            if (r5 != 0) goto L55
            D3.b0 r4 = D3.b0.d(r2, r4)     // Catch: java.lang.Throwable -> L2e
            r0.add(r4)     // Catch: java.lang.Throwable -> L2e
            goto L55
        L79:
            G3.q r3 = G3.q.f2455b     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = r3.c()     // Catch: java.lang.Throwable -> L2e
            boolean r1 = r1.contains(r3)     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L95
            D3.b0$a r1 = D3.b0.a.ASCENDING     // Catch: java.lang.Throwable -> L2e
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L90
            D3.b0 r1 = D3.c0.f1261l     // Catch: java.lang.Throwable -> L2e
            goto L92
        L90:
            D3.b0 r1 = D3.c0.f1262m     // Catch: java.lang.Throwable -> L2e
        L92:
            r0.add(r1)     // Catch: java.lang.Throwable -> L2e
        L95:
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)     // Catch: java.lang.Throwable -> L2e
            r6.f1264b = r0     // Catch: java.lang.Throwable -> L2e
        L9b:
            java.util.List r0 = r6.f1264b     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r6)
            return r0
        L9f:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: D3.c0.m():java.util.List");
    }

    public G3.t n() {
        return this.f1268f;
    }

    public C0439i o() {
        return this.f1272j;
    }

    public boolean p() {
        return this.f1270h != -1;
    }

    public boolean q() {
        return this.f1269g != null;
    }

    public boolean r() {
        return G3.k.q(this.f1268f) && this.f1269g == null && this.f1267e.isEmpty();
    }

    public c0 s(long j7) {
        return new c0(this.f1268f, this.f1269g, this.f1267e, this.f1263a, j7, a.LIMIT_TO_FIRST, this.f1272j, this.f1273k);
    }

    public c0 t(long j7) {
        return new c0(this.f1268f, this.f1269g, this.f1267e, this.f1263a, j7, a.LIMIT_TO_LAST, this.f1272j, this.f1273k);
    }

    public String toString() {
        return "Query(target=" + D().toString() + ";limitType=" + this.f1271i.toString() + ")";
    }

    public boolean u(G3.h hVar) {
        return hVar.b() && z(hVar) && y(hVar) && x(hVar) && w(hVar);
    }

    public boolean v() {
        if (this.f1267e.isEmpty() && this.f1270h == -1 && this.f1272j == null && this.f1273k == null) {
            return h().isEmpty() || (h().size() == 1 && ((b0) h().get(0)).f1254b.x());
        }
        return false;
    }

    public final boolean w(G3.h hVar) {
        C0439i c0439i = this.f1272j;
        if (c0439i != null && !c0439i.f(m(), hVar)) {
            return false;
        }
        C0439i c0439i2 = this.f1273k;
        return c0439i2 == null || c0439i2.e(m(), hVar);
    }

    public final boolean x(G3.h hVar) {
        Iterator it = this.f1267e.iterator();
        while (it.hasNext()) {
            if (!((AbstractC0447q) it.next()).d(hVar)) {
                return false;
            }
        }
        return true;
    }

    public final boolean y(G3.h hVar) {
        for (b0 b0Var : m()) {
            if (!b0Var.c().equals(G3.q.f2455b) && hVar.i(b0Var.f1254b) == null) {
                return false;
            }
        }
        return true;
    }

    public final boolean z(G3.h hVar) {
        G3.t tVarO = hVar.getKey().o();
        return this.f1269g != null ? hVar.getKey().p(this.f1269g) && this.f1268f.p(tVarO) : G3.k.q(this.f1268f) ? this.f1268f.equals(tVarO) : this.f1268f.p(tVarO) && this.f1268f.q() == tVarO.q() - 1;
    }

    public c0(G3.t tVar, String str) {
        this(tVar, str, Collections.emptyList(), Collections.emptyList(), -1L, a.LIMIT_TO_FIRST, null, null);
    }
}
