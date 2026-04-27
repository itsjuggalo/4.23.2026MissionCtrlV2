package S1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class H6 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        byte[] bArrG = null;
        String strQ = null;
        Bundle bundleF = null;
        String strQ2 = null;
        long jH = 0;
        long jH2 = 0;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    jH = A1.b.H(parcel, iD);
                    break;
                case 2:
                    bArrG = A1.b.g(parcel, iD);
                    break;
                case 3:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 4:
                    bundleF = A1.b.f(parcel, iD);
                    break;
                case 5:
                    iF = A1.b.F(parcel, iD);
                    break;
                case 6:
                    jH2 = A1.b.H(parcel, iD);
                    break;
                case 7:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new G6(jH, bArrG, strQ, bundleF, iF, jH2, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new G6[i4];
    }
}
