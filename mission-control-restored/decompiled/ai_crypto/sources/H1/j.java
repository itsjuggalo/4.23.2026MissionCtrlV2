package H1;

import Q1.b;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        HashSet hashSet = new HashSet();
        int iF = 0;
        String strQ = null;
        byte[] bArrG = null;
        PendingIntent pendingIntent = null;
        a aVar = null;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    iF = Q1.b.F(parcel, iD);
                    hashSet.add(1);
                    break;
                case 2:
                    strQ = Q1.b.q(parcel, iD);
                    hashSet.add(2);
                    break;
                case 3:
                    iF2 = Q1.b.F(parcel, iD);
                    hashSet.add(3);
                    break;
                case 4:
                    bArrG = Q1.b.g(parcel, iD);
                    hashSet.add(4);
                    break;
                case 5:
                    pendingIntent = (PendingIntent) Q1.b.p(parcel, iD, PendingIntent.CREATOR);
                    hashSet.add(5);
                    break;
                case 6:
                    aVar = (a) Q1.b.p(parcel, iD, a.CREATOR);
                    hashSet.add(6);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        if (parcel.dataPosition() == iM) {
            return new i(hashSet, iF, strQ, iF2, bArrG, pendingIntent, aVar);
        }
        throw new b.a("Overread allowed size end=" + iM, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new i[i7];
    }
}
