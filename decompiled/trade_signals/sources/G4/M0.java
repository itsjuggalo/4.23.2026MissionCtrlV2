package G4;

import G4.L0;

/* JADX INFO: loaded from: classes2.dex */
public final class M0 implements InterfaceC0549q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L0.d f2532a;

    public M0(L0.d dVar) {
        this.f2532a = dVar;
    }

    public static M0 c(L0.d dVar) {
        return new M0(dVar);
    }

    @Override // G4.InterfaceC0549q0
    public Object a() {
        return L0.d(this.f2532a);
    }

    @Override // G4.InterfaceC0549q0
    public Object b(Object obj) {
        L0.f(this.f2532a, obj);
        return null;
    }
}
