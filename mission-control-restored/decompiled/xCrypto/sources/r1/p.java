package r1;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        ArrayList arrayListU = null;
        String strQ = null;
        Account account = null;
        String strQ2 = null;
        String strQ3 = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    arrayListU = A1.b.u(parcel, iD, Scope.CREATOR);
                    break;
                case 2:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 3:
                    zX = A1.b.x(parcel, iD);
                    break;
                case 4:
                    zX2 = A1.b.x(parcel, iD);
                    break;
                case 5:
                    account = (Account) A1.b.p(parcel, iD, Account.CREATOR);
                    break;
                case 6:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                case 7:
                    strQ3 = A1.b.q(parcel, iD);
                    break;
                case 8:
                    zX3 = A1.b.x(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new AuthorizationRequest(arrayListU, strQ, zX, zX2, account, strQ2, strQ3, zX3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new AuthorizationRequest[i4];
    }
}
