package Q1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class E implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        boolean zL = false;
        boolean zL2 = false;
        boolean zL3 = false;
        boolean zL4 = false;
        String strF = null;
        IBinder iBinderQ = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            switch (T1.b.k(iP)) {
                case 1:
                    strF = T1.b.f(parcel, iP);
                    break;
                case 2:
                    zL = T1.b.l(parcel, iP);
                    break;
                case 3:
                    zL2 = T1.b.l(parcel, iP);
                    break;
                case 4:
                    iBinderQ = T1.b.q(parcel, iP);
                    break;
                case 5:
                    zL3 = T1.b.l(parcel, iP);
                    break;
                case 6:
                    zL4 = T1.b.l(parcel, iP);
                    break;
                default:
                    T1.b.v(parcel, iP);
                    break;
            }
        }
        T1.b.j(parcel, iW);
        return new D(strF, zL, zL2, iBinderQ, zL3, zL4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new D[i8];
    }
}
