package K2;

/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f935b;

    public h0(boolean z6, boolean z7) {
        this.f934a = z6;
        this.f935b = z7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.f934a == h0Var.f934a && this.f935b == h0Var.f935b;
    }

    public final int hashCode() {
        return ((this.f934a ? 1 : 0) * 31) + (this.f935b ? 1 : 0);
    }

    public final String toString() {
        return "SnapshotMetadata{hasPendingWrites=" + this.f934a + ", isFromCache=" + this.f935b + '}';
    }
}
