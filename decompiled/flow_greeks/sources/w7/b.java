package w7;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f23687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f23688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f23689f;

    public b(String str, String str2, String str3, String str4, long j10) {
        if (str == null) {
            throw new NullPointerException("Null rolloutId");
        }
        this.f23685b = str;
        if (str2 == null) {
            throw new NullPointerException("Null parameterKey");
        }
        this.f23686c = str2;
        if (str3 == null) {
            throw new NullPointerException("Null parameterValue");
        }
        this.f23687d = str3;
        if (str4 == null) {
            throw new NullPointerException("Null variantId");
        }
        this.f23688e = str4;
        this.f23689f = j10;
    }

    @Override // w7.j
    public String c() {
        return this.f23686c;
    }

    @Override // w7.j
    public String d() {
        return this.f23687d;
    }

    @Override // w7.j
    public String e() {
        return this.f23685b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (this.f23685b.equals(jVar.e()) && this.f23686c.equals(jVar.c()) && this.f23687d.equals(jVar.d()) && this.f23688e.equals(jVar.g()) && this.f23689f == jVar.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // w7.j
    public long f() {
        return this.f23689f;
    }

    @Override // w7.j
    public String g() {
        return this.f23688e;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f23685b.hashCode() ^ 1000003) * 1000003) ^ this.f23686c.hashCode()) * 1000003) ^ this.f23687d.hashCode()) * 1000003) ^ this.f23688e.hashCode()) * 1000003;
        long j10 = this.f23689f;
        return iHashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f23685b + ", parameterKey=" + this.f23686c + ", parameterValue=" + this.f23687d + ", variantId=" + this.f23688e + ", templateVersion=" + this.f23689f + "}";
    }
}
