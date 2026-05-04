package n7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        ArrayList arrayListU = null;
        p pVar = null;
        String strQ = null;
        m7.z1 z1Var = null;
        i iVar = null;
        ArrayList arrayListU2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    arrayListU = n5.b.u(parcel, iD, m7.r0.CREATOR);
                    break;
                case 2:
                    pVar = (p) n5.b.p(parcel, iD, p.CREATOR);
                    break;
                case 3:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 4:
                    z1Var = (m7.z1) n5.b.p(parcel, iD, m7.z1.CREATOR);
                    break;
                case 5:
                    iVar = (i) n5.b.p(parcel, iD, i.CREATOR);
                    break;
                case 6:
                    arrayListU2 = n5.b.u(parcel, iD, m7.x0.CREATOR);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new o(arrayListU, pVar, strQ, z1Var, iVar, arrayListU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new o[i10];
    }
}
