package g5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        String strQ = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 2) {
                strQ = n5.b.q(parcel, iD);
            } else if (iW != 5) {
                n5.b.L(parcel, iD);
            } else {
                googleSignInOptions = (GoogleSignInOptions) n5.b.p(parcel, iD, GoogleSignInOptions.CREATOR);
            }
        }
        n5.b.v(parcel, iM);
        return new SignInConfiguration(strQ, googleSignInOptions);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new SignInConfiguration[i10];
    }
}
