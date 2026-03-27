package F3;

import java.util.Comparator;

/* JADX INFO: renamed from: F3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0489e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Comparator f2134c = new Comparator() { // from class: F3.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return C0489e.e((C0489e) obj, (C0489e) obj2);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Comparator f2135d = new Comparator() { // from class: F3.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return C0489e.f((C0489e) obj, (C0489e) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G3.k f2136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2137b;

    public C0489e(G3.k kVar, int i7) {
        this.f2136a = kVar;
        this.f2137b = i7;
    }

    public static /* synthetic */ int e(C0489e c0489e, C0489e c0489e2) {
        int iCompareTo = c0489e.f2136a.compareTo(c0489e2.f2136a);
        return iCompareTo != 0 ? iCompareTo : K3.I.l(c0489e.f2137b, c0489e2.f2137b);
    }

    public static /* synthetic */ int f(C0489e c0489e, C0489e c0489e2) {
        int iL = K3.I.l(c0489e.f2137b, c0489e2.f2137b);
        return iL != 0 ? iL : c0489e.f2136a.compareTo(c0489e2.f2136a);
    }

    public int c() {
        return this.f2137b;
    }

    public G3.k d() {
        return this.f2136a;
    }
}
