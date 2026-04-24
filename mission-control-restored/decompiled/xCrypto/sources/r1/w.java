package r1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import r1.C1745b;

/* JADX INFO: loaded from: classes.dex */
public final class w implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        ArrayList arrayListS = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    zX = A1.b.x(parcel, iD);
                    break;
                case 2:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                case 4:
                    zX2 = A1.b.x(parcel, iD);
                    break;
                case 5:
                    strQ3 = A1.b.q(parcel, iD);
                    break;
                case 6:
                    arrayListS = A1.b.s(parcel, iD);
                    break;
                case 7:
                    zX3 = A1.b.x(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new C1745b.C0234b(zX, strQ, strQ2, zX2, strQ3, arrayListS, zX3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C1745b.C0234b[i4];
    }
}
