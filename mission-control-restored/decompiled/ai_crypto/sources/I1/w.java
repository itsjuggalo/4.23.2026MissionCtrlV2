package I1;

import I1.C0577b;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class w implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        ArrayList arrayListS = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 2:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    zX2 = Q1.b.x(parcel, iD);
                    break;
                case 5:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case 6:
                    arrayListS = Q1.b.s(parcel, iD);
                    break;
                case 7:
                    zX3 = Q1.b.x(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C0577b.C0029b(zX, strQ, strQ2, zX2, strQ3, arrayListS, zX3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0577b.C0029b[i7];
    }
}
