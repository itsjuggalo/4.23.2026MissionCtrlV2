package io.flutter.plugins.googlesignin;

import S1.AbstractC0701w;
import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.googlesignin.GoogleSignInPlugin;
import io.flutter.plugins.googlesignin.Messages;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import n1.AbstractC1619e;
import u1.C1863b;

/* JADX INFO: loaded from: classes3.dex */
public class GoogleSignInPlugin implements FlutterPlugin, ActivityAware {
    private ActivityPluginBinding activityPluginBinding;
    private Delegate delegate;
    private BinaryMessenger messenger;

    /* JADX INFO: renamed from: io.flutter.plugins.googlesignin.GoogleSignInPlugin$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$googlesignin$Messages$SignInType;

        static {
            int[] iArr = new int[Messages.SignInType.values().length];
            $SwitchMap$io$flutter$plugins$googlesignin$Messages$SignInType = iArr;
            try {
                iArr[Messages.SignInType.GAMES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$googlesignin$Messages$SignInType[Messages.SignInType.STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Delegate implements PluginRegistry.ActivityResultListener, Messages.GoogleSignInApi {
        private static final String ERROR_FAILURE_TO_RECOVER_AUTH = "failed_to_recover_auth";
        private static final String ERROR_REASON_EXCEPTION = "exception";
        private static final String ERROR_REASON_NETWORK_ERROR = "network_error";
        private static final String ERROR_REASON_SIGN_IN_CANCELED = "sign_in_canceled";
        private static final String ERROR_REASON_SIGN_IN_FAILED = "sign_in_failed";
        private static final String ERROR_REASON_SIGN_IN_REQUIRED = "sign_in_required";
        private static final String ERROR_REASON_STATUS = "status";
        private static final String ERROR_USER_RECOVERABLE_AUTH = "user_recoverable_auth";
        private static final int REQUEST_CODE_RECOVER_AUTH = 53294;
        static final int REQUEST_CODE_REQUEST_SCOPE = 53295;
        private static final int REQUEST_CODE_SIGNIN = 53293;
        private Activity activity;
        private final Context context;
        private final GoogleSignInWrapper googleSignInWrapper;
        private PendingOperation pendingOperation;
        private List<String> requestedScopes;
        private C1863b signInClient;

        public static class PendingOperation {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            final Messages.Result<Boolean> boolResult;
            final Object data;
            final String method;
            final Messages.Result<String> stringResult;
            final Messages.Result<Messages.UserData> userDataResult;
            final Messages.VoidResult voidResult;

            public PendingOperation(String str, Messages.Result<Messages.UserData> result, Messages.VoidResult voidResult, Messages.Result<Boolean> result2, Messages.Result<String> result3, Object obj) {
                this.method = str;
                this.userDataResult = result;
                this.voidResult = voidResult;
                this.boolResult = result2;
                this.stringResult = result3;
                this.data = obj;
            }
        }

        public Delegate(Context context, GoogleSignInWrapper googleSignInWrapper) {
            this.context = context;
            this.googleSignInWrapper = googleSignInWrapper;
        }

        private void checkAndSetPendingAccessTokenOperation(String str, Messages.Result<String> result, Object obj) {
            checkAndSetPendingStringOperation(str, result, obj);
        }

        private void checkAndSetPendingBoolOperation(String str, Messages.Result<Boolean> result) {
            checkAndSetPendingOperation(str, null, null, result, null, null);
        }

        private void checkAndSetPendingOperation(String str, Messages.Result<Messages.UserData> result, Messages.VoidResult voidResult, Messages.Result<Boolean> result2, Messages.Result<String> result3, Object obj) {
            if (this.pendingOperation == null) {
                this.pendingOperation = new PendingOperation(str, result, voidResult, result2, result3, obj);
                return;
            }
            throw new IllegalStateException("Concurrent operations detected: " + this.pendingOperation.method + ", " + str);
        }

        private void checkAndSetPendingSignInOperation(String str, Messages.Result<Messages.UserData> result) {
            checkAndSetPendingOperation(str, result, null, null, null, null);
        }

        private void checkAndSetPendingStringOperation(String str, Messages.Result<String> result, Object obj) {
            checkAndSetPendingOperation(str, null, null, null, result, obj);
        }

        private void checkAndSetPendingVoidOperation(String str, Messages.VoidResult voidResult) {
            checkAndSetPendingOperation(str, null, voidResult, null, null, null);
        }

        private String errorCodeForStatus(int i4) {
            return i4 != 4 ? i4 != 7 ? i4 != 12501 ? ERROR_REASON_SIGN_IN_FAILED : ERROR_REASON_SIGN_IN_CANCELED : ERROR_REASON_NETWORK_ERROR : ERROR_REASON_SIGN_IN_REQUIRED;
        }

        private void finishWithBoolean(Boolean bool) {
            Messages.Result<Boolean> result = this.pendingOperation.boolResult;
            Objects.requireNonNull(result);
            result.success(bool);
            this.pendingOperation = null;
        }

        private void finishWithError(String str, String str2) {
            PendingOperation pendingOperation = this.pendingOperation;
            Messages.VoidResult voidResult = pendingOperation.voidResult;
            if (voidResult != null) {
                Objects.requireNonNull(voidResult);
                voidResult.error(new Messages.FlutterError(str, str2, null));
            } else {
                Messages.Result result = pendingOperation.userDataResult;
                if (result == null && (result = pendingOperation.boolResult) == null) {
                    result = pendingOperation.stringResult;
                }
                Objects.requireNonNull(result);
                result.error(new Messages.FlutterError(str, str2, null));
            }
            this.pendingOperation = null;
        }

        private void finishWithSuccess() {
            Messages.VoidResult voidResult = this.pendingOperation.voidResult;
            Objects.requireNonNull(voidResult);
            voidResult.success();
            this.pendingOperation = null;
        }

        private void finishWithUserData(Messages.UserData userData) {
            Messages.Result<Messages.UserData> result = this.pendingOperation.userDataResult;
            Objects.requireNonNull(result);
            result.success(userData);
            this.pendingOperation = null;
        }

        private static boolean isNullOrEmpty(String str) {
            return str == null || str.isEmpty();
        }

        public static /* synthetic */ void j(Delegate delegate, Task task) {
            delegate.getClass();
            if (task.isSuccessful()) {
                delegate.finishWithSuccess();
            } else {
                delegate.finishWithError(ERROR_REASON_STATUS, "Failed to signout.");
            }
        }

