package Y6;

import s5.InterfaceC2707e;
import t5.AbstractC2751c;

/* JADX INFO: renamed from: Y6.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1035w extends A0 implements InterfaceC1034v {
    public C1035w(InterfaceC1033u0 interfaceC1033u0) {
        super(true);
        l0(interfaceC1033u0);
    }

    @Override // Y6.T
    public Object O(InterfaceC2707e interfaceC2707e) throws Throwable {
        Object objX = x(interfaceC2707e);
        AbstractC2751c.f();
        return objX;
    }

    @Override // Y6.InterfaceC1034v
    public boolean T(Throwable th) {
        return q0(new A(th, false, 2, null));
    }

    @Override // Y6.InterfaceC1034v
    public boolean X(Object obj) {
        return q0(obj);
    }

    @Override // Y6.A0
    public boolean a0() {
        return true;
    }

    @Override // Y6.T
    public Object f() {
        return U();
    }
}
