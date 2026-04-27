package U2;

/* JADX INFO: loaded from: classes.dex */
public final class b extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f8103f;

    public b(String str, String str2, String str3, String str4, long j8) {
        if (str == null) {
            throw new NullPointerException("Null rolloutId");
        }
        this.f8099b = str;
        if (str2 == null) {
            throw new NullPointerException("Null parameterKey");
        }
        this.f8100c = str2;
        if (str3 == null) {
            throw new NullPointerException("Null parameterValue");
        }
        this.f8101d = str3;
        if (str4 == null) {
            throw new NullPointerException("Null variantId");
        }
        this.f8102e = str4;
        this.f8103f = j8;
    }

    @Override // U2.j
    public String c() {
        return this.f8100c;
    }

    @Override // U2.j
    public String d() {
        return this.f8101d;
    }

    @Override // U2.j
    public String e() {
        return this.f8099b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f8099b.equals(jVar.e()) && this.f8100c.equals(jVar.c()) && this.f8101d.equals(jVar.d()) && this.f8102e.equals(jVar.g()) && this.f8103f == jVar.f();
    }

    @Override // U2.j
    public long f() {
        return this.f8103f;
    }

    @Override // U2.j
    public String g() {
        return this.f8102e;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f8099b.hashCode() ^ 1000003) * 1000003) ^ this.f8100c.hashCode()) * 1000003) ^ this.f8101d.hashCode()) * 1000003) ^ this.f8102e.hashCode()) * 1000003;
        long j8 = this.f8103f;
        return iHashCode ^ ((int) (j8 ^ (j8 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f8099b + ", parameterKey=" + this.f8100c + ", parameterValue=" + this.f8101d + ", variantId=" + this.f8102e + ", templateVersion=" + this.f8103f + "}";
    }
}
