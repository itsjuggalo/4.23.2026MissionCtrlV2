package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zznb implements zznj {
    private final zznj[] zza;

    public zznb(zznj... zznjVarArr) {
        this.zza = zznjVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final boolean zzb(Class cls) {
        for (int i7 = 0; i7 < 2; i7++) {
            if (this.zza[i7].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final zzni zzc(Class cls) {
        for (int i7 = 0; i7 < 2; i7++) {
            zznj zznjVar = this.zza[i7];
            if (zznjVar.zzb(cls)) {
                return zznjVar.zzc(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
