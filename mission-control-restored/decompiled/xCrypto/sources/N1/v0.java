package N1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class v0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        int iF = 0;
        String strQ = null;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 2) {
                iF = A1.b.F(parcel, iD);
            } else if (iW == 3) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                iF2 = A1.b.F(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new C0472i(iF, strQ, iF2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0472i[i4];
    }
}
