package com.google.firebase.auth.internal;

import com.google.android.gms.internal.p002firebaseauthapi.zzahx;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;

/* JADX INFO: loaded from: classes.dex */
public final class zzu implements ActionCodeResult {
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final ActionCodeInfo zzd;

    public zzu(zzahx zzahxVar) {
        int i4 = 5;
        this.zzb = zzahxVar.zzg() ? zzahxVar.zzc() : zzahxVar.zzb();
        this.zzc = zzahxVar.zzb();
        ActionCodeInfo zzsVar = null;
        if (!zzahxVar.zzh()) {
            this.zza = 3;
            this.zzd = null;
            return;
        }
        String strZzd = zzahxVar.zzd();
        strZzd.getClass();
        switch (strZzd) {
            case "REVERT_SECOND_FACTOR_ADDITION":
                i4 = 6;
                break;
            case "PASSWORD_RESET":
                i4 = 0;
                break;
            case "VERIFY_EMAIL":
                i4 = 1;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                break;
            case "EMAIL_SIGNIN":
                i4 = 4;
                break;
            case "RECOVER_EMAIL":
                i4 = 2;
                break;
            default:
                i4 = 3;
                break;
        }
        this.zza = i4;
        if (i4 == 4 || i4 == 3) {
            this.zzd = null;
            return;
        }
        if (zzahxVar.zzf()) {
            zzsVar = new zzv(zzahxVar.zzb(), zzbk.zza(zzahxVar.zza()));
        } else if (zzahxVar.zzg()) {
            zzsVar = new zzt(zzahxVar.zzc(), zzahxVar.zzb());
        } else if (zzahxVar.zze()) {
            zzsVar = new zzs(zzahxVar.zzb());
        }
        this.zzd = zzsVar;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final String getData(int i4) {
        if (this.zza == 4) {
            return null;
        }
        if (i4 == 0) {
            return this.zzb;
        }
        if (i4 != 1) {
            return null;
        }
        return this.zzc;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final ActionCodeInfo getInfo() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final int getOperation() {
        return this.zza;
    }
}
