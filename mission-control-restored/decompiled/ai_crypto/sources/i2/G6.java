package i2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class G6 extends Q1.a {
    public static final Parcelable.Creator<G6> CREATOR = new H6();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f15136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f15138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f15139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f15140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f15141g;

    public G6(long j7, byte[] bArr, String str, Bundle bundle, int i7, long j8, String str2) {
        this.f15135a = j7;
        this.f15136b = bArr;
        this.f15137c = str;
        this.f15138d = bundle;
        this.f15139e = i7;
        this.f15140f = j8;
        this.f15141g = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        long j7 = this.f15135a;
        int iA = Q1.c.a(parcel);
        Q1.c.x(parcel, 1, j7);
        Q1.c.k(parcel, 2, this.f15136b, false);
        Q1.c.E(parcel, 3, this.f15137c, false);
        Q1.c.j(parcel, 4, this.f15138d, false);
        Q1.c.t(parcel, 5, this.f15139e);
        Q1.c.x(parcel, 6, this.f15140f);
        Q1.c.E(parcel, 7, this.f15141g, false);
        Q1.c.b(parcel, iA);
    }
}
