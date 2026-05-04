package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        r rVar = null;
        f2 f2Var = null;
        f0 f0Var = null;
        l2 l2Var = null;
        l0 l0Var = null;
        n0 n0Var = null;
        h2 h2Var = null;
        q0 q0Var = null;
        s sVar = null;
        u0 u0Var = null;
        f1 f1Var = null;
        s0 s0Var = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 2:
                    rVar = (r) n5.b.p(parcel, iD, r.CREATOR);
                    break;
                case 3:
                    f2Var = (f2) n5.b.p(parcel, iD, f2.CREATOR);
                    break;
                case 4:
                    f0Var = (f0) n5.b.p(parcel, iD, f0.CREATOR);
                    break;
                case 5:
                    l2Var = (l2) n5.b.p(parcel, iD, l2.CREATOR);
                    break;
                case 6:
                    l0Var = (l0) n5.b.p(parcel, iD, l0.CREATOR);
                    break;
                case 7:
                    n0Var = (n0) n5.b.p(parcel, iD, n0.CREATOR);
                    break;
                case 8:
                    h2Var = (h2) n5.b.p(parcel, iD, h2.CREATOR);
                    break;
                case 9:
                    q0Var = (q0) n5.b.p(parcel, iD, q0.CREATOR);
                    break;
                case 10:
                    sVar = (s) n5.b.p(parcel, iD, s.CREATOR);
                    break;
                case 11:
                    u0Var = (u0) n5.b.p(parcel, iD, u0.CREATOR);
                    break;
                case 12:
                    f1Var = (f1) n5.b.p(parcel, iD, f1.CREATOR);
                    break;
                case 13:
                    s0Var = (s0) n5.b.p(parcel, iD, s0.CREATOR);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new d(rVar, f2Var, f0Var, l2Var, l0Var, n0Var, h2Var, q0Var, sVar, u0Var, f1Var, s0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new d[i10];
    }
}
