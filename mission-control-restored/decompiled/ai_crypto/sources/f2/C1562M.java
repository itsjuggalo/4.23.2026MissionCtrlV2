package f2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: f2.M, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1562M implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        boolean zX4 = false;
        boolean zX5 = false;
        boolean zX6 = false;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 2:
                    zX2 = Q1.b.x(parcel, iD);
                    break;
                case 3:
                    zX3 = Q1.b.x(parcel, iD);
                    break;
                case 4:
                    zX4 = Q1.b.x(parcel, iD);
                    break;
                case 5:
                    zX5 = Q1.b.x(parcel, iD);
                    break;
                case 6:
                    zX6 = Q1.b.x(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C1588n(zX, zX2, zX3, zX4, zX5, zX6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i7) {
        return new C1588n[i7];
    }
}
