package i2;

import android.os.Parcel;
import android.os.Parcelable;
import k4.C2105D;

/* JADX INFO: renamed from: i2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1838j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        h7 h7Var = null;
        String strQ3 = null;
        C1750J c1750j = null;
        C1750J c1750j2 = null;
        C1750J c1750j3 = null;
        long jH = 0;
        long jH2 = 0;
        long jH3 = 0;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 2:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    h7Var = (h7) Q1.b.p(parcel, iD, h7.CREATOR);
                    break;
                case 5:
                    jH = Q1.b.H(parcel, iD);
                    break;
                case 6:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 7:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case 8:
                    c1750j = (C1750J) Q1.b.p(parcel, iD, C1750J.CREATOR);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    jH2 = Q1.b.H(parcel, iD);
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    c1750j2 = (C1750J) Q1.b.p(parcel, iD, C1750J.CREATOR);
                    break;
                case 11:
                    jH3 = Q1.b.H(parcel, iD);
                    break;
                case 12:
                    c1750j3 = (C1750J) Q1.b.p(parcel, iD, C1750J.CREATOR);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C1830i(strQ, strQ2, h7Var, jH, zX, strQ3, c1750j, jH2, c1750j2, jH3, c1750j3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1830i[i7];
    }
}
