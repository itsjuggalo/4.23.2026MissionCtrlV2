package E1;

import E1.a;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        int iF = 0;
        a.C0016a c0016a = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF = A1.b.F(parcel, iD);
            } else if (iW == 2) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW != 3) {
                A1.b.L(parcel, iD);
            } else {
                c0016a = (a.C0016a) A1.b.p(parcel, iD, a.C0016a.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new g(iF, strQ, c0016a);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new g[i4];
    }
}
