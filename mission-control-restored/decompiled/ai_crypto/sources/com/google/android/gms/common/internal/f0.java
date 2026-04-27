package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        int iF = 0;
        boolean zX = false;
        boolean zX2 = false;
        int iF2 = 0;
        int iF3 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW == 2) {
                zX = Q1.b.x(parcel, iD);
            } else if (iW == 3) {
                zX2 = Q1.b.x(parcel, iD);
            } else if (iW == 4) {
                iF2 = Q1.b.F(parcel, iD);
            } else if (iW != 5) {
                Q1.b.L(parcel, iD);
            } else {
                iF3 = Q1.b.F(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new C1209u(iF, zX, zX2, iF2, iF3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1209u[i7];
    }
}
