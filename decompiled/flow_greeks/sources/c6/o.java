package c6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Parcelable.Creator {
    public static void c(n nVar, Parcel parcel, int i10) {
        n5.c.b(parcel, n5.c.a(parcel));
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public n createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            n5.b.w(iD);
            n5.b.L(parcel, iD);
        }
        n5.b.v(parcel, iM);
        return new n();
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public n[] newArray(int i10) {
        return new n[i10];
    }
}
