package N1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: N1.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0467f0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            if (A1.b.w(iD) != 1) {
                A1.b.L(parcel, iD);
            } else {
                zX = A1.b.x(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new F(zX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new F[i4];
    }
}
