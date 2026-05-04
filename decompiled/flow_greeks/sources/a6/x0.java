package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        byte[] bArrG = null;
        h hVar = null;
        g gVar = null;
        i iVar = null;
        e eVar = null;
        String strQ3 = null;
        String strQ4 = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 2:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case 3:
                    bArrG = n5.b.g(parcel, iD);
                    break;
                case 4:
                    hVar = (h) n5.b.p(parcel, iD, h.CREATOR);
                    break;
                case 5:
                    gVar = (g) n5.b.p(parcel, iD, g.CREATOR);
                    break;
                case 6:
                    iVar = (i) n5.b.p(parcel, iD, i.CREATOR);
                    break;
                case 7:
                    eVar = (e) n5.b.p(parcel, iD, e.CREATOR);
                    break;
                case 8:
                    strQ3 = n5.b.q(parcel, iD);
                    break;
                case 9:
                    strQ4 = n5.b.q(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new t(strQ, strQ2, bArrG, hVar, gVar, iVar, eVar, strQ3, strQ4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new t[i10];
    }
}
