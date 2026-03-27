package A3;

/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x0 f247b = new b().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f248a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f249a = 5;

        public x0 a() {
            return new x0(this.f249a);
        }

        public b b(int i7) {
            if (i7 < 1) {
                throw new IllegalArgumentException("Max attempts must be at least 1");
            }
            this.f249a = i7;
            return this;
        }
    }

    public int a() {
        return this.f248a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && x0.class == obj.getClass() && this.f248a == ((x0) obj).f248a;
    }

    public int hashCode() {
        return this.f248a;
    }

    public String toString() {
        return "TransactionOptions{maxAttempts=" + this.f248a + '}';
    }

    public x0(int i7) {
        this.f248a = i7;
    }
}
