package b5;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashSet;
import n5.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        HashSet hashSet = new HashSet();
        int iF = 0;
        String strQ = null;
        byte[] bArrG = null;
        PendingIntent pendingIntent = null;
        a aVar = null;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    iF = n5.b.F(parcel, iD);
                    hashSet.add(1);
                    break;
                case 2:
                    strQ = n5.b.q(parcel, iD);
                    hashSet.add(2);
                    break;
                case 3:
                    iF2 = n5.b.F(parcel, iD);
                    hashSet.add(3);
                    break;
                case 4:
                    bArrG = n5.b.g(parcel, iD);
                    hashSet.add(4);
                    break;
                case 5:
                    pendingIntent = (PendingIntent) n5.b.p(parcel, iD, PendingIntent.CREATOR);
                    hashSet.add(5);
                    break;
                case 6:
                    aVar = (a) n5.b.p(parcel, iD, a.CREATOR);
                    hashSet.add(6);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        if (parcel.dataPosition() == iM) {
            return new i(hashSet, iF, strQ, iF2, bArrG, pendingIntent, aVar);
        }
        throw new b.a("Overread allowed size end=" + iM, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new i[i10];
    }
}
