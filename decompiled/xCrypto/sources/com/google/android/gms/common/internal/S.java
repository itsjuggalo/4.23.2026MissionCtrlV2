package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: loaded from: classes.dex */
public final class S implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        Account account = null;
        int iF = 0;
        int iF2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF = A1.b.F(parcel, iD);
            } else if (iW == 2) {
                account = (Account) A1.b.p(parcel, iD, Account.CREATOR);
            } else if (iW == 3) {
                iF2 = A1.b.F(parcel, iD);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                googleSignInAccount = (GoogleSignInAccount) A1.b.p(parcel, iD, GoogleSignInAccount.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new Q(iF, account, iF2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new Q[i4];
    }
}
