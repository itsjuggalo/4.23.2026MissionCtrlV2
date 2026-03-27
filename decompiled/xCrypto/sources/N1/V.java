package N1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class V implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        byte[] bArrG = null;
        C0470h c0470h = null;
        C0468g c0468g = null;
        C0472i c0472i = null;
        C0464e c0464e = null;
        String strQ3 = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 2:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                case 3:
                    bArrG = A1.b.g(parcel, iD);
                    break;
                case 4:
                    c0470h = (C0470h) A1.b.p(parcel, iD, C0470h.CREATOR);
                    break;
                case 5:
                    c0468g = (C0468g) A1.b.p(parcel, iD, C0468g.CREATOR);
                    break;
                case 6:
                    c0472i = (C0472i) A1.b.p(parcel, iD, C0472i.CREATOR);
                    break;
                case 7:
                    c0464e = (C0464e) A1.b.p(parcel, iD, C0464e.CREATOR);
                    break;
                case 8:
                    strQ3 = A1.b.q(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new C0483t(strQ, strQ2, bArrG, c0470h, c0468g, c0472i, c0464e, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0483t[i4];
    }
}
