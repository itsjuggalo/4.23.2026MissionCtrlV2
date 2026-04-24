package Z2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;

/* JADX INFO: loaded from: classes.dex */
public final class z0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        zzait zzaitVar = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 2:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    zzaitVar = (zzait) Q1.b.p(parcel, iD, zzait.CREATOR);
                    break;
                case 5:
                    strQ4 = Q1.b.q(parcel, iD);
                    break;
                case 6:
                    strQ5 = Q1.b.q(parcel, iD);
                    break;
                case 7:
                    strQ6 = Q1.b.q(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new y0(strQ, strQ2, strQ3, zzaitVar, strQ4, strQ5, strQ6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new y0[i7];
    }
}
