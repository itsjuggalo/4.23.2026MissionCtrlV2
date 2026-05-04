package kg;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vd.g f14911b;

    public i(String value, vd.g range) {
        kotlin.jvm.internal.t.f(value, "value");
        kotlin.jvm.internal.t.f(range, "range");
        this.f14910a = value;
        this.f14911b = range;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.t.b(this.f14910a, iVar.f14910a) && kotlin.jvm.internal.t.b(this.f14911b, iVar.f14911b);
    }

    public int hashCode() {
        return (this.f14910a.hashCode() * 31) + this.f14911b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f14910a + ", range=" + this.f14911b + ')';
    }
}
