package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        byte[][] bArrH = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            if (n5.b.w(iD) != 1) {
                n5.b.L(parcel, iD);
            } else {
                bArrH = n5.b.h(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new u0(bArrH);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new u0[i10];
    }
}
