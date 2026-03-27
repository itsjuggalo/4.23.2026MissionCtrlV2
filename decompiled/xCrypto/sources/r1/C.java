package r1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class C implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        int iF = 0;
        m mVar = null;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                mVar = (m) A1.b.p(parcel, iD, m.CREATOR);
            } else if (iW == 2) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW != 3) {
                A1.b.L(parcel, iD);
            } else {
                iF = A1.b.F(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new i(mVar, strQ, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new i[i4];
    }
}
