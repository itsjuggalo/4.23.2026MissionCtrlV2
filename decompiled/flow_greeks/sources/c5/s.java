package c5;

import android.os.Parcel;
import android.os.Parcelable;
import c5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        boolean zX = false;
        int iF = 0;
        boolean zX2 = false;
        c.e eVar = null;
        c.b bVar = null;
        String strQ = null;
        c.d dVar = null;
        c.C0067c c0067c = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    eVar = (c.e) n5.b.p(parcel, iD, c.e.CREATOR);
                    break;
                case 2:
                    bVar = (c.b) n5.b.p(parcel, iD, c.b.CREATOR);
                    break;
                case 3:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 4:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 5:
                    iF = n5.b.F(parcel, iD);
                    break;
                case 6:
                    dVar = (c.d) n5.b.p(parcel, iD, c.d.CREATOR);
                    break;
                case 7:
                    c0067c = (c.C0067c) n5.b.p(parcel, iD, c.C0067c.CREATOR);
                    break;
                case 8:
                    zX2 = n5.b.x(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new c(eVar, bVar, strQ, zX, iF, dVar, c0067c, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new c[i10];
    }
}
