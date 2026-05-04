package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.internal.s;
import x4.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzhh extends zzjf {
    static final Pair zza = new Pair("", 0L);
    public zzhf zzb;
    public final zzhe zzc;
    public final zzhe zzd;
    public final zzhg zze;
    public final zzhe zzf;
    public final zzhc zzg;
    public final zzhg zzh;
    public final zzhd zzi;
    public final zzhc zzj;
    public final zzhe zzk;
    public final zzhe zzl;
    public boolean zzm;
    public final zzhc zzn;
    public final zzhc zzo;
    public final zzhe zzp;
    public final zzhg zzq;
    public final zzhg zzr;
    public final zzhe zzs;
    public final zzhd zzt;
    private SharedPreferences zzv;
    private SharedPreferences zzw;
    private String zzx;
    private boolean zzy;
    private long zzz;

    public zzhh(zzic zzicVar) {
        super(zzicVar);
        this.zzf = new zzhe(this, "session_timeout", 1800000L);
        this.zzg = new zzhc(this, "start_new_session", true);
        this.zzk = new zzhe(this, "last_pause_time", 0L);
        this.zzl = new zzhe(this, "session_id", 0L);
        this.zzh = new zzhg(this, "non_personalized_ads", null);
        this.zzi = new zzhd(this, "last_received_uri_timestamps_by_source", null);
        this.zzj = new zzhc(this, "allow_remote_dynamite", false);
        this.zzc = new zzhe(this, "first_open_time", 0L);
        this.zzd = new zzhe(this, "app_install_time", 0L);
        this.zze = new zzhg(this, "app_instance_id", null);
        this.zzn = new zzhc(this, "app_backgrounded", false);
        this.zzo = new zzhc(this, "deep_link_retrieval_complete", false);
        this.zzp = new zzhe(this, "deep_link_retrieval_attempts", 0L);
        this.zzq = new zzhg(this, "firebase_feature_rollouts", null);
        this.zzr = new zzhg(this, "deferred_attribution_cache", null);
        this.zzs = new zzhe(this, "deferred_attribution_cache_timestamp", 0L);
        this.zzt = new zzhd(this, "default_event_parameters", null);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final boolean zza() {
        return true;
    }

    public final Pair zzb(String str) {
        zzg();
        if (!zzl().zzo(zzjk.AD_STORAGE)) {
            return new Pair("", Boolean.FALSE);
        }
        zzic zzicVar = this.zzu;
        long jB = zzicVar.zzaZ().b();
        String str2 = this.zzx;
        if (str2 != null && jB < this.zzz) {
            return new Pair(str2, Boolean.valueOf(this.zzy));
        }
        this.zzz = jB + zzicVar.zzc().zzl(str, zzfy.zza);
        x4.a.b(true);
        try {
            a.C0423a c0423aA = x4.a.a(zzicVar.zzaY());
            this.zzx = "";
            String strA = c0423aA.a();
            if (strA != null) {
                this.zzx = strA;
            }
            this.zzy = c0423aA.b();
        } catch (Exception e10) {
            this.zzu.zzaV().zzj().zzb("Unable to get advertising id", e10);
            this.zzx = "";
        }
        x4.a.b(false);
        return new Pair(this.zzx, Boolean.valueOf(this.zzy));
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final void zzba() {
        zzic zzicVar = this.zzu;
        SharedPreferences sharedPreferences = zzicVar.zzaY().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzv = sharedPreferences;
        boolean z10 = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzm = z10;
        if (!z10) {
            SharedPreferences.Editor editorEdit = this.zzv.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        zzicVar.zzc();
        this.zzb = new zzhf(this, "health_monitor", Math.max(0L, ((Long) zzfy.zzc.zzb(null)).longValue()), null);
    }

    public final SharedPreferences zzd() {
        zzg();
        zzw();
        s.k(this.zzv);
        return this.zzv;
    }

    public final SharedPreferences zze() {
        zzg();
        zzw();
        if (this.zzw == null) {
            zzic zzicVar = this.zzu;
            String strValueOf = String.valueOf(zzicVar.zzaY().getPackageName());
            zzgs zzgsVarZzk = zzicVar.zzaV().zzk();
            String strConcat = strValueOf.concat("_preferences");
            zzgsVarZzk.zzb("Default prefs file", strConcat);
            this.zzw = zzicVar.zzaY().getSharedPreferences(strConcat, 0);
        }
        return this.zzw;
    }

    public final SparseArray zzf() {
        Bundle bundleZza = this.zzi.zza();
        int[] intArray = bundleZza.getIntArray("uriSources");
        long[] longArray = bundleZza.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            this.zzu.zzaV().zzb().zza("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i10 = 0; i10 < intArray.length; i10++) {
            sparseArray.put(intArray[i10], Long.valueOf(longArray[i10]));
        }
        return sparseArray;
    }

    public final void zzh(Boolean bool) {
        zzg();
        SharedPreferences.Editor editorEdit = zzd().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
    }

    public final Boolean zzi() {
        zzg();
        if (zzd().contains("measurement_enabled")) {
            return Boolean.valueOf(zzd().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    public final zzaz zzj() {
        zzg();
        return zzaz.zzg(zzd().getString("dma_consent_settings", null));
    }

    public final boolean zzk(int i10) {
        return zzjl.zzu(i10, zzd().getInt("consent_source", 100));
    }

    public final zzjl zzl() {
        zzg();
        return zzjl.zzf(zzd().getString("consent_settings", "G1"), zzd().getInt("consent_source", 100));
    }

    public final boolean zzm(zzod zzodVar) {
        zzg();
        String string = zzd().getString("stored_tcf_param", "");
        String strZza = zzodVar.zza();
        if (strZza.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = zzd().edit();
        editorEdit.putString("stored_tcf_param", strZza);
        editorEdit.apply();
        return true;
    }

    public final void zzn(boolean z10) {
        zzg();
        this.zzu.zzaV().zzk().zzb("App measurement setting deferred collection", Boolean.valueOf(z10));
        SharedPreferences.Editor editorEdit = zzd().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z10);
        editorEdit.apply();
    }

    public final boolean zzo() {
        SharedPreferences sharedPreferences = this.zzv;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    public final boolean zzp(long j10) {
        return j10 - this.zzf.zza() > this.zzk.zza();
    }
}
