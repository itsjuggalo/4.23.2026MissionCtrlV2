package d2;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class y0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        C1451x c1451x = null;
        Uri uri = null;
        byte[] bArrG = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 2) {
                c1451x = (C1451x) Q1.b.p(parcel, iD, C1451x.CREATOR);
            } else if (iW == 3) {
                uri = (Uri) Q1.b.p(parcel, iD, Uri.CREATOR);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                bArrG = Q1.b.g(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1440m(c1451x, uri, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1440m[i7];
    }
}
