package io.flutter.plugins.firebase.auth;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorGenerator;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseMultiFactor implements GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi, GeneratedAndroidFirebaseAuth.MultiFactoResolverHostApi {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Map<String, Map<String, MultiFactor>> multiFactorUserMap = new HashMap();
    static final Map<String, MultiFactorSession> multiFactorSessionMap = new HashMap();
    static final Map<String, MultiFactorResolver> multiFactorResolverMap = new HashMap();
    static final Map<String, MultiFactorAssertion> multiFactorAssertionMap = new HashMap();

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
            result.success(PigeonParser.parseAuthResult((AuthResult) task.getResult()));
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
        MultiFactorSession multiFactorSession = (MultiFactorSession) task.getResult();
        String string = UUID.randomUUID().toString();
        multiFactorSessionMap.put(string, multiFactorSession);
        result.success(new GeneratedAndroidFirebaseAuth.PigeonMultiFactorSession.Builder().setId(string).build());
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi
    public void enrollPhone(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonPhoneMultiFactorAssertion pigeonPhoneMultiFactorAssertion, String str, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        try {
            getAppMultiFactor(authPigeonFirebaseApp).enroll(PhoneMultiFactorGenerator.getAssertion(PhoneAuthProvider.getCredential(pigeonPhoneMultiFactorAssertion.getVerificationId(), pigeonPhoneMultiFactorAssertion.getVerificationCode())), str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.T
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseMultiFactor.h(voidResult, task);
                }
            });
        } catch (FirebaseNoSignedInUserException e4) {
            voidResult.error(e4);
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi
    public void enrollTotp(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, String str2, final GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        try {
            getAppMultiFactor(authPigeonFirebaseApp).enroll(multiFactorAssertionMap.get(str), str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.Q
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseMultiFactor.j(voidResult, task);
                }
            });
        } catch (FirebaseNoSignedInUserException e4) {
            voidResult.error(e4);
        }
    }

    public MultiFactor getAppMultiFactor(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp) throws FirebaseNoSignedInUserException {
        FirebaseUser currentUserFromPigeon = FlutterFirebaseAuthUser.getCurrentUserFromPigeon(authPigeonFirebaseApp);
        if (currentUserFromPigeon == null) {
            throw new FirebaseNoSignedInUserException("No user is signed in");
        }
        Map<String, Map<String, MultiFactor>> map = multiFactorUserMap;
        if (map.get(authPigeonFirebaseApp.getAppName()) == null) {
            map.put(authPigeonFirebaseApp.getAppName(), new HashMap());
        }
        Map<String, MultiFactor> map2 = map.get(authPigeonFirebaseApp.getAppName());
        if (map2.get(currentUserFromPigeon.getUid()) == null) {
            map2.put(currentUserFromPigeon.getUid(), currentUserFromPigeon.getMultiFactor());
        }
        return map2.get(currentUserFromPigeon.getUid());
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi
    public void getEnrolledFactors(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.Result<List<GeneratedAndroidFirebaseAuth.PigeonMultiFactorInfo>> result) {
        try {
            result.success(PigeonParser.multiFactorInfoToPigeon(getAppMultiFactor(authPigeonFirebaseApp).getEnrolledFactors()));
        } catch (FirebaseNoSignedInUserException e4) {
            result.error(e4);
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi
    public void getSession(GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonMultiFactorSession> result) {
        try {
            getAppMultiFactor(authPigeonFirebaseApp).getSession().addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.P
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseMultiFactor.k(result, task);
                }
            });
        } catch (FirebaseNoSignedInUserException e4) {
            result.error(e4);
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactoResolverHostApi
    public void resolveSignIn(String str, GeneratedAndroidFirebaseAuth.PigeonPhoneMultiFactorAssertion pigeonPhoneMultiFactorAssertion, String str2, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonUserCredential> result) {
        MultiFactorResolver multiFactorResolver = multiFactorResolverMap.get(str);
        if (multiFactorResolver == null) {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(new Exception("Resolver not found")));
        } else {
            multiFactorResolver.resolveSignIn(pigeonPhoneMultiFactorAssertion != null ? PhoneMultiFactorGenerator.getAssertion(PhoneAuthProvider.getCredential(pigeonPhoneMultiFactorAssertion.getVerificationId(), pigeonPhoneMultiFactorAssertion.getVerificationCode())) : multiFactorAssertionMap.get(str2)).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.O
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
            getAppMultiFactor(authPigeonFirebaseApp).unenroll(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.S
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FlutterFirebaseMultiFactor.g(voidResult, task);
                }
            });
        } catch (FirebaseNoSignedInUserException e4) {
            voidResult.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(e4));
        }
    }
}
