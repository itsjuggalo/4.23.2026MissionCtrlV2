package i2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: i2.K, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1751K implements Parcelable.Creator {
    public static void a(C1750J c1750j, Parcel parcel, int i7) {
        String str = c1750j.f15164a;
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 2, str, false);
        Q1.c.C(parcel, 3, c1750j.f15165b, i7, false);
        Q1.c.E(parcel, 4, c1750j.f15166c, false);
        Q1.c.x(parcel, 5, c1750j.f15167d);
        Q1.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        long jH = 0;
        String strQ = null;
        C1748H c1748h = null;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 2) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW == 3) {
                c1748h = (C1748H) Q1.b.p(parcel, iD, C1748H.CREATOR);
            } else if (iW == 4) {
                strQ2 = Q1.b.q(parcel, iD);
            } else if (iW != 5) {
                Q1.b.L(parcel, iD);
            } else {
                jH = Q1.b.H(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1750J(strQ, c1748h, strQ2, jH);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1750J[i7];
    }
}
