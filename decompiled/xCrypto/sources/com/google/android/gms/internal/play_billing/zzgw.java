package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgw {
    static final zzgw zza = new zzgw(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzgw zzd;
    private final Map zze;

    public zzgw() {
        this.zze = new HashMap();
    }

    public static zzgw zza() {
        zzgw zzgwVar = zzd;
        if (zzgwVar != null) {
            return zzgwVar;
        }
        synchronized (zzgw.class) {
            try {
                zzgw zzgwVar2 = zzd;
                if (zzgwVar2 != null) {
                    return zzgwVar2;
                }
                int i4 = zziu.zza;
                zzgw zzgwVarZzb = zzhe.zzb(zzgw.class);
                zzd = zzgwVarZzb;
                return zzgwVarZzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzhj zzb(zzim zzimVar, int i4) {
        return (zzhj) this.zze.get(new zzgv(zzimVar, i4));
    }

    public zzgw(boolean z4) {
        this.zze = Collections.EMPTY_MAP;
    }
}
