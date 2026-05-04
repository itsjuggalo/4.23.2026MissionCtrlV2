package d9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w1 f7972b = new b().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7973a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7974a = 5;

        public w1 a() {
            return new w1(this.f7974a);
        }

        public b b(int i10) {
            if (i10 < 1) {
                throw new IllegalArgumentException("Max attempts must be at least 1");
            }
            this.f7974a = i10;
            return this;
        }
    }

    public int a() {
        return this.f7973a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && w1.class == obj.getClass() && this.f7973a == ((w1) obj).f7973a;
    }

    public int hashCode() {
        return this.f7973a;
    }

    public String toString() {
        return "TransactionOptions{maxAttempts=" + this.f7973a + '}';
    }

    public w1(int i10) {
        this.f7973a = i10;
    }
}
