package i9;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Comparator f11901c = new Comparator() { // from class: i9.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return e.b((e) obj, (e) obj2);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Comparator f11902d = new Comparator() { // from class: i9.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return e.a((e) obj, (e) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j9.k f11903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11904b;

    public e(j9.k kVar, int i10) {
        this.f11903a = kVar;
        this.f11904b = i10;
    }

    public static /* synthetic */ int a(e eVar, e eVar2) {
        int iCompare = Integer.compare(eVar.f11904b, eVar2.f11904b);
        return iCompare != 0 ? iCompare : eVar.f11903a.compareTo(eVar2.f11903a);
    }

    public static /* synthetic */ int b(e eVar, e eVar2) {
        int iCompareTo = eVar.f11903a.compareTo(eVar2.f11903a);
        return iCompareTo != 0 ? iCompareTo : Integer.compare(eVar.f11904b, eVar2.f11904b);
    }

    public int c() {
        return this.f11904b;
    }

    public j9.k d() {
        return this.f11903a;
    }
}
