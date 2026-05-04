package io.flutter.plugins.firebase.appcheck;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import io.flutter.plugins.firebase.database.Constants;
import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseAppCheckPlugin implements FlutterFirebasePlugin, FlutterPlugin, MethodChannel.MethodCallHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String METHOD_CHANNEL_NAME = "plugins.flutter.io/firebase_app_check";
    private MethodChannel channel;
    private BinaryMessenger messenger;
    private final Map<EventChannel, TokenChannelStreamHandler> streamHandlers = new HashMap();
    private final String debugProvider = com.amazon.a.a.o.b.ar;
    private final String playIntegrity = "playIntegrity";

    public static /* synthetic */ void a(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private Task<Void> activate(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.appcheck.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f12671a.lambda$activate$1(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static /* synthetic */ void e(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private e7.e getAppCheck(Map<String, Object> map) {
        Object obj = map.get("appName");
        Objects.requireNonNull(obj);
        return e7.e.f(a7.g.p((String) obj));
    }

    private Map<String, Object> getExceptionDetails(Exception exc) {
        HashMap map = new HashMap();
        map.put(Constants.ERROR_CODE, FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE);
        if (exc != null) {
            map.put(Constants.ERROR_MESSAGE, exc.getMessage());
            return map;
        }
        map.put(Constants.ERROR_MESSAGE, "An unknown error has occurred.");
        return map;
    }

    private Task<String> getLimitedUseAppCheckToken(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.appcheck.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f12663a.lambda$getLimitedUseAppCheckToken$0(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private Task<String> getToken(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.appcheck.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f12666a.lambda$getToken$2(map, taskCompletionSource);
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
    public /* synthetic */ void lambda$activate$1(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            Object obj = map.get("androidProvider");
            Objects.requireNonNull(obj);
            String str = (String) obj;
            int iHashCode = str.hashCode();
            if (iHashCode != 95458899) {
                if (iHashCode == 242544249 && str.equals("playIntegrity")) {
                    getAppCheck(map).h(k7.b.b());
                }
            } else if (str.equals(com.amazon.a.a.o.b.ar)) {
                e7.e appCheck = getAppCheck(map);
                FlutterFirebaseAppRegistrar.debugToken = (String) map.get("androidDebugToken");
                appCheck.h(f7.a.b());
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLimitedUseAppCheckToken$0(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(((e7.c) Tasks.await(getAppCheck(map).g())).b());
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getToken$2(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            e7.e appCheck = getAppCheck(map);
            Object obj = map.get("forceRefresh");
            Objects.requireNonNull(obj);
            taskCompletionSource.setResult(((e7.c) Tasks.await(appCheck.e(((Boolean) obj).booleanValue()))).b());
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
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
            Object obj = map.get("appName");
            Objects.requireNonNull(obj);
            TokenChannelStreamHandler tokenChannelStreamHandler = new TokenChannelStreamHandler(getAppCheck(map));
            String str = "plugins.flutter.io/firebase_app_check/token/" + ((String) obj);
            EventChannel eventChannel = new EventChannel(this.messenger, str);
            eventChannel.setStreamHandler(tokenChannelStreamHandler);
            this.streamHandlers.put(eventChannel, tokenChannelStreamHandler);
            taskCompletionSource.setResult(str);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setTokenAutoRefreshEnabled$3(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            e7.e appCheck = getAppCheck(map);
            Object obj = map.get("isTokenAutoRefreshEnabled");
            Objects.requireNonNull(obj);
            appCheck.j(((Boolean) obj).booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private Task<String> registerTokenListener(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.appcheck.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f12660a.lambda$registerTokenListener$4(map, taskCompletionSource);
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
                this.f12675a.lambda$setTokenAutoRefreshEnabled$3(map, taskCompletionSource);
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
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(a7.g gVar) {
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
                this.f12669a.lambda$onMethodCall$5(result, task);
            }
        });
    }
}
