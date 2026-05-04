package r5;

import android.os.Parcel;
import android.os.Parcelable;
import r5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        String strQ = null;
        int iF = 0;
        a.C0336a c0336a = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                iF = n5.b.F(parcel, iD);
            } else if (iW == 2) {
                strQ = n5.b.q(parcel, iD);
            } else if (iW != 3) {
                n5.b.L(parcel, iD);
            } else {
                c0336a = (a.C0336a) n5.b.p(parcel, iD, a.C0336a.CREATOR);
            }
        }
        n5.b.v(parcel, iM);
        return new g(iF, strQ, c0336a);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new g[i10];
    }
}
