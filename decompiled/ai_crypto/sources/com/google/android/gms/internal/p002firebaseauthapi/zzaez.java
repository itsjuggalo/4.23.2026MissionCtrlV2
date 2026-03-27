package com.google.android.gms.internal.p002firebaseauthapi;

import Z2.AbstractC0759h;
import Z2.O;
import a3.AbstractC0873r;
import a3.InterfaceC0885x;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1207s;

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
        int i7 = this.zza.zza;
        AbstractC1207s.o(i7 == 8, "Unexpected response type " + i7);
        zza(new zzafb(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zzc(String str) {
        int i7 = this.zza.zza;
        AbstractC1207s.o(i7 == 7, "Unexpected response type " + i7);
        zzaex.zza(this.zza);
    }

    private final void zza(Status status, AbstractC0759h abstractC0759h, String str, String str2) {
        zzaex.zza(this.zza, status);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzn = abstractC0759h;
        zzaexVar.zzo = str;
        zzaexVar.zzp = str2;
        InterfaceC0885x interfaceC0885x = zzaexVar.zzf;
        if (interfaceC0885x != null) {
            interfaceC0885x.zza(status);
        }
        this.zza.zza(status);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zzb() {
        int i7 = this.zza.zza;
        AbstractC1207s.o(i7 == 6, "Unexpected response type " + i7);
        zzaex.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zzc() {
        int i7 = this.zza.zza;
        AbstractC1207s.o(i7 == 9, "Unexpected response type " + i7);
        zzaex.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(String str) {
        int i7 = this.zza.zza;
        AbstractC1207s.o(i7 == 8, "Unexpected response type " + i7);
        this.zza.zzu = true;
        zza(new zzafd(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzagn zzagnVar) {
        int i7 = this.zza.zza;
        AbstractC1207s.o(i7 == 3, "Unexpected response type " + i7);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzl = zzagnVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza() {
        int i7 = this.zza.zza;
        AbstractC1207s.o(i7 == 5, "Unexpected response type " + i7);
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
        zzaexVar.zza(AbstractC0873r.a("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(Status status, O o7) {
        int i7 = this.zza.zza;
        AbstractC1207s.o(i7 == 2, "Unexpected response type " + i7);
        zza(status, o7, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(Status status) {
        String strC = status.C();
        if (strC != null) {
            if (strC.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (strC.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (strC.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (strC.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (strC.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (strC.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (strC.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (strC.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (strC.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (strC.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
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
        int i7 = this.zza.zza;
        AbstractC1207s.o(i7 == 2, "Unexpected response type: " + i7);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzj = zzahnVar;
        zzaexVar.zzk = zzahcVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(zzahx zzahxVar) {
        int i7 = this.zza.zza;
        AbstractC1207s.o(i7 == 4, "Unexpected response type " + i7);
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
        int i7 = this.zza.zza;
        AbstractC1207s.o(i7 == 1, "Unexpected response type: " + i7);
        zzaex zzaexVar = this.zza;
        zzaexVar.zzj = zzahnVar;
        zzaex.zza(zzaexVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaed
    public final void zza(O o7) {
        int i7 = this.zza.zza;
        AbstractC1207s.o(i7 == 8, "Unexpected response type " + i7);
        this.zza.zzu = true;
        zza(new zzafa(this, o7));
    }
}
