package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzgx;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        byte[] bArrG = null;
        byte[] bArrG2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                bArrG = n5.b.g(parcel, iD);
            } else if (iW != 2) {
                n5.b.L(parcel, iD);
            } else {
                bArrG2 = n5.b.g(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new s1(bArrG == null ? null : zzgx.zzl(bArrG, 0, bArrG.length), bArrG2 != null ? zzgx.zzl(bArrG2, 0, bArrG2.length) : null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new s1[i10];
    }
}
