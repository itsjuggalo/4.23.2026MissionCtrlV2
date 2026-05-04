package m5;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends n5.a {
    public static final Parcelable.Creator<h0> CREATOR = new i0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f15926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f15930e;

    public h0(boolean z10, String str, int i10, int i11, long j10) {
        this.f15926a = z10;
        this.f15927b = str;
        this.f15928c = p0.a(i10) - 1;
        this.f15929d = s.a(i11) - 1;
        this.f15930e = j10;
    }

    public final String R() {
        return this.f15927b;
    }

    public final long S() {
        return this.f15930e;
    }

    public final int T() {
        return p0.a(this.f15928c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.g(parcel, 1, this.f15926a);
        n5.c.E(parcel, 2, this.f15927b, false);
        n5.c.t(parcel, 3, this.f15928c);
        n5.c.t(parcel, 4, this.f15929d);
        n5.c.x(parcel, 5, this.f15930e);
        n5.c.b(parcel, iA);
    }

    public final boolean zza() {
        return this.f15926a;
    }

    public final int zze() {
        return s.a(this.f15929d);
    }
}
