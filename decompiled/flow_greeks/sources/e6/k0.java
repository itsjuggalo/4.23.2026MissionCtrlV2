package e6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        ArrayList arrayListU = null;
        boolean zX = false;
        boolean zX2 = false;
        i0 i0Var = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                arrayListU = n5.b.u(parcel, iD, LocationRequest.CREATOR);
            } else if (iW == 2) {
                zX = n5.b.x(parcel, iD);
            } else if (iW == 3) {
                zX2 = n5.b.x(parcel, iD);
            } else if (iW != 5) {
                n5.b.L(parcel, iD);
            } else {
                i0Var = (i0) n5.b.p(parcel, iD, i0.CREATOR);
            }
        }
        n5.b.v(parcel, iM);
        return new l(arrayListU, zX, zX2, i0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new l[i10];
    }
}
