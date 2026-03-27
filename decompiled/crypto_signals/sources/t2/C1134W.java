package t2;

import java.util.List;

/* JADX INFO: renamed from: t2.W, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1134W extends B0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f10035c;

    public C1134W(String str, int i, List list) {
        this.f10033a = str;
        this.f10034b = i;
        this.f10035c = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof B0) {
            B0 b02 = (B0) obj;
            if (this.f10033a.equals(((C1134W) b02).f10033a)) {
                C1134W c1134w = (C1134W) b02;
                if (this.f10034b == c1134w.f10034b && this.f10035c.equals(c1134w.f10035c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f10033a.hashCode() ^ 1000003) * 1000003) ^ this.f10034b) * 1000003) ^ this.f10035c.hashCode();
    }

    public final String toString() {
        return "Thread{name=" + this.f10033a + ", importance=" + this.f10034b + ", frames=" + this.f10035c + "}";
    }
}
