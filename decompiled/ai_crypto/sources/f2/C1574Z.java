package f2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: f2.Z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1574Z implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        boolean zX = true;
        long jH = 50;
        float fB = 0.0f;
        long jH2 = Long.MAX_VALUE;
        int iF = Integer.MAX_VALUE;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                zX = Q1.b.x(parcel, iD);
            } else if (iW == 2) {
                jH = Q1.b.H(parcel, iD);
            } else if (iW == 3) {
                fB = Q1.b.B(parcel, iD);
            } else if (iW == 4) {
                jH2 = Q1.b.H(parcel, iD);
            } else if (iW != 5) {
                Q1.b.L(parcel, iD);
            } else {
                iF = Q1.b.F(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1573Y(zX, jH, fB, jH2, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i7) {
        return new C1573Y[i7];
    }
}
