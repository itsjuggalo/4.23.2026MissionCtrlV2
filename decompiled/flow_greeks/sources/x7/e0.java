package x7;

import x7.g0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends g0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f24476c;

    public e0(String str, String str2, boolean z10) {
        if (str == null) {
            throw new NullPointerException("Null osRelease");
        }
        this.f24474a = str;
        if (str2 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.f24475b = str2;
        this.f24476c = z10;
    }

    @Override // x7.g0.c
    public boolean b() {
        return this.f24476c;
    }

    @Override // x7.g0.c
    public String c() {
        return this.f24475b;
    }

    @Override // x7.g0.c
    public String d() {
        return this.f24474a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0.c) {
            g0.c cVar = (g0.c) obj;
            if (this.f24474a.equals(cVar.d()) && this.f24475b.equals(cVar.c()) && this.f24476c == cVar.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f24474a.hashCode() ^ 1000003) * 1000003) ^ this.f24475b.hashCode()) * 1000003) ^ (this.f24476c ? 1231 : 1237);
    }

    public String toString() {
        return "OsData{osRelease=" + this.f24474a + ", osCodeName=" + this.f24475b + ", isRooted=" + this.f24476c + "}";
    }
}
