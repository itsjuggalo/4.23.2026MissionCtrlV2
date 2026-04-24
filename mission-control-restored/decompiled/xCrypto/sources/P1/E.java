package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;

/* JADX INFO: loaded from: classes.dex */
public final class E implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        int iF = 102;
        long jH = 3600000;
        long jH2 = 600000;
        boolean zX = false;
        boolean zX2 = false;
        long jH3 = Long.MAX_VALUE;
        int iF2 = Integer.MAX_VALUE;
        float fB = 0.0f;
        long jH4 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    iF = A1.b.F(parcel, iD);
                    break;
                case 2:
                    jH = A1.b.H(parcel, iD);
                    break;
                case 3:
                    jH2 = A1.b.H(parcel, iD);
                    break;
                case 4:
                    zX = A1.b.x(parcel, iD);
                    break;
                case 5:
                    jH3 = A1.b.H(parcel, iD);
                    break;
                case 6:
                    iF2 = A1.b.F(parcel, iD);
                    break;
                case 7:
                    fB = A1.b.B(parcel, iD);
                    break;
                case 8:
                    jH4 = A1.b.H(parcel, iD);
                    break;
                case 9:
                    zX2 = A1.b.x(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new LocationRequest(iF, jH, jH2, zX, jH3, iF2, fB, jH4, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i4) {
        return new LocationRequest[i4];
    }
}
