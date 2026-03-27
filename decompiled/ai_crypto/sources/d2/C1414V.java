package d2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: d2.V, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1414V implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        byte[] bArrG = null;
        C1433h c1433h = null;
        C1431g c1431g = null;
        C1435i c1435i = null;
        C1427e c1427e = null;
        String strQ3 = null;
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
                    bArrG = Q1.b.g(parcel, iD);
                    break;
                case 4:
                    c1433h = (C1433h) Q1.b.p(parcel, iD, C1433h.CREATOR);
                    break;
                case 5:
                    c1431g = (C1431g) Q1.b.p(parcel, iD, C1431g.CREATOR);
                    break;
                case 6:
                    c1435i = (C1435i) Q1.b.p(parcel, iD, C1435i.CREATOR);
                    break;
                case 7:
                    c1427e = (C1427e) Q1.b.p(parcel, iD, C1427e.CREATOR);
                    break;
                case 8:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C1447t(strQ, strQ2, bArrG, c1433h, c1431g, c1435i, c1427e, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1447t[i7];
    }
}
