package t2;

/* JADX INFO: renamed from: t2.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1161l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1163m0 f10155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1167o0 f10156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1165n0 f10157c;

    public C1161l0(C1163m0 c1163m0, C1167o0 c1167o0, C1165n0 c1165n0) {
        this.f10155a = c1163m0;
        this.f10156b = c1167o0;
        this.f10157c = c1165n0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1161l0) {
            C1161l0 c1161l0 = (C1161l0) obj;
            if (this.f10155a.equals(c1161l0.f10155a) && this.f10156b.equals(c1161l0.f10156b) && this.f10157c.equals(c1161l0.f10157c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f10155a.hashCode() ^ 1000003) * 1000003) ^ this.f10156b.hashCode()) * 1000003) ^ this.f10157c.hashCode();
    }

    public final String toString() {
        return "StaticSessionData{appData=" + this.f10155a + ", osData=" + this.f10156b + ", deviceData=" + this.f10157c + "}";
    }
}
