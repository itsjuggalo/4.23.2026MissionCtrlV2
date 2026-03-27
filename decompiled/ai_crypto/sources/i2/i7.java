package i2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class i7 implements Parcelable.Creator {
    public static void a(h7 h7Var, Parcel parcel, int i7) {
        int i8 = h7Var.f15819a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        Q1.c.E(parcel, 2, h7Var.f15820b, false);
        Q1.c.x(parcel, 3, h7Var.f15821c);
        Q1.c.z(parcel, 4, h7Var.f15822d, false);
        Q1.c.r(parcel, 5, null, false);
        Q1.c.E(parcel, 6, h7Var.f15823e, false);
        Q1.c.E(parcel, 7, h7Var.f15824f, false);
        Q1.c.o(parcel, 8, h7Var.f15825g, false);
        Q1.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        Long lI = null;
        Float fC = null;
        String strQ2 = null;
        String strQ3 = null;
        Double dA = null;
        long jH = 0;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case 2:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 3:
                    jH = Q1.b.H(parcel, iD);
                    break;
                case 4:
                    lI = Q1.b.I(parcel, iD);
                    break;
                case 5:
                    fC = Q1.b.C(parcel, iD);
                    break;
                case 6:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 7:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case 8:
                    dA = Q1.b.A(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new h7(iF, strQ, jH, lI, fC, strQ2, strQ3, dA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new h7[i7];
    }
}
