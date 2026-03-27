package r1;

import N1.C0483t;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class E implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        Uri uri = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        C0483t c0483t = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 2:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ3 = A1.b.q(parcel, iD);
                    break;
                case 4:
                    strQ4 = A1.b.q(parcel, iD);
                    break;
                case 5:
                    uri = (Uri) A1.b.p(parcel, iD, Uri.CREATOR);
                    break;
                case 6:
                    strQ5 = A1.b.q(parcel, iD);
                    break;
                case 7:
                    strQ6 = A1.b.q(parcel, iD);
                    break;
                case 8:
                    strQ7 = A1.b.q(parcel, iD);
                    break;
                case 9:
                    c0483t = (C0483t) A1.b.p(parcel, iD, C0483t.CREATOR);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new l(strQ, strQ2, strQ3, strQ4, uri, strQ5, strQ6, strQ7, c0483t);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new l[i4];
    }
}
