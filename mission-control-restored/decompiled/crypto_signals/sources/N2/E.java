package N2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C f1911l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C f1912m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f1914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public K f1915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public K f1916d;
    public final List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Q2.m f1917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f1919h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C0155d f1920j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0155d f1921k;

    static {
        Q2.j jVar = Q2.j.f2677b;
        f1911l = new C(1, jVar);
        f1912m = new C(2, jVar);
    }

    public E(Q2.m mVar, String str, List list, List list2, long j4, int i, C0155d c0155d, C0155d c0155d2) {
        this.f1917f = mVar;
        this.f1918g = str;
        this.f1913a = list2;
        this.e = list;
        this.f1919h = j4;
        this.i = i;
        this.f1920j = c0155d;
        this.f1921k = c0155d2;
    }

    public final D a() {
        return new D(d());
    }

    public final E b(AbstractC0163l abstractC0163l) {
        D1.b.w("No filter is allowed for document query", !e(), new Object[0]);
        ArrayList arrayList = new ArrayList(this.e);
        arrayList.add(abstractC0163l);
        return new E(this.f1917f, this.f1918g, arrayList, this.f1913a, this.f1919h, this.i, this.f1920j, this.f1921k);
    }

    public final TreeSet c() {
        TreeSet treeSet = new TreeSet();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            for (C0162k c0162k : ((AbstractC0163l) it.next()).c()) {
                if (c0162k.f()) {
                    treeSet.add(c0162k.f2020c);
                }
            }
        }
        return treeSet;
    }

    public final synchronized List d() {
        int i;
        try {
            if (this.f1914b == null) {
                ArrayList arrayList = new ArrayList();
                HashSet hashSet = new HashSet();
                for (C c6 : this.f1913a) {
                    arrayList.add(c6);
                    hashSet.add(c6.f1908b.c());
                }
                if (this.f1913a.size() > 0) {
                    List list = this.f1913a;
                    i = ((C) list.get(list.size() - 1)).f1907a;
                } else {
                    i = 1;
                }
                for (Q2.j jVar : c()) {
                    if (!hashSet.contains(jVar.c()) && !jVar.equals(Q2.j.f2677b)) {
                        arrayList.add(new C(i, jVar));
                    }
                }
                if (!hashSet.contains(Q2.j.f2677b.c())) {
                    arrayList.add(S.i.b(i, 1) ? f1911l : f1912m);
                }
                this.f1914b = Collections.unmodifiableList(arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f1914b;
    }

    public final boolean e() {
        return Q2.h.e(this.f1917f) && this.f1918g == null && this.e.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || E.class != obj.getClass()) {
            return false;
        }
        E e = (E) obj;
        if (this.i != e.i) {
            return false;
        }
        return i().equals(e.i());
    }

    public final E f(long j4) {
        return new E(this.f1917f, this.f1918g, this.e, this.f1913a, j4, 1, this.f1920j, this.f1921k);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d5 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(Q2.k r9) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.E.g(Q2.k):boolean");
    }

    public final boolean h() {
        if (this.e.isEmpty() && this.f1919h == -1 && this.f1920j == null && this.f1921k == null) {
            List list = this.f1913a;
            if (list.isEmpty() || (list.size() == 1 && ((C) list.get(0)).f1908b.equals(Q2.j.f2677b))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return S.i.c(this.i) + (i().hashCode() * 31);
    }

    public final synchronized K i() {
        try {
            if (this.f1915c == null) {
                this.f1915c = j(d());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f1915c;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.List] */
    public final synchronized K j(List list) {
        if (this.i == 1) {
            return new K(this.f1917f, this.f1918g, this.e, list, this.f1919h, this.f1920j, this.f1921k);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C c6 = (C) it.next();
            int i = 2;
            if (c6.f1907a == 2) {
                i = 1;
            }
            arrayList.add(new C(i, c6.f1908b));
        }
        C0155d c0155d = this.f1921k;
        C0155d c0155d2 = c0155d != null ? new C0155d(c0155d.f1991b, c0155d.f1990a) : null;
        C0155d c0155d3 = this.f1920j;
        return new K(this.f1917f, this.f1918g, this.e, arrayList, this.f1919h, c0155d2, c0155d3 != null ? new C0155d(c0155d3.f1991b, c0155d3.f1990a) : null);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Query(target=");
        sb.append(i().toString());
        sb.append(";limitType=");
        int i = this.i;
        if (i == 1) {
            str = "LIMIT_TO_FIRST";
        } else {
            if (i != 2) {
                throw null;
            }
            str = "LIMIT_TO_LAST";
        }
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public E(Q2.m mVar, String str) {
        List list = Collections.EMPTY_LIST;
        this(mVar, str, list, list, -1L, 1, null, null);
    }
}
