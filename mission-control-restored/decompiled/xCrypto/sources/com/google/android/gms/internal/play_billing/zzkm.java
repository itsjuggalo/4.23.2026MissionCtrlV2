package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class zzkm implements zzhm {
    static final zzhm zza = new zzkm();

    private zzkm() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final boolean zza(int i4) {
        return (i4 != 0 ? i4 != 1 ? i4 != 2 ? i4 != 3 ? null : zzkn.ALTERNATIVE_BILLING_ACTION : zzkn.LOCAL_PURCHASES_UPDATED_ACTION : zzkn.PURCHASES_UPDATED_ACTION : zzkn.BROADCAST_ACTION_UNSPECIFIED) != null;
    }
}
