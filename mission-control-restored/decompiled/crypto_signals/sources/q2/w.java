package q2;

/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9254b;

    public w(String str, String str2) {
        this.f9253a = str;
        this.f9254b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return kotlin.jvm.internal.j.a(this.f9253a, wVar.f9253a) && kotlin.jvm.internal.j.a(this.f9254b, wVar.f9254b);
    }

    public final int hashCode() {
        String str = this.f9253a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f9254b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "FirebaseInstallationId(fid=" + this.f9253a + ", authToken=" + this.f9254b + ')';
    }
}
