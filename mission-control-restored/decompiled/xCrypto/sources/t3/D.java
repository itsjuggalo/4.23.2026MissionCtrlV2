package t3;

/* JADX INFO: loaded from: classes3.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i3.k f14909b;

    public D(Object obj, i3.k kVar) {
        this.f14908a = obj;
        this.f14909b = kVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d4 = (D) obj;
        return kotlin.jvm.internal.r.b(this.f14908a, d4.f14908a) && kotlin.jvm.internal.r.b(this.f14909b, d4.f14909b);
    }

    public int hashCode() {
        Object obj = this.f14908a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f14909b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f14908a + ", onCancellation=" + this.f14909b + ')';
    }
}
