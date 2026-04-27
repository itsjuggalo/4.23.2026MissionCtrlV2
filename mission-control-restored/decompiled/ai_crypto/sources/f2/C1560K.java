package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* JADX INFO: renamed from: f2.K, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1560K implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        ArrayList arrayListU = null;
        boolean zX = false;
        boolean zX2 = false;
        C1558I c1558i = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                arrayListU = Q1.b.u(parcel, iD, LocationRequest.CREATOR);
            } else if (iW == 2) {
                zX = Q1.b.x(parcel, iD);
            } else if (iW == 3) {
                zX2 = Q1.b.x(parcel, iD);
            } else if (iW != 5) {
                Q1.b.L(parcel, iD);
            } else {
                c1558i = (C1558I) Q1.b.p(parcel, iD, C1558I.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1586l(arrayListU, zX, zX2, c1558i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i7) {
        return new C1586l[i7];
    }
}
