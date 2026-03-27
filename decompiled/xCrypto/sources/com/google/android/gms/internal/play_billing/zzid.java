package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class zzid implements zzik {
    private final zzik[] zza;

    public zzid(zzik... zzikVarArr) {
        this.zza = zzikVarArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzik
    public final zzij zzb(Class cls) {
        for (int i4 = 0; i4 < 2; i4++) {
            zzik zzikVar = this.zza[i4];
            if (zzikVar.zzc(cls)) {
                return zzikVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.play_billing.zzik
    public final boolean zzc(Class cls) {
        for (int i4 = 0; i4 < 2; i4++) {
            if (this.zza[i4].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
