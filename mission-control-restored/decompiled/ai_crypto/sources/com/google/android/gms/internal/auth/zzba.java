package com.google.android.gms.internal.auth;

import Q1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzba implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        int iF = 0;
        byte[] bArrG = null;
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
                bArrG = b.g(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new zzaz(iF, strQ, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new zzaz[i7];
    }
}
