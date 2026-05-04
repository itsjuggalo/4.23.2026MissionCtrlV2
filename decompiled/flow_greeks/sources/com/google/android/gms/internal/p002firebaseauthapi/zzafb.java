package com.google.android.gms.internal.p002firebaseauthapi;

import a7.g;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzafb extends zzaft implements zzagn {
    private zzaev zza;
    private zzaey zzb;
    private zzafy zzc;
    private final zzafc zzd;
    private final g zze;
    private String zzf;
    private zzafe zzg;

    public zzafb(g gVar, zzafc zzafcVar) {
        this(gVar, zzafcVar, null, null, null, null);
    }

    private final zzafe zzb() {
        if (this.zzg == null) {
            this.zzg = new zzafe(this.zze, this.zzd.zzb());
        }
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzags zzagsVar, zzafv<zzagv> zzafvVar) {
        s.k(zzagsVar);
        s.k(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/createAuthUri", this.zzf), zzagsVar, zzafvVar, zzagv.class, zzaevVar.zza);
    }

    private zzafb(g gVar, zzafc zzafcVar, zzafy zzafyVar, zzaev zzaevVar, zzaey zzaeyVar, zzaew zzaewVar) {
        this.zze = gVar;
        this.zzf = gVar.r().b();
        gVar.r().g();
        this.zzd = (zzafc) s.k(zzafcVar);
        zza(null, null, null, null);
        zzagl.zza(this.zzf, this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzagu zzaguVar, zzafv<Void> zzafvVar) {
        s.k(zzaguVar);
        s.k(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/deleteAccount", this.zzf), zzaguVar, zzafvVar, Void.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzagx zzagxVar, zzafv<zzagw> zzafvVar) {
        s.k(zzagxVar);
        s.k(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/emailLinkSignin", this.zzf), zzagxVar, zzafvVar, zzagw.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzagz zzagzVar, zzafv<zzagy> zzafvVar) {
        s.k(zzagzVar);
        s.k(zzafvVar);
        zzaey zzaeyVar = this.zzb;
        zzaey.zza(zzaeyVar.zza("/accounts/mfaEnrollment:finalize", this.zzf), zzagzVar, zzafvVar, zzagy.class, zzaeyVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzahb zzahbVar, zzafv<zzaha> zzafvVar) {
        s.k(zzahbVar);
        s.k(zzafvVar);
        zzaey zzaeyVar = this.zzb;
        zzaey.zza(zzaeyVar.zza("/accounts/mfaSignIn:finalize", this.zzf), zzahbVar, zzafvVar, zzaha.class, zzaeyVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzahj zzahjVar, zzafv<zzahv> zzafvVar) {
        s.k(zzahjVar);
        s.k(zzafvVar);
        zzafy zzafyVar = this.zzc;
        zzafu.zza(zzafyVar.zza("/token", this.zzf), zzahjVar, zzafvVar, zzahv.class, zzafyVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzahi zzahiVar, zzafv<zzahl> zzafvVar) {
        s.k(zzahiVar);
        s.k(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/getAccountInfo", this.zzf), zzahiVar, zzafvVar, zzahl.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzahm zzahmVar, zzafv<zzahp> zzafvVar) {
        s.k(zzahmVar);
        s.k(zzafvVar);
        if (zzahmVar.zzb() != null) {
            zzb().zzb(zzahmVar.zzb().zze());
        }
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/getOobConfirmationCode", this.zzf), zzahmVar, zzafvVar, zzahp.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaho zzahoVar, zzafv<zzahr> zzafvVar) {
        s.k(zzahoVar);
        s.k(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/getRecaptchaParam", this.zzf), zzafvVar, zzahr.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaht zzahtVar, zzafv<zzahs> zzafvVar) {
        s.k(zzahtVar);
        s.k(zzafvVar);
        zzaey zzaeyVar = this.zzb;
        String str = zzaeyVar.zza("/recaptchaConfig", this.zzf) + "&clientType=" + zzahtVar.zzb() + "&version=" + zzahtVar.zzc();
        if (!zzac.zzc(zzahtVar.zzd())) {
            str = str + "&tenantId=" + zzahtVar.zzd();
        }
        zzafu.zza(str, zzafvVar, zzahs.class, zzaeyVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzagn
    public final void zza() {
        zza(null, null, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaic zzaicVar, zzafv<zzaif> zzafvVar) {
        s.k(zzaicVar);
        s.k(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/resetPassword", this.zzf), zzaicVar, zzafvVar, zzaif.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaie zzaieVar, zzafv<zzaig> zzafvVar) {
        s.k(zzaieVar);
        s.k(zzafvVar);
        zzaey zzaeyVar = this.zzb;
        zzaey.zza(zzaeyVar.zza("/accounts:revokeToken", this.zzf), zzaieVar, zzafvVar, zzaig.class, zzaeyVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaij zzaijVar, zzafv<zzaii> zzafvVar) {
        s.k(zzaijVar);
        s.k(zzafvVar);
        if (!TextUtils.isEmpty(zzaijVar.zzc())) {
            zzb().zzb(zzaijVar.zzc());
        }
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/sendVerificationCode", this.zzf), zzaijVar, zzafvVar, zzaii.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzail zzailVar, zzafv<zzaik> zzafvVar) {
        s.k(zzailVar);
        s.k(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/setAccountInfo", this.zzf), zzailVar, zzafvVar, zzaik.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(String str, zzafv<Void> zzafvVar) {
        s.k(zzafvVar);
        zzb().zza(str);
        zzafvVar.zza((Void) null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaim zzaimVar, zzafv<zzaip> zzafvVar) {
        s.k(zzaimVar);
        s.k(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/signupNewUser", this.zzf), zzaimVar, zzafvVar, zzaip.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaio zzaioVar, zzafv<zzair> zzafvVar) {
        s.k(zzaioVar);
        s.k(zzafvVar);
        if (zzaioVar instanceof zzais) {
            zzais zzaisVar = (zzais) zzaioVar;
            if (!TextUtils.isEmpty(zzaisVar.zzb())) {
                zzb().zzb(zzaisVar.zzb());
            }
        }
        zzaey zzaeyVar = this.zzb;
        zzaey.zza(zzaeyVar.zza("/accounts/mfaEnrollment:start", this.zzf), zzaioVar, zzafvVar, zzair.class, zzaeyVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaiq zzaiqVar, zzafv<zzait> zzafvVar) {
        s.k(zzaiqVar);
        s.k(zzafvVar);
        if (!TextUtils.isEmpty(zzaiqVar.zzb())) {
            zzb().zzb(zzaiqVar.zzb());
        }
        zzaey zzaeyVar = this.zzb;
        zzaey.zza(zzaeyVar.zza("/accounts/mfaSignIn:start", this.zzf), zzaiqVar, zzafvVar, zzait.class, zzaeyVar.zza);
    }

    private final void zza(zzafy zzafyVar, zzaev zzaevVar, zzaey zzaeyVar, zzaew zzaewVar) {
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        String strZza = zzagi.zza("firebear.secureToken");
        if (TextUtils.isEmpty(strZza)) {
            strZza = zzagl.zzd(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for secureToken URL: " + strZza);
        }
        if (this.zzc == null) {
            this.zzc = new zzafy(strZza, zzb());
        }
        String strZza2 = zzagi.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(strZza2)) {
            strZza2 = zzagl.zzb(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkit URL: " + strZza2);
        }
        if (this.zza == null) {
            this.zza = new zzaev(strZza2, zzb());
        }
        String strZza3 = zzagi.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(strZza3)) {
            strZza3 = zzagl.zzc(this.zzf);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkitV2 URL: " + strZza3);
        }
        if (this.zzb == null) {
            this.zzb = new zzaey(strZza3, zzb());
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzajb zzajbVar, zzafv<zzajd> zzafvVar) {
        s.k(zzajbVar);
        s.k(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/verifyAssertion", this.zzf), zzajbVar, zzafvVar, zzajd.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzajc zzajcVar, zzafv<zzajf> zzafvVar) {
        s.k(zzajcVar);
        s.k(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/verifyCustomToken", this.zzf), zzajcVar, zzafvVar, zzajf.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaje zzajeVar, zzafv<zzajh> zzafvVar) {
        s.k(zzajeVar);
        s.k(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/verifyPassword", this.zzf), zzajeVar, zzafvVar, zzajh.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzajg zzajgVar, zzafv<zzajj> zzafvVar) {
        s.k(zzajgVar);
        s.k(zzafvVar);
        zzaev zzaevVar = this.zza;
        zzafu.zza(zzaevVar.zza("/verifyPhoneNumber", this.zzf), zzajgVar, zzafvVar, zzajj.class, zzaevVar.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaft
    public final void zza(zzaji zzajiVar, zzafv<zzajl> zzafvVar) {
        s.k(zzajiVar);
        s.k(zzafvVar);
        zzaey zzaeyVar = this.zzb;
        zzaey.zza(zzaeyVar.zza("/accounts/mfaEnrollment:withdraw", this.zzf), zzajiVar, zzafvVar, zzajl.class, zzaeyVar.zza);
    }
}
