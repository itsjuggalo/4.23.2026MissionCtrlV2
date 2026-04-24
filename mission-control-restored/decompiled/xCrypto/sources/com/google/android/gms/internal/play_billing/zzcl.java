package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class zzcl extends zzbh {
    private final zzco zza;

    public zzcl(zzco zzcoVar, int i4) {
        super(zzcoVar.size(), i4);
        this.zza = zzcoVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbh
    public final Object zza(int i4) {
        return this.zza.get(i4);
    }
}
