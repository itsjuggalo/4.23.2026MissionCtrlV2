package t5;

import t5.L0;

/* JADX INFO: loaded from: classes2.dex */
public final class M0 implements InterfaceC2696q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L0.d f23495a;

    public M0(L0.d dVar) {
        this.f23495a = dVar;
    }

    public static M0 c(L0.d dVar) {
        return new M0(dVar);
    }

    @Override // t5.InterfaceC2696q0
    public Object a() {
        return L0.d(this.f23495a);
    }

    @Override // t5.InterfaceC2696q0
    public Object b(Object obj) {
        L0.f(this.f23495a, obj);
        return null;
    }
}
