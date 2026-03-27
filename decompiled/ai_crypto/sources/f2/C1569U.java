package f2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: f2.U, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1569U implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        int iF = 0;
        int iF2 = 0;
        int iF3 = 0;
        int iF4 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW == 2) {
                iF2 = Q1.b.F(parcel, iD);
            } else if (iW == 3) {
                iF3 = Q1.b.F(parcel, iD);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                iF4 = Q1.b.F(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1568T(iF, iF2, iF3, iF4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i7) {
        return new C1568T[i7];
    }
}
