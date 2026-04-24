package w1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = "com.google.android.gms.auth.blockstore.DEFAULT_BYTES_DATA_KEY";
        boolean zX = false;
        byte[] bArrG = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                bArrG = A1.b.g(parcel, iD);
            } else if (iW == 2) {
                zX = A1.b.x(parcel, iD);
            } else if (iW != 3) {
                A1.b.L(parcel, iD);
            } else {
                strQ = A1.b.q(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new f(bArrG, zX, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new f[i4];
    }
}
