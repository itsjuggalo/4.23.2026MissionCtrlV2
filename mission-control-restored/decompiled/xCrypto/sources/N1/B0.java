package N1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class B0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        byte[] bArrG = null;
        byte[] bArrG2 = null;
        byte[] bArrG3 = null;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                jH = A1.b.H(parcel, iD);
            } else if (iW == 2) {
                bArrG = A1.b.g(parcel, iD);
            } else if (iW == 3) {
                bArrG2 = A1.b.g(parcel, iD);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                bArrG3 = A1.b.g(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new A0(jH, bArrG, bArrG2, bArrG3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new A0[i4];
    }
}
