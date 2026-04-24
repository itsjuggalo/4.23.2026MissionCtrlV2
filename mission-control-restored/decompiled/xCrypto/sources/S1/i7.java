package S1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class i7 implements Parcelable.Creator {
    public static void a(h7 h7Var, Parcel parcel, int i4) {
        int i5 = h7Var.f4660a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        A1.c.E(parcel, 2, h7Var.f4661b, false);
        A1.c.x(parcel, 3, h7Var.f4662c);
        A1.c.z(parcel, 4, h7Var.f4663d, false);
        A1.c.r(parcel, 5, null, false);
        A1.c.E(parcel, 6, h7Var.f4664e, false);
        A1.c.E(parcel, 7, h7Var.f4665f, false);
        A1.c.o(parcel, 8, h7Var.f4666g, false);
        A1.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        Long lI = null;
        Float fC = null;
        String strQ2 = null;
        String strQ3 = null;
        Double dA = null;
        long jH = 0;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    iF = A1.b.F(parcel, iD);
                    break;
                case 2:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 3:
                    jH = A1.b.H(parcel, iD);
                    break;
                case 4:
                    lI = A1.b.I(parcel, iD);
                    break;
                case 5:
                    fC = A1.b.C(parcel, iD);
                    break;
                case 6:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                case 7:
                    strQ3 = A1.b.q(parcel, iD);
                    break;
                case 8:
                    dA = A1.b.A(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new h7(iF, strQ, jH, lI, fC, strQ2, strQ3, dA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new h7[i4];
    }
}
