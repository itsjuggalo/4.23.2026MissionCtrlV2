package L1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
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
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case 2:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case 5:
                    strQ4 = Q1.b.q(parcel, iD);
                    break;
                case 6:
                    uri = (Uri) Q1.b.p(parcel, iD, Uri.CREATOR);
                    break;
                case 7:
                    strQ5 = Q1.b.q(parcel, iD);
                    break;
                case 8:
                    jH = Q1.b.H(parcel, iD);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    strQ6 = Q1.b.q(parcel, iD);
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    arrayListU = Q1.b.u(parcel, iD, Scope.CREATOR);
                    break;
                case 11:
                    strQ7 = Q1.b.q(parcel, iD);
                    break;
                case 12:
                    strQ8 = Q1.b.q(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new GoogleSignInAccount(iF, strQ, strQ2, strQ3, strQ4, uri, strQ5, jH, strQ6, arrayListU, strQ7, strQ8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new GoogleSignInAccount[i7];
    }
}
