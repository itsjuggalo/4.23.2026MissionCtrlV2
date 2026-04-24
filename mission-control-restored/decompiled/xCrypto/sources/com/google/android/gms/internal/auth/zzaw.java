package com.google.android.gms.internal.auth;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzaw implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        int iF = 0;
        String strQ = null;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                iF = b.F(parcel, iD);
            } else if (iW == 2) {
                strQ = b.q(parcel, iD);
            } else if (iW != 3) {
                b.L(parcel, iD);
            } else {
                iF2 = b.F(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new zzav(iF, strQ, iF2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new zzav[i4];
    }
}
