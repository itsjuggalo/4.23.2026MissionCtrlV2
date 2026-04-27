package Q1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class G implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        boolean zL = false;
        int iR = 0;
        String strF = null;
        int iR2 = 0;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 1) {
                zL = T1.b.l(parcel, iP);
            } else if (iK == 2) {
                strF = T1.b.f(parcel, iP);
            } else if (iK == 3) {
                iR2 = T1.b.r(parcel, iP);
            } else if (iK != 4) {
                T1.b.v(parcel, iP);
            } else {
                iR = T1.b.r(parcel, iP);
            }
        }
        T1.b.j(parcel, iW);
        return new F(zL, strF, iR2, iR);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new F[i8];
    }
}
