package a6;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        y yVar = null;
        a0 a0Var = null;
        byte[] bArrG = null;
        ArrayList arrayListU = null;
        Double dA = null;
        ArrayList arrayListU2 = null;
        k kVar = null;
        Integer numG = null;
        e0 e0Var = null;
        String strQ = null;
        d dVar = null;
        String strQ2 = null;
        ResultReceiver resultReceiver = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 2:
                    yVar = (y) n5.b.p(parcel, iD, y.CREATOR);
                    break;
                case 3:
                    a0Var = (a0) n5.b.p(parcel, iD, a0.CREATOR);
                    break;
                case 4:
                    bArrG = n5.b.g(parcel, iD);
                    break;
                case 5:
                    arrayListU = n5.b.u(parcel, iD, w.CREATOR);
                    break;
                case 6:
                    dA = n5.b.A(parcel, iD);
                    break;
                case 7:
                    arrayListU2 = n5.b.u(parcel, iD, v.CREATOR);
                    break;
                case 8:
                    kVar = (k) n5.b.p(parcel, iD, k.CREATOR);
                    break;
                case 9:
                    numG = n5.b.G(parcel, iD);
                    break;
                case 10:
                    e0Var = (e0) n5.b.p(parcel, iD, e0.CREATOR);
                    break;
                case 11:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 12:
                    dVar = (d) n5.b.p(parcel, iD, d.CREATOR);
                    break;
                case 13:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case 14:
                    resultReceiver = (ResultReceiver) n5.b.p(parcel, iD, ResultReceiver.CREATOR);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new u(yVar, a0Var, bArrG, arrayListU, dA, arrayListU2, kVar, numG, e0Var, strQ, dVar, strQ2, resultReceiver);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new u[i10];
    }
}
