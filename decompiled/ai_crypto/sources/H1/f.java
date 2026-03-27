package H1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        ArrayList arrayListS = null;
        ArrayList arrayListS2 = null;
        ArrayList arrayListS3 = null;
        ArrayList arrayListS4 = null;
        ArrayList arrayListS5 = null;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case 2:
                    arrayListS = Q1.b.s(parcel, iD);
                    break;
                case 3:
                    arrayListS2 = Q1.b.s(parcel, iD);
                    break;
                case 4:
                    arrayListS3 = Q1.b.s(parcel, iD);
                    break;
                case 5:
                    arrayListS4 = Q1.b.s(parcel, iD);
                    break;
                case 6:
                    arrayListS5 = Q1.b.s(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new e(iF, arrayListS, arrayListS2, arrayListS3, arrayListS4, arrayListS5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new e[i7];
    }
}
