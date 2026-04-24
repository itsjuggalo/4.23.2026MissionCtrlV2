package com.google.firebase.auth;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzg implements Parcelable.Creator<FacebookAuthCredential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FacebookAuthCredential createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            if (b.w(iD) != 1) {
                b.L(parcel, iD);
            } else {
                strQ = b.q(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new FacebookAuthCredential(strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FacebookAuthCredential[] newArray(int i4) {
        return new FacebookAuthCredential[i4];
    }
}
