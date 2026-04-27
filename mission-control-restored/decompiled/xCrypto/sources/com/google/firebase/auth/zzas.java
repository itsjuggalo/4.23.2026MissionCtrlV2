package com.google.firebase.auth;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzair;

/* JADX INFO: loaded from: classes.dex */
public final class zzas implements Parcelable.Creator<TotpMultiFactorInfo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TotpMultiFactorInfo createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        zzair zzairVar = null;
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
                zzairVar = (zzair) b.p(parcel, iD, zzair.CREATOR);
            }
        }
        b.v(parcel, iM);
        return new TotpMultiFactorInfo(strQ, strQ2, jH, zzairVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TotpMultiFactorInfo[] newArray(int i4) {
        return new TotpMultiFactorInfo[i4];
    }
}
