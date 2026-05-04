package m7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        String strQ8 = null;
        boolean zX = false;
        boolean zX2 = false;
        int iF = 0;
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
                    strQ3 = n5.b.q(parcel, iD);
                    break;
                case 4:
                    strQ4 = n5.b.q(parcel, iD);
                    break;
                case 5:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 6:
                    strQ5 = n5.b.q(parcel, iD);
                    break;
                case 7:
                    zX2 = n5.b.x(parcel, iD);
                    break;
                case 8:
                    strQ6 = n5.b.q(parcel, iD);
                    break;
                case 9:
                    iF = n5.b.F(parcel, iD);
                    break;
                case 10:
                    strQ7 = n5.b.q(parcel, iD);
                    break;
                case 11:
                    strQ8 = n5.b.q(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new e(strQ, strQ2, strQ3, strQ4, zX, strQ5, zX2, strQ6, iF, strQ7, strQ8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new e[i10];
    }
}
