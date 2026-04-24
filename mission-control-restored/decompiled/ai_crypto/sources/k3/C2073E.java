package k3;

import k3.AbstractC2075G;

/* JADX INFO: renamed from: k3.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2073E extends AbstractC2075G.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17596c;

    public C2073E(String str, String str2, boolean z7) {
        if (str == null) {
            throw new NullPointerException("Null osRelease");
        }
        this.f17594a = str;
        if (str2 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.f17595b = str2;
        this.f17596c = z7;
    }

    @Override // k3.AbstractC2075G.c
    public boolean b() {
        return this.f17596c;
    }

    @Override // k3.AbstractC2075G.c
    public String c() {
        return this.f17595b;
    }

    @Override // k3.AbstractC2075G.c
    public String d() {
        return this.f17594a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2075G.c)) {
            return false;
        }
        AbstractC2075G.c cVar = (AbstractC2075G.c) obj;
        return this.f17594a.equals(cVar.d()) && this.f17595b.equals(cVar.c()) && this.f17596c == cVar.b();
    }

    public int hashCode() {
        return ((((this.f17594a.hashCode() ^ 1000003) * 1000003) ^ this.f17595b.hashCode()) * 1000003) ^ (this.f17596c ? 1231 : 1237);
    }

    public String toString() {
        return "OsData{osRelease=" + this.f17594a + ", osCodeName=" + this.f17595b + ", isRooted=" + this.f17596c + "}";
    }
}
