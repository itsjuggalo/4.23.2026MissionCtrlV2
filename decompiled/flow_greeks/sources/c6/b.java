package c6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    public static void c(a aVar, Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.g(parcel, 1, aVar.R());
        n5.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            if (n5.b.w(iD) != 1) {
                n5.b.L(parcel, iD);
            } else {
                zX = n5.b.x(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new a(zX);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a[] newArray(int i10) {
        return new a[i10];
    }
}
