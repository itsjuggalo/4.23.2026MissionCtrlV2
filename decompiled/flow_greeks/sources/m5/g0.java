package m5;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        boolean zX4 = false;
        boolean zX5 = false;
        String strQ = null;
        IBinder iBinderE = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 2:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 3:
                    zX2 = n5.b.x(parcel, iD);
                    break;
                case 4:
                    iBinderE = n5.b.E(parcel, iD);
                    break;
                case 5:
                    zX3 = n5.b.x(parcel, iD);
                    break;
                case 6:
                    zX4 = n5.b.x(parcel, iD);
                    break;
                case 7:
                default:
                    n5.b.L(parcel, iD);
                    break;
                case 8:
                    zX5 = n5.b.x(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new f0(strQ, zX, zX2, iBinderE, zX3, zX4, zX5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new f0[i10];
    }
}
