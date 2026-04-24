package N1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class H0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            if (A1.b.w(iD) != 2) {
                A1.b.L(parcel, iD);
            } else {
                strQ = A1.b.q(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new r(strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new r[i4];
    }
}
