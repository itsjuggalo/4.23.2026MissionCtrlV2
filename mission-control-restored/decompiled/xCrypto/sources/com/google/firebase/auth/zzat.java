package com.google.firebase.auth;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzat implements Parcelable.Creator<TwitterAuthCredential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TwitterAuthCredential createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                strQ = b.q(parcel, iD);
            } else if (iW != 2) {
                b.L(parcel, iD);
            } else {
                strQ2 = b.q(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new TwitterAuthCredential(strQ, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TwitterAuthCredential[] newArray(int i4) {
        return new TwitterAuthCredential[i4];
    }
}
