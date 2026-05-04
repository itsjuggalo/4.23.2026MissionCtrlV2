package io.flutter.plugins.firebase.analytics;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import cd.r;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\r2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010!J'\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\u0006\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150\rH\u0002¢\u0006\u0004\b&\u0010\u0010J+\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0011H\u0002¢\u0006\u0004\b'\u0010\u0017J-\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0011H\u0002¢\u0006\u0004\b)\u0010\u0017J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120\rH\u0002¢\u0006\u0004\b*\u0010\u0010J)\u0010-\u001a\u0004\u0018\u00010,2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0011H\u0002¢\u0006\u0004\b-\u0010.J9\u00103\u001a\u00020\n2\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r2\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n01\u0012\u0004\u0012\u00020\n00H\u0002¢\u0006\u0004\b3\u00104J?\u00106\u001a\u00020\n\"\u0004\b\u0000\u001052\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u001a\u00102\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u000001\u0012\u0004\u0012\u00020\n00H\u0002¢\u0006\u0004\b6\u00104J+\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013090\r2\b\u00108\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0004\b:\u0010;J\u0015\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00150\rH\u0016¢\u0006\u0004\b<\u0010\u0010J\u0017\u0010?\u001a\u00020\n2\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\n2\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\bA\u0010@J?\u0010C\u001a\u00020\n2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00112\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n01\u0012\u0004\u0012\u00020\n00H\u0016¢\u0006\u0004\bC\u0010DJ3\u0010E\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n01\u0012\u0004\u0012\u00020\n00H\u0016¢\u0006\u0004\bE\u0010FJ;\u0010G\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u00122\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n01\u0012\u0004\u0012\u00020\n00H\u0016¢\u0006\u0004\bG\u0010HJ1\u0010I\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n01\u0012\u0004\u0012\u00020\n00H\u0016¢\u0006\u0004\bI\u0010JJ)\u0010K\u001a\u00020\n2\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n01\u0012\u0004\u0012\u00020\n00H\u0016¢\u0006\u0004\bK\u0010LJ1\u0010N\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u000e2\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n01\u0012\u0004\u0012\u00020\n00H\u0016¢\u0006\u0004\bN\u0010OJ?\u0010Q\u001a\u00020\n2\u0014\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00112\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n01\u0012\u0004\u0012\u00020\n00H\u0016¢\u0006\u0004\bQ\u0010DJA\u0010R\u001a\u00020\n2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00112\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n01\u0012\u0004\u0012\u00020\n00H\u0016¢\u0006\u0004\bR\u0010DJ+\u0010S\u001a\u00020\n2\u001a\u00102\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001201\u0012\u0004\u0012\u00020\n00H\u0016¢\u0006\u0004\bS\u0010LJ+\u0010T\u001a\u00020\n2\u001a\u00102\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e01\u0012\u0004\u0012\u00020\n00H\u0016¢\u0006\u0004\bT\u0010LJ?\u0010U\u001a\u00020\n2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n01\u0012\u0004\u0012\u00020\n00H\u0016¢\u0006\u0004\bU\u0010DR\u0016\u0010W\u001a\u00020V8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\\¨\u0006]"}, d2 = {"Lio/flutter/plugins/firebase/analytics/FlutterFirebaseAnalyticsPlugin;", "Lio/flutter/plugins/firebase/core/FlutterFirebasePlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugins/firebase/analytics/FirebaseAnalyticsHostApi;", "<init>", "()V", "Lio/flutter/plugin/common/BinaryMessenger;", "messenger", "Landroid/content/Context;", "context", "Lcd/h0;", "initInstance", "(Lio/flutter/plugin/common/BinaryMessenger;Landroid/content/Context;)V", "Lcom/google/android/gms/tasks/Task;", "", "handleGetSessionId", "()Lcom/google/android/gms/tasks/Task;", "", "", "", "arguments", "Ljava/lang/Void;", "handleLogEvent", "(Ljava/util/Map;)Lcom/google/android/gms/tasks/Task;", "userId", "handleSetUserId", "(Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;", "", Constants.ENABLED, "handleSetAnalyticsCollectionEnabled", "(Z)Lcom/google/android/gms/tasks/Task;", Constants.MILLISECONDS, "handleSetSessionTimeoutDuration", "(J)Lcom/google/android/gms/tasks/Task;", "name", "value", "handleSetUserProperty", "(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/tasks/Task;", "handleResetAnalyticsData", "handleSetConsent", Constants.PARAMETERS, "handleSetDefaultEventParameters", "handleGetAppInstanceId", "map", "Landroid/os/Bundle;", "createBundleFromMap", "(Ljava/util/Map;)Landroid/os/Bundle;", "task", "Lkotlin/Function1;", "Lcd/r;", "callback", "handleVoidTaskResult", "(Lcom/google/android/gms/tasks/Task;Lpd/k;)V", "T", "handleTypedTaskResult", "La7/g;", "firebaseApp", "", "getPluginConstantsForFirebaseApp", "(La7/g;)Lcom/google/android/gms/tasks/Task;", "didReinitializeFirebaseCore", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "binding", "onAttachedToEngine", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V", "onDetachedFromEngine", "event", "logEvent", "(Ljava/util/Map;Lpd/k;)V", "setUserId", "(Ljava/lang/String;Lpd/k;)V", "setUserProperty", "(Ljava/lang/String;Ljava/lang/String;Lpd/k;)V", "setAnalyticsCollectionEnabled", "(ZLpd/k;)V", "resetAnalyticsData", "(Lpd/k;)V", "timeout", "setSessionTimeoutDuration", "(JLpd/k;)V", "consent", "setConsent", "setDefaultEventParameters", "getAppInstanceId", "getSessionId", "initiateOnDeviceConversionMeasurement", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "analytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "Lio/flutter/plugin/common/MethodChannel;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "Lio/flutter/plugin/common/BinaryMessenger;", "firebase_analytics_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAppInstanceId$lambda$20(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, pd.k kVar, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleTypedTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPluginConstantsForFirebaseApp$lambda$0(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(new HashMap());
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSessionId$lambda$21(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, pd.k kVar, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleTypedTaskResult(task, kVar);
    }

    private final Task<String> handleGetAppInstanceId() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.e0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleGetAppInstanceId$lambda$11(taskCompletionSource, this);
            }
        });
        Task<String> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleGetAppInstanceId$lambda$11(TaskCompletionSource taskCompletionSource, FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.t.s("analytics");
                firebaseAnalytics = null;
            }
            taskCompletionSource.setResult(Tasks.await(firebaseAnalytics.getAppInstanceId()));
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Long> handleGetSessionId() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.m0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleGetSessionId$lambda$2(taskCompletionSource, this);
            }
        });
        Task<Long> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleGetSessionId$lambda$2(TaskCompletionSource taskCompletionSource, FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.t.s("analytics");
                firebaseAnalytics = null;
            }
            taskCompletionSource.setResult(Tasks.await(firebaseAnalytics.getSessionId()));
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> handleLogEvent(final Map<String, ? extends Object> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.b0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleLogEvent$lambda$3(arguments, this, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleLogEvent$lambda$3(Map map, FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, TaskCompletionSource taskCompletionSource) {
        try {
            Object obj = map.get(Constants.EVENT_NAME);
            Objects.requireNonNull(obj);
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            Bundle bundleCreateBundleFromMap = flutterFirebaseAnalyticsPlugin.createBundleFromMap((Map) map.get(Constants.PARAMETERS));
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.t.s("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.logEvent(str, bundleCreateBundleFromMap);
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> handleResetAnalyticsData() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.h0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleResetAnalyticsData$lambda$8(this.f12608a, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleResetAnalyticsData$lambda$8(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.t.s("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.resetAnalyticsData();
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> handleSetAnalyticsCollectionEnabled(final boolean enabled) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.j0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleSetAnalyticsCollectionEnabled$lambda$5(this.f12614a, enabled, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSetAnalyticsCollectionEnabled$lambda$5(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, boolean z10, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.t.s("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.setAnalyticsCollectionEnabled(z10);
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> handleSetConsent(final Map<String, Boolean> arguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.s0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleSetConsent$lambda$9(arguments, this, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
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
                kotlin.jvm.internal.t.s("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.setConsent(map2);
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> handleSetDefaultEventParameters(final Map<String, ? extends Object> parameters) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.r0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleSetDefaultEventParameters$lambda$10(this.f12641a, parameters, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSetDefaultEventParameters$lambda$10(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.t.s("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.setDefaultEventParameters(flutterFirebaseAnalyticsPlugin.createBundleFromMap(map));
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> handleSetSessionTimeoutDuration(final long milliseconds) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.g0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleSetSessionTimeoutDuration$lambda$6(this.f12604a, milliseconds, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSetSessionTimeoutDuration$lambda$6(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, long j10, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.t.s("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.setSessionTimeoutDuration(j10);
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> handleSetUserId(final String userId) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.q0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleSetUserId$lambda$4(this.f12638a, userId, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSetUserId$lambda$4(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, String str, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.t.s("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.setUserId(str);
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final Task<Void> handleSetUserProperty(final String name, final String value) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.l0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.handleSetUserProperty$lambda$7(this.f12621a, name, value, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSetUserProperty$lambda$7(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, String str, String str2, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAnalytics firebaseAnalytics = flutterFirebaseAnalyticsPlugin.analytics;
            if (firebaseAnalytics == null) {
                kotlin.jvm.internal.t.s("analytics");
                firebaseAnalytics = null;
            }
            firebaseAnalytics.setUserProperty(str, str2);
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final <T> void handleTypedTaskResult(Task<T> task, pd.k callback) {
        String message;
        if (task.isSuccessful()) {
            r.a aVar = r.f3870b;
            callback.invoke(r.a(r.b(task.getResult())));
            return;
        }
        Exception exception = task.getException();
        if (exception == null || (message = exception.getMessage()) == null) {
            message = FlutterFirebaseDatabaseException.UNKNOWN_ERROR_MESSAGE;
        }
        r.a aVar2 = r.f3870b;
        callback.invoke(r.a(r.b(cd.s.a(new FlutterError("firebase_analytics", message, null)))));
    }

    private final void handleVoidTaskResult(Task<Void> task, pd.k callback) {
        String message;
        if (task.isSuccessful()) {
            r.a aVar = r.f3870b;
            callback.invoke(r.a(r.b(cd.h0.f3852a)));
            return;
        }
        Exception exception = task.getException();
        if (exception == null || (message = exception.getMessage()) == null) {
            message = FlutterFirebaseDatabaseException.UNKNOWN_ERROR_MESSAGE;
        }
        r.a aVar2 = r.f3870b;
        callback.invoke(r.a(r.b(cd.s.a(new FlutterError("firebase_analytics", message, null)))));
    }

    private final void initInstance(BinaryMessenger messenger, Context context) {
        this.analytics = FirebaseAnalytics.getInstance(context);
        this.channel = new MethodChannel(messenger, "plugins.flutter.io/firebase_analytics");
        FirebaseAnalyticsHostApi.Companion.setUp$default(FirebaseAnalyticsHostApi.INSTANCE, messenger, this, null, 4, null);
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_analytics", this);
        this.messenger = messenger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logEvent$lambda$12(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, pd.k kVar, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetAnalyticsData$lambda$16(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, pd.k kVar, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setAnalyticsCollectionEnabled$lambda$15(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, pd.k kVar, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setConsent$lambda$18(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, pd.k kVar, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDefaultEventParameters$lambda$19(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, pd.k kVar, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSessionTimeoutDuration$lambda$17(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, pd.k kVar, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUserId$lambda$13(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, pd.k kVar, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUserProperty$lambda$14(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, pd.k kVar, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        flutterFirebaseAnalyticsPlugin.handleVoidTaskResult(task, kVar);
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.f0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.didReinitializeFirebaseCore$lambda$1(taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void getAppInstanceId(final pd.k callback) {
        kotlin.jvm.internal.t.f(callback, "callback");
        handleGetAppInstanceId().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.p0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.getAppInstanceId$lambda$20(this.f12635a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(a7.g firebaseApp) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.analytics.d0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAnalyticsPlugin.getPluginConstantsForFirebaseApp$lambda$0(taskCompletionSource);
            }
        });
        Task<Map<String, Object>> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void getSessionId(final pd.k callback) {
        kotlin.jvm.internal.t.f(callback, "callback");
        handleGetSessionId().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.y
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.getSessionId$lambda$21(this.f12655a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void initiateOnDeviceConversionMeasurement(Map<String, String> arguments, pd.k callback) {
        kotlin.jvm.internal.t.f(arguments, "arguments");
        kotlin.jvm.internal.t.f(callback, "callback");
        r.a aVar = r.f3870b;
        callback.invoke(r.a(r.b(cd.s.a(new FlutterError("unimplemented", "initiateOnDeviceConversionMeasurement is only available on iOS.", null)))));
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void logEvent(Map<String, ? extends Object> event, final pd.k callback) {
        kotlin.jvm.internal.t.f(event, "event");
        kotlin.jvm.internal.t.f(callback, "callback");
        handleLogEvent(event).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.c0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.logEvent$lambda$12(this.f12595a, callback, task);
            }
        });
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.t.f(binding, "binding");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        kotlin.jvm.internal.t.e(binaryMessenger, "getBinaryMessenger(...)");
        Context applicationContext = binding.getApplicationContext();
        kotlin.jvm.internal.t.e(applicationContext, "getApplicationContext(...)");
        initInstance(binaryMessenger, applicationContext);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.t.f(binding, "binding");
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
        }
        BinaryMessenger binaryMessenger = this.messenger;
        if (binaryMessenger == null) {
            throw new IllegalStateException("Required value was null.");
        }
        FirebaseAnalyticsHostApi.Companion companion = FirebaseAnalyticsHostApi.INSTANCE;
        kotlin.jvm.internal.t.c(binaryMessenger);
        FirebaseAnalyticsHostApi.Companion.setUp$default(companion, binaryMessenger, null, null, 4, null);
        this.channel = null;
        this.messenger = null;
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void resetAnalyticsData(final pd.k callback) {
        kotlin.jvm.internal.t.f(callback, "callback");
        handleResetAnalyticsData().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.a0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.resetAnalyticsData$lambda$16(this.f12588a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void setAnalyticsCollectionEnabled(boolean enabled, final pd.k callback) {
        kotlin.jvm.internal.t.f(callback, "callback");
        handleSetAnalyticsCollectionEnabled(enabled).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.k0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.setAnalyticsCollectionEnabled$lambda$15(this.f12618a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void setConsent(Map<String, Boolean> consent, final pd.k callback) {
        kotlin.jvm.internal.t.f(consent, "consent");
        kotlin.jvm.internal.t.f(callback, "callback");
        handleSetConsent(consent).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.t0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.setConsent$lambda$18(this.f12649a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void setDefaultEventParameters(Map<String, ? extends Object> parameters, final pd.k callback) {
        kotlin.jvm.internal.t.f(callback, "callback");
        handleSetDefaultEventParameters(parameters).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.z
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.setDefaultEventParameters$lambda$19(this.f12657a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void setSessionTimeoutDuration(long timeout, final pd.k callback) {
        kotlin.jvm.internal.t.f(callback, "callback");
        handleSetSessionTimeoutDuration(timeout).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.o0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.setSessionTimeoutDuration$lambda$17(this.f12632a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void setUserId(String userId, final pd.k callback) {
        kotlin.jvm.internal.t.f(callback, "callback");
        handleSetUserId(userId).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.n0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.setUserId$lambda$13(this.f12629a, callback, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi
    public void setUserProperty(String name, String value, final pd.k callback) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(callback, "callback");
        handleSetUserProperty(name, value).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.analytics.i0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAnalyticsPlugin.setUserProperty$lambda$14(this.f12611a, callback, task);
            }
        });
    }
}
