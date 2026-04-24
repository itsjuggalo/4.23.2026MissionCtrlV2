package io.flutter.plugins.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseAuthUser implements GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi {
    private Activity activity;

    public static /* synthetic */ void A(GeneratedAndroidFirebaseAuth.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void B(GeneratedAndroidFirebaseAuth.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void C(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((AuthResult) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void D(final FirebaseUser firebaseUser, final GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            firebaseUser.reload().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.x
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    FlutterFirebaseAuthUser.o(result, firebaseUser, task2);
                }
            });
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

    public static /* synthetic */ void F(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.Result result, Boolean bool) {
        FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
            return;
        }
        try {
            result.success(PigeonParser.parseTokenResult((GetTokenResult) Tasks.await(currentUserFromPigeon.getIdToken(bool.booleanValue()))));
        } catch (Exception e4) {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(e4));
        }
    }

    public static /* synthetic */ void G(GeneratedAndroidFirebaseAuth.Result result, FirebaseUser firebaseUser, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseFirebaseUser(firebaseUser));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void H(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((AuthResult) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static FirebaseUser getCurrentUserFromPigeon(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance(authPigeonFirebaseApp.getAppName()));
        if (authPigeonFirebaseApp.getTenantId() != null) {
            firebaseAuth.setTenantId(authPigeonFirebaseApp.getTenantId());
        }
        return firebaseAuth.getCurrentUser();
    }

    public static /* synthetic */ void o(GeneratedAndroidFirebaseAuth.Result result, FirebaseUser firebaseUser, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseFirebaseUser(firebaseUser));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void p(final FirebaseUser firebaseUser, final GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            firebaseUser.reload().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.E
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    FlutterFirebaseAuthUser.t(result, firebaseUser, task2);
                }
            });
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void q(GeneratedAndroidFirebaseAuth.Result result, FirebaseUser firebaseUser, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseFirebaseUser(firebaseUser));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void r(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((AuthResult) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void s(GeneratedAndroidFirebaseAuth.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void t(GeneratedAndroidFirebaseAuth.Result result, FirebaseUser firebaseUser, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseFirebaseUser(firebaseUser));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void u(final FirebaseUser firebaseUser, final GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            firebaseUser.reload().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.u
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    FlutterFirebaseAuthUser.x(result, firebaseUser, task2);
                }
            });
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void v(final FirebaseUser firebaseUser, final GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            firebaseUser.reload().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.y
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    FlutterFirebaseAuthUser.G(result, firebaseUser, task2);
                }
            });
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void w(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((AuthResult) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void x(GeneratedAndroidFirebaseAuth.Result result, FirebaseUser firebaseUser, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseFirebaseUser(firebaseUser));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void y(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((AuthResult) task.getResult()));
            return;
        }
        Exception exception = task.getException();
        if (exception.getMessage().contains("User was not linked to an account with the given provider.")) {
            result.error(FlutterFirebaseAuthPluginException.noSuchProvider());
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(exception));
        }
    }

    public static /* synthetic */ void z(GeneratedAndroidFirebaseAuth.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void delete(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            voidResult.error(FlutterFirebaseAuthPluginException.noUser());
        } else {
            currentUserFromPigeon.delete().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.N
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.E(voidResult, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void getIdToken(final GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, final Boolean bool, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonIdTokenResult> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.auth.z
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAuthUser.F(authPigeonFirebaseApp, result, bool);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void linkWithCredential(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, Map<String, Object> map, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        AuthCredential credential = PigeonParser.getCredential(map);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
        } else if (credential == null) {
            result.error(FlutterFirebaseAuthPluginException.invalidCredential());
        } else {
            currentUserFromPigeon.linkWithCredential(credential).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.I
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.H(result, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void linkWithProvider(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonSignInProvider pigeonSignInProvider, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        OAuthProvider.Builder builderNewBuilder = OAuthProvider.newBuilder(pigeonSignInProvider.getProviderId());
        if (pigeonSignInProvider.getScopes() != null) {
            builderNewBuilder.setScopes(pigeonSignInProvider.getScopes());
        }
        if (pigeonSignInProvider.getCustomParameters() != null) {
            builderNewBuilder.addCustomParameters(pigeonSignInProvider.getCustomParameters());
        }
        currentUserFromPigeon.startActivityForLinkWithProvider(this.activity, builderNewBuilder.build()).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.F
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthUser.r(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void reauthenticateWithCredential(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, Map<String, Object> map, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        AuthCredential credential = PigeonParser.getCredential(map);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
        } else if (credential == null) {
            result.error(FlutterFirebaseAuthPluginException.invalidCredential());
        } else {
            currentUserFromPigeon.reauthenticateAndRetrieveData(credential).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.D
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.w(result, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void reauthenticateWithProvider(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonSignInProvider pigeonSignInProvider, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        OAuthProvider.Builder builderNewBuilder = OAuthProvider.newBuilder(pigeonSignInProvider.getProviderId());
        if (pigeonSignInProvider.getScopes() != null) {
            builderNewBuilder.setScopes(pigeonSignInProvider.getScopes());
        }
        if (pigeonSignInProvider.getCustomParameters() != null) {
            builderNewBuilder.addCustomParameters(pigeonSignInProvider.getCustomParameters());
        }
        currentUserFromPigeon.startActivityForReauthenticateWithProvider(this.activity, builderNewBuilder.build()).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.v
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthUser.C(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void reload(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserDetails> result) {
        final FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
        } else {
            currentUserFromPigeon.reload().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.w
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.q(result, currentUserFromPigeon, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void sendEmailVerification(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonActionCodeSettings pigeonActionCodeSettings, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            voidResult.error(FlutterFirebaseAuthPluginException.noUser());
        } else if (pigeonActionCodeSettings == null) {
            currentUserFromPigeon.sendEmailVerification().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.G
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.z(voidResult, task);
                }
            });
        } else {
            currentUserFromPigeon.sendEmailVerification(PigeonParser.getActionCodeSettings(pigeonActionCodeSettings)).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.H
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.B(voidResult, task);
                }
            });
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void unlink(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
        } else {
            currentUserFromPigeon.unlink(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.M
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.y(result, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void updateEmail(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserDetails> result) {
        final FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
        } else {
            currentUserFromPigeon.updateEmail(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.C
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.v(currentUserFromPigeon, result, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void updatePassword(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserDetails> result) {
        final FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
        } else {
            currentUserFromPigeon.updatePassword(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.B
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.u(currentUserFromPigeon, result, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void updatePhoneNumber(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, Map<String, Object> map, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserDetails> result) {
        final FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
            return;
        }
        PhoneAuthCredential phoneAuthCredential = (PhoneAuthCredential) PigeonParser.getCredential(map);
        if (phoneAuthCredential == null) {
            result.error(FlutterFirebaseAuthPluginException.invalidCredential());
        } else {
            currentUserFromPigeon.updatePhoneNumber(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.A
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.p(currentUserFromPigeon, result, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void updateProfile(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonUserProfile pigeonUserProfile, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserDetails> result) {
        final FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
            return;
        }
        UserProfileChangeRequest.Builder builder = new UserProfileChangeRequest.Builder();
        if (pigeonUserProfile.getDisplayNameChanged().booleanValue()) {
            builder.setDisplayName(pigeonUserProfile.getDisplayName());
        }
        if (pigeonUserProfile.getPhotoUrlChanged().booleanValue()) {
            if (pigeonUserProfile.getPhotoUrl() != null) {
                builder.setPhotoUri(Uri.parse(pigeonUserProfile.getPhotoUrl()));
            } else {
                builder.setPhotoUri(null);
            }
        }
        currentUserFromPigeon.updateProfile(builder.build()).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.L
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthUser.D(currentUserFromPigeon, result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void verifyBeforeUpdateEmail(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, GeneratedAndroidFirebaseAuth.PigeonActionCodeSettings pigeonActionCodeSettings, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        FirebaseUser currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            voidResult.error(FlutterFirebaseAuthPluginException.noUser());
        } else if (pigeonActionCodeSettings == null) {
            currentUserFromPigeon.verifyBeforeUpdateEmail(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.J
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.A(voidResult, task);
                }
            });
        } else {
            currentUserFromPigeon.verifyBeforeUpdateEmail(str, PigeonParser.getActionCodeSettings(pigeonActionCodeSettings)).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.K
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.s(voidResult, task);
                }
            });
        }
    }
}
