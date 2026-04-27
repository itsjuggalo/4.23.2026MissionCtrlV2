package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class zzkm implements zzhm {
    static final zzhm zza = new zzkm();

    private zzkm() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final boolean zza(int i7) {
        return (i7 != 0 ? i7 != 1 ? i7 != 2 ? i7 != 3 ? null : zzkn.ALTERNATIVE_BILLING_ACTION : zzkn.LOCAL_PURCHASES_UPDATED_ACTION : zzkn.PURCHASES_UPDATED_ACTION : zzkn.BROADCAST_ACTION_UNSPECIFIED) != null;
    }
}
