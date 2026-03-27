package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
final class zznz implements zzog {
    private final zzog[] zza;

    public zznz(zzog... zzogVarArr) {
        this.zza = zzogVarArr;
    }

    @Override // com.google.android.recaptcha.internal.zzog
    public final zzof zzb(Class cls) {
        for (int i4 = 0; i4 < 2; i4++) {
            zzog zzogVar = this.zza[i4];
            if (zzogVar.zzc(cls)) {
                return zzogVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.recaptcha.internal.zzog
    public final boolean zzc(Class cls) {
        for (int i4 = 0; i4 < 2; i4++) {
            if (this.zza[i4].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
