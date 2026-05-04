package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        Account account = null;
        int iF = 0;
        int iF2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                iF = n5.b.F(parcel, iD);
            } else if (iW == 2) {
                account = (Account) n5.b.p(parcel, iD, Account.CREATOR);
            } else if (iW == 3) {
                iF2 = n5.b.F(parcel, iD);
            } else if (iW != 4) {
                n5.b.L(parcel, iD);
            } else {
                googleSignInAccount = (GoogleSignInAccount) n5.b.p(parcel, iD, GoogleSignInAccount.CREATOR);
            }
        }
        n5.b.v(parcel, iM);
        return new o0(iF, account, iF2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new o0[i10];
    }
}
