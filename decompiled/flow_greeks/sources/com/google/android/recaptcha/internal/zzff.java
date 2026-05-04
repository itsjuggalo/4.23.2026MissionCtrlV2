package com.google.android.recaptcha.internal;

import cd.k;
import cd.l;
import gd.e;
import kg.z;
import ng.o0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzff {
    private final k zza;
    private final k zzb;
    private final k zzc;

    public zzff() {
        int i10 = zzav.zza;
        this.zza = l.b(zzfc.zza);
        this.zzb = l.b(zzfd.zza);
        this.zzc = l.b(zzfe.zza);
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
                } catch (Exception e10) {
                    zzenVarZzf.zzb(new zzbd(zzbb.zzk, zzba.zzR, e10.getMessage()));
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
                    } catch (Exception e11) {
                        zzenVarZzf3.zzb(new zzbd(zzbb.zzk, zzba.zzT, e11.getMessage()));
                    }
                    str = strZzb;
                } catch (zzbd e12) {
                    zzenVarZzf2.zzb(e12);
                    throw e12;
                }
            }
            return z.F(zzscVar.zzk(), "JAVASCRIPT_TAG", str, false, 4, null);
        } catch (Exception e13) {
            if (e13 instanceof zzbd) {
                throw e13;
            }
            throw new zzbd(zzbb.zzb, zzba.zzL, e13.getMessage());
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
        return o0.c(new zzfb(this, str, zztoVar, null), eVar);
    }

    public final Object zzd(zzsc zzscVar, zzek zzekVar, e eVar) {
        return zze(this, zzscVar, zzekVar, eVar);
    }
}
