package f5;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        ArrayList arrayListU = null;
        Account account = null;
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListU2 = null;
        String strQ3 = null;
        int iF = 0;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    iF = n5.b.F(parcel, iD);
                    break;
                case 2:
                    arrayListU = n5.b.u(parcel, iD, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) n5.b.p(parcel, iD, Account.CREATOR);
                    break;
                case 4:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 5:
                    zX2 = n5.b.x(parcel, iD);
                    break;
                case 6:
                    zX3 = n5.b.x(parcel, iD);
                    break;
                case 7:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 8:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case 9:
                    arrayListU2 = n5.b.u(parcel, iD, g5.a.CREATOR);
                    break;
                case 10:
                    strQ3 = n5.b.q(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new GoogleSignInOptions(iF, arrayListU, account, zX, zX2, zX3, strQ, strQ2, arrayListU2, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new GoogleSignInOptions[i10];
    }
}
