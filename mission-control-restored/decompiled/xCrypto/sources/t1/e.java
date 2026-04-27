package t1;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        PendingIntent pendingIntent = null;
        Bundle bundleF = null;
        byte[] bArrG = null;
        int iF = 0;
        int iF2 = 0;
        int iF3 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF2 = A1.b.F(parcel, iD);
            } else if (iW == 2) {
                pendingIntent = (PendingIntent) A1.b.p(parcel, iD, PendingIntent.CREATOR);
            } else if (iW == 3) {
                iF3 = A1.b.F(parcel, iD);
            } else if (iW == 4) {
                bundleF = A1.b.f(parcel, iD);
            } else if (iW == 5) {
                bArrG = A1.b.g(parcel, iD);
            } else if (iW != 1000) {
                A1.b.L(parcel, iD);
            } else {
                iF = A1.b.F(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new c(iF, iF2, pendingIntent, iF3, bundleF, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new c[i4];
    }
}
