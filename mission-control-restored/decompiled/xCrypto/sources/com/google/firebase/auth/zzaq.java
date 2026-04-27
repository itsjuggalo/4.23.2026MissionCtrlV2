package com.google.firebase.auth;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzaq implements Parcelable.Creator<PhoneMultiFactorInfo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneMultiFactorInfo createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                strQ = b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = b.q(parcel, iD);
            } else if (iW == 3) {
                jH = b.H(parcel, iD);
            } else if (iW != 4) {
                b.L(parcel, iD);
            } else {
                strQ3 = b.q(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new PhoneMultiFactorInfo(strQ, strQ2, jH, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneMultiFactorInfo[] newArray(int i4) {
        return new PhoneMultiFactorInfo[i4];
    }
}
