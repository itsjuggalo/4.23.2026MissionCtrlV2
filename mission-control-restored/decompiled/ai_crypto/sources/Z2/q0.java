package Z2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class q0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = Q1.b.q(parcel, iD);
            } else if (iW == 4) {
                strQ3 = Q1.b.q(parcel, iD);
            } else if (iW == 5) {
                zX = Q1.b.x(parcel, iD);
            } else if (iW != 6) {
                Q1.b.L(parcel, iD);
            } else {
                strQ4 = Q1.b.q(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new O(strQ, strQ2, strQ3, zX, strQ4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new O[i7];
    }
}
