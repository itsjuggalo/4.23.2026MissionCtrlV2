package a3;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: a3.I0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0821I0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        C0855i c0855i = null;
        C0819H0 c0819h0 = null;
        Z2.y0 y0Var = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                c0855i = (C0855i) Q1.b.p(parcel, iD, C0855i.CREATOR);
            } else if (iW == 2) {
                c0819h0 = (C0819H0) Q1.b.p(parcel, iD, C0819H0.CREATOR);
            } else if (iW != 3) {
                Q1.b.L(parcel, iD);
            } else {
                y0Var = (Z2.y0) Q1.b.p(parcel, iD, Z2.y0.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new C0823J0(c0855i, c0819h0, y0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0823J0[i7];
    }
}
