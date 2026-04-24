package e2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        b bVar = null;
        String strQ = null;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 2) {
                bVar = (b) Q1.b.p(parcel, iD, b.CREATOR);
            } else if (iW == 3) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                strQ2 = Q1.b.q(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new e(bVar, strQ, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new e[i7];
    }
}
