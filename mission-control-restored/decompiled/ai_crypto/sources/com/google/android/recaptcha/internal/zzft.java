package com.google.android.recaptcha.internal;

import E5.E;
import H5.d;
import b6.AbstractC1077k;
import b6.L;
import b6.M;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzft implements zzfo {
    private final L zza;
    private final zzgf zzb;
    private final zzhx zzc;
    private final Map zzd;

    public zzft(L l7, zzgf zzgfVar, zzhx zzhxVar, Map map) {
        this.zza = l7;
        this.zzb = zzgfVar;
        this.zzc = zzhxVar;
        this.zzd = map;
    }

    public static final /* synthetic */ void zzf(zzft zzftVar, zzuf zzufVar, zzgd zzgdVar) throws zzce {
        zzjh zzjhVarZzb = zzjh.zzb();
        int iZza = zzgdVar.zza();
        zzgx zzgxVar = (zzgx) zzftVar.zzd.get(Integer.valueOf(zzufVar.zzf()));
        if (zzgxVar == null) {
            throw new zzce(5, 2, null);
        }
        int iZzg = zzufVar.zzg();
        zzue[] zzueVarArr = (zzue[]) zzufVar.zzj().toArray(new zzue[0]);
        zzgxVar.zza(iZzg, zzgdVar, (zzue[]) Arrays.copyOf(zzueVarArr, zzueVarArr.length));
        if (iZza == zzgdVar.zza()) {
            zzgdVar.zzg(zzgdVar.zza() + 1);
        }
        zzjhVarZzb.zzf();
        long jZza = zzjhVarZzb.zza(TimeUnit.MICROSECONDS);
        int i7 = zzbk.zza;
        int iZzk = zzufVar.zzk();
        if (iZzk == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zzbk.zza(iZzk - 2, jZza);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzg(List list, zzgd zzgdVar, d dVar) {
        Object objC = M.c(new zzfq(zzgdVar, list, this, null), dVar);
        return objC == I5.c.e() ? objC : E.f1657a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzh(Exception exc, zzgd zzgdVar, d dVar) {
        Object objC = M.c(new zzfr(exc, zzgdVar, this, null), dVar);
        return objC == I5.c.e() ? objC : E.f1657a;
    }

    @Override // com.google.android.recaptcha.internal.zzfo
    public final void zza(String str) {
        AbstractC1077k.d(this.zza, null, null, new zzfs(new zzgd(this.zzb), this, str, null), 3, null);
    }
}
