package com.google.firebase.auth.internal;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzw implements Parcelable.Creator<zzx> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzx createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        boolean zX = false;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                strQ = b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = b.q(parcel, iD);
            } else if (iW != 3) {
                b.L(parcel, iD);
            } else {
                zX = b.x(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new zzx(strQ, strQ2, zX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzx[] newArray(int i4) {
        return new zzx[i4];
    }
}
