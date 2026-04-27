package p3;

import java.util.Map;
import k3.AbstractC2279m;
import p3.AbstractC2557k;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: p3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2551e extends AbstractC2557k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f22287c;

    public C2551e(Map map, InterfaceC2560n interfaceC2560n) {
        super(interfaceC2560n);
        this.f22287c = map;
    }

    @Override // p3.AbstractC2557k
    public AbstractC2557k.b I() {
        return AbstractC2557k.b.DeferredValue;
    }

    @Override // p3.AbstractC2557k
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public int a(C2551e c2551e) {
        return 0;
    }

    @Override // p3.InterfaceC2560n
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public C2551e c(InterfaceC2560n interfaceC2560n) {
        AbstractC2279m.f(AbstractC2564r.b(interfaceC2560n));
        return new C2551e(this.f22287c, interfaceC2560n);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2551e)) {
            return false;
        }
        C2551e c2551e = (C2551e) obj;
        return this.f22287c.equals(c2551e.f22287c) && this.f22295a.equals(c2551e.f22295a);
    }

    @Override // p3.InterfaceC2560n
    public Object getValue() {
        return this.f22287c;
    }

    public int hashCode() {
        return this.f22287c.hashCode() + this.f22295a.hashCode();
    }

    @Override // p3.InterfaceC2560n
    public String v(InterfaceC2560n.b bVar) {
        return J(bVar) + "deferredValue:" + this.f22287c;
    }
}
