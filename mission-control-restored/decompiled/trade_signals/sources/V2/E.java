package V2;

import V2.G;

/* JADX INFO: loaded from: classes.dex */
public final class E extends G.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8517c;

    public E(String str, String str2, boolean z7) {
        if (str == null) {
            throw new NullPointerException("Null osRelease");
        }
        this.f8515a = str;
        if (str2 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.f8516b = str2;
        this.f8517c = z7;
    }

    @Override // V2.G.c
    public boolean b() {
        return this.f8517c;
    }

    @Override // V2.G.c
    public String c() {
        return this.f8516b;
    }

    @Override // V2.G.c
    public String d() {
        return this.f8515a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof G.c)) {
            return false;
        }
        G.c cVar = (G.c) obj;
        return this.f8515a.equals(cVar.d()) && this.f8516b.equals(cVar.c()) && this.f8517c == cVar.b();
    }

    public int hashCode() {
        return ((((this.f8515a.hashCode() ^ 1000003) * 1000003) ^ this.f8516b.hashCode()) * 1000003) ^ (this.f8517c ? 1231 : 1237);
    }

    public String toString() {
        return "OsData{osRelease=" + this.f8515a + ", osCodeName=" + this.f8516b + ", isRooted=" + this.f8517c + "}";
    }
}
