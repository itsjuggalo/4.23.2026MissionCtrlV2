package N1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: N1.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0465e0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 2) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW != 3) {
                A1.b.L(parcel, iD);
            } else {
                strQ2 = A1.b.q(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new E(strQ, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new E[i4];
    }
}
