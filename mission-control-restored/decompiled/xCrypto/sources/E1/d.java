package E1;

import E1.a;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        D1.b bVar = null;
        int iF = 0;
        int iF2 = 0;
        boolean zX = false;
        int iF3 = 0;
        boolean zX2 = false;
        int iF4 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    iF = A1.b.F(parcel, iD);
                    break;
                case 2:
                    iF2 = A1.b.F(parcel, iD);
                    break;
                case 3:
                    zX = A1.b.x(parcel, iD);
                    break;
                case 4:
                    iF3 = A1.b.F(parcel, iD);
                    break;
                case 5:
                    zX2 = A1.b.x(parcel, iD);
                    break;
                case 6:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 7:
                    iF4 = A1.b.F(parcel, iD);
                    break;
                case 8:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                case 9:
                    bVar = (D1.b) A1.b.p(parcel, iD, D1.b.CREATOR);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new a.C0016a(iF, iF2, zX, iF3, zX2, strQ, iF4, strQ2, bVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new a.C0016a[i4];
    }
}
