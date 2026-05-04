package io.flutter.plugins.firebase.auth;

import io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterFirebaseAuthPluginException {
    public static GeneratedAndroidFirebaseAuth.FlutterError alreadyLinkedProvider() {
        return new GeneratedAndroidFirebaseAuth.FlutterError("PROVIDER_ALREADY_LINKED", "User has already been linked to the given provider.", null);
    }

    public static GeneratedAndroidFirebaseAuth.FlutterError invalidCredential() {
        return new GeneratedAndroidFirebaseAuth.FlutterError("INVALID_CREDENTIAL", "The supplied auth credential is malformed, has expired or is not currently supported.", null);
    }

    public static GeneratedAndroidFirebaseAuth.FlutterError noSuchProvider() {
        return new GeneratedAndroidFirebaseAuth.FlutterError("NO_SUCH_PROVIDER", "User was not linked to an account with the given provider.", null);
    }

    public static GeneratedAndroidFirebaseAuth.FlutterError noUser() {
        return new GeneratedAndroidFirebaseAuth.FlutterError("NO_CURRENT_USER", "No user currently signed in.", null);
    }

    public static GeneratedAndroidFirebaseAuth.FlutterError parserExceptionToFlutter(Exception exc) {
        if (exc == null) {
            return new GeneratedAndroidFirebaseAuth.FlutterError("UNKNOWN", null, null);
        }
        String message = exc.getMessage();
        HashMap map = new HashMap();
        if (exc instanceof m7.u) {
            m7.u uVar = (m7.u) exc;
            HashMap map2 = new HashMap();
            m7.k0 k0VarB = uVar.b();
            List listS = k0VarB.S();
            m7.l0 l0VarT = k0VarB.T();
            String string = UUID.randomUUID().toString();
            FlutterFirebaseMultiFactor.multiFactorSessionMap.put(string, l0VarT);
            String string2 = UUID.randomUUID().toString();
            FlutterFirebaseMultiFactor.multiFactorResolverMap.put(string2, k0VarB);
            List<List<Object>> listMultiFactorInfoToMap = PigeonParser.multiFactorInfoToMap(listS);
            map2.put("appName", uVar.b().R().l().q());
            map2.put(Constants.MULTI_FACTOR_HINTS, listMultiFactorInfoToMap);
            map2.put(Constants.MULTI_FACTOR_SESSION_ID, string);
            map2.put(Constants.MULTI_FACTOR_RESOLVER_ID, string2);
            return new GeneratedAndroidFirebaseAuth.FlutterError(uVar.a(), uVar.getLocalizedMessage(), map2);
        }
        if ((exc instanceof a7.o) || (exc.getCause() != null && (exc.getCause() instanceof a7.o))) {
            return new GeneratedAndroidFirebaseAuth.FlutterError("network-request-failed", "A network error (such as timeout, interrupted connection or unreachable host) has occurred.", null);
        }
        if ((exc instanceof a7.d) || (exc.getCause() != null && (exc.getCause() instanceof a7.d))) {
            return new GeneratedAndroidFirebaseAuth.FlutterError("api-not-available", "The requested API is not available.", null);
        }
        if ((exc instanceof a7.q) || (exc.getCause() != null && (exc.getCause() instanceof a7.q))) {
            return new GeneratedAndroidFirebaseAuth.FlutterError("too-many-requests", "We have blocked all requests from this device due to unusual activity. Try again later.", null);
        }
        if (exc.getMessage() != null && exc.getMessage().startsWith("Cannot create PhoneAuthCredential without either verificationProof")) {
            return new GeneratedAndroidFirebaseAuth.FlutterError("invalid-verification-code", "The verification ID used to create the phone auth credential is invalid.", null);
        }
        if (message != null && message.contains("User has already been linked to the given provider.")) {
            return alreadyLinkedProvider();
        }
        String strA = exc instanceof m7.q ? ((m7.q) exc).a() : "UNKNOWN";
        if (exc instanceof m7.y) {
            message = ((m7.y) exc).b();
        }
        if (exc instanceof m7.x) {
            m7.x xVar = (m7.x) exc;
            String strB = xVar.b();
            if (strB != null) {
                map.put(Constants.EMAIL, strB);
            }
            m7.h hVarC = xVar.c();
            if (hVarC != null) {
                map.put("authCredential", PigeonParser.parseAuthCredential(hVarC));
            }
        }
        return new GeneratedAndroidFirebaseAuth.FlutterError(strA, message, map);
    }
}
