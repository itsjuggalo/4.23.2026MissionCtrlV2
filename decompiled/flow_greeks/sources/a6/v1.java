package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzgx;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        byte[] bArrG = null;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                zX = n5.b.x(parcel, iD);
            } else if (iW != 2) {
                n5.b.L(parcel, iD);
            } else {
                bArrG = n5.b.g(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new u1(zX, bArrG != null ? zzgx.zzl(bArrG, 0, bArrG.length) : null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new u1[i10];
    }
}
