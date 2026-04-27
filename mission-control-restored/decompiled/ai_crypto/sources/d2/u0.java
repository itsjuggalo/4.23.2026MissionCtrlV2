package d2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class u0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        byte[] bArrG = null;
        byte[] bArrG2 = null;
        byte[] bArrG3 = null;
        String[] strArrR = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 2) {
                bArrG = Q1.b.g(parcel, iD);
            } else if (iW == 3) {
                bArrG2 = Q1.b.g(parcel, iD);
            } else if (iW == 4) {
                bArrG3 = Q1.b.g(parcel, iD);
            } else if (iW != 5) {
                Q1.b.L(parcel, iD);
            } else {
                strArrR = Q1.b.r(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1433h(bArrG, bArrG2, bArrG3, strArrR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1433h[i7];
    }
}
