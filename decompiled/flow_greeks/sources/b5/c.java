package b5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashSet;
import n5.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        HashSet hashSet = new HashSet();
        int iF = 0;
        ArrayList arrayListU = null;
        e eVar = null;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                iF = n5.b.F(parcel, iD);
                hashSet.add(1);
            } else if (iW == 2) {
                arrayListU = n5.b.u(parcel, iD, g.CREATOR);
                hashSet.add(2);
            } else if (iW == 3) {
                iF2 = n5.b.F(parcel, iD);
                hashSet.add(3);
            } else if (iW != 4) {
                n5.b.L(parcel, iD);
            } else {
                eVar = (e) n5.b.p(parcel, iD, e.CREATOR);
                hashSet.add(4);
            }
        }
        if (parcel.dataPosition() == iM) {
            return new b(hashSet, iF, arrayListU, iF2, eVar);
        }
        throw new b.a("Overread allowed size end=" + iM, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new b[i10];
    }
}
