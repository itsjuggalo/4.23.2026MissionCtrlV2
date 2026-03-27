package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zznb implements zznj {
    private final zznj[] zza;

    public zznb(zznj... zznjVarArr) {
        this.zza = zznjVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final boolean zzb(Class cls) {
        for (int i4 = 0; i4 < 2; i4++) {
            if (this.zza[i4].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zznj
    public final zzni zzc(Class cls) {
        for (int i4 = 0; i4 < 2; i4++) {
            zznj zznjVar = this.zza[i4];
            if (zznjVar.zzb(cls)) {
                return zznjVar.zzc(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
