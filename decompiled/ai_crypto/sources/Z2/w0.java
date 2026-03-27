package Z2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class w0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        boolean zX = false;
        boolean zX2 = false;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 2) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW == 3) {
                strQ2 = Q1.b.q(parcel, iD);
            } else if (iW == 4) {
                zX = Q1.b.x(parcel, iD);
            } else if (iW != 5) {
                Q1.b.L(parcel, iD);
            } else {
                zX2 = Q1.b.x(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C0752d0(strQ, strQ2, zX, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0752d0[i7];
    }
}
