package z1;

import z1.AbstractC2860e;

/* JADX INFO: renamed from: z1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2856a extends AbstractC2860e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f25991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f25992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f25993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f25994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f25995f;

    /* JADX INFO: renamed from: z1.a$b */
    public static final class b extends AbstractC2860e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f25996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f25997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f25998c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f25999d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f26000e;

        @Override // z1.AbstractC2860e.a
        public AbstractC2860e a() {
            String str = "";
            if (this.f25996a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f25997b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f25998c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f25999d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f26000e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new C2856a(this.f25996a.longValue(), this.f25997b.intValue(), this.f25998c.intValue(), this.f25999d.longValue(), this.f26000e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // z1.AbstractC2860e.a
        public AbstractC2860e.a b(int i7) {
            this.f25998c = Integer.valueOf(i7);
            return this;
        }

        @Override // z1.AbstractC2860e.a
        public AbstractC2860e.a c(long j7) {
            this.f25999d = Long.valueOf(j7);
            return this;
        }

        @Override // z1.AbstractC2860e.a
        public AbstractC2860e.a d(int i7) {
            this.f25997b = Integer.valueOf(i7);
            return this;
        }

        @Override // z1.AbstractC2860e.a
        public AbstractC2860e.a e(int i7) {
            this.f26000e = Integer.valueOf(i7);
            return this;
        }

        @Override // z1.AbstractC2860e.a
        public AbstractC2860e.a f(long j7) {
            this.f25996a = Long.valueOf(j7);
            return this;
        }
    }

    @Override // z1.AbstractC2860e
    public int b() {
        return this.f25993d;
    }

    @Override // z1.AbstractC2860e
    public long c() {
        return this.f25994e;
    }

    @Override // z1.AbstractC2860e
    public int d() {
        return this.f25992c;
    }

    @Override // z1.AbstractC2860e
    public int e() {
        return this.f25995f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2860e)) {
            return false;
        }
        AbstractC2860e abstractC2860e = (AbstractC2860e) obj;
        return this.f25991b == abstractC2860e.f() && this.f25992c == abstractC2860e.d() && this.f25993d == abstractC2860e.b() && this.f25994e == abstractC2860e.c() && this.f25995f == abstractC2860e.e();
    }

    @Override // z1.AbstractC2860e
    public long f() {
        return this.f25991b;
    }

    public int hashCode() {
        long j7 = this.f25991b;
        int i7 = (((((((int) (j7 ^ (j7 >>> 32))) ^ 1000003) * 1000003) ^ this.f25992c) * 1000003) ^ this.f25993d) * 1000003;
        long j8 = this.f25994e;
        return ((i7 ^ ((int) ((j8 >>> 32) ^ j8))) * 1000003) ^ this.f25995f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f25991b + ", loadBatchSize=" + this.f25992c + ", criticalSectionEnterTimeoutMs=" + this.f25993d + ", eventCleanUpAge=" + this.f25994e + ", maxBlobByteSizePerRow=" + this.f25995f + "}";
    }

    public C2856a(long j7, int i7, int i8, long j8, int i9) {
        this.f25991b = j7;
        this.f25992c = i7;
        this.f25993d = i8;
        this.f25994e = j8;
        this.f25995f = i9;
    }
}
