package p3;

import k3.AbstractC2279m;
import p3.AbstractC2557k;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: p3.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2558l extends AbstractC2557k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22303c;

    public C2558l(Long l8, InterfaceC2560n interfaceC2560n) {
        super(interfaceC2560n);
        this.f22303c = l8.longValue();
    }

    @Override // p3.AbstractC2557k
    public AbstractC2557k.b I() {
        return AbstractC2557k.b.Number;
    }

    @Override // p3.AbstractC2557k
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public int a(C2558l c2558l) {
        return AbstractC2279m.b(this.f22303c, c2558l.f22303c);
    }

    @Override // p3.InterfaceC2560n
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public C2558l c(InterfaceC2560n interfaceC2560n) {
        return new C2558l(Long.valueOf(this.f22303c), interfaceC2560n);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2558l)) {
            return false;
        }
        C2558l c2558l = (C2558l) obj;
        return this.f22303c == c2558l.f22303c && this.f22295a.equals(c2558l.f22295a);
    }

    @Override // p3.InterfaceC2560n
    public Object getValue() {
        return Long.valueOf(this.f22303c);
    }

    public int hashCode() {
        long j8 = this.f22303c;
        return ((int) (j8 ^ (j8 >>> 32))) + this.f22295a.hashCode();
    }

    @Override // p3.InterfaceC2560n
    public String v(InterfaceC2560n.b bVar) {
        return (J(bVar) + "number:") + AbstractC2279m.c(this.f22303c);
    }
}
