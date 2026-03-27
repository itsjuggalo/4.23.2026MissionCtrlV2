package Z2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class s0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = Q1.b.q(parcel, iD);
            } else if (iW == 3) {
                jH = Q1.b.H(parcel, iD);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                strQ3 = Q1.b.q(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new S(strQ, strQ2, jH, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new S[i7];
    }
}
