package e5;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        PendingIntent pendingIntent = null;
        Bundle bundleF = null;
        byte[] bArrG = null;
        int iF = 0;
        int iF2 = 0;
        int iF3 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                iF2 = n5.b.F(parcel, iD);
            } else if (iW == 2) {
                pendingIntent = (PendingIntent) n5.b.p(parcel, iD, PendingIntent.CREATOR);
            } else if (iW == 3) {
                iF3 = n5.b.F(parcel, iD);
            } else if (iW == 4) {
                bundleF = n5.b.f(parcel, iD);
            } else if (iW == 5) {
                bArrG = n5.b.g(parcel, iD);
            } else if (iW != 1000) {
                n5.b.L(parcel, iD);
            } else {
                iF = n5.b.F(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new c(iF, iF2, pendingIntent, iF3, bundleF, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new c[i10];
    }
}
