package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationAvailability;

/* JADX INFO: renamed from: f2.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1553D implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        int iF = 1000;
        int iF2 = 1;
        int iF3 = 1;
        long jH = 0;
        C1563N[] c1563nArr = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF2 = Q1.b.F(parcel, iD);
            } else if (iW == 2) {
                iF3 = Q1.b.F(parcel, iD);
            } else if (iW == 3) {
                jH = Q1.b.H(parcel, iD);
            } else if (iW == 4) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW != 5) {
                Q1.b.L(parcel, iD);
            } else {
                c1563nArr = (C1563N[]) Q1.b.t(parcel, iD, C1563N.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new LocationAvailability(iF, iF2, iF3, jH, c1563nArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i7) {
        return new LocationAvailability[i7];
    }
}
