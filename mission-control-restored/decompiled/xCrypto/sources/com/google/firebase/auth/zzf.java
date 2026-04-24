package com.google.firebase.auth;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzf implements Parcelable.Creator<EmailAuthCredential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ EmailAuthCredential createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                strQ = b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = b.q(parcel, iD);
            } else if (iW == 3) {
                strQ3 = b.q(parcel, iD);
            } else if (iW == 4) {
                strQ4 = b.q(parcel, iD);
            } else if (iW != 5) {
                b.L(parcel, iD);
            } else {
                zX = b.x(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new EmailAuthCredential(strQ, strQ2, strQ3, strQ4, zX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ EmailAuthCredential[] newArray(int i4) {
        return new EmailAuthCredential[i4];
    }
}
