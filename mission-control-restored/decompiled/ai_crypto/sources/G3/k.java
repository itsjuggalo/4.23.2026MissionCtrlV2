package G3;

import K3.AbstractC0612b;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Comparator f2441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r3.e f2442c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f2443a;

    static {
        Comparator comparator = new Comparator() { // from class: G3.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((k) obj).compareTo((k) obj2);
            }
        };
        f2441b = comparator;
        f2442c = new r3.e(Collections.emptyList(), comparator);
    }

    public k(t tVar) {
        AbstractC0612b.d(q(tVar), "Not a document key path: %s", tVar);
        this.f2443a = tVar;
    }

    public static Comparator a() {
        return f2441b;
    }

    public static k c() {
        return k(Collections.emptyList());
    }

    public static r3.e h() {
        return f2442c;
    }

    public static k i(String str) {
        t tVarV = t.v(str);
        boolean z7 = false;
        if (tVarV.q() > 4 && tVarV.m(0).equals("projects") && tVarV.m(2).equals("databases") && tVarV.m(4).equals("documents")) {
            z7 = true;
        }
        AbstractC0612b.d(z7, "Tried to parse an invalid key: %s", tVarV);
        return j((t) tVarV.r(5));
    }

    public static k j(t tVar) {
        return new k(tVar);
    }

    public static k k(List list) {
        return new k(t.u(list));
    }

    public static boolean q(t tVar) {
        return tVar.q() % 2 == 0;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(k kVar) {
        return this.f2443a.compareTo(kVar.f2443a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        return this.f2443a.equals(((k) obj).f2443a);
    }

    public int hashCode() {
        return this.f2443a.hashCode();
    }

    public String l() {
        return this.f2443a.m(r0.q() - 2);
    }

    public t m() {
        return (t) this.f2443a.s();
    }

    public String n() {
        return this.f2443a.l();
    }

    public t o() {
        return this.f2443a;
    }

    public boolean p(String str) {
        if (this.f2443a.q() >= 2) {
            t tVar = this.f2443a;
            if (((String) tVar.f2435a.get(tVar.q() - 2)).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.f2443a.toString();
    }
}
