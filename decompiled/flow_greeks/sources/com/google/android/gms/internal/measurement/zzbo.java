package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbo extends zzbl implements zzbq {
    public zzbo(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbq
    public final Bundle zze(Bundle bundle) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        Parcel parcelZzP = zzP(1, parcelZza);
        Bundle bundle2 = (Bundle) zzbn.zzb(parcelZzP, Bundle.CREATOR);
        parcelZzP.recycle();
        return bundle2;
    }
}
