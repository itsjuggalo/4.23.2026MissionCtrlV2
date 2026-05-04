package e6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        int iF = 102;
        long jH = 3600000;
        long jH2 = 600000;
        boolean zX = false;
        boolean zX2 = false;
        long jH3 = Long.MAX_VALUE;
        int iF2 = Integer.MAX_VALUE;
        float fB = 0.0f;
        long jH4 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    iF = n5.b.F(parcel, iD);
                    break;
                case 2:
                    jH = n5.b.H(parcel, iD);
                    break;
                case 3:
                    jH2 = n5.b.H(parcel, iD);
                    break;
                case 4:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 5:
                    jH3 = n5.b.H(parcel, iD);
                    break;
                case 6:
                    iF2 = n5.b.F(parcel, iD);
                    break;
                case 7:
                    fB = n5.b.B(parcel, iD);
                    break;
                case 8:
                    jH4 = n5.b.H(parcel, iD);
                    break;
                case 9:
                    zX2 = n5.b.x(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new LocationRequest(iF, jH, jH2, zX, jH3, iF2, fB, jH4, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new LocationRequest[i10];
    }
}
