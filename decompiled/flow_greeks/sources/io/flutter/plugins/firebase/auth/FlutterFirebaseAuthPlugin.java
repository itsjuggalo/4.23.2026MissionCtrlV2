package io.flutter.plugins.firebase.auth;

import android.app.Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth;
import io.flutter.plugins.firebase.auth.PhoneNumberVerificationStreamHandler;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import m7.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseAuthPlugin implements FlutterFirebasePlugin, FlutterPlugin, ActivityAware, GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String METHOD_CHANNEL_NAME = "plugins.flutter.io/firebase_auth";
    static final HashMap<Integer, m7.h> authCredentials = new HashMap<>();
    private Activity activity;
    private MethodChannel channel;
    private BinaryMessenger messenger;
    private final Map<EventChannel, EventChannel.StreamHandler> streamHandlers = new HashMap();
    private final FlutterFirebaseAuthUser firebaseAuthUser = new FlutterFirebaseAuthUser();
    private final FlutterFirebaseMultiFactor firebaseMultiFactor = new FlutterFirebaseMultiFactor();
    private final FlutterFirebaseTotpMultiFactor firebaseTotpMultiFactor = new FlutterFirebaseTotpMultiFactor();
    private final FlutterFirebaseTotpSecret firebaseTotpSecret = new FlutterFirebaseTotpSecret();

    public static /* synthetic */ void A(GeneratedAndroidFirebaseAuth.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void B(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success((String) task.getResult());
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void D(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((m7.i) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void E(GeneratedAndroidFirebaseAuth.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void F(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((m7.i) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void G(GeneratedAndroidFirebaseAuth.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void H(a7.g gVar, TaskCompletionSource taskCompletionSource) {
        try {
            HashMap map = new HashMap();
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(gVar);
            m7.a0 a0VarM = firebaseAuth.m();
            String strP = firebaseAuth.p();
            GeneratedAndroidFirebaseAuth.PigeonUserDetails firebaseUser = a0VarM == null ? null : PigeonParser.parseFirebaseUser(a0VarM);
            if (strP != null) {
                map.put("APP_LANGUAGE_CODE", strP);
            }
            if (firebaseUser != null) {
                map.put("APP_CURRENT_USER", PigeonParser.manuallyToList(firebaseUser));
            }
            taskCompletionSource.setResult(map);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void I(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseActionCodeResult((m7.d) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void J(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((m7.i) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void K(GeneratedAndroidFirebaseAuth.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void L(GeneratedAndroidFirebaseAuth.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void N(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((m7.i) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void O(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((m7.i) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void P(GeneratedAndroidFirebaseAuth.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    private Activity getActivity() {
        return this.activity;
    }

    public static FirebaseAuth getAuthFromPigeon(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(a7.g.p(authPigeonFirebaseApp.getAppName()));
        if (authPigeonFirebaseApp.getTenantId() != null) {
            firebaseAuth.z(authPigeonFirebaseApp.getTenantId());
        }
        String str = FlutterFirebaseCorePlugin.customAuthDomain.get(authPigeonFirebaseApp.getAppName());
        if (str != null) {
            firebaseAuth.x(str);
        }
        if (authPigeonFirebaseApp.getCustomAuthDomain() != null) {
            firebaseAuth.x(authPigeonFirebaseApp.getCustomAuthDomain());
        }
        return firebaseAuth;
    }

    private void initInstance(BinaryMessenger binaryMessenger) {
        FlutterFirebasePluginRegistry.registerPlugin(METHOD_CHANNEL_NAME, this);
        this.channel = new MethodChannel(binaryMessenger, METHOD_CHANNEL_NAME);
        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.setUp(binaryMessenger, this);
        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.setUp(binaryMessenger, this.firebaseAuthUser);
        GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi.setUp(binaryMessenger, this.firebaseMultiFactor);
        GeneratedAndroidFirebaseAuth.MultiFactoResolverHostApi.setUp(binaryMessenger, this.firebaseMultiFactor);
        GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi.setUp(binaryMessenger, this.firebaseTotpMultiFactor);
        GeneratedAndroidFirebaseAuth.MultiFactorTotpSecretHostApi.setUp(binaryMessenger, this.firebaseTotpSecret);
        this.messenger = binaryMessenger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReinitializeFirebaseCore$18(TaskCompletionSource taskCompletionSource) {
        try {
            removeEventListeners();
            authCredentials.clear();
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    private void removeEventListeners() {
        for (EventChannel eventChannel : this.streamHandlers.keySet()) {
            EventChannel.StreamHandler streamHandler = this.streamHandlers.get(eventChannel);
            if (streamHandler != null) {
                streamHandler.onCancel(null);
            }
            eventChannel.setStreamHandler(null);
        }
        this.streamHandlers.clear();
    }

    public static /* synthetic */ void x(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((m7.i) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void y(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(((m7.u0) task.getResult()).a());
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void z(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((m7.i) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void applyActionCode(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        getAuthFromPigeon(authPigeonFirebaseApp).g(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.e
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.A(voidResult, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void checkActionCode(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonActionCodeInfo> result) {
        getAuthFromPigeon(authPigeonFirebaseApp).h(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.j
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.I(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void confirmPasswordReset(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, String str2, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        getAuthFromPigeon(authPigeonFirebaseApp).i(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.l
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.L(voidResult, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void createUserWithEmailAndPassword(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, String str2, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        getAuthFromPigeon(authPigeonFirebaseApp).j(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.u
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.N(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.auth.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f12743a.lambda$didReinitializeFirebaseCore$18(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void fetchSignInMethodsForEmail(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, final GeneratedAndroidFirebaseAuth.Result<List<String>> result) {
        getAuthFromPigeon(authPigeonFirebaseApp).k(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.q
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.y(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(final a7.g gVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.auth.o
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAuthPlugin.H(gVar, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void initializeRecaptchaConfig(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        getAuthFromPigeon(authPigeonFirebaseApp).r().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.s
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.K(voidResult, task);
            }
        });
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Activity activity = activityPluginBinding.getActivity();
        this.activity = activity;
        this.firebaseAuthUser.setActivity(activity);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.activity = null;
        this.firebaseAuthUser.setActivity(null);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.activity = null;
        this.firebaseAuthUser.setActivity(null);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler(null);
        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.setUp(this.messenger, null);
        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.setUp(this.messenger, null);
        GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi.setUp(this.messenger, null);
        GeneratedAndroidFirebaseAuth.MultiFactoResolverHostApi.setUp(this.messenger, null);
        GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi.setUp(this.messenger, null);
        GeneratedAndroidFirebaseAuth.MultiFactorTotpSecretHostApi.setUp(this.messenger, null);
        this.channel = null;
        this.messenger = null;
        removeEventListeners();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        Activity activity = activityPluginBinding.getActivity();
        this.activity = activity;
        this.firebaseAuthUser.setActivity(activity);
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void registerAuthStateListener(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.Result<String> result) {
        try {
            FirebaseAuth authFromPigeon = getAuthFromPigeon(authPigeonFirebaseApp);
            AuthStateChannelStreamHandler authStateChannelStreamHandler = new AuthStateChannelStreamHandler(authFromPigeon);
            String str = "plugins.flutter.io/firebase_auth/auth-state/" + authFromPigeon.l().q();
            EventChannel eventChannel = new EventChannel(this.messenger, str);
            eventChannel.setStreamHandler(authStateChannelStreamHandler);
            this.streamHandlers.put(eventChannel, authStateChannelStreamHandler);
            result.success(str);
        } catch (Exception e10) {
            result.error(e10);
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void registerIdTokenListener(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.Result<String> result) {
        try {
            FirebaseAuth authFromPigeon = getAuthFromPigeon(authPigeonFirebaseApp);
            IdTokenChannelStreamHandler idTokenChannelStreamHandler = new IdTokenChannelStreamHandler(authFromPigeon);
            String str = "plugins.flutter.io/firebase_auth/id-token/" + authFromPigeon.l().q();
            EventChannel eventChannel = new EventChannel(this.messenger, str);
            eventChannel.setStreamHandler(idTokenChannelStreamHandler);
            this.streamHandlers.put(eventChannel, idTokenChannelStreamHandler);
            result.success(str);
        } catch (Exception e10) {
            result.error(e10);
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void revokeTokenWithAuthorizationCode(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        voidResult.success();
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void sendPasswordResetEmail(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, GeneratedAndroidFirebaseAuth.PigeonActionCodeSettings pigeonActionCodeSettings, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        FirebaseAuth authFromPigeon = getAuthFromPigeon(authPigeonFirebaseApp);
        if (pigeonActionCodeSettings == null) {
            authFromPigeon.u(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.g
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthPlugin.E(voidResult, task);
                }
            });
        } else {
            authFromPigeon.v(str, PigeonParser.getActionCodeSettings(pigeonActionCodeSettings)).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.h
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthPlugin.G(voidResult, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void sendSignInLinkToEmail(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, GeneratedAndroidFirebaseAuth.PigeonActionCodeSettings pigeonActionCodeSettings, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        getAuthFromPigeon(authPigeonFirebaseApp).w(str, PigeonParser.getActionCodeSettings(pigeonActionCodeSettings)).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.m
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.P(voidResult, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void setLanguageCode(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, GeneratedAndroidFirebaseAuth.Result<String> result) {
        try {
            FirebaseAuth authFromPigeon = getAuthFromPigeon(authPigeonFirebaseApp);
            if (str == null) {
                authFromPigeon.H();
            } else {
                authFromPigeon.y(str);
            }
            result.success(authFromPigeon.p());
        } catch (Exception e10) {
            result.error(e10);
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void setSettings(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonFirebaseAuthSettings pigeonFirebaseAuthSettings, GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        try {
            FirebaseAuth authFromPigeon = getAuthFromPigeon(authPigeonFirebaseApp);
            authFromPigeon.o().b(pigeonFirebaseAuthSettings.getAppVerificationDisabledForTesting().booleanValue());
            if (pigeonFirebaseAuthSettings.getForceRecaptchaFlow() != null) {
                authFromPigeon.o().a(pigeonFirebaseAuthSettings.getForceRecaptchaFlow().booleanValue());
            }
            if (pigeonFirebaseAuthSettings.getPhoneNumber() != null && pigeonFirebaseAuthSettings.getSmsCode() != null) {
                authFromPigeon.o().c(pigeonFirebaseAuthSettings.getPhoneNumber(), pigeonFirebaseAuthSettings.getSmsCode());
            }
            voidResult.success();
        } catch (Exception e10) {
            voidResult.error(e10);
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void signInAnonymously(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        getAuthFromPigeon(authPigeonFirebaseApp).A().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.p
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.J(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void signInWithCredential(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, Map<String, Object> map, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        FirebaseAuth authFromPigeon = getAuthFromPigeon(authPigeonFirebaseApp);
        m7.h credential = PigeonParser.getCredential(map);
        if (credential == null) {
            throw FlutterFirebaseAuthPluginException.invalidCredential();
        }
        authFromPigeon.B(credential).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.k
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.z(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void signInWithCustomToken(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        getAuthFromPigeon(authPigeonFirebaseApp).C(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.i
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.D(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void signInWithEmailAndPassword(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, String str2, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        getAuthFromPigeon(authPigeonFirebaseApp).D(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.d
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.x(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void signInWithEmailLink(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, String str2, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        getAuthFromPigeon(authPigeonFirebaseApp).E(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.c
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.F(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void signInWithProvider(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonSignInProvider pigeonSignInProvider, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        FirebaseAuth authFromPigeon = getAuthFromPigeon(authPigeonFirebaseApp);
        n0.a aVarE = m7.n0.e(pigeonSignInProvider.getProviderId(), authFromPigeon);
        if (pigeonSignInProvider.getScopes() != null) {
            aVarE.c(pigeonSignInProvider.getScopes());
        }
        if (pigeonSignInProvider.getCustomParameters() != null) {
            aVarE.a(pigeonSignInProvider.getCustomParameters());
        }
        authFromPigeon.G(getActivity(), aVarE.b()).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.b
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.O(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void signOut(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        Map<String, m7.h0> map;
        try {
            FirebaseAuth authFromPigeon = getAuthFromPigeon(authPigeonFirebaseApp);
            if (authFromPigeon.m() != null && (map = FlutterFirebaseMultiFactor.multiFactorUserMap.get(authPigeonFirebaseApp.getAppName())) != null) {
                map.remove(authFromPigeon.m().a());
            }
            authFromPigeon.F();
            voidResult.success();
        } catch (Exception e10) {
            voidResult.error(e10);
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void useEmulator(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, Long l10, GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        try {
            getAuthFromPigeon(authPigeonFirebaseApp).I(str, l10.intValue());
            voidResult.success();
        } catch (Exception e10) {
            voidResult.error(e10);
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void verifyPasswordResetCode(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, final GeneratedAndroidFirebaseAuth.Result<String> result) {
        getAuthFromPigeon(authPigeonFirebaseApp).J(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.f
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthPlugin.B(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi
    public void verifyPhoneNumber(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonVerifyPhoneNumberRequest pigeonVerifyPhoneNumberRequest, GeneratedAndroidFirebaseAuth.Result<String> result) {
        try {
            String str = "plugins.flutter.io/firebase_auth/phone/" + UUID.randomUUID().toString();
            EventChannel eventChannel = new EventChannel(this.messenger, str);
            m7.r0 r0Var = null;
            m7.l0 l0Var = pigeonVerifyPhoneNumberRequest.getMultiFactorSessionId() != null ? FlutterFirebaseMultiFactor.multiFactorSessionMap.get(pigeonVerifyPhoneNumberRequest.getMultiFactorSessionId()) : null;
            String multiFactorInfoId = pigeonVerifyPhoneNumberRequest.getMultiFactorInfoId();
            if (multiFactorInfoId != null) {
                Iterator<String> it = FlutterFirebaseMultiFactor.multiFactorResolverMap.keySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = FlutterFirebaseMultiFactor.multiFactorResolverMap.get(it.next()).S().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            m7.j0 j0Var = (m7.j0) it2.next();
                            if (j0Var.a().equals(multiFactorInfoId) && (j0Var instanceof m7.r0)) {
                                r0Var = (m7.r0) j0Var;
                                break;
                            }
                        }
                    }
                }
            }
            PhoneNumberVerificationStreamHandler phoneNumberVerificationStreamHandler = new PhoneNumberVerificationStreamHandler(getActivity(), authPigeonFirebaseApp, pigeonVerifyPhoneNumberRequest, l0Var, r0Var, new PhoneNumberVerificationStreamHandler.OnCredentialsListener() { // from class: io.flutter.plugins.firebase.auth.t
                @Override // io.flutter.plugins.firebase.auth.PhoneNumberVerificationStreamHandler.OnCredentialsListener
                public final void onCredentialsReceived(m7.o0 o0Var) {
                    FlutterFirebaseAuthPlugin.authCredentials.put(Integer.valueOf(o0Var.hashCode()), o0Var);
                }
            });
            eventChannel.setStreamHandler(phoneNumberVerificationStreamHandler);
            this.streamHandlers.put(eventChannel, phoneNumberVerificationStreamHandler);
            result.success(str);
        } catch (Exception e10) {
            result.error(e10);
        }
    }
}
