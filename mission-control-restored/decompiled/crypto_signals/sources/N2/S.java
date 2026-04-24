package N2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f1975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q2.i f1976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Q2.i f1977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f1978d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final A2.e f1979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1981h;
    public final boolean i;

    public S(E e, Q2.i iVar, Q2.i iVar2, ArrayList arrayList, boolean z6, A2.e eVar, boolean z7, boolean z8, boolean z9) {
        this.f1975a = e;
        this.f1976b = iVar;
        this.f1977c = iVar2;
        this.f1978d = arrayList;
        this.e = z6;
        this.f1979f = eVar;
        this.f1980g = z7;
        this.f1981h = z8;
        this.i = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S)) {
            return false;
        }
        S s6 = (S) obj;
        if (this.e == s6.e && this.f1980g == s6.f1980g && this.f1981h == s6.f1981h && this.f1975a.equals(s6.f1975a) && this.f1979f.equals(s6.f1979f) && this.f1976b.equals(s6.f1976b) && this.f1977c.equals(s6.f1977c) && this.i == s6.i) {
            return this.f1978d.equals(s6.f1978d);
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.f1979f.f51a.hashCode() + ((this.f1978d.hashCode() + ((this.f1977c.hashCode() + ((this.f1976b.hashCode() + (this.f1975a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f1980g ? 1 : 0)) * 31) + (this.f1981h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }

    public final String toString() {
        return "ViewSnapshot(" + this.f1975a + ", " + this.f1976b + ", " + this.f1977c + ", " + this.f1978d + ", isFromCache=" + this.e + ", mutatedKeys=" + this.f1979f.f51a.size() + ", didSyncStateChange=" + this.f1980g + ", excludesMetadataChanges=" + this.f1981h + ", hasCachedResults=" + this.i + ")";
    }
}
