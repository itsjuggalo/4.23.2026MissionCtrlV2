package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends f0.e.d.a.b.AbstractC0438d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f24602c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.a.b.AbstractC0438d.AbstractC0439a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f24605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte f24606d;

        @Override // x7.f0.e.d.a.b.AbstractC0438d.AbstractC0439a
        public f0.e.d.a.b.AbstractC0438d a() {
            String str;
            String str2;
            if (this.f24606d == 1 && (str = this.f24603a) != null && (str2 = this.f24604b) != null) {
                return new q(str, str2, this.f24605c);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24603a == null) {
                sb2.append(" name");
            }
            if (this.f24604b == null) {
                sb2.append(" code");
            }
            if ((1 & this.f24606d) == 0) {
                sb2.append(" address");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.d.a.b.AbstractC0438d.AbstractC0439a
        public f0.e.d.a.b.AbstractC0438d.AbstractC0439a b(long j10) {
            this.f24605c = j10;
            this.f24606d = (byte) (this.f24606d | 1);
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0438d.AbstractC0439a
        public f0.e.d.a.b.AbstractC0438d.AbstractC0439a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null code");
            }
            this.f24604b = str;
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0438d.AbstractC0439a
        public f0.e.d.a.b.AbstractC0438d.AbstractC0439a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f24603a = str;
            return this;
        }
    }

    @Override // x7.f0.e.d.a.b.AbstractC0438d
    public long b() {
        return this.f24602c;
    }

    @Override // x7.f0.e.d.a.b.AbstractC0438d
    public String c() {
        return this.f24601b;
    }

    @Override // x7.f0.e.d.a.b.AbstractC0438d
    public String d() {
        return this.f24600a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.a.b.AbstractC0438d) {
            f0.e.d.a.b.AbstractC0438d abstractC0438d = (f0.e.d.a.b.AbstractC0438d) obj;
            if (this.f24600a.equals(abstractC0438d.d()) && this.f24601b.equals(abstractC0438d.c()) && this.f24602c == abstractC0438d.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.f24600a.hashCode() ^ 1000003) * 1000003) ^ this.f24601b.hashCode()) * 1000003;
        long j10 = this.f24602c;
        return iHashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f24600a + ", code=" + this.f24601b + ", address=" + this.f24602c + "}";
    }

    public q(String str, String str2, long j10) {
        this.f24600a = str;
        this.f24601b = str2;
        this.f24602c = j10;
    }
}
