package i2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: i2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1822h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        long jH = 0;
        long jH2 = 0;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                jH = Q1.b.H(parcel, iD);
            } else if (iW == 2) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW != 3) {
                Q1.b.L(parcel, iD);
            } else {
                jH2 = Q1.b.H(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1814g(jH, iF, jH2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1814g[i7];
    }
}
