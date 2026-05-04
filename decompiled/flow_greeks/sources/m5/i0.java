package m5;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        long jH = -1;
        boolean zX = false;
        int iF = 0;
        int iF2 = 0;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                zX = n5.b.x(parcel, iD);
            } else if (iW == 2) {
                strQ = n5.b.q(parcel, iD);
            } else if (iW == 3) {
                iF = n5.b.F(parcel, iD);
            } else if (iW == 4) {
                iF2 = n5.b.F(parcel, iD);
            } else if (iW != 5) {
                n5.b.L(parcel, iD);
            } else {
                jH = n5.b.H(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new h0(zX, strQ, iF, iF2, jH);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new h0[i10];
    }
}
