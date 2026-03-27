package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzair;

/* JADX INFO: loaded from: classes.dex */
public final class u0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        zzair zzairVar = null;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = Q1.b.q(parcel, iD);
            } else if (iW == 3) {
                jH = Q1.b.H(parcel, iD);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                zzairVar = (zzair) Q1.b.p(parcel, iD, zzair.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new Y(strQ, strQ2, jH, zzairVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new Y[i7];
    }
}
