package t1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        byte[] bArrG = null;
        Bundle bundleF = null;
        long jH = 0;
        int iF = 0;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW == 2) {
                iF2 = A1.b.F(parcel, iD);
            } else if (iW == 3) {
                jH = A1.b.H(parcel, iD);
            } else if (iW == 4) {
                bArrG = A1.b.g(parcel, iD);
            } else if (iW == 5) {
                bundleF = A1.b.f(parcel, iD);
            } else if (iW != 1000) {
                A1.b.L(parcel, iD);
            } else {
                iF = A1.b.F(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new b(iF, strQ, iF2, jH, bArrG, bundleF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new b[i4];
    }
}
