package d2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class w0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        Boolean boolY = null;
        String strQ2 = null;
        String strQ3 = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 2) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW == 3) {
                boolY = Q1.b.y(parcel, iD);
            } else if (iW == 4) {
                strQ2 = Q1.b.q(parcel, iD);
            } else if (iW != 5) {
                Q1.b.L(parcel, iD);
            } else {
                strQ3 = Q1.b.q(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1438k(strQ, boolY, strQ2, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1438k[i7];
    }
}
