package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzay extends zzav {
    public zzay() {
        this.zza.add(zzbk.APPLY);
        this.zza.add(zzbk.BLOCK);
        this.zza.add(zzbk.BREAK);
        this.zza.add(zzbk.CASE);
        this.zza.add(zzbk.DEFAULT);
        this.zza.add(zzbk.CONTINUE);
        this.zza.add(zzbk.DEFINE_FUNCTION);
        this.zza.add(zzbk.FN);
        this.zza.add(zzbk.IF);
        this.zza.add(zzbk.QUOTE);
        this.zza.add(zzbk.RETURN);
        this.zza.add(zzbk.SWITCH);
        this.zza.add(zzbk.TERNARY);
    }

    private static zzao zzc(zzg zzgVar, List list) {
        zzh.zzb(zzbk.FN.name(), 2, list);
        zzao zzaoVarZza = zzgVar.zza((zzao) list.get(0));
        zzao zzaoVarZza2 = zzgVar.zza((zzao) list.get(1));
        if (!(zzaoVarZza2 instanceof zzae)) {
            throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", zzaoVarZza2.getClass().getCanonicalName()));
        }
        List listZzb = ((zzae) zzaoVarZza2).zzb();
        List arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new zzan(zzaoVarZza.zzc(), listZzb, arrayList, zzgVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x015e  */
    @Override // com.google.android.gms.internal.measurement.zzav
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.zzao zza(java.lang.String r8, com.google.android.gms.internal.measurement.zzg r9, java.util.List r10) {
        /*
            Method dump skipped, instruction units count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzay.zza(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzao");
    }
}
