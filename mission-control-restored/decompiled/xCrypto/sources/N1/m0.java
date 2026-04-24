package N1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        G g4 = null;
        p0 p0Var = null;
        C0466f c0466f = null;
        r0 r0Var = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                g4 = (G) A1.b.p(parcel, iD, G.CREATOR);
            } else if (iW == 2) {
                p0Var = (p0) A1.b.p(parcel, iD, p0.CREATOR);
            } else if (iW == 3) {
                c0466f = (C0466f) A1.b.p(parcel, iD, C0466f.CREATOR);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                r0Var = (r0) A1.b.p(parcel, iD, r0.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new C0464e(g4, p0Var, c0466f, r0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0464e[i4];
    }
}
