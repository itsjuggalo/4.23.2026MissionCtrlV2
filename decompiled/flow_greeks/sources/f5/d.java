package f5;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        Uri uri = null;
        String strQ5 = null;
        String strQ6 = null;
        ArrayList arrayListU = null;
        String strQ7 = null;
        String strQ8 = null;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 2:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case 4:
                    strQ3 = n5.b.q(parcel, iD);
                    break;
                case 5:
                    strQ4 = n5.b.q(parcel, iD);
                    break;
                case 6:
                    uri = (Uri) n5.b.p(parcel, iD, Uri.CREATOR);
                    break;
                case 7:
                    strQ5 = n5.b.q(parcel, iD);
                    break;
                case 8:
                    jH = n5.b.H(parcel, iD);
                    break;
                case 9:
                    strQ6 = n5.b.q(parcel, iD);
                    break;
                case 10:
                    arrayListU = n5.b.u(parcel, iD, Scope.CREATOR);
                    break;
                case 11:
                    strQ7 = n5.b.q(parcel, iD);
                    break;
                case 12:
                    strQ8 = n5.b.q(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new GoogleSignInAccount(strQ, strQ2, strQ3, strQ4, uri, strQ5, jH, strQ6, arrayListU, strQ7, strQ8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new GoogleSignInAccount[i10];
    }
}
