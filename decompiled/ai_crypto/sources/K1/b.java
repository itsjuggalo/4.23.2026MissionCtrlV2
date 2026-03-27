package K1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class b extends Q1.a {
    public static final Parcelable.Creator<b> CREATOR = new d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f3349g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f3350h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3351i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f3352j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f3353k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f3354l = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f3355m = 6;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f3356n = 7;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f3357o = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f3361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f3363f;

    public b(int i7, String str, int i8, long j7, byte[] bArr, Bundle bundle) {
        this.f3362e = i7;
        this.f3358a = str;
        this.f3359b = i8;
        this.f3360c = j7;
        this.f3361d = bArr;
        this.f3363f = bundle;
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.f3358a + ", method: " + this.f3359b + " ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, this.f3358a, false);
        Q1.c.t(parcel, 2, this.f3359b);
        Q1.c.x(parcel, 3, this.f3360c);
        Q1.c.k(parcel, 4, this.f3361d, false);
        Q1.c.j(parcel, 5, this.f3363f, false);
        Q1.c.t(parcel, 1000, this.f3362e);
        Q1.c.b(parcel, iA);
    }
}
