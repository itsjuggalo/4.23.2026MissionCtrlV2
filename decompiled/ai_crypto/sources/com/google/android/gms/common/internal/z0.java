package com.google.android.gms.common.internal;

import Z1.a;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: loaded from: classes.dex */
public final class z0 extends zza implements W {
    public z0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.W
    public final int zzc() {
        Parcel parcelZzB = zzB(2, zza());
        int i7 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i7;
    }

    @Override // com.google.android.gms.common.internal.W
    public final Z1.a zzd() {
        Parcel parcelZzB = zzB(1, zza());
        Z1.a aVarB = a.AbstractBinderC0104a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }
}
