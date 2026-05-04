package io.flutter.plugins.firebase.auth;

import android.app.Activity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.a;
import com.google.firebase.auth.b;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class PhoneNumberVerificationStreamHandler implements EventChannel.StreamHandler {
    private static final HashMap<Integer, b.a> forceResendingTokens = new HashMap<>();
    final AtomicReference<Activity> activityRef;
    String autoRetrievedSmsCodeForTesting;
    private EventChannel.EventSink eventSink;
    final FirebaseAuth firebaseAuth;
    Integer forceResendingToken;
    final m7.r0 multiFactorInfo;
    final m7.l0 multiFactorSession;
    final OnCredentialsListener onCredentialsListener;
    final String phoneNumber;
    final int timeout;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface OnCredentialsListener {
        void onCredentialsReceived(m7.o0 o0Var);
    }

    public PhoneNumberVerificationStreamHandler(Activity activity, GeneratedAndroidFirebaseAuth.AuthPigeonFirebaseApp authPigeonFirebaseApp, GeneratedAndroidFirebaseAuth.PigeonVerifyPhoneNumberRequest pigeonVerifyPhoneNumberRequest, m7.l0 l0Var, m7.r0 r0Var, OnCredentialsListener onCredentialsListener) {
        AtomicReference<Activity> atomicReference = new AtomicReference<>(null);
        this.activityRef = atomicReference;
        atomicReference.set(activity);
        this.multiFactorSession = l0Var;
        this.multiFactorInfo = r0Var;
        this.firebaseAuth = FlutterFirebaseAuthPlugin.getAuthFromPigeon(authPigeonFirebaseApp);
        this.phoneNumber = pigeonVerifyPhoneNumberRequest.getPhoneNumber();
        this.timeout = Math.toIntExact(pigeonVerifyPhoneNumberRequest.getTimeout().longValue());
        if (pigeonVerifyPhoneNumberRequest.getAutoRetrievedSmsCodeForTesting() != null) {
            this.autoRetrievedSmsCodeForTesting = pigeonVerifyPhoneNumberRequest.getAutoRetrievedSmsCodeForTesting();
        }
        if (pigeonVerifyPhoneNumberRequest.getForceResendingToken() != null) {
            this.forceResendingToken = Integer.valueOf(Math.toIntExact(pigeonVerifyPhoneNumberRequest.getForceResendingToken().longValue()));
        }
        this.onCredentialsListener = onCredentialsListener;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object obj) {
        this.eventSink = null;
        this.activityRef.set(null);
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        b.a aVar;
        this.eventSink = eventSink;
        b.AbstractC0100b abstractC0100b = new b.AbstractC0100b() { // from class: io.flutter.plugins.firebase.auth.PhoneNumberVerificationStreamHandler.1
            @Override // com.google.firebase.auth.b.AbstractC0100b
            public void onCodeAutoRetrievalTimeOut(String str) {
                HashMap map = new HashMap();
                map.put(Constants.VERIFICATION_ID, str);
                map.put("name", "Auth#phoneCodeAutoRetrievalTimeout");
                if (PhoneNumberVerificationStreamHandler.this.eventSink != null) {
                    PhoneNumberVerificationStreamHandler.this.eventSink.success(map);
                }
            }

            @Override // com.google.firebase.auth.b.AbstractC0100b
            public void onCodeSent(String str, b.a aVar2) {
                int iHashCode = aVar2.hashCode();
                PhoneNumberVerificationStreamHandler.forceResendingTokens.put(Integer.valueOf(iHashCode), aVar2);
                HashMap map = new HashMap();
                map.put(Constants.VERIFICATION_ID, str);
                map.put(Constants.FORCE_RESENDING_TOKEN, Integer.valueOf(iHashCode));
                map.put("name", "Auth#phoneCodeSent");
                if (PhoneNumberVerificationStreamHandler.this.eventSink != null) {
                    PhoneNumberVerificationStreamHandler.this.eventSink.success(map);
                }
            }

            @Override // com.google.firebase.auth.b.AbstractC0100b
            public void onVerificationCompleted(m7.o0 o0Var) {
                int iHashCode = o0Var.hashCode();
                PhoneNumberVerificationStreamHandler.this.onCredentialsListener.onCredentialsReceived(o0Var);
                HashMap map = new HashMap();
                map.put("token", Integer.valueOf(iHashCode));
                if (o0Var.U() != null) {
                    map.put(Constants.SMS_CODE, o0Var.U());
                }
                map.put("name", "Auth#phoneVerificationCompleted");
                if (PhoneNumberVerificationStreamHandler.this.eventSink != null) {
                    PhoneNumberVerificationStreamHandler.this.eventSink.success(map);
                }
            }

            @Override // com.google.firebase.auth.b.AbstractC0100b
            public void onVerificationFailed(a7.m mVar) {
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                GeneratedAndroidFirebaseAuth.FlutterError flutterError = FlutterFirebaseAuthPluginException.parserExceptionToFlutter(mVar);
                map2.put(io.flutter.plugins.firebase.database.Constants.ERROR_CODE, flutterError.code.replaceAll("ERROR_", "").toLowerCase(Locale.ROOT).replaceAll("_", "-"));
                map2.put(io.flutter.plugins.firebase.database.Constants.ERROR_MESSAGE, flutterError.getMessage());
                map2.put(io.flutter.plugins.firebase.database.Constants.ERROR_DETAILS, flutterError.details);
                map.put("error", map2);
                map.put("name", "Auth#phoneVerificationFailed");
                if (PhoneNumberVerificationStreamHandler.this.eventSink != null) {
                    PhoneNumberVerificationStreamHandler.this.eventSink.success(map);
                }
            }
        };
        if (this.autoRetrievedSmsCodeForTesting != null) {
            this.firebaseAuth.o().c(this.phoneNumber, this.autoRetrievedSmsCodeForTesting);
        }
        a.C0099a c0099a = new a.C0099a(this.firebaseAuth);
        c0099a.b(this.activityRef.get());
        c0099a.c(abstractC0100b);
        String str = this.phoneNumber;
        if (str != null) {
            c0099a.g(str);
        }
        m7.l0 l0Var = this.multiFactorSession;
        if (l0Var != null) {
            c0099a.f(l0Var);
        }
        m7.r0 r0Var = this.multiFactorInfo;
        if (r0Var != null) {
            c0099a.e(r0Var);
        }
        c0099a.h(Long.valueOf(this.timeout), TimeUnit.MILLISECONDS);
        Integer num = this.forceResendingToken;
        if (num != null && (aVar = forceResendingTokens.get(num)) != null) {
            c0099a.d(aVar);
        }
        com.google.firebase.auth.b.b(c0099a.a());
    }
}
