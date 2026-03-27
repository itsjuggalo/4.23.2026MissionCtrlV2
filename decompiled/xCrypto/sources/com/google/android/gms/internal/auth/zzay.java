package com.google.android.gms.internal.auth;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzay implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                iF = b.F(parcel, iD);
            } else if (iW != 2) {
                b.L(parcel, iD);
            } else {
                strQ = b.q(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new zzax(iF, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new zzax[i4];
    }
}
