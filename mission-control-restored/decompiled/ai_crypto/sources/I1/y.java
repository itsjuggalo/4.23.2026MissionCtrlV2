package I1;

import I1.C0577b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class y implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        byte[] bArrG = null;
        boolean zX = false;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                zX = Q1.b.x(parcel, iD);
            } else if (iW == 2) {
                bArrG = Q1.b.g(parcel, iD);
            } else if (iW != 3) {
                Q1.b.L(parcel, iD);
            } else {
                strQ = Q1.b.q(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C0577b.d(zX, bArrG, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0577b.d[i7];
    }
}
