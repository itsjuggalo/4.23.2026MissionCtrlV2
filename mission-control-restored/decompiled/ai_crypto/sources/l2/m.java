package l2;

import P1.C0648b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.T;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        C0648b c0648b = null;
        int iF = 0;
        T t7 = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW == 2) {
                c0648b = (C0648b) Q1.b.p(parcel, iD, C0648b.CREATOR);
            } else if (iW != 3) {
                Q1.b.L(parcel, iD);
            } else {
                t7 = (T) Q1.b.p(parcel, iD, T.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new l(iF, c0648b, t7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new l[i7];
    }
}
