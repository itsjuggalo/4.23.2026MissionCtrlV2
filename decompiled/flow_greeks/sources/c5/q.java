package c5;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        boolean zX4 = false;
        ArrayList arrayListU = null;
        String strQ = null;
        Account account = null;
        String strQ2 = null;
        String strQ3 = null;
        Bundle bundleF = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    arrayListU = n5.b.u(parcel, iD, Scope.CREATOR);
                    break;
                case 2:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 3:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 4:
                    zX2 = n5.b.x(parcel, iD);
                    break;
                case 5:
                    account = (Account) n5.b.p(parcel, iD, Account.CREATOR);
                    break;
                case 6:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case 7:
                    strQ3 = n5.b.q(parcel, iD);
                    break;
                case 8:
                    zX3 = n5.b.x(parcel, iD);
                    break;
                case 9:
                    bundleF = n5.b.f(parcel, iD);
                    break;
                case 10:
                    zX4 = n5.b.x(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new AuthorizationRequest(arrayListU, strQ, zX, zX2, account, strQ2, strQ3, zX3, bundleF, zX4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new AuthorizationRequest[i10];
    }
}
