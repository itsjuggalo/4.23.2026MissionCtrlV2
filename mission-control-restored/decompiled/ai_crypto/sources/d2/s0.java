package d2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class s0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        byte[] bArrG = null;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                zX = Q1.b.x(parcel, iD);
            } else if (iW != 2) {
                Q1.b.L(parcel, iD);
            } else {
                bArrG = Q1.b.g(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new r0(zX, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new r0[i7];
    }
}
