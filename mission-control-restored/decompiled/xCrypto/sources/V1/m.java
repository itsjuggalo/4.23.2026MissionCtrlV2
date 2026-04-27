package V1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.T;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        C1984b c1984b = null;
        int iF = 0;
        T t4 = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF = A1.b.F(parcel, iD);
            } else if (iW == 2) {
                c1984b = (C1984b) A1.b.p(parcel, iD, C1984b.CREATOR);
            } else if (iW != 3) {
                A1.b.L(parcel, iD);
            } else {
                t4 = (T) A1.b.p(parcel, iD, T.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new l(iF, c1984b, t4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new l[i4];
    }
}
