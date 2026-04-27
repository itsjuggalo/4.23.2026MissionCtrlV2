package G1;

import G1.f;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c extends f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f2092c;

    public static final class b extends f.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f2093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f2094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set f2095c;

        @Override // G1.f.b.a
        public f.b a() {
            String str = "";
            if (this.f2093a == null) {
                str = " delta";
            }
            if (this.f2094b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f2095c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new c(this.f2093a.longValue(), this.f2094b.longValue(), this.f2095c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // G1.f.b.a
        public f.b.a b(long j8) {
            this.f2093a = Long.valueOf(j8);
            return this;
        }

        @Override // G1.f.b.a
        public f.b.a c(Set set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f2095c = set;
            return this;
        }

        @Override // G1.f.b.a
        public f.b.a d(long j8) {
            this.f2094b = Long.valueOf(j8);
            return this;
        }
    }

    public c(long j8, long j9, Set set) {
        this.f2090a = j8;
        this.f2091b = j9;
        this.f2092c = set;
    }

    @Override // G1.f.b
    public long b() {
        return this.f2090a;
    }

    @Override // G1.f.b
    public Set c() {
        return this.f2092c;
    }

    @Override // G1.f.b
    public long d() {
        return this.f2091b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f.b)) {
            return false;
        }
        f.b bVar = (f.b) obj;
        return this.f2090a == bVar.b() && this.f2091b == bVar.d() && this.f2092c.equals(bVar.c());
    }

    public int hashCode() {
        long j8 = this.f2090a;
        int i8 = (((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003;
        long j9 = this.f2091b;
        return ((i8 ^ ((int) ((j9 >>> 32) ^ j9))) * 1000003) ^ this.f2092c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f2090a + ", maxAllowedDelay=" + this.f2091b + ", flags=" + this.f2092c + "}";
    }
}
