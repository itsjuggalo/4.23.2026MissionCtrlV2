package n7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h2 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        i iVar = null;
        g2 g2Var = null;
        m7.z1 z1Var = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                iVar = (i) n5.b.p(parcel, iD, i.CREATOR);
            } else if (iW == 2) {
                g2Var = (g2) n5.b.p(parcel, iD, g2.CREATOR);
            } else if (iW != 3) {
                n5.b.L(parcel, iD);
            } else {
                z1Var = (m7.z1) n5.b.p(parcel, iD, m7.z1.CREATOR);
            }
        }
        n5.b.v(parcel, iM);
        return new i2(iVar, g2Var, z1Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new i2[i10];
    }
}