        public static /* synthetic */ void k(Delegate delegate, Task task) {
            delegate.getClass();
            if (task.isSuccessful()) {
                delegate.finishWithSuccess();
            } else {
                delegate.finishWithError(ERROR_REASON_STATUS, "Failed to disconnect.");
            }
        }

        public static /* synthetic */ void m(Delegate delegate, Boolean bool, Messages.Result result, UserRecoverableAuthException userRecoverableAuthException, String str) {
            delegate.getClass();
            if (!bool.booleanValue() || delegate.pendingOperation != null) {
                result.error(new Messages.FlutterError(ERROR_USER_RECOVERABLE_AUTH, userRecoverableAuthException.getLocalizedMessage(), null));
                return;
            }
            Activity activity = delegate.getActivity();
            if (activity != null) {
                delegate.checkAndSetPendingAccessTokenOperation("getTokens", result, str);
                activity.startActivityForResult(userRecoverableAuthException.a(), REQUEST_CODE_RECOVER_AUTH);
            } else {
                result.error(new Messages.FlutterError(ERROR_USER_RECOVERABLE_AUTH, "Cannot recover auth because app is not in foreground. " + userRecoverableAuthException.getLocalizedMessage(), null));
            }
        }

        private void onSignInAccount(GoogleSignInAccount googleSignInAccount) {
            Messages.UserData.Builder displayName = new Messages.UserData.Builder().setEmail(googleSignInAccount.getEmail()).setId(googleSignInAccount.m()).setIdToken(googleSignInAccount.getIdToken()).setServerAuthCode(googleSignInAccount.o()).setDisplayName(googleSignInAccount.getDisplayName());
            if (googleSignInAccount.getPhotoUrl() != null) {
                displayName.setPhotoUrl(googleSignInAccount.getPhotoUrl().toString());
            }
            finishWithUserData(displayName.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSignInResult(Task<GoogleSignInAccount> task) {
            try {
                onSignInAccount(task.getResult(com.google.android.gms.common.api.b.class));
            } catch (com.google.android.gms.common.api.b e4) {
                finishWithError(errorCodeForStatus(e4.getStatusCode()), e4.toString());
            } catch (RuntimeExecutionException e5) {
                finishWithError("exception", e5.toString());
            }
        }

        @Override // io.flutter.plugins.googlesignin.Messages.GoogleSignInApi
        public void clearAuthCache(String str) {
            try {
                AbstractC1619e.a(this.context, str);
            } catch (Exception e4) {
                throw new Messages.FlutterError("exception", e4.getMessage(), null);
            }
        }

        @Override // io.flutter.plugins.googlesignin.Messages.GoogleSignInApi
        public void disconnect(Messages.VoidResult voidResult) {
            checkAndSetPendingVoidOperation("disconnect", voidResult);
            this.signInClient.e().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.googlesignin.c
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    GoogleSignInPlugin.Delegate.k(this.f12760a, task);
                }
            });
        }

        @Override // io.flutter.plugins.googlesignin.Messages.GoogleSignInApi
        public void getAccessToken(final String str, final Boolean bool, final Messages.Result<String> result) {
            try {
                result.success(AbstractC1619e.b(this.context, new Account(str, "com.google"), "oauth2:" + AbstractC0701w.a(" ", this.requestedScopes)));
            } catch (UserRecoverableAuthException e4) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.flutter.plugins.googlesignin.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        GoogleSignInPlugin.Delegate.m(this.f12754a, bool, result, e4, str);
                    }
                });
            } catch (Exception e5) {
                result.error(new Messages.FlutterError("exception", e5.getMessage(), null));
            }
        }

        public Activity getActivity() {
            return this.activity;
        }

        @Override // io.flutter.plugins.googlesignin.Messages.GoogleSignInApi
        public void init(Messages.InitParams initParams) {
            GoogleSignInOptions.a aVar;
            int identifier;
            try {
                int i4 = AnonymousClass1.$SwitchMap$io$flutter$plugins$googlesignin$Messages$SignInType[initParams.getSignInType().ordinal()];
                if (i4 == 1) {
                    aVar = new GoogleSignInOptions.a(GoogleSignInOptions.f9610m);
                } else {
                    if (i4 != 2) {
                        throw new IllegalStateException("Unknown signInOption");
                    }
                    aVar = new GoogleSignInOptions.a(GoogleSignInOptions.f9609l).b();
                }
                String serverClientId = initParams.getServerClientId();
                if (!isNullOrEmpty(initParams.getClientId()) && isNullOrEmpty(serverClientId)) {
                    Log.w("google_sign_in", "clientId is not supported on Android and is interpreted as serverClientId. Use serverClientId instead to suppress this warning.");
                    serverClientId = initParams.getClientId();
                }
                if (isNullOrEmpty(serverClientId) && (identifier = this.context.getResources().getIdentifier("default_web_client_id", "string", this.context.getPackageName())) != 0) {
                    serverClientId = this.context.getString(identifier);
                }
                if (!isNullOrEmpty(serverClientId)) {
                    aVar.d(serverClientId);
                    aVar.g(serverClientId, initParams.getForceCodeForRefreshToken().booleanValue());
                }
                List<String> scopes = initParams.getScopes();
                this.requestedScopes = scopes;
                Iterator<String> it = scopes.iterator();
                while (it.hasNext()) {
                    aVar.f(new Scope(it.next()), new Scope[0]);
                }
                if (!isNullOrEmpty(initParams.getHostedDomain())) {
                    aVar.i(initParams.getHostedDomain());
                }
                String forceAccountName = initParams.getForceAccountName();
                if (!isNullOrEmpty(forceAccountName)) {
                    aVar.h(forceAccountName);
                }
                this.signInClient = this.googleSignInWrapper.getClient(this.context, aVar.a());
            } catch (Exception e4) {
                throw new Messages.FlutterError("exception", e4.getMessage(), null);
            }
        }

        @Override // io.flutter.plugins.googlesignin.Messages.GoogleSignInApi
        public Boolean isSignedIn() {
            return Boolean.valueOf(com.google.android.gms.auth.api.signin.a.b(this.context) != null);
        }

        @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
        public boolean onActivityResult(int i4, int i5, Intent intent) {
            PendingOperation pendingOperation = this.pendingOperation;
            if (pendingOperation == null) {
                return false;
            }
            switch (i4) {
                case REQUEST_CODE_SIGNIN /* 53293 */:
                    if (intent == null) {
                        finishWithError(ERROR_REASON_SIGN_IN_FAILED, "Signin failed");
                    } else {
                        onSignInResult(com.google.android.gms.auth.api.signin.a.c(intent));
                    }
                    break;
                case REQUEST_CODE_RECOVER_AUTH /* 53294 */:
                    if (i5 != -1) {
                        finishWithError(ERROR_FAILURE_TO_RECOVER_AUTH, "Failed attempt to recover authentication");
                    } else {
                        Messages.Result<String> result = pendingOperation.stringResult;
                        Objects.requireNonNull(result);
                        Object obj = this.pendingOperation.data;
                        Objects.requireNonNull(obj);
                        this.pendingOperation = null;
                        getAccessToken((String) obj, Boolean.FALSE, result);
                    }
                    break;
                case REQUEST_CODE_REQUEST_SCOPE /* 53295 */:
                    finishWithBoolean(Boolean.valueOf(i5 == -1));
                    break;
            }
            return false;
        }

        @Override // io.flutter.plugins.googlesignin.Messages.GoogleSignInApi
        public void requestScopes(List<String> list, Messages.Result<Boolean> result) {
            checkAndSetPendingBoolOperation("requestScopes", result);
            GoogleSignInAccount lastSignedInAccount = this.googleSignInWrapper.getLastSignedInAccount(this.context);
            if (lastSignedInAccount == null) {
                finishWithError(ERROR_REASON_SIGN_IN_REQUIRED, "No account to grant scopes.");
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                Scope scope = new Scope(it.next());
                if (!this.googleSignInWrapper.hasPermissions(lastSignedInAccount, scope)) {
                    arrayList.add(scope);
                }
            }
            if (arrayList.isEmpty()) {
                finishWithBoolean(Boolean.TRUE);
            } else {
                this.googleSignInWrapper.requestPermissions(getActivity(), REQUEST_CODE_REQUEST_SCOPE, lastSignedInAccount, (Scope[]) arrayList.toArray(new Scope[0]));
            }
        }

        public void setActivity(Activity activity) {
            this.activity = activity;
        }

        @Override // io.flutter.plugins.googlesignin.Messages.GoogleSignInApi
        public void signIn(Messages.Result<Messages.UserData> result) {
            if (getActivity() == null) {
                throw new IllegalStateException("signIn needs a foreground activity");
            }
            checkAndSetPendingSignInOperation("signIn", result);
            getActivity().startActivityForResult(this.signInClient.d(), REQUEST_CODE_SIGNIN);
        }

        @Override // io.flutter.plugins.googlesignin.Messages.GoogleSignInApi
        public void signInSilently(Messages.Result<Messages.UserData> result) {
            checkAndSetPendingSignInOperation("signInSilently", result);
            Task taskF = this.signInClient.f();
            if (taskF.isComplete()) {
                onSignInResult(taskF);
            } else {
                taskF.addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.googlesignin.d
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        this.f12761a.onSignInResult(task);
                    }
                });
            }
        }

        @Override // io.flutter.plugins.googlesignin.Messages.GoogleSignInApi
        public void signOut(Messages.VoidResult voidResult) {
            checkAndSetPendingVoidOperation("signOut", voidResult);
            this.signInClient.signOut().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.googlesignin.b
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    GoogleSignInPlugin.Delegate.j(this.f12759a, task);
                }
            });
        }
    }

    private void attachToActivity(ActivityPluginBinding activityPluginBinding) {
        this.activityPluginBinding = activityPluginBinding;
        activityPluginBinding.addActivityResultListener(this.delegate);
        this.delegate.setActivity(activityPluginBinding.getActivity());
    }

    private void dispose() {
        this.delegate = null;
        BinaryMessenger binaryMessenger = this.messenger;
        if (binaryMessenger != null) {
            Messages.GoogleSignInApi.setUp(binaryMessenger, null);
            this.messenger = null;
        }
    }

    private void disposeActivity() {
        this.activityPluginBinding.removeActivityResultListener(this.delegate);
        this.delegate.setActivity(null);
        this.activityPluginBinding = null;
    }

    public void initInstance(BinaryMessenger binaryMessenger, Context context, GoogleSignInWrapper googleSignInWrapper) {
        this.messenger = binaryMessenger;
        Delegate delegate = new Delegate(context, googleSignInWrapper);
        this.delegate = delegate;
        Messages.GoogleSignInApi.setUp(binaryMessenger, delegate);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        attachToActivity(activityPluginBinding);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext(), new GoogleSignInWrapper());
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        disposeActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        disposeActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        dispose();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        attachToActivity(activityPluginBinding);
    }
}
