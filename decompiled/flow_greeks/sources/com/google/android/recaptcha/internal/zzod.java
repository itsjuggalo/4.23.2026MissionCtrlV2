package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzod {
    public static final boolean zza(Object obj) {
        return !((zzoc) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzoc zzocVarZzb = (zzoc) obj;
        zzoc zzocVar = (zzoc) obj2;
        if (!zzocVar.isEmpty()) {
            if (!zzocVarZzb.zze()) {
                zzocVarZzb = zzocVarZzb.zzb();
            }
            zzocVarZzb.zzd(zzocVar);
        }
        return zzocVarZzb;
    }
}
