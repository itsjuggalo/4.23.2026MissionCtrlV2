package i1;

import i1.AbstractC1298e;

/* JADX INFO: renamed from: i1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1294a extends AbstractC1298e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f12218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12219f;

    /* JADX INFO: renamed from: i1.a$b */
    public static final class b extends AbstractC1298e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f12220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f12221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f12222c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f12223d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f12224e;

        @Override // i1.AbstractC1298e.a
        public AbstractC1298e a() {
            String str = "";
            if (this.f12220a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f12221b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f12222c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f12223d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f12224e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new C1294a(this.f12220a.longValue(), this.f12221b.intValue(), this.f12222c.intValue(), this.f12223d.longValue(), this.f12224e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // i1.AbstractC1298e.a
        public AbstractC1298e.a b(int i4) {
            this.f12222c = Integer.valueOf(i4);
            return this;
        }

        @Override // i1.AbstractC1298e.a
        public AbstractC1298e.a c(long j4) {
            this.f12223d = Long.valueOf(j4);
            return this;
        }

        @Override // i1.AbstractC1298e.a
        public AbstractC1298e.a d(int i4) {
            this.f12221b = Integer.valueOf(i4);
            return this;
        }

        @Override // i1.AbstractC1298e.a
        public AbstractC1298e.a e(int i4) {
            this.f12224e = Integer.valueOf(i4);
            return this;
        }

        @Override // i1.AbstractC1298e.a
        public AbstractC1298e.a f(long j4) {
            this.f12220a = Long.valueOf(j4);
            return this;
        }
    }

    @Override // i1.AbstractC1298e
    public int b() {
        return this.f12217d;
    }

    @Override // i1.AbstractC1298e
    public long c() {
        return this.f12218e;
    }

    @Override // i1.AbstractC1298e
    public int d() {
        return this.f12216c;
    }

    @Override // i1.AbstractC1298e
    public int e() {
        return this.f12219f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC1298e) {
            AbstractC1298e abstractC1298e = (AbstractC1298e) obj;
            if (this.f12215b == abstractC1298e.f() && this.f12216c == abstractC1298e.d() && this.f12217d == abstractC1298e.b() && this.f12218e == abstractC1298e.c() && this.f12219f == abstractC1298e.e()) {
                return true;
            }
        }
        return false;
    }

    @Override // i1.AbstractC1298e
    public long f() {
        return this.f12215b;
    }

    public int hashCode() {
        long j4 = this.f12215b;
        int i4 = (((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f12216c) * 1000003) ^ this.f12217d) * 1000003;
        long j5 = this.f12218e;
        return ((i4 ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003) ^ this.f12219f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f12215b + ", loadBatchSize=" + this.f12216c + ", criticalSectionEnterTimeoutMs=" + this.f12217d + ", eventCleanUpAge=" + this.f12218e + ", maxBlobByteSizePerRow=" + this.f12219f + "}";
    }

    public C1294a(long j4, int i4, int i5, long j5, int i6) {
        this.f12215b = j4;
        this.f12216c = i4;
        this.f12217d = i5;
        this.f12218e = j5;
        this.f12219f = i6;
    }
}
