package b6;

/* JADX INFO: renamed from: b6.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1068f0 implements InterfaceC1091r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9059a;

    public C1068f0(boolean z7) {
        this.f9059a = z7;
    }

    @Override // b6.InterfaceC1091r0
    public J0 d() {
        return null;
    }

    @Override // b6.InterfaceC1091r0
    public boolean isActive() {
        return this.f9059a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
