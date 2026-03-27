package com.google.android.recaptcha.internal;

import H4.g;
import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class zzhc implements zzgx {
    public static final zzhc zza = new zzhc();

    private zzhc() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        int length = zzueVarArr.length;
        if (length < 2) {
            throw new zzce(4, 3, null);
        }
        Class<?> clsZza = zzgdVar.zzc().zza(zzueVarArr[0]);
        if (true != Objects.nonNull(clsZza)) {
            clsZza = null;
        }
        if (clsZza == null) {
            throw new zzce(4, 5, null);
        }
        Class<?> cls = clsZza instanceof Class ? clsZza : clsZza.getClass();
        Object objZza = zzgdVar.zzc().zza(zzueVarArr[1]);
        if (true != (objZza instanceof String)) {
            objZza = null;
        }
        String str = (String) objZza;
        if (str == null) {
            throw new zzce(4, 5, null);
        }
        String strZza = zzgdVar.zzh().zza(str);
        if (j.a(strZza, "forName")) {
            throw new zzce(6, 48, null);
        }
        Class[] clsArrZzf = zzgdVar.zzc().zzf(g.k0(zzueVarArr).subList(2, length));
        try {
            zzgdVar.zzc().zze(i, cls.getMethod(strZza, (Class[]) Arrays.copyOf(clsArrZzf, clsArrZzf.length)));
        } catch (Exception e) {
            throw new zzce(6, 13, e);
        }
    }
}
