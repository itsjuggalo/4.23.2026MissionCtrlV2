package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0926d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class X implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        ArrayList arrayListU = null;
        String strQ = null;
        ArrayList arrayListU2 = null;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                arrayListU = A1.b.u(parcel, iD, C0492c.CREATOR);
            } else if (iW == 2) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW == 3) {
                arrayListU2 = A1.b.u(parcel, iD, C0926d.CREATOR);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                strQ2 = A1.b.q(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new C0493d(arrayListU, strQ, arrayListU2, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i4) {
        return new C0493d[i4];
    }
}
