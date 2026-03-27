package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzat extends zzaq implements zzav {
    public zzat(IBinder iBinder) {
        super(iBinder, "com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzav
    public final void zza(String str, String str2, zzax zzaxVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        int i7 = zzas.zza;
        parcelZzu.writeStrongBinder(zzaxVar);
        zzx(1, parcelZzu);
    }
}
