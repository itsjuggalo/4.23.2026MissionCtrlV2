package com.google.android.gms.internal.play_billing;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzaw extends zzar implements zzax {
    public zzaw() {
        super("com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideServiceCallback");
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final boolean zzb(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 != 1) {
            return false;
        }
        int i6 = parcel.readInt();
        zzas.zzb(parcel);
        zza(i6);
        return true;
    }
}
