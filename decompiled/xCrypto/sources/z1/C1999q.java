package z1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: z1.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1999q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        PendingIntent pendingIntent = null;
        int iF = 0;
        int iF2 = 0;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF = A1.b.F(parcel, iD);
            } else if (iW == 2) {
                iF2 = A1.b.F(parcel, iD);
            } else if (iW == 3) {
                pendingIntent = (PendingIntent) A1.b.p(parcel, iD, PendingIntent.CREATOR);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                strQ = A1.b.q(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new C1984b(iF, iF2, pendingIntent, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C1984b[i4];
    }
}
