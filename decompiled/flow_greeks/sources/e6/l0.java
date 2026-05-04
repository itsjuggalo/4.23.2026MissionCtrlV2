package e6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        Status status = null;
        n nVar = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                status = (Status) n5.b.p(parcel, iD, Status.CREATOR);
            } else if (iW != 2) {
                n5.b.L(parcel, iD);
            } else {
                nVar = (n) n5.b.p(parcel, iD, n.CREATOR);
            }
        }
        n5.b.v(parcel, iM);
        return new m(status, nVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new m[i10];
    }
}
