package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C1193d;
import java.util.ArrayList;

/* JADX INFO: renamed from: f2.X, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1572X implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        ArrayList arrayListU = null;
        String strQ = null;
        ArrayList arrayListU2 = null;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                arrayListU = Q1.b.u(parcel, iD, C1577c.CREATOR);
            } else if (iW == 2) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW == 3) {
                arrayListU2 = Q1.b.u(parcel, iD, C1193d.CREATOR);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                strQ2 = Q1.b.q(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1578d(arrayListU, strQ, arrayListU2, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i7) {
        return new C1578d[i7];
    }
}
