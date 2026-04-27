package j2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        ArrayList arrayListG = null;
        String strF = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 1) {
                arrayListG = T1.b.g(parcel, iP);
            } else if (iK != 2) {
                T1.b.v(parcel, iP);
            } else {
                strF = T1.b.f(parcel, iP);
            }
        }
        T1.b.j(parcel, iW);
        return new h(arrayListG, strF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new h[i8];
    }
}
