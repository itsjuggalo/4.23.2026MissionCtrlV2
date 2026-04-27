package i2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class H6 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        byte[] bArrG = null;
        String strQ = null;
        Bundle bundleF = null;
        String strQ2 = null;
        long jH = 0;
        long jH2 = 0;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    jH = Q1.b.H(parcel, iD);
                    break;
                case 2:
                    bArrG = Q1.b.g(parcel, iD);
                    break;
                case 3:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    bundleF = Q1.b.f(parcel, iD);
                    break;
                case 5:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case 6:
                    jH2 = Q1.b.H(parcel, iD);
                    break;
                case 7:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new G6(jH, bArrG, strQ, bundleF, iF, jH2, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new G6[i7];
    }
}
