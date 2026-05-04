package a6;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        byte[] bArrG = null;
        Double dA = null;
        String strQ = null;
        ArrayList arrayListU = null;
        Integer numG = null;
        e0 e0Var = null;
        String strQ2 = null;
        d dVar = null;
        Long lI = null;
        String strQ3 = null;
        ResultReceiver resultReceiver = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 2:
                    bArrG = n5.b.g(parcel, iD);
                    break;
                case 3:
                    dA = n5.b.A(parcel, iD);
                    break;
                case 4:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 5:
                    arrayListU = n5.b.u(parcel, iD, v.CREATOR);
                    break;
                case 6:
                    numG = n5.b.G(parcel, iD);
                    break;
                case 7:
                    e0Var = (e0) n5.b.p(parcel, iD, e0.CREATOR);
                    break;
                case 8:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case 9:
                    dVar = (d) n5.b.p(parcel, iD, d.CREATOR);
                    break;
                case 10:
                    lI = n5.b.I(parcel, iD);
                    break;
                case 11:
                    strQ3 = n5.b.q(parcel, iD);
                    break;
                case 12:
                    resultReceiver = (ResultReceiver) n5.b.p(parcel, iD, ResultReceiver.CREATOR);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new x(bArrG, dA, strQ, arrayListU, numG, e0Var, strQ2, dVar, lI, strQ3, resultReceiver);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new x[i10];
    }
}
