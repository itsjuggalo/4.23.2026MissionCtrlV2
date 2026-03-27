package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class zzaam {
    private final zzafl zza;

    public zzaam(zzafl zzaflVar) {
        this.zza = (zzafl) AbstractC0940s.k(zzaflVar);
    }

    public final void zzb(String str, String str2, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(zzaegVar);
        zza(str, new zzace(this, str2, zzaegVar));
    }

    public final void zzc(String str, String str2, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(zzaegVar);
        zza(str, new zzacd(this, str2, zzaegVar));
    }

    public final void zzd(String str, String str2, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(new zzahu(str, null, str2), new zzaav(this, zzaegVar));
    }

    public final void zze(String str, String str2, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(new zzagk(str, str2), new zzaat(this, zzaegVar));
    }

    public final void zzf(String str, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaegVar);
        zza(str, new zzabi(this, zzaegVar));
    }

    public static /* synthetic */ void zza(zzaam zzaamVar, zzaiv zzaivVar, zzaeg zzaegVar, zzafk zzafkVar) {
        Status statusZza;
        if (zzaivVar.zzo()) {
            zzc zzcVarZzb = zzaivVar.zzb();
            String strZzc = zzaivVar.zzc();
            String strZzj = zzaivVar.zzj();
            if (zzaivVar.zzm()) {
                statusZza = new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL);
            } else {
                statusZza = zzao.zza(zzaivVar.zzd());
            }
            zzaegVar.zza(new zzaak(statusZza, zzcVarZzb, strZzc, strZzj));
            return;
        }
        zzaamVar.zza(new zzahn(zzaivVar.zzi(), zzaivVar.zze(), Long.valueOf(zzaivVar.zza()), "Bearer"), zzaivVar.zzh(), zzaivVar.zzg(), Boolean.valueOf(zzaivVar.zzn()), zzaivVar.zzb(), zzaegVar, zzafkVar);
    }

    public final void zzf(String str, String str2, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(zzaegVar);
        zza(str2, new zzabh(this, str, zzaegVar));
    }

    private final void zzd(zzahe zzaheVar, zzaeg zzaegVar) {
        AbstractC0940s.k(zzaheVar);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(zzaheVar, new zzaca(this, zzaegVar));
    }

    public final void zzb(String str, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(new zzahb(str), new zzaal(this, zzaegVar));
    }

    public final void zzc(String str, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaegVar);
        zza(str, new zzabt(this, zzaegVar));
    }

    public final void zze(String str, zzaeg zzaegVar) {
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(new zzaie(str), new zzabz(this, zzaegVar));
    }

    public final void zzc(zzahe zzaheVar, zzaeg zzaegVar) {
        zzd(zzaheVar, zzaegVar);
    }

    public final void zzd(String str, zzaeg zzaegVar) {
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(str, new zzabx(this, zzaegVar));
    }

    public final void zzb(zzahe zzaheVar, zzaeg zzaegVar) {
        AbstractC0940s.e(zzaheVar.zzc());
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(zzaheVar, new zzaaw(this, zzaegVar));
    }

    public final void zzb(String str, String str2, String str3, String str4, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(new zzaiw(str, str2, str3, str4), new zzaan(this, zzaegVar));
    }

    public static /* synthetic */ void zza(zzaam zzaamVar, zzaeg zzaegVar, zzaie zzaieVar, zzafk zzafkVar) {
        AbstractC0940s.k(zzaegVar);
        AbstractC0940s.k(zzaieVar);
        AbstractC0940s.k(zzafkVar);
        zzaamVar.zza.zza(zzaieVar, new zzabb(zzaamVar, zzaegVar, zzafkVar));
    }

    public static /* synthetic */ void zza(zzaam zzaamVar, zzaeg zzaegVar, zzahn zzahnVar, zzaid zzaidVar, zzafk zzafkVar) {
        AbstractC0940s.k(zzaegVar);
        AbstractC0940s.k(zzahnVar);
        AbstractC0940s.k(zzaidVar);
        AbstractC0940s.k(zzafkVar);
        zzaamVar.zza.zza(new zzaha(zzahnVar.zzc()), new zzaas(zzaamVar, zzafkVar, zzaegVar, zzahnVar, zzaidVar));
    }

    public static /* synthetic */ void zza(zzaam zzaamVar, zzaeg zzaegVar, zzahn zzahnVar, zzahc zzahcVar, zzaid zzaidVar, zzafk zzafkVar) {
        AbstractC0940s.k(zzaegVar);
        AbstractC0940s.k(zzahnVar);
        AbstractC0940s.k(zzahcVar);
        AbstractC0940s.k(zzaidVar);
        AbstractC0940s.k(zzafkVar);
        zzaamVar.zza.zza(zzaidVar, new zzaar(zzaamVar, zzaidVar, zzahcVar, zzaegVar, zzahnVar, zzafkVar));
    }

    public final void zza(String str, String str2, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaegVar);
        zzaid zzaidVar = new zzaid();
        zzaidVar.zze(str);
        zzaidVar.zzh(str2);
        this.zza.zza(zzaidVar, new zzacg(this, zzaegVar));
    }

    public final void zza(zzahu zzahuVar, zzaeg zzaegVar) {
        AbstractC0940s.e(zzahuVar.zzb());
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(zzahuVar, new zzaax(this, zzaegVar));
    }

    public final void zza(String str, String str2, String str3, String str4, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(new zzaie(str, str2, null, str3, str4, null), new zzaao(this, zzaegVar));
    }

    public final void zza(String str, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaegVar);
        zza(str, new zzabv(this, zzaegVar));
    }

    private final void zza(String str, zzafn<zzahn> zzafnVar) {
        AbstractC0940s.k(zzafnVar);
        AbstractC0940s.e(str);
        zzahn zzahnVarZzb = zzahn.zzb(str);
        if (zzahnVarZzb.zzg()) {
            zzafnVar.zza(zzahnVarZzb);
        } else {
            this.zza.zza(new zzahb(zzahnVarZzb.zzd()), new zzacf(this, zzafnVar));
        }
    }

    public final void zza(zzagr zzagrVar, String str, zzaeg zzaegVar) {
        AbstractC0940s.k(zzagrVar);
        AbstractC0940s.k(zzaegVar);
        zza(str, new zzabn(this, zzagrVar, zzaegVar));
    }

    public final void zza(zzagt zzagtVar, zzaeg zzaegVar) {
        AbstractC0940s.k(zzagtVar);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(zzagtVar, new zzabp(this, zzaegVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzagp zzagpVar, zzaeg zzaegVar) {
        AbstractC0940s.k(zzagpVar);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(zzagpVar, new zzaap(this, zzaegVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzahn zzahnVar, String str, String str2, Boolean bool, zzc zzcVar, zzaeg zzaegVar, zzafk zzafkVar) {
        AbstractC0940s.k(zzahnVar);
        AbstractC0940s.k(zzafkVar);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(new zzaha(zzahnVar.zzc()), new zzaau(this, zzafkVar, str2, str, bool, zzcVar, zzaegVar, zzahnVar));
    }

    public final void zza(zzahg zzahgVar, zzaeg zzaegVar) {
        AbstractC0940s.k(zzahgVar);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(zzahgVar, new zzabu(this, zzaegVar));
    }

    public final void zza(zzahl zzahlVar, zzaeg zzaegVar) {
        AbstractC0940s.k(zzahlVar);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(zzahlVar, new zzabr(this, zzaegVar));
    }

    public final void zza(String str, String str2, String str3, String str4, String str5, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.e(str3);
        AbstractC0940s.k(zzaegVar);
        zza(str3, new zzabc(this, str, str2, str4, str5, zzaegVar));
    }

    public final void zza(String str, zzait zzaitVar, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaitVar);
        AbstractC0940s.k(zzaegVar);
        zza(str, new zzabg(this, zzaitVar, zzaegVar));
    }

    public final void zza(String str, zzaiy zzaiyVar, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(zzaiyVar);
        AbstractC0940s.k(zzaegVar);
        zza(str, new zzabe(this, zzaiyVar, zzaegVar));
    }

    public final void zza(zzahw zzahwVar, zzaeg zzaegVar) {
        this.zza.zza(zzahwVar, new zzacc(this, zzaegVar));
    }

    public final void zza(zzahe zzaheVar, zzaeg zzaegVar) {
        AbstractC0940s.e(zzaheVar.zzd());
        AbstractC0940s.k(zzaegVar);
        zzd(zzaheVar, zzaegVar);
    }

    public final void zza(zzaib zzaibVar, zzaeg zzaegVar) {
        AbstractC0940s.e(zzaibVar.zzd());
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(zzaibVar, new zzaba(this, zzaegVar));
    }

    public final void zza(zzait zzaitVar, zzaeg zzaegVar) {
        AbstractC0940s.k(zzaitVar);
        AbstractC0940s.k(zzaegVar);
        zzaitVar.zzb(true);
        this.zza.zza(zzaitVar, new zzabl(this, zzaegVar));
    }

    public final void zza(zzaiu zzaiuVar, zzaeg zzaegVar) {
        AbstractC0940s.k(zzaiuVar);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(zzaiuVar, new zzaay(this, zzaegVar));
    }

    public final void zza(EmailAuthCredential emailAuthCredential, String str, zzaeg zzaegVar) {
        AbstractC0940s.k(emailAuthCredential);
        AbstractC0940s.k(zzaegVar);
        if (emailAuthCredential.zzg()) {
            zza(emailAuthCredential.zzb(), new zzaaq(this, emailAuthCredential, str, zzaegVar));
        } else {
            zza(new zzagp(emailAuthCredential, null, str), zzaegVar);
        }
    }

    public final void zza(zzaiy zzaiyVar, zzaeg zzaegVar) {
        AbstractC0940s.k(zzaiyVar);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(zzaiyVar, new zzaaz(this, zzaegVar));
    }

    public final void zza(zzaig zzaigVar, zzaeg zzaegVar) {
        AbstractC0940s.k(zzaigVar);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(zzaigVar, new zzabo(this, zzaigVar, zzaegVar));
    }

    public final void zza(zzaii zzaiiVar, zzaeg zzaegVar) {
        AbstractC0940s.k(zzaiiVar);
        AbstractC0940s.k(zzaegVar);
        this.zza.zza(zzaiiVar, new zzabs(this, zzaegVar));
    }

    public final void zza(String str, String str2, String str3, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.e(str2);
        AbstractC0940s.k(zzaegVar);
        zza(str, new zzabj(this, str2, str3, zzaegVar));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzaeg zzaegVar) {
        AbstractC0940s.e(str);
        AbstractC0940s.k(userProfileChangeRequest);
        AbstractC0940s.k(zzaegVar);
        zza(str, new zzacb(this, userProfileChangeRequest, zzaegVar));
    }
}
