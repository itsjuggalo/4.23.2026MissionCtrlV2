package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zznc implements zznk {
    private final zznk[] zza;

    public zznc(zznk... zznkVarArr) {
        this.zza = zznkVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    public final boolean zzb(Class cls) {
        for (int i8 = 0; i8 < 2; i8++) {
            if (this.zza[i8].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    public final zznj zzc(Class cls) {
        for (int i8 = 0; i8 < 2; i8++) {
            zznk zznkVar = this.zza[i8];
            if (zznkVar.zzb(cls)) {
                return zznkVar.zzc(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
