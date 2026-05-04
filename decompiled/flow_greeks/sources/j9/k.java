package j9;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Comparator f14242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g8.e f14243c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f14244a;

    static {
        Comparator comparator = new Comparator() { // from class: j9.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((k) obj).compareTo((k) obj2);
            }
        };
        f14242b = comparator;
        f14243c = new g8.e(Collections.EMPTY_LIST, comparator);
    }

    public k(t tVar) {
        n9.b.d(v(tVar), "Not a document key path: %s", tVar);
        this.f14244a = tVar;
    }

    public static Comparator a() {
        return f14242b;
    }

    public static k c() {
        return l(Collections.EMPTY_LIST);
    }

    public static g8.e h() {
        return f14243c;
    }

    public static k i(String str) {
        t tVarB = t.B(str);
        boolean z10 = false;
        if (tVarB.u() > 4 && tVarB.o(0).equals("projects") && tVarB.o(2).equals("databases") && tVarB.o(4).equals("documents")) {
            z10 = true;
        }
        n9.b.d(z10, "Tried to parse an invalid key: %s", tVarB);
        return k((t) tVarB.v(5));
    }

    public static k k(t tVar) {
        return new k(tVar);
    }

    public static k l(List list) {
        return new k(t.A(list));
    }

    public static boolean v(t tVar) {
        return tVar.u() % 2 == 0;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(k kVar) {
        return this.f14244a.compareTo(kVar.f14244a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        return this.f14244a.equals(((k) obj).f14244a);
    }

    public int hashCode() {
        return this.f14244a.hashCode();
    }

    public String m() {
        return this.f14244a.o(r0.u() - 2);
    }

    public t o() {
        return (t) this.f14244a.w();
    }

    public String q() {
        return this.f14244a.m();
    }

    public t s() {
        return this.f14244a;
    }

    public String toString() {
        return this.f14244a.toString();
    }

    public boolean u(String str) {
        if (this.f14244a.u() < 2) {
            return false;
        }
        t tVar = this.f14244a;
        return ((String) tVar.f14236a.get(tVar.u() - 2)).equals(str);
    }
}
