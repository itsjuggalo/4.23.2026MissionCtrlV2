package p3;

import k3.AbstractC2279m;
import p3.AbstractC2557k;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: p3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2552f extends AbstractC2557k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Double f22288c;

    public C2552f(Double d8, InterfaceC2560n interfaceC2560n) {
        super(interfaceC2560n);
        this.f22288c = d8;
    }

    @Override // p3.AbstractC2557k
    public AbstractC2557k.b I() {
        return AbstractC2557k.b.Number;
    }

    @Override // p3.AbstractC2557k
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public int a(C2552f c2552f) {
        return this.f22288c.compareTo(c2552f.f22288c);
    }

    @Override // p3.InterfaceC2560n
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public C2552f c(InterfaceC2560n interfaceC2560n) {
        AbstractC2279m.f(AbstractC2564r.b(interfaceC2560n));
        return new C2552f(this.f22288c, interfaceC2560n);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2552f)) {
            return false;
        }
        C2552f c2552f = (C2552f) obj;
        return this.f22288c.equals(c2552f.f22288c) && this.f22295a.equals(c2552f.f22295a);
    }

    @Override // p3.InterfaceC2560n
    public Object getValue() {
        return this.f22288c;
    }

    public int hashCode() {
        return this.f22288c.hashCode() + this.f22295a.hashCode();
    }

    @Override // p3.InterfaceC2560n
    public String v(InterfaceC2560n.b bVar) {
        return (J(bVar) + "number:") + AbstractC2279m.c(this.f22288c.doubleValue());
    }
}
