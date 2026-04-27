package Y6;

/* JADX INFO: renamed from: Y6.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1000d0 implements InterfaceC1026q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9657a;

    public C1000d0(boolean z7) {
        this.f9657a = z7;
    }

    @Override // Y6.InterfaceC1026q0
    public boolean c() {
        return this.f9657a;
    }

    @Override // Y6.InterfaceC1026q0
    public F0 d() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(c() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
