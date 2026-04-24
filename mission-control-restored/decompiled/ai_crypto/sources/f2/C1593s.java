package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;

/* JADX INFO: renamed from: f2.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1593s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = "";
        ArrayList arrayListU = null;
        int iF = 0;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                arrayListU = Q1.b.u(parcel, iD, zzbe.CREATOR);
            } else if (iW == 2) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW == 3) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                strQ2 = Q1.b.q(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1582h(arrayListU, iF, strQ, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i7) {
        return new C1582h[i7];
    }
}
