package e6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 extends n5.a {
    public static final Parcelable.Creator<i0> CREATOR = new j0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8418c;

    public i0(String str, String str2, String str3) {
        this.f8418c = str;
        this.f8416a = str2;
        this.f8417b = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, this.f8416a, false);
        n5.c.E(parcel, 2, this.f8417b, false);
        n5.c.E(parcel, 5, this.f8418c, false);
        n5.c.b(parcel, iA);
    }
}
