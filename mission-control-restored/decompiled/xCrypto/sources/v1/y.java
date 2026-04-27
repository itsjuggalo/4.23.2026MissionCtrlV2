package v1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class y implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 2) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW != 5) {
                A1.b.L(parcel, iD);
            } else {
                googleSignInOptions = (GoogleSignInOptions) A1.b.p(parcel, iD, GoogleSignInOptions.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new SignInConfiguration(strQ, googleSignInOptions);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new SignInConfiguration[i4];
    }
}
