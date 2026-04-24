package h3;

/* JADX INFO: renamed from: h3.M, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1682M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14777b;

    public C1682M(String str, String str2) {
        this.f14776a = str;
        this.f14777b = str2;
    }

    public final String a() {
        return this.f14777b;
    }

    public final String b() {
        return this.f14776a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1682M)) {
            return false;
        }
        C1682M c1682m = (C1682M) obj;
        return kotlin.jvm.internal.r.b(this.f14776a, c1682m.f14776a) && kotlin.jvm.internal.r.b(this.f14777b, c1682m.f14777b);
    }

    public int hashCode() {
        String str = this.f14776a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f14777b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "FirebaseInstallationId(fid=" + this.f14776a + ", authToken=" + this.f14777b + ')';
    }
}
