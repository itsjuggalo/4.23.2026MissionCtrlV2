package P1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class I implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        boolean zX = false;
        String strQ = null;
        IBinder iBinderE = null;
        boolean zX2 = false;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW == 2) {
                iBinderE = Q1.b.E(parcel, iD);
            } else if (iW == 3) {
                zX = Q1.b.x(parcel, iD);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                zX2 = Q1.b.x(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new H(strQ, iBinderE, zX, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new H[i7];
    }
}
