package com.google.android.recaptcha.internal;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zznv {
    public static final List zza(Object obj, long j4) {
        zznk zznkVar = (zznk) zzps.zzf(obj, j4);
        if (zznkVar.zzc()) {
            return zznkVar;
        }
        int size = zznkVar.size();
        zznk zznkVarZzd = zznkVar.zzd(size == 0 ? 10 : size + size);
        zzps.zzs(obj, j4, zznkVarZzd);
        return zznkVarZzd;
    }
}
