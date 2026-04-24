package d2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: d2.Q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1410Q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            if (Q1.b.w(iD) != 1) {
                Q1.b.L(parcel, iD);
            } else {
                strQ = Q1.b.q(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1409P(strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1409P[i7];
    }
}
