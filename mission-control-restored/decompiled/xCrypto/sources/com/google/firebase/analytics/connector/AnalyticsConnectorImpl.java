package com.google.firebase.analytics.connector;

import R1.a;
import S1.AbstractC0620l5;
import S1.W3;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzc;
    final a zza;
    final Map zzb;

    public AnalyticsConnectorImpl(a aVar) {
        AbstractC0940s.k(aVar);
        this.zza = aVar;
        this.zzb = new ConcurrentHashMap();
    }

    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static /* synthetic */ void zza(Event event) {
        boolean z4 = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) AbstractC0940s.k(zzc)).zza.i(z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final boolean zzb(String str) {
        if (str.isEmpty()) {
            return false;
        }
        Map map = this.zzb;
        return map.containsKey(str) && map.get(str) != null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || zzc.zzb(str2, bundle)) {
            this.zza.a(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : this.zza.b(str, str2)) {
            int i4 = zzc.zza;
            AbstractC0940s.k(bundle);
            AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
            conditionalUserProperty.origin = (String) AbstractC0940s.k((String) W3.b(bundle, FirebaseAnalytics.Param.ORIGIN, String.class, null));
            conditionalUserProperty.name = (String) AbstractC0940s.k((String) W3.b(bundle, "name", String.class, null));
            conditionalUserProperty.value = W3.b(bundle, "value", Object.class, null);
            conditionalUserProperty.triggerEventName = (String) W3.b(bundle, "trigger_event_name", String.class, null);
            conditionalUserProperty.triggerTimeout = ((Long) W3.b(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            conditionalUserProperty.timedOutEventName = (String) W3.b(bundle, "timed_out_event_name", String.class, null);
            conditionalUserProperty.timedOutEventParams = (Bundle) W3.b(bundle, "timed_out_event_params", Bundle.class, null);
            conditionalUserProperty.triggeredEventName = (String) W3.b(bundle, "triggered_event_name", String.class, null);
            conditionalUserProperty.triggeredEventParams = (Bundle) W3.b(bundle, "triggered_event_params", Bundle.class, null);
            conditionalUserProperty.timeToLive = ((Long) W3.b(bundle, "time_to_live", Long.class, 0L)).longValue();
            conditionalUserProperty.expiredEventName = (String) W3.b(bundle, "expired_event_name", String.class, null);
            conditionalUserProperty.expiredEventParams = (Bundle) W3.b(bundle, "expired_event_params", Bundle.class, null);
            conditionalUserProperty.active = ((Boolean) W3.b(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            conditionalUserProperty.creationTimestamp = ((Long) W3.b(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            conditionalUserProperty.triggeredTimestamp = ((Long) W3.b(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int getMaxUserProperties(String str) {
        return this.zza.c(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public Map<String, Object> getUserProperties(boolean z4) {
        return this.zza.d(null, null, z4);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.zza(str) && zzc.zzb(str2, bundle) && zzc.zze(str, str2, bundle)) {
            if ("clx".equals(str) && Constants.FIREBASE_APPLICATION_EXCEPTION.equals(str2)) {
                bundle.putLong("_r", 1L);
            }
            this.zza.e(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(final String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        AbstractC0940s.k(analyticsConnectorListener);
        if (zzc.zza(str) && !zzb(str)) {
            a aVar = this.zza;
            com.google.firebase.analytics.connector.internal.zza zzeVar = "fiam".equals(str) ? new zze(aVar, analyticsConnectorListener) : "clx".equals(str) ? new zzg(aVar, analyticsConnectorListener) : null;
            if (zzeVar != null) {
                this.zzb.put(str, zzeVar);
                return new AnalyticsConnector.AnalyticsConnectorHandle(this) { // from class: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.1
                    final /* synthetic */ AnalyticsConnectorImpl zzb;

                    {
                        Objects.requireNonNull(this);
                        this.zzb = this;
                    }

                    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
                    public void registerEventNames(Set<String> set) {
                        AnalyticsConnectorImpl analyticsConnectorImpl = this.zzb;
                        String str2 = str;
                        if (!analyticsConnectorImpl.zzb(str2) || !str2.equals("fiam") || set == null || set.isEmpty()) {
                            return;
                        }
                        ((com.google.firebase.analytics.connector.internal.zza) analyticsConnectorImpl.zzb.get(str2)).zzb(set);
                    }

                    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
                    public final void unregister() {
                        AnalyticsConnectorImpl analyticsConnectorImpl = this.zzb;
                        String str2 = str;
                        if (analyticsConnectorImpl.zzb(str2)) {
                            Map map = analyticsConnectorImpl.zzb;
                            AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListenerZza = ((com.google.firebase.analytics.connector.internal.zza) map.get(str2)).zza();
                            if (analyticsConnectorListenerZza != null) {
                                analyticsConnectorListenerZza.onMessageTriggered(0, null);
                            }
                            map.remove(str2);
                        }
                    }

                    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
                    public void unregisterEventNames() {
                        AnalyticsConnectorImpl analyticsConnectorImpl = this.zzb;
                        String str2 = str;
                        if (analyticsConnectorImpl.zzb(str2) && str2.equals("fiam")) {
                            ((com.google.firebase.analytics.connector.internal.zza) analyticsConnectorImpl.zzb.get(str2)).zzc();
                        }
                    }
                };
            }
        }
        return null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str;
        int i4 = zzc.zza;
        if (conditionalUserProperty == null || (str = conditionalUserProperty.origin) == null || str.isEmpty()) {
            return;
        }
        Object obj = conditionalUserProperty.value;
        if ((obj == null || AbstractC0620l5.b(obj) != null) && zzc.zza(str) && zzc.zzd(str, conditionalUserProperty.name)) {
            String str2 = conditionalUserProperty.expiredEventName;
            if (str2 == null || (zzc.zzb(str2, conditionalUserProperty.expiredEventParams) && zzc.zze(str, conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams))) {
                String str3 = conditionalUserProperty.triggeredEventName;
                if (str3 == null || (zzc.zzb(str3, conditionalUserProperty.triggeredEventParams) && zzc.zze(str, conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams))) {
                    String str4 = conditionalUserProperty.timedOutEventName;
                    if (str4 == null || (zzc.zzb(str4, conditionalUserProperty.timedOutEventParams) && zzc.zze(str, conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams))) {
                        a aVar = this.zza;
                        Bundle bundle = new Bundle();
                        String str5 = conditionalUserProperty.origin;
                        if (str5 != null) {
                            bundle.putString(FirebaseAnalytics.Param.ORIGIN, str5);
                        }
                        String str6 = conditionalUserProperty.name;
                        if (str6 != null) {
                            bundle.putString("name", str6);
                        }
                        Object obj2 = conditionalUserProperty.value;
                        if (obj2 != null) {
                            W3.a(bundle, obj2);
                        }
                        String str7 = conditionalUserProperty.triggerEventName;
                        if (str7 != null) {
                            bundle.putString("trigger_event_name", str7);
                        }
                        bundle.putLong("trigger_timeout", conditionalUserProperty.triggerTimeout);
                        String str8 = conditionalUserProperty.timedOutEventName;
                        if (str8 != null) {
                            bundle.putString("timed_out_event_name", str8);
                        }
                        Bundle bundle2 = conditionalUserProperty.timedOutEventParams;
                        if (bundle2 != null) {
                            bundle.putBundle("timed_out_event_params", bundle2);
                        }
                        String str9 = conditionalUserProperty.triggeredEventName;
                        if (str9 != null) {
                            bundle.putString("triggered_event_name", str9);
                        }
                        Bundle bundle3 = conditionalUserProperty.triggeredEventParams;
                        if (bundle3 != null) {
                            bundle.putBundle("triggered_event_params", bundle3);
                        }
                        bundle.putLong("time_to_live", conditionalUserProperty.timeToLive);
                        String str10 = conditionalUserProperty.expiredEventName;
                        if (str10 != null) {
                            bundle.putString("expired_event_name", str10);
                        }
                        Bundle bundle4 = conditionalUserProperty.expiredEventParams;
                        if (bundle4 != null) {
                            bundle.putBundle("expired_event_params", bundle4);
                        }
                        bundle.putLong("creation_timestamp", conditionalUserProperty.creationTimestamp);
                        bundle.putBoolean("active", conditionalUserProperty.active);
                        bundle.putLong("triggered_timestamp", conditionalUserProperty.triggeredTimestamp);
                        aVar.g(bundle);
                    }
                }
            }
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(String str, String str2, Object obj) {
        if (zzc.zza(str) && zzc.zzd(str, str2)) {
            this.zza.h(str, str2, obj);
        }
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        AbstractC0940s.k(firebaseApp);
        AbstractC0940s.k(context);
        AbstractC0940s.k(subscriber);
        AbstractC0940s.k(context.getApplicationContext());
        if (zzc == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                try {
                    if (zzc == null) {
                        Bundle bundle = new Bundle(1);
                        if (firebaseApp.isDefaultApp()) {
                            subscriber.subscribe(DataCollectionDefaultChange.class, zzb.zza, zza.zza);
                            bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                        }
                        zzc = new AnalyticsConnectorImpl(zzfb.zza(context, bundle).zzb());
                    }
                } finally {
                }
            }
        }
        return zzc;
    }
}
