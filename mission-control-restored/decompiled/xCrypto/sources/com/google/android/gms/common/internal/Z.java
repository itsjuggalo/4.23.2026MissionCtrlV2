package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;
import z1.C1973D;
import z1.C1975F;
import z1.C1977H;

/* JADX INFO: loaded from: classes.dex */
public final class Z extends zza implements b0 {
    public Z(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.b0
    public final boolean A(C1977H c1977h, J1.a aVar) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, c1977h);
        zzc.zze(parcelZza, aVar);
        Parcel parcelZzB = zzB(5, parcelZza);
        boolean zZzf = zzc.zzf(parcelZzB);
        parcelZzB.recycle();
        return zZzf;
    }

    @Override // com.google.android.gms.common.internal.b0
    public final C1975F e(C1973D c1973d) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, c1973d);
        Parcel parcelZzB = zzB(8, parcelZza);
        C1975F c1975f = (C1975F) zzc.zza(parcelZzB, C1975F.CREATOR);
        parcelZzB.recycle();
        return c1975f;
    }

    @Override // com.google.android.gms.common.internal.b0
    public final C1975F y(C1973D c1973d) {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, c1973d);
        Parcel parcelZzB = zzB(6, parcelZza);
        C1975F c1975f = (C1975F) zzc.zza(parcelZzB, C1975F.CREATOR);
        parcelZzB.recycle();
        return c1975f;
    }

    @Override // com.google.android.gms.common.internal.b0
    public final boolean zzi() {
        Parcel parcelZzB = zzB(7, zza());
        boolean zZzf = zzc.zzf(parcelZzB);
        parcelZzB.recycle();
        return zZzf;
    }
}
