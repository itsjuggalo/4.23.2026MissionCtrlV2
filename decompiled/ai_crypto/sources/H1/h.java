package H1;

import Q1.b;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        HashSet hashSet = new HashSet();
        int iF = 0;
        i iVar = null;
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
                hashSet.add(1);
            } else if (iW == 2) {
                iVar = (i) Q1.b.p(parcel, iD, i.CREATOR);
                hashSet.add(2);
            } else if (iW == 3) {
                strQ = Q1.b.q(parcel, iD);
                hashSet.add(3);
            } else if (iW == 4) {
                strQ2 = Q1.b.q(parcel, iD);
                hashSet.add(4);
            } else if (iW != 5) {
                Q1.b.L(parcel, iD);
            } else {
                strQ3 = Q1.b.q(parcel, iD);
                hashSet.add(5);
            }
        }
        if (parcel.dataPosition() == iM) {
            return new g(hashSet, iF, iVar, strQ, strQ2, strQ3);
        }
        throw new b.a("Overread allowed size end=" + iM, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new g[i7];
    }
}
