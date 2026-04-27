package K1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        byte[] bArrG = null;
        Bundle bundleF = null;
        long jH = 0;
        int iF = 0;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW == 2) {
                iF2 = Q1.b.F(parcel, iD);
            } else if (iW == 3) {
                jH = Q1.b.H(parcel, iD);
            } else if (iW == 4) {
                bArrG = Q1.b.g(parcel, iD);
            } else if (iW == 5) {
                bundleF = Q1.b.f(parcel, iD);
            } else if (iW != 1000) {
                Q1.b.L(parcel, iD);
            } else {
                iF = Q1.b.F(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new b(iF, strQ, iF2, jH, bArrG, bundleF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new b[i7];
    }
}
