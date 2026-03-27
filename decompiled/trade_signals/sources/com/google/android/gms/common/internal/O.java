package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import e2.AbstractC1663a;

/* JADX INFO: loaded from: classes.dex */
public final class O extends AbstractC1663a implements Q {
    public O(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.Q
    public final Q1.F A(Q1.D d8) {
        Parcel parcelE = E();
        e2.e.c(parcelE, d8);
        Parcel parcelD = D(8, parcelE);
        Q1.F f8 = (Q1.F) e2.e.a(parcelD, Q1.F.CREATOR);
        parcelD.recycle();
        return f8;
    }

    @Override // com.google.android.gms.common.internal.Q
    public final Q1.F o(Q1.D d8) {
        Parcel parcelE = E();
        e2.e.c(parcelE, d8);
        Parcel parcelD = D(6, parcelE);
        Q1.F f8 = (Q1.F) e2.e.a(parcelD, Q1.F.CREATOR);
        parcelD.recycle();
        return f8;
    }

    @Override // com.google.android.gms.common.internal.Q
    public final boolean r(Q1.H h8, Z1.a aVar) {
        Parcel parcelE = E();
        e2.e.c(parcelE, h8);
        e2.e.d(parcelE, aVar);
        Parcel parcelD = D(5, parcelE);
        boolean zE = e2.e.e(parcelD);
        parcelD.recycle();
        return zE;
    }

    @Override // com.google.android.gms.common.internal.Q
    public final boolean zzi() {
        Parcel parcelD = D(7, E());
        boolean zE = e2.e.e(parcelD);
        parcelD.recycle();
        return zE;
    }
}
