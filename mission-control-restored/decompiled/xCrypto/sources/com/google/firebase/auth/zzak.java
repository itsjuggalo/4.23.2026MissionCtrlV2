package com.google.firebase.auth;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzak implements Parcelable.Creator<GoogleAuthCredential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleAuthCredential createFromParcel(Parcel parcel) {
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
        return new GoogleAuthCredential(strQ, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleAuthCredential[] newArray(int i4) {
        return new GoogleAuthCredential[i4];
    }
}
