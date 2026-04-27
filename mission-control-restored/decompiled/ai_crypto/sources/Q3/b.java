package Q3;

import Q3.f;

/* JADX INFO: loaded from: classes.dex */
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f.b f4536c;

    /* JADX INFO: renamed from: Q3.b$b, reason: collision with other inner class name */
    public static final class C0074b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f4538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f.b f4539c;

        @Override // Q3.f.a
        public f a() {
            String str = "";
            if (this.f4538b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f4537a, this.f4538b.longValue(), this.f4539c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // Q3.f.a
        public f.a b(f.b bVar) {
            this.f4539c = bVar;
            return this;
        }

        @Override // Q3.f.a
        public f.a c(String str) {
            this.f4537a = str;
            return this;
        }

        @Override // Q3.f.a
        public f.a d(long j7) {
            this.f4538b = Long.valueOf(j7);
            return this;
        }
    }

    @Override // Q3.f
    public f.b b() {
        return this.f4536c;
    }

    @Override // Q3.f
    public String c() {
        return this.f4534a;
    }

    @Override // Q3.f
    public long d() {
        return this.f4535b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.f4534a;
        if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
            if (this.f4535b == fVar.d()) {
                f.b bVar = this.f4536c;
                if (bVar == null) {
                    if (fVar.b() == null) {
                        return true;
                    }
                } else if (bVar.equals(fVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f4534a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j7 = this.f4535b;
        int i7 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        f.b bVar = this.f4536c;
        return i7 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f4534a + ", tokenExpirationTimestamp=" + this.f4535b + ", responseCode=" + this.f4536c + "}";
    }

    public b(String str, long j7, f.b bVar) {
        this.f4534a = str;
        this.f4535b = j7;
        this.f4536c = bVar;
    }
}
