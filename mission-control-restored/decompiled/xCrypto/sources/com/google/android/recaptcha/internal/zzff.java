package com.google.android.recaptcha.internal;

import W2.j;
import W2.k;
import Z2.e;
import r3.x;
import t3.M;

/* JADX INFO: loaded from: classes.dex */
public final class zzff {
    private final j zza;
    private final j zzb;
    private final j zzc;

    public zzff() {
        int i4 = zzav.zza;
        this.zza = k.b(zzfc.zza);
        this.zzb = k.b(zzfd.zza);
        this.zzc = k.b(zzfe.zza);
    }

    public static final /* synthetic */ zzfk zzb(zzff zzffVar) {
        return (zzfk) zzffVar.zza.getValue();
    }

    public static /* synthetic */ Object zze(zzff zzffVar, zzsc zzscVar, zzek zzekVar, e eVar) throws Exception {
        String strZza;
        try {
            String strZzl = zzscVar.zzl();
            String strZzM = zzscVar.zzM();
            zzaq zzaqVarZzf = zzffVar.zzf();
            String str = null;
            if (zzaqVarZzf != null && zzaqVarZzf.zzd(strZzM)) {
                zzen zzenVarZzf = zzekVar.zzf(25);
                try {
                    strZza = zzffVar.zzf().zza(strZzM);
                } catch (Exception e4) {
                    zzenVarZzf.zzb(new zzbd(zzbb.zzk, zzba.zzR, e4.getMessage()));
                }
                if (strZza != null) {
                    zzenVarZzf.zza();
                    str = strZza;
                } else {
                    zzenVarZzf.zzb(new zzbd(zzbb.zzk, zzba.zzS, null));
                }
            }
            if (str == null) {
                zzaq zzaqVarZzf2 = zzffVar.zzf();
                if (zzaqVarZzf2 != null) {
                    zzaqVarZzf2.zzb();
                }
                zzen zzenVarZzf2 = zzekVar.zzf(23);
                try {
                    String strZzb = zzffVar.zzg().zzb(strZzl);
                    zzenVarZzf2.zza();
                    zzen zzenVarZzf3 = zzekVar.zzf(24);
                    try {
                        zzaq zzaqVarZzf3 = zzffVar.zzf();
                        if (zzaqVarZzf3 != null) {
                            zzaqVarZzf3.zzc(strZzM, strZzb);
                        }
                        zzenVarZzf3.zza();
                    } catch (Exception e5) {
                        zzenVarZzf3.zzb(new zzbd(zzbb.zzk, zzba.zzT, e5.getMessage()));
                    }
                    str = strZzb;
                } catch (zzbd e6) {
                    zzenVarZzf2.zzb(e6);
                    throw e6;
                }
            }
            return x.A(zzscVar.zzk(), "JAVASCRIPT_TAG", str, false, 4, null);
        } catch (Exception e7) {
            if (e7 instanceof zzbd) {
                throw e7;
            }
            throw new zzbd(zzbb.zzb, zzba.zzL, e7.getMessage());
        }
    }

    private final zzaq zzf() {
        return (zzaq) this.zzb.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzey zzg() {
        return (zzey) this.zzc.getValue();
    }

    public final Object zzc(String str, zzto zztoVar, e eVar) {
        return M.e(new zzfb(this, str, zztoVar, null), eVar);
    }

    public final Object zzd(zzsc zzscVar, zzek zzekVar, e eVar) {
        return zze(this, zzscVar, zzekVar, eVar);
    }
}
