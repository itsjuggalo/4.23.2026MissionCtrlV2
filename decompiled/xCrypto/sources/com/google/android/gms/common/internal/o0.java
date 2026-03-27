package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class o0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        C0942u c0942u = null;
        int[] iArrK = null;
        int[] iArrK2 = null;
        boolean zX = false;
        boolean zX2 = false;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    c0942u = (C0942u) A1.b.p(parcel, iD, C0942u.CREATOR);
                    break;
                case 2:
                    zX = A1.b.x(parcel, iD);
                    break;
                case 3:
                    zX2 = A1.b.x(parcel, iD);
                    break;
                case 4:
                    iArrK = A1.b.k(parcel, iD);
                    break;
                case 5:
                    iF = A1.b.F(parcel, iD);
                    break;
                case 6:
                    iArrK2 = A1.b.k(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new C0928f(c0942u, zX, zX2, iArrK, iF, iArrK2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0928f[i4];
    }
}
