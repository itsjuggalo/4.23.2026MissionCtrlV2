package R1;

import Q1.C0790b;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        String strF = null;
        C0790b c0790b = null;
        int iR = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 1) {
                iR = T1.b.r(parcel, iP);
            } else if (iK == 2) {
                strF = T1.b.f(parcel, iP);
            } else if (iK == 3) {
                pendingIntent = (PendingIntent) T1.b.e(parcel, iP, PendingIntent.CREATOR);
            } else if (iK != 4) {
                T1.b.v(parcel, iP);
            } else {
                c0790b = (C0790b) T1.b.e(parcel, iP, C0790b.CREATOR);
            }
        }
        T1.b.j(parcel, iW);
        return new Status(iR, strF, pendingIntent, c0790b);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new Status[i8];
    }
}
