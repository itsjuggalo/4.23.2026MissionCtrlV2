package S1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class K implements Parcelable.Creator {
    public static void a(J j4, Parcel parcel, int i4) {
        String str = j4.f4005a;
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 2, str, false);
        A1.c.C(parcel, 3, j4.f4006b, i4, false);
        A1.c.E(parcel, 4, j4.f4007c, false);
        A1.c.x(parcel, 5, j4.f4008d);
        A1.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        long jH = 0;
        String strQ = null;
        H h4 = null;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 2) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW == 3) {
                h4 = (H) A1.b.p(parcel, iD, H.CREATOR);
            } else if (iW == 4) {
                strQ2 = A1.b.q(parcel, iD);
            } else if (iW != 5) {
                A1.b.L(parcel, iD);
            } else {
                jH = A1.b.H(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new J(strQ, h4, strQ2, jH);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new J[i4];
    }
}
