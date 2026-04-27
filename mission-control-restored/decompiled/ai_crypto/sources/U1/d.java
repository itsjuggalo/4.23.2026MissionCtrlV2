package U1;

import U1.a;
import android.os.Parcel;
import android.os.Parcelable;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        T1.b bVar = null;
        int iF = 0;
        int iF2 = 0;
        boolean zX = false;
        int iF3 = 0;
        boolean zX2 = false;
        int iF4 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case 2:
                    iF2 = Q1.b.F(parcel, iD);
                    break;
                case 3:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 4:
                    iF3 = Q1.b.F(parcel, iD);
                    break;
                case 5:
                    zX2 = Q1.b.x(parcel, iD);
                    break;
                case 6:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 7:
                    iF4 = Q1.b.F(parcel, iD);
                    break;
                case 8:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    bVar = (T1.b) Q1.b.p(parcel, iD, T1.b.CREATOR);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new a.C0083a(iF, iF2, zX, iF3, zX2, strQ, iF4, strQ2, bVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new a.C0083a[i7];
    }
}
