package e6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        boolean zX = true;
        long jH = 50;
        float fB = 0.0f;
        long jH2 = Long.MAX_VALUE;
        int iF = Integer.MAX_VALUE;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                zX = n5.b.x(parcel, iD);
            } else if (iW == 2) {
                jH = n5.b.H(parcel, iD);
            } else if (iW == 3) {
                fB = n5.b.B(parcel, iD);
            } else if (iW == 4) {
                jH2 = n5.b.H(parcel, iD);
            } else if (iW != 5) {
                n5.b.L(parcel, iD);
            } else {
                iF = n5.b.F(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new x0(zX, jH, fB, jH2, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new x0[i10];
    }
}
