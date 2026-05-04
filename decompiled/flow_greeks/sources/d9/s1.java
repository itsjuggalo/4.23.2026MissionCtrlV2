package d9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7936b;

    public s1(boolean z10, boolean z11) {
        this.f7935a = z10;
        this.f7936b = z11;
    }

    public boolean a() {
        return this.f7935a;
    }

    public boolean b() {
        return this.f7936b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s1)) {
            return false;
        }
        s1 s1Var = (s1) obj;
        return this.f7935a == s1Var.f7935a && this.f7936b == s1Var.f7936b;
    }

    public int hashCode() {
        return ((this.f7935a ? 1 : 0) * 31) + (this.f7936b ? 1 : 0);
    }

    public String toString() {
        return "SnapshotMetadata{hasPendingWrites=" + this.f7935a + ", isFromCache=" + this.f7936b + '}';
    }
}
