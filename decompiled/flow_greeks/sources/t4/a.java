package t4;

import t4.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f20729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f20732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f20733f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f20734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f20735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f20736c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f20737d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f20738e;

        @Override // t4.e.a
        public e a() {
            String str = "";
            if (this.f20734a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f20735b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f20736c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f20737d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f20738e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f20734a.longValue(), this.f20735b.intValue(), this.f20736c.intValue(), this.f20737d.longValue(), this.f20738e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // t4.e.a
        public e.a b(int i10) {
            this.f20736c = Integer.valueOf(i10);
            return this;
        }

        @Override // t4.e.a
        public e.a c(long j10) {
            this.f20737d = Long.valueOf(j10);
            return this;
        }

        @Override // t4.e.a
        public e.a d(int i10) {
            this.f20735b = Integer.valueOf(i10);
            return this;
        }

        @Override // t4.e.a
        public e.a e(int i10) {
            this.f20738e = Integer.valueOf(i10);
            return this;
        }

        @Override // t4.e.a
        public e.a f(long j10) {
            this.f20734a = Long.valueOf(j10);
            return this;
        }
    }

    @Override // t4.e
    public int b() {
        return this.f20731d;
    }

    @Override // t4.e
    public long c() {
        return this.f20732e;
    }

    @Override // t4.e
    public int d() {
        return this.f20730c;
    }

    @Override // t4.e
    public int e() {
        return this.f20733f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f20729b == eVar.f() && this.f20730c == eVar.d() && this.f20731d == eVar.b() && this.f20732e == eVar.c() && this.f20733f == eVar.e()) {
                return true;
            }
        }
        return false;
    }

    @Override // t4.e
    public long f() {
        return this.f20729b;
    }

    public int hashCode() {
        long j10 = this.f20729b;
        int i10 = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f20730c) * 1000003) ^ this.f20731d) * 1000003;
        long j11 = this.f20732e;
        return ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f20733f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f20729b + ", loadBatchSize=" + this.f20730c + ", criticalSectionEnterTimeoutMs=" + this.f20731d + ", eventCleanUpAge=" + this.f20732e + ", maxBlobByteSizePerRow=" + this.f20733f + "}";
    }

    public a(long j10, int i10, int i11, long j11, int i12) {
        this.f20729b = j10;
        this.f20730c = i10;
        this.f20731d = i11;
        this.f20732e = j11;
        this.f20733f = i12;
    }
}
