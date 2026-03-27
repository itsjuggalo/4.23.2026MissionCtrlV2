package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationAvailability;

/* JADX INFO: loaded from: classes.dex */
public final class D implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        int iF = 1000;
        int iF2 = 1;
        int iF3 = 1;
        long jH = 0;
        N[] nArr = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF2 = A1.b.F(parcel, iD);
            } else if (iW == 2) {
                iF3 = A1.b.F(parcel, iD);
            } else if (iW == 3) {
                jH = A1.b.H(parcel, iD);
            } else if (iW == 4) {
                iF = A1.b.F(parcel, iD);
            } else if (iW != 5) {
                A1.b.L(parcel, iD);
            } else {
                nArr = (N[]) A1.b.t(parcel, iD, N.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new LocationAvailability(iF, iF2, iF3, jH, nArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i4) {
        return new LocationAvailability[i4];
    }
}
