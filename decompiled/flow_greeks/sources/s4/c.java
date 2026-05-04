package s4;

import java.util.Set;
import s4.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f19968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f19969c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f19970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f19971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set f19972c;

        @Override // s4.f.b.a
        public f.b a() {
            String str = "";
            if (this.f19970a == null) {
                str = " delta";
            }
            if (this.f19971b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f19972c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new c(this.f19970a.longValue(), this.f19971b.longValue(), this.f19972c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // s4.f.b.a
        public f.b.a b(long j10) {
            this.f19970a = Long.valueOf(j10);
            return this;
        }

        @Override // s4.f.b.a
        public f.b.a c(Set set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f19972c = set;
            return this;
        }

        @Override // s4.f.b.a
        public f.b.a d(long j10) {
            this.f19971b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // s4.f.b
    public long b() {
        return this.f19967a;
    }

    @Override // s4.f.b
    public Set c() {
        return this.f19969c;
    }

    @Override // s4.f.b
    public long d() {
        return this.f19968b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f.b) {
            f.b bVar = (f.b) obj;
            if (this.f19967a == bVar.b() && this.f19968b == bVar.d() && this.f19969c.equals(bVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f19967a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        long j11 = this.f19968b;
        return ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f19969c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f19967a + ", maxAllowedDelay=" + this.f19968b + ", flags=" + this.f19969c + "}";
    }

    public c(long j10, long j11, Set set) {
        this.f19967a = j10;
        this.f19968b = j11;
        this.f19969c = set;
    }
}
