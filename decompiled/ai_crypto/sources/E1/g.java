package E1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        int iF = 0;
        int iF2 = 0;
        int iF3 = 0;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case 2:
                    jH = Q1.b.H(parcel, iD);
                    break;
                case 3:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    iF2 = Q1.b.F(parcel, iD);
                    break;
                case 5:
                    iF3 = Q1.b.F(parcel, iD);
                    break;
                case 6:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new a(iF, jH, strQ, iF2, iF3, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new a[i7];
    }
}
