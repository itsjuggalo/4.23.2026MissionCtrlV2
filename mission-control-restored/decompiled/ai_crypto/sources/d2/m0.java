package d2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        C1400G c1400g = null;
        p0 p0Var = null;
        C1429f c1429f = null;
        r0 r0Var = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                c1400g = (C1400G) Q1.b.p(parcel, iD, C1400G.CREATOR);
            } else if (iW == 2) {
                p0Var = (p0) Q1.b.p(parcel, iD, p0.CREATOR);
            } else if (iW == 3) {
                c1429f = (C1429f) Q1.b.p(parcel, iD, C1429f.CREATOR);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                r0Var = (r0) Q1.b.p(parcel, iD, r0.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1427e(c1400g, p0Var, c1429f, r0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1427e[i7];
    }
}
