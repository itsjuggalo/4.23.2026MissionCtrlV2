package L1;

import M1.C0638a;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
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
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case 2:
                    arrayListU = Q1.b.u(parcel, iD, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) Q1.b.p(parcel, iD, Account.CREATOR);
                    break;
                case 4:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 5:
                    zX2 = Q1.b.x(parcel, iD);
                    break;
                case 6:
                    zX3 = Q1.b.x(parcel, iD);
                    break;
                case 7:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 8:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    arrayListU2 = Q1.b.u(parcel, iD, C0638a.CREATOR);
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new GoogleSignInOptions(iF, arrayListU, account, zX, zX2, zX3, strQ, strQ2, arrayListU2, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new GoogleSignInOptions[i7];
    }
}
