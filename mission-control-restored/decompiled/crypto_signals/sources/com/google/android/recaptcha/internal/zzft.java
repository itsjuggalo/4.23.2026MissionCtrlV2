package com.google.android.recaptcha.internal;

import G4.l;
import I4.d;
import J4.a;
import a5.A;
import a5.C;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzft implements zzfo {
    private final A zza;
    private final zzgf zzb;
    private final zzhx zzc;
    private final Map zzd;

    public zzft(A a6, zzgf zzgfVar, zzhx zzhxVar, Map map) {
        this.zza = a6;
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
        int i = zzbk.zza;
        int iZzk = zzufVar.zzk();
        if (iZzk == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zzbk.zza(iZzk - 2, jZza);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzg(List list, zzgd zzgdVar, d dVar) throws Throwable {
        Object objE = C.e(new zzfq(zzgdVar, list, this, null), dVar);
        return objE == a.f791a ? objE : l.f540a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzh(Exception exc, zzgd zzgdVar, d dVar) throws Throwable {
        Object objE = C.e(new zzfr(exc, zzgdVar, this, null), dVar);
        return objE == a.f791a ? objE : l.f540a;
    }

    @Override // com.google.android.recaptcha.internal.zzfo
    public final void zza(String str) {
        C.p(this.zza, new zzfs(new zzgd(this.zzb), this, str, null));
    }
}
