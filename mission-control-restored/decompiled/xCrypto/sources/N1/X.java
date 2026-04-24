package N1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class X implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        Integer numG = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 2) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW != 3) {
                A1.b.L(parcel, iD);
            } else {
                numG = A1.b.G(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new C0486w(strQ, numG.intValue());
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0486w[i4];
    }
}
