package Y6;

/* JADX INFO: renamed from: Y6.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1030t extends z0 implements InterfaceC1028s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC1032u f9692e;

    public C1030t(InterfaceC1032u interfaceC1032u) {
        this.f9692e = interfaceC1032u;
    }

    @Override // Y6.InterfaceC1028s
    public boolean a(Throwable th) {
        return u().I(th);
    }

    @Override // Y6.InterfaceC1028s
    public InterfaceC1033u0 getParent() {
        return u();
    }

    @Override // Y6.z0
    public boolean v() {
        return true;
    }

    @Override // Y6.z0
    public void w(Throwable th) {
        this.f9692e.Q(u());
    }
}
