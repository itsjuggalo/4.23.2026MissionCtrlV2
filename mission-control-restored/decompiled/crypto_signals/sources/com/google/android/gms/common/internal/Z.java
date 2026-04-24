package com.google.android.gms.common.internal;

import android.os.Parcel;
import com.google.android.gms.internal.common.zza;

/* JADX INFO: loaded from: classes.dex */
public final class Z extends zza implements D {
    @Override // com.google.android.gms.common.internal.D
    public final int zzc() {
        Parcel parcelZzB = zzB(2, zza());
        int i = parcelZzB.readInt();
        parcelZzB.recycle();
        return i;
    }

    @Override // com.google.android.gms.common.internal.D
    public final E1.a zzd() {
        Parcel parcelZzB = zzB(1, zza());
        E1.a aVarA = E1.b.a(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarA;
    }
}
