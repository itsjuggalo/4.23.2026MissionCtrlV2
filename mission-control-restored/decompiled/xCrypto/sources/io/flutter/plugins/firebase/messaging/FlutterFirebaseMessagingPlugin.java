package io.flutter.plugins.firebase.messaging;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import androidx.lifecycle.AbstractC0853p;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import io.flutter.plugins.firebase.crashlytics.Constants;
import io.flutter.plugins.firebase.messaging.FlutterFirebasePermissionManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseMessagingPlugin implements FlutterFirebasePlugin, MethodChannel.MethodCallHandler, PluginRegistry.NewIntentListener, FlutterPlugin, ActivityAware {
    private MethodChannel channel;
    private RemoteMessage initialMessage;
    private Map<String, Object> initialMessageNotification;
    private Activity mainActivity;
    FlutterFirebasePermissionManager permissionManager;
    private androidx.lifecycle.s remoteMessageObserver;
    private androidx.lifecycle.s tokenObserver;
    private final HashMap<String, Boolean> consumedInitialMessages = new HashMap<>();
    private final AbstractC0853p liveDataRemoteMessage = FlutterFirebaseRemoteMessageLiveData.getInstance();
    private final AbstractC0853p liveDataToken = FlutterFirebaseTokenLiveData.getInstance();

    public static /* synthetic */ void a(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map).send(FlutterFirebaseMessagingUtils.getRemoteMessageForArguments(map));
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public static /* synthetic */ void c(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessagingForArguments = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map);
            Object obj = map.get("topic");
            Objects.requireNonNull(obj);
            Tasks.await(firebaseMessagingForArguments.subscribeToTopic((String) obj));
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private Boolean checkPermissions() {
        return Boolean.valueOf(ContextHolder.getApplicationContext().checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0);
    }

    private Task<Void> deleteToken() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.o
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.h(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static /* synthetic */ void e(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessagingForArguments = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map);
            Object obj = map.get("topic");
            Objects.requireNonNull(obj);
            Tasks.await(firebaseMessagingForArguments.unsubscribeFromTopic((String) obj));
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private Map<String, Object> getExceptionDetails(Exception exc) {
        HashMap map = new HashMap();
        map.put("code", "unknown");
        if (exc != null) {
            map.put(Constants.MESSAGE, exc.getMessage());
            return map;
        }
        map.put(Constants.MESSAGE, "An unknown error has occurred.");
        return map;
    }

    private Task<Map<String, Object>> getInitialMessage() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f12709a.lambda$getInitialMessage$9(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private Task<Map<String, Integer>> getPermissions() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f12705a.lambda$getPermissions$13(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private Task<Map<String, Object>> getToken() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f12700a.lambda$getToken$3(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public static /* synthetic */ void h(TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(FirebaseMessaging.getInstance().deleteToken());
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    private void initInstance(BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/firebase_messaging");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.permissionManager = new FlutterFirebasePermissionManager();
        this.remoteMessageObserver = new androidx.lifecycle.s() { // from class: io.flutter.plugins.firebase.messaging.p
            @Override // androidx.lifecycle.s
            public final void a(Object obj) {
                this.f12703a.lambda$initInstance$0((RemoteMessage) obj);
            }
        };
        this.tokenObserver = new androidx.lifecycle.s() { // from class: io.flutter.plugins.firebase.messaging.q
            @Override // androidx.lifecycle.s
            public final void a(Object obj) {
                this.f12704a.lambda$initInstance$1((String) obj);
            }
        };
        this.liveDataRemoteMessage.observeForever(this.remoteMessageObserver);
        this.liveDataToken.observeForever(this.tokenObserver);
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_messaging", this);
    }

    public static /* synthetic */ void k(FirebaseApp firebaseApp, TaskCompletionSource taskCompletionSource) {
        try {
            HashMap map = new HashMap();
            if (firebaseApp.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                map.put("AUTO_INIT_ENABLED", Boolean.valueOf(FirebaseMessaging.getInstance().isAutoInitEnabled()));
            }
            taskCompletionSource.setResult(map);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007c A[PHI: r0
      0x007c: PHI (r0v11 com.google.firebase.messaging.RemoteMessage) = (r0v8 com.google.firebase.messaging.RemoteMessage), (r0v13 com.google.firebase.messaging.RemoteMessage) binds: [B:31:0x0067, B:33:0x0071] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getInitialMessage$9(com.google.android.gms.tasks.TaskCompletionSource r7) {
        /*
            r6 = this;
            com.google.firebase.messaging.RemoteMessage r0 = r6.initialMessage     // Catch: java.lang.Exception -> L13
            java.lang.String r1 = "notification"
            r2 = 0
            if (r0 == 0) goto L1e
            java.util.Map r0 = io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingUtils.remoteMessageToMap(r0)     // Catch: java.lang.Exception -> L13
            java.util.Map<java.lang.String, java.lang.Object> r3 = r6.initialMessageNotification     // Catch: java.lang.Exception -> L13
            if (r3 == 0) goto L16
            r0.put(r1, r3)     // Catch: java.lang.Exception -> L13
            goto L16
        L13:
            r0 = move-exception
            goto Lae
        L16:
            r7.setResult(r0)     // Catch: java.lang.Exception -> L13
            r6.initialMessage = r2     // Catch: java.lang.Exception -> L13
            r6.initialMessageNotification = r2     // Catch: java.lang.Exception -> L13
            return
        L1e:
            android.app.Activity r0 = r6.mainActivity     // Catch: java.lang.Exception -> L13
            if (r0 != 0) goto L26
            r7.setResult(r2)     // Catch: java.lang.Exception -> L13
            return
        L26:
            android.content.Intent r0 = r0.getIntent()     // Catch: java.lang.Exception -> L13
            if (r0 == 0) goto Laa
            android.os.Bundle r3 = r0.getExtras()     // Catch: java.lang.Exception -> L13
            if (r3 != 0) goto L34
            goto Laa
        L34:
            android.os.Bundle r3 = r0.getExtras()     // Catch: java.lang.Exception -> L13
            java.lang.String r4 = "google.message_id"
            java.lang.String r3 = r3.getString(r4)     // Catch: java.lang.Exception -> L13
            if (r3 != 0) goto L4a
            android.os.Bundle r0 = r0.getExtras()     // Catch: java.lang.Exception -> L13
            java.lang.String r3 = "message_id"
            java.lang.String r3 = r0.getString(r3)     // Catch: java.lang.Exception -> L13
        L4a:
            if (r3 == 0) goto La6
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = r6.consumedInitialMessages     // Catch: java.lang.Exception -> L13
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Exception -> L13
            if (r0 == 0) goto L55
            goto La6
        L55:
            java.util.HashMap<java.lang.String, com.google.firebase.messaging.RemoteMessage> r0 = io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingReceiver.notifications     // Catch: java.lang.Exception -> L13
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Exception -> L13
            com.google.firebase.messaging.RemoteMessage r0 = (com.google.firebase.messaging.RemoteMessage) r0     // Catch: java.lang.Exception -> L13
            if (r0 != 0) goto L85
            io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingStore r4 = io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingStore.getInstance()     // Catch: java.lang.Exception -> L13
            java.util.Map r4 = r4.getFirebaseMessageMap(r3)     // Catch: java.lang.Exception -> L13
            if (r4 == 0) goto L7c
            com.google.firebase.messaging.RemoteMessage r0 = io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingUtils.getRemoteMessageForArguments(r4)     // Catch: java.lang.Exception -> L13
            java.lang.Object r5 = r4.get(r1)     // Catch: java.lang.Exception -> L13
            if (r5 == 0) goto L7c
            java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Exception -> L13
            java.util.Map r4 = r6.uncheckedCastToMap(r4)     // Catch: java.lang.Exception -> L13
            goto L7d
        L7c:
            r4 = r2
        L7d:
            io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingStore r5 = io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingStore.getInstance()     // Catch: java.lang.Exception -> L13
            r5.removeFirebaseMessage(r3)     // Catch: java.lang.Exception -> L13
            goto L86
        L85:
            r4 = r2
        L86:
            if (r0 != 0) goto L8c
            r7.setResult(r2)     // Catch: java.lang.Exception -> L13
            return
        L8c:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r2 = r6.consumedInitialMessages     // Catch: java.lang.Exception -> L13
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L13
            r2.put(r3, r5)     // Catch: java.lang.Exception -> L13
            java.util.Map r2 = io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingUtils.remoteMessageToMap(r0)     // Catch: java.lang.Exception -> L13
            com.google.firebase.messaging.RemoteMessage$Notification r0 = r0.getNotification()     // Catch: java.lang.Exception -> L13
            if (r0 != 0) goto La2
            if (r4 == 0) goto La2
            r2.put(r1, r4)     // Catch: java.lang.Exception -> L13
        La2:
            r7.setResult(r2)     // Catch: java.lang.Exception -> L13
            return
        La6:
            r7.setResult(r2)     // Catch: java.lang.Exception -> L13
            return
        Laa:
            r7.setResult(r2)     // Catch: java.lang.Exception -> L13
            return
        Lae:
            r7.setException(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin.lambda$getInitialMessage$9(com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$getPermissions$13(TaskCompletionSource taskCompletionSource) {
        try {
            HashMap map = new HashMap();
            map.put("authorizationStatus", Integer.valueOf(Build.VERSION.SDK_INT >= 33 ? checkPermissions().booleanValue() : w.p.e(this.mainActivity).a()));
            taskCompletionSource.setResult(map);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getToken$3(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(new HashMap<String, Object>((String) Tasks.await(FirebaseMessaging.getInstance().getToken())) { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin.1
                final /* synthetic */ String val$token;

                {
                    this.val$token = str;
                    put("token", str);
                }
            });
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initInstance$0(RemoteMessage remoteMessage) {
        this.channel.invokeMethod("Messaging#onMessage", FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initInstance$1(String str) {
        this.channel.invokeMethod("Messaging#onTokenRefresh", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMethodCall$14(MethodChannel.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(task.getResult());
        } else {
            Exception exception = task.getException();
            result.error("firebase_messaging", exception != null ? exception.getMessage() : null, getExceptionDetails(exception));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestPermissions$12(final TaskCompletionSource taskCompletionSource) {
        final HashMap map = new HashMap();
        try {
            if (!checkPermissions().booleanValue()) {
                this.permissionManager.requestPermissions(this.mainActivity, new FlutterFirebasePermissionManager.RequestPermissionsSuccessCallback() { // from class: io.flutter.plugins.firebase.messaging.g
                    @Override // io.flutter.plugins.firebase.messaging.FlutterFirebasePermissionManager.RequestPermissionsSuccessCallback
                    public final void onSuccess(int i4) {
                        FlutterFirebaseMessagingPlugin.o(map, taskCompletionSource, i4);
                    }
                }, new ErrorCallback() { // from class: io.flutter.plugins.firebase.messaging.h
                    @Override // io.flutter.plugins.firebase.messaging.ErrorCallback
                    public final void onError(String str) {
                        taskCompletionSource.setException(new Exception(str));
                    }
                });
            } else {
                map.put("authorizationStatus", 1);
                taskCompletionSource.setResult(map);
            }
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAutoInitEnabled$7(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessagingForArguments = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map);
            Object obj = map.get("enabled");
            Objects.requireNonNull(obj);
            firebaseMessagingForArguments.setAutoInitEnabled(((Boolean) obj).booleanValue());
            taskCompletionSource.setResult(new HashMap<String, Object>(firebaseMessagingForArguments) { // from class: io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingPlugin.2
                final /* synthetic */ FirebaseMessaging val$firebaseMessaging;

                {
                    this.val$firebaseMessaging = firebaseMessagingForArguments;
                    put("isAutoInitEnabled", Boolean.valueOf(firebaseMessagingForArguments.isAutoInitEnabled()));
                }
            });
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public static /* synthetic */ void m(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessagingForArguments = FlutterFirebaseMessagingUtils.getFirebaseMessagingForArguments(map);
            Object obj = map.get("enabled");
            Objects.requireNonNull(obj);
            firebaseMessagingForArguments.setDeliveryMetricsExportToBigQuery(((Boolean) obj).booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public static /* synthetic */ void o(Map map, TaskCompletionSource taskCompletionSource, int i4) {
        map.put("authorizationStatus", Integer.valueOf(i4));
        taskCompletionSource.setResult(map);
    }

    private Task<Map<String, Integer>> requestPermissions() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f12696a.lambda$requestPermissions$12(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private Task<Void> sendMessage(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.m
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.a(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private Task<Map<String, Object>> setAutoInitEnabled(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f12690a.lambda$setAutoInitEnabled$7(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private Task<Void> setDeliveryMetricsExportToBigQuery(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.f
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.m(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private Task<Void> subscribeToTopic(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.k
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.c(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private Map<String, Object> uncheckedCastToMap(Object obj) {
        return (Map) obj;
    }

    private Task<Void> unsubscribeFromTopic(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.e
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.e(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.j
            @Override // java.lang.Runnable
            public final void run() {
                taskCompletionSource.setResult(null);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(final FirebaseApp firebaseApp) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.messaging.d
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseMessagingPlugin.k(firebaseApp, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addOnNewIntentListener(this);
        activityPluginBinding.addRequestPermissionsResultListener(this.permissionManager);
        Activity activity = activityPluginBinding.getActivity();
        this.mainActivity = activity;
        if (activity.getIntent() == null || this.mainActivity.getIntent().getExtras() == null || (this.mainActivity.getIntent().getFlags() & 1048576) == 1048576) {
            return;
        }
        onNewIntent(this.mainActivity.getIntent());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        ContextHolder.setApplicationContext(flutterPluginBinding.getApplicationContext());
        initInstance(flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.mainActivity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.mainActivity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.liveDataToken.removeObserver(this.tokenObserver);
        this.liveDataRemoteMessage.removeObserver(this.remoteMessageObserver);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        Task initialMessage;
        long jIntValue;
        long jIntValue2;
        String str = methodCall.method;
        str.getClass();
        switch (str) {
            case "Messaging#getInitialMessage":
                initialMessage = getInitialMessage();
                break;
            case "Messaging#setAutoInitEnabled":
                initialMessage = setAutoInitEnabled((Map) methodCall.arguments());
                break;
            case "Messaging#deleteToken":
                initialMessage = deleteToken();
                break;
            case "Messaging#unsubscribeFromTopic":
                initialMessage = unsubscribeFromTopic((Map) methodCall.arguments());
                break;
            case "Messaging#subscribeToTopic":
                initialMessage = subscribeToTopic((Map) methodCall.arguments());
                break;
            case "Messaging#setDeliveryMetricsExportToBigQuery":
                initialMessage = setDeliveryMetricsExportToBigQuery((Map) methodCall.arguments());
                break;
            case "Messaging#startBackgroundIsolate":
                Map map = (Map) methodCall.arguments;
                Object obj = map.get("pluginCallbackHandle");
                Object obj2 = map.get("userCallbackHandle");
                if (obj instanceof Long) {
                    jIntValue = ((Long) obj).longValue();
                } else {
                    if (!(obj instanceof Integer)) {
                        throw new IllegalArgumentException("Expected 'Long' or 'Integer' type for 'pluginCallbackHandle'.");
                    }
                    jIntValue = ((Integer) obj).intValue();
                }
                if (obj2 instanceof Long) {
                    jIntValue2 = ((Long) obj2).longValue();
                } else {
                    if (!(obj2 instanceof Integer)) {
                        throw new IllegalArgumentException("Expected 'Long' or 'Integer' type for 'userCallbackHandle'.");
                    }
                    jIntValue2 = ((Integer) obj2).intValue();
                }
                Activity activity = this.mainActivity;
                FlutterShellArgs flutterShellArgsFromIntent = activity != null ? FlutterShellArgs.fromIntent(activity.getIntent()) : null;
                FlutterFirebaseMessagingBackgroundService.setCallbackDispatcher(jIntValue);
                FlutterFirebaseMessagingBackgroundService.setUserCallbackHandle(jIntValue2);
                FlutterFirebaseMessagingBackgroundService.startBackgroundIsolate(jIntValue, flutterShellArgsFromIntent);
                initialMessage = Tasks.forResult(null);
                break;
            case "Messaging#sendMessage":
                initialMessage = sendMessage((Map) methodCall.arguments());
                break;
            case "Messaging#requestPermission":
                if (Build.VERSION.SDK_INT < 33) {
                    initialMessage = getPermissions();
                    break;
                } else {
                    initialMessage = requestPermissions();
                    break;
                }
                break;
            case "Messaging#getNotificationSettings":
                initialMessage = getPermissions();
                break;
            case "Messaging#getToken":
                initialMessage = getToken();
                break;
            default:
                result.notImplemented();
                return;
        }
        initialMessage.addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.messaging.s
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f12707a.lambda$onMethodCall$14(result, task);
            }
        });
    }

    @Override // io.flutter.plugin.common.PluginRegistry.NewIntentListener
    public boolean onNewIntent(Intent intent) {
        Map<String, Object> remoteMessageNotificationForArguments;
        Map<String, Object> map;
        Map<String, Object> firebaseMessageMap;
        if (intent.getExtras() == null) {
            return false;
        }
        String string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID);
        if (string == null) {
            string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID_SERVER);
        }
        if (string == null) {
            return false;
        }
        RemoteMessage remoteMessageForArguments = FlutterFirebaseMessagingReceiver.notifications.get(string);
        if (remoteMessageForArguments != null || (firebaseMessageMap = FlutterFirebaseMessagingStore.getInstance().getFirebaseMessageMap(string)) == null) {
            remoteMessageNotificationForArguments = null;
        } else {
            remoteMessageForArguments = FlutterFirebaseMessagingUtils.getRemoteMessageForArguments(firebaseMessageMap);
            remoteMessageNotificationForArguments = FlutterFirebaseMessagingUtils.getRemoteMessageNotificationForArguments(firebaseMessageMap);
        }
        if (remoteMessageForArguments == null) {
            return false;
        }
        this.initialMessage = remoteMessageForArguments;
        this.initialMessageNotification = remoteMessageNotificationForArguments;
        FlutterFirebaseMessagingReceiver.notifications.remove(string);
        Map<String, Object> mapRemoteMessageToMap = FlutterFirebaseMessagingUtils.remoteMessageToMap(remoteMessageForArguments);
        if (remoteMessageForArguments.getNotification() == null && (map = this.initialMessageNotification) != null) {
            mapRemoteMessageToMap.put("notification", map);
        }
        this.channel.invokeMethod("Messaging#onMessageOpenedApp", mapRemoteMessageToMap);
        this.mainActivity.setIntent(intent);
        return true;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addOnNewIntentListener(this);
        this.mainActivity = activityPluginBinding.getActivity();
    }
}
