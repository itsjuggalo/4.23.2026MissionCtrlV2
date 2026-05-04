package r5;

import android.os.Parcel;
import android.os.Parcelable;
import r5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        q5.b bVar = null;
        int iF = 0;
        int iF2 = 0;
        boolean zX = false;
        int iF3 = 0;
        boolean zX2 = false;
        int iF4 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    iF = n5.b.F(parcel, iD);
                    break;
                case 2:
                    iF2 = n5.b.F(parcel, iD);
                    break;
                case 3:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 4:
                    iF3 = n5.b.F(parcel, iD);
                    break;
                case 5:
                    zX2 = n5.b.x(parcel, iD);
                    break;
                case 6:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 7:
                    iF4 = n5.b.F(parcel, iD);
                    break;
                case 8:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case 9:
                    bVar = (q5.b) n5.b.p(parcel, iD, q5.b.CREATOR);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new a.C0336a(iF, iF2, zX, iF3, zX2, strQ, iF4, strQ2, bVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new a.C0336a[i10];
    }
}
