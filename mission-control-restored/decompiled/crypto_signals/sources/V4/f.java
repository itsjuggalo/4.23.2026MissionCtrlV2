package V4;

/* JADX INFO: loaded from: classes.dex */
public final class f extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f3305d = new f(1, 0, 1);

    @Override // V4.d
    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        if (isEmpty() && ((f) obj).isEmpty()) {
            return true;
        }
        f fVar = (f) obj;
        if (this.f3298a == fVar.f3298a) {
            return this.f3299b == fVar.f3299b;
        }
        return false;
    }

    @Override // V4.d
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f3298a * 31) + this.f3299b;
    }

    @Override // V4.d
    public final boolean isEmpty() {
        return this.f3298a > this.f3299b;
    }

    @Override // V4.d
    public final String toString() {
        return this.f3298a + ".." + this.f3299b;
    }
}
