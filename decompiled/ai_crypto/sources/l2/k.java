package l2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Q;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        Q q7 = null;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW != 2) {
                Q1.b.L(parcel, iD);
            } else {
                q7 = (Q) Q1.b.p(parcel, iD, Q.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new j(iF, q7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new j[i7];
    }
}
