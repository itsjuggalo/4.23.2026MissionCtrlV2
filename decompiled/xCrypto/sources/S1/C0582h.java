package S1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: S1.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0582h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        long jH = 0;
        long jH2 = 0;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                jH = A1.b.H(parcel, iD);
            } else if (iW == 2) {
                iF = A1.b.F(parcel, iD);
            } else if (iW != 3) {
                A1.b.L(parcel, iD);
            } else {
                jH2 = A1.b.H(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new C0574g(jH, iF, jH2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0574g[i4];
    }
}
