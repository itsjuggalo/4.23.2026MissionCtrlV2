package T1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        ArrayList arrayListU = null;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW != 2) {
                Q1.b.L(parcel, iD);
            } else {
                arrayListU = Q1.b.u(parcel, iD, d.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new a(iF, arrayListU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new a[i7];
    }
}
