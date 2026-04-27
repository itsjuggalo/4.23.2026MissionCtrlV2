package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class K implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        ArrayList arrayListU = null;
        boolean zX = false;
        boolean zX2 = false;
        I i4 = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                arrayListU = A1.b.u(parcel, iD, LocationRequest.CREATOR);
            } else if (iW == 2) {
                zX = A1.b.x(parcel, iD);
            } else if (iW == 3) {
                zX2 = A1.b.x(parcel, iD);
            } else if (iW != 5) {
                A1.b.L(parcel, iD);
            } else {
                i4 = (I) A1.b.p(parcel, iD, I.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new C0501l(arrayListU, zX, zX2, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i4) {
        return new C0501l[i4];
    }
}
