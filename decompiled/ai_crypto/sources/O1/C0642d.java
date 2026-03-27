package O1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: O1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0642d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            if (Q1.b.w(iD) != 1) {
                Q1.b.L(parcel, iD);
            } else {
                intent = (Intent) Q1.b.p(parcel, iD, Intent.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new C0639a(intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0639a[i7];
    }
}
