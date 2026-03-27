package u1;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import v1.C1883a;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
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
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    iF = A1.b.F(parcel, iD);
                    break;
                case 2:
                    arrayListU = A1.b.u(parcel, iD, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) A1.b.p(parcel, iD, Account.CREATOR);
                    break;
                case 4:
                    zX = A1.b.x(parcel, iD);
                    break;
                case 5:
                    zX2 = A1.b.x(parcel, iD);
                    break;
                case 6:
                    zX3 = A1.b.x(parcel, iD);
                    break;
                case 7:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 8:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                case 9:
                    arrayListU2 = A1.b.u(parcel, iD, C1883a.CREATOR);
                    break;
                case 10:
                    strQ3 = A1.b.q(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new GoogleSignInOptions(iF, arrayListU, account, zX, zX2, zX3, strQ, strQ2, arrayListU2, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new GoogleSignInOptions[i4];
    }
}
