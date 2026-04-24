package l2;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        Intent intent = null;
        int iF = 0;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW == 2) {
                iF2 = Q1.b.F(parcel, iD);
            } else if (iW != 3) {
                Q1.b.L(parcel, iD);
            } else {
                intent = (Intent) Q1.b.p(parcel, iD, Intent.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new C2157b(iF, iF2, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C2157b[i7];
    }
}
