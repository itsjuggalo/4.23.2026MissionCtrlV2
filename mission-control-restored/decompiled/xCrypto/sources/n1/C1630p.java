package n1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.TokenData;
import java.util.ArrayList;

/* JADX INFO: renamed from: n1.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1630p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        Long lI = null;
        ArrayList arrayListS = null;
        String strQ2 = null;
        int iF = 0;
        boolean zX = false;
        boolean zX2 = false;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    iF = A1.b.F(parcel, iD);
                    break;
                case 2:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 3:
                    lI = A1.b.I(parcel, iD);
                    break;
                case 4:
                    zX = A1.b.x(parcel, iD);
                    break;
                case 5:
                    zX2 = A1.b.x(parcel, iD);
                    break;
                case 6:
                    arrayListS = A1.b.s(parcel, iD);
                    break;
                case 7:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new TokenData(iF, strQ, lI, zX, zX2, arrayListS, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new TokenData[i4];
    }
}
