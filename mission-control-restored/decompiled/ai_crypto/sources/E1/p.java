package E1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.TokenData;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        Long lI = null;
        ArrayList arrayListS = null;
        String strQ2 = null;
        int iF = 0;
        boolean zX = false;
        boolean zX2 = false;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case 2:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 3:
                    lI = Q1.b.I(parcel, iD);
                    break;
                case 4:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 5:
                    zX2 = Q1.b.x(parcel, iD);
                    break;
                case 6:
                    arrayListS = Q1.b.s(parcel, iD);
                    break;
                case 7:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new TokenData(iF, strQ, lI, zX, zX2, arrayListS, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new TokenData[i7];
    }
}
