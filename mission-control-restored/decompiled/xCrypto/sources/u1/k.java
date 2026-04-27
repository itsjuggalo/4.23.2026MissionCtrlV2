package u1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = "";
        GoogleSignInAccount googleSignInAccount = null;
        String strQ2 = "";
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 4) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW == 7) {
                googleSignInAccount = (GoogleSignInAccount) A1.b.p(parcel, iD, GoogleSignInAccount.CREATOR);
            } else if (iW != 8) {
                A1.b.L(parcel, iD);
            } else {
                strQ2 = A1.b.q(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new SignInAccount(strQ, googleSignInAccount, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new SignInAccount[i4];
    }
}
