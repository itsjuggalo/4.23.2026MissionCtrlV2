package c3;

import h3.C1859C;
import h3.C1875k;
import h3.t;
import k3.AbstractC2280n;
import l3.AbstractC2334a;
import p3.AbstractC2561o;
import p3.C2548b;
import p3.InterfaceC2560n;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f13385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1875k f13386b;

    public m(t tVar, C1875k c1875k) {
        this.f13385a = tVar;
        this.f13386b = c1875k;
        C1859C.g(c1875k, c());
    }

    public String a() {
        if (this.f13386b.N() != null) {
            return this.f13386b.N().b();
        }
        return null;
    }

    public InterfaceC2560n b() {
        return this.f13385a.a(this.f13386b);
    }

    public Object c() {
        return b().getValue();
    }

    public void d(Object obj) {
        C1859C.g(this.f13386b, obj);
        Object objB = AbstractC2334a.b(obj);
        AbstractC2280n.k(objB);
        this.f13385a.c(this.f13386b, AbstractC2561o.a(objB));
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.f13385a.equals(mVar.f13385a) && this.f13386b.equals(mVar.f13386b)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        C2548b c2548bP = this.f13386b.P();
        StringBuilder sb = new StringBuilder();
        sb.append("MutableData { key = ");
        sb.append(c2548bP != null ? c2548bP.b() : "<none>");
        sb.append(", value = ");
        sb.append(this.f13385a.b().D(true));
        sb.append(" }");
        return sb.toString();
    }

    public m(InterfaceC2560n interfaceC2560n) {
        this(new t(interfaceC2560n), new C1875k(""));
    }
}
