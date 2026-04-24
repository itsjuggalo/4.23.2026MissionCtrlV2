package a3;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: a3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0845d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 2:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ5 = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    strQ4 = Q1.b.q(parcel, iD);
                    break;
                case 5:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case 6:
                    strQ6 = Q1.b.q(parcel, iD);
                    break;
                case 7:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 8:
                    strQ7 = Q1.b.q(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C0847e(strQ, strQ2, strQ3, strQ4, strQ5, strQ6, zX, strQ7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0847e[i7];
    }
}
