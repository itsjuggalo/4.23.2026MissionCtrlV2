package y1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: y1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1941d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            if (A1.b.w(iD) != 1) {
                A1.b.L(parcel, iD);
            } else {
                intent = (Intent) A1.b.p(parcel, iD, Intent.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new C1938a(intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C1938a[i4];
    }
}
