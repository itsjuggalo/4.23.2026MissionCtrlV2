package e6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        int iF = 1;
        int iF2 = 1;
        long jH = -1;
        long jH2 = -1;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                iF = n5.b.F(parcel, iD);
            } else if (iW == 2) {
                iF2 = n5.b.F(parcel, iD);
            } else if (iW == 3) {
                jH = n5.b.H(parcel, iD);
            } else if (iW != 4) {
                n5.b.L(parcel, iD);
            } else {
                jH2 = n5.b.H(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new n0(iF, iF2, jH, jH2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new n0[i10];
    }
}
