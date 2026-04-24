package f2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: f2.O, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1564O implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        int iF = 1;
        int iF2 = 1;
        long jH = -1;
        long jH2 = -1;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW == 2) {
                iF2 = Q1.b.F(parcel, iD);
            } else if (iW == 3) {
                jH = Q1.b.H(parcel, iD);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                jH2 = Q1.b.H(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1563N(iF, iF2, jH, jH2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i7) {
        return new C1563N[i7];
    }
}
