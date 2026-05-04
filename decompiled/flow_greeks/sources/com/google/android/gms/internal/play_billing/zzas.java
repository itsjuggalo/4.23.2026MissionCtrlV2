package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzas extends zzap implements zzau {
    public zzas(IBinder iBinder) {
        super(iBinder, "com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzau
    public final void zza(String str, String str2, zzaw zzawVar) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeString(str);
        parcelZzs.writeString(str2);
        int i10 = zzar.zza;
        parcelZzs.writeStrongBinder(zzawVar);
        zzv(1, parcelZzs);
    }
}
