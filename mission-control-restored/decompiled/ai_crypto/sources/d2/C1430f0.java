package d2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: d2.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1430f0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            if (Q1.b.w(iD) != 1) {
                Q1.b.L(parcel, iD);
            } else {
                zX = Q1.b.x(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1399F(zX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1399F[i7];
    }
}
