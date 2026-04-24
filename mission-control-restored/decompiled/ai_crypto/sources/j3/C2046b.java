package j3;

/* JADX INFO: renamed from: j3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2046b extends AbstractC2054j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f17380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f17381f;

    public C2046b(String str, String str2, String str3, String str4, long j7) {
        if (str == null) {
            throw new NullPointerException("Null rolloutId");
        }
        this.f17377b = str;
        if (str2 == null) {
            throw new NullPointerException("Null parameterKey");
        }
        this.f17378c = str2;
        if (str3 == null) {
            throw new NullPointerException("Null parameterValue");
        }
        this.f17379d = str3;
        if (str4 == null) {
            throw new NullPointerException("Null variantId");
        }
        this.f17380e = str4;
        this.f17381f = j7;
    }

    @Override // j3.AbstractC2054j
    public String c() {
        return this.f17378c;
    }

    @Override // j3.AbstractC2054j
    public String d() {
        return this.f17379d;
    }

    @Override // j3.AbstractC2054j
    public String e() {
        return this.f17377b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2054j)) {
            return false;
        }
        AbstractC2054j abstractC2054j = (AbstractC2054j) obj;
        return this.f17377b.equals(abstractC2054j.e()) && this.f17378c.equals(abstractC2054j.c()) && this.f17379d.equals(abstractC2054j.d()) && this.f17380e.equals(abstractC2054j.g()) && this.f17381f == abstractC2054j.f();
    }

    @Override // j3.AbstractC2054j
    public long f() {
        return this.f17381f;
    }

    @Override // j3.AbstractC2054j
    public String g() {
        return this.f17380e;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f17377b.hashCode() ^ 1000003) * 1000003) ^ this.f17378c.hashCode()) * 1000003) ^ this.f17379d.hashCode()) * 1000003) ^ this.f17380e.hashCode()) * 1000003;
        long j7 = this.f17381f;
        return iHashCode ^ ((int) (j7 ^ (j7 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f17377b + ", parameterKey=" + this.f17378c + ", parameterValue=" + this.f17379d + ", variantId=" + this.f17380e + ", templateVersion=" + this.f17381f + "}";
    }
}
