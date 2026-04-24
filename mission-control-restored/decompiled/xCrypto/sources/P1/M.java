package P1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class M implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        boolean zX4 = false;
        boolean zX5 = false;
        boolean zX6 = false;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    zX = A1.b.x(parcel, iD);
                    break;
                case 2:
                    zX2 = A1.b.x(parcel, iD);
                    break;
                case 3:
                    zX3 = A1.b.x(parcel, iD);
                    break;
                case 4:
                    zX4 = A1.b.x(parcel, iD);
                    break;
                case 5:
                    zX5 = A1.b.x(parcel, iD);
                    break;
                case 6:
                    zX6 = A1.b.x(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new C0503n(zX, zX2, zX3, zX4, zX5, zX6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i4) {
        return new C0503n[i4];
    }
}
