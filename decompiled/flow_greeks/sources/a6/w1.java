package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        byte[] bArrG = null;
        byte[] bArrG2 = null;
        byte[] bArrG3 = null;
        byte[] bArrG4 = null;
        byte[] bArrG5 = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 2) {
                bArrG = n5.b.g(parcel, iD);
            } else if (iW == 3) {
                bArrG2 = n5.b.g(parcel, iD);
            } else if (iW == 4) {
                bArrG3 = n5.b.g(parcel, iD);
            } else if (iW == 5) {
                bArrG4 = n5.b.g(parcel, iD);
            } else if (iW != 6) {
                n5.b.L(parcel, iD);
            } else {
                bArrG5 = n5.b.g(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new g(bArrG, bArrG2, bArrG3, bArrG4, bArrG5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new g[i10];
    }
}
