package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class L implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        Status status = null;
        C0503n c0503n = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                status = (Status) A1.b.p(parcel, iD, Status.CREATOR);
            } else if (iW != 2) {
                A1.b.L(parcel, iD);
            } else {
                c0503n = (C0503n) A1.b.p(parcel, iD, C0503n.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new C0502m(status, c0503n);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i4) {
        return new C0502m[i4];
    }
}
