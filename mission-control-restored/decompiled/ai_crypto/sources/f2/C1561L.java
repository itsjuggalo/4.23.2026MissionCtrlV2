package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: f2.L, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1561L implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        Status status = null;
        C1588n c1588n = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                status = (Status) Q1.b.p(parcel, iD, Status.CREATOR);
            } else if (iW != 2) {
                Q1.b.L(parcel, iD);
            } else {
                c1588n = (C1588n) Q1.b.p(parcel, iD, C1588n.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1587m(status, c1588n);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i7) {
        return new C1587m[i7];
    }
}
