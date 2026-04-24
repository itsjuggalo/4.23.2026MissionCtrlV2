package I1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        ArrayList arrayListS = null;
        GoogleSignInAccount googleSignInAccount = null;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 2:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    arrayListS = Q1.b.s(parcel, iD);
                    break;
                case 5:
                    googleSignInAccount = (GoogleSignInAccount) Q1.b.p(parcel, iD, GoogleSignInAccount.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) Q1.b.p(parcel, iD, PendingIntent.CREATOR);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C0576a(strQ, strQ2, strQ3, arrayListS, googleSignInAccount, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0576a[i7];
    }
}
