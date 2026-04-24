package d2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class l0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        int iF = 0;
        short sJ = 0;
        short sJ2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW == 2) {
                sJ = Q1.b.J(parcel, iD);
            } else if (iW != 3) {
                Q1.b.L(parcel, iD);
            } else {
                sJ2 = Q1.b.J(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1401H(iF, sJ, sJ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1401H[i7];
    }
}
