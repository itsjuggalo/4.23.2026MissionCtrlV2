package e6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        boolean zX4 = false;
        boolean zX5 = false;
        boolean zX6 = false;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 2:
                    zX2 = n5.b.x(parcel, iD);
                    break;
                case 3:
                    zX3 = n5.b.x(parcel, iD);
                    break;
                case 4:
                    zX4 = n5.b.x(parcel, iD);
                    break;
                case 5:
                    zX5 = n5.b.x(parcel, iD);
                    break;
                case 6:
                    zX6 = n5.b.x(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new n(zX, zX2, zX3, zX4, zX5, zX6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new n[i10];
    }
}
