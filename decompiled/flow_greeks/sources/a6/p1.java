package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        h0 h0Var = null;
        s1 s1Var = null;
        f fVar = null;
        u1 u1Var = null;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                h0Var = (h0) n5.b.p(parcel, iD, h0.CREATOR);
            } else if (iW == 2) {
                s1Var = (s1) n5.b.p(parcel, iD, s1.CREATOR);
            } else if (iW == 3) {
                fVar = (f) n5.b.p(parcel, iD, f.CREATOR);
            } else if (iW == 4) {
                u1Var = (u1) n5.b.p(parcel, iD, u1.CREATOR);
            } else if (iW != 5) {
                n5.b.L(parcel, iD);
            } else {
                strQ = n5.b.q(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new e(h0Var, s1Var, fVar, u1Var, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new e[i10];
    }
}
