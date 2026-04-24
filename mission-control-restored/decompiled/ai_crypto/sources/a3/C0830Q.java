package a3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: renamed from: a3.Q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0830Q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        ArrayList arrayListU = null;
        ArrayList arrayListU2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                arrayListU = Q1.b.u(parcel, iD, Z2.S.CREATOR);
            } else if (iW != 2) {
                Q1.b.L(parcel, iD);
            } else {
                arrayListU2 = Q1.b.u(parcel, iD, Z2.Y.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new C0827N(arrayListU, arrayListU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0827N[i7];
    }
}
