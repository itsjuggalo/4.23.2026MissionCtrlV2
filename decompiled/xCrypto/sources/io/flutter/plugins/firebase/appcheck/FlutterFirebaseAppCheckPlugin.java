package io.flutter.plugins.firebase.appcheck;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckToken;
import com.google.firebase.appcheck.FirebaseAppCheck;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.auth.Constants;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseAppCheckPlugin implements FlutterFirebasePlugin, FlutterPlugin, MethodChannel.MethodCallHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String METHOD_CHANNEL_NAME = "plugins.flutter.io/firebase_app_check";
    private MethodChannel channel;
    private BinaryMessenger messenger;
    private final Map<EventChannel, TokenChannelStreamHandler> streamHandlers = new HashMap();
    private final String debugProvider = com.amazon.a.a.o.b.ar;
    private final String safetyNetProvider = "safetyNet";
    private final String playIntegrity = "playIntegrity";

    public static /* synthetic */ void a(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private Task<Void> activate(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.appcheck.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f12401a.lambda$activate$1(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static /* synthetic */ void e(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private FirebaseAppCheck getAppCheck(Map<String, Object> map) {
        Object obj = map.get(Constants.APP_NAME);
        Objects.requireNonNull(obj);
        return FirebaseAppCheck.getInstance(FirebaseApp.getInstance((String) obj));
    }

    private Map<String, Object> getExceptionDetails(Exception exc) {
        HashMap map = new HashMap();
        map.put("code", "unknown");
        if (exc != null) {
            map.put(io.flutter.plugins.firebase.crashlytics.Constants.MESSAGE, exc.getMessage());
            return map;
        }
        map.put(io.flutter.plugins.firebase.crashlytics.Constants.MESSAGE, "An unknown error has occurred.");
        return map;
    }

    private Task<String> getLimitedUseAppCheckToken(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.appcheck.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f12393a.lambda$getLimitedUseAppCheckToken$0(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private Task<String> getToken(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.appcheck.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f12396a.lambda$getToken$2(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private void initInstance(BinaryMessenger binaryMessenger) {
        FlutterFirebasePluginRegistry.registerPlugin(METHOD_CHANNEL_NAME, this);
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, METHOD_CHANNEL_NAME);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.messenger = binaryMessenger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$activate$1(java.util.Map r6, com.google.android.gms.tasks.TaskCompletionSource r7) {
        /*
            r5 = this;
            java.lang.String r0 = "androidProvider"
            java.lang.Object r0 = r6.get(r0)     // Catch: java.lang.Exception -> L2b
            java.util.Objects.requireNonNull(r0)     // Catch: java.lang.Exception -> L2b
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L2b
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L2b
            r2 = -1111504533(0xffffffffbdbfc96b, float:-0.09364589)
            r3 = 1
            r4 = 2
            if (r1 == r2) goto L37
            r2 = 95458899(0x5b09653, float:1.6606181E-35)
            if (r1 == r2) goto L2d
            r2 = 242544249(0xe74ee79, float:3.0190142E-30)
            if (r1 == r2) goto L21
            goto L41
        L21:
            java.lang.String r1 = "playIntegrity"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L2b
            if (r0 == 0) goto L41
            r0 = r4
            goto L42
        L2b:
            r6 = move-exception
            goto L71
        L2d:
            java.lang.String r1 = "debug"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L2b
            if (r0 == 0) goto L41
            r0 = 0
            goto L42
        L37:
            java.lang.String r1 = "safetyNet"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L2b
            if (r0 == 0) goto L41
            r0 = r3
            goto L42
        L41:
            r0 = -1
        L42:
            if (r0 == 0) goto L61
            if (r0 == r3) goto L55
            if (r0 == r4) goto L49
            goto L6c
        L49:
            com.google.firebase.appcheck.FirebaseAppCheck r6 = r5.getAppCheck(r6)     // Catch: java.lang.Exception -> L2b
            com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory r0 = com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory.getInstance()     // Catch: java.lang.Exception -> L2b
            r6.installAppCheckProviderFactory(r0)     // Catch: java.lang.Exception -> L2b
            goto L6c
        L55:
            com.google.firebase.appcheck.FirebaseAppCheck r6 = r5.getAppCheck(r6)     // Catch: java.lang.Exception -> L2b
            com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory r0 = com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory.getInstance()     // Catch: java.lang.Exception -> L2b
            r6.installAppCheckProviderFactory(r0)     // Catch: java.lang.Exception -> L2b
            goto L6c
        L61:
            com.google.firebase.appcheck.FirebaseAppCheck r6 = r5.getAppCheck(r6)     // Catch: java.lang.Exception -> L2b
            com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory r0 = com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory.getInstance()     // Catch: java.lang.Exception -> L2b
            r6.installAppCheckProviderFactory(r0)     // Catch: java.lang.Exception -> L2b
        L6c:
            r6 = 0
            r7.setResult(r6)     // Catch: java.lang.Exception -> L2b
            return
        L71:
            r7.setException(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.appcheck.FlutterFirebaseAppCheckPlugin.lambda$activate$1(java.util.Map, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLimitedUseAppCheckToken$0(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(((AppCheckToken) Tasks.await(getAppCheck(map).getLimitedUseAppCheckToken())).getToken());
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getToken$2(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAppCheck appCheck = getAppCheck(map);
            Object obj = map.get("forceRefresh");
            Objects.requireNonNull(obj);
            taskCompletionSource.setResult(((AppCheckToken) Tasks.await(appCheck.getAppCheckToken(((Boolean) obj).booleanValue()))).getToken());
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMethodCall$5(MethodChannel.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
        } else {
            Exception exception = task.getException();
            result.error("firebase_app_check", exception != null ? exception.getMessage() : null, getExceptionDetails(exception));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerTokenListener$4(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Object obj = map.get(Constants.APP_NAME);
            Objects.requireNonNull(obj);
            TokenChannelStreamHandler tokenChannelStreamHandler = new TokenChannelStreamHandler(getAppCheck(map));
            String str = "plugins.flutter.io/firebase_app_check/token/" + ((String) obj);
            EventChannel eventChannel = new EventChannel(this.messenger, str);
            eventChannel.setStreamHandler(tokenChannelStreamHandler);
            this.streamHandlers.put(eventChannel, tokenChannelStreamHandler);
            taskCompletionSource.setResult(str);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setTokenAutoRefreshEnabled$3(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseAppCheck appCheck = getAppCheck(map);
            Object obj = map.get("isTokenAutoRefreshEnabled");
            Objects.requireNonNull(obj);
            appCheck.setTokenAutoRefreshEnabled(((Boolean) obj).booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private Task<String> registerTokenListener(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.appcheck.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f12390a.lambda$registerTokenListener$4(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private void removeEventListeners() {
        for (EventChannel eventChannel : this.streamHandlers.keySet()) {
            this.streamHandlers.get(eventChannel).onCancel(null);
            eventChannel.setStreamHandler(null);
        }
        this.streamHandlers.clear();
    }

    private Task<Void> setTokenAutoRefreshEnabled(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.appcheck.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f12405a.lambda$setTokenAutoRefreshEnabled$3(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.appcheck.a
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAppCheckPlugin.a(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(FirebaseApp firebaseApp) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.appcheck.g
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAppCheckPlugin.e(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler(null);
        this.channel = null;
        this.messenger = null;
        removeEventListeners();
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        Task limitedUseAppCheckToken;
        String str = methodCall.method;
        str.getClass();
        switch (str) {
            case "FirebaseAppCheck#getLimitedUseAppCheckToken":
                limitedUseAppCheckToken = getLimitedUseAppCheckToken((Map) methodCall.arguments());
                break;
            case "FirebaseAppCheck#setTokenAutoRefreshEnabled":
                limitedUseAppCheckToken = setTokenAutoRefreshEnabled((Map) methodCall.arguments());
                break;
            case "FirebaseAppCheck#registerTokenListener":
                limitedUseAppCheckToken = registerTokenListener((Map) methodCall.arguments());
                break;
            case "FirebaseAppCheck#getToken":
                limitedUseAppCheckToken = getToken((Map) methodCall.arguments());
                break;
            case "FirebaseAppCheck#activate":
                limitedUseAppCheckToken = activate((Map) methodCall.arguments());
                break;
            default:
                result.notImplemented();
                return;
        }
        limitedUseAppCheckToken.addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.appcheck.e
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f12399a.lambda$onMethodCall$5(result, task);
            }
        });
    }
}
