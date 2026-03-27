package N1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class y0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        C0487x c0487x = null;
        Uri uri = null;
        byte[] bArrG = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 2) {
                c0487x = (C0487x) A1.b.p(parcel, iD, C0487x.CREATOR);
            } else if (iW == 3) {
                uri = (Uri) A1.b.p(parcel, iD, Uri.CREATOR);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                bArrG = A1.b.g(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new C0477m(c0487x, uri, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0477m[i4];
    }
}
