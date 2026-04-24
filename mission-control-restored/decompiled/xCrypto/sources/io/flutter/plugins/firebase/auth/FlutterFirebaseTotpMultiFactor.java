package io.flutter.plugins.firebase.auth;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.TotpMultiFactorGenerator;
import com.google.firebase.auth.TotpSecret;
import io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseTotpMultiFactor implements GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Map<String, TotpSecret> multiFactorSecret = new HashMap();

    public static /* synthetic */ void d(GeneratedAndroidFirebaseAuth.Result result, Task task) {
        if (!task.isSuccessful()) {
            result.error(FlutterFirebaseAuthPluginException.parserExceptionToFlutter(task.getException()));
            return;
        }
        TotpSecret totpSecret = (TotpSecret) task.getResult();
        multiFactorSecret.put(totpSecret.getSharedSecretKey(), totpSecret);
        result.success(new GeneratedAndroidFirebaseAuth.PigeonTotpSecret.Builder().setCodeIntervalSeconds(Long.valueOf(totpSecret.getCodeIntervalSeconds())).setCodeLength(Long.valueOf(totpSecret.getCodeLength())).setSecretKey(totpSecret.getSharedSecretKey()).setHashingAlgorithm(totpSecret.getHashAlgorithm()).setEnrollmentCompletionDeadline(Long.valueOf(totpSecret.getEnrollmentCompletionDeadline())).build());
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi
    public void generateSecret(String str, final GeneratedAndroidFirebaseAuth.Result<GeneratedAndroidFirebaseAuth.PigeonTotpSecret> result) {
        TotpMultiFactorGenerator.generateSecret(FlutterFirebaseMultiFactor.multiFactorSessionMap.get(str)).addOnCompleteListener(new OnCompleteListener() { // from class: io.flutter.plugins.firebase.auth.U
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FlutterFirebaseTotpMultiFactor.d(result, task);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi
    public void getAssertionForEnrollment(String str, String str2, GeneratedAndroidFirebaseAuth.Result<String> result) {
        TotpMultiFactorAssertion assertionForEnrollment = TotpMultiFactorGenerator.getAssertionForEnrollment(multiFactorSecret.get(str), str2);
        String string = UUID.randomUUID().toString();
        FlutterFirebaseMultiFactor.multiFactorAssertionMap.put(string, assertionForEnrollment);
        result.success(string);
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi
    public void getAssertionForSignIn(String str, String str2, GeneratedAndroidFirebaseAuth.Result<String> result) {
        TotpMultiFactorAssertion assertionForSignIn = TotpMultiFactorGenerator.getAssertionForSignIn(str, str2);
        String string = UUID.randomUUID().toString();
        FlutterFirebaseMultiFactor.multiFactorAssertionMap.put(string, assertionForSignIn);
        result.success(string);
    }
}
