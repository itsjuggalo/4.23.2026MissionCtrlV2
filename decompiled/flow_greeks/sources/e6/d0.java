package e6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationAvailability;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        int iF = 1000;
        int iF2 = 1;
        int iF3 = 1;
        long jH = 0;
        n0[] n0VarArr = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                iF2 = n5.b.F(parcel, iD);
            } else if (iW == 2) {
                iF3 = n5.b.F(parcel, iD);
            } else if (iW == 3) {
                jH = n5.b.H(parcel, iD);
            } else if (iW == 4) {
                iF = n5.b.F(parcel, iD);
            } else if (iW != 5) {
                n5.b.L(parcel, iD);
            } else {
                n0VarArr = (n0[]) n5.b.t(parcel, iD, n0.CREATOR);
            }
        }
        n5.b.v(parcel, iM);
        return new LocationAvailability(iF, iF2, iF3, jH, n0VarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new LocationAvailability[i10];
    }
}
