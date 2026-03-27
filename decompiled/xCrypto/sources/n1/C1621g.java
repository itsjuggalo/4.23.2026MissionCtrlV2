package n1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: n1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1621g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        int iF = 0;
        int iF2 = 0;
        int iF3 = 0;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    iF = A1.b.F(parcel, iD);
                    break;
                case 2:
                    jH = A1.b.H(parcel, iD);
                    break;
                case 3:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 4:
                    iF2 = A1.b.F(parcel, iD);
                    break;
                case 5:
                    iF3 = A1.b.F(parcel, iD);
                    break;
                case 6:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new C1615a(iF, jH, strQ, iF2, iF3, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C1615a[i4];
    }
}
