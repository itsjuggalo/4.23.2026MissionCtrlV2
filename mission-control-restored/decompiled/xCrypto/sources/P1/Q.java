package P1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = "";
        ArrayList arrayListS = null;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                arrayListS = A1.b.s(parcel, iD);
            } else if (iW == 2) {
                pendingIntent = (PendingIntent) A1.b.p(parcel, iD, PendingIntent.CREATOR);
            } else if (iW != 3) {
                A1.b.L(parcel, iD);
            } else {
                strQ = A1.b.q(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new P(arrayListS, pendingIntent, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i4) {
        return new P[i4];
    }
}
