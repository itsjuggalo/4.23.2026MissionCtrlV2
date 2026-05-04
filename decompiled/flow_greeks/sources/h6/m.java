package h6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        m5.b bVar = null;
        int iF = 0;
        q0 q0Var = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                iF = n5.b.F(parcel, iD);
            } else if (iW == 2) {
                bVar = (m5.b) n5.b.p(parcel, iD, m5.b.CREATOR);
            } else if (iW != 3) {
                n5.b.L(parcel, iD);
            } else {
                q0Var = (q0) n5.b.p(parcel, iD, q0.CREATOR);
            }
        }
        n5.b.v(parcel, iM);
        return new l(iF, bVar, q0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new l[i10];
    }
}
