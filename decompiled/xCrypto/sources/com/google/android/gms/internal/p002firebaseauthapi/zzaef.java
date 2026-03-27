package com.google.android.gms.internal.p002firebaseauthapi;

import C1.a;
import android.content.Context;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.TotpSecret;
import com.google.firebase.auth.UserProfileChangeRequest;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzaef {
    private static final a zza = new a("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzaam zzb;
    private final zzafu zzc;

    public zzaef(FirebaseApp firebaseApp, ScheduledExecutorService scheduledExecutorService) {
        AbstractC0940s.k(firebaseApp);
        Context applicationContext = firebaseApp.getApplicationContext();
        AbstractC0940s.k(applicationContext);
        this.zzb = new zzaam(new zzaet(firebaseApp, zzaeu.zza()));
        this.zzc = new zzafu(applicationContext, scheduledExecutorService);
    }

    public final void zza(String str, String str2, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zza(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zzb(String str, String str2, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zzb(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zzc(String str, String str2, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zzc(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zzd(String str, String str2, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zzd(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zze(String str, String str2, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        this.zzb.zze(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zzf(String str, String str2, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zzf(str, str2, new zzaeg(zzaedVar, zza));
    }

    public final void zze(String str, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zzf(str, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahu zzahuVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzahuVar);
        AbstractC0940s.e(zzahuVar.zzb());
        AbstractC0940s.k(zzaedVar);
        this.zzb.zza(zzahuVar, new zzaeg(zzaedVar, zza));
    }

    public final void zzd(String str, zzaed zzaedVar) {
        AbstractC0940s.k(zzaedVar);
        this.zzb.zze(str, new zzaeg(zzaedVar, zza));
    }

    public final void zzb(String str, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zzb(str, new zzaeg(zzaedVar, zza));
    }

    public final void zzc(String str, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zzc(str, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zza(str, str2, str3, str4, new zzaeg(zzaedVar, zza));
    }

    public final void zzb(zzahe zzaheVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzaheVar);
        AbstractC0940s.e(zzaheVar.zzc());
        AbstractC0940s.k(zzaedVar);
        this.zzb.zzb(zzaheVar, new zzaeg(zzaedVar, zza));
    }

    public final void zzc(zzahe zzaheVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzaheVar);
        this.zzb.zzc(zzaheVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zza(str, new zzaeg(zzaedVar, zza));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(zzaedVar);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zzb(str, str2, str3, str4, new zzaeg(zzaedVar, zza));
    }

    public final void zza(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3, zzaed zzaedVar) {
        zzagr zzagrVarZza;
        AbstractC0940s.k(multiFactorAssertion);
        AbstractC0940s.f(str, "cachedTokenState should not be empty.");
        AbstractC0940s.k(zzaedVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential phoneAuthCredentialZza = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            zzagrVarZza = zzagv.zza(str, (String) AbstractC0940s.k(phoneAuthCredentialZza.zzc()), (String) AbstractC0940s.k(phoneAuthCredentialZza.getSmsCode()), str2, str3);
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            zzagrVarZza = zzagx.zza(str, AbstractC0940s.e(str2), AbstractC0940s.e(((TotpSecret) AbstractC0940s.k(totpMultiFactorAssertion.zza())).getSessionInfo()), AbstractC0940s.e(totpMultiFactorAssertion.zzc()), str3);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
        this.zzb.zza(zzagrVarZza, str, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, MultiFactorAssertion multiFactorAssertion, String str2, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(multiFactorAssertion);
        AbstractC0940s.k(zzaedVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential phoneAuthCredentialZza = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            this.zzb.zza(zzagu.zza(str, (String) AbstractC0940s.k(phoneAuthCredentialZza.zzc()), (String) AbstractC0940s.k(phoneAuthCredentialZza.getSmsCode()), str2), new zzaeg(zzaedVar, zza));
        } else {
            if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
                TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
                this.zzb.zza(zzagw.zza(str, AbstractC0940s.e(totpMultiFactorAssertion.zzc()), str2, AbstractC0940s.e(totpMultiFactorAssertion.zzb())), new zzaeg(zzaedVar, zza));
                return;
            }
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zza(zzahg zzahgVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzahgVar);
        this.zzb.zza(zzahgVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahl zzahlVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzahlVar);
        this.zzb.zza(zzahlVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.e(str3);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zza(str, str2, str3, str4, str5, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, zzait zzaitVar, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaitVar);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zza(str, zzaitVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahr zzahrVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzaedVar);
        AbstractC0940s.k(zzahrVar);
        this.zzb.zza(AbstractC0940s.e(zzahrVar.zzb()), zzahrVar.zza(), new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahw zzahwVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzahwVar);
        this.zzb.zza(zzahwVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzahe zzaheVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzaheVar);
        AbstractC0940s.e(zzaheVar.zzd());
        AbstractC0940s.k(zzaedVar);
        this.zzb.zza(zzaheVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzaib zzaibVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzaedVar);
        AbstractC0940s.k(zzaibVar);
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
        AbstractC0940s.k(zzaifVar);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zzd(zzaifVar.zza(), new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzait zzaitVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzaitVar);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zza(zzaitVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzaiu zzaiuVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzaiuVar);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zza(zzaiuVar, new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzagp zzagpVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzaedVar);
        AbstractC0940s.k(zzagpVar.zzb());
        this.zzb.zza(zzagpVar.zzb(), zzagpVar.zzc(), new zzaeg(zzaedVar, zza));
    }

    public final void zza(zzaai zzaaiVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzaedVar);
        AbstractC0940s.k(zzaaiVar);
        this.zzb.zza(zzafo.zza((PhoneAuthCredential) AbstractC0940s.k(zzaaiVar.zza())), new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, String str2, String str3, long j4, boolean z4, boolean z5, String str4, String str5, String str6, boolean z6, zzaed zzaedVar) {
        AbstractC0940s.f(str, "idToken should not be empty.");
        AbstractC0940s.k(zzaedVar);
        zzaeg zzaegVar = new zzaeg(zzaedVar, zza);
        if (this.zzc.zzc(str2)) {
            if (z4) {
                this.zzc.zzb(str2);
            } else {
                this.zzc.zzb(zzaegVar, str2);
                return;
            }
        }
        zzaik zzaikVarZza = zzaik.zza(str, str2, str3, str4, str5, str6, null);
        if (zza(j4, z6)) {
            zzaikVarZza.zza(new zzage(this.zzc.zzb()));
        }
        this.zzc.zza(str2, zzaegVar, j4, z6);
        this.zzb.zza(zzaikVarZza, this.zzc.zza(zzaegVar, str2));
    }

    public final void zza(zzaah zzaahVar, zzaed zzaedVar) {
        AbstractC0940s.k(zzaahVar);
        AbstractC0940s.k(zzaedVar);
        String phoneNumber = zzaahVar.zzb().getPhoneNumber();
        zzaeg zzaegVar = new zzaeg(zzaedVar, zza);
        if (this.zzc.zzc(phoneNumber)) {
            if (zzaahVar.zzh()) {
                this.zzc.zzb(phoneNumber);
            } else {
                this.zzc.zzb(zzaegVar, phoneNumber);
                return;
            }
        }
        long jZza = zzaahVar.zza();
        boolean zZzi = zzaahVar.zzi();
        zzaii zzaiiVarZza = zzaii.zza(zzaahVar.zze(), zzaahVar.zzb().getUid(), zzaahVar.zzb().getPhoneNumber(), zzaahVar.zzd(), zzaahVar.zzg(), zzaahVar.zzf(), zzaahVar.zzc());
        if (zza(jZza, zZzi)) {
            zzaiiVarZza.zza(new zzage(this.zzc.zzb()));
        }
        this.zzc.zza(phoneNumber, zzaegVar, jZza, zZzi);
        this.zzb.zza(zzaiiVarZza, this.zzc.zza(zzaegVar, phoneNumber));
    }

    public final void zza(zzaim zzaimVar, zzaed zzaedVar) {
        this.zzb.zza(zzaimVar, new zzaeg((zzaed) AbstractC0940s.k(zzaedVar), zza));
    }

    public final void zza(String str, String str2, String str3, zzaed zzaedVar) {
        AbstractC0940s.f(str, "cachedTokenState should not be empty.");
        AbstractC0940s.f(str2, "uid should not be empty.");
        AbstractC0940s.k(zzaedVar);
        this.zzb.zza(str, str2, str3, new zzaeg(zzaedVar, zza));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzaed zzaedVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(userProfileChangeRequest);
        AbstractC0940s.k(zzaedVar);
        this.zzb.zza(str, userProfileChangeRequest, new zzaeg(zzaedVar, zza));
    }

    private static boolean zza(long j4, boolean z4) {
        if (j4 > 0 && z4) {
            return true;
        }
        zza.h("App hash will not be appended to the request.", new Object[0]);
        return false;
    }
}
