package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h2 extends n5.a {
    public static final Parcelable.Creator<h2> CREATOR = new i2();

    public h2(boolean z10) {
    }

    public final boolean equals(Object obj) {
        return obj instanceof h2;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(Boolean.FALSE);
    }

    public final String toString() {
        return "DevicePublicKeyExtension{devicePublicKey=false}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.g(parcel, 1, false);
        n5.c.b(parcel, iA);
    }
}
