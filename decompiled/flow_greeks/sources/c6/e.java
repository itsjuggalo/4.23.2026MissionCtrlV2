package c6;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.google.android.gms.identitycredentials.GetCredentialRequest;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    public static void c(GetCredentialRequest getCredentialRequest, Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.I(parcel, 1, getCredentialRequest.getCredentialOptions(), false);
        n5.c.j(parcel, 2, getCredentialRequest.getData(), false);
        n5.c.E(parcel, 3, getCredentialRequest.getOrigin(), false);
        n5.c.C(parcel, 4, getCredentialRequest.getResultReceiver(), i10, false);
        n5.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetCredentialRequest createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        ArrayList arrayListU = null;
        Bundle bundleF = null;
        String strQ = null;
        ResultReceiver resultReceiver = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                arrayListU = n5.b.u(parcel, iD, c.CREATOR);
            } else if (iW == 2) {
                bundleF = n5.b.f(parcel, iD);
            } else if (iW == 3) {
                strQ = n5.b.q(parcel, iD);
            } else if (iW != 4) {
                n5.b.L(parcel, iD);
            } else {
                resultReceiver = (ResultReceiver) n5.b.p(parcel, iD, ResultReceiver.CREATOR);
            }
        }
        n5.b.v(parcel, iM);
        return new GetCredentialRequest(arrayListU, bundleF, strQ, resultReceiver);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public GetCredentialRequest[] newArray(int i10) {
        return new GetCredentialRequest[i10];
    }
}
