package n1;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: n1.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1622h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        int iF = 0;
        int iF2 = 0;
        Account account = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF = A1.b.F(parcel, iD);
            } else if (iW == 2) {
                iF2 = A1.b.F(parcel, iD);
            } else if (iW == 3) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                account = (Account) A1.b.p(parcel, iD, Account.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new C1616b(iF, iF2, strQ, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C1616b[i4];
    }
}
