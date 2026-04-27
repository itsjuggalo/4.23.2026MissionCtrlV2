package d2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import k4.C2105D;

/* JADX INFO: renamed from: d2.Y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1417Y implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        byte[] bArrG = null;
        Double dA = null;
        String strQ = null;
        ArrayList arrayListU = null;
        Integer numG = null;
        C1398E c1398e = null;
        String strQ2 = null;
        C1425d c1425d = null;
        Long lI = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 2:
                    bArrG = Q1.b.g(parcel, iD);
                    break;
                case 3:
                    dA = Q1.b.A(parcel, iD);
                    break;
                case 4:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 5:
                    arrayListU = Q1.b.u(parcel, iD, C1449v.CREATOR);
                    break;
                case 6:
                    numG = Q1.b.G(parcel, iD);
                    break;
                case 7:
                    c1398e = (C1398E) Q1.b.p(parcel, iD, C1398E.CREATOR);
                    break;
                case 8:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    c1425d = (C1425d) Q1.b.p(parcel, iD, C1425d.CREATOR);
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    lI = Q1.b.I(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C1451x(bArrG, dA, strQ, arrayListU, numG, c1398e, strQ2, c1425d, lI);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1451x[i7];
    }
}
