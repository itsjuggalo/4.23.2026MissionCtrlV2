package Q1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        PendingIntent pendingIntent = null;
        int iR = 0;
        int iR2 = 0;
        String strF = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 1) {
                iR = T1.b.r(parcel, iP);
            } else if (iK == 2) {
                iR2 = T1.b.r(parcel, iP);
            } else if (iK == 3) {
                pendingIntent = (PendingIntent) T1.b.e(parcel, iP, PendingIntent.CREATOR);
            } else if (iK != 4) {
                T1.b.v(parcel, iP);
            } else {
                strF = T1.b.f(parcel, iP);
            }
        }
        T1.b.j(parcel, iW);
        return new C0790b(iR, iR2, pendingIntent, strF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new C0790b[i8];
    }
}
