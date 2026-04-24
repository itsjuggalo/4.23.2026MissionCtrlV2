package t2;

import s3.AbstractC1024h;

/* JADX INFO: renamed from: t2.N, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1126N extends w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9996d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f9997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f9999h;
    public final String i;

    public C1126N(int i, String str, int i6, long j4, long j6, boolean z6, int i7, String str2, String str3) {
        this.f9993a = i;
        this.f9994b = str;
        this.f9995c = i6;
        this.f9996d = j4;
        this.e = j6;
        this.f9997f = z6;
        this.f9998g = i7;
        this.f9999h = str2;
        this.i = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w0) {
            w0 w0Var = (w0) obj;
            if (this.f9993a == ((C1126N) w0Var).f9993a) {
                C1126N c1126n = (C1126N) w0Var;
                if (this.f9994b.equals(c1126n.f9994b) && this.f9995c == c1126n.f9995c && this.f9996d == c1126n.f9996d && this.e == c1126n.e && this.f9997f == c1126n.f9997f && this.f9998g == c1126n.f9998g && this.f9999h.equals(c1126n.f9999h) && this.i.equals(c1126n.i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((this.f9993a ^ 1000003) * 1000003) ^ this.f9994b.hashCode()) * 1000003) ^ this.f9995c) * 1000003;
        long j4 = this.f9996d;
        int i = (iHashCode ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j6 = this.e;
        return ((((((((i ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ (this.f9997f ? 1231 : 1237)) * 1000003) ^ this.f9998g) * 1000003) ^ this.f9999h.hashCode()) * 1000003) ^ this.i.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Device{arch=");
        sb.append(this.f9993a);
        sb.append(", model=");
        sb.append(this.f9994b);
        sb.append(", cores=");
        sb.append(this.f9995c);
        sb.append(", ram=");
        sb.append(this.f9996d);
        sb.append(", diskSpace=");
        sb.append(this.e);
        sb.append(", simulator=");
        sb.append(this.f9997f);
        sb.append(", state=");
        sb.append(this.f9998g);
        sb.append(", manufacturer=");
        sb.append(this.f9999h);
        sb.append(", modelClass=");
        return AbstractC1024h.d(sb, this.i, "}");
    }
}
