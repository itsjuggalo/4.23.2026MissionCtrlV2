package b6;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.u2f.api.common.RegisterRequestParams;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        Integer numG = null;
        Double dA = null;
        Uri uri = null;
        ArrayList arrayListU = null;
        ArrayList arrayListU2 = null;
        a aVar = null;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 2:
                    numG = n5.b.G(parcel, iD);
                    break;
                case 3:
                    dA = n5.b.A(parcel, iD);
                    break;
                case 4:
                    uri = (Uri) n5.b.p(parcel, iD, Uri.CREATOR);
                    break;
                case 5:
                    arrayListU = n5.b.u(parcel, iD, d.CREATOR);
                    break;
                case 6:
                    arrayListU2 = n5.b.u(parcel, iD, e.CREATOR);
                    break;
                case 7:
                    aVar = (a) n5.b.p(parcel, iD, a.CREATOR);
                    break;
                case 8:
                    strQ = n5.b.q(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new RegisterRequestParams(numG, dA, uri, arrayListU, arrayListU2, aVar, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new RegisterRequestParams[i10];
    }
}
