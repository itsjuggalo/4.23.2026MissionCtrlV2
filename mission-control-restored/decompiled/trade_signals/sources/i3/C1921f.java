package i3;

import h3.C1875k;
import i3.AbstractC1919d;
import p3.C2548b;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: i3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1921f extends AbstractC1919d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2560n f18799d;

    public C1921f(C1920e c1920e, C1875k c1875k, InterfaceC2560n interfaceC2560n) {
        super(AbstractC1919d.a.Overwrite, c1920e, c1875k);
        this.f18799d = interfaceC2560n;
    }

    @Override // i3.AbstractC1919d
    public AbstractC1919d d(C2548b c2548b) {
        return this.f18785c.isEmpty() ? new C1921f(this.f18784b, C1875k.O(), this.f18799d.z(c2548b)) : new C1921f(this.f18784b, this.f18785c.S(), this.f18799d);
    }

    public InterfaceC2560n e() {
        return this.f18799d;
    }

    public String toString() {
        return String.format("Overwrite { path=%s, source=%s, snapshot=%s }", a(), b(), this.f18799d);
    }
}
