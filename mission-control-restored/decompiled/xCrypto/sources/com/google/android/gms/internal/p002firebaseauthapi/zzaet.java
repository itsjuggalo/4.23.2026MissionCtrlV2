package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.FirebaseApp;

/* JADX INFO: loaded from: classes.dex */
public final class zzaet extends zzafl implements zzagf {
    private zzaen zza;
    private zzaeq zzb;
    private zzafq zzc;
    private final zzaeu zzd;
    private final FirebaseApp zze;
    private String zzf;
    private zzaew zzg;

    public zzaet(FirebaseApp firebaseApp, zzaeu zzaeuVar) {
        this(firebaseApp, zzaeuVar, null, null, null);
    }

    private final zzaew zzb() {
        if (this.zzg == null) {
            this.zzg = new zzaew(this.zze, this.zzd.zzb());
        }
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzagk zzagkVar, zzafn<zzagn> zzafnVar) {
        AbstractC0940s.k(zzagkVar);
        AbstractC0940s.k(zzafnVar);
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/createAuthUri", this.zzf), zzagkVar, zzafnVar, zzagn.class, zzaenVar.zza);
    }

    private zzaet(FirebaseApp firebaseApp, zzaeu zzaeuVar, zzafq zzafqVar, zzaen zzaenVar, zzaeq zzaeqVar) {
        this.zze = firebaseApp;
        this.zzf = firebaseApp.getOptions().getApiKey();
        this.zzd = (zzaeu) AbstractC0940s.k(zzaeuVar);
        zza(null, null, null);
        zzagd.zza(this.zzf, this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzagm zzagmVar, zzafn<Void> zzafnVar) {
        AbstractC0940s.k(zzagmVar);
        AbstractC0940s.k(zzafnVar);
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/deleteAccount", this.zzf), zzagmVar, zzafnVar, Void.class, zzaenVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzagp zzagpVar, zzafn<zzago> zzafnVar) {
        AbstractC0940s.k(zzagpVar);
        AbstractC0940s.k(zzafnVar);
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/emailLinkSignin", this.zzf), zzagpVar, zzafnVar, zzago.class, zzaenVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzagr zzagrVar, zzafn<zzagq> zzafnVar) {
        AbstractC0940s.k(zzagrVar);
        AbstractC0940s.k(zzafnVar);
        zzaeq zzaeqVar = this.zzb;
        zzaeq.zza(zzaeqVar.zza("/accounts/mfaEnrollment:finalize", this.zzf), zzagrVar, zzafnVar, zzagq.class, zzaeqVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzagt zzagtVar, zzafn<zzags> zzafnVar) {
        AbstractC0940s.k(zzagtVar);
        AbstractC0940s.k(zzafnVar);
        zzaeq zzaeqVar = this.zzb;
        zzaeq.zza(zzaeqVar.zza("/accounts/mfaSignIn:finalize", this.zzf), zzagtVar, zzafnVar, zzags.class, zzaeqVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzahb zzahbVar, zzafn<zzahn> zzafnVar) {
        AbstractC0940s.k(zzahbVar);
        AbstractC0940s.k(zzafnVar);
        zzafq zzafqVar = this.zzc;
        zzafm.zza(zzafqVar.zza("/token", this.zzf), zzahbVar, zzafnVar, zzahn.class, zzafqVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzaha zzahaVar, zzafn<zzahd> zzafnVar) {
        AbstractC0940s.k(zzahaVar);
        AbstractC0940s.k(zzafnVar);
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/getAccountInfo", this.zzf), zzahaVar, zzafnVar, zzahd.class, zzaenVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzahe zzaheVar, zzafn<zzahh> zzafnVar) {
        AbstractC0940s.k(zzaheVar);
        AbstractC0940s.k(zzafnVar);
        if (zzaheVar.zzb() != null) {
            zzb().zzb(zzaheVar.zzb().zze());
        }
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/getOobConfirmationCode", this.zzf), zzaheVar, zzafnVar, zzahh.class, zzaenVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzahg zzahgVar, zzafn<zzahj> zzafnVar) {
        AbstractC0940s.k(zzahgVar);
        AbstractC0940s.k(zzafnVar);
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/getRecaptchaParam", this.zzf), zzafnVar, zzahj.class, zzaenVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzahl zzahlVar, zzafn<zzahk> zzafnVar) {
        AbstractC0940s.k(zzahlVar);
        AbstractC0940s.k(zzafnVar);
        zzaeq zzaeqVar = this.zzb;
        String str = zzaeqVar.zza("/recaptchaConfig", this.zzf) + "&clientType=" + zzahlVar.zzb() + "&version=" + zzahlVar.zzc();
        if (!zzae.zzc(zzahlVar.zzd())) {
            str = str + "&tenantId=" + zzahlVar.zzd();
        }
        zzafm.zza(str, zzafnVar, zzahk.class, zzaeqVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagf
    public final void zza() {
        zza(null, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzahu zzahuVar, zzafn<zzahx> zzafnVar) {
        AbstractC0940s.k(zzahuVar);
        AbstractC0940s.k(zzafnVar);
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/resetPassword", this.zzf), zzahuVar, zzafnVar, zzahx.class, zzaenVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzahw zzahwVar, zzafn<zzahy> zzafnVar) {
        AbstractC0940s.k(zzahwVar);
        AbstractC0940s.k(zzafnVar);
        zzaeq zzaeqVar = this.zzb;
        zzaeq.zza(zzaeqVar.zza("/accounts:revokeToken", this.zzf), zzahwVar, zzafnVar, zzahy.class, zzaeqVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzaib zzaibVar, zzafn<zzaia> zzafnVar) {
        AbstractC0940s.k(zzaibVar);
        AbstractC0940s.k(zzafnVar);
        if (!TextUtils.isEmpty(zzaibVar.zzc())) {
            zzb().zzb(zzaibVar.zzc());
        }
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/sendVerificationCode", this.zzf), zzaibVar, zzafnVar, zzaia.class, zzaenVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzaid zzaidVar, zzafn<zzaic> zzafnVar) {
        AbstractC0940s.k(zzaidVar);
        AbstractC0940s.k(zzafnVar);
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/setAccountInfo", this.zzf), zzaidVar, zzafnVar, zzaic.class, zzaenVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(String str, zzafn<Void> zzafnVar) {
        AbstractC0940s.k(zzafnVar);
        zzb().zza(str);
        zzafnVar.zza((Void) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzaie zzaieVar, zzafn<zzaih> zzafnVar) {
        AbstractC0940s.k(zzaieVar);
        AbstractC0940s.k(zzafnVar);
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/signupNewUser", this.zzf), zzaieVar, zzafnVar, zzaih.class, zzaenVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzaig zzaigVar, zzafn<zzaij> zzafnVar) {
        AbstractC0940s.k(zzaigVar);
        AbstractC0940s.k(zzafnVar);
        if (zzaigVar instanceof zzaik) {
            zzaik zzaikVar = (zzaik) zzaigVar;
            if (!TextUtils.isEmpty(zzaikVar.zzb())) {
                zzb().zzb(zzaikVar.zzb());
            }
        }
        zzaeq zzaeqVar = this.zzb;
        zzaeq.zza(zzaeqVar.zza("/accounts/mfaEnrollment:start", this.zzf), zzaigVar, zzafnVar, zzaij.class, zzaeqVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzaii zzaiiVar, zzafn<zzail> zzafnVar) {
        AbstractC0940s.k(zzaiiVar);
        AbstractC0940s.k(zzafnVar);
        if (!TextUtils.isEmpty(zzaiiVar.zzb())) {
            zzb().zzb(zzaiiVar.zzb());
        }
        zzaeq zzaeqVar = this.zzb;
        zzaeq.zza(zzaeqVar.zza("/accounts/mfaSignIn:start", this.zzf), zzaiiVar, zzafnVar, zzail.class, zzaeqVar.zza);
    }

    private final void zza(zzafq zzafqVar, zzaen zzaenVar, zzaeq zzaeqVar) {
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        String strZza = zzaga.zza("firebear.secureToken");
        if (TextUtils.isEmpty(strZza)) {
            strZza = zzagd.zzd(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for secureToken URL: " + strZza);
        }
        if (this.zzc == null) {
            this.zzc = new zzafq(strZza, zzb());
        }
        String strZza2 = zzaga.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(strZza2)) {
            strZza2 = zzagd.zzb(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkit URL: " + strZza2);
        }
        if (this.zza == null) {
            this.zza = new zzaen(strZza2, zzb());
        }
        String strZza3 = zzaga.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(strZza3)) {
            strZza3 = zzagd.zzc(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkitV2 URL: " + strZza3);
        }
        if (this.zzb == null) {
            this.zzb = new zzaeq(strZza3, zzb());
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzait zzaitVar, zzafn<zzaiv> zzafnVar) {
        AbstractC0940s.k(zzaitVar);
        AbstractC0940s.k(zzafnVar);
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/verifyAssertion", this.zzf), zzaitVar, zzafnVar, zzaiv.class, zzaenVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzaiu zzaiuVar, zzafn<zzaix> zzafnVar) {
        AbstractC0940s.k(zzaiuVar);
        AbstractC0940s.k(zzafnVar);
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/verifyCustomToken", this.zzf), zzaiuVar, zzafnVar, zzaix.class, zzaenVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzaiw zzaiwVar, zzafn<zzaiz> zzafnVar) {
        AbstractC0940s.k(zzaiwVar);
        AbstractC0940s.k(zzafnVar);
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/verifyPassword", this.zzf), zzaiwVar, zzafnVar, zzaiz.class, zzaenVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzaiy zzaiyVar, zzafn<zzajb> zzafnVar) {
        AbstractC0940s.k(zzaiyVar);
        AbstractC0940s.k(zzafnVar);
        zzaen zzaenVar = this.zza;
        zzafm.zza(zzaenVar.zza("/verifyPhoneNumber", this.zzf), zzaiyVar, zzafnVar, zzajb.class, zzaenVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafl
    public final void zza(zzaja zzajaVar, zzafn<zzajd> zzafnVar) {
        AbstractC0940s.k(zzajaVar);
        AbstractC0940s.k(zzafnVar);
        zzaeq zzaeqVar = this.zzb;
        zzaeq.zza(zzaeqVar.zza("/accounts/mfaEnrollment:withdraw", this.zzf), zzajaVar, zzafnVar, zzajd.class, zzaeqVar.zza);
    }
}
