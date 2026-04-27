package j2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.G;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        G g8 = null;
        int iR = 0;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 1) {
                iR = T1.b.r(parcel, iP);
            } else if (iK != 2) {
                T1.b.v(parcel, iP);
            } else {
                g8 = (G) T1.b.e(parcel, iP, G.CREATOR);
            }
        }
        T1.b.j(parcel, iW);
        return new j(iR, g8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new j[i8];
    }
}
