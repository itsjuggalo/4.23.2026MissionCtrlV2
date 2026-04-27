package y3;

import a3.AbstractC0786b;
import b3.InterfaceC0867e;
import t3.AbstractC1802a;

/* JADX INFO: loaded from: classes3.dex */
public class B extends AbstractC1802a implements InterfaceC0867e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Z2.e f15953d;

    public B(Z2.i iVar, Z2.e eVar) {
        super(iVar, true, true);
        this.f15953d = eVar;
    }

    @Override // t3.AbstractC1802a
    public void K0(Object obj) {
        Z2.e eVar = this.f15953d;
        eVar.resumeWith(t3.G.a(obj, eVar));
    }

    @Override // t3.E0
    public final boolean f0() {
        return true;
    }

    @Override // b3.InterfaceC0867e
    public final InterfaceC0867e getCallerFrame() {
        Z2.e eVar = this.f15953d;
        if (eVar instanceof InterfaceC0867e) {
            return (InterfaceC0867e) eVar;
        }
        return null;
    }

    @Override // t3.E0
    public void y(Object obj) {
        AbstractC1957k.c(AbstractC0786b.c(this.f15953d), t3.G.a(obj, this.f15953d), null, 2, null);
    }
}
