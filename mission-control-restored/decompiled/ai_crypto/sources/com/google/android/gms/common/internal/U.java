package com.google.android.gms.common.internal;

import P1.C0648b;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class U implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        int iF = 0;
        boolean zX = false;
        boolean zX2 = false;
        IBinder iBinderE = null;
        C0648b c0648b = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW == 2) {
                iBinderE = Q1.b.E(parcel, iD);
            } else if (iW == 3) {
                c0648b = (C0648b) Q1.b.p(parcel, iD, C0648b.CREATOR);
            } else if (iW == 4) {
                zX = Q1.b.x(parcel, iD);
            } else if (iW != 5) {
                Q1.b.L(parcel, iD);
            } else {
                zX2 = Q1.b.x(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new T(iF, iBinderE, c0648b, zX, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new T[i7];
    }
}
