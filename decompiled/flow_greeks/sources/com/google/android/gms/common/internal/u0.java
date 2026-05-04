package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 extends zza implements w0 {
    public u0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.w0
    public final boolean c(m5.j0 j0Var, w5.a aVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, j0Var);
        zzc.zze(parcelZza, aVar);
        Parcel parcelZzB = zzB(5, parcelZza);
        boolean zZza = zzc.zza(parcelZzB);
        parcelZzB.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.common.internal.w0
    public final m5.h0 g(m5.f0 f0Var) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, f0Var);
        Parcel parcelZzB = zzB(6, parcelZza);
        m5.h0 h0Var = (m5.h0) zzc.zzb(parcelZzB, m5.h0.CREATOR);
        parcelZzB.recycle();
        return h0Var;
    }

    @Override // com.google.android.gms.common.internal.w0
    public final m5.h0 q(m5.f0 f0Var) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, f0Var);
        Parcel parcelZzB = zzB(8, parcelZza);
        m5.h0 h0Var = (m5.h0) zzc.zzb(parcelZzB, m5.h0.CREATOR);
        parcelZzB.recycle();
        return h0Var;
    }

    @Override // com.google.android.gms.common.internal.w0
    public final boolean zzg() {
        Parcel parcelZzB = zzB(7, zza());
        boolean zZza = zzc.zza(parcelZzB);
        parcelZzB.recycle();
        return zZza;
    }
}
