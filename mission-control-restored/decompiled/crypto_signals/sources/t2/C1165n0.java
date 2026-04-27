package t2;

import android.os.Build;
import s3.AbstractC1024h;

/* JADX INFO: renamed from: t2.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1165n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10176d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10177f;

    public C1165n0(int i, int i6, long j4, long j6, boolean z6, int i7) {
        String str = Build.MODEL;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.PRODUCT;
        this.f10173a = i;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f10174b = i6;
        this.f10175c = j4;
        this.f10176d = j6;
        this.e = z6;
        this.f10177f = i7;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1165n0)) {
            return false;
        }
        C1165n0 c1165n0 = (C1165n0) obj;
        if (this.f10173a != c1165n0.f10173a) {
            return false;
        }
        String str = Build.MODEL;
        if (!str.equals(str) || this.f10174b != c1165n0.f10174b || this.f10175c != c1165n0.f10175c || this.f10176d != c1165n0.f10176d || this.e != c1165n0.e || this.f10177f != c1165n0.f10177f) {
            return false;
        }
        String str2 = Build.MANUFACTURER;
        if (!str2.equals(str2)) {
            return false;
        }
        String str3 = Build.PRODUCT;
        return str3.equals(str3);
    }

    public final int hashCode() {
        int iHashCode = (((((this.f10173a ^ 1000003) * 1000003) ^ Build.MODEL.hashCode()) * 1000003) ^ this.f10174b) * 1000003;
        long j4 = this.f10175c;
        int i = (iHashCode ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j6 = this.f10176d;
        return Build.PRODUCT.hashCode() ^ ((((((((i ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ (this.e ? 1231 : 1237)) * 1000003) ^ this.f10177f) * 1000003) ^ Build.MANUFACTURER.hashCode()) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceData{arch=");
        sb.append(this.f10173a);
        sb.append(", model=");
        sb.append(Build.MODEL);
        sb.append(", availableProcessors=");
        sb.append(this.f10174b);
        sb.append(", totalRam=");
        sb.append(this.f10175c);
        sb.append(", diskSpace=");
        sb.append(this.f10176d);
        sb.append(", isEmulator=");
        sb.append(this.e);
        sb.append(", state=");
        sb.append(this.f10177f);
        sb.append(", manufacturer=");
        sb.append(Build.MANUFACTURER);
        sb.append(", modelClass=");
        return AbstractC1024h.d(sb, Build.PRODUCT, "}");
    }
}
