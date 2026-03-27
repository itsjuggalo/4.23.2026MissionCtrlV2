package n1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: renamed from: n1.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1623i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        ArrayList arrayListU = null;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF = A1.b.F(parcel, iD);
            } else if (iW != 2) {
                A1.b.L(parcel, iD);
            } else {
                arrayListU = A1.b.u(parcel, iD, C1615a.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new C1617c(iF, arrayListU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C1617c[i4];
    }
}
