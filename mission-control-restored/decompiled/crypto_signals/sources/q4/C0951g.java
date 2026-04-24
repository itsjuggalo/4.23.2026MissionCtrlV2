package q4;

/* JADX INFO: renamed from: q4.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0951g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9333b;

    public C0951g(String str, boolean z6) {
        this.f9332a = str;
        this.f9333b = z6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0951g)) {
            return false;
        }
        C0951g c0951g = (C0951g) obj;
        return kotlin.jvm.internal.j.a(this.f9332a, c0951g.f9332a) && this.f9333b == c0951g.f9333b;
    }

    public final int hashCode() {
        String str = this.f9332a;
        return Boolean.hashCode(this.f9333b) + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public final String toString() {
        return "SharedPreferencesPigeonOptions(fileName=" + this.f9332a + ", useDataStore=" + this.f9333b + ")";
    }
}
