package e2;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.u2f.api.common.RegisterRequestParams;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        Integer numG = null;
        Double dA = null;
        Uri uri = null;
        ArrayList arrayListU = null;
        ArrayList arrayListU2 = null;
        C1471a c1471a = null;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 2:
                    numG = Q1.b.G(parcel, iD);
                    break;
                case 3:
                    dA = Q1.b.A(parcel, iD);
                    break;
                case 4:
                    uri = (Uri) Q1.b.p(parcel, iD, Uri.CREATOR);
                    break;
                case 5:
                    arrayListU = Q1.b.u(parcel, iD, d.CREATOR);
                    break;
                case 6:
                    arrayListU2 = Q1.b.u(parcel, iD, e.CREATOR);
                    break;
                case 7:
                    c1471a = (C1471a) Q1.b.p(parcel, iD, C1471a.CREATOR);
                    break;
                case 8:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new RegisterRequestParams(numG, dA, uri, arrayListU, arrayListU2, c1471a, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new RegisterRequestParams[i7];
    }
}
