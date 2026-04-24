package K2;

/* JADX INFO: loaded from: classes.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f942a;

    public k0(int i) {
        this.f942a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && k0.class == obj.getClass() && this.f942a == ((k0) obj).f942a;
    }

    public final int hashCode() {
        return this.f942a;
    }

    public final String toString() {
        return "TransactionOptions{maxAttempts=" + this.f942a + '}';
    }
}
