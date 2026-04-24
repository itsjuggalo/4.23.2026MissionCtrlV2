package I1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            if (Q1.b.w(iD) != 1) {
                Q1.b.L(parcel, iD);
            } else {
                pendingIntent = (PendingIntent) Q1.b.p(parcel, iD, PendingIntent.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new C0578c(pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0578c[i7];
    }
}
