package r1;

import android.os.Parcel;
import android.os.Parcelable;
import r1.C1745b;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        C1745b.e eVar = null;
        C1745b.C0234b c0234b = null;
        String strQ = null;
        C1745b.d dVar = null;
        C1745b.c cVar = null;
        boolean zX = false;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    eVar = (C1745b.e) A1.b.p(parcel, iD, C1745b.e.CREATOR);
                    break;
                case 2:
                    c0234b = (C1745b.C0234b) A1.b.p(parcel, iD, C1745b.C0234b.CREATOR);
                    break;
                case 3:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 4:
                    zX = A1.b.x(parcel, iD);
                    break;
                case 5:
                    iF = A1.b.F(parcel, iD);
                    break;
                case 6:
                    dVar = (C1745b.d) A1.b.p(parcel, iD, C1745b.d.CREATOR);
                    break;
                case 7:
                    cVar = (C1745b.c) A1.b.p(parcel, iD, C1745b.c.CREATOR);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new C1745b(eVar, c0234b, strQ, zX, iF, dVar, cVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C1745b[i4];
    }
}
