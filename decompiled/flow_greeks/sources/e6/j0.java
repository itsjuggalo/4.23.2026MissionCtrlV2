package e6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        String strQ = "";
        String strQ2 = "";
        String strQ3 = strQ2;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                strQ2 = n5.b.q(parcel, iD);
            } else if (iW == 2) {
                strQ3 = n5.b.q(parcel, iD);
            } else if (iW != 5) {
                n5.b.L(parcel, iD);
            } else {
                strQ = n5.b.q(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new i0(strQ, strQ2, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new i0[i10];
    }
}
