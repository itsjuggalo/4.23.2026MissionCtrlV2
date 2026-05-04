package a6;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b2 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        x xVar = null;
        Uri uri = null;
        byte[] bArrG = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 2) {
                xVar = (x) n5.b.p(parcel, iD, x.CREATOR);
            } else if (iW == 3) {
                uri = (Uri) n5.b.p(parcel, iD, Uri.CREATOR);
            } else if (iW != 4) {
                n5.b.L(parcel, iD);
            } else {
                bArrG = n5.b.g(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new m(xVar, uri, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new m[i10];
    }
}
