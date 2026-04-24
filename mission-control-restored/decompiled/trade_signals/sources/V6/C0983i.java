package V6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: V6.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0983i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H5.d f9009b;

    public C0983i(String value, H5.d range) {
        AbstractC2304t.f(value, "value");
        AbstractC2304t.f(range, "range");
        this.f9008a = value;
        this.f9009b = range;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0983i)) {
            return false;
        }
        C0983i c0983i = (C0983i) obj;
        return AbstractC2304t.b(this.f9008a, c0983i.f9008a) && AbstractC2304t.b(this.f9009b, c0983i.f9009b);
    }

    public int hashCode() {
        return (this.f9008a.hashCode() * 31) + this.f9009b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f9008a + ", range=" + this.f9009b + ')';
    }
}
