package com.google.firebase.auth;

import A1.a;
import A1.c;
import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthOptions;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class PhoneAuthProvider {
    public static final String PHONE_SIGN_IN_METHOD = "phone";
    public static final String PROVIDER_ID = "phone";
    private final FirebaseAuth zza;

    public static class ForceResendingToken extends a {
        public static final Parcelable.Creator<ForceResendingToken> CREATOR = new zzd();

        public static ForceResendingToken zza() {
            return new ForceResendingToken();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            c.b(parcel, c.a(parcel));
        }
    }

    public static abstract class OnVerificationStateChangedCallbacks {
        private static final C1.a zza = new C1.a("PhoneAuthProvider", new String[0]);

        public void onCodeAutoRetrievalTimeOut(String str) {
            zza.e("Sms auto retrieval timed-out.", new Object[0]);
        }

        public void onCodeSent(String str, ForceResendingToken forceResendingToken) {
        }

        public abstract void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential);

        public abstract void onVerificationFailed(FirebaseException firebaseException);
    }

    private PhoneAuthProvider(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public static PhoneAuthCredential getCredential(String str, String str2) {
        return PhoneAuthCredential.zza(str, str2);
    }

    @Deprecated
    public static PhoneAuthProvider getInstance() {
        return new PhoneAuthProvider(FirebaseAuth.getInstance(FirebaseApp.getInstance()));
    }

    public static void verifyPhoneNumber(PhoneAuthOptions phoneAuthOptions) {
        AbstractC0940s.k(phoneAuthOptions);
        FirebaseAuth.zza(phoneAuthOptions);
    }

    @Deprecated
    public static PhoneAuthProvider getInstance(FirebaseAuth firebaseAuth) {
        return new PhoneAuthProvider(firebaseAuth);
    }

    @Deprecated
    public void verifyPhoneNumber(String str, long j4, TimeUnit timeUnit, Activity activity, OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        verifyPhoneNumber(PhoneAuthOptions.newBuilder(this.zza).setPhoneNumber(str).setTimeout(Long.valueOf(j4), timeUnit).setActivity(activity).setCallbacks(onVerificationStateChangedCallbacks).build());
    }

    @Deprecated
    public void verifyPhoneNumber(String str, long j4, TimeUnit timeUnit, Activity activity, OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, ForceResendingToken forceResendingToken) {
        PhoneAuthOptions.Builder callbacks = PhoneAuthOptions.newBuilder(this.zza).setPhoneNumber(str).setTimeout(Long.valueOf(j4), timeUnit).setActivity(activity).setCallbacks(onVerificationStateChangedCallbacks);
        if (forceResendingToken != null) {
            callbacks.setForceResendingToken(forceResendingToken);
        }
        verifyPhoneNumber(callbacks.build());
    }
}
