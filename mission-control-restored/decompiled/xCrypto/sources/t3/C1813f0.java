package t3;

/* JADX INFO: renamed from: t3.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1813f0 implements InterfaceC1836r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f15001a;

    public C1813f0(boolean z4) {
        this.f15001a = z4;
    }

    @Override // t3.InterfaceC1836r0
    public J0 a() {
        return null;
    }

    @Override // t3.InterfaceC1836r0
    public boolean isActive() {
        return this.f15001a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
