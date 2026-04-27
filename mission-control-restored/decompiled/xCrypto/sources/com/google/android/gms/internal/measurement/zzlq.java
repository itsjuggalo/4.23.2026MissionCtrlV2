package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzlq {
    static final zzlq zza = new zzlq(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzlq zzd;
    private final Map zze;

    public zzlq() {
        this.zze = new HashMap();
    }

    public static zzlq zza() {
        zzlq zzlqVar = zzd;
        if (zzlqVar != null) {
            return zzlqVar;
        }
        synchronized (zzlq.class) {
            try {
                zzlq zzlqVar2 = zzd;
                if (zzlqVar2 != null) {
                    return zzlqVar2;
                }
                int i4 = zznt.zza;
                zzlq zzlqVarZzb = zzly.zzb(zzlq.class);
                zzd = zzlqVarZzb;
                return zzlqVarZzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzmd zzb(zznl zznlVar, int i4) {
        return (zzmd) this.zze.get(new zzlp(zznlVar, i4));
    }

    public zzlq(boolean z4) {
        this.zze = Collections.EMPTY_MAP;
    }
}
