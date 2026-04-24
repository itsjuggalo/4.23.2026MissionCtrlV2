package Q1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class I implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        boolean zL = false;
        String strF = null;
        IBinder iBinderQ = null;
        boolean zL2 = false;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 1) {
                strF = T1.b.f(parcel, iP);
            } else if (iK == 2) {
                iBinderQ = T1.b.q(parcel, iP);
            } else if (iK == 3) {
                zL = T1.b.l(parcel, iP);
            } else if (iK != 4) {
                T1.b.v(parcel, iP);
            } else {
                zL2 = T1.b.l(parcel, iP);
            }
        }
        T1.b.j(parcel, iW);
        return new H(strF, iBinderQ, zL, zL2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new H[i8];
    }
}
