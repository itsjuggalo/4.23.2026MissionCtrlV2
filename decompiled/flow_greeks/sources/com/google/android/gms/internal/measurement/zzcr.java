package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface zzcr extends IInterface {
    void beginAdUnitExposure(String str, long j10);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j10);

    void endAdUnitExposure(String str, long j10);

    void generateEventId(zzcu zzcuVar);

    void getAppInstanceId(zzcu zzcuVar);

    void getCachedAppInstanceId(zzcu zzcuVar);

    void getConditionalUserProperties(String str, String str2, zzcu zzcuVar);

    void getCurrentScreenClass(zzcu zzcuVar);

    void getCurrentScreenName(zzcu zzcuVar);

    void getGmpAppId(zzcu zzcuVar);

    void getMaxUserProperties(String str, zzcu zzcuVar);

    void getSessionId(zzcu zzcuVar);

    void getTestFlag(zzcu zzcuVar, int i10);

    void getUserProperties(String str, String str2, boolean z10, zzcu zzcuVar);

    void initForTests(Map map);

    void initialize(w5.a aVar, zzdd zzddVar, long j10);

    void isDataCollectionEnabled(zzcu zzcuVar);

    void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10);

    void logEventAndBundle(String str, String str2, Bundle bundle, zzcu zzcuVar, long j10);

    void logHealthData(int i10, String str, w5.a aVar, w5.a aVar2, w5.a aVar3);

    void onActivityCreated(w5.a aVar, Bundle bundle, long j10);

    void onActivityCreatedByScionActivityInfo(zzdf zzdfVar, Bundle bundle, long j10);

    void onActivityDestroyed(w5.a aVar, long j10);

    void onActivityDestroyedByScionActivityInfo(zzdf zzdfVar, long j10);

    void onActivityPaused(w5.a aVar, long j10);

    void onActivityPausedByScionActivityInfo(zzdf zzdfVar, long j10);

    void onActivityResumed(w5.a aVar, long j10);

    void onActivityResumedByScionActivityInfo(zzdf zzdfVar, long j10);

    void onActivitySaveInstanceState(w5.a aVar, zzcu zzcuVar, long j10);

    void onActivitySaveInstanceStateByScionActivityInfo(zzdf zzdfVar, zzcu zzcuVar, long j10);

    void onActivityStarted(w5.a aVar, long j10);

    void onActivityStartedByScionActivityInfo(zzdf zzdfVar, long j10);

    void onActivityStopped(w5.a aVar, long j10);

    void onActivityStoppedByScionActivityInfo(zzdf zzdfVar, long j10);

    void performAction(Bundle bundle, zzcu zzcuVar, long j10);

    void registerOnMeasurementEventListener(zzda zzdaVar);

    void resetAnalyticsData(long j10);

    void retrieveAndUploadBatches(zzcx zzcxVar);

    void setConditionalUserProperty(Bundle bundle, long j10);

    void setConsent(Bundle bundle, long j10);

    void setConsentThirdParty(Bundle bundle, long j10);

    void setCurrentScreen(w5.a aVar, String str, String str2, long j10);

    void setCurrentScreenByScionActivityInfo(zzdf zzdfVar, String str, String str2, long j10);

    void setDataCollectionEnabled(boolean z10);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(zzda zzdaVar);

    void setInstanceIdProvider(zzdc zzdcVar);

    void setMeasurementEnabled(boolean z10, long j10);

    void setMinimumSessionDuration(long j10);

    void setSessionTimeoutDuration(long j10);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j10);

    void setUserProperty(String str, String str2, w5.a aVar, boolean z10, long j10);

    void unregisterOnMeasurementEventListener(zzda zzdaVar);
}
