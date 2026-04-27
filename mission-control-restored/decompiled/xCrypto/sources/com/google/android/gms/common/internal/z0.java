package com.google.android.gms.common.internal;

import J1.a;
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
        int i4 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i4;
    }

    @Override // com.google.android.gms.common.internal.W
    public final J1.a zzd() {
        Parcel parcelZzB = zzB(1, zza());
        J1.a aVarB = a.AbstractBinderC0026a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }
}
