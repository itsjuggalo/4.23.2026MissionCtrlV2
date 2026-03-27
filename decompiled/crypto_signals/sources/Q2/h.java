package Q2;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final A.d f2672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final A2.e f2673c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f2674a;

    static {
        A.d dVar = new A.d(6);
        f2672b = dVar;
        f2673c = new A2.e(Collections.EMPTY_LIST, dVar);
    }

    public h(m mVar) {
        D1.b.w("Not a document key path: %s", e(mVar), mVar);
        this.f2674a = mVar;
    }

    public static h b() {
        List list = Collections.EMPTY_LIST;
        m mVar = m.f2686b;
        return new h(list.isEmpty() ? m.f2686b : new m(list));
    }

    public static h c(String str) {
        m mVarL = m.l(str);
        boolean z6 = false;
        if (mVarL.f2668a.size() > 4 && mVarL.g(0).equals("projects") && mVarL.g(2).equals("databases") && mVarL.g(4).equals("documents")) {
            z6 = true;
        }
        D1.b.w("Tried to parse an invalid key: %s", z6, mVarL);
        return new h((m) mVarL.j());
    }

    public static boolean e(m mVar) {
        return mVar.f2668a.size() % 2 == 0;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(h hVar) {
        return this.f2674a.compareTo(hVar.f2674a);
    }

    public final m d() {
        return (m) this.f2674a.k();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return this.f2674a.equals(((h) obj).f2674a);
    }

    public final int hashCode() {
        return this.f2674a.hashCode();
    }

    public final String toString() {
        return this.f2674a.c();
    }
}
