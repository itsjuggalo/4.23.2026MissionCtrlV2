package com.google.firebase.auth.internal;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzap implements Parcelable.Creator<zzam> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzam createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListU = null;
        ArrayList arrayListU2 = null;
        zzaf zzafVar = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                strQ = b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = b.q(parcel, iD);
            } else if (iW == 3) {
                arrayListU = b.u(parcel, iD, PhoneMultiFactorInfo.CREATOR);
            } else if (iW == 4) {
                arrayListU2 = b.u(parcel, iD, TotpMultiFactorInfo.CREATOR);
            } else if (iW != 5) {
                b.L(parcel, iD);
            } else {
                zzafVar = (zzaf) b.p(parcel, iD, zzaf.CREATOR);
            }
        }
        b.v(parcel, iM);
        return new zzam(strQ, strQ2, arrayListU, arrayListU2, zzafVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzam[] newArray(int i4) {
        return new zzam[i4];
    }
}
