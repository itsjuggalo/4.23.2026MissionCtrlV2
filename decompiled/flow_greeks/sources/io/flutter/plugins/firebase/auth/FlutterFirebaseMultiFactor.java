package io.flutter.plugins.firebase.auth;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseMultiFactor implements GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi, GeneratedAndroidFirebaseAuth.MultiFactoResolverHostApi {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Map<String, Map<String, m7.h0>> multiFactorUserMap = new HashMap();
    static final Map<String, m7.l0> multiFactorSessionMap = new HashMap();
    static final Map<String, m7.k0> multiFactorResolverMap = new HashMap();
    static final Map<String, m7.i0> multiFactorAssertionMap = new HashMap();

    public static /* synthetic */ void g(GeneratedAndroidFirebaseAuth.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void h(GeneratedAndroidFirebaseAuth.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void i(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (task.isSuccessful()) {
            result.success(PigeonParser.parseAuthResult((m7.i) task.getResult()));
        } else {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void j(GeneratedAndroidFirebaseAuth.VoidResult voidResult, Task task) {
        if (task.isSuccessful()) {
            voidResult.success();
        } else {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
        }
    }

    public static /* synthetic */ void k(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (!task.isSuccessful()) {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
            return;
        }
        m7.l0 l0Var = (m7.l0) task.getResult();
        String string = UUID.randomUUID().toString();
        multiFactorSessionMap.put(string, l0Var);
        result.success(new GeneratedAndroidFirebaseAuth.PigeonMultiFactorSession.Builder().setId(string).build());
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi
    public void enrollPhone(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonPhoneMultiFactorAssertion pigeonPhoneMultiFactorAssertion, String str, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        try {
            getAppMultiFactor(authPigeonFirebaseApp).a(m7.q0.a(com.google.firebase.auth.b.a(pigeonPhoneMultiFactorAssertion.getVerificationId(), pigeonPhoneMultiFactorAssertion.getVerificationCode())), str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.t0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseMultiFactor.h(voidResult, task);
                }
            });
        } catch (la.a e10) {
            voidResult.error(e10);
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi
    public void enrollTotp(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, String str2, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        try {
            getAppMultiFactor(authPigeonFirebaseApp).a(multiFactorAssertionMap.get(str), str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.r0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseMultiFactor.j(voidResult, task);
                }
            });
        } catch (la.a e10) {
            voidResult.error(e10);
        }
    }

    public m7.h0 getAppMultiFactor(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp) throws la.a {
        m7.a0 currentUserFromPigeon = FlutterFirebaseAuthUser.getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            throw new la.a("No user is signed in");
        }
        Map<String, Map<String, m7.h0>> map = multiFactorUserMap;
        if (map.get(authPigeonFirebaseApp.getAppName()) == null) {
            map.put(authPigeonFirebaseApp.getAppName(), new HashMap());
        }
        Map<String, m7.h0> map2 = map.get(authPigeonFirebaseApp.getAppName());
        if (map2.get(currentUserFromPigeon.a()) == null) {
            map2.put(currentUserFromPigeon.a(), currentUserFromPigeon.U());
        }
        return map2.get(currentUserFromPigeon.a());
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi
    public void getEnrolledFactors(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.Result<List<GeneratedAndroidFirebaseAuth.PigeonMultiFactorInfo>> result) {
        try {
            result.success(PigeonParser.multiFactorInfoToPigeon(getAppMultiFactor(authPigeonFirebaseApp).b()));
        } catch (la.a e10) {
            result.error(e10);
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi
    public void getSession(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonMultiFactorSession> result) {
        try {
            getAppMultiFactor(authPigeonFirebaseApp).c().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.q0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseMultiFactor.k(result, task);
                }
            });
        } catch (la.a e10) {
            result.error(e10);
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactoResolverHostApi
    public void resolveSignIn(String str, GeneratedAndroidFirebaseAuth.PigeonPhoneMultiFactorAssertion pigeonPhoneMultiFactorAssertion, String str2, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        m7.k0 k0Var = multiFactorResolverMap.get(str);
        if (k0Var == null) {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(new Exception("Resolver not found")));
        } else {
            k0Var.U(pigeonPhoneMultiFactorAssertion != null ? m7.q0.a(com.google.firebase.auth.b.a(pigeonPhoneMultiFactorAssertion.getVerificationId(), pigeonPhoneMultiFactorAssertion.getVerificationCode())) : multiFactorAssertionMap.get(str2)).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.p0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseMultiFactor.i(result, task);
                }
            });
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi
    public void unenroll(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        try {
            getAppMultiFactor(authPigeonFirebaseApp).d(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.s0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseMultiFactor.g(voidResult, task);
                }
            });
        } catch (la.a e10) {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(e10));
        }
    }
}
