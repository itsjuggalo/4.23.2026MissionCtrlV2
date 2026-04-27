package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class o0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        C1209u c1209u = null;
        int[] iArrK = null;
        int[] iArrK2 = null;
        boolean zX = false;
        boolean zX2 = false;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    c1209u = (C1209u) Q1.b.p(parcel, iD, C1209u.CREATOR);
                    break;
                case 2:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 3:
                    zX2 = Q1.b.x(parcel, iD);
                    break;
                case 4:
                    iArrK = Q1.b.k(parcel, iD);
                    break;
                case 5:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case 6:
                    iArrK2 = Q1.b.k(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C1195f(c1209u, zX, zX2, iArrK, iF, iArrK2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1195f[i7];
    }
}
