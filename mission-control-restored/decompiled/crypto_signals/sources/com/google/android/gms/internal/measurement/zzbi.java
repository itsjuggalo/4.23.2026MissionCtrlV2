package com.google.android.gms.internal.measurement;

import java.util.List;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class zzbi extends zzav {
    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String str, zzg zzgVar, List list) {
        if (str == null || str.isEmpty() || !zzgVar.zzd(str)) {
            throw new IllegalArgumentException(AbstractC1024h.b("Command not found: ", str));
        }
        zzao zzaoVarZzh = zzgVar.zzh(str);
        if (zzaoVarZzh instanceof zzai) {
            return ((zzai) zzaoVarZzh).zza(zzgVar, list);
        }
        throw new IllegalArgumentException(AbstractC1024h.c("Function ", str, " is not defined"));
    }
}
