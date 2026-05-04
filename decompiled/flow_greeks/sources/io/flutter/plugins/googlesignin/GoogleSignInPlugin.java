package io.flutter.plugins.googlesignin;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.ClearTokenRequest;
import com.google.android.gms.auth.api.identity.RevokeAccessRequest;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import j6.a;
import j6.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executors;
import x0.w;
import x0.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class GoogleSignInPlugin implements FlutterPlugin, ActivityAware {
    private static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    private ActivityPluginBinding activityPluginBinding;
    private Delegate delegate;
    private BinaryMessenger messenger;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface AuthorizationClientFactory {
        c5.a create(Context context);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface CredentialManagerFactory {
        x0.d create(Context context);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class Delegate implements PluginRegistry.ActivityResultListener, GoogleSignInApi {
        static final int REQUEST_CODE_AUTHORIZE = 53294;
        private Activity activity;
        private final AuthorizationClientFactory authorizationClientFactory;
        private final Context context;
        final GoogleIdCredentialConverter credentialConverter;
        private final CredentialManagerFactory credentialManagerFactory;
        private pd.k pendingAuthorizationCallback;

        public Delegate(Context context, CredentialManagerFactory credentialManagerFactory, AuthorizationClientFactory authorizationClientFactory, GoogleIdCredentialConverter googleIdCredentialConverter) {
            this.context = context;
            this.credentialManagerFactory = credentialManagerFactory;
            this.authorizationClientFactory = authorizationClientFactory;
            this.credentialConverter = googleIdCredentialConverter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$authorize$2(boolean z10, pd.k kVar, c5.b bVar) {
            if (!bVar.V()) {
                ResultUtilsKt.completeWithAuthorizationResult(kVar, new PlatformAuthorizationResult(bVar.R(), bVar.U(), bVar.S()));
                return;
            }
            if (!z10) {
                ResultUtilsKt.completeWithAuthorizeFailure(kVar, new AuthorizeFailure(AuthorizeFailureType.UNAUTHORIZED, null, null));
                return;
            }
            Activity activity = getActivity();
            if (activity == null) {
                ResultUtilsKt.completeWithAuthorizeFailure(kVar, new AuthorizeFailure(AuthorizeFailureType.NO_ACTIVITY, "No activity available", null));
                return;
            }
            PendingIntent pendingIntentT = bVar.T();
            Objects.requireNonNull(pendingIntentT);
            try {
                this.pendingAuthorizationCallback = kVar;
                activity.startIntentSenderForResult(pendingIntentT.getIntentSender(), REQUEST_CODE_AUTHORIZE, null, 0, 0, 0, null);
            } catch (IntentSender.SendIntentException e10) {
                this.pendingAuthorizationCallback = null;
                ResultUtilsKt.completeWithAuthorizeFailure(kVar, new AuthorizeFailure(AuthorizeFailureType.PENDING_INTENT_EXCEPTION, e10.getMessage(), null));
            }
        }

        @Override // io.flutter.plugins.googlesignin.GoogleSignInApi
        public void authorize(PlatformAuthorizationRequest platformAuthorizationRequest, final boolean z10, final pd.k kVar) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = platformAuthorizationRequest.getScopes().iterator();
                while (it.hasNext()) {
                    arrayList.add(new Scope(it.next()));
                }
                AuthorizationRequest.a aVarG = AuthorizationRequest.R().g(arrayList);
                if (platformAuthorizationRequest.getHostedDomain() != null) {
                    aVarG.c(platformAuthorizationRequest.getHostedDomain());
                }
                if (platformAuthorizationRequest.getServerClientIdForForcedRefreshToken() != null) {
                    aVarG.d(platformAuthorizationRequest.getServerClientIdForForcedRefreshToken(), true);
                }
                if (platformAuthorizationRequest.getAccountEmail() != null) {
                    aVarG.e(new Account(platformAuthorizationRequest.getAccountEmail(), GoogleSignInPlugin.GOOGLE_ACCOUNT_TYPE));
                }
                this.authorizationClientFactory.create(this.context).authorize(aVarG.b()).addOnSuccessListener(new OnSuccessListener() { // from class: io.flutter.plugins.googlesignin.u
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        this.f13133a.lambda$authorize$2(z10, kVar, (c5.b) obj);
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: io.flutter.plugins.googlesignin.v
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        ResultUtilsKt.completeWithAuthorizeFailure(kVar, new AuthorizeFailure(AuthorizeFailureType.AUTHORIZE_FAILURE, exc.getMessage(), null));
                    }
                });
            } catch (RuntimeException e10) {
                ResultUtilsKt.completeWithAuthorizeFailure(kVar, new AuthorizeFailure(AuthorizeFailureType.API_EXCEPTION, e10.getMessage(), "Cause: " + e10.getCause() + ", Stacktrace: " + Log.getStackTraceString(e10)));
            }
        }

        @Override // io.flutter.plugins.googlesignin.GoogleSignInApi
        public void clearAuthorizationToken(String str, final pd.k kVar) {
            this.authorizationClientFactory.create(this.context).clearToken(ClearTokenRequest.R().b(str).a()).addOnSuccessListener(new OnSuccessListener() { // from class: io.flutter.plugins.googlesignin.p
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    ResultUtilsKt.completeWithUnitSuccess(kVar);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: io.flutter.plugins.googlesignin.q
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    ResultUtilsKt.completeWithUnitError(kVar, new FlutterError("clearAuthorizationToken failed", exc.getMessage(), null));
                }
            });
        }

        @Override // io.flutter.plugins.googlesignin.GoogleSignInApi
        public void clearCredentialState(final pd.k kVar) {
            this.credentialManagerFactory.create(this.context).a(new x0.a(), null, Executors.newSingleThreadExecutor(), new x0.e() { // from class: io.flutter.plugins.googlesignin.GoogleSignInPlugin.Delegate.2
                @Override // x0.e
                public void onError(y0.a aVar) {
                    ResultUtilsKt.completeWithUnitError(kVar, new FlutterError("Clear Failed", aVar.getMessage(), null));
                }

                @Override // x0.e
                public void onResult(Void r12) {
                    ResultUtilsKt.completeWithUnitSuccess(kVar);
                }
            });
        }

        public Activity getActivity() {
            return this.activity;
        }

        @Override // io.flutter.plugins.googlesignin.GoogleSignInApi
        public void getCredential(GetCredentialRequestParams getCredentialRequestParams, final pd.k kVar) {
            try {
                String serverClientId = getCredentialRequestParams.getServerClientId();
                if (serverClientId != null && !serverClientId.isEmpty()) {
                    Activity activity = getActivity();
                    if (activity == null) {
                        ResultUtilsKt.completeWithGetCredentialFailure(kVar, new GetCredentialFailure(GetCredentialFailureType.NO_ACTIVITY, "No activity available", null));
                        return;
                    }
                    String nonce = getCredentialRequestParams.getNonce();
                    String hostedDomain = getCredentialRequestParams.getHostedDomain();
                    w.a aVar = new w.a();
                    if (getCredentialRequestParams.getUseButtonFlow()) {
                        b.a aVar2 = new b.a(serverClientId);
                        if (hostedDomain != null) {
                            aVar2.b(hostedDomain);
                        }
                        if (nonce != null) {
                            aVar2.c(nonce);
                        }
                        aVar.a(aVar2.a());
                    } else {
                        GetCredentialRequestGoogleIdOptionParams googleIdOptionParams = getCredentialRequestParams.getGoogleIdOptionParams();
                        a.C0242a c0242aE = new a.C0242a().c(googleIdOptionParams.getFilterToAuthorized()).b(googleIdOptionParams.getAutoSelectEnabled()).e(serverClientId);
                        if (nonce != null) {
                            c0242aE.d(nonce);
                        }
                        aVar.a(c0242aE.a());
                    }
                    this.credentialManagerFactory.create(this.context).b(activity, aVar.b(), null, Executors.newSingleThreadExecutor(), new x0.e() { // from class: io.flutter.plugins.googlesignin.GoogleSignInPlugin.Delegate.1
                        @Override // x0.e
                        public void onError(y0.h hVar) {
                            ResultUtilsKt.completeWithGetCredentialFailure(kVar, new GetCredentialFailure(hVar instanceof y0.f ? GetCredentialFailureType.CANCELED : hVar instanceof y0.i ? GetCredentialFailureType.INTERRUPTED : hVar instanceof y0.j ? GetCredentialFailureType.PROVIDER_CONFIGURATION_ISSUE : hVar instanceof y0.l ? GetCredentialFailureType.UNSUPPORTED : hVar instanceof y0.m ? GetCredentialFailureType.NO_CREDENTIAL : GetCredentialFailureType.UNKNOWN, hVar.getMessage(), null));
                        }

                        @Override // x0.e
                        public void onResult(x xVar) {
                            x0.c cVarA = xVar.a();
                            if ((cVarA instanceof x0.u) && cVarA.b().equals("com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL")) {
                                j6.c cVarCreateFrom = Delegate.this.credentialConverter.createFrom(cVarA);
                                Uri uriI = cVarCreateFrom.i();
                                ResultUtilsKt.completeWithGetGetCredentialResult(kVar, new GetCredentialSuccess(new PlatformGoogleIdTokenCredential(cVarCreateFrom.d(), cVarCreateFrom.e(), cVarCreateFrom.f(), cVarCreateFrom.g(), cVarCreateFrom.h(), uriI != null ? uriI.toString() : null)));
                            } else {
                                ResultUtilsKt.completeWithGetCredentialFailure(kVar, new GetCredentialFailure(GetCredentialFailureType.UNEXPECTED_CREDENTIAL_TYPE, "Unexpected credential type: " + cVarA, null));
                            }
                        }
                    });
                    return;
                }
                ResultUtilsKt.completeWithGetCredentialFailure(kVar, new GetCredentialFailure(GetCredentialFailureType.MISSING_SERVER_CLIENT_ID, "CredentialManager requires a serverClientId.", null));
            } catch (RuntimeException e10) {
                ResultUtilsKt.completeWithGetCredentialFailure(kVar, new GetCredentialFailure(GetCredentialFailureType.UNKNOWN, e10.getMessage(), "Cause: " + e10.getCause() + ", Stacktrace: " + Log.getStackTraceString(e10)));
            }
        }

        @Override // io.flutter.plugins.googlesignin.GoogleSignInApi
        public String getGoogleServicesJsonServerClientId() {
            int identifier = this.context.getResources().getIdentifier("default_web_client_id", "string", this.context.getPackageName());
            if (identifier != 0) {
                return this.context.getString(identifier);
            }
            return null;
        }

        @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
        public boolean onActivityResult(int i10, int i11, Intent intent) {
            if (i10 != REQUEST_CODE_AUTHORIZE) {
                return false;
            }
            if (this.pendingAuthorizationCallback == null) {
                Log.e("google_sign_in", "Unexpected authorization result callback");
                return false;
            }
            try {
                c5.b authorizationResultFromIntent = this.authorizationClientFactory.create(this.context).getAuthorizationResultFromIntent(intent);
                ResultUtilsKt.completeWithAuthorizationResult(this.pendingAuthorizationCallback, new PlatformAuthorizationResult(authorizationResultFromIntent.R(), authorizationResultFromIntent.U(), authorizationResultFromIntent.S()));
                return true;
            } catch (com.google.android.gms.common.api.b e10) {
                ResultUtilsKt.completeWithAuthorizeFailure(this.pendingAuthorizationCallback, new AuthorizeFailure(AuthorizeFailureType.API_EXCEPTION, e10.getMessage(), null));
                this.pendingAuthorizationCallback = null;
                return false;
            }
        }

        @Override // io.flutter.plugins.googlesignin.GoogleSignInApi
        public void revokeAccess(PlatformRevokeAccessRequest platformRevokeAccessRequest, final pd.k kVar) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = platformRevokeAccessRequest.getScopes().iterator();
            while (it.hasNext()) {
                arrayList.add(new Scope(it.next()));
            }
            this.authorizationClientFactory.create(this.context).revokeAccess(RevokeAccessRequest.R().b(new Account(platformRevokeAccessRequest.getAccountEmail(), GoogleSignInPlugin.GOOGLE_ACCOUNT_TYPE)).c(arrayList).a()).addOnSuccessListener(new OnSuccessListener() { // from class: io.flutter.plugins.googlesignin.s
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    ResultUtilsKt.completeWithUnitSuccess(kVar);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: io.flutter.plugins.googlesignin.t
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    ResultUtilsKt.completeWithUnitError(kVar, new FlutterError("revokeAccess failed", exc.getMessage(), null));
                }
            });
        }

        public void setActivity(Activity activity) {
            this.activity = activity;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface GoogleIdCredentialConverter {
        j6.c createFrom(x0.c cVar);
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
            GoogleSignInApi.INSTANCE.setUp(binaryMessenger, null);
            this.messenger = null;
        }
    }

    private void disposeActivity() {
        this.activityPluginBinding.removeActivityResultListener(this.delegate);
        this.delegate.setActivity(null);
        this.activityPluginBinding = null;
    }

    private void initInstance(BinaryMessenger binaryMessenger, Context context) {
        initWithDelegate(binaryMessenger, new Delegate(context, new CredentialManagerFactory() { // from class: io.flutter.plugins.googlesignin.m
            @Override // io.flutter.plugins.googlesignin.GoogleSignInPlugin.CredentialManagerFactory
            public final x0.d create(Context context2) {
                return x0.d.create(context2);
            }
        }, new AuthorizationClientFactory() { // from class: io.flutter.plugins.googlesignin.n
            @Override // io.flutter.plugins.googlesignin.GoogleSignInPlugin.AuthorizationClientFactory
            public final c5.a create(Context context2) {
                return c5.i.a(context2);
            }
        }, new GoogleIdCredentialConverter() { // from class: io.flutter.plugins.googlesignin.o
            @Override // io.flutter.plugins.googlesignin.GoogleSignInPlugin.GoogleIdCredentialConverter
            public final j6.c createFrom(x0.c cVar) {
                return j6.c.c(cVar.a());
            }
        }));
    }

    public void initWithDelegate(BinaryMessenger binaryMessenger, Delegate delegate) {
        this.messenger = binaryMessenger;
        this.delegate = delegate;
        GoogleSignInApi.INSTANCE.setUp(binaryMessenger, delegate);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        attachToActivity(activityPluginBinding);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        initInstance(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
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
