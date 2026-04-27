package com.google.firebase.auth.internal;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzag implements Parcelable.Creator<zzah> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzah createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        long jH = 0;
        long jH2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                jH = b.H(parcel, iD);
            } else if (iW != 2) {
                b.L(parcel, iD);
            } else {
                jH2 = b.H(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new zzah(jH, jH2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzah[] newArray(int i4) {
        return new zzah[i4];
    }
}
