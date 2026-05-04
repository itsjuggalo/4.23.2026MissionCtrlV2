package oa;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17692b;

    public a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f17691a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f17692b = str2;
    }

    @Override // oa.f
    public String b() {
        return this.f17691a;
    }

    @Override // oa.f
    public String c() {
        return this.f17692b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f17691a.equals(fVar.b()) && this.f17692b.equals(fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f17691a.hashCode() ^ 1000003) * 1000003) ^ this.f17692b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f17691a + ", version=" + this.f17692b + "}";
    }
}
