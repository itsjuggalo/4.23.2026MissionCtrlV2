package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;

/* JADX INFO: renamed from: P1.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0507s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = "";
        ArrayList arrayListU = null;
        int iF = 0;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                arrayListU = A1.b.u(parcel, iD, zzbe.CREATOR);
            } else if (iW == 2) {
                iF = A1.b.F(parcel, iD);
            } else if (iW == 3) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                strQ2 = A1.b.q(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new C0497h(arrayListU, iF, strQ, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object[] newArray(int i4) {
        return new C0497h[i4];
    }
}
