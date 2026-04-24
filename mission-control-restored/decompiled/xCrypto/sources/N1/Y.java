package N1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Y implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        byte[] bArrG = null;
        Double dA = null;
        String strQ = null;
        ArrayList arrayListU = null;
        Integer numG = null;
        E e4 = null;
        String strQ2 = null;
        C0462d c0462d = null;
        Long lI = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 2:
                    bArrG = A1.b.g(parcel, iD);
                    break;
                case 3:
                    dA = A1.b.A(parcel, iD);
                    break;
                case 4:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 5:
                    arrayListU = A1.b.u(parcel, iD, C0485v.CREATOR);
                    break;
                case 6:
                    numG = A1.b.G(parcel, iD);
                    break;
                case 7:
                    e4 = (E) A1.b.p(parcel, iD, E.CREATOR);
                    break;
                case 8:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                case 9:
                    c0462d = (C0462d) A1.b.p(parcel, iD, C0462d.CREATOR);
                    break;
                case 10:
                    lI = A1.b.I(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new C0487x(bArrG, dA, strQ, arrayListU, numG, e4, strQ2, c0462d, lI);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0487x[i4];
    }
}
