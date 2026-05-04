package io.flutter.plugins.firebase.auth;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseTotpMultiFactor implements GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Map<String, m7.y0> multiFactorSecret = new HashMap();

    public static /* synthetic */ void d(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (!task.isSuccessful()) {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
            return;
        }
        m7.y0 y0Var = (m7.y0) task.getResult();
        multiFactorSecret.put(y0Var.i(), y0Var);
        result.success(new GeneratedAndroidFirebaseAuth.PigeonTotpSecret.Builder().setCodeIntervalSeconds(Long.valueOf(y0Var.g())).setCodeLength(Long.valueOf(y0Var.b())).setSecretKey(y0Var.i()).setHashingAlgorithm(y0Var.a()).setEnrollmentCompletionDeadline(Long.valueOf(y0Var.f())).build());
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi
    public void generateSecret(String str, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonTotpSecret> result) {
        m7.w0.a(FlutterFirebaseMultiFactor.multiFactorSessionMap.get(str)).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.u0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseTotpMultiFactor.d(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi
    public void getAssertionForEnrollment(String str, String str2, GeneratedAndroidFirebaseAuth.Result<String> result) {
        m7.v0 v0VarB = m7.w0.b(multiFactorSecret.get(str), str2);
        String string = UUID.randomUUID().toString();
        FlutterFirebaseMultiFactor.multiFactorAssertionMap.put(string, v0VarB);
        result.success(string);
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi
    public void getAssertionForSignIn(String str, String str2, GeneratedAndroidFirebaseAuth.Result<String> result) {
        m7.v0 v0VarC = m7.w0.c(str, str2);
        String string = UUID.randomUUID().toString();
        FlutterFirebaseMultiFactor.multiFactorAssertionMap.put(string, v0VarC);
        result.success(string);
    }
}
