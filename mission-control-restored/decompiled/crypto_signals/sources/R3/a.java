package R3;

import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2798c;

    public a(String str, String str2) {
        this.f2796a = str;
        this.f2797b = null;
        this.f2798c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f2796a.equals(aVar.f2796a)) {
            return this.f2798c.equals(aVar.f2798c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2798c.hashCode() + (this.f2796a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DartEntrypoint( bundle path: ");
        sb.append(this.f2796a);
        sb.append(", function: ");
        return AbstractC1024h.d(sb, this.f2798c, " )");
    }

    public a(String str, String str2, String str3) {
        this.f2796a = str;
        this.f2797b = str2;
        this.f2798c = str3;
    }
}
