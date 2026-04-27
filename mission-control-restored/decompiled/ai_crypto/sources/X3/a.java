package X3;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5487b;

    public a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f5486a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f5487b = str2;
    }

    @Override // X3.f
    public String b() {
        return this.f5486a;
    }

    @Override // X3.f
    public String c() {
        return this.f5487b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f5486a.equals(fVar.b()) && this.f5487b.equals(fVar.c());
    }

    public int hashCode() {
        return ((this.f5486a.hashCode() ^ 1000003) * 1000003) ^ this.f5487b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f5486a + ", version=" + this.f5487b + "}";
    }
}
