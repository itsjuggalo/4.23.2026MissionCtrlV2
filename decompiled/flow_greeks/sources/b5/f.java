package b5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        ArrayList arrayListS = null;
        ArrayList arrayListS2 = null;
        ArrayList arrayListS3 = null;
        ArrayList arrayListS4 = null;
        ArrayList arrayListS5 = null;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    iF = n5.b.F(parcel, iD);
                    break;
                case 2:
                    arrayListS = n5.b.s(parcel, iD);
                    break;
                case 3:
                    arrayListS2 = n5.b.s(parcel, iD);
                    break;
                case 4:
                    arrayListS3 = n5.b.s(parcel, iD);
                    break;
                case 5:
                    arrayListS4 = n5.b.s(parcel, iD);
                    break;
                case 6:
                    arrayListS5 = n5.b.s(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new e(iF, arrayListS, arrayListS2, arrayListS3, arrayListS4, arrayListS5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new e[i10];
    }
}
