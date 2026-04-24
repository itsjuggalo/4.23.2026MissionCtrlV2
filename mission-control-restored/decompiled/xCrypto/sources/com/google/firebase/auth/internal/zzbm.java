package com.google.firebase.auth.internal;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbm implements Parcelable.Creator<zzbj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbj createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        ArrayList arrayListU = null;
        ArrayList arrayListU2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                arrayListU = b.u(parcel, iD, PhoneMultiFactorInfo.CREATOR);
            } else if (iW != 2) {
                b.L(parcel, iD);
            } else {
                arrayListU2 = b.u(parcel, iD, TotpMultiFactorInfo.CREATOR);
            }
        }
        b.v(parcel, iM);
        return new zzbj(arrayListU, arrayListU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbj[] newArray(int i4) {
        return new zzbj[i4];
    }
}
