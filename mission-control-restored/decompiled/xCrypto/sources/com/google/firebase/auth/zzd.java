package com.google.firebase.auth;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: loaded from: classes.dex */
public final class zzd implements Parcelable.Creator<PhoneAuthProvider.ForceResendingToken> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneAuthProvider.ForceResendingToken createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            b.w(iD);
            b.L(parcel, iD);
        }
        b.v(parcel, iM);
        return new PhoneAuthProvider.ForceResendingToken();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneAuthProvider.ForceResendingToken[] newArray(int i4) {
        return new PhoneAuthProvider.ForceResendingToken[i4];
    }
}
