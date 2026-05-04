package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        u uVar = null;
        int[] iArrK = null;
        int[] iArrK2 = null;
        boolean zX = false;
        boolean zX2 = false;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    uVar = (u) n5.b.p(parcel, iD, u.CREATOR);
                    break;
                case 2:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 3:
                    zX2 = n5.b.x(parcel, iD);
                    break;
                case 4:
                    iArrK = n5.b.k(parcel, iD);
                    break;
                case 5:
                    iF = n5.b.F(parcel, iD);
                    break;
                case 6:
                    iArrK2 = n5.b.k(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new f(uVar, zX, zX2, iArrK, iF, iArrK2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new f[i10];
    }
}
