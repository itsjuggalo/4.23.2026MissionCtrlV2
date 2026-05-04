package ta;

import ta.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f20850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f20851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f20852f;

    /* JADX INFO: renamed from: ta.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0369b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f20853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f20854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f20855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f20856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f20857e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f20858f;

        @Override // ta.d.a
        public d a() {
            if (this.f20858f == 1 && this.f20853a != null && this.f20854b != null && this.f20855c != null && this.f20856d != null) {
                return new b(this.f20853a, this.f20854b, this.f20855c, this.f20856d, this.f20857e);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f20853a == null) {
                sb2.append(" rolloutId");
            }
            if (this.f20854b == null) {
                sb2.append(" variantId");
            }
            if (this.f20855c == null) {
                sb2.append(" parameterKey");
            }
            if (this.f20856d == null) {
                sb2.append(" parameterValue");
            }
            if ((1 & this.f20858f) == 0) {
                sb2.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // ta.d.a
        public d.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterKey");
            }
            this.f20855c = str;
            return this;
        }

        @Override // ta.d.a
        public d.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterValue");
            }
            this.f20856d = str;
            return this;
        }

        @Override // ta.d.a
        public d.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null rolloutId");
            }
            this.f20853a = str;
            return this;
        }

        @Override // ta.d.a
        public d.a e(long j10) {
            this.f20857e = j10;
            this.f20858f = (byte) (this.f20858f | 1);
            return this;
        }

        @Override // ta.d.a
        public d.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            this.f20854b = str;
            return this;
        }
    }

    @Override // ta.d
    public String b() {
        return this.f20850d;
    }

    @Override // ta.d
    public String c() {
        return this.f20851e;
    }

    @Override // ta.d
    public String d() {
        return this.f20848b;
    }

    @Override // ta.d
    public long e() {
        return this.f20852f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f20848b.equals(dVar.d()) && this.f20849c.equals(dVar.f()) && this.f20850d.equals(dVar.b()) && this.f20851e.equals(dVar.c()) && this.f20852f == dVar.e()) {
                return true;
            }
        }
        return false;
    }

    @Override // ta.d
    public String f() {
        return this.f20849c;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f20848b.hashCode() ^ 1000003) * 1000003) ^ this.f20849c.hashCode()) * 1000003) ^ this.f20850d.hashCode()) * 1000003) ^ this.f20851e.hashCode()) * 1000003;
        long j10 = this.f20852f;
        return iHashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f20848b + ", variantId=" + this.f20849c + ", parameterKey=" + this.f20850d + ", parameterValue=" + this.f20851e + ", templateVersion=" + this.f20852f + "}";
    }

    public b(String str, String str2, String str3, String str4, long j10) {
        this.f20848b = str;
        this.f20849c = str2;
        this.f20850d = str3;
        this.f20851e = str4;
        this.f20852f = j10;
    }
}
