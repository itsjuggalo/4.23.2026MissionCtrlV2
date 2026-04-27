package f2;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationResult;
import java.util.List;

/* JADX INFO: renamed from: f2.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1555F implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        List listU = LocationResult.f11239b;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            if (Q1.b.w(iD) != 1) {
                Q1.b.L(parcel, iD);
            } else {
                listU = Q1.b.u(parcel, iD, Location.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new LocationResult(listU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i7) {
        return new LocationResult[i7];
    }
}
