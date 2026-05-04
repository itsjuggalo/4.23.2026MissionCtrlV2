package io.flutter.plugins.firebase.auth;

import io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseTotpSecret implements GeneratedAndroidFirebaseAuth.MultiFactorTotpSecretHostApi {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorTotpSecretHostApi
    public void generateQrCodeUrl(String str, String str2, String str3, GeneratedAndroidFirebaseAuth.Result<String> result) {
        m7.y0 y0Var = FlutterFirebaseTotpMultiFactor.multiFactorSecret.get(str);
        if (str2 == null || str3 == null) {
            result.success(y0Var.e());
        } else {
            result.success(y0Var.d(str2, str3));
        }
    }

    @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorTotpSecretHostApi
    public void openInOtpApp(String str, String str2, GeneratedAndroidFirebaseAuth.VoidResult voidResult) {
        FlutterFirebaseTotpMultiFactor.multiFactorSecret.get(str).h(str2);
        voidResult.success();
    }
}
