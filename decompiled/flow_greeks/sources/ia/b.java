package ia;

import ia.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f.b f12254c;

    /* JADX INFO: renamed from: ia.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0227b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f12256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f.b f12257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte f12258d;

        @Override // ia.f.a
        public f a() {
            if (this.f12258d == 1) {
                return new b(this.f12255a, this.f12256b, this.f12257c);
            }
            throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
        }

        @Override // ia.f.a
        public f.a b(f.b bVar) {
            this.f12257c = bVar;
            return this;
        }

        @Override // ia.f.a
        public f.a c(String str) {
            this.f12255a = str;
            return this;
        }

        @Override // ia.f.a
        public f.a d(long j10) {
            this.f12256b = j10;
            this.f12258d = (byte) (this.f12258d | 1);
            return this;
        }
    }

    @Override // ia.f
    public f.b b() {
        return this.f12254c;
    }

    @Override // ia.f
    public String c() {
        return this.f12252a;
    }

    @Override // ia.f
    public long d() {
        return this.f12253b;
    }

    public boolean equals(Object obj) {
        f.b bVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            String str = this.f12252a;
            if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
                if (this.f12253b == fVar.d() && ((bVar = this.f12254c) != null ? bVar.equals(fVar.b()) : fVar.b() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f12252a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j10 = this.f12253b;
        int i10 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        f.b bVar = this.f12254c;
        return i10 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f12252a + ", tokenExpirationTimestamp=" + this.f12253b + ", responseCode=" + this.f12254c + "}";
    }

    public b(String str, long j10, f.b bVar) {
        this.f12252a = str;
        this.f12253b = j10;
        this.f12254c = bVar;
    }
}
