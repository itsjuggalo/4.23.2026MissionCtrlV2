package P1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: P1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0760d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            if (T1.b.k(iP) != 1) {
                T1.b.v(parcel, iP);
            } else {
                intent = (Intent) T1.b.e(parcel, iP, Intent.CREATOR);
            }
        }
        T1.b.j(parcel, iW);
        return new C0757a(intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new C0757a[i8];
    }
}
