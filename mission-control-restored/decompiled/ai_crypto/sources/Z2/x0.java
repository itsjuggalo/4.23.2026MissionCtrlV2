package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public final class x0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        String strQ8 = null;
        boolean zX = false;
        boolean zX2 = false;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 2:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    strQ4 = Q1.b.q(parcel, iD);
                    break;
                case 5:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 6:
                    strQ5 = Q1.b.q(parcel, iD);
                    break;
                case 7:
                    zX2 = Q1.b.x(parcel, iD);
                    break;
                case 8:
                    strQ6 = Q1.b.q(parcel, iD);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    strQ7 = Q1.b.q(parcel, iD);
                    break;
                case 11:
                    strQ8 = Q1.b.q(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C0753e(strQ, strQ2, strQ3, strQ4, zX, strQ5, zX2, strQ6, iF, strQ7, strQ8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0753e[i7];
    }
}
