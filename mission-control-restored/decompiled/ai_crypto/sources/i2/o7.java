package i2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public final class o7 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        boolean zX = false;
        int iF = 0;
        boolean zX2 = false;
        boolean zX3 = false;
        int iF2 = 0;
        int iF3 = 0;
        long jH = 0;
        long jH2 = 0;
        long jH3 = 0;
        long jH4 = 0;
        long jH5 = 0;
        long jH6 = 0;
        long jH7 = 0;
        String strQ = "";
        String strQ2 = strQ;
        String strQ3 = strQ2;
        String strQ4 = strQ3;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        String strQ8 = null;
        String strQ9 = null;
        String strQ10 = null;
        Boolean boolY = null;
        ArrayList arrayListS = null;
        String strQ11 = null;
        String strQ12 = null;
        int iF4 = 100;
        boolean zX4 = true;
        boolean zX5 = true;
        long jH8 = -2147483648L;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 2:
                    strQ5 = Q1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ6 = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    strQ7 = Q1.b.q(parcel, iD);
                    break;
                case 5:
                    strQ8 = Q1.b.q(parcel, iD);
                    break;
                case 6:
                    jH = Q1.b.H(parcel, iD);
                    break;
                case 7:
                    jH2 = Q1.b.H(parcel, iD);
                    break;
                case 8:
                    strQ9 = Q1.b.q(parcel, iD);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    zX4 = Q1.b.x(parcel, iD);
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 11:
                    jH8 = Q1.b.H(parcel, iD);
                    break;
                case 12:
                    strQ10 = Q1.b.q(parcel, iD);
                    break;
                case 13:
                case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                case 19:
                case 20:
                case 24:
                case 33:
                default:
                    Q1.b.L(parcel, iD);
                    break;
                case 14:
                    jH3 = Q1.b.H(parcel, iD);
                    break;
                case 15:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case com.amazon.c.a.a.c.f10119g /* 16 */:
                    zX5 = Q1.b.x(parcel, iD);
                    break;
                case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    zX2 = Q1.b.x(parcel, iD);
                    break;
                case 21:
                    boolY = Q1.b.y(parcel, iD);
                    break;
                case 22:
                    jH4 = Q1.b.H(parcel, iD);
                    break;
                case 23:
                    arrayListS = Q1.b.s(parcel, iD);
                    break;
                case 25:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 26:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 27:
                    strQ11 = Q1.b.q(parcel, iD);
                    break;
                case 28:
                    zX3 = Q1.b.x(parcel, iD);
                    break;
                case 29:
                    jH5 = Q1.b.H(parcel, iD);
                    break;
                case 30:
                    iF4 = Q1.b.F(parcel, iD);
                    break;
                case 31:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case com.amazon.c.a.a.c.f10120h /* 32 */:
                    iF2 = Q1.b.F(parcel, iD);
                    break;
                case 34:
                    jH6 = Q1.b.H(parcel, iD);
                    break;
                case 35:
                    strQ12 = Q1.b.q(parcel, iD);
                    break;
                case 36:
                    strQ4 = Q1.b.q(parcel, iD);
                    break;
                case 37:
                    jH7 = Q1.b.H(parcel, iD);
                    break;
                case 38:
                    iF3 = Q1.b.F(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new n7(strQ5, strQ6, strQ7, strQ8, jH, jH2, strQ9, zX4, zX, jH8, strQ10, jH3, iF, zX5, zX2, boolY, jH4, arrayListS, strQ, strQ2, strQ11, zX3, jH5, iF4, strQ3, iF2, jH6, strQ12, strQ4, jH7, iF3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new n7[i7];
    }
}
