package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class Z extends zza implements b0 {
    public Z(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.b0
    public final P1.F M(P1.D d7) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, d7);
        Parcel parcelZzB = zzB(8, parcelZza);
        P1.F f7 = (P1.F) zzc.zza(parcelZzB, P1.F.CREATOR);
        parcelZzB.recycle();
        return f7;
    }

    @Override // com.google.android.gms.common.internal.b0
    public final P1.F S(P1.D d7) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, d7);
        Parcel parcelZzB = zzB(6, parcelZza);
        P1.F f7 = (P1.F) zzc.zza(parcelZzB, P1.F.CREATOR);
        parcelZzB.recycle();
        return f7;
    }

    @Override // com.google.android.gms.common.internal.b0
    public final boolean V(P1.H h7, Z1.a aVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, h7);
        zzc.zze(parcelZza, aVar);
        Parcel parcelZzB = zzB(5, parcelZza);
        boolean zZzf = zzc.zzf(parcelZzB);
        parcelZzB.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.common.internal.b0
    public final boolean zzi() {
        Parcel parcelZzB = zzB(7, zza());
        boolean zZzf = zzc.zzf(parcelZzB);
        parcelZzB.recycle();
        return zZzf;
    }
}
