package z1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: z1.I, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1978I implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        boolean zX = false;
        String strQ = null;
        IBinder iBinderE = null;
        boolean zX2 = false;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW == 2) {
                iBinderE = A1.b.E(parcel, iD);
            } else if (iW == 3) {
                zX = A1.b.x(parcel, iD);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                zX2 = A1.b.x(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new C1977H(strQ, iBinderE, zX, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C1977H[i4];
    }
}
