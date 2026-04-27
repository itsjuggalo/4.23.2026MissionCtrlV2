package io.flutter.plugins.firebase.analytics;

import W2.p;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class FlutterFirebaseAnalyticsPlugin implements FlutterFirebasePlugin, FlutterPlugin, FirebaseAnalyticsHostApi {
    private FirebaseAnalytics analytics;
    private MethodChannel channel;
    private BinaryMessenger messenger;

    private final Bundle createBundleFromMap(Map<String, ? extends Object> map) {
        if (map == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                bundle.putString(key, (String) value);
            } else if (value instanceof Integer) {
                bundle.putLong(key, ((Number) value).intValue());
            } else if (value instanceof Long) {
                bundle.putLong(key, ((Number) value).longValue());
            } else if (value instanceof Double) {
                bundle.putDouble(key, ((Number) value).doubleValue());
            } else if (value instanceof Boolean) {
                bundle.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value == null) {
                bundle.putString(key, null);
            } else if (value instanceof Iterable) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (Object obj : (Iterable) value) {
                    if (obj instanceof Map) {
                        arrayList.add(createBundleFromMap((Map) obj));
                    } else if (obj != null) {
                        throw new IllegalArgumentException("Unsupported value type: " + obj.getClass().getCanonicalName() + " in list at key " + key);
                    }
                }
                bundle.putParcelableArrayList(key, arrayList);
            } else {
                if (!(value instanceof Map)) {
                    throw new IllegalArgumentException("Unsupported value type: " + value.getClass().getCanonicalName());
                }
                bundle.putParcelable(key, createBundleFromMap((Map) value));
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void didReinitializeFirebaseCore$lambda$1(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAppInstanceId$lambda$20(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, i3.k kVar, Task task) {
        kotlin.jvm.internal.r.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleTypedTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPluginConstantsForFirebaseApp$lambda$0(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(new HashMap());
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSessionId$lambda$21(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, i3.k kVar, Task task) {
        kotlin.jvm.internal.r.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleTypedTaskResult(task, kVar);
    }

    private final Task<String> handleGetAppInstanceId() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.D
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleGetAppInstanceId$lambda$11(taskCompletionSource, this);
            }
        });
        Task<String> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.r.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleGetAppInstanceId$lambda$11(TaskCompletionSource taskCompletionSource, FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.r.t("analytics");
                firebaseAnalytics = null;
            }
            taskCompletionSource.setResult(Tasks.await(firebaseAnalytics.getAppInstanceId()));
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private final Task<Long> handleGetSessionId() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.L
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleGetSessionId$lambda$2(taskCompletionSource, this);
            }
        });
        Task<Long> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.r.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleGetSessionId$lambda$2(TaskCompletionSource taskCompletionSource, FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.r.t("analytics");
                firebaseAnalytics = null;
            }
            taskCompletionSource.setResult(Tasks.await(firebaseAnalytics.getSessionId()));
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private final Task<Void> handleLogEvent(final Map<String, ? extends Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.A
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleLogEvent$lambda$3(map, this, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.r.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleLogEvent$lambda$3(Map map, FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, TaskCompletionSource taskCompletionSource) {
        try {
            Object obj = map.get(Constants.EVENT_NAME);
            Objects.requireNonNull(obj);
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            Bundle bundleCreateBundleFromMap = flutterFirebaseAnalyticsPlugin.createBundleFromMap((Map) map.get(Constants.PARAMETERS));
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.r.t("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.logEvent(str, bundleCreateBundleFromMap);
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private final Task<Void> handleResetAnalyticsData() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.G
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleResetAnalyticsData$lambda$8(this.f12329a, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.r.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleResetAnalyticsData$lambda$8(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.r.t("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.resetAnalyticsData();
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private final Task<Void> handleSetAnalyticsCollectionEnabled(final boolean z4) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.I
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleSetAnalyticsCollectionEnabled$lambda$5(this.f12333a, z4, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.r.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSetAnalyticsCollectionEnabled$lambda$5(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, boolean z4, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.r.t("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.setAnalyticsCollectionEnabled(z4);
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private final Task<Void> handleSetConsent(final Map<String, Boolean> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.S
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleSetConsent$lambda$9(map, this, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.r.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSetConsent$lambda$9(Map map, FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, TaskCompletionSource taskCompletionSource) {
        try {
            Boolean bool = (Boolean) map.get(Constants.AD_STORAGE_CONSENT_GRANTED);
            Boolean bool2 = (Boolean) map.get(Constants.ANALYTICS_STORAGE_CONSENT_GRANTED);
            Boolean bool3 = (Boolean) map.get(Constants.AD_PERSONALIZATION_SIGNALS_CONSENT_GRANTED);
            Boolean bool4 = (Boolean) map.get(Constants.AD_USER_DATA_CONSENT_GRANTED);
            HashMap map2 = new HashMap();
            if (bool != null) {
                map2.put(FirebaseAnalytics.ConsentType.AD_STORAGE, bool.booleanValue() ? FirebaseAnalytics.ConsentStatus.GRANTED : FirebaseAnalytics.ConsentStatus.DENIED);
            }
            if (bool2 != null) {
                map2.put(FirebaseAnalytics.ConsentType.ANALYTICS_STORAGE, bool2.booleanValue() ? FirebaseAnalytics.ConsentStatus.GRANTED : FirebaseAnalytics.ConsentStatus.DENIED);
            }
            if (bool3 != null) {
                map2.put(FirebaseAnalytics.ConsentType.AD_PERSONALIZATION, bool3.booleanValue() ? FirebaseAnalytics.ConsentStatus.GRANTED : FirebaseAnalytics.ConsentStatus.DENIED);
            }
            if (bool4 != null) {
                map2.put(FirebaseAnalytics.ConsentType.AD_USER_DATA, bool4.booleanValue() ? FirebaseAnalytics.ConsentStatus.GRANTED : FirebaseAnalytics.ConsentStatus.DENIED);
            }
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.r.t("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.setConsent(map2);
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private final Task<Void> handleSetDefaultEventParameters(final Map<String, ? extends Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.Q
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleSetDefaultEventParameters$lambda$10(this.f12353a, map, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.r.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSetDefaultEventParameters$lambda$10(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.r.t("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.setDefaultEventParameters(flutterFirebaseAnalyticsPlugin.createBundleFromMap(map));
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private final Task<Void> handleSetSessionTimeoutDuration(final long j4) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.F
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleSetSessionTimeoutDuration$lambda$6(this.f12326a, j4, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.r.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSetSessionTimeoutDuration$lambda$6(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, long j4, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.r.t("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.setSessionTimeoutDuration(j4);
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private final Task<Void> handleSetUserId(final String str) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.P
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleSetUserId$lambda$4(this.f12350a, str, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.r.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSetUserId$lambda$4(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, String str, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.r.t("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.setUserId(str);
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private final Task<Void> handleSetUserProperty(final String str, final String str2) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.K
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleSetUserProperty$lambda$7(this.f12338a, str, str2, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.r.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSetUserProperty$lambda$7(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, String str, String str2, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.r.t("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.setUserProperty(str, str2);
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private final <T> void handleTypedTaskResult(Task<T> task, i3.k kVar) {
        String message;
        if (task.isSuccessful()) {
            p.a aVar = W2.p.f5487b;
            kVar.invoke(W2.p.a(W2.p.b(task.getResult())));
            return;
        }
        Exception exception = task.getException();
        if (exception == null || (message = exception.getMessage()) == null) {
            message = "An unknown error occurred";
        }
        p.a aVar2 = W2.p.f5487b;
        kVar.invoke(W2.p.a(W2.p.b(W2.q.a(new FlutterError("firebase_analytics", message, null)))));
    }

    private final void handleVoidTaskResult(Task<Void> task, i3.k kVar) {
        String message;
        if (task.isSuccessful()) {
            p.a aVar = W2.p.f5487b;
            kVar.invoke(W2.p.a(W2.p.b(W2.E.f5463a)));
            return;
        }
        Exception exception = task.getException();
        if (exception == null || (message = exception.getMessage()) == null) {
            message = "An unknown error occurred";
        }
        p.a aVar2 = W2.p.f5487b;
        kVar.invoke(W2.p.a(W2.p.b(W2.q.a(new FlutterError("firebase_analytics", message, null)))));
    }

    private final void initInstance(BinaryMessenger binaryMessenger, Context context) {
        this.analytics = FirebaseAnalytics.getInstance(context);
        this.channel = new MethodChannel(binaryMessenger, "plugins.flutter.io/firebase_analytics");
        FirebaseAnalyticsHostApi.Companion.setUp$default(FirebaseAnalyticsHostApi.Companion, binaryMessenger, this, null, 4, null);
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_analytics", this);
        this.messenger = binaryMessenger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logEvent$lambda$12(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, i3.k kVar, Task task) {
        kotlin.jvm.internal.r.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetAnalyticsData$lambda$16(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, i3.k kVar, Task task) {
        kotlin.jvm.internal.r.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setAnalyticsCollectionEnabled$lambda$15(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, i3.k kVar, Task task) {
        kotlin.jvm.internal.r.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setConsent$lambda$18(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, i3.k kVar, Task task) {
        kotlin.jvm.internal.r.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDefaultEventParameters$lambda$19(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, i3.k kVar, Task task) {
        kotlin.jvm.internal.r.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSessionTimeoutDuration$lambda$17(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, i3.k kVar, Task task) {
        kotlin.jvm.internal.r.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUserId$lambda$13(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, i3.k kVar, Task task) {
        kotlin.jvm.internal.r.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUserProperty$lambda$14(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, i3.k kVar, Task task) {
        kotlin.jvm.internal.r.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.E
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.didReinitializeFirebaseCore$lambda$1(taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.r.e(task, "getTask(...)");
        return task;
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void getAppInstanceId(final i3.k callback) {
        kotlin.jvm.internal.r.f(callback, "callback");
        handleGetAppInstanceId().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.O
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.getAppInstanceId$lambda$20(this.f12348a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.C
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.getPluginConstantsForFirebaseApp$lambda$0(taskCompletionSource);
            }
        });
        Task<Map<String, Object>> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.r.e(task, "getTask(...)");
        return task;
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void getSessionId(final i3.k callback) {
        kotlin.jvm.internal.r.f(callback, "callback");
        handleGetSessionId().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.x
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.getSessionId$lambda$21(this.f12383a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void initiateOnDeviceConversionMeasurement(Map<String, String> arguments, i3.k callback) {
        kotlin.jvm.internal.r.f(arguments, "arguments");
        kotlin.jvm.internal.r.f(callback, "callback");
        p.a aVar = W2.p.f5487b;
        callback.invoke(W2.p.a(W2.p.b(W2.q.a(new FlutterError("unimplemented", "initiateOnDeviceConversionMeasurement is only available on iOS.", null)))));
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void logEvent(Map<String, ? extends Object> event, final i3.k callback) {
        kotlin.jvm.internal.r.f(event, "event");
        kotlin.jvm.internal.r.f(callback, "callback");
        handleLogEvent(event).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.B
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.logEvent$lambda$12(this.f12320a, callback, task);
            }
        });
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.r.f(binding, "binding");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        kotlin.jvm.internal.r.e(binaryMessenger, "getBinaryMessenger(...)");
        Context applicationContext = binding.getApplicationContext();
        kotlin.jvm.internal.r.e(applicationContext, "getApplicationContext(...)");
        initInstance(binaryMessenger, applicationContext);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.r.f(binding, "binding");
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
        }
        BinaryMessenger binaryMessenger = this.messenger;
        if (binaryMessenger == null) {
            throw new IllegalStateException("Required value was null.");
        }
        FirebaseAnalyticsHostApi.Companion companion = FirebaseAnalyticsHostApi.Companion;
        kotlin.jvm.internal.r.c(binaryMessenger);
        FirebaseAnalyticsHostApi.Companion.setUp$default(companion, binaryMessenger, null, null, 4, null);
        this.channel = null;
        this.messenger = null;
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void resetAnalyticsData(final i3.k callback) {
        kotlin.jvm.internal.r.f(callback, "callback");
        handleResetAnalyticsData().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.z
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.resetAnalyticsData$lambda$16(this.f12387a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void setAnalyticsCollectionEnabled(boolean z4, final i3.k callback) {
        kotlin.jvm.internal.r.f(callback, "callback");
        handleSetAnalyticsCollectionEnabled(z4).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.J
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.setAnalyticsCollectionEnabled$lambda$15(this.f12336a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void setConsent(Map<String, Boolean> consent, final i3.k callback) {
        kotlin.jvm.internal.r.f(consent, "consent");
        kotlin.jvm.internal.r.f(callback, "callback");
        handleSetConsent(consent).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.T
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.setConsent$lambda$18(this.f12359a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void setDefaultEventParameters(Map<String, ? extends Object> map, final i3.k callback) {
        kotlin.jvm.internal.r.f(callback, "callback");
        handleSetDefaultEventParameters(map).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.y
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.setDefaultEventParameters$lambda$19(this.f12385a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void setSessionTimeoutDuration(long j4, final i3.k callback) {
        kotlin.jvm.internal.r.f(callback, "callback");
        handleSetSessionTimeoutDuration(j4).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.N
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.setSessionTimeoutDuration$lambda$17(this.f12346a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void setUserId(String str, final i3.k callback) {
        kotlin.jvm.internal.r.f(callback, "callback");
        handleSetUserId(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.M
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.setUserId$lambda$13(this.f12344a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void setUserProperty(String name, String str, final i3.k callback) {
        kotlin.jvm.internal.r.f(name, "name");
        kotlin.jvm.internal.r.f(callback, "callback");
        handleSetUserProperty(name, str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.H
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.setUserProperty$lambda$14(this.f12331a, callback, task);
            }
        });
    }
}
