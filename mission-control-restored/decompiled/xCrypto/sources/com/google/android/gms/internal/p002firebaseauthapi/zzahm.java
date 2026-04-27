package com.google.android.gms.internal.p002firebaseauthapi;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzahm implements Parcelable.Creator<zzahn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzahn createFromParcel(Parcel parcel) {
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
        return new zzahn(strQ, strQ2, lI, strQ3, lI2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzahn[] newArray(int i4) {
        return new zzahn[i4];
    }
}
