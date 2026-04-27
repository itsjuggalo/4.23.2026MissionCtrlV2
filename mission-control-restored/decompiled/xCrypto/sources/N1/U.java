package N1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class U implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        C0488y c0488y = null;
        A a4 = null;
        byte[] bArrG = null;
        ArrayList arrayListU = null;
        Double dA = null;
        ArrayList arrayListU2 = null;
        C0475k c0475k = null;
        Integer numG = null;
        E e4 = null;
        String strQ = null;
        C0462d c0462d = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 2:
                    c0488y = (C0488y) A1.b.p(parcel, iD, C0488y.CREATOR);
                    break;
                case 3:
                    a4 = (A) A1.b.p(parcel, iD, A.CREATOR);
                    break;
                case 4:
                    bArrG = A1.b.g(parcel, iD);
                    break;
                case 5:
                    arrayListU = A1.b.u(parcel, iD, C0486w.CREATOR);
                    break;
                case 6:
                    dA = A1.b.A(parcel, iD);
                    break;
                case 7:
                    arrayListU2 = A1.b.u(parcel, iD, C0485v.CREATOR);
                    break;
                case 8:
                    c0475k = (C0475k) A1.b.p(parcel, iD, C0475k.CREATOR);
                    break;
                case 9:
                    numG = A1.b.G(parcel, iD);
                    break;
                case 10:
                    e4 = (E) A1.b.p(parcel, iD, E.CREATOR);
                    break;
                case 11:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 12:
                    c0462d = (C0462d) A1.b.p(parcel, iD, C0462d.CREATOR);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new C0484u(c0488y, a4, bArrG, arrayListU, dA, arrayListU2, c0475k, numG, e4, strQ, c0462d);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0484u[i4];
    }
}
