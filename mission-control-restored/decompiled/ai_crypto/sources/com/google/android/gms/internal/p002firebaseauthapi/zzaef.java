package com.google.android.gms.internal.p002firebaseauthapi;

import Q2.g;
import S1.a;
import Z2.C0752d0;
import Z2.I;
import Z2.O;
import Z2.P;
import Z2.W;
import Z2.Z;
import android.content.Context;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzaef {
    private static final a zza = new a("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzaam zzb;
    private final zzafu zzc;

    public zzaef(g gVar, ScheduledExecutorService scheduledExecutorService) {
        AbstractC1207s.k(gVar);
        Context contextM = gVar.m();
        AbstractC1207s.k(contextM);
        this.zzb = new zzaam(new zzaet(gVar, zzaeu.zza()));
        this.zzc = new zzafu(contextM, scheduledExecutorService);
    }

    public final void zza(String str, String str2, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zza(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zzb(String str, String str2, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.e(str2);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zzb(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zzc(String str, String str2, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.e(str2);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zzc(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zzd(String str, String str2, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zzd(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zze(String str, String str2, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        this.zzb.zze(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zzf(String str, String str2, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.e(str2);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zzf(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zze(String str, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zzf(str, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahu zzahuVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzahuVar);
        AbstractC1207s.e(zzahuVar.zzb());
        AbstractC1207s.k(zzaedVar);
        this.zzb.zza(zzahuVar, new zzaeg(zzaedVar, zza));
    }

    public final void zzd(String str, zzaed zzaedVar) {
        AbstractC1207s.k(zzaedVar);
        this.zzb.zze(str, new zzaeg(zzaedVar, zza));
    }

    public final void zzb(String str, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zzb(str, new zzaeg(zzaedVar, zza));
    }

    public final void zzc(String str, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zzc(str, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.e(str2);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zza(str, str2, str3, str4, new zzaeg(zzaedVar, zza));
    }

    public final void zzb(zzahe zzaheVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzaheVar);
        AbstractC1207s.e(zzaheVar.zzc());
        AbstractC1207s.k(zzaedVar);
        this.zzb.zzb(zzaheVar, new zzaeg(zzaedVar, zza));
    }

    public final void zzc(zzahe zzaheVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzaheVar);
        this.zzb.zzc(zzaheVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zza(str, new zzaeg(zzaedVar, zza));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.e(str2);
        AbstractC1207s.k(zzaedVar);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zzb(str, str2, str3, str4, new zzaeg(zzaedVar, zza));
    }

    public final void zza(I i7, String str, String str2, String str3, zzaed zzaedVar) {
        zzagr zzagrVarZza;
        AbstractC1207s.k(i7);
        AbstractC1207s.f(str, "cachedTokenState should not be empty.");
        AbstractC1207s.k(zzaedVar);
        if (i7 instanceof P) {
            O oA = ((P) i7).a();
            zzagrVarZza = zzagv.zza(str, (String) AbstractC1207s.k(oA.zzc()), (String) AbstractC1207s.k(oA.D()), str2, str3);
        } else if (i7 instanceof W) {
            W w7 = (W) i7;
            zzagrVarZza = zzagx.zza(str, AbstractC1207s.e(str2), AbstractC1207s.e(((Z) AbstractC1207s.k(w7.a())).c()), AbstractC1207s.e(w7.c()), str3);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
        this.zzb.zza(zzagrVarZza, str, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, I i7, String str2, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.k(i7);
        AbstractC1207s.k(zzaedVar);
        if (i7 instanceof P) {
            O oA = ((P) i7).a();
            this.zzb.zza(zzagu.zza(str, (String) AbstractC1207s.k(oA.zzc()), (String) AbstractC1207s.k(oA.D()), str2), new zzaeg(zzaedVar, zza));
        } else {
            if (i7 instanceof W) {
                W w7 = (W) i7;
                this.zzb.zza(zzagw.zza(str, AbstractC1207s.e(w7.c()), str2, AbstractC1207s.e(w7.b())), new zzaeg(zzaedVar, zza));
                return;
            }
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zza(zzahg zzahgVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzahgVar);
        this.zzb.zza(zzahgVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahl zzahlVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzahlVar);
        this.zzb.zza(zzahlVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.e(str2);
        AbstractC1207s.e(str3);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zza(str, str2, str3, str4, str5, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, zzait zzaitVar, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.k(zzaitVar);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zza(str, zzaitVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahr zzahrVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzaedVar);
        AbstractC1207s.k(zzahrVar);
        this.zzb.zza(AbstractC1207s.e(zzahrVar.zzb()), zzahrVar.zza(), new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahw zzahwVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzahwVar);
        this.zzb.zza(zzahwVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahe zzaheVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzaheVar);
        AbstractC1207s.e(zzaheVar.zzd());
        AbstractC1207s.k(zzaedVar);
        this.zzb.zza(zzaheVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzaib zzaibVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzaedVar);
        AbstractC1207s.k(zzaibVar);
        String strZzd = zzaibVar.zzd();
        zzaeg zzaegVar = new zzaeg(zzaedVar, zza);
        if (this.zzc.zzc(strZzd)) {
            if (zzaibVar.zze()) {
                this.zzc.zzb(strZzd);
            } else {
                this.zzc.zzb(zzaegVar, strZzd);
                return;
            }
        }
        long jZzb = zzaibVar.zzb();
        boolean zZzf = zzaibVar.zzf();
        if (zza(jZzb, zZzf)) {
            zzaibVar.zza(new zzage(this.zzc.zzb()));
        }
        this.zzc.zza(strZzd, zzaegVar, jZzb, zZzf);
        this.zzb.zza(zzaibVar, this.zzc.zza(zzaegVar, strZzd));
    }

    public final void zza(zzaif zzaifVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzaifVar);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zzd(zzaifVar.zza(), new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzait zzaitVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzaitVar);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zza(zzaitVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzaiu zzaiuVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzaiuVar);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zza(zzaiuVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzagp zzagpVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzaedVar);
        AbstractC1207s.k(zzagpVar.zzb());
        this.zzb.zza(zzagpVar.zzb(), zzagpVar.zzc(), new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzaai zzaaiVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzaedVar);
        AbstractC1207s.k(zzaaiVar);
        this.zzb.zza(zzafo.zza((O) AbstractC1207s.k(zzaaiVar.zza())), new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, String str2, String str3, long j7, boolean z7, boolean z8, String str4, String str5, String str6, boolean z9, zzaed zzaedVar) {
        AbstractC1207s.f(str, "idToken should not be empty.");
        AbstractC1207s.k(zzaedVar);
        zzaeg zzaegVar = new zzaeg(zzaedVar, zza);
        if (this.zzc.zzc(str2)) {
            if (z7) {
                this.zzc.zzb(str2);
            } else {
                this.zzc.zzb(zzaegVar, str2);
                return;
            }
        }
        zzaik zzaikVarZza = zzaik.zza(str, str2, str3, str4, str5, str6, null);
        if (zza(j7, z9)) {
            zzaikVarZza.zza(new zzage(this.zzc.zzb()));
        }
        this.zzc.zza(str2, zzaegVar, j7, z9);
        this.zzb.zza(zzaikVarZza, this.zzc.zza(zzaegVar, str2));
    }

    public final void zza(zzaah zzaahVar, zzaed zzaedVar) {
        AbstractC1207s.k(zzaahVar);
        AbstractC1207s.k(zzaedVar);
        String strK = zzaahVar.zzb().k();
        zzaeg zzaegVar = new zzaeg(zzaedVar, zza);
        if (this.zzc.zzc(strK)) {
            if (zzaahVar.zzh()) {
                this.zzc.zzb(strK);
            } else {
                this.zzc.zzb(zzaegVar, strK);
                return;
            }
        }
        long jZza = zzaahVar.zza();
        boolean zZzi = zzaahVar.zzi();
        zzaii zzaiiVarZza = zzaii.zza(zzaahVar.zze(), zzaahVar.zzb().a(), zzaahVar.zzb().k(), zzaahVar.zzd(), zzaahVar.zzg(), zzaahVar.zzf(), zzaahVar.zzc());
        if (zza(jZza, zZzi)) {
            zzaiiVarZza.zza(new zzage(this.zzc.zzb()));
        }
        this.zzc.zza(strK, zzaegVar, jZza, zZzi);
        this.zzb.zza(zzaiiVarZza, this.zzc.zza(zzaegVar, strK));
    }

    public final void zza(zzaim zzaimVar, zzaed zzaedVar) {
        this.zzb.zza(zzaimVar, new zzaeg((zzaed) AbstractC1207s.k(zzaedVar), zza));
    }

    public final void zza(String str, String str2, String str3, zzaed zzaedVar) {
        AbstractC1207s.f(str, "cachedTokenState should not be empty.");
        AbstractC1207s.f(str2, "uid should not be empty.");
        AbstractC1207s.k(zzaedVar);
        this.zzb.zza(str, str2, str3, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, C0752d0 c0752d0, zzaed zzaedVar) {
        AbstractC1207s.e(str);
        AbstractC1207s.k(c0752d0);
        AbstractC1207s.k(zzaedVar);
        this.zzb.zza(str, c0752d0, new zzaeg(zzaedVar, zza));
    }

    private static boolean zza(long j7, boolean z7) {
        if (j7 > 0 && z7) {
            return true;
        }
        zza.h("App hash will not be appended to the request.", new Object[0]);
        return false;
    }
}
