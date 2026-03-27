package com.google.android.gms.internal.measurement;

import E1.a;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcp extends zzbl implements zzcr {
    public zzcp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void beginAdUnitExposure(String str, long j4) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeLong(j4);
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
    public final void clearMeasurementEnabled(long j4) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void endAdUnitExposure(String str, long j4) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeLong(j4);
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
    public final void getTestFlag(zzcu zzcuVar, int i) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcuVar);
        parcelZza.writeInt(i);
        zzc(38, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void getUserProperties(String str, String str2, boolean z6, zzcu zzcuVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        int i = zzbn.zza;
        parcelZza.writeInt(z6 ? 1 : 0);
        zzbn.zzd(parcelZza, zzcuVar);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void initForTests(Map map) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void initialize(a aVar, zzdd zzddVar, long j4) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, aVar);
        zzbn.zzc(parcelZza, zzddVar);
        parcelZza.writeLong(j4);
        zzc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void isDataCollectionEnabled(zzcu zzcuVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void logEvent(String str, String str2, Bundle bundle, boolean z6, boolean z7, long j4) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbn.zzc(parcelZza, bundle);
        parcelZza.writeInt(z6 ? 1 : 0);
        parcelZza.writeInt(z7 ? 1 : 0);
        parcelZza.writeLong(j4);
        zzc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzcu zzcuVar, long j4) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void logHealthData(int i, String str, a aVar, a aVar2, a aVar3) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(5);
        parcelZza.writeString(str);
        zzbn.zzd(parcelZza, aVar);
        zzbn.zzd(parcelZza, aVar2);
        zzbn.zzd(parcelZza, aVar3);
        zzc(33, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityCreated(a aVar, Bundle bundle, long j4) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityCreatedByScionActivityInfo(zzdf zzdfVar, Bundle bundle, long j4) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        zzbn.zzc(parcelZza, bundle);
        parcelZza.writeLong(j4);
        zzc(53, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityDestroyed(a aVar, long j4) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityDestroyedByScionActivityInfo(zzdf zzdfVar, long j4) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        parcelZza.writeLong(j4);
        zzc(54, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityPaused(a aVar, long j4) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityPausedByScionActivityInfo(zzdf zzdfVar, long j4) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        parcelZza.writeLong(j4);
        zzc(55, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityResumed(a aVar, long j4) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityResumedByScionActivityInfo(zzdf zzdfVar, long j4) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        parcelZza.writeLong(j4);
        zzc(56, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivitySaveInstanceState(a aVar, zzcu zzcuVar, long j4) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivitySaveInstanceStateByScionActivityInfo(zzdf zzdfVar, zzcu zzcuVar, long j4) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        zzbn.zzd(parcelZza, zzcuVar);
        parcelZza.writeLong(j4);
        zzc(57, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStarted(a aVar, long j4) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStartedByScionActivityInfo(zzdf zzdfVar, long j4) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        parcelZza.writeLong(j4);
        zzc(51, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStopped(a aVar, long j4) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void onActivityStoppedByScionActivityInfo(zzdf zzdfVar, long j4) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        parcelZza.writeLong(j4);
        zzc(52, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void performAction(Bundle bundle, zzcu zzcuVar, long j4) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        zzbn.zzd(parcelZza, zzcuVar);
        parcelZza.writeLong(j4);
        zzc(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void registerOnMeasurementEventListener(zzda zzdaVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzdaVar);
        zzc(35, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void resetAnalyticsData(long j4) {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j4);
        zzc(12, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void retrieveAndUploadBatches(zzcx zzcxVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzcxVar);
        zzc(58, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setConditionalUserProperty(Bundle bundle, long j4) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        parcelZza.writeLong(j4);
        zzc(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setConsent(Bundle bundle, long j4) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setConsentThirdParty(Bundle bundle, long j4) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, bundle);
        parcelZza.writeLong(j4);
        zzc(45, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setCurrentScreen(a aVar, String str, String str2, long j4) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setCurrentScreenByScionActivityInfo(zzdf zzdfVar, String str, String str2, long j4) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, zzdfVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeLong(j4);
        zzc(50, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setDataCollectionEnabled(boolean z6) {
        Parcel parcelZza = zza();
        int i = zzbn.zza;
        parcelZza.writeInt(z6 ? 1 : 0);
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
    public final void setMeasurementEnabled(boolean z6, long j4) {
        Parcel parcelZza = zza();
        int i = zzbn.zza;
        parcelZza.writeInt(z6 ? 1 : 0);
        parcelZza.writeLong(j4);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setMinimumSessionDuration(long j4) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setSessionTimeoutDuration(long j4) {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j4);
        zzc(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setSgtmDebugInfo(Intent intent) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, intent);
        zzc(48, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setUserId(String str, long j4) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeLong(j4);
        zzc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void setUserProperty(String str, String str2, a aVar, boolean z6, long j4) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbn.zzd(parcelZza, aVar);
        parcelZza.writeInt(z6 ? 1 : 0);
        parcelZza.writeLong(j4);
        zzc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzcr
    public final void unregisterOnMeasurementEventListener(zzda zzdaVar) {
        Parcel parcelZza = zza();
        zzbn.zzd(parcelZza, zzdaVar);
        zzc(36, parcelZza);
    }
}
