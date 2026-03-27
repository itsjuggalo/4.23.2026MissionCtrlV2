package P1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class O implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        int iF = 1;
        int iF2 = 1;
        long jH = -1;
        long jH2 = -1;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF = A1.b.F(parcel, iD);
            } else if (iW == 2) {
                iF2 = A1.b.F(parcel, iD);
            } else if (iW == 3) {
                jH = A1.b.H(parcel, iD);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                jH2 = A1.b.H(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new N(iF, iF2, jH, jH2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i4) {
        return new N[i4];
    }
}
