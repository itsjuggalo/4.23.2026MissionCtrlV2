package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.s;
import m7.c1;
import m7.j;
import m7.z1;
import n7.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaar {
    private final zzaft zza;

    public zzaar(zzaft zzaftVar) {
        this.zza = (zzaft) s.k(zzaftVar);
    }

    public final void zzb(String str, String str2, zzael zzaelVar) {
        s.e(str);
        s.e(str2);
        s.k(zzaelVar);
        zza(str, new zzacj(this, str2, zzaelVar));
    }

    public final void zzc(String str, String str2, zzael zzaelVar) {
        s.e(str);
        s.e(str2);
        s.k(zzaelVar);
        zza(str, new zzacm(this, str2, zzaelVar));
    }

    public final void zzd(String str, String str2, zzael zzaelVar) {
        s.e(str);
        s.k(zzaelVar);
        this.zza.zza(new zzaic(str, null, str2), new zzabe(this, zzaelVar));
    }

    public final void zze(String str, String str2, zzael zzaelVar) {
        s.e(str);
        s.k(zzaelVar);
        this.zza.zza(new zzags(str, str2), new zzabc(this, zzaelVar));
    }

    public final void zzf(String str, zzael zzaelVar) {
        s.e(str);
        s.k(zzaelVar);
        zza(str, new zzabn(this, zzaelVar));
    }

    public static /* synthetic */ void zza(zzaar zzaarVar, zzajd zzajdVar, zzael zzaelVar, zzafs zzafsVar) {
        Status statusA;
        if (zzajdVar.zzo()) {
            z1 z1VarZzb = zzajdVar.zzb();
            String strZzc = zzajdVar.zzc();
            String strZzj = zzajdVar.zzj();
            if (zzajdVar.zzm()) {
                statusA = new Status(17012);
            } else {
                statusA = r.a(zzajdVar.zzd());
            }
            zzaelVar.zza(new zzaap(statusA, z1VarZzb, strZzc, strZzj));
            return;
        }
        zzaarVar.zza(new zzahv(zzajdVar.zzi(), zzajdVar.zze(), Long.valueOf(zzajdVar.zza()), "Bearer"), zzajdVar.zzh(), zzajdVar.zzg(), Boolean.valueOf(zzajdVar.zzn()), zzajdVar.zzb(), zzaelVar, zzafsVar);
    }

    public final void zzf(String str, String str2, zzael zzaelVar) {
        s.e(str);
        s.e(str2);
        s.k(zzaelVar);
        zza(str2, new zzabq(this, str, zzaelVar));
    }

    private final void zzd(zzahm zzahmVar, zzael zzaelVar) {
        s.k(zzahmVar);
        s.k(zzaelVar);
        this.zza.zza(zzahmVar, new zzacf(this, zzaelVar));
    }

    public final void zzb(String str, zzael zzaelVar) {
        s.e(str);
        s.k(zzaelVar);
        this.zza.zza(new zzahj(str), new zzaau(this, zzaelVar));
    }

    public final void zzc(String str, zzael zzaelVar) {
        s.e(str);
        s.k(zzaelVar);
        zza(str, new zzacc(this, zzaelVar));
    }

    public final void zze(String str, zzael zzaelVar) {
        s.k(zzaelVar);
        this.zza.zza(new zzaim(str), new zzaci(this, zzaelVar));
    }

    public final void zzc(zzahm zzahmVar, zzael zzaelVar) {
        zzd(zzahmVar, zzaelVar);
    }

    public final void zzd(String str, zzael zzaelVar) {
        s.k(zzaelVar);
        this.zza.zza(str, new zzacg(this, zzaelVar));
    }

    public final void zzb(zzahm zzahmVar, zzael zzaelVar) {
        s.e(zzahmVar.zzc());
        s.k(zzaelVar);
        this.zza.zza(zzahmVar, new zzabb(this, zzaelVar));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzael zzaelVar) {
        s.e(str);
        s.e(str2);
        s.k(zzaelVar);
        this.zza.zza(new zzaje(str, str2, str3, str4), new zzaaw(this, zzaelVar));
    }

    public static /* synthetic */ void zza(zzaar zzaarVar, zzael zzaelVar, zzaim zzaimVar, zzafs zzafsVar) {
        s.k(zzaelVar);
        s.k(zzaimVar);
        s.k(zzafsVar);
        zzaarVar.zza.zza(zzaimVar, new zzabk(zzaarVar, zzaelVar, zzafsVar));
    }

    public static /* synthetic */ void zza(zzaar zzaarVar, zzael zzaelVar, zzahv zzahvVar, zzail zzailVar, zzafs zzafsVar) {
        s.k(zzaelVar);
        s.k(zzahvVar);
        s.k(zzailVar);
        s.k(zzafsVar);
        zzaarVar.zza.zza(new zzahi(zzahvVar.zzc()), new zzaax(zzaarVar, zzafsVar, zzaelVar, zzahvVar, zzailVar));
    }

    public static /* synthetic */ void zza(zzaar zzaarVar, zzael zzaelVar, zzahv zzahvVar, zzahk zzahkVar, zzail zzailVar, zzafs zzafsVar) {
        s.k(zzaelVar);
        s.k(zzahvVar);
        s.k(zzahkVar);
        s.k(zzailVar);
        s.k(zzafsVar);
        zzaarVar.zza.zza(zzailVar, new zzaba(zzaarVar, zzailVar, zzahkVar, zzaelVar, zzahvVar, zzafsVar));
    }

    public final void zza(String str, String str2, zzael zzaelVar) {
        s.e(str);
        s.k(zzaelVar);
        zzail zzailVar = new zzail();
        zzailVar.zze(str);
        zzailVar.zzh(str2);
        this.zza.zza(zzailVar, new zzacl(this, zzaelVar));
    }

    public final void zza(zzaic zzaicVar, zzael zzaelVar) {
        s.e(zzaicVar.zzb());
        s.k(zzaelVar);
        this.zza.zza(zzaicVar, new zzabg(this, zzaelVar));
    }

    public final void zza(String str, String str2, String str3, String str4, zzael zzaelVar) {
        s.e(str);
        s.e(str2);
        s.k(zzaelVar);
        this.zza.zza(new zzaim(str, str2, null, str3, str4, null), new zzaat(this, zzaelVar));
    }

    public final void zza(String str, zzael zzaelVar) {
        s.e(str);
        s.k(zzaelVar);
        zza(str, new zzace(this, zzaelVar));
    }

    private final void zza(String str, zzafv<zzahv> zzafvVar) {
        s.k(zzafvVar);
        s.e(str);
        zzahv zzahvVarZzb = zzahv.zzb(str);
        if (zzahvVarZzb.zzg()) {
            zzafvVar.zza(zzahvVarZzb);
        } else {
            this.zza.zza(new zzahj(zzahvVarZzb.zzd()), new zzaco(this, zzafvVar));
        }
    }

    public final void zza(zzagz zzagzVar, String str, zzael zzaelVar) {
        s.k(zzagzVar);
        s.k(zzaelVar);
        zza(str, new zzabw(this, zzagzVar, zzaelVar));
    }

    public final void zza(zzahb zzahbVar, zzael zzaelVar) {
        s.k(zzahbVar);
        s.k(zzaelVar);
        this.zza.zza(zzahbVar, new zzaby(this, zzaelVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzagx zzagxVar, zzael zzaelVar) {
        s.k(zzagxVar);
        s.k(zzaelVar);
        this.zza.zza(zzagxVar, new zzaay(this, zzaelVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzahv zzahvVar, String str, String str2, Boolean bool, z1 z1Var, zzael zzaelVar, zzafs zzafsVar) {
        s.k(zzahvVar);
        s.k(zzafsVar);
        s.k(zzaelVar);
        this.zza.zza(new zzahi(zzahvVar.zzc()), new zzaaz(this, zzafsVar, str2, str, bool, z1Var, zzaelVar, zzahvVar));
    }

    public final void zza(zzaho zzahoVar, zzael zzaelVar) {
        s.k(zzahoVar);
        s.k(zzaelVar);
        this.zza.zza(zzahoVar, new zzabz(this, zzaelVar));
    }

    public final void zza(zzaht zzahtVar, zzael zzaelVar) {
        s.k(zzahtVar);
        s.k(zzaelVar);
        this.zza.zza(zzahtVar, new zzaca(this, zzaelVar));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzael zzaelVar) {
        s.e(str);
        s.e(str2);
        s.e(str3);
        s.k(zzaelVar);
        zza(str3, new zzabh(this, str, str2, str4, str5, zzaelVar));
    }

    public final void zza(String str, zzajb zzajbVar, zzael zzaelVar) {
        s.e(str);
        s.k(zzajbVar);
        s.k(zzaelVar);
        zza(str, new zzabl(this, zzajbVar, zzaelVar));
    }

    public final void zza(String str, zzajg zzajgVar, zzael zzaelVar) {
        s.e(str);
        s.k(zzajgVar);
        s.k(zzaelVar);
        zza(str, new zzabj(this, zzajgVar, zzaelVar));
    }

    public final void zza(zzaie zzaieVar, zzael zzaelVar) {
        this.zza.zza(zzaieVar, new zzach(this, zzaelVar));
    }

    public final void zza(zzahm zzahmVar, zzael zzaelVar) {
        s.e(zzahmVar.zzd());
        s.k(zzaelVar);
        zzd(zzahmVar, zzaelVar);
    }

    public final void zza(zzaij zzaijVar, zzael zzaelVar) {
        s.e(zzaijVar.zzd());
        s.k(zzaelVar);
        this.zza.zza(zzaijVar, new zzabf(this, zzaelVar));
    }

    public final void zza(zzajb zzajbVar, zzael zzaelVar) {
        s.k(zzajbVar);
        s.k(zzaelVar);
        zzajbVar.zzb(true);
        this.zza.zza(zzajbVar, new zzabu(this, zzaelVar));
    }

    public final void zza(zzajc zzajcVar, zzael zzaelVar) {
        s.k(zzajcVar);
        s.k(zzaelVar);
        this.zza.zza(zzajcVar, new zzabd(this, zzaelVar));
    }

    public final void zza(j jVar, String str, zzael zzaelVar) {
        s.k(jVar);
        s.k(zzaelVar);
        if (jVar.zzg()) {
            zza(jVar.W(), new zzaav(this, jVar, str, zzaelVar));
        } else {
            zza(new zzagx(jVar, null, str), zzaelVar);
        }
    }

    public final void zza(zzajg zzajgVar, zzael zzaelVar) {
        s.k(zzajgVar);
        s.k(zzaelVar);
        this.zza.zza(zzajgVar, new zzabi(this, zzaelVar));
    }

    public final void zza(zzaio zzaioVar, zzael zzaelVar) {
        s.k(zzaioVar);
        s.k(zzaelVar);
        this.zza.zza(zzaioVar, new zzabt(this, zzaioVar, zzaelVar));
    }

    public final void zza(zzaiq zzaiqVar, zzael zzaelVar) {
        s.k(zzaiqVar);
        s.k(zzaelVar);
        this.zza.zza(zzaiqVar, new zzabx(this, zzaelVar));
    }

    public final void zza(String str, String str2, String str3, zzael zzaelVar) {
        s.e(str);
        s.e(str2);
        s.k(zzaelVar);
        zza(str, new zzabs(this, str2, str3, zzaelVar));
    }

    public final void zza(String str, c1 c1Var, zzael zzaelVar) {
        s.e(str);
        s.k(c1Var);
        s.k(zzaelVar);
        zza(str, new zzack(this, c1Var, zzaelVar));
    }
}
