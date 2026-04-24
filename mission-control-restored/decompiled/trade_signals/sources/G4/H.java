package G4;

import F4.AbstractC0497k;
import F4.C0489c;
import G4.InterfaceC0551s;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public class H implements InterfaceC0553t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F4.j0 f2501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0551s.a f2502b;

    public H(F4.j0 j0Var, InterfaceC0551s.a aVar) {
        AbstractC2848n.e(!j0Var.p(), "error must not be OK");
        this.f2501a = j0Var;
        this.f2502b = aVar;
    }

    @Override // G4.InterfaceC0553t
    public r e(F4.Y y7, F4.X x8, C0489c c0489c, AbstractC0497k[] abstractC0497kArr) {
        return new G(this.f2501a, this.f2502b, abstractC0497kArr);
    }

    @Override // F4.N
    public F4.J h() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}
