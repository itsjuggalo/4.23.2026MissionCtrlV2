package h1;

import h1.f;
import java.util.Set;

/* JADX INFO: renamed from: h1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1280c extends f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f12097c;

    /* JADX INFO: renamed from: h1.c$b */
    public static final class b extends f.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f12098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f12099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set f12100c;

        @Override // h1.f.b.a
        public f.b a() {
            String str = "";
            if (this.f12098a == null) {
                str = " delta";
            }
            if (this.f12099b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f12100c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new C1280c(this.f12098a.longValue(), this.f12099b.longValue(), this.f12100c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // h1.f.b.a
        public f.b.a b(long j4) {
            this.f12098a = Long.valueOf(j4);
            return this;
        }

        @Override // h1.f.b.a
        public f.b.a c(Set set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f12100c = set;
            return this;
        }

        @Override // h1.f.b.a
        public f.b.a d(long j4) {
            this.f12099b = Long.valueOf(j4);
            return this;
        }
    }

    @Override // h1.f.b
    public long b() {
        return this.f12095a;
    }

    @Override // h1.f.b
    public Set c() {
        return this.f12097c;
    }

    @Override // h1.f.b
    public long d() {
        return this.f12096b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f.b) {
            f.b bVar = (f.b) obj;
            if (this.f12095a == bVar.b() && this.f12096b == bVar.d() && this.f12097c.equals(bVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f12095a;
        int i4 = (((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003;
        long j5 = this.f12096b;
        return ((i4 ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003) ^ this.f12097c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f12095a + ", maxAllowedDelay=" + this.f12096b + ", flags=" + this.f12097c + "}";
    }

    public C1280c(long j4, long j5, Set set) {
        this.f12095a = j4;
        this.f12096b = j5;
        this.f12097c = set;
    }
}
