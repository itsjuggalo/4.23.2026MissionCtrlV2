package com.google.android.recaptcha.internal;

import E5.j;
import E5.k;
import H5.d;
import Z5.t;
import b6.M;

/* JADX INFO: loaded from: classes.dex */
public final class zzff {
    private final j zza;
    private final j zzb;
    private final j zzc;

    public zzff() {
        int i7 = zzav.zza;
        this.zza = k.b(zzfc.zza);
        this.zzb = k.b(zzfd.zza);
        this.zzc = k.b(zzfe.zza);
    }

    public static final /* synthetic */ zzfk zzb(zzff zzffVar) {
        return (zzfk) zzffVar.zza.getValue();
    }

    public static /* synthetic */ Object zze(zzff zzffVar, zzsc zzscVar, zzek zzekVar, d dVar) throws Exception {
        String strZza;
        try {
            String strZzl = zzscVar.zzl();
            String strZzM = zzscVar.zzM();
            zzaq zzaqVarZzf = zzffVar.zzf();
            String strZzb = null;
            if (zzaqVarZzf != null && zzaqVarZzf.zzd(strZzM)) {
                zzen zzenVarZzf = zzekVar.zzf(25);
                try {
                    strZza = zzffVar.zzf().zza(strZzM);
                } catch (Exception e7) {
                    zzenVarZzf.zzb(new zzbd(zzbb.zzk, zzba.zzR, e7.getMessage()));
                }
                if (strZza != null) {
                    zzenVarZzf.zza();
                    strZzb = strZza;
                } else {
                    zzenVarZzf.zzb(new zzbd(zzbb.zzk, zzba.zzS, null));
                }
            }
            if (strZzb == null) {
                zzaq zzaqVarZzf2 = zzffVar.zzf();
                if (zzaqVarZzf2 != null) {
                    zzaqVarZzf2.zzb();
                }
                zzen zzenVarZzf2 = zzekVar.zzf(23);
                try {
                    strZzb = zzffVar.zzg().zzb(strZzl);
                    zzenVarZzf2.zza();
                    zzen zzenVarZzf3 = zzekVar.zzf(24);
                    try {
                        zzaq zzaqVarZzf3 = zzffVar.zzf();
                        if (zzaqVarZzf3 != null) {
                            zzaqVarZzf3.zzc(strZzM, strZzb);
                        }
                        zzenVarZzf3.zza();
                    } catch (Exception e8) {
                        zzenVarZzf3.zzb(new zzbd(zzbb.zzk, zzba.zzT, e8.getMessage()));
                    }
                } catch (zzbd e9) {
                    zzenVarZzf2.zzb(e9);
                    throw e9;
                }
            }
            return t.w(zzscVar.zzk(), "JAVASCRIPT_TAG", strZzb, false, 4, null);
        } catch (Exception e10) {
            if (e10 instanceof zzbd) {
                throw e10;
            }
            throw new zzbd(zzbb.zzb, zzba.zzL, e10.getMessage());
        }
    }

    private final zzaq zzf() {
        return (zzaq) this.zzb.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzey zzg() {
        return (zzey) this.zzc.getValue();
    }

    public final Object zzc(String str, zzto zztoVar, d dVar) {
        return M.c(new zzfb(this, str, zztoVar, null), dVar);
    }

    public final Object zzd(zzsc zzscVar, zzek zzekVar, d dVar) {
        return zze(this, zzscVar, zzekVar, dVar);
    }
}
