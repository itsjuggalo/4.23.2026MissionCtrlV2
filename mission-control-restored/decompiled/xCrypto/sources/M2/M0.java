package M2;

import M2.L0;

/* JADX INFO: loaded from: classes3.dex */
public final class M0 implements InterfaceC0441q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L0.d f1944a;

    public M0(L0.d dVar) {
        this.f1944a = dVar;
    }

    public static M0 c(L0.d dVar) {
        return new M0(dVar);
    }

    @Override // M2.InterfaceC0441q0
    public Object a() {
        return L0.d(this.f1944a);
    }

    @Override // M2.InterfaceC0441q0
    public Object b(Object obj) {
        L0.f(this.f1944a, obj);
        return null;
    }
}
