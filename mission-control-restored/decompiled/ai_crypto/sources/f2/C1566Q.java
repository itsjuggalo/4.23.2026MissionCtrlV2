package f2;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: renamed from: f2.Q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1566Q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = "";
        ArrayList arrayListS = null;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                arrayListS = Q1.b.s(parcel, iD);
            } else if (iW == 2) {
                pendingIntent = (PendingIntent) Q1.b.p(parcel, iD, PendingIntent.CREATOR);
            } else if (iW != 3) {
                Q1.b.L(parcel, iD);
            } else {
                strQ = Q1.b.q(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1565P(arrayListS, pendingIntent, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i7) {
        return new C1565P[i7];
    }
}
