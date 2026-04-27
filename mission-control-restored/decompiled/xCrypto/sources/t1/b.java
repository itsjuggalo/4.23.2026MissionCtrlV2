package t1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class b extends A1.a {
    public static final Parcelable.Creator<b> CREATOR = new d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f14727g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f14728h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f14729i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f14730j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f14731k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f14732l = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f14733m = 6;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f14734n = 7;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f14735o = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f14739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f14741f;

    public b(int i4, String str, int i5, long j4, byte[] bArr, Bundle bundle) {
        this.f14740e = i4;
        this.f14736a = str;
        this.f14737b = i5;
        this.f14738c = j4;
        this.f14739d = bArr;
        this.f14741f = bundle;
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.f14736a + ", method: " + this.f14737b + " ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 1, this.f14736a, false);
        A1.c.t(parcel, 2, this.f14737b);
        A1.c.x(parcel, 3, this.f14738c);
        A1.c.k(parcel, 4, this.f14739d, false);
        A1.c.j(parcel, 5, this.f14741f, false);
        A1.c.t(parcel, 1000, this.f14740e);
        A1.c.b(parcel, iA);
    }
}
