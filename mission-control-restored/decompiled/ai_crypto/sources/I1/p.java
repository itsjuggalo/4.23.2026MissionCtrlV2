package I1;

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
        int iM = Q1.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        ArrayList arrayListU = null;
        String strQ = null;
        Account account = null;
        String strQ2 = null;
        String strQ3 = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    arrayListU = Q1.b.u(parcel, iD, Scope.CREATOR);
                    break;
                case 2:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 3:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 4:
                    zX2 = Q1.b.x(parcel, iD);
                    break;
                case 5:
                    account = (Account) Q1.b.p(parcel, iD, Account.CREATOR);
                    break;
                case 6:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 7:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case 8:
                    zX3 = Q1.b.x(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new AuthorizationRequest(arrayListU, strQ, zX, zX2, account, strQ2, strQ3, zX3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new AuthorizationRequest[i7];
    }
}
