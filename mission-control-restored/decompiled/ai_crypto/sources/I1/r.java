package I1;

import I1.C0577b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        C0577b.e eVar = null;
        C0577b.C0029b c0029b = null;
        String strQ = null;
        C0577b.d dVar = null;
        C0577b.c cVar = null;
        boolean zX = false;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    eVar = (C0577b.e) Q1.b.p(parcel, iD, C0577b.e.CREATOR);
                    break;
                case 2:
                    c0029b = (C0577b.C0029b) Q1.b.p(parcel, iD, C0577b.C0029b.CREATOR);
                    break;
                case 3:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 5:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case 6:
                    dVar = (C0577b.d) Q1.b.p(parcel, iD, C0577b.d.CREATOR);
                    break;
                case 7:
                    cVar = (C0577b.c) Q1.b.p(parcel, iD, C0577b.c.CREATOR);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C0577b(eVar, c0029b, strQ, zX, iF, dVar, cVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0577b[i7];
    }
}
