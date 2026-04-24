package g3;

import s3.AbstractC1024h;

/* JADX INFO: renamed from: g3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0610a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6557b;

    public C0610a(String str, String str2) {
        this.f6556a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f6557b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0610a) {
            C0610a c0610a = (C0610a) obj;
            if (this.f6556a.equals(c0610a.f6556a) && this.f6557b.equals(c0610a.f6557b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f6556a.hashCode() ^ 1000003) * 1000003) ^ this.f6557b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LibraryVersion{libraryName=");
        sb.append(this.f6556a);
        sb.append(", version=");
        return AbstractC1024h.d(sb, this.f6557b, "}");
    }
}
