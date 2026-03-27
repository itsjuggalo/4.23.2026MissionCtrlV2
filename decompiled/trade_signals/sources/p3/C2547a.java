package p3;

import p3.AbstractC2557k;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: p3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2547a extends AbstractC2557k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f22260c;

    public C2547a(Boolean bool, InterfaceC2560n interfaceC2560n) {
        super(interfaceC2560n);
        this.f22260c = bool.booleanValue();
    }

    @Override // p3.AbstractC2557k
    public AbstractC2557k.b I() {
        return AbstractC2557k.b.Boolean;
    }

    @Override // p3.AbstractC2557k
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public int a(C2547a c2547a) {
        boolean z7 = this.f22260c;
        if (z7 == c2547a.f22260c) {
            return 0;
        }
        return z7 ? 1 : -1;
    }

    @Override // p3.InterfaceC2560n
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public C2547a c(InterfaceC2560n interfaceC2560n) {
        return new C2547a(Boolean.valueOf(this.f22260c), interfaceC2560n);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2547a)) {
            return false;
        }
        C2547a c2547a = (C2547a) obj;
        return this.f22260c == c2547a.f22260c && this.f22295a.equals(c2547a.f22295a);
    }

    @Override // p3.InterfaceC2560n
    public Object getValue() {
        return Boolean.valueOf(this.f22260c);
    }

    public int hashCode() {
        boolean z7 = this.f22260c;
        return (z7 ? 1 : 0) + this.f22295a.hashCode();
    }

    @Override // p3.InterfaceC2560n
    public String v(InterfaceC2560n.b bVar) {
        return J(bVar) + "boolean:" + this.f22260c;
    }
}
