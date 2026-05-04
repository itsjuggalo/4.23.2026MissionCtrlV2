package e5;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b extends n5.a {
    public static final Parcelable.Creator<b> CREATOR = new d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f8377g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f8378h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f8379i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f8380j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f8381k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f8382l = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f8383m = 6;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f8384n = 7;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f8385o = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f8389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f8391f;

    public b(int i10, String str, int i11, long j10, byte[] bArr, Bundle bundle) {
        this.f8390e = i10;
        this.f8386a = str;
        this.f8387b = i11;
        this.f8388c = j10;
        this.f8389d = bArr;
        this.f8391f = bundle;
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.f8386a + ", method: " + this.f8387b + " ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, this.f8386a, false);
        n5.c.t(parcel, 2, this.f8387b);
        n5.c.x(parcel, 3, this.f8388c);
        n5.c.k(parcel, 4, this.f8389d, false);
        n5.c.j(parcel, 5, this.f8391f, false);
        n5.c.t(parcel, 1000, this.f8390e);
        n5.c.b(parcel, iA);
    }
}
