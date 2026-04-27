package X5;

import h6.InterfaceC1892a;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class B extends u implements h6.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6.c f9392a;

    public B(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        this.f9392a = fqName;
    }

    @Override // h6.u
    public Collection G(B5.k nameFilter) {
        AbstractC2304t.f(nameFilter, "nameFilter");
        return AbstractC2595q.i();
    }

    @Override // h6.InterfaceC1895d
    public InterfaceC1892a b(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        return null;
    }

    @Override // h6.u
    public q6.c e() {
        return this.f9392a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof B) && AbstractC2304t.b(e(), ((B) obj).e());
    }

    public int hashCode() {
        return e().hashCode();
    }

    @Override // h6.InterfaceC1895d
    public boolean i() {
        return false;
    }

    public String toString() {
        return B.class.getName() + ": " + e();
    }

    @Override // h6.u
    public Collection y() {
        return AbstractC2595q.i();
    }

    @Override // h6.InterfaceC1895d
    public List getAnnotations() {
        return AbstractC2595q.i();
    }
}
