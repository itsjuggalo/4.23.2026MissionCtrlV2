package I1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import d2.C1447t;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public final class E implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        Uri uri = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        C1447t c1447t = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 2:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    strQ4 = Q1.b.q(parcel, iD);
                    break;
                case 5:
                    uri = (Uri) Q1.b.p(parcel, iD, Uri.CREATOR);
                    break;
                case 6:
                    strQ5 = Q1.b.q(parcel, iD);
                    break;
                case 7:
                    strQ6 = Q1.b.q(parcel, iD);
                    break;
                case 8:
                    strQ7 = Q1.b.q(parcel, iD);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    c1447t = (C1447t) Q1.b.p(parcel, iD, C1447t.CREATOR);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new l(strQ, strQ2, strQ3, strQ4, uri, strQ5, strQ6, strQ7, c1447t);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new l[i7];
    }
}
