package i2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: i2.I, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1749I implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        Bundle bundleF = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            if (Q1.b.w(iD) != 2) {
                Q1.b.L(parcel, iD);
            } else {
                bundleF = Q1.b.f(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1748H(bundleF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1748H[i7];
    }
}
