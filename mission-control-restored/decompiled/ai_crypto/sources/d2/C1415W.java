package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.common.Transport;
import java.util.ArrayList;

/* JADX INFO: renamed from: d2.W, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1415W implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        byte[] bArrG = null;
        ArrayList arrayListU = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 2) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW == 3) {
                bArrG = Q1.b.g(parcel, iD);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                arrayListU = Q1.b.u(parcel, iD, Transport.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1449v(strQ, bArrG, arrayListU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1449v[i7];
    }
}
