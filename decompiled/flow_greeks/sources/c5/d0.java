package c5;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.RevokeAccessRequest;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        ArrayList arrayListU = null;
        Account account = null;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                arrayListU = n5.b.u(parcel, iD, Scope.CREATOR);
            } else if (iW == 2) {
                account = (Account) n5.b.p(parcel, iD, Account.CREATOR);
            } else if (iW != 3) {
                n5.b.L(parcel, iD);
            } else {
                strQ = n5.b.q(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new RevokeAccessRequest(arrayListU, account, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new RevokeAccessRequest[i10];
    }
}
