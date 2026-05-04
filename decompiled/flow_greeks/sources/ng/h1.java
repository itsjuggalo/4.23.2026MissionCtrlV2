package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h1 implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17138a;

    public h1(boolean z10) {
        this.f17138a = z10;
    }

    @Override // ng.u1
    public j2 b() {
        return null;
    }

    @Override // ng.u1
    public boolean isActive() {
        return this.f17138a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Empty{");
        sb2.append(isActive() ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
