package t2;

import s3.AbstractC1024h;

/* JADX INFO: renamed from: t2.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1117E extends p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9952c;

    public C1117E(String str, String str2, String str3) {
        this.f9950a = str;
        this.f9951b = str2;
        this.f9952c = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p0) {
            p0 p0Var = (p0) obj;
            if (this.f9950a.equals(((C1117E) p0Var).f9950a)) {
                C1117E c1117e = (C1117E) p0Var;
                if (this.f9951b.equals(c1117e.f9951b) && this.f9952c.equals(c1117e.f9952c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f9950a.hashCode() ^ 1000003) * 1000003) ^ this.f9951b.hashCode()) * 1000003) ^ this.f9952c.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BuildIdMappingForArch{arch=");
        sb.append(this.f9950a);
        sb.append(", libraryName=");
        sb.append(this.f9951b);
        sb.append(", buildId=");
        return AbstractC1024h.d(sb, this.f9952c, "}");
    }
}
