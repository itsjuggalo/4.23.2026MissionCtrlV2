package H1;

import H1.AbstractC0587e;

/* JADX INFO: renamed from: H1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0583a extends AbstractC0587e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3614f;

    /* JADX INFO: renamed from: H1.a$b */
    public static final class b extends AbstractC0587e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f3615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f3616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f3617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f3618d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f3619e;

        @Override // H1.AbstractC0587e.a
        public AbstractC0587e a() {
            String str = "";
            if (this.f3615a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f3616b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f3617c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f3618d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f3619e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new C0583a(this.f3615a.longValue(), this.f3616b.intValue(), this.f3617c.intValue(), this.f3618d.longValue(), this.f3619e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // H1.AbstractC0587e.a
        public AbstractC0587e.a b(int i8) {
            this.f3617c = Integer.valueOf(i8);
            return this;
        }

        @Override // H1.AbstractC0587e.a
        public AbstractC0587e.a c(long j8) {
            this.f3618d = Long.valueOf(j8);
            return this;
        }

        @Override // H1.AbstractC0587e.a
        public AbstractC0587e.a d(int i8) {
            this.f3616b = Integer.valueOf(i8);
            return this;
        }

        @Override // H1.AbstractC0587e.a
        public AbstractC0587e.a e(int i8) {
            this.f3619e = Integer.valueOf(i8);
            return this;
        }

        @Override // H1.AbstractC0587e.a
        public AbstractC0587e.a f(long j8) {
            this.f3615a = Long.valueOf(j8);
            return this;
        }
    }

    public C0583a(long j8, int i8, int i9, long j9, int i10) {
        this.f3610b = j8;
        this.f3611c = i8;
        this.f3612d = i9;
        this.f3613e = j9;
        this.f3614f = i10;
    }

    @Override // H1.AbstractC0587e
    public int b() {
        return this.f3612d;
    }

    @Override // H1.AbstractC0587e
    public long c() {
        return this.f3613e;
    }

    @Override // H1.AbstractC0587e
    public int d() {
        return this.f3611c;
    }

    @Override // H1.AbstractC0587e
    public int e() {
        return this.f3614f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0587e)) {
            return false;
        }
        AbstractC0587e abstractC0587e = (AbstractC0587e) obj;
        return this.f3610b == abstractC0587e.f() && this.f3611c == abstractC0587e.d() && this.f3612d == abstractC0587e.b() && this.f3613e == abstractC0587e.c() && this.f3614f == abstractC0587e.e();
    }

    @Override // H1.AbstractC0587e
    public long f() {
        return this.f3610b;
    }

    public int hashCode() {
        long j8 = this.f3610b;
        int i8 = (((((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ this.f3611c) * 1000003) ^ this.f3612d) * 1000003;
        long j9 = this.f3613e;
        return ((i8 ^ ((int) ((j9 >>> 32) ^ j9))) * 1000003) ^ this.f3614f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f3610b + ", loadBatchSize=" + this.f3611c + ", criticalSectionEnterTimeoutMs=" + this.f3612d + ", eventCleanUpAge=" + this.f3613e + ", maxBlobByteSizePerRow=" + this.f3614f + "}";
    }
}
