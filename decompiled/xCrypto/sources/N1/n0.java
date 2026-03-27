package N1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class n0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        r rVar = null;
        C0 c02 = null;
        F f4 = null;
        I0 i02 = null;
        K k4 = null;
        M m4 = null;
        E0 e02 = null;
        P p4 = null;
        C0482s c0482s = null;
        S s4 = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 2:
                    rVar = (r) A1.b.p(parcel, iD, r.CREATOR);
                    break;
                case 3:
                    c02 = (C0) A1.b.p(parcel, iD, C0.CREATOR);
                    break;
                case 4:
                    f4 = (F) A1.b.p(parcel, iD, F.CREATOR);
                    break;
                case 5:
                    i02 = (I0) A1.b.p(parcel, iD, I0.CREATOR);
                    break;
                case 6:
                    k4 = (K) A1.b.p(parcel, iD, K.CREATOR);
                    break;
                case 7:
                    m4 = (M) A1.b.p(parcel, iD, M.CREATOR);
                    break;
                case 8:
                    e02 = (E0) A1.b.p(parcel, iD, E0.CREATOR);
                    break;
                case 9:
                    p4 = (P) A1.b.p(parcel, iD, P.CREATOR);
                    break;
                case 10:
                    c0482s = (C0482s) A1.b.p(parcel, iD, C0482s.CREATOR);
                    break;
                case 11:
                    s4 = (S) A1.b.p(parcel, iD, S.CREATOR);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new C0462d(rVar, c02, f4, i02, k4, m4, e02, p4, c0482s, s4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0462d[i4];
    }
}
