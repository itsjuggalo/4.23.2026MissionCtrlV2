package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.DynamiteApi;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@DynamiteApi
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzcq {
    zzic zza = null;
    private final Map zzb = new w.a();

    private final void zzb() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zzc(com.google.android.gms.internal.measurement.zzcu zzcuVar, String str) {
        zzb();
        this.zza.zzk().zzal(zzcuVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void beginAdUnitExposure(String str, long j10) {
        zzb();
        this.zza.zzw().zza(str, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzb();
        this.zza.zzj().zzab(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void clearMeasurementEnabled(long j10) {
        zzb();
        this.zza.zzj().zzn(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void endAdUnitExposure(String str, long j10) {
        zzb();
        this.zza.zzw().zzb(str, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void generateEventId(com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzb();
        long jZzd = this.zza.zzk().zzd();
        zzb();
        this.zza.zzk().zzam(zzcuVar, jZzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzb();
        this.zza.zzaW().zzj(new zzi(this, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzb();
        zzc(zzcuVar, this.zza.zzj().zzQ());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzb();
        this.zza.zzaW().zzj(new zzm(this, zzcuVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzb();
        zzc(zzcuVar, this.zza.zzj().zzae());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzb();
        zzc(zzcuVar, this.zza.zzj().zzad());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzb();
        zzc(zzcuVar, this.zza.zzj().zzaf());
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzb();
        this.zza.zzj().zzY(str);
        zzb();
        this.zza.zzk().zzan(zzcuVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getSessionId(com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzb();
        zzlj zzljVarZzj = this.zza.zzj();
        zzljVarZzj.zzu.zzaW().zzj(new zzkm(zzljVarZzj, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getTestFlag(com.google.android.gms.internal.measurement.zzcu zzcuVar, int i10) {
        zzb();
        if (i10 == 0) {
            this.zza.zzk().zzal(zzcuVar, this.zza.zzj().zzj());
            return;
        }
        if (i10 == 1) {
            this.zza.zzk().zzam(zzcuVar, this.zza.zzj().zzk().longValue());
            return;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                this.zza.zzk().zzan(zzcuVar, this.zza.zzj().zzl().intValue());
                return;
            } else {
                if (i10 != 4) {
                    return;
                }
                this.zza.zzk().zzap(zzcuVar, this.zza.zzj().zzi().booleanValue());
                return;
            }
        }
        zzpp zzppVarZzk = this.zza.zzk();
        double dDoubleValue = this.zza.zzj().zzm().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", dDoubleValue);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e10) {
            zzppVarZzk.zzu.zzaV().zze().zzb("Error returning double value to wrapper", e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void getUserProperties(String str, String str2, boolean z10, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzb();
        this.zza.zzaW().zzj(new zzk(this, zzcuVar, str, str2, z10));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void initForTests(Map map) {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void initialize(w5.a aVar, com.google.android.gms.internal.measurement.zzdd zzddVar, long j10) {
        zzic zzicVar = this.zza;
        if (zzicVar == null) {
            this.zza = zzic.zzy((Context) s.k((Context) w5.b.I(aVar)), zzddVar, Long.valueOf(j10));
        } else {
            zzicVar.zzaV().zze().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        zzb();
        this.zza.zzaW().zzj(new zzn(this, zzcuVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        zzb();
        this.zza.zzj().zzC(str, str2, bundle, z10, z11, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j10) {
        zzb();
        s.e(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.zza.zzaW().zzj(new zzj(this, zzcuVar, new zzbg(str2, new zzbe(bundle), "app", j10), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void logHealthData(int i10, String str, w5.a aVar, w5.a aVar2, w5.a aVar3) {
        zzb();
        this.zza.zzaV().zzm(i10, true, false, str, aVar == null ? null : w5.b.I(aVar), aVar2 == null ? null : w5.b.I(aVar2), aVar3 != null ? w5.b.I(aVar3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityCreated(w5.a aVar, Bundle bundle, long j10) {
        zzb();
        onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) s.k((Activity) w5.b.I(aVar))), bundle, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, Bundle bundle, long j10) {
        zzb();
        zzky zzkyVar = this.zza.zzj().zza;
        if (zzkyVar != null) {
            this.zza.zzj().zzh();
            zzkyVar.zza(zzdfVar, bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityDestroyed(w5.a aVar, long j10) {
        zzb();
        onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) s.k((Activity) w5.b.I(aVar))), j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j10) {
        zzb();
        zzky zzkyVar = this.zza.zzj().zza;
        if (zzkyVar != null) {
            this.zza.zzj().zzh();
            zzkyVar.zzb(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityPaused(w5.a aVar, long j10) {
        zzb();
        onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) s.k((Activity) w5.b.I(aVar))), j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j10) {
        zzb();
        zzky zzkyVar = this.zza.zzj().zza;
        if (zzkyVar != null) {
            this.zza.zzj().zzh();
            zzkyVar.zzc(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityResumed(w5.a aVar, long j10) {
        zzb();
        onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) s.k((Activity) w5.b.I(aVar))), j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j10) {
        zzb();
        zzky zzkyVar = this.zza.zzj().zza;
        if (zzkyVar != null) {
            this.zza.zzj().zzh();
            zzkyVar.zzd(zzdfVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivitySaveInstanceState(w5.a aVar, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j10) {
        zzb();
        onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) s.k((Activity) w5.b.I(aVar))), zzcuVar, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j10) {
        zzb();
        zzky zzkyVar = this.zza.zzj().zza;
        Bundle bundle = new Bundle();
        if (zzkyVar != null) {
            this.zza.zzj().zzh();
            zzkyVar.zze(zzdfVar, bundle);
        }
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e10) {
            this.zza.zzaV().zze().zzb("Error returning bundle value to wrapper", e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStarted(w5.a aVar, long j10) {
        zzb();
        onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) s.k((Activity) w5.b.I(aVar))), j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j10) {
        zzb();
        if (this.zza.zzj().zza != null) {
            this.zza.zzj().zzh();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStopped(w5.a aVar, long j10) {
        zzb();
        onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) s.k((Activity) w5.b.I(aVar))), j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, long j10) {
        zzb();
        if (this.zza.zzj().zza != null) {
            this.zza.zzj().zzh();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzcu zzcuVar, long j10) {
        zzb();
        zzcuVar.zzb(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzda zzdaVar) {
        zzjq zzqVar;
        zzb();
        Map map = this.zzb;
        synchronized (map) {
            try {
                zzqVar = (zzjq) map.get(Integer.valueOf(zzdaVar.zzf()));
                if (zzqVar == null) {
                    zzqVar = new zzq(this, zzdaVar);
                    map.put(Integer.valueOf(zzdaVar.zzf()), zzqVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.zza.zzj().zzW(zzqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void resetAnalyticsData(long j10) {
        zzb();
        this.zza.zzj().zzT(j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void retrieveAndUploadBatches(final com.google.android.gms.internal.measurement.zzcx zzcxVar) {
        zzb();
        this.zza.zzj().zzt(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzo
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    zzcxVar.zze();
                } catch (RemoteException e10) {
                    ((zzic) s.k(this.zza.zza)).zzaV().zze().zzb("Failed to call IDynamiteUploadBatchesCallback", e10);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConditionalUserProperty(Bundle bundle, long j10) {
        zzb();
        if (bundle == null) {
            this.zza.zzaV().zzb().zza("Conditional user property must not be null");
        } else {
            this.zza.zzj().zzaa(bundle, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConsentThirdParty(Bundle bundle, long j10) {
        zzb();
        this.zza.zzj().zzp(bundle, -20, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setCurrentScreen(w5.a aVar, String str, String str2, long j10) {
        zzb();
        setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf.zza((Activity) s.k((Activity) w5.b.I(aVar))), str, str2, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzdf zzdfVar, String str, String str2, long j10) {
        zzb();
        this.zza.zzs().zzk(zzdfVar, str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setDataCollectionEnabled(boolean z10) {
        zzb();
        zzlj zzljVarZzj = this.zza.zzj();
        zzljVarZzj.zzb();
        zzljVarZzj.zzu.zzaW().zzj(new zzjy(zzljVarZzj, z10));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setDefaultEventParameters(Bundle bundle) {
        zzb();
        final zzlj zzljVarZzj = this.zza.zzj();
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzljVarZzj.zzu.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlf
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzljVarZzj.zzah(bundle2);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzda zzdaVar) {
        zzb();
        zzp zzpVar = new zzp(this, zzdaVar);
        if (this.zza.zzaW().zze()) {
            this.zza.zzj().zzV(zzpVar);
        } else {
            this.zza.zzaW().zzj(new zzl(this, zzpVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzdc zzdcVar) {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setMeasurementEnabled(boolean z10, long j10) {
        zzb();
        this.zza.zzj().zzn(Boolean.valueOf(z10));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setMinimumSessionDuration(long j10) {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setSessionTimeoutDuration(long j10) {
        zzb();
        zzlj zzljVarZzj = this.zza.zzj();
        zzljVarZzj.zzu.zzaW().zzj(new zzka(zzljVarZzj, j10));
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setSgtmDebugInfo(Intent intent) {
        zzb();
        zzlj zzljVarZzj = this.zza.zzj();
        Uri data = intent.getData();
        if (data == null) {
            zzljVarZzj.zzu.zzaV().zzi().zza("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals("1")) {
            zzic zzicVar = zzljVarZzj.zzu;
            zzicVar.zzaV().zzi().zza("[sgtm] Preview Mode was not enabled.");
            zzicVar.zzc().zzy(null);
        } else {
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            zzic zzicVar2 = zzljVarZzj.zzu;
            zzicVar2.zzaV().zzi().zzb("[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            zzicVar2.zzc().zzy(queryParameter2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setUserId(final String str, long j10) {
        zzb();
        final zzlj zzljVarZzj = this.zza.zzj();
        if (str != null && TextUtils.isEmpty(str)) {
            zzljVarZzj.zzu.zzaV().zze().zza("User ID must be non-empty or null");
        } else {
            zzljVarZzj.zzu.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlg
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzic zzicVar = zzljVarZzj.zzu;
                    if (zzicVar.zzv().zzq(str)) {
                        zzicVar.zzv().zzi();
                    }
                }
            });
            zzljVarZzj.zzL(null, "_id", str, true, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setUserProperty(String str, String str2, w5.a aVar, boolean z10, long j10) {
        zzb();
        this.zza.zzj().zzL(str, str2, w5.b.I(aVar), z10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzda zzdaVar) {
        zzjq zzqVar;
        zzb();
        Map map = this.zzb;
        synchronized (map) {
            zzqVar = (zzjq) map.remove(Integer.valueOf(zzdaVar.zzf()));
        }
        if (zzqVar == null) {
            zzqVar = new zzq(this, zzdaVar);
        }
        this.zza.zzj().zzX(zzqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public void setConsent(Bundle bundle, long j10) {
    }
}
