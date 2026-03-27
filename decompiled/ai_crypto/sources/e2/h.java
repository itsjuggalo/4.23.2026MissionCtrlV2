package e2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.common.Transport;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        byte[] bArrG = null;
        ArrayList arrayListU = null;
        int iF = 0;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW == 2) {
                bArrG = Q1.b.g(parcel, iD);
            } else if (iW == 3) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                arrayListU = Q1.b.u(parcel, iD, Transport.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new b(iF, bArrG, strQ, arrayListU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new b[i7];
    }
}
