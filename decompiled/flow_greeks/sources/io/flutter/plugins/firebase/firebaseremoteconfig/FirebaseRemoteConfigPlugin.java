package io.flutter.plugins.firebase.firebaseremoteconfig;

import android.os.Handler;
import android.os.Looper;
import cd.h0;
import cd.r;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.firebase.analytics.Constants;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigHostApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import pa.e;
import pa.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 `2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001`B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0006J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001c0\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010 \u001a\u00020\u001cH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020#H\u0002¢\u0006\u0004\b(\u0010&J\u000f\u0010)\u001a\u00020\u0010H\u0002¢\u0006\u0004\b)\u0010\u0006J?\u00101\u001a\u00020\u0010\"\u0004\b\u0000\u0010*2\u0018\u0010-\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,\u0012\u0004\u0012\u00020\u00100+2\u000e\u00100\u001a\n\u0018\u00010.j\u0004\u0018\u0001`/H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00102\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00102\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b7\u00106J)\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u00182\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J\u0015\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016¢\u0006\u0004\b<\u0010=J\u001f\u0010A\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bA\u0010BJ\u0019\u0010C\u001a\u00020\u00102\b\u0010>\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\bC\u0010DJ1\u0010E\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\n2\u0018\u0010-\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100,\u0012\u0004\u0012\u00020\u00100+H\u0016¢\u0006\u0004\bE\u0010FJ1\u0010H\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\n2\u0018\u0010-\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0,\u0012\u0004\u0012\u00020\u00100+H\u0016¢\u0006\u0004\bH\u0010FJ1\u0010I\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\n2\u0018\u0010-\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0,\u0012\u0004\u0012\u00020\u00100+H\u0016¢\u0006\u0004\bI\u0010FJ9\u0010L\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010K\u001a\u00020J2\u0018\u0010-\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100,\u0012\u0004\u0012\u00020\u00100+H\u0016¢\u0006\u0004\bL\u0010MJG\u0010O\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\n2\u0014\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0018\u0010-\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100,\u0012\u0004\u0012\u00020\u00100+H\u0016¢\u0006\u0004\bO\u0010PJ1\u0010Q\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\n2\u0018\u0010-\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100,\u0012\u0004\u0012\u00020\u00100+H\u0016¢\u0006\u0004\bQ\u0010FJG\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\n2\u0014\u0010R\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t2\u0018\u0010-\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100,\u0012\u0004\u0012\u00020\u00100+H\u0016¢\u0006\u0004\b\u001a\u0010PJ?\u0010S\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\n2&\u0010-\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t0,\u0012\u0004\u0012\u00020\u00100+H\u0016¢\u0006\u0004\bS\u0010FJ=\u0010T\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\n2$\u0010-\u001a \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0,\u0012\u0004\u0012\u00020\u00100+H\u0016¢\u0006\u0004\bT\u0010FR \u0010W\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020V0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010_¨\u0006a"}, d2 = {"Lio/flutter/plugins/firebase/firebaseremoteconfig/FirebaseRemoteConfigPlugin;", "Lio/flutter/plugins/firebase/core/FlutterFirebasePlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "Lio/flutter/plugins/firebase/firebaseremoteconfig/FirebaseRemoteConfigHostApi;", "<init>", "()V", "Lpa/o;", "remoteConfig", "", "", "", "getConfigProperties", "(Lpa/o;)Ljava/util/Map;", "Lio/flutter/plugin/common/BinaryMessenger;", "messenger", "Lcd/h0;", "setupChannel", "(Lio/flutter/plugin/common/BinaryMessenger;)V", "tearDownChannel", "appName", "getRemoteConfig", "(Ljava/lang/String;)Lpa/o;", "customSignalsArguments", "Lcom/google/android/gms/tasks/Task;", "Ljava/lang/Void;", "setCustomSignals", "(Lpa/o;Ljava/util/Map;)Lcom/google/android/gms/tasks/Task;", "Lpa/v;", Constants.PARAMETERS, "parseParameters", "(Ljava/util/Map;)Ljava/util/Map;", "remoteConfigValue", "createRemoteConfigValueMap", "(Lpa/v;)Ljava/util/Map;", "", "status", "mapLastFetchStatus", "(I)Ljava/lang/String;", FirebaseAnalytics.Param.SOURCE, "mapValueSource", "removeEventListeners", "T", "Lkotlin/Function1;", "Lcd/r;", "callback", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "handleFailure", "(Lpd/k;Ljava/lang/Exception;)V", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "binding", "onAttachedToEngine", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V", "onDetachedFromEngine", "La7/g;", "firebaseApp", "getPluginConstantsForFirebaseApp", "(La7/g;)Lcom/google/android/gms/tasks/Task;", "didReinitializeFirebaseCore", "()Lcom/google/android/gms/tasks/Task;", "arguments", "Lio/flutter/plugin/common/EventChannel$EventSink;", "events", "onListen", "(Ljava/lang/Object;Lio/flutter/plugin/common/EventChannel$EventSink;)V", "onCancel", "(Ljava/lang/Object;)V", "fetch", "(Ljava/lang/String;Lpd/k;)V", "", "fetchAndActivate", "activate", "Lio/flutter/plugins/firebase/firebaseremoteconfig/RemoteConfigPigeonSettings;", "settings", "setConfigSettings", "(Ljava/lang/String;Lio/flutter/plugins/firebase/firebaseremoteconfig/RemoteConfigPigeonSettings;Lpd/k;)V", "defaultParameters", "setDefaults", "(Ljava/lang/String;Ljava/util/Map;Lpd/k;)V", "ensureInitialized", "customSignals", "getAll", "getProperties", "", "Lpa/d;", "listenersMap", "Ljava/util/Map;", "Lio/flutter/plugin/common/EventChannel;", "eventChannel", "Lio/flutter/plugin/common/EventChannel;", "Landroid/os/Handler;", "mainThreadHandler", "Landroid/os/Handler;", "Lio/flutter/plugin/common/BinaryMessenger;", "Companion", "firebase_remote_config_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FirebaseRemoteConfigPlugin implements FlutterFirebasePlugin, FlutterPlugin, EventChannel.StreamHandler, FirebaseRemoteConfigHostApi {
    public static final String EVENT_CHANNEL = "plugins.flutter.io/firebase_remote_config_updated";
    public static final String METHOD_CHANNEL = "plugins.flutter.io/firebase_remote_config";
    public static final String TAG = "FRCPlugin";
    private EventChannel eventChannel;
    private final Map<String, pa.d> listenersMap = new HashMap();
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private BinaryMessenger messenger;

    /* JADX INFO: renamed from: io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigPlugin$onListen$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"io/flutter/plugins/firebase/firebaseremoteconfig/FirebaseRemoteConfigPlugin$onListen$1", "Lpa/c;", "Lpa/b;", "configUpdate", "Lcd/h0;", "onUpdate", "(Lpa/b;)V", "Lpa/q;", "error", "onError", "(Lpa/q;)V", "firebase_remote_config_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements pa.c {
        final /* synthetic */ EventChannel.EventSink $events;

        public AnonymousClass1(EventChannel.EventSink eventSink) {
            this.$events = eventSink;
        }

        @Override // pa.c
        public void onError(pa.q error) {
            kotlin.jvm.internal.t.f(error, "error");
            this.$events.error("firebase_remote_config", error.getMessage(), null);
        }

        @Override // pa.c
        public void onUpdate(pa.b configUpdate) {
            kotlin.jvm.internal.t.f(configUpdate, "configUpdate");
            final ArrayList arrayList = new ArrayList(configUpdate.b());
            Handler handler = FirebaseRemoteConfigPlugin.this.mainThreadHandler;
            final EventChannel.EventSink eventSink = this.$events;
            handler.post(new Runnable() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.e0
                @Override // java.lang.Runnable
                public final void run() {
                    eventSink.success(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void activate$lambda$5(pd.k kVar, FirebaseRemoteConfigPlugin firebaseRemoteConfigPlugin, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        if (!task.isSuccessful()) {
            firebaseRemoteConfigPlugin.handleFailure(kVar, task.getException());
        } else {
            r.a aVar = r.f3870b;
            kVar.invoke(r.a(r.b(task.getResult())));
        }
    }

    private final Map<String, Object> createRemoteConfigValueMap(pa.v remoteConfigValue) {
        HashMap map = new HashMap();
        map.put("value", remoteConfigValue.a());
        map.put(FirebaseAnalytics.Param.SOURCE, mapValueSource(remoteConfigValue.j()));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void didReinitializeFirebaseCore$lambda$1(FirebaseRemoteConfigPlugin firebaseRemoteConfigPlugin, TaskCompletionSource taskCompletionSource) {
        try {
            firebaseRemoteConfigPlugin.removeEventListeners();
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureInitialized$lambda$8(pd.k kVar, FirebaseRemoteConfigPlugin firebaseRemoteConfigPlugin, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        if (!task.isSuccessful()) {
            firebaseRemoteConfigPlugin.handleFailure(kVar, task.getException());
        } else {
            r.a aVar = r.f3870b;
            kVar.invoke(r.a(r.b(h0.f3852a)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetch$lambda$3(pd.k kVar, FirebaseRemoteConfigPlugin firebaseRemoteConfigPlugin, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        if (!task.isSuccessful()) {
            firebaseRemoteConfigPlugin.handleFailure(kVar, task.getException());
        } else {
            r.a aVar = r.f3870b;
            kVar.invoke(r.a(r.b(h0.f3852a)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchAndActivate$lambda$4(pd.k kVar, FirebaseRemoteConfigPlugin firebaseRemoteConfigPlugin, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        if (!task.isSuccessful()) {
            firebaseRemoteConfigPlugin.handleFailure(kVar, task.getException());
        } else {
            r.a aVar = r.f3870b;
            kVar.invoke(r.a(r.b(task.getResult())));
        }
    }

    private final Map<String, Object> getConfigProperties(pa.o remoteConfig) {
        HashMap map = new HashMap();
        map.put("fetchTimeout", Long.valueOf(remoteConfig.o().c().a()));
        map.put("minimumFetchInterval", Long.valueOf(remoteConfig.o().c().b()));
        map.put("lastFetchTime", Long.valueOf(remoteConfig.o().b()));
        map.put("lastFetchStatus", mapLastFetchStatus(remoteConfig.o().a()));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPluginConstantsForFirebaseApp$lambda$0(a7.g gVar, FirebaseRemoteConfigPlugin firebaseRemoteConfigPlugin, TaskCompletionSource taskCompletionSource) {
        try {
            pa.o oVarP = pa.o.p(gVar);
            kotlin.jvm.internal.t.e(oVarP, "getInstance(...)");
            HashMap map = new HashMap(firebaseRemoteConfigPlugin.getConfigProperties(oVarP));
            Map mapN = oVarP.n();
            kotlin.jvm.internal.t.e(mapN, "getAll(...)");
            map.put(Constants.PARAMETERS, firebaseRemoteConfigPlugin.parseParameters(mapN));
            taskCompletionSource.setResult(map);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private final pa.o getRemoteConfig(String appName) {
        a7.g gVarP = a7.g.p(appName);
        kotlin.jvm.internal.t.e(gVarP, "getInstance(...)");
        pa.o oVarP = pa.o.p(gVarP);
        kotlin.jvm.internal.t.e(oVarP, "getInstance(...)");
        return oVarP;
    }

    private final <T> void handleFailure(pd.k callback, Exception exception) {
        String message;
        HashMap map = new HashMap();
        if (exception instanceof pa.r) {
            map.put(io.flutter.plugins.firebase.database.Constants.ERROR_CODE, "throttled");
            map.put(io.flutter.plugins.firebase.database.Constants.ERROR_MESSAGE, "frequency of requests exceeds throttled limits");
        } else if (exception instanceof pa.p) {
            map.put(io.flutter.plugins.firebase.database.Constants.ERROR_CODE, "internal");
            map.put(io.flutter.plugins.firebase.database.Constants.ERROR_MESSAGE, "internal remote config fetch error");
        } else if (exception instanceof pa.t) {
            map.put(io.flutter.plugins.firebase.database.Constants.ERROR_CODE, "remote-config-server-error");
            pa.t tVar = (pa.t) exception;
            map.put(io.flutter.plugins.firebase.database.Constants.ERROR_MESSAGE, tVar.getMessage());
            Throwable cause = tVar.getCause();
            if (cause != null && (message = cause.getMessage()) != null && kg.c0.P(message, "Forbidden", false, 2, null)) {
                map.put(io.flutter.plugins.firebase.database.Constants.ERROR_CODE, "forbidden");
            }
        } else {
            map.put(io.flutter.plugins.firebase.database.Constants.ERROR_CODE, FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE);
            map.put(io.flutter.plugins.firebase.database.Constants.ERROR_MESSAGE, "unknown remote config error");
        }
        r.a aVar = r.f3870b;
        callback.invoke(r.a(r.b(cd.s.a(new FlutterError("firebase_remote_config", exception != null ? exception.getMessage() : null, map)))));
    }

    private final String mapLastFetchStatus(int status) {
        return status != -1 ? status != 0 ? (status == 1 || status != 2) ? "failure" : "throttled" : "noFetchYet" : "success";
    }

    private final String mapValueSource(int source) {
        return source != 0 ? source != 1 ? source != 2 ? "static" : "remote" : "default" : "static";
    }

    private final Map<String, Object> parseParameters(Map<String, ? extends pa.v> parameters) {
        HashMap map = new HashMap();
        for (String str : parameters.keySet()) {
            pa.v vVar = parameters.get(str);
            kotlin.jvm.internal.t.c(vVar);
            map.put(str, createRemoteConfigValueMap(vVar));
        }
        return map;
    }

    private final void removeEventListeners() {
        Iterator<pa.d> it = this.listenersMap.values().iterator();
        while (it.hasNext()) {
            it.next().remove();
        }
        this.listenersMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setConfigSettings$lambda$6(pd.k kVar, FirebaseRemoteConfigPlugin firebaseRemoteConfigPlugin, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        if (!task.isSuccessful()) {
            firebaseRemoteConfigPlugin.handleFailure(kVar, task.getException());
        } else {
            r.a aVar = r.f3870b;
            kVar.invoke(r.a(r.b(h0.f3852a)));
        }
    }

    private final Task<Void> setCustomSignals(final pa.o remoteConfig, final Map<String, ? extends Object> customSignalsArguments) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.v
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseRemoteConfigPlugin.setCustomSignals$lambda$2(customSignalsArguments, remoteConfig, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCustomSignals$lambda$2(Map map, pa.o oVar, TaskCompletionSource taskCompletionSource) {
        try {
            e.a aVar = new e.a();
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    aVar.e(str, (String) value);
                } else if (value instanceof Long) {
                    aVar.d(str, ((Number) value).longValue());
                } else if (value instanceof Integer) {
                    aVar.d(str, ((Number) value).intValue());
                } else if (value instanceof Double) {
                    aVar.c(str, ((Number) value).doubleValue());
                } else if (value == null) {
                    aVar.e(str, null);
                }
            }
            Tasks.await(oVar.v(aVar.b()));
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCustomSignals$lambda$9(pd.k kVar, FirebaseRemoteConfigPlugin firebaseRemoteConfigPlugin, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        if (!task.isSuccessful()) {
            firebaseRemoteConfigPlugin.handleFailure(kVar, task.getException());
        } else {
            r.a aVar = r.f3870b;
            kVar.invoke(r.a(r.b(h0.f3852a)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDefaults$lambda$7(pd.k kVar, FirebaseRemoteConfigPlugin firebaseRemoteConfigPlugin, Task task) {
        kotlin.jvm.internal.t.f(task, "task");
        if (!task.isSuccessful()) {
            firebaseRemoteConfigPlugin.handleFailure(kVar, task.getException());
        } else {
            r.a aVar = r.f3870b;
            kVar.invoke(r.a(r.b(h0.f3852a)));
        }
    }

    private final void setupChannel(BinaryMessenger messenger) {
        FirebaseRemoteConfigHostApi.Companion.setUp$default(FirebaseRemoteConfigHostApi.INSTANCE, messenger, this, null, 4, null);
        FlutterFirebasePluginRegistry.registerPlugin(METHOD_CHANNEL, this);
        EventChannel eventChannel = new EventChannel(messenger, EVENT_CHANNEL);
        this.eventChannel = eventChannel;
        kotlin.jvm.internal.t.c(eventChannel);
        eventChannel.setStreamHandler(this);
        this.messenger = messenger;
    }

    private final void tearDownChannel() {
        BinaryMessenger binaryMessenger = this.messenger;
        if (binaryMessenger == null) {
            throw new IllegalStateException("Required value was null.");
        }
        FirebaseRemoteConfigHostApi.Companion companion = FirebaseRemoteConfigHostApi.INSTANCE;
        kotlin.jvm.internal.t.c(binaryMessenger);
        FirebaseRemoteConfigHostApi.Companion.setUp$default(companion, binaryMessenger, null, null, 4, null);
        this.messenger = null;
        EventChannel eventChannel = this.eventChannel;
        kotlin.jvm.internal.t.c(eventChannel);
        eventChannel.setStreamHandler(null);
        this.eventChannel = null;
        removeEventListeners();
    }

    @Override // io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigHostApi
    public void activate(String appName, final pd.k callback) {
        kotlin.jvm.internal.t.f(appName, "appName");
        kotlin.jvm.internal.t.f(callback, "callback");
        getRemoteConfig(appName).i().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.d0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseRemoteConfigPlugin.activate$lambda$5(callback, this, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.u
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseRemoteConfigPlugin.didReinitializeFirebaseCore$lambda$1(this.f12966a, taskCompletionSource);
            }
        });
        Task<Void> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    @Override // io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigHostApi
    public void ensureInitialized(String appName, final pd.k callback) {
        kotlin.jvm.internal.t.f(appName, "appName");
        kotlin.jvm.internal.t.f(callback, "callback");
        getRemoteConfig(appName).k().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.b0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseRemoteConfigPlugin.ensureInitialized$lambda$8(callback, this, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigHostApi
    public void fetch(String appName, final pd.k callback) {
        kotlin.jvm.internal.t.f(appName, "appName");
        kotlin.jvm.internal.t.f(callback, "callback");
        getRemoteConfig(appName).l().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.w
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseRemoteConfigPlugin.fetch$lambda$3(callback, this, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigHostApi
    public void fetchAndActivate(String appName, final pd.k callback) {
        kotlin.jvm.internal.t.f(appName, "appName");
        kotlin.jvm.internal.t.f(callback, "callback");
        getRemoteConfig(appName).m().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.a0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseRemoteConfigPlugin.fetchAndActivate$lambda$4(callback, this, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigHostApi
    public void getAll(String appName, pd.k callback) {
        kotlin.jvm.internal.t.f(appName, "appName");
        kotlin.jvm.internal.t.f(callback, "callback");
        pa.o remoteConfig = getRemoteConfig(appName);
        r.a aVar = r.f3870b;
        Map mapN = remoteConfig.n();
        kotlin.jvm.internal.t.e(mapN, "getAll(...)");
        callback.invoke(r.a(r.b(parseParameters(mapN))));
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(final a7.g firebaseApp) {
        kotlin.jvm.internal.t.f(firebaseApp, "firebaseApp");
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.y
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseRemoteConfigPlugin.getPluginConstantsForFirebaseApp$lambda$0(firebaseApp, this, taskCompletionSource);
            }
        });
        Task<Map<String, Object>> task = taskCompletionSource.getTask();
        kotlin.jvm.internal.t.e(task, "getTask(...)");
        return task;
    }

    @Override // io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigHostApi
    public void getProperties(String appName, pd.k callback) {
        kotlin.jvm.internal.t.f(appName, "appName");
        kotlin.jvm.internal.t.f(callback, "callback");
        callback.invoke(r.a(r.b(getConfigProperties(getRemoteConfig(appName)))));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.t.f(binding, "binding");
        BinaryMessenger binaryMessenger = binding.getBinaryMessenger();
        kotlin.jvm.internal.t.e(binaryMessenger, "getBinaryMessenger(...)");
        setupChannel(binaryMessenger);
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object arguments) {
        Map map = arguments instanceof Map ? (Map) arguments : null;
        if (map == null) {
            return;
        }
        Object obj = map.get("appName");
        Objects.requireNonNull(obj);
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        pa.d dVar = this.listenersMap.get(str);
        if (dVar != null) {
            dVar.remove();
            this.listenersMap.remove(str);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        kotlin.jvm.internal.t.f(binding, "binding");
        tearDownChannel();
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object arguments, EventChannel.EventSink events) {
        kotlin.jvm.internal.t.f(arguments, "arguments");
        kotlin.jvm.internal.t.f(events, "events");
        Object obj = ((Map) arguments).get("appName");
        Objects.requireNonNull(obj);
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        this.listenersMap.put(str, getRemoteConfig(str).j(new AnonymousClass1(events)));
    }

    @Override // io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigHostApi
    public void setConfigSettings(String appName, RemoteConfigPigeonSettings settings, final pd.k callback) {
        kotlin.jvm.internal.t.f(appName, "appName");
        kotlin.jvm.internal.t.f(settings, "settings");
        kotlin.jvm.internal.t.f(callback, "callback");
        pa.u uVarC = new u.b().d(settings.getFetchTimeoutSeconds()).e(settings.getMinimumFetchIntervalSeconds()).c();
        kotlin.jvm.internal.t.e(uVarC, "build(...)");
        getRemoteConfig(appName).t(uVarC).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.x
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseRemoteConfigPlugin.setConfigSettings$lambda$6(callback, this, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigHostApi
    public void setDefaults(String appName, Map<String, ? extends Object> defaultParameters, final pd.k callback) {
        kotlin.jvm.internal.t.f(appName, "appName");
        kotlin.jvm.internal.t.f(defaultParameters, "defaultParameters");
        kotlin.jvm.internal.t.f(callback, "callback");
        getRemoteConfig(appName).w(defaultParameters).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.c0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseRemoteConfigPlugin.setDefaults$lambda$7(callback, this, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigHostApi
    public void setCustomSignals(String appName, Map<String, ? extends Object> customSignals, final pd.k callback) {
        kotlin.jvm.internal.t.f(appName, "appName");
        kotlin.jvm.internal.t.f(customSignals, "customSignals");
        kotlin.jvm.internal.t.f(callback, "callback");
        setCustomSignals(getRemoteConfig(appName), customSignals).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.z
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseRemoteConfigPlugin.setCustomSignals$lambda$9(callback, this, task);
            }
        });
    }
}
