package a3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: renamed from: a3.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0875s implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListU = null;
        ArrayList arrayListU2 = null;
        C0855i c0855i = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = Q1.b.q(parcel, iD);
            } else if (iW == 3) {
                arrayListU = Q1.b.u(parcel, iD, Z2.S.CREATOR);
            } else if (iW == 4) {
                arrayListU2 = Q1.b.u(parcel, iD, Z2.Y.CREATOR);
            } else if (iW != 5) {
                Q1.b.L(parcel, iD);
            } else {
                c0855i = (C0855i) Q1.b.p(parcel, iD, C0855i.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new C0869p(strQ, strQ2, arrayListU, arrayListU2, c0855i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0869p[i7];
    }
}
