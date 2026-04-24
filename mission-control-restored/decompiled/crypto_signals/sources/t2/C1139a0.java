package t2;

/* JADX INFO: renamed from: t2.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1139a0 extends D0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10056d;

    public C1139a0(int i, int i6, String str, boolean z6) {
        this.f10053a = str;
        this.f10054b = i;
        this.f10055c = i6;
        this.f10056d = z6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof D0) {
            D0 d02 = (D0) obj;
            if (this.f10053a.equals(((C1139a0) d02).f10053a)) {
                C1139a0 c1139a0 = (C1139a0) d02;
                if (this.f10054b == c1139a0.f10054b && this.f10055c == c1139a0.f10055c && this.f10056d == c1139a0.f10056d) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f10053a.hashCode() ^ 1000003) * 1000003) ^ this.f10054b) * 1000003) ^ this.f10055c) * 1000003) ^ (this.f10056d ? 1231 : 1237);
    }

    public final String toString() {
        return "ProcessDetails{processName=" + this.f10053a + ", pid=" + this.f10054b + ", importance=" + this.f10055c + ", defaultProcess=" + this.f10056d + "}";
    }
}
