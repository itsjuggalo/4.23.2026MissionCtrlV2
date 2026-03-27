package f2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: renamed from: f2.S, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1567S implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        ArrayList arrayListU = null;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                arrayListU = Q1.b.u(parcel, iD, C1568T.CREATOR);
            } else if (iW != 2) {
                Q1.b.L(parcel, iD);
            } else {
                iF = Q1.b.F(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1591q(arrayListU, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i7) {
        return new C1591q[i7];
    }
}
