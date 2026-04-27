package y1;

import java.util.Set;
import y1.AbstractC2839f;

/* JADX INFO: renamed from: y1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2836c extends AbstractC2839f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f25459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f25460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f25461c;

    /* JADX INFO: renamed from: y1.c$b */
    public static final class b extends AbstractC2839f.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f25462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f25463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set f25464c;

        @Override // y1.AbstractC2839f.b.a
        public AbstractC2839f.b a() {
            String str = "";
            if (this.f25462a == null) {
                str = " delta";
            }
            if (this.f25463b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f25464c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new C2836c(this.f25462a.longValue(), this.f25463b.longValue(), this.f25464c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // y1.AbstractC2839f.b.a
        public AbstractC2839f.b.a b(long j7) {
            this.f25462a = Long.valueOf(j7);
            return this;
        }

        @Override // y1.AbstractC2839f.b.a
        public AbstractC2839f.b.a c(Set set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f25464c = set;
            return this;
        }

        @Override // y1.AbstractC2839f.b.a
        public AbstractC2839f.b.a d(long j7) {
            this.f25463b = Long.valueOf(j7);
            return this;
        }
    }

    @Override // y1.AbstractC2839f.b
    public long b() {
        return this.f25459a;
    }

    @Override // y1.AbstractC2839f.b
    public Set c() {
        return this.f25461c;
    }

    @Override // y1.AbstractC2839f.b
    public long d() {
        return this.f25460b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2839f.b)) {
            return false;
        }
        AbstractC2839f.b bVar = (AbstractC2839f.b) obj;
        return this.f25459a == bVar.b() && this.f25460b == bVar.d() && this.f25461c.equals(bVar.c());
    }

    public int hashCode() {
        long j7 = this.f25459a;
        int i7 = (((int) (j7 ^ (j7 >>> 32))) ^ 1000003) * 1000003;
        long j8 = this.f25460b;
        return ((i7 ^ ((int) ((j8 >>> 32) ^ j8))) * 1000003) ^ this.f25461c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f25459a + ", maxAllowedDelay=" + this.f25460b + ", flags=" + this.f25461c + "}";
    }

    public C2836c(long j7, long j8, Set set) {
        this.f25459a = j7;
        this.f25460b = j8;
        this.f25461c = set;
    }
}
