package c6;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    public static void c(c cVar, Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, cVar.W(), false);
        n5.c.j(parcel, 2, cVar.S(), false);
        n5.c.j(parcel, 3, cVar.R(), false);
        n5.c.E(parcel, 4, cVar.U(), false);
        n5.c.E(parcel, 5, cVar.V(), false);
        n5.c.E(parcel, 6, cVar.T(), false);
        n5.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        String strQ = "";
        String strQ2 = strQ;
        String strQ3 = strQ2;
        Bundle bundleF = null;
        Bundle bundleF2 = null;
        String strQ4 = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 2:
                    bundleF = n5.b.f(parcel, iD);
                    break;
                case 3:
                    bundleF2 = n5.b.f(parcel, iD);
                    break;
                case 4:
                    strQ4 = n5.b.q(parcel, iD);
                    break;
                case 5:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case 6:
                    strQ3 = n5.b.q(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new c(strQ, bundleF, bundleF2, strQ4, strQ2, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c[] newArray(int i10) {
        return new c[i10];
    }
}
