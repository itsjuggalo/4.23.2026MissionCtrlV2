package a4;

/* JADX INFO: renamed from: a4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1068a extends AbstractC1073f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9958b;

    public C1068a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f9957a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f9958b = str2;
    }

    @Override // a4.AbstractC1073f
    public String b() {
        return this.f9957a;
    }

    @Override // a4.AbstractC1073f
    public String c() {
        return this.f9958b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1073f)) {
            return false;
        }
        AbstractC1073f abstractC1073f = (AbstractC1073f) obj;
        return this.f9957a.equals(abstractC1073f.b()) && this.f9958b.equals(abstractC1073f.c());
    }

    public int hashCode() {
        return ((this.f9957a.hashCode() ^ 1000003) * 1000003) ^ this.f9958b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f9957a + ", version=" + this.f9958b + "}";
    }
}
