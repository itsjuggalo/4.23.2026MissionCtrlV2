package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.internal.zzau;

/* JADX INFO: loaded from: classes.dex */
final class zzaez implements zzaed {
    final /* synthetic */ zzaex zza;

    public zzaez(zzaex zzaexVar) {
        this.zza = zzaexVar;
    }

    private final void zza(zzafe zzafeVar) {
        this.zza.zzi.execute(new zzaff(this, zzafeVar));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zzb(String str) {
        int i4 = this.zza.zza;
        AbstractC0940s.o(i4 == 8, "Unexpected response type " + i4);
        zza(new zzafb(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zzc(String str) {
        int i4 = this.zza.zza;
        AbstractC0940s.o(i4 == 7, "Unexpected response type " + i4);
        zzaex.zza(this.zza);
    }

    private final void zza(Status status, AuthCredential authCredential, String str, String str2) {
        zzaex.zza(this.zza, status);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzn = authCredential;
        zzaexVar.zzo = str;
        zzaexVar.zzp = str2;
        zzau zzauVar = zzaexVar.zzf;
        if (zzauVar != null) {
            zzauVar.zza(status);
        }
        this.zza.zza(status);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zzb() {
        int i4 = this.zza.zza;
        AbstractC0940s.o(i4 == 6, "Unexpected response type " + i4);
        zzaex.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zzc() {
        int i4 = this.zza.zza;
        AbstractC0940s.o(i4 == 9, "Unexpected response type " + i4);
        zzaex.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(String str) {
        int i4 = this.zza.zza;
        AbstractC0940s.o(i4 == 8, "Unexpected response type " + i4);
        this.zza.zzu = true;
        zza(new zzafd(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzagn zzagnVar) {
        int i4 = this.zza.zza;
        AbstractC0940s.o(i4 == 3, "Unexpected response type " + i4);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzl = zzagnVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza() {
        int i4 = this.zza.zza;
        AbstractC0940s.o(i4 == 5, "Unexpected response type " + i4);
        zzaex.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzaak zzaakVar) {
        zza(zzaakVar.zza(), zzaakVar.zzb(), zzaakVar.zzc(), zzaakVar.zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzaaj zzaajVar) {
        zzaex zzaexVar = this.zza;
        zzaexVar.zzq = zzaajVar;
        zzaexVar.zza(zzao.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) {
        int i4 = this.zza.zza;
        AbstractC0940s.o(i4 == 2, "Unexpected response type " + i4);
        zza(status, phoneAuthCredential, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(Status status) {
        String strL = status.l();
        if (strL != null) {
            if (strL.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (strL.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (strL.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (strL.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (strL.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (strL.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (strL.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (strL.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (strL.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (strL.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzaex zzaexVar = this.zza;
        if (zzaexVar.zza == 8) {
            zzaexVar.zzu = true;
            zza(new zzafc(this, status));
        } else {
            zzaex.zza(zzaexVar, status);
            this.zza.zza(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzahj zzahjVar) {
        zzaex zzaexVar = this.zza;
        zzaexVar.zzs = zzahjVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzahk zzahkVar) {
        zzaex zzaexVar = this.zza;
        zzaexVar.zzr = zzahkVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzahn zzahnVar, zzahc zzahcVar) {
        int i4 = this.zza.zza;
        AbstractC0940s.o(i4 == 2, "Unexpected response type: " + i4);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzj = zzahnVar;
        zzaexVar.zzk = zzahcVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzahx zzahxVar) {
        int i4 = this.zza.zza;
        AbstractC0940s.o(i4 == 4, "Unexpected response type " + i4);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzm = zzahxVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzahy zzahyVar) {
        zzaex.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzaij zzaijVar) {
        zzaex zzaexVar = this.zza;
        zzaexVar.zzt = zzaijVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzahn zzahnVar) {
        int i4 = this.zza.zza;
        AbstractC0940s.o(i4 == 1, "Unexpected response type: " + i4);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzj = zzahnVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(PhoneAuthCredential phoneAuthCredential) {
        int i4 = this.zza.zza;
        AbstractC0940s.o(i4 == 8, "Unexpected response type " + i4);
        this.zza.zzu = true;
        zza(new zzafa(this, phoneAuthCredential));
    }
}
