package b5;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends n5.a {
    public static final Parcelable.Creator<a> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2940d;

    public a(int i10, boolean z10, long j10, boolean z11) {
        this.f2937a = i10;
        this.f2938b = z10;
        this.f2939c = j10;
        this.f2940d = z11;
    }

    public long R() {
        return this.f2939c;
    }

    public boolean S() {
        return this.f2940d;
    }

    public boolean T() {
        return this.f2938b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f2937a);
        n5.c.g(parcel, 2, T());
        n5.c.x(parcel, 3, R());
        n5.c.g(parcel, 4, S());
        n5.c.b(parcel, iA);
    }
}
