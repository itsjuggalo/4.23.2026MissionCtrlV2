package com.google.android.gms.measurement;

import Q1.a;
import Q1.b;
import Q1.c;
import S1.C0658q3;
import S1.InterfaceC0548c5;
import S1.W3;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class AppMeasurement {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile AppMeasurement f10058b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f10059a;

    public static class ConditionalUserProperty {
        public boolean mActive;
        public String mAppId;
        public long mCreationTimestamp;
        public String mExpiredEventName;
        public Bundle mExpiredEventParams;
        public String mName;
        public String mOrigin;
        public long mTimeToLive;
        public String mTimedOutEventName;
        public Bundle mTimedOutEventParams;
        public String mTriggerEventName;
        public long mTriggerTimeout;
        public String mTriggeredEventName;
        public Bundle mTriggeredEventParams;
        public long mTriggeredTimestamp;
        public Object mValue;

        public ConditionalUserProperty(Bundle bundle) {
            AbstractC0940s.k(bundle);
            this.mAppId = (String) W3.b(bundle, "app_id", String.class, null);
            this.mOrigin = (String) W3.b(bundle, FirebaseAnalytics.Param.ORIGIN, String.class, null);
            this.mName = (String) W3.b(bundle, "name", String.class, null);
            this.mValue = W3.b(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) W3.b(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) W3.b(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) W3.b(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) W3.b(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) W3.b(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) W3.b(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) W3.b(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) W3.b(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) W3.b(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) W3.b(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) W3.b(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) W3.b(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }
    }

    public AppMeasurement(C0658q3 c0658q3) {
        this.f10059a = new a(c0658q3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        if (f10058b == null) {
            synchronized (AppMeasurement.class) {
                if (f10058b == null) {
                    InterfaceC0548c5 interfaceC0548c5 = (InterfaceC0548c5) FirebaseAnalytics.class.getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    if (interfaceC0548c5 != null) {
                        f10058b = new AppMeasurement(interfaceC0548c5);
                    } else {
                        f10058b = new AppMeasurement(C0658q3.O(context, new zzdd(0L, 0L, true, null, null), null));
                    }
                }
            }
        }
        return f10058b;
    }

    public void beginAdUnitExposure(String str) {
        this.f10059a.zzm(str);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.f10059a.zzp(str, str2, bundle);
    }

    public void endAdUnitExposure(String str) {
        this.f10059a.zzn(str);
    }

    public long generateEventId() {
        return this.f10059a.zzl();
    }

    public String getAppInstanceId() {
        return this.f10059a.zzj();
    }

    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List listZzq = this.f10059a.zzq(str, str2);
        ArrayList arrayList = new ArrayList(listZzq == null ? 0 : listZzq.size());
        Iterator it = listZzq.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty((Bundle) it.next()));
        }
        return arrayList;
    }

    public String getCurrentScreenClass() {
        return this.f10059a.zzi();
    }

    public String getCurrentScreenName() {
        return this.f10059a.zzh();
    }

    public String getGmpAppId() {
        return this.f10059a.zzk();
    }

    public int getMaxUserProperties(String str) {
        return this.f10059a.zzr(str);
    }

    public Map<String, Object> getUserProperties(String str, String str2, boolean z4) {
        return this.f10059a.zzd(str, str2, z4);
    }

    public void logEventInternal(String str, String str2, Bundle bundle) {
        this.f10059a.zza(str, str2, bundle);
    }

    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        AbstractC0940s.k(conditionalUserProperty);
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString(FirebaseAnalytics.Param.ORIGIN, str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString("name", str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            W3.a(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString("trigger_event_name", str4);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString("timed_out_event_name", str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString("triggered_event_name", str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString("expired_event_name", str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        c cVar = this.f10059a;
        bundle.putLong("creation_timestamp", conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.mActive);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.mTriggeredTimestamp);
        cVar.zzo(bundle);
    }

    public AppMeasurement(InterfaceC0548c5 interfaceC0548c5) {
        this.f10059a = new b(interfaceC0548c5);
    }
}
