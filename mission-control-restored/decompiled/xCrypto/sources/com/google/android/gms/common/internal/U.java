package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class U implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        int iF = 0;
        boolean zX = false;
        boolean zX2 = false;
        IBinder iBinderE = null;
        C1984b c1984b = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF = A1.b.F(parcel, iD);
            } else if (iW == 2) {
                iBinderE = A1.b.E(parcel, iD);
            } else if (iW == 3) {
                c1984b = (C1984b) A1.b.p(parcel, iD, C1984b.CREATOR);
            } else if (iW == 4) {
                zX = A1.b.x(parcel, iD);
            } else if (iW != 5) {
                A1.b.L(parcel, iD);
            } else {
                zX2 = A1.b.x(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new T(iF, iBinderE, c1984b, zX, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new T[i4];
    }
}
