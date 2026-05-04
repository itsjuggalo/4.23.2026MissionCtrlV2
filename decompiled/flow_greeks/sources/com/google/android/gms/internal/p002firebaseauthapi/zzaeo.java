package com.google.android.gms.internal.p002firebaseauthapi;

import a7.g;
import android.content.Context;
import com.google.android.gms.common.internal.s;
import java.util.concurrent.ScheduledExecutorService;
import m7.c1;
import m7.i0;
import m7.o0;
import m7.p0;
import m7.v0;
import m7.y0;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaeo {
    private static final a zza = new a("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzaar zzb;
    private final zzagc zzc;

    public zzaeo(g gVar, ScheduledExecutorService scheduledExecutorService) {
        s.k(gVar);
        Context contextM = gVar.m();
        s.k(contextM);
        this.zzb = new zzaar(new zzafb(gVar, zzafc.zza()));
        this.zzc = new zzagc(contextM, scheduledExecutorService);
    }

    public final void zza(String str, String str2, zzaem zzaemVar) {
        s.e(str);
        s.k(zzaemVar);
        this.zzb.zza(str, str2, new zzael(zzaemVar, zza));
    }

    public final void zzb(String str, String str2, zzaem zzaemVar) {
        s.e(str);
        s.e(str2);
        s.k(zzaemVar);
        this.zzb.zzb(str, str2, new zzael(zzaemVar, zza));
    }

    public final void zzc(String str, String str2, zzaem zzaemVar) {
        s.e(str);
        s.e(str2);
        s.k(zzaemVar);
        this.zzb.zzc(str, str2, new zzael(zzaemVar, zza));
    }

    public final void zzd(String str, String str2, zzaem zzaemVar) {
        s.e(str);
        s.k(zzaemVar);
        this.zzb.zzd(str, str2, new zzael(zzaemVar, zza));
    }

    public final void zze(String str, String str2, zzaem zzaemVar) {
        s.e(str);
        this.zzb.zze(str, str2, new zzael(zzaemVar, zza));
    }

    public final void zzf(String str, String str2, zzaem zzaemVar) {
        s.e(str);
        s.e(str2);
        s.k(zzaemVar);
        this.zzb.zzf(str, str2, new zzael(zzaemVar, zza));
    }

    public final void zze(String str, zzaem zzaemVar) {
        s.e(str);
        s.k(zzaemVar);
        this.zzb.zzf(str, new zzael(zzaemVar, zza));
    }

    public final void zza(zzaic zzaicVar, zzaem zzaemVar) {
        s.k(zzaicVar);
        s.e(zzaicVar.zzb());
        s.k(zzaemVar);
        this.zzb.zza(zzaicVar, new zzael(zzaemVar, zza));
    }

    public final void zzd(String str, zzaem zzaemVar) {
        s.k(zzaemVar);
        this.zzb.zze(str, new zzael(zzaemVar, zza));
    }

    public final void zzb(String str, zzaem zzaemVar) {
        s.e(str);
        s.k(zzaemVar);
        this.zzb.zzb(str, new zzael(zzaemVar, zza));
    }

    public final void zzc(String str, zzaem zzaemVar) {
        s.e(str);
        s.k(zzaemVar);
        this.zzb.zzc(str, new zzael(zzaemVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, zzaem zzaemVar) {
        s.e(str);
        s.e(str2);
        s.k(zzaemVar);
        this.zzb.zza(str, str2, str3, str4, new zzael(zzaemVar, zza));
    }

    public final void zzb(zzahm zzahmVar, zzaem zzaemVar) {
        s.k(zzahmVar);
        s.e(zzahmVar.zzc());
        s.k(zzaemVar);
        this.zzb.zzb(zzahmVar, new zzael(zzaemVar, zza));
    }

    public final void zzc(zzahm zzahmVar, zzaem zzaemVar) {
        s.k(zzahmVar);
        this.zzb.zzc(zzahmVar, new zzael(zzaemVar, zza));
    }

    public final void zza(String str, zzaem zzaemVar) {
        s.e(str);
        s.k(zzaemVar);
        this.zzb.zza(str, new zzael(zzaemVar, zza));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzaem zzaemVar) {
        s.e(str);
        s.e(str2);
        s.k(zzaemVar);
        s.k(zzaemVar);
        this.zzb.zzb(str, str2, str3, str4, new zzael(zzaemVar, zza));
    }

    public final void zza(i0 i0Var, String str, String str2, String str3, zzaem zzaemVar) {
        zzagz zzagzVarZza;
        s.k(i0Var);
        s.f(str, "cachedTokenState should not be empty.");
        s.k(zzaemVar);
        if (i0Var instanceof p0) {
            o0 o0VarA = ((p0) i0Var).a();
            zzagzVarZza = zzahd.zza(str, (String) s.k(o0VarA.zzc()), (String) s.k(o0VarA.U()), str2, str3);
        } else if (i0Var instanceof v0) {
            v0 v0Var = (v0) i0Var;
            zzagzVarZza = zzahf.zza(str, s.e(str2), s.e(((y0) s.k(v0Var.a())).c()), s.e(v0Var.c()), str3);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
        this.zzb.zza(zzagzVarZza, str, new zzael(zzaemVar, zza));
    }

    public final void zza(String str, i0 i0Var, String str2, zzaem zzaemVar) {
        s.e(str);
        s.k(i0Var);
        s.k(zzaemVar);
        if (i0Var instanceof p0) {
            o0 o0VarA = ((p0) i0Var).a();
            this.zzb.zza(zzahc.zza(str, (String) s.k(o0VarA.zzc()), (String) s.k(o0VarA.U()), str2), new zzael(zzaemVar, zza));
        } else {
            if (i0Var instanceof v0) {
                v0 v0Var = (v0) i0Var;
                this.zzb.zza(zzahe.zza(str, s.e(v0Var.c()), str2, s.e(v0Var.b())), new zzael(zzaemVar, zza));
                return;
            }
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zza(zzaho zzahoVar, zzaem zzaemVar) {
        s.k(zzahoVar);
        this.zzb.zza(zzahoVar, new zzael(zzaemVar, zza));
    }

    public final void zza(zzaht zzahtVar, zzaem zzaemVar) {
        s.k(zzahtVar);
        this.zzb.zza(zzahtVar, new zzael(zzaemVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzaem zzaemVar) {
        s.e(str);
        s.e(str2);
        s.e(str3);
        s.k(zzaemVar);
        this.zzb.zza(str, str2, str3, str4, str5, new zzael(zzaemVar, zza));
    }

    public final void zza(String str, zzajb zzajbVar, zzaem zzaemVar) {
        s.e(str);
        s.k(zzajbVar);
        s.k(zzaemVar);
        this.zzb.zza(str, zzajbVar, new zzael(zzaemVar, zza));
    }

    public final void zza(zzahz zzahzVar, zzaem zzaemVar) {
        s.k(zzaemVar);
        s.k(zzahzVar);
        this.zzb.zza(s.e(zzahzVar.zzb()), zzahzVar.zza(), new zzael(zzaemVar, zza));
    }

    public final void zza(zzaie zzaieVar, zzaem zzaemVar) {
        s.k(zzaieVar);
        this.zzb.zza(zzaieVar, new zzael(zzaemVar, zza));
    }

    public final void zza(zzahm zzahmVar, zzaem zzaemVar) {
        s.k(zzahmVar);
        s.e(zzahmVar.zzd());
        s.k(zzaemVar);
        this.zzb.zza(zzahmVar, new zzael(zzaemVar, zza));
    }

    public final void zza(zzaij zzaijVar, zzaem zzaemVar) {
        s.k(zzaemVar);
        s.k(zzaijVar);
        String strZzd = zzaijVar.zzd();
        zzael zzaelVar = new zzael(zzaemVar, zza);
        if (this.zzc.zzc(strZzd)) {
            if (zzaijVar.zze()) {
                this.zzc.zzb(strZzd);
            } else {
                this.zzc.zzb(zzaelVar, strZzd);
                return;
            }
        }
        long jZzb = zzaijVar.zzb();
        boolean zZzf = zzaijVar.zzf();
        if (zza(jZzb, zZzf)) {
            zzaijVar.zza(new zzagm(this.zzc.zzb()));
        }
        this.zzc.zza(strZzd, zzaelVar, jZzb, zZzf);
        this.zzb.zza(zzaijVar, this.zzc.zza(zzaelVar, strZzd));
    }

    public final void zza(zzain zzainVar, zzaem zzaemVar) {
        s.k(zzainVar);
        s.k(zzaemVar);
        this.zzb.zzd(zzainVar.zza(), new zzael(zzaemVar, zza));
    }

    public final void zza(zzajb zzajbVar, zzaem zzaemVar) {
        s.k(zzajbVar);
        s.k(zzaemVar);
        this.zzb.zza(zzajbVar, new zzael(zzaemVar, zza));
    }

    public final void zza(zzajc zzajcVar, zzaem zzaemVar) {
        s.k(zzajcVar);
        s.k(zzaemVar);
        this.zzb.zza(zzajcVar, new zzael(zzaemVar, zza));
    }

    public final void zza(zzagx zzagxVar, zzaem zzaemVar) {
        s.k(zzaemVar);
        s.k(zzagxVar.zzb());
        this.zzb.zza(zzagxVar.zzb(), zzagxVar.zzc(), new zzael(zzaemVar, zza));
    }

    public final void zza(zzaan zzaanVar, zzaem zzaemVar) {
        s.k(zzaemVar);
        s.k(zzaanVar);
        this.zzb.zza(zzafw.zza((o0) s.k(zzaanVar.zza())), new zzael(zzaemVar, zza));
    }

    public final void zza(String str, String str2, String str3, long j10, boolean z10, boolean z11, String str4, String str5, String str6, boolean z12, zzaem zzaemVar) {
        s.f(str, "idToken should not be empty.");
        s.k(zzaemVar);
        zzael zzaelVar = new zzael(zzaemVar, zza);
        if (this.zzc.zzc(str2)) {
            if (z10) {
                this.zzc.zzb(str2);
            } else {
                this.zzc.zzb(zzaelVar, str2);
                return;
            }
        }
        zzais zzaisVarZza = zzais.zza(str, str2, str3, str4, str5, str6, null);
        if (zza(j10, z12)) {
            zzaisVarZza.zza(new zzagm(this.zzc.zzb()));
        }
        this.zzc.zza(str2, zzaelVar, j10, z12);
        this.zzb.zza(zzaisVarZza, this.zzc.zza(zzaelVar, str2));
    }

    public final void zza(zzaaq zzaaqVar, zzaem zzaemVar) {
        s.k(zzaaqVar);
        s.k(zzaemVar);
        String strP = zzaaqVar.zzb().p();
        zzael zzaelVar = new zzael(zzaemVar, zza);
        if (this.zzc.zzc(strP)) {
            if (zzaaqVar.zzh()) {
                this.zzc.zzb(strP);
            } else {
                this.zzc.zzb(zzaelVar, strP);
                return;
            }
        }
        long jZza = zzaaqVar.zza();
        boolean zZzi = zzaaqVar.zzi();
        zzaiq zzaiqVarZza = zzaiq.zza(zzaaqVar.zze(), zzaaqVar.zzb().a(), zzaaqVar.zzb().p(), zzaaqVar.zzd(), zzaaqVar.zzg(), zzaaqVar.zzf(), zzaaqVar.zzc());
        if (zza(jZza, zZzi)) {
            zzaiqVarZza.zza(new zzagm(this.zzc.zzb()));
        }
        this.zzc.zza(strP, zzaelVar, jZza, zZzi);
        this.zzb.zza(zzaiqVarZza, this.zzc.zza(zzaelVar, strP));
    }

    public final void zza(zzaiu zzaiuVar, zzaem zzaemVar) {
        this.zzb.zza(zzaiuVar, new zzael((zzaem) s.k(zzaemVar), zza));
    }

    public final void zza(String str, String str2, String str3, zzaem zzaemVar) {
        s.f(str, "cachedTokenState should not be empty.");
        s.f(str2, "uid should not be empty.");
        s.k(zzaemVar);
        this.zzb.zza(str, str2, str3, new zzael(zzaemVar, zza));
    }

    public final void zza(String str, c1 c1Var, zzaem zzaemVar) {
        s.e(str);
        s.k(c1Var);
        s.k(zzaemVar);
        this.zzb.zza(str, c1Var, new zzael(zzaemVar, zza));
    }

    private static boolean zza(long j10, boolean z10) {
        if (j10 > 0 && z10) {
            return true;
        }
        zza.h("App hash will not be appended to the request.", new Object[0]);
        return false;
    }
}
