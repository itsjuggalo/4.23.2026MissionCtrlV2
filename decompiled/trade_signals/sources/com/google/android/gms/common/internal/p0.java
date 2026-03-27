package com.google.android.gms.common.internal;

import Z1.a;
import android.os.IBinder;
import android.os.Parcel;
import e2.AbstractC1663a;

/* JADX INFO: loaded from: classes.dex */
public final class p0 extends AbstractC1663a implements L {
    public p0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.L
    public final int zzc() {
        Parcel parcelD = D(2, E());
        int i8 = parcelD.readInt();
        parcelD.recycle();
        return i8;
    }

    @Override // com.google.android.gms.common.internal.L
    public final Z1.a zzd() {
        Parcel parcelD = D(1, E());
        Z1.a aVarE = a.AbstractBinderC0162a.E(parcelD.readStrongBinder());
        parcelD.recycle();
        return aVarE;
    }
}
