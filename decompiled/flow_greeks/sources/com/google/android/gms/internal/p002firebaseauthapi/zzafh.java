package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.s;
import java.util.Objects;
import m7.h;
import m7.o0;
import n7.r;
import n7.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzafh implements zzaem {
    final /* synthetic */ zzaff zza;

    public zzafh(zzaff zzaffVar) {
        Objects.requireNonNull(zzaffVar);
        this.zza = zzaffVar;
    }

    private final void zza(zzafm zzafmVar) {
        this.zza.zzi.execute(new zzafn(this, zzafmVar));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zzb(String str) {
        int i10 = this.zza.zza;
        s.o(i10 == 8, "Unexpected response type " + i10);
        zza(new zzafj(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zzc(String str) {
        int i10 = this.zza.zza;
        s.o(i10 == 7, "Unexpected response type " + i10);
        zzaff.zza(this.zza);
    }

    private final void zza(Status status, h hVar, String str, String str2) {
        zzaff.zza(this.zza, status);
        zzaff zzaffVar = this.zza;
        zzaffVar.zzn = hVar;
        zzaffVar.zzo = str;
        zzaffVar.zzp = str2;
        x xVar = zzaffVar.zzf;
        if (xVar != null) {
            xVar.zza(status);
        }
        this.zza.zza(status);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zzb() {
        int i10 = this.zza.zza;
        s.o(i10 == 6, "Unexpected response type " + i10);
        zzaff.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zzc() {
        int i10 = this.zza.zza;
        s.o(i10 == 9, "Unexpected response type " + i10);
        zzaff.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(String str) {
        int i10 = this.zza.zza;
        s.o(i10 == 8, "Unexpected response type " + i10);
        this.zza.zzu = true;
        zza(new zzafl(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzagv zzagvVar) {
        int i10 = this.zza.zza;
        s.o(i10 == 3, "Unexpected response type " + i10);
        zzaff zzaffVar = this.zza;
        zzaffVar.zzl = zzagvVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza() {
        int i10 = this.zza.zza;
        s.o(i10 == 5, "Unexpected response type " + i10);
        zzaff.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzaap zzaapVar) {
        zza(zzaapVar.zza(), zzaapVar.zzb(), zzaapVar.zzc(), zzaapVar.zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzaas zzaasVar) {
        zzaff zzaffVar = this.zza;
        zzaffVar.zzq = zzaasVar;
        zzaffVar.zza(r.a("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(Status status, o0 o0Var) {
        int i10 = this.zza.zza;
        s.o(i10 == 2, "Unexpected response type " + i10);
        zza(status, o0Var, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(Status status) {
        String strT = status.T();
        if (strT != null) {
            if (strT.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (strT.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (strT.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (strT.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (strT.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (strT.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (strT.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (strT.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (strT.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (strT.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzaff zzaffVar = this.zza;
        if (zzaffVar.zza == 8) {
            zzaffVar.zzu = true;
            zza(new zzafk(this, status));
        } else {
            zzaff.zza(zzaffVar, status);
            this.zza.zza(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzahr zzahrVar) {
        zzaff zzaffVar = this.zza;
        zzaffVar.zzs = zzahrVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzahs zzahsVar) {
        zzaff zzaffVar = this.zza;
        zzaffVar.zzr = zzahsVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzahv zzahvVar, zzahk zzahkVar) {
        int i10 = this.zza.zza;
        s.o(i10 == 2, "Unexpected response type: " + i10);
        zzaff zzaffVar = this.zza;
        zzaffVar.zzj = zzahvVar;
        zzaffVar.zzk = zzahkVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzaif zzaifVar) {
        int i10 = this.zza.zza;
        s.o(i10 == 4, "Unexpected response type " + i10);
        zzaff zzaffVar = this.zza;
        zzaffVar.zzm = zzaifVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzaig zzaigVar) {
        zzaff.zza(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzair zzairVar) {
        zzaff zzaffVar = this.zza;
        zzaffVar.zzt = zzairVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(zzahv zzahvVar) {
        int i10 = this.zza.zza;
        s.o(i10 == 1, "Unexpected response type: " + i10);
        zzaff zzaffVar = this.zza;
        zzaffVar.zzj = zzahvVar;
        zzaff.zza(zzaffVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaem
    public final void zza(o0 o0Var) {
        int i10 = this.zza.zza;
        s.o(i10 == 8, "Unexpected response type " + i10);
        this.zza.zzu = true;
        zza(new zzafi(this, o0Var));
    }
}
