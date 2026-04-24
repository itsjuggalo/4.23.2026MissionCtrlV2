package S2;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7499b;

    public I(String str, String str2) {
        this.f7498a = str;
        this.f7499b = str2;
    }

    public final String a() {
        return this.f7499b;
    }

    public final String b() {
        return this.f7498a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I)) {
            return false;
        }
        I i8 = (I) obj;
        return AbstractC2304t.b(this.f7498a, i8.f7498a) && AbstractC2304t.b(this.f7499b, i8.f7499b);
    }

    public int hashCode() {
        String str = this.f7498a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f7499b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "FirebaseInstallationId(fid=" + this.f7498a + ", authToken=" + this.f7499b + ')';
    }
}
