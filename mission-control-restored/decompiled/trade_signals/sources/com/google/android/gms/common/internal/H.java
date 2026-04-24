package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: loaded from: classes.dex */
public final class H implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        Account account = null;
        int iR = 0;
        int iR2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 1) {
                iR = T1.b.r(parcel, iP);
            } else if (iK == 2) {
                account = (Account) T1.b.e(parcel, iP, Account.CREATOR);
            } else if (iK == 3) {
                iR2 = T1.b.r(parcel, iP);
            } else if (iK != 4) {
                T1.b.v(parcel, iP);
            } else {
                googleSignInAccount = (GoogleSignInAccount) T1.b.e(parcel, iP, GoogleSignInAccount.CREATOR);
            }
        }
        T1.b.j(parcel, iW);
        return new G(iR, account, iR2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new G[i8];
    }
}
