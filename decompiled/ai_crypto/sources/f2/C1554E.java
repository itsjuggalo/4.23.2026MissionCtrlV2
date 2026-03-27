package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import k4.C2105D;

/* JADX INFO: renamed from: f2.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1554E implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
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
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case 2:
                    jH = Q1.b.H(parcel, iD);
                    break;
                case 3:
                    jH2 = Q1.b.H(parcel, iD);
                    break;
                case 4:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 5:
                    jH3 = Q1.b.H(parcel, iD);
                    break;
                case 6:
                    iF2 = Q1.b.F(parcel, iD);
                    break;
                case 7:
                    fB = Q1.b.B(parcel, iD);
                    break;
                case 8:
                    jH4 = Q1.b.H(parcel, iD);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    zX2 = Q1.b.x(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new LocationRequest(iF, jH, jH2, zX, jH3, iF2, fB, jH4, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i7) {
        return new LocationRequest[i7];
    }
}
