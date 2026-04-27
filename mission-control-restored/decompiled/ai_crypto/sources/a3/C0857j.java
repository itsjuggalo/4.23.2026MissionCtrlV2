package a3;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: a3.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0857j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        long jH = 0;
        long jH2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                jH = Q1.b.H(parcel, iD);
            } else if (iW != 2) {
                Q1.b.L(parcel, iD);
            } else {
                jH2 = Q1.b.H(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C0859k(jH, jH2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C0859k[i7];
    }
}
