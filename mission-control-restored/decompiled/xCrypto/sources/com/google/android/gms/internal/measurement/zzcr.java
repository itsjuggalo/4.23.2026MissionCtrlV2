package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface zzcr extends IInterface {
    void beginAdUnitExposure(String str, long j4);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j4);

    void endAdUnitExposure(String str, long j4);

    void generateEventId(zzcu zzcuVar);

    void getAppInstanceId(zzcu zzcuVar);

    void getCachedAppInstanceId(zzcu zzcuVar);

    void getConditionalUserProperties(String str, String str2, zzcu zzcuVar);

    void getCurrentScreenClass(zzcu zzcuVar);

    void getCurrentScreenName(zzcu zzcuVar);

    void getGmpAppId(zzcu zzcuVar);

    void getMaxUserProperties(String str, zzcu zzcuVar);

    void getSessionId(zzcu zzcuVar);

    void getTestFlag(zzcu zzcuVar, int i4);

    void getUserProperties(String str, String str2, boolean z4, zzcu zzcuVar);

    void initForTests(Map map);

    void initialize(J1.a aVar, zzdd zzddVar, long j4);

    void isDataCollectionEnabled(zzcu zzcuVar);

    void logEvent(String str, String str2, Bundle bundle, boolean z4, boolean z5, long j4);

    void logEventAndBundle(String str, String str2, Bundle bundle, zzcu zzcuVar, long j4);

    void logHealthData(int i4, String str, J1.a aVar, J1.a aVar2, J1.a aVar3);

    void onActivityCreated(J1.a aVar, Bundle bundle, long j4);

    void onActivityCreatedByScionActivityInfo(zzdf zzdfVar, Bundle bundle, long j4);

    void onActivityDestroyed(J1.a aVar, long j4);

    void onActivityDestroyedByScionActivityInfo(zzdf zzdfVar, long j4);

    void onActivityPaused(J1.a aVar, long j4);

    void onActivityPausedByScionActivityInfo(zzdf zzdfVar, long j4);

    void onActivityResumed(J1.a aVar, long j4);

    void onActivityResumedByScionActivityInfo(zzdf zzdfVar, long j4);

    void onActivitySaveInstanceState(J1.a aVar, zzcu zzcuVar, long j4);

    void onActivitySaveInstanceStateByScionActivityInfo(zzdf zzdfVar, zzcu zzcuVar, long j4);

    void onActivityStarted(J1.a aVar, long j4);

    void onActivityStartedByScionActivityInfo(zzdf zzdfVar, long j4);

    void onActivityStopped(J1.a aVar, long j4);

    void onActivityStoppedByScionActivityInfo(zzdf zzdfVar, long j4);

    void performAction(Bundle bundle, zzcu zzcuVar, long j4);

    void registerOnMeasurementEventListener(zzda zzdaVar);

    void resetAnalyticsData(long j4);

    void retrieveAndUploadBatches(zzcx zzcxVar);

    void setConditionalUserProperty(Bundle bundle, long j4);

    void setConsent(Bundle bundle, long j4);

    void setConsentThirdParty(Bundle bundle, long j4);

    void setCurrentScreen(J1.a aVar, String str, String str2, long j4);

    void setCurrentScreenByScionActivityInfo(zzdf zzdfVar, String str, String str2, long j4);

    void setDataCollectionEnabled(boolean z4);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(zzda zzdaVar);

    void setInstanceIdProvider(zzdc zzdcVar);

    void setMeasurementEnabled(boolean z4, long j4);

    void setMinimumSessionDuration(long j4);

    void setSessionTimeoutDuration(long j4);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j4);

    void setUserProperty(String str, String str2, J1.a aVar, boolean z4, long j4);

    void unregisterOnMeasurementEventListener(zzda zzdaVar);
}
