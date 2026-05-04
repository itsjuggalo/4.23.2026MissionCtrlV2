package io.flutter.plugins.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import java.util.Map;
import m7.c1;
import m7.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
            result.success(PigeonParser.parseAuthResult((m7.i) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void D(final m7.a0 a0Var, final GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            a0Var.a0().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.y
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    FlutterFirebaseAuthUser.o(result, a0Var, task2);
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
        m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
            return;
        }
        try {
            result.success(PigeonParser.parseTokenResult((m7.c0) Tasks.await(currentUserFromPigeon.S(bool.booleanValue()))));
        } catch (Exception e10) {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(e10));
        }
    }

    public static /* synthetic */ void G(GeneratedAndroidFirebaseAuth.Result result, m7.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseFirebaseUser(a0Var));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void H(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((m7.i) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static m7.a0 getCurrentUserFromPigeon(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(a7.g.p(authPigeonFirebaseApp.getAppName()));
        if (authPigeonFirebaseApp.getTenantId() != null) {
            firebaseAuth.z(authPigeonFirebaseApp.getTenantId());
        }
        return firebaseAuth.m();
    }

    public static /* synthetic */ void o(GeneratedAndroidFirebaseAuth.Result result, m7.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseFirebaseUser(a0Var));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void p(final m7.a0 a0Var, final GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            a0Var.a0().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.f0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    FlutterFirebaseAuthUser.t(result, a0Var, task2);
                }
            });
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void q(GeneratedAndroidFirebaseAuth.Result result, m7.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseFirebaseUser(a0Var));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void r(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((m7.i) task.getResult()));
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

    public static /* synthetic */ void t(GeneratedAndroidFirebaseAuth.Result result, m7.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseFirebaseUser(a0Var));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void u(final m7.a0 a0Var, final GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            a0Var.a0().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.v
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    FlutterFirebaseAuthUser.x(result, a0Var, task2);
                }
            });
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void v(final m7.a0 a0Var, final GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            a0Var.a0().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.z
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    FlutterFirebaseAuthUser.G(result, a0Var, task2);
                }
            });
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void w(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((m7.i) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void x(GeneratedAndroidFirebaseAuth.Result result, m7.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseFirebaseUser(a0Var));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void y(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((m7.i) task.getResult()));
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
        m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            voidResult.error(FlutterFirebaseAuthPluginException.noUser());
        } else {
            currentUserFromPigeon.R().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.o0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.E(voidResult, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void getIdToken(final GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, final Boolean bool, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonIdTokenResult> result) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: io.flutter.plugins.firebase.auth.a0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterFirebaseAuthUser.F(authPigeonFirebaseApp, result, bool);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void linkWithCredential(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, Map<String, Object> map, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        m7.h credential = PigeonParser.getCredential(map);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
        } else if (credential == null) {
            result.error(FlutterFirebaseAuthPluginException.invalidCredential());
        } else {
            currentUserFromPigeon.Y(credential).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.j0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.H(result, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void linkWithProvider(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonSignInProvider pigeonSignInProvider, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        n0.a aVarD = m7.n0.d(pigeonSignInProvider.getProviderId());
        if (pigeonSignInProvider.getScopes() != null) {
            aVarD.c(pigeonSignInProvider.getScopes());
        }
        if (pigeonSignInProvider.getCustomParameters() != null) {
            aVarD.a(pigeonSignInProvider.getCustomParameters());
        }
        currentUserFromPigeon.d0(this.activity, aVarD.b()).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.g0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthUser.r(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void reauthenticateWithCredential(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, Map<String, Object> map, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        m7.h credential = PigeonParser.getCredential(map);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
        } else if (credential == null) {
            result.error(FlutterFirebaseAuthPluginException.invalidCredential());
        } else {
            currentUserFromPigeon.Z(credential).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.e0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.w(result, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void reauthenticateWithProvider(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonSignInProvider pigeonSignInProvider, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        n0.a aVarD = m7.n0.d(pigeonSignInProvider.getProviderId());
        if (pigeonSignInProvider.getScopes() != null) {
            aVarD.c(pigeonSignInProvider.getScopes());
        }
        if (pigeonSignInProvider.getCustomParameters() != null) {
            aVarD.a(pigeonSignInProvider.getCustomParameters());
        }
        currentUserFromPigeon.e0(this.activity, aVarD.b()).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.w
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthUser.C(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void reload(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserDetails> result) {
        final m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
        } else {
            currentUserFromPigeon.a0().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.x
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.q(result, currentUserFromPigeon, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void sendEmailVerification(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonActionCodeSettings pigeonActionCodeSettings, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            voidResult.error(FlutterFirebaseAuthPluginException.noUser());
        } else if (pigeonActionCodeSettings == null) {
            currentUserFromPigeon.b0().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.h0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.z(voidResult, task);
                }
            });
        } else {
            currentUserFromPigeon.c0(PigeonParser.getActionCodeSettings(pigeonActionCodeSettings)).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.i0
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
        m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
        } else {
            currentUserFromPigeon.f0(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.n0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.y(result, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void updateEmail(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserDetails> result) {
        final m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
        } else {
            currentUserFromPigeon.g0(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.d0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.v(currentUserFromPigeon, result, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void updatePassword(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserDetails> result) {
        final m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
        } else {
            currentUserFromPigeon.h0(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.c0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.u(currentUserFromPigeon, result, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void updatePhoneNumber(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, Map<String, Object> map, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserDetails> result) {
        final m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
            return;
        }
        m7.o0 o0Var = (m7.o0) PigeonParser.getCredential(map);
        if (o0Var == null) {
            result.error(FlutterFirebaseAuthPluginException.invalidCredential());
        } else {
            currentUserFromPigeon.i0(o0Var).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.b0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.p(currentUserFromPigeon, result, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void updateProfile(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonUserProfile pigeonUserProfile, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserDetails> result) {
        final m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            result.error(FlutterFirebaseAuthPluginException.noUser());
            return;
        }
        c1.a aVar = new c1.a();
        if (pigeonUserProfile.getDisplayNameChanged().booleanValue()) {
            aVar.b(pigeonUserProfile.getDisplayName());
        }
        if (pigeonUserProfile.getPhotoUrlChanged().booleanValue()) {
            if (pigeonUserProfile.getPhotoUrl() != null) {
                aVar.c(Uri.parse(pigeonUserProfile.getPhotoUrl()));
            } else {
                aVar.c(null);
            }
        }
        currentUserFromPigeon.j0(aVar.a()).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.m0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseAuthUser.D(currentUserFromPigeon, result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi
    public void verifyBeforeUpdateEmail(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, GeneratedAndroidFirebaseAuth.PigeonActionCodeSettings pigeonActionCodeSettings, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        m7.a0 currentUserFromPigeon = getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            voidResult.error(FlutterFirebaseAuthPluginException.noUser());
        } else if (pigeonActionCodeSettings == null) {
            currentUserFromPigeon.k0(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.k0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.A(voidResult, task);
                }
            });
        } else {
            currentUserFromPigeon.l0(str, PigeonParser.getActionCodeSettings(pigeonActionCodeSettings)).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.l0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseAuthUser.s(voidResult, task);
                }
            });
        }
    }
}
