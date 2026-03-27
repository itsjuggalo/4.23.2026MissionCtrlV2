package N1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class l0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        int iF = 0;
        short sJ = 0;
        short sJ2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF = A1.b.F(parcel, iD);
            } else if (iW == 2) {
                sJ = A1.b.J(parcel, iD);
            } else if (iW != 3) {
                A1.b.L(parcel, iD);
            } else {
                sJ2 = A1.b.J(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new H(iF, sJ, sJ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new H[i4];
    }
}
