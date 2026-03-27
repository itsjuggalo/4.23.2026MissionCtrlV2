package a5;

/* JADX INFO: loaded from: classes.dex */
public final class O implements Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4090a;

    public O(boolean z6) {
        this.f4090a = z6;
    }

    @Override // a5.Z
    public final q0 c() {
        return null;
    }

    @Override // a5.Z
    public final boolean isActive() {
        return this.f4090a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.f4090a ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
