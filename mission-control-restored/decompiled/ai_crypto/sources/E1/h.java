package E1;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        int iF = 0;
        int iF2 = 0;
        Account account = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW == 2) {
                iF2 = Q1.b.F(parcel, iD);
            } else if (iW == 3) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                account = (Account) Q1.b.p(parcel, iD, Account.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new b(iF, iF2, strQ, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new b[i7];
    }
}
