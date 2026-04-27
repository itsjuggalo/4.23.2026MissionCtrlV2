package a3;

import S.i;

/* JADX INFO: renamed from: a3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0288a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f4056d;
    public final int e;

    public C0288a(String str, String str2, String str3, b bVar, int i) {
        this.f4053a = str;
        this.f4054b = str2;
        this.f4055c = str3;
        this.f4056d = bVar;
        this.e = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0288a)) {
            return false;
        }
        C0288a c0288a = (C0288a) obj;
        String str = this.f4053a;
        if (str == null) {
            if (c0288a.f4053a != null) {
                return false;
            }
        } else if (!str.equals(c0288a.f4053a)) {
            return false;
        }
        String str2 = this.f4054b;
        if (str2 == null) {
            if (c0288a.f4054b != null) {
                return false;
            }
        } else if (!str2.equals(c0288a.f4054b)) {
            return false;
        }
        String str3 = this.f4055c;
        if (str3 == null) {
            if (c0288a.f4055c != null) {
                return false;
            }
        } else if (!str3.equals(c0288a.f4055c)) {
            return false;
        }
        b bVar = this.f4056d;
        if (bVar == null) {
            if (c0288a.f4056d != null) {
                return false;
            }
        } else if (!bVar.equals(c0288a.f4056d)) {
            return false;
        }
        int i = this.e;
        return i == 0 ? c0288a.e == 0 : i.b(i, c0288a.e);
    }

    public final int hashCode() {
        String str = this.f4053a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f4054b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f4055c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        b bVar = this.f4056d;
        int iHashCode4 = (iHashCode3 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        int i = this.e;
        return (i != 0 ? i.c(i) : 0) ^ iHashCode4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallationResponse{uri=");
        sb.append(this.f4053a);
        sb.append(", fid=");
        sb.append(this.f4054b);
        sb.append(", refreshToken=");
        sb.append(this.f4055c);
        sb.append(", authToken=");
        sb.append(this.f4056d);
        sb.append(", responseCode=");
        int i = this.e;
        sb.append(i != 1 ? i != 2 ? "null" : "BAD_CONFIG" : "OK");
        sb.append("}");
        return sb.toString();
    }
}
