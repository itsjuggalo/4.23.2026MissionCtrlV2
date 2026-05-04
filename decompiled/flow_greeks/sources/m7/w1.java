package m7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        String strQ = null;
        boolean zX = false;
        boolean zX2 = false;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 2) {
                strQ = n5.b.q(parcel, iD);
            } else if (iW == 3) {
                strQ2 = n5.b.q(parcel, iD);
            } else if (iW == 4) {
                zX = n5.b.x(parcel, iD);
            } else if (iW != 5) {
                n5.b.L(parcel, iD);
            } else {
                zX2 = n5.b.x(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new c1(strQ, strQ2, zX, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new c1[i10];
    }
}
