package q1;

import A1.b;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        HashSet hashSet = new HashSet();
        int iF = 0;
        String strQ = null;
        byte[] bArrG = null;
        PendingIntent pendingIntent = null;
        C1719a c1719a = null;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    iF = A1.b.F(parcel, iD);
                    hashSet.add(1);
                    break;
                case 2:
                    strQ = A1.b.q(parcel, iD);
                    hashSet.add(2);
                    break;
                case 3:
                    iF2 = A1.b.F(parcel, iD);
                    hashSet.add(3);
                    break;
                case 4:
                    bArrG = A1.b.g(parcel, iD);
                    hashSet.add(4);
                    break;
                case 5:
                    pendingIntent = (PendingIntent) A1.b.p(parcel, iD, PendingIntent.CREATOR);
                    hashSet.add(5);
                    break;
                case 6:
                    c1719a = (C1719a) A1.b.p(parcel, iD, C1719a.CREATOR);
                    hashSet.add(6);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        if (parcel.dataPosition() == iM) {
            return new i(hashSet, iF, strQ, iF2, bArrG, pendingIntent, c1719a);
        }
        throw new b.a("Overread allowed size end=" + iM, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new i[i4];
    }
}
