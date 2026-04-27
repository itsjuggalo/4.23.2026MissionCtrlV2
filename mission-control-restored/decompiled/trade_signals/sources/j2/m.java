package j2;

import Q1.C0790b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        C0790b c0790b = null;
        int iR = 0;
        I i8 = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 1) {
                iR = T1.b.r(parcel, iP);
            } else if (iK == 2) {
                c0790b = (C0790b) T1.b.e(parcel, iP, C0790b.CREATOR);
            } else if (iK != 3) {
                T1.b.v(parcel, iP);
            } else {
                i8 = (I) T1.b.e(parcel, iP, I.CREATOR);
            }
        }
        T1.b.j(parcel, iW);
        return new l(iR, c0790b, i8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new l[i8];
    }
}
