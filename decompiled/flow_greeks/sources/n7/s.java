package n7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListU = null;
        ArrayList arrayListU2 = null;
        i iVar = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                strQ = n5.b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = n5.b.q(parcel, iD);
            } else if (iW == 3) {
                arrayListU = n5.b.u(parcel, iD, m7.r0.CREATOR);
            } else if (iW == 4) {
                arrayListU2 = n5.b.u(parcel, iD, m7.x0.CREATOR);
            } else if (iW != 5) {
                n5.b.L(parcel, iD);
            } else {
                iVar = (i) n5.b.p(parcel, iD, i.CREATOR);
            }
        }
        n5.b.v(parcel, iM);
        return new p(strQ, strQ2, arrayListU, arrayListU2, iVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new p[i10];
    }
}
