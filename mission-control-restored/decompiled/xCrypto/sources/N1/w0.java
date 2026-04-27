package N1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class w0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        Boolean boolY = null;
        String strQ2 = null;
        String strQ3 = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 2) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW == 3) {
                boolY = A1.b.y(parcel, iD);
            } else if (iW == 4) {
                strQ2 = A1.b.q(parcel, iD);
            } else if (iW != 5) {
                A1.b.L(parcel, iD);
            } else {
                strQ3 = A1.b.q(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new C0475k(strQ, boolY, strQ2, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0475k[i4];
    }
}
