package q1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        int iF = 0;
        boolean zX = false;
        boolean zX2 = false;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF = A1.b.F(parcel, iD);
            } else if (iW == 2) {
                zX = A1.b.x(parcel, iD);
            } else if (iW == 3) {
                jH = A1.b.H(parcel, iD);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                zX2 = A1.b.x(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new C1719a(iF, zX, jH, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C1719a[i4];
    }
}
