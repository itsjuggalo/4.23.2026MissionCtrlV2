package c5;

import android.os.Parcel;
import android.os.Parcelable;
import c5.c;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        ArrayList arrayListS = null;
        ArrayList arrayListU = null;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 2:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case 4:
                    zX2 = n5.b.x(parcel, iD);
                    break;
                case 5:
                    strQ3 = n5.b.q(parcel, iD);
                    break;
                case 6:
                    arrayListS = n5.b.s(parcel, iD);
                    break;
                case 7:
                    zX3 = n5.b.x(parcel, iD);
                    break;
                case 8:
                    arrayListU = n5.b.u(parcel, iD, e.CREATOR);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new c.b(zX, strQ, strQ2, zX2, strQ3, arrayListS, zX3, arrayListU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new c.b[i10];
    }
}
