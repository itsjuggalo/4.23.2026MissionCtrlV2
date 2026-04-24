package U1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        Parcel parcelN = null;
        int iF = 0;
        h hVar = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW == 2) {
                parcelN = Q1.b.n(parcel, iD);
            } else if (iW != 3) {
                Q1.b.L(parcel, iD);
            } else {
                hVar = (h) Q1.b.p(parcel, iD, h.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new c(iF, parcelN, hVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new c[i7];
    }
}
