package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import n5.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzahu implements Parcelable.Creator<zzahv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzahv createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        Long lI = null;
        String strQ3 = null;
        Long lI2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 2) {
                strQ = b.q(parcel, iD);
            } else if (iW == 3) {
                strQ2 = b.q(parcel, iD);
            } else if (iW == 4) {
                lI = b.I(parcel, iD);
            } else if (iW == 5) {
                strQ3 = b.q(parcel, iD);
            } else if (iW != 6) {
                b.L(parcel, iD);
            } else {
                lI2 = b.I(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new zzahv(strQ, strQ2, lI, strQ3, lI2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzahv[] newArray(int i10) {
        return new zzahv[i10];
    }
}
