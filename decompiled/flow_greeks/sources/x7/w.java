package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends f0.e.d.AbstractC0446e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0.e.d.AbstractC0446e.b f24649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24652d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.AbstractC0446e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f0.e.d.AbstractC0446e.b f24653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f24655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f24656d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte f24657e;

        @Override // x7.f0.e.d.AbstractC0446e.a
        public f0.e.d.AbstractC0446e a() {
            f0.e.d.AbstractC0446e.b bVar;
            String str;
            String str2;
            if (this.f24657e == 1 && (bVar = this.f24653a) != null && (str = this.f24654b) != null && (str2 = this.f24655c) != null) {
                return new w(bVar, str, str2, this.f24656d);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24653a == null) {
                sb2.append(" rolloutVariant");
            }
            if (this.f24654b == null) {
                sb2.append(" parameterKey");
            }
            if (this.f24655c == null) {
                sb2.append(" parameterValue");
            }
            if ((1 & this.f24657e) == 0) {
                sb2.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.d.AbstractC0446e.a
        public f0.e.d.AbstractC0446e.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterKey");
            }
            this.f24654b = str;
            return this;
        }

        @Override // x7.f0.e.d.AbstractC0446e.a
        public f0.e.d.AbstractC0446e.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterValue");
            }
            this.f24655c = str;
            return this;
        }

        @Override // x7.f0.e.d.AbstractC0446e.a
        public f0.e.d.AbstractC0446e.a d(f0.e.d.AbstractC0446e.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null rolloutVariant");
            }
            this.f24653a = bVar;
            return this;
        }

        @Override // x7.f0.e.d.AbstractC0446e.a
        public f0.e.d.AbstractC0446e.a e(long j10) {
            this.f24656d = j10;
            this.f24657e = (byte) (this.f24657e | 1);
            return this;
        }
    }

    @Override // x7.f0.e.d.AbstractC0446e
    public String b() {
        return this.f24650b;
    }

    @Override // x7.f0.e.d.AbstractC0446e
    public String c() {
        return this.f24651c;
    }

    @Override // x7.f0.e.d.AbstractC0446e
    public f0.e.d.AbstractC0446e.b d() {
        return this.f24649a;
    }

    @Override // x7.f0.e.d.AbstractC0446e
    public long e() {
        return this.f24652d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.AbstractC0446e) {
            f0.e.d.AbstractC0446e abstractC0446e = (f0.e.d.AbstractC0446e) obj;
            if (this.f24649a.equals(abstractC0446e.d()) && this.f24650b.equals(abstractC0446e.b()) && this.f24651c.equals(abstractC0446e.c()) && this.f24652d == abstractC0446e.e()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((this.f24649a.hashCode() ^ 1000003) * 1000003) ^ this.f24650b.hashCode()) * 1000003) ^ this.f24651c.hashCode()) * 1000003;
        long j10 = this.f24652d;
        return iHashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutVariant=" + this.f24649a + ", parameterKey=" + this.f24650b + ", parameterValue=" + this.f24651c + ", templateVersion=" + this.f24652d + "}";
    }

    public w(f0.e.d.AbstractC0446e.b bVar, String str, String str2, long j10) {
        this.f24649a = bVar;
        this.f24650b = str;
        this.f24651c = str2;
        this.f24652d = j10;
    }
}
