package N1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class q0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        byte[] bArrG = null;
        byte[] bArrG2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                bArrG = A1.b.g(parcel, iD);
            } else if (iW != 2) {
                A1.b.L(parcel, iD);
            } else {
                bArrG2 = A1.b.g(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new p0(bArrG, bArrG2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new p0[i4];
    }
}
