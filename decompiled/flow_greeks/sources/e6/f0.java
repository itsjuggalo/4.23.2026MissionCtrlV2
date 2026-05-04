package e6;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationResult;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        List listU = LocationResult.f5880b;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            if (n5.b.w(iD) != 1) {
                n5.b.L(parcel, iD);
            } else {
                listU = n5.b.u(parcel, iD, Location.CREATOR);
            }
        }
        n5.b.v(parcel, iM);
        return new LocationResult(listU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new LocationResult[i10];
    }
}
