package z1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: z1.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1974E implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        boolean zX4 = false;
        String strQ = null;
        IBinder iBinderE = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 2:
                    zX = A1.b.x(parcel, iD);
                    break;
                case 3:
                    zX2 = A1.b.x(parcel, iD);
                    break;
                case 4:
                    iBinderE = A1.b.E(parcel, iD);
                    break;
                case 5:
                    zX3 = A1.b.x(parcel, iD);
                    break;
                case 6:
                    zX4 = A1.b.x(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new C1973D(strQ, zX, zX2, iBinderE, zX3, zX4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C1973D[i4];
    }
}
