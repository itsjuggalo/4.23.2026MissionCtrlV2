package com.google.firebase.auth;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzau implements Parcelable.Creator<UserProfileChangeRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ UserProfileChangeRequest createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        boolean zX = false;
        boolean zX2 = false;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 2) {
                strQ = b.q(parcel, iD);
            } else if (iW == 3) {
                strQ2 = b.q(parcel, iD);
            } else if (iW == 4) {
                zX = b.x(parcel, iD);
            } else if (iW != 5) {
                b.L(parcel, iD);
            } else {
                zX2 = b.x(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new UserProfileChangeRequest(strQ, strQ2, zX, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ UserProfileChangeRequest[] newArray(int i4) {
        return new UserProfileChangeRequest[i4];
    }
}
