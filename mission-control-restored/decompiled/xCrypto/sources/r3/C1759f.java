package r3;

import o3.C1676g;

/* JADX INFO: renamed from: r3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1759f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1676g f14586b;

    public C1759f(String value, C1676g range) {
        kotlin.jvm.internal.r.f(value, "value");
        kotlin.jvm.internal.r.f(range, "range");
        this.f14585a = value;
        this.f14586b = range;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1759f)) {
            return false;
        }
        C1759f c1759f = (C1759f) obj;
        return kotlin.jvm.internal.r.b(this.f14585a, c1759f.f14585a) && kotlin.jvm.internal.r.b(this.f14586b, c1759f.f14586b);
    }

    public int hashCode() {
        return (this.f14585a.hashCode() * 31) + this.f14586b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f14585a + ", range=" + this.f14586b + ')';
    }
}
