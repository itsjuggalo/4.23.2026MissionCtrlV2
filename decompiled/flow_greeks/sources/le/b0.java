package le;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends u implements ve.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ef.c f15601a;

    public b0(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        this.f15601a = fqName;
    }

    @Override // ve.d
    public ve.a b(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        return null;
    }

    @Override // ve.u
    public ef.c e() {
        return this.f15601a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b0) && kotlin.jvm.internal.t.b(e(), ((b0) obj).e());
    }

    @Override // ve.u
    public Collection h(pd.k nameFilter) {
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        return dd.r.k();
    }

    public int hashCode() {
        return e().hashCode();
    }

    @Override // ve.d
    public boolean n() {
        return false;
    }

    public String toString() {
        return b0.class.getName() + ": " + e();
    }

    @Override // ve.u
    public Collection z() {
        return dd.r.k();
    }

    @Override // ve.d
    public List getAnnotations() {
        return dd.r.k();
    }
}
