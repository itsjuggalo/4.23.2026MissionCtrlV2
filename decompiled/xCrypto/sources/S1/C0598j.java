package S1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: S1.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0598j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        h7 h7Var = null;
        String strQ3 = null;
        J j4 = null;
        J j5 = null;
        J j6 = null;
        long jH = 0;
        long jH2 = 0;
        long jH3 = 0;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 2:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                case 4:
                    h7Var = (h7) A1.b.p(parcel, iD, h7.CREATOR);
                    break;
                case 5:
                    jH = A1.b.H(parcel, iD);
                    break;
                case 6:
                    zX = A1.b.x(parcel, iD);
                    break;
                case 7:
                    strQ3 = A1.b.q(parcel, iD);
                    break;
                case 8:
                    j4 = (J) A1.b.p(parcel, iD, J.CREATOR);
                    break;
                case 9:
                    jH2 = A1.b.H(parcel, iD);
                    break;
                case 10:
                    j5 = (J) A1.b.p(parcel, iD, J.CREATOR);
                    break;
                case 11:
                    jH3 = A1.b.H(parcel, iD);
                    break;
                case 12:
                    j6 = (J) A1.b.p(parcel, iD, J.CREATOR);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new C0590i(strQ, strQ2, h7Var, jH, zX, strQ3, j4, jH2, j5, jH3, j6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0590i[i4];
    }
}
