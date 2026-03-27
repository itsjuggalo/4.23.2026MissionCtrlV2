package P1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class E implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        boolean zX4 = false;
        String strQ = null;
        IBinder iBinderE = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 2:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 3:
                    zX2 = Q1.b.x(parcel, iD);
                    break;
                case 4:
                    iBinderE = Q1.b.E(parcel, iD);
                    break;
                case 5:
                    zX3 = Q1.b.x(parcel, iD);
                    break;
                case 6:
                    zX4 = Q1.b.x(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new D(strQ, zX, zX2, iBinderE, zX3, zX4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new D[i7];
    }
}
