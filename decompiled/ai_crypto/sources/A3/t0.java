package A3;

/* JADX INFO: loaded from: classes.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f234b;

    public t0(boolean z7, boolean z8) {
        this.f233a = z7;
        this.f234b = z8;
    }

    public boolean a() {
        return this.f233a;
    }

    public boolean b() {
        return this.f234b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return this.f233a == t0Var.f233a && this.f234b == t0Var.f234b;
    }

    public int hashCode() {
        return ((this.f233a ? 1 : 0) * 31) + (this.f234b ? 1 : 0);
    }

    public String toString() {
        return "SnapshotMetadata{hasPendingWrites=" + this.f233a + ", isFromCache=" + this.f234b + '}';
    }
}
