package S1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: S1.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0654q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        Bundle bundleF = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            if (A1.b.w(iD) != 1) {
                A1.b.L(parcel, iD);
            } else {
                bundleF = A1.b.f(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new C0646p(bundleF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0646p[i4];
    }
}
