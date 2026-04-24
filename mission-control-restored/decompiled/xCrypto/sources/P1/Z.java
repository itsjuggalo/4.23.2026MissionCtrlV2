package P1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Z implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        boolean zX = true;
        long jH = 50;
        float fB = 0.0f;
        long jH2 = Long.MAX_VALUE;
        int iF = Integer.MAX_VALUE;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                zX = A1.b.x(parcel, iD);
            } else if (iW == 2) {
                jH = A1.b.H(parcel, iD);
            } else if (iW == 3) {
                fB = A1.b.B(parcel, iD);
            } else if (iW == 4) {
                jH2 = A1.b.H(parcel, iD);
            } else if (iW != 5) {
                A1.b.L(parcel, iD);
            } else {
                iF = A1.b.F(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new Y(zX, jH, fB, jH2, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i4) {
        return new Y[i4];
    }
}
