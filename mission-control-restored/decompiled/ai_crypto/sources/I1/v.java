package I1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class v implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        boolean zX = false;
        int iF = 0;
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
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
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    strQ4 = Q1.b.q(parcel, iD);
                    break;
                case 5:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 6:
                    iF = Q1.b.F(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C0581f(strQ, strQ2, strQ3, strQ4, zX, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0581f[i7];
    }
}
