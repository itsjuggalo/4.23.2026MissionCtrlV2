package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcp extends zzbl implements zzcr {
    public zzcp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void beginAdUnitExposure(String str, long j10) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeLong(j10);
        zzc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbn.zzc(parcelZza, bundle);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void clearMeasurementEnabled(long j10) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void endAdUnitExposure(String str, long j10) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeLong(j10);
        zzc(24, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void generateEventId(zzcu zzcuVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcuVar);
        zzc(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getAppInstanceId(zzcu zzcuVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcuVar);
        zzc(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getCachedAppInstanceId(zzcu zzcuVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcuVar);
        zzc(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getConditionalUserProperties(String str, String str2, zzcu zzcuVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbn.zzd(parcelZza, zzcuVar);
        zzc(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getCurrentScreenClass(zzcu zzcuVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcuVar);
        zzc(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getCurrentScreenName(zzcu zzcuVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcuVar);
        zzc(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getGmpAppId(zzcu zzcuVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcuVar);
        zzc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getMaxUserProperties(String str, zzcu zzcuVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzbn.zzd(parcelZza, zzcuVar);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getSessionId(zzcu zzcuVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcuVar);
        zzc(46, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getTestFlag(zzcu zzcuVar, int i10) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcuVar);
        parcelZza.writeInt(i10);
        zzc(38, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getUserProperties(String str, String str2, boolean z10, zzcu zzcuVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        int i10 = zzbn.zza;
        parcelZza.writeInt(z10 ? 1 : 0);
        zzbn.zzd(parcelZza, zzcuVar);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void initForTests(Map map) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void initialize(w5.a aVar, zzdd zzddVar, long j10) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, aVar);
        zzbn.zzc(parcelZza, zzddVar);
        parcelZza.writeLong(j10);
        zzc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void isDataCollectionEnabled(zzcu zzcuVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbn.zzc(parcelZza, bundle);
        parcelZza.writeInt(z10 ? 1 : 0);
        parcelZza.writeInt(z11 ? 1 : 0);
        parcelZza.writeLong(j10);
        zzc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzcu zzcuVar, long j10) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void logHealthData(int i10, String str, w5.a aVar, w5.a aVar2, w5.a aVar3) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(5);
        parcelZza.writeString(str);
        zzbn.zzd(parcelZza, aVar);
        zzbn.zzd(parcelZza, aVar2);
        zzbn.zzd(parcelZza, aVar3);
        zzc(33, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityCreated(w5.a aVar, Bundle bundle, long j10) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityCreatedByScionActivityInfo(zzdf zzdfVar, Bundle bundle, long j10) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        zzbn.zzc(parcelZza, bundle);
        parcelZza.writeLong(j10);
        zzc(53, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityDestroyed(w5.a aVar, long j10) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityDestroyedByScionActivityInfo(zzdf zzdfVar, long j10) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        parcelZza.writeLong(j10);
        zzc(54, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityPaused(w5.a aVar, long j10) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityPausedByScionActivityInfo(zzdf zzdfVar, long j10) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        parcelZza.writeLong(j10);
        zzc(55, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityResumed(w5.a aVar, long j10) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityResumedByScionActivityInfo(zzdf zzdfVar, long j10) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        parcelZza.writeLong(j10);
        zzc(56, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivitySaveInstanceState(w5.a aVar, zzcu zzcuVar, long j10) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivitySaveInstanceStateByScionActivityInfo(zzdf zzdfVar, zzcu zzcuVar, long j10) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        zzbn.zzd(parcelZza, zzcuVar);
        parcelZza.writeLong(j10);
        zzc(57, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStarted(w5.a aVar, long j10) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStartedByScionActivityInfo(zzdf zzdfVar, long j10) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        parcelZza.writeLong(j10);
        zzc(51, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStopped(w5.a aVar, long j10) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStoppedByScionActivityInfo(zzdf zzdfVar, long j10) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        parcelZza.writeLong(j10);
        zzc(52, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void performAction(Bundle bundle, zzcu zzcuVar, long j10) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        zzbn.zzd(parcelZza, zzcuVar);
        parcelZza.writeLong(j10);
        zzc(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void registerOnMeasurementEventListener(zzda zzdaVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzdaVar);
        zzc(35, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void resetAnalyticsData(long j10) {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j10);
        zzc(12, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void retrieveAndUploadBatches(zzcx zzcxVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcxVar);
        zzc(58, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setConditionalUserProperty(Bundle bundle, long j10) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        parcelZza.writeLong(j10);
        zzc(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setConsent(Bundle bundle, long j10) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setConsentThirdParty(Bundle bundle, long j10) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        parcelZza.writeLong(j10);
        zzc(45, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setCurrentScreen(w5.a aVar, String str, String str2, long j10) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setCurrentScreenByScionActivityInfo(zzdf zzdfVar, String str, String str2, long j10) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeLong(j10);
        zzc(50, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setDataCollectionEnabled(boolean z10) {
        Parcel parcelZza = zza();
        int i10 = zzbn.zza;
        parcelZza.writeInt(z10 ? 1 : 0);
        zzc(39, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setDefaultEventParameters(Bundle bundle) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        zzc(42, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setEventInterceptor(zzda zzdaVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzdaVar);
        zzc(34, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setInstanceIdProvider(zzdc zzdcVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setMeasurementEnabled(boolean z10, long j10) {
        Parcel parcelZza = zza();
        int i10 = zzbn.zza;
        parcelZza.writeInt(z10 ? 1 : 0);
        parcelZza.writeLong(j10);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setMinimumSessionDuration(long j10) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setSessionTimeoutDuration(long j10) {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j10);
        zzc(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setSgtmDebugInfo(Intent intent) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, intent);
        zzc(48, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setUserId(String str, long j10) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeLong(j10);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setUserProperty(String str, String str2, w5.a aVar, boolean z10, long j10) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbn.zzd(parcelZza, aVar);
        parcelZza.writeInt(z10 ? 1 : 0);
        parcelZza.writeLong(j10);
        zzc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void unregisterOnMeasurementEventListener(zzda zzdaVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzdaVar);
        zzc(36, parcelZza);
    }
}
