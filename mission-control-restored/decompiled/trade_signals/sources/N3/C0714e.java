package N3;

/* JADX INFO: renamed from: N3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0714e extends H0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T3.m f5673b;

    public C0714e(String str, T3.m mVar) {
        if (str == null) {
            throw new NullPointerException("Null installationId");
        }
        this.f5672a = str;
        if (mVar == null) {
            throw new NullPointerException("Null installationTokenResult");
        }
        this.f5673b = mVar;
    }

    @Override // N3.H0
    public String b() {
        return this.f5672a;
    }

    @Override // N3.H0
    public T3.m c() {
        return this.f5673b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof H0)) {
            return false;
        }
        H0 h02 = (H0) obj;
        return this.f5672a.equals(h02.b()) && this.f5673b.equals(h02.c());
    }

    public int hashCode() {
        return ((this.f5672a.hashCode() ^ 1000003) * 1000003) ^ this.f5673b.hashCode();
    }

    public String toString() {
        return "InstallationIdResult{installationId=" + this.f5672a + ", installationTokenResult=" + this.f5673b + "}";
    }
}
