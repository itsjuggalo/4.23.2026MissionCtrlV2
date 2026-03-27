package P1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class U implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        int iF = 0;
        int iF2 = 0;
        int iF3 = 0;
        int iF4 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF = A1.b.F(parcel, iD);
            } else if (iW == 2) {
                iF2 = A1.b.F(parcel, iD);
            } else if (iW == 3) {
                iF3 = A1.b.F(parcel, iD);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                iF4 = A1.b.F(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new T(iF, iF2, iF3, iF4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i4) {
        return new T[i4];
    }
}
