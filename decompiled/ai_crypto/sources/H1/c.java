package H1;

import Q1.b;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        HashSet hashSet = new HashSet();
        int iF = 0;
        ArrayList arrayListU = null;
        e eVar = null;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
                hashSet.add(1);
            } else if (iW == 2) {
                arrayListU = Q1.b.u(parcel, iD, g.CREATOR);
                hashSet.add(2);
            } else if (iW == 3) {
                iF2 = Q1.b.F(parcel, iD);
                hashSet.add(3);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                eVar = (e) Q1.b.p(parcel, iD, e.CREATOR);
                hashSet.add(4);
            }
        }
        if (parcel.dataPosition() == iM) {
            return new b(hashSet, iF, arrayListU, iF2, eVar);
        }
        throw new b.a("Overread allowed size end=" + iM, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new b[i7];
    }
}
