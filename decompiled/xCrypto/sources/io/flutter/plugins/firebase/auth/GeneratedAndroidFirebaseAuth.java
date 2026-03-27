package io.flutter.plugins.firebase.auth;

import android.util.Log;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class GeneratedAndroidFirebaseAuth {

    public enum ActionCodeInfoOperation {
        UNKNOWN(0),
        PASSWORD_RESET(1),
        VERIFY_EMAIL(2),
        RECOVER_EMAIL(3),
        EMAIL_SIGN_IN(4),
        VERIFY_AND_CHANGE_EMAIL(5),
        REVERT_SECOND_FACTOR_ADDITION(6);

        final int index;

        ActionCodeInfoOperation(int i4) {
            this.index = i4;
        }
    }

    public static final class AuthPigeonFirebaseApp {
        private String appName;
        private String customAuthDomain;
        private String tenantId;

        public static final class Builder {
            private String appName;
            private String customAuthDomain;
            private String tenantId;

            public AuthPigeonFirebaseApp build() {
                AuthPigeonFirebaseApp authPigeonFirebaseApp = new AuthPigeonFirebaseApp();
                authPigeonFirebaseApp.setAppName(this.appName);
                authPigeonFirebaseApp.setTenantId(this.tenantId);
                authPigeonFirebaseApp.setCustomAuthDomain(this.customAuthDomain);
                return authPigeonFirebaseApp;
            }

            @CanIgnoreReturnValue
            public Builder setAppName(String str) {
                this.appName = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setCustomAuthDomain(String str) {
                this.customAuthDomain = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setTenantId(String str) {
                this.tenantId = str;
                return this;
            }
        }

        public static AuthPigeonFirebaseApp fromList(ArrayList<Object> arrayList) {
            AuthPigeonFirebaseApp authPigeonFirebaseApp = new AuthPigeonFirebaseApp();
            authPigeonFirebaseApp.setAppName((String) arrayList.get(0));
            authPigeonFirebaseApp.setTenantId((String) arrayList.get(1));
            authPigeonFirebaseApp.setCustomAuthDomain((String) arrayList.get(2));
            return authPigeonFirebaseApp;
        }

        public String getAppName() {
            return this.appName;
        }

        public String getCustomAuthDomain() {
            return this.customAuthDomain;
        }

        public String getTenantId() {
            return this.tenantId;
        }

        public void setAppName(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"appName\" is null.");
            }
            this.appName = str;
        }

        public void setCustomAuthDomain(String str) {
            this.customAuthDomain = str;
        }

        public void setTenantId(String str) {
            this.tenantId = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.appName);
            arrayList.add(this.tenantId);
            arrayList.add(this.customAuthDomain);
            return arrayList;
        }
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface CanIgnoreReturnValue {
    }

    public interface FirebaseAuthHostApi {
        static /* synthetic */ void a(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.signInWithEmailAndPassword((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2), new Result<PigeonUserCredential>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.11
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserCredential pigeonUserCredential) {
                    arrayList.add(0, pigeonUserCredential);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void b(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.checkActionCode((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), new Result<PigeonActionCodeInfo>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.5
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonActionCodeInfo pigeonActionCodeInfo) {
                    arrayList.add(0, pigeonActionCodeInfo);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void c(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.createUserWithEmailAndPassword((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2), new Result<PigeonUserCredential>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.7
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserCredential pigeonUserCredential) {
                    arrayList.add(0, pigeonUserCredential);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void d(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.sendPasswordResetEmail((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), (PigeonActionCodeSettings) arrayList2.get(2), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.16
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void e(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.signInWithCredential((AuthPigeonFirebaseApp) arrayList2.get(0), (Map) arrayList2.get(1), new Result<PigeonUserCredential>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.9
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserCredential pigeonUserCredential) {
                    arrayList.add(0, pigeonUserCredential);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void f(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.fetchSignInMethodsForEmail((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), new Result<List<String>>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.15
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(List<String> list) {
                    arrayList.add(0, list);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void g(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            firebaseAuthHostApi.signInAnonymously((AuthPigeonFirebaseApp) ((ArrayList) obj).get(0), new Result<PigeonUserCredential>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.8
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserCredential pigeonUserCredential) {
                    arrayList.add(0, pigeonUserCredential);
                    reply.reply(arrayList);
                }
            });
        }

        static MessageCodec<Object> getCodec() {
            return FirebaseAuthHostApiCodec.INSTANCE;
        }

        static /* synthetic */ void h(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            firebaseAuthHostApi.registerAuthStateListener((AuthPigeonFirebaseApp) ((ArrayList) obj).get(0), new Result<String>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.2
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void i(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.setSettings((AuthPigeonFirebaseApp) arrayList2.get(0), (PigeonFirebaseAuthSettings) arrayList2.get(1), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.19
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void j(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.signInWithProvider((AuthPigeonFirebaseApp) arrayList2.get(0), (PigeonSignInProvider) arrayList2.get(1), new Result<PigeonUserCredential>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.13
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserCredential pigeonUserCredential) {
                    arrayList.add(0, pigeonUserCredential);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void k(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.signInWithCustomToken((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), new Result<PigeonUserCredential>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.10
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserCredential pigeonUserCredential) {
                    arrayList.add(0, pigeonUserCredential);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void l(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            AuthPigeonFirebaseApp authPigeonFirebaseApp = (AuthPigeonFirebaseApp) arrayList2.get(0);
            String str = (String) arrayList2.get(1);
            Number number = (Number) arrayList2.get(2);
            firebaseAuthHostApi.useEmulator(authPigeonFirebaseApp, str, number == null ? null : Long.valueOf(number.longValue()), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.3
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void m(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.verifyPasswordResetCode((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), new Result<String>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.20
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void n(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.signInWithEmailLink((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2), new Result<PigeonUserCredential>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.12
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserCredential pigeonUserCredential) {
                    arrayList.add(0, pigeonUserCredential);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void o(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            firebaseAuthHostApi.registerIdTokenListener((AuthPigeonFirebaseApp) ((ArrayList) obj).get(0), new Result<String>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.1
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void p(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.setLanguageCode((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), new Result<String>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.18
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void q(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.confirmPasswordReset((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.6
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void r(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            firebaseAuthHostApi.initializeRecaptchaConfig((AuthPigeonFirebaseApp) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.23
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void s(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.applyActionCode((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.4
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static void setUp(BinaryMessenger binaryMessenger, FirebaseAuthHostApi firebaseAuthHostApi) {
            setUp(binaryMessenger, "", firebaseAuthHostApi);
        }

        static /* synthetic */ void t(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.verifyPhoneNumber((AuthPigeonFirebaseApp) arrayList2.get(0), (PigeonVerifyPhoneNumberRequest) arrayList2.get(1), new Result<String>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.21
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void u(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            firebaseAuthHostApi.signOut((AuthPigeonFirebaseApp) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.14
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void v(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.sendSignInLinkToEmail((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), (PigeonActionCodeSettings) arrayList2.get(2), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.17
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void w(FirebaseAuthHostApi firebaseAuthHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthHostApi.revokeTokenWithAuthorizationCode((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.22
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        void applyActionCode(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, VoidResult voidResult);

        void checkActionCode(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, Result<PigeonActionCodeInfo> result);

        void confirmPasswordReset(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, String str2, VoidResult voidResult);

        void createUserWithEmailAndPassword(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, String str2, Result<PigeonUserCredential> result);

        void fetchSignInMethodsForEmail(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, Result<List<String>> result);

        void initializeRecaptchaConfig(AuthPigeonFirebaseApp authPigeonFirebaseApp, VoidResult voidResult);

        void registerAuthStateListener(AuthPigeonFirebaseApp authPigeonFirebaseApp, Result<String> result);

        void registerIdTokenListener(AuthPigeonFirebaseApp authPigeonFirebaseApp, Result<String> result);

        void revokeTokenWithAuthorizationCode(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, VoidResult voidResult);

        void sendPasswordResetEmail(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, PigeonActionCodeSettings pigeonActionCodeSettings, VoidResult voidResult);

        void sendSignInLinkToEmail(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, PigeonActionCodeSettings pigeonActionCodeSettings, VoidResult voidResult);

        void setLanguageCode(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, Result<String> result);

        void setSettings(AuthPigeonFirebaseApp authPigeonFirebaseApp, PigeonFirebaseAuthSettings pigeonFirebaseAuthSettings, VoidResult voidResult);

        void signInAnonymously(AuthPigeonFirebaseApp authPigeonFirebaseApp, Result<PigeonUserCredential> result);

        void signInWithCredential(AuthPigeonFirebaseApp authPigeonFirebaseApp, Map<String, Object> map, Result<PigeonUserCredential> result);

        void signInWithCustomToken(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, Result<PigeonUserCredential> result);

        void signInWithEmailAndPassword(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, String str2, Result<PigeonUserCredential> result);

        void signInWithEmailLink(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, String str2, Result<PigeonUserCredential> result);

        void signInWithProvider(AuthPigeonFirebaseApp authPigeonFirebaseApp, PigeonSignInProvider pigeonSignInProvider, Result<PigeonUserCredential> result);

        void signOut(AuthPigeonFirebaseApp authPigeonFirebaseApp, VoidResult voidResult);

        void useEmulator(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, Long l4, VoidResult voidResult);

        void verifyPasswordResetCode(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, Result<String> result);

        void verifyPhoneNumber(AuthPigeonFirebaseApp authPigeonFirebaseApp, PigeonVerifyPhoneNumberRequest pigeonVerifyPhoneNumberRequest, Result<String> result);

        static void setUp(BinaryMessenger binaryMessenger, String str, final FirebaseAuthHostApi firebaseAuthHostApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.registerIdTokenListener" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.V
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.o(this.f12455a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.registerAuthStateListener" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.X
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.h(this.f12457a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.useEmulator" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.b0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.l(this.f12465a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.applyActionCode" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.c0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.s(this.f12467a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.checkActionCode" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.d0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.b(this.f12469a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.confirmPasswordReset" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.e0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.q(this.f12471a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.createUserWithEmailAndPassword" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.f0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.c(this.f12473a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel7.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInAnonymously" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.h0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.g(this.f12477a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel8.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithCredential" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.i0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.e(this.f12479a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel9.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithCustomToken" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.j0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.k(this.f12481a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel10.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithEmailAndPassword" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.g0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.a(this.f12475a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel11.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithEmailLink" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel12.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.k0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.n(this.f12483a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel12.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithProvider" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel13.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.l0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.j(this.f12485a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel13.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel14 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signOut" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel14.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.m0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.u(this.f12487a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel14.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel15 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.fetchSignInMethodsForEmail" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel15.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.n0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.f(this.f12490a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel15.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel16 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.sendPasswordResetEmail" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel16.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.o0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.d(this.f12493a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel16.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel17 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.sendSignInLinkToEmail" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel17.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.p0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.v(this.f12495a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel17.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel18 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.setLanguageCode" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel18.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.q0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.p(this.f12497a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel18.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel19 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.setSettings" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel19.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.r0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.i(this.f12499a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel19.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel20 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.verifyPasswordResetCode" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel20.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.W
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.m(this.f12456a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel20.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel21 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.verifyPhoneNumber" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel21.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.Y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.t(this.f12458a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel21.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel22 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.revokeTokenWithAuthorizationCode" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel22.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.Z
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.w(this.f12459a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel22.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel23 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.initializeRecaptchaConfig" + str2, getCodec());
            if (firebaseAuthHostApi != null) {
                basicMessageChannel23.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.a0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthHostApi.r(this.f12463a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel23.setMessageHandler(null);
            }
        }
    }

    public static class FirebaseAuthHostApiCodec extends StandardMessageCodec {
        public static final FirebaseAuthHostApiCodec INSTANCE = new FirebaseAuthHostApiCodec();

        private FirebaseAuthHostApiCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b4, ByteBuffer byteBuffer) {
            switch (b4) {
                case -128:
                    return AuthPigeonFirebaseApp.fromList((ArrayList) readValue(byteBuffer));
                case -127:
                    return PigeonActionCodeInfo.fromList((ArrayList) readValue(byteBuffer));
                case -126:
                    return PigeonActionCodeInfoData.fromList((ArrayList) readValue(byteBuffer));
                case -125:
                    return PigeonActionCodeSettings.fromList((ArrayList) readValue(byteBuffer));
                case -124:
                    return PigeonAdditionalUserInfo.fromList((ArrayList) readValue(byteBuffer));
                case -123:
                    return PigeonAuthCredential.fromList((ArrayList) readValue(byteBuffer));
                case -122:
                    return PigeonFirebaseAuthSettings.fromList((ArrayList) readValue(byteBuffer));
                case -121:
                    return PigeonIdTokenResult.fromList((ArrayList) readValue(byteBuffer));
                case -120:
                    return PigeonMultiFactorInfo.fromList((ArrayList) readValue(byteBuffer));
                case -119:
                    return PigeonMultiFactorSession.fromList((ArrayList) readValue(byteBuffer));
                case -118:
                    return PigeonPhoneMultiFactorAssertion.fromList((ArrayList) readValue(byteBuffer));
                case -117:
                    return PigeonSignInProvider.fromList((ArrayList) readValue(byteBuffer));
                case -116:
                    return PigeonTotpSecret.fromList((ArrayList) readValue(byteBuffer));
                case -115:
                    return PigeonUserCredential.fromList((ArrayList) readValue(byteBuffer));
                case -114:
                    return PigeonUserDetails.fromList((ArrayList) readValue(byteBuffer));
                case -113:
                    return PigeonUserInfo.fromList((ArrayList) readValue(byteBuffer));
                case -112:
                    return PigeonUserProfile.fromList((ArrayList) readValue(byteBuffer));
                case -111:
                    return PigeonVerifyPhoneNumberRequest.fromList((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b4, byteBuffer);
            }
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof AuthPigeonFirebaseApp) {
                byteArrayOutputStream.write(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                writeValue(byteArrayOutputStream, ((AuthPigeonFirebaseApp) obj).toList());
                return;
            }
            if (obj instanceof PigeonActionCodeInfo) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((PigeonActionCodeInfo) obj).toList());
                return;
            }
            if (obj instanceof PigeonActionCodeInfoData) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((PigeonActionCodeInfoData) obj).toList());
                return;
            }
            if (obj instanceof PigeonActionCodeSettings) {
                byteArrayOutputStream.write(131);
                writeValue(byteArrayOutputStream, ((PigeonActionCodeSettings) obj).toList());
                return;
            }
            if (obj instanceof PigeonAdditionalUserInfo) {
                byteArrayOutputStream.write(132);
                writeValue(byteArrayOutputStream, ((PigeonAdditionalUserInfo) obj).toList());
                return;
            }
            if (obj instanceof PigeonAuthCredential) {
                byteArrayOutputStream.write(133);
                writeValue(byteArrayOutputStream, ((PigeonAuthCredential) obj).toList());
                return;
            }
            if (obj instanceof PigeonFirebaseAuthSettings) {
                byteArrayOutputStream.write(134);
                writeValue(byteArrayOutputStream, ((PigeonFirebaseAuthSettings) obj).toList());
                return;
            }
            if (obj instanceof PigeonIdTokenResult) {
                byteArrayOutputStream.write(135);
                writeValue(byteArrayOutputStream, ((PigeonIdTokenResult) obj).toList());
                return;
            }
            if (obj instanceof PigeonMultiFactorInfo) {
                byteArrayOutputStream.write(136);
                writeValue(byteArrayOutputStream, ((PigeonMultiFactorInfo) obj).toList());
                return;
            }
            if (obj instanceof PigeonMultiFactorSession) {
                byteArrayOutputStream.write(137);
                writeValue(byteArrayOutputStream, ((PigeonMultiFactorSession) obj).toList());
                return;
            }
            if (obj instanceof PigeonPhoneMultiFactorAssertion) {
                byteArrayOutputStream.write(138);
                writeValue(byteArrayOutputStream, ((PigeonPhoneMultiFactorAssertion) obj).toList());
                return;
            }
            if (obj instanceof PigeonSignInProvider) {
                byteArrayOutputStream.write(139);
                writeValue(byteArrayOutputStream, ((PigeonSignInProvider) obj).toList());
                return;
            }
            if (obj instanceof PigeonTotpSecret) {
                byteArrayOutputStream.write(140);
                writeValue(byteArrayOutputStream, ((PigeonTotpSecret) obj).toList());
                return;
            }
            if (obj instanceof PigeonUserCredential) {
                byteArrayOutputStream.write(141);
                writeValue(byteArrayOutputStream, ((PigeonUserCredential) obj).toList());
                return;
            }
            if (obj instanceof PigeonUserDetails) {
                byteArrayOutputStream.write(142);
                writeValue(byteArrayOutputStream, ((PigeonUserDetails) obj).toList());
                return;
            }
            if (obj instanceof PigeonUserInfo) {
                byteArrayOutputStream.write(143);
                writeValue(byteArrayOutputStream, ((PigeonUserInfo) obj).toList());
            } else if (obj instanceof PigeonUserProfile) {
                byteArrayOutputStream.write(144);
                writeValue(byteArrayOutputStream, ((PigeonUserProfile) obj).toList());
            } else if (!(obj instanceof PigeonVerifyPhoneNumberRequest)) {
                super.writeValue(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(145);
                writeValue(byteArrayOutputStream, ((PigeonVerifyPhoneNumberRequest) obj).toList());
            }
        }
    }

    public interface FirebaseAuthUserHostApi {
        static /* synthetic */ void a(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthUserHostApi.getIdToken((AuthPigeonFirebaseApp) arrayList2.get(0), (Boolean) arrayList2.get(1), new Result<PigeonIdTokenResult>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.2
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonIdTokenResult pigeonIdTokenResult) {
                    arrayList.add(0, pigeonIdTokenResult);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void b(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthUserHostApi.updateProfile((AuthPigeonFirebaseApp) arrayList2.get(0), (PigeonUserProfile) arrayList2.get(1), new Result<PigeonUserDetails>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.13
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserDetails pigeonUserDetails) {
                    arrayList.add(0, pigeonUserDetails);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void c(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthUserHostApi.linkWithProvider((AuthPigeonFirebaseApp) arrayList2.get(0), (PigeonSignInProvider) arrayList2.get(1), new Result<PigeonUserCredential>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.4
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserCredential pigeonUserCredential) {
                    arrayList.add(0, pigeonUserCredential);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void d(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthUserHostApi.updatePhoneNumber((AuthPigeonFirebaseApp) arrayList2.get(0), (Map) arrayList2.get(1), new Result<PigeonUserDetails>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.12
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserDetails pigeonUserDetails) {
                    arrayList.add(0, pigeonUserDetails);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void e(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthUserHostApi.sendEmailVerification((AuthPigeonFirebaseApp) arrayList2.get(0), (PigeonActionCodeSettings) arrayList2.get(1), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.8
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void f(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            firebaseAuthUserHostApi.reload((AuthPigeonFirebaseApp) ((ArrayList) obj).get(0), new Result<PigeonUserDetails>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.7
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserDetails pigeonUserDetails) {
                    arrayList.add(0, pigeonUserDetails);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void g(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthUserHostApi.unlink((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), new Result<PigeonUserCredential>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.9
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserCredential pigeonUserCredential) {
                    arrayList.add(0, pigeonUserCredential);
                    reply.reply(arrayList);
                }
            });
        }

        static MessageCodec<Object> getCodec() {
            return FirebaseAuthUserHostApiCodec.INSTANCE;
        }

        static /* synthetic */ void h(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthUserHostApi.updatePassword((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), new Result<PigeonUserDetails>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.11
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserDetails pigeonUserDetails) {
                    arrayList.add(0, pigeonUserDetails);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void i(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthUserHostApi.linkWithCredential((AuthPigeonFirebaseApp) arrayList2.get(0), (Map) arrayList2.get(1), new Result<PigeonUserCredential>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.3
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserCredential pigeonUserCredential) {
                    arrayList.add(0, pigeonUserCredential);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void j(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthUserHostApi.reauthenticateWithProvider((AuthPigeonFirebaseApp) arrayList2.get(0), (PigeonSignInProvider) arrayList2.get(1), new Result<PigeonUserCredential>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.6
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserCredential pigeonUserCredential) {
                    arrayList.add(0, pigeonUserCredential);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void k(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            firebaseAuthUserHostApi.delete((AuthPigeonFirebaseApp) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.1
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void l(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthUserHostApi.updateEmail((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), new Result<PigeonUserDetails>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.10
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserDetails pigeonUserDetails) {
                    arrayList.add(0, pigeonUserDetails);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void m(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthUserHostApi.reauthenticateWithCredential((AuthPigeonFirebaseApp) arrayList2.get(0), (Map) arrayList2.get(1), new Result<PigeonUserCredential>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.5
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserCredential pigeonUserCredential) {
                    arrayList.add(0, pigeonUserCredential);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void n(FirebaseAuthUserHostApi firebaseAuthUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAuthUserHostApi.verifyBeforeUpdateEmail((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), (PigeonActionCodeSettings) arrayList2.get(2), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.14
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static void setUp(BinaryMessenger binaryMessenger, FirebaseAuthUserHostApi firebaseAuthUserHostApi) {
            setUp(binaryMessenger, "", firebaseAuthUserHostApi);
        }

        void delete(AuthPigeonFirebaseApp authPigeonFirebaseApp, VoidResult voidResult);

        void getIdToken(AuthPigeonFirebaseApp authPigeonFirebaseApp, Boolean bool, Result<PigeonIdTokenResult> result);

        void linkWithCredential(AuthPigeonFirebaseApp authPigeonFirebaseApp, Map<String, Object> map, Result<PigeonUserCredential> result);

        void linkWithProvider(AuthPigeonFirebaseApp authPigeonFirebaseApp, PigeonSignInProvider pigeonSignInProvider, Result<PigeonUserCredential> result);

        void reauthenticateWithCredential(AuthPigeonFirebaseApp authPigeonFirebaseApp, Map<String, Object> map, Result<PigeonUserCredential> result);

        void reauthenticateWithProvider(AuthPigeonFirebaseApp authPigeonFirebaseApp, PigeonSignInProvider pigeonSignInProvider, Result<PigeonUserCredential> result);

        void reload(AuthPigeonFirebaseApp authPigeonFirebaseApp, Result<PigeonUserDetails> result);

        void sendEmailVerification(AuthPigeonFirebaseApp authPigeonFirebaseApp, PigeonActionCodeSettings pigeonActionCodeSettings, VoidResult voidResult);

        void unlink(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, Result<PigeonUserCredential> result);

        void updateEmail(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, Result<PigeonUserDetails> result);

        void updatePassword(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, Result<PigeonUserDetails> result);

        void updatePhoneNumber(AuthPigeonFirebaseApp authPigeonFirebaseApp, Map<String, Object> map, Result<PigeonUserDetails> result);

        void updateProfile(AuthPigeonFirebaseApp authPigeonFirebaseApp, PigeonUserProfile pigeonUserProfile, Result<PigeonUserDetails> result);

        void verifyBeforeUpdateEmail(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, PigeonActionCodeSettings pigeonActionCodeSettings, VoidResult voidResult);

        static void setUp(BinaryMessenger binaryMessenger, String str, final FirebaseAuthUserHostApi firebaseAuthUserHostApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.delete" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.s0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.k(this.f12500a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.getIdToken" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.B0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.a(this.f12414a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.linkWithCredential" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.C0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.i(this.f12417a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.linkWithProvider" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.D0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.c(this.f12419a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.reauthenticateWithCredential" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.E0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.m(this.f12422a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.reauthenticateWithProvider" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.F0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.j(this.f12424a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.reload" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.t0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.f(this.f12502a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel7.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.sendEmailVerification" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.u0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.e(this.f12505a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel8.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.unlink" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.v0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.g(this.f12507a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel9.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.updateEmail" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.w0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.l(this.f12510a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel10.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.updatePassword" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.x0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.h(this.f12513a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel11.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.updatePhoneNumber" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel12.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.y0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.d(this.f12516a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel12.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.updateProfile" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel13.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.z0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.b(this.f12520a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel13.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel14 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.verifyBeforeUpdateEmail" + str2, getCodec());
            if (firebaseAuthUserHostApi != null) {
                basicMessageChannel14.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.A0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.FirebaseAuthUserHostApi.n(this.f12411a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel14.setMessageHandler(null);
            }
        }
    }

    public static class FirebaseAuthUserHostApiCodec extends StandardMessageCodec {
        public static final FirebaseAuthUserHostApiCodec INSTANCE = new FirebaseAuthUserHostApiCodec();

        private FirebaseAuthUserHostApiCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b4, ByteBuffer byteBuffer) {
            switch (b4) {
                case -128:
                    return AuthPigeonFirebaseApp.fromList((ArrayList) readValue(byteBuffer));
                case -127:
                    return PigeonActionCodeInfo.fromList((ArrayList) readValue(byteBuffer));
                case -126:
                    return PigeonActionCodeInfoData.fromList((ArrayList) readValue(byteBuffer));
                case -125:
                    return PigeonActionCodeSettings.fromList((ArrayList) readValue(byteBuffer));
                case -124:
                    return PigeonAdditionalUserInfo.fromList((ArrayList) readValue(byteBuffer));
                case -123:
                    return PigeonAuthCredential.fromList((ArrayList) readValue(byteBuffer));
                case -122:
                    return PigeonFirebaseAuthSettings.fromList((ArrayList) readValue(byteBuffer));
                case -121:
                    return PigeonIdTokenResult.fromList((ArrayList) readValue(byteBuffer));
                case -120:
                    return PigeonMultiFactorInfo.fromList((ArrayList) readValue(byteBuffer));
                case -119:
                    return PigeonMultiFactorSession.fromList((ArrayList) readValue(byteBuffer));
                case -118:
                    return PigeonPhoneMultiFactorAssertion.fromList((ArrayList) readValue(byteBuffer));
                case -117:
                    return PigeonSignInProvider.fromList((ArrayList) readValue(byteBuffer));
                case -116:
                    return PigeonTotpSecret.fromList((ArrayList) readValue(byteBuffer));
                case -115:
                    return PigeonUserCredential.fromList((ArrayList) readValue(byteBuffer));
                case -114:
                    return PigeonUserDetails.fromList((ArrayList) readValue(byteBuffer));
                case -113:
                    return PigeonUserInfo.fromList((ArrayList) readValue(byteBuffer));
                case -112:
                    return PigeonUserProfile.fromList((ArrayList) readValue(byteBuffer));
                case -111:
                    return PigeonVerifyPhoneNumberRequest.fromList((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b4, byteBuffer);
            }
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof AuthPigeonFirebaseApp) {
                byteArrayOutputStream.write(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                writeValue(byteArrayOutputStream, ((AuthPigeonFirebaseApp) obj).toList());
                return;
            }
            if (obj instanceof PigeonActionCodeInfo) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((PigeonActionCodeInfo) obj).toList());
                return;
            }
            if (obj instanceof PigeonActionCodeInfoData) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((PigeonActionCodeInfoData) obj).toList());
                return;
            }
            if (obj instanceof PigeonActionCodeSettings) {
                byteArrayOutputStream.write(131);
                writeValue(byteArrayOutputStream, ((PigeonActionCodeSettings) obj).toList());
                return;
            }
            if (obj instanceof PigeonAdditionalUserInfo) {
                byteArrayOutputStream.write(132);
                writeValue(byteArrayOutputStream, ((PigeonAdditionalUserInfo) obj).toList());
                return;
            }
            if (obj instanceof PigeonAuthCredential) {
                byteArrayOutputStream.write(133);
                writeValue(byteArrayOutputStream, ((PigeonAuthCredential) obj).toList());
                return;
            }
            if (obj instanceof PigeonFirebaseAuthSettings) {
                byteArrayOutputStream.write(134);
                writeValue(byteArrayOutputStream, ((PigeonFirebaseAuthSettings) obj).toList());
                return;
            }
            if (obj instanceof PigeonIdTokenResult) {
                byteArrayOutputStream.write(135);
                writeValue(byteArrayOutputStream, ((PigeonIdTokenResult) obj).toList());
                return;
            }
            if (obj instanceof PigeonMultiFactorInfo) {
                byteArrayOutputStream.write(136);
                writeValue(byteArrayOutputStream, ((PigeonMultiFactorInfo) obj).toList());
                return;
            }
            if (obj instanceof PigeonMultiFactorSession) {
                byteArrayOutputStream.write(137);
                writeValue(byteArrayOutputStream, ((PigeonMultiFactorSession) obj).toList());
                return;
            }
            if (obj instanceof PigeonPhoneMultiFactorAssertion) {
                byteArrayOutputStream.write(138);
                writeValue(byteArrayOutputStream, ((PigeonPhoneMultiFactorAssertion) obj).toList());
                return;
            }
            if (obj instanceof PigeonSignInProvider) {
                byteArrayOutputStream.write(139);
                writeValue(byteArrayOutputStream, ((PigeonSignInProvider) obj).toList());
                return;
            }
            if (obj instanceof PigeonTotpSecret) {
                byteArrayOutputStream.write(140);
                writeValue(byteArrayOutputStream, ((PigeonTotpSecret) obj).toList());
                return;
            }
            if (obj instanceof PigeonUserCredential) {
                byteArrayOutputStream.write(141);
                writeValue(byteArrayOutputStream, ((PigeonUserCredential) obj).toList());
                return;
            }
            if (obj instanceof PigeonUserDetails) {
                byteArrayOutputStream.write(142);
                writeValue(byteArrayOutputStream, ((PigeonUserDetails) obj).toList());
                return;
            }
            if (obj instanceof PigeonUserInfo) {
                byteArrayOutputStream.write(143);
                writeValue(byteArrayOutputStream, ((PigeonUserInfo) obj).toList());
            } else if (obj instanceof PigeonUserProfile) {
                byteArrayOutputStream.write(144);
                writeValue(byteArrayOutputStream, ((PigeonUserProfile) obj).toList());
            } else if (!(obj instanceof PigeonVerifyPhoneNumberRequest)) {
                super.writeValue(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(145);
                writeValue(byteArrayOutputStream, ((PigeonVerifyPhoneNumberRequest) obj).toList());
            }
        }
    }

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(String str, String str2, Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    public interface GenerateInterfaces {
        static /* synthetic */ void a(GenerateInterfaces generateInterfaces, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                generateInterfaces.pigeonInterface((PigeonMultiFactorInfo) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = GeneratedAndroidFirebaseAuth.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static MessageCodec<Object> getCodec() {
            return GenerateInterfacesCodec.INSTANCE;
        }

        static void setUp(BinaryMessenger binaryMessenger, GenerateInterfaces generateInterfaces) {
            setUp(binaryMessenger, "", generateInterfaces);
        }

        void pigeonInterface(PigeonMultiFactorInfo pigeonMultiFactorInfo);

        static void setUp(BinaryMessenger binaryMessenger, String str, final GenerateInterfaces generateInterfaces) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.GenerateInterfaces.pigeonInterface" + str2, getCodec());
            if (generateInterfaces != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.G0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.GenerateInterfaces.a(this.f12426a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
        }
    }

    public static class GenerateInterfacesCodec extends StandardMessageCodec {
        public static final GenerateInterfacesCodec INSTANCE = new GenerateInterfacesCodec();

        private GenerateInterfacesCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b4, ByteBuffer byteBuffer) {
            return b4 != -128 ? super.readValueOfType(b4, byteBuffer) : PigeonMultiFactorInfo.fromList((ArrayList) readValue(byteBuffer));
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (!(obj instanceof PigeonMultiFactorInfo)) {
                super.writeValue(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                writeValue(byteArrayOutputStream, ((PigeonMultiFactorInfo) obj).toList());
            }
        }
    }

    public interface MultiFactoResolverHostApi {
        static /* synthetic */ void e(MultiFactoResolverHostApi multiFactoResolverHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            multiFactoResolverHostApi.resolveSignIn((String) arrayList2.get(0), (PigeonPhoneMultiFactorAssertion) arrayList2.get(1), (String) arrayList2.get(2), new Result<PigeonUserCredential>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactoResolverHostApi.1
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonUserCredential pigeonUserCredential) {
                    arrayList.add(0, pigeonUserCredential);
                    reply.reply(arrayList);
                }
            });
        }

        static MessageCodec<Object> getCodec() {
            return MultiFactoResolverHostApiCodec.INSTANCE;
        }

        static void setUp(BinaryMessenger binaryMessenger, MultiFactoResolverHostApi multiFactoResolverHostApi) {
            setUp(binaryMessenger, "", multiFactoResolverHostApi);
        }

        void resolveSignIn(String str, PigeonPhoneMultiFactorAssertion pigeonPhoneMultiFactorAssertion, String str2, Result<PigeonUserCredential> result);

        static void setUp(BinaryMessenger binaryMessenger, String str, final MultiFactoResolverHostApi multiFactoResolverHostApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactoResolverHostApi.resolveSignIn" + str2, getCodec());
            if (multiFactoResolverHostApi != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.H0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.MultiFactoResolverHostApi.e(this.f12428a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
        }
    }

    public static class MultiFactoResolverHostApiCodec extends StandardMessageCodec {
        public static final MultiFactoResolverHostApiCodec INSTANCE = new MultiFactoResolverHostApiCodec();

        private MultiFactoResolverHostApiCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b4, ByteBuffer byteBuffer) {
            switch (b4) {
                case -128:
                    return PigeonAdditionalUserInfo.fromList((ArrayList) readValue(byteBuffer));
                case -127:
                    return PigeonAuthCredential.fromList((ArrayList) readValue(byteBuffer));
                case -126:
                    return PigeonPhoneMultiFactorAssertion.fromList((ArrayList) readValue(byteBuffer));
                case -125:
                    return PigeonUserCredential.fromList((ArrayList) readValue(byteBuffer));
                case -124:
                    return PigeonUserDetails.fromList((ArrayList) readValue(byteBuffer));
                case -123:
                    return PigeonUserInfo.fromList((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b4, byteBuffer);
            }
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof PigeonAdditionalUserInfo) {
                byteArrayOutputStream.write(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                writeValue(byteArrayOutputStream, ((PigeonAdditionalUserInfo) obj).toList());
                return;
            }
            if (obj instanceof PigeonAuthCredential) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((PigeonAuthCredential) obj).toList());
                return;
            }
            if (obj instanceof PigeonPhoneMultiFactorAssertion) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((PigeonPhoneMultiFactorAssertion) obj).toList());
                return;
            }
            if (obj instanceof PigeonUserCredential) {
                byteArrayOutputStream.write(131);
                writeValue(byteArrayOutputStream, ((PigeonUserCredential) obj).toList());
            } else if (obj instanceof PigeonUserDetails) {
                byteArrayOutputStream.write(132);
                writeValue(byteArrayOutputStream, ((PigeonUserDetails) obj).toList());
            } else if (!(obj instanceof PigeonUserInfo)) {
                super.writeValue(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(133);
                writeValue(byteArrayOutputStream, ((PigeonUserInfo) obj).toList());
            }
        }
    }

    public interface MultiFactorTotpHostApi {
        static /* synthetic */ void a(MultiFactorTotpHostApi multiFactorTotpHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            multiFactorTotpHostApi.getAssertionForEnrollment((String) arrayList2.get(0), (String) arrayList2.get(1), new Result<String>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi.2
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void b(MultiFactorTotpHostApi multiFactorTotpHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            multiFactorTotpHostApi.getAssertionForSignIn((String) arrayList2.get(0), (String) arrayList2.get(1), new Result<String>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi.3
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void c(MultiFactorTotpHostApi multiFactorTotpHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            multiFactorTotpHostApi.generateSecret((String) ((ArrayList) obj).get(0), new Result<PigeonTotpSecret>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi.1
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonTotpSecret pigeonTotpSecret) {
                    arrayList.add(0, pigeonTotpSecret);
                    reply.reply(arrayList);
                }
            });
        }

        static MessageCodec<Object> getCodec() {
            return MultiFactorTotpHostApiCodec.INSTANCE;
        }

        static void setUp(BinaryMessenger binaryMessenger, MultiFactorTotpHostApi multiFactorTotpHostApi) {
            setUp(binaryMessenger, "", multiFactorTotpHostApi);
        }

        void generateSecret(String str, Result<PigeonTotpSecret> result);

        void getAssertionForEnrollment(String str, String str2, Result<String> result);

        void getAssertionForSignIn(String str, String str2, Result<String> result);

        static void setUp(BinaryMessenger binaryMessenger, String str, final MultiFactorTotpHostApi multiFactorTotpHostApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.generateSecret" + str2, getCodec());
            if (multiFactorTotpHostApi != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.I0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi.c(this.f12430a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.getAssertionForEnrollment" + str2, getCodec());
            if (multiFactorTotpHostApi != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.J0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi.a(this.f12432a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.getAssertionForSignIn" + str2, getCodec());
            if (multiFactorTotpHostApi != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.K0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.MultiFactorTotpHostApi.b(this.f12434a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
        }
    }

    public static class MultiFactorTotpHostApiCodec extends StandardMessageCodec {
        public static final MultiFactorTotpHostApiCodec INSTANCE = new MultiFactorTotpHostApiCodec();

        private MultiFactorTotpHostApiCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b4, ByteBuffer byteBuffer) {
            return b4 != -128 ? super.readValueOfType(b4, byteBuffer) : PigeonTotpSecret.fromList((ArrayList) readValue(byteBuffer));
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (!(obj instanceof PigeonTotpSecret)) {
                super.writeValue(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                writeValue(byteArrayOutputStream, ((PigeonTotpSecret) obj).toList());
            }
        }
    }

    public interface MultiFactorTotpSecretHostApi {
        static /* synthetic */ void a(MultiFactorTotpSecretHostApi multiFactorTotpSecretHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            multiFactorTotpSecretHostApi.openInOtpApp((String) arrayList2.get(0), (String) arrayList2.get(1), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorTotpSecretHostApi.2
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void b(MultiFactorTotpSecretHostApi multiFactorTotpSecretHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            multiFactorTotpSecretHostApi.generateQrCodeUrl((String) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2), new Result<String>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorTotpSecretHostApi.1
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }
            });
        }

        static MessageCodec<Object> getCodec() {
            return new StandardMessageCodec();
        }

        static void setUp(BinaryMessenger binaryMessenger, MultiFactorTotpSecretHostApi multiFactorTotpSecretHostApi) {
            setUp(binaryMessenger, "", multiFactorTotpSecretHostApi);
        }

        void generateQrCodeUrl(String str, String str2, String str3, Result<String> result);

        void openInOtpApp(String str, String str2, VoidResult voidResult);

        static void setUp(BinaryMessenger binaryMessenger, String str, final MultiFactorTotpSecretHostApi multiFactorTotpSecretHostApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpSecretHostApi.generateQrCodeUrl" + str2, getCodec());
            if (multiFactorTotpSecretHostApi != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.L0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.MultiFactorTotpSecretHostApi.b(this.f12437a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpSecretHostApi.openInOtpApp" + str2, getCodec());
            if (multiFactorTotpSecretHostApi != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.M0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.MultiFactorTotpSecretHostApi.a(this.f12439a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
        }
    }

    public interface MultiFactorUserHostApi {
        static /* synthetic */ void a(MultiFactorUserHostApi multiFactorUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            multiFactorUserHostApi.getEnrolledFactors((AuthPigeonFirebaseApp) ((ArrayList) obj).get(0), new Result<List<PigeonMultiFactorInfo>>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi.5
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(List<PigeonMultiFactorInfo> list) {
                    arrayList.add(0, list);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void b(MultiFactorUserHostApi multiFactorUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            multiFactorUserHostApi.enrollPhone((AuthPigeonFirebaseApp) arrayList2.get(0), (PigeonPhoneMultiFactorAssertion) arrayList2.get(1), (String) arrayList2.get(2), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi.1
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void c(MultiFactorUserHostApi multiFactorUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            multiFactorUserHostApi.getSession((AuthPigeonFirebaseApp) ((ArrayList) obj).get(0), new Result<PigeonMultiFactorSession>() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi.3
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.Result
                public void success(PigeonMultiFactorSession pigeonMultiFactorSession) {
                    arrayList.add(0, pigeonMultiFactorSession);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void d(MultiFactorUserHostApi multiFactorUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            multiFactorUserHostApi.enrollTotp((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), (String) arrayList2.get(2), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi.2
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void f(MultiFactorUserHostApi multiFactorUserHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            multiFactorUserHostApi.unenroll((AuthPigeonFirebaseApp) arrayList2.get(0), (String) arrayList2.get(1), new VoidResult() { // from class: io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi.4
                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseAuth.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static MessageCodec<Object> getCodec() {
            return MultiFactorUserHostApiCodec.INSTANCE;
        }

        static void setUp(BinaryMessenger binaryMessenger, MultiFactorUserHostApi multiFactorUserHostApi) {
            setUp(binaryMessenger, "", multiFactorUserHostApi);
        }

        void enrollPhone(AuthPigeonFirebaseApp authPigeonFirebaseApp, PigeonPhoneMultiFactorAssertion pigeonPhoneMultiFactorAssertion, String str, VoidResult voidResult);

        void enrollTotp(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, String str2, VoidResult voidResult);

        void getEnrolledFactors(AuthPigeonFirebaseApp authPigeonFirebaseApp, Result<List<PigeonMultiFactorInfo>> result);

        void getSession(AuthPigeonFirebaseApp authPigeonFirebaseApp, Result<PigeonMultiFactorSession> result);

        void unenroll(AuthPigeonFirebaseApp authPigeonFirebaseApp, String str, VoidResult voidResult);

        static void setUp(BinaryMessenger binaryMessenger, String str, final MultiFactorUserHostApi multiFactorUserHostApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.enrollPhone" + str2, getCodec());
            if (multiFactorUserHostApi != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.N0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi.b(this.f12441a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.enrollTotp" + str2, getCodec());
            if (multiFactorUserHostApi != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.O0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi.d(this.f12443a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.getSession" + str2, getCodec());
            if (multiFactorUserHostApi != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.P0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi.c(this.f12445a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.unenroll" + str2, getCodec());
            if (multiFactorUserHostApi != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.Q0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi.f(this.f12447a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.getEnrolledFactors" + str2, getCodec());
            if (multiFactorUserHostApi != null) {
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.auth.R0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GeneratedAndroidFirebaseAuth.MultiFactorUserHostApi.a(this.f12448a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
        }
    }

    public static class MultiFactorUserHostApiCodec extends StandardMessageCodec {
        public static final MultiFactorUserHostApiCodec INSTANCE = new MultiFactorUserHostApiCodec();

        private MultiFactorUserHostApiCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b4, ByteBuffer byteBuffer) {
            switch (b4) {
                case -128:
                    return AuthPigeonFirebaseApp.fromList((ArrayList) readValue(byteBuffer));
                case -127:
                    return PigeonMultiFactorInfo.fromList((ArrayList) readValue(byteBuffer));
                case -126:
                    return PigeonMultiFactorSession.fromList((ArrayList) readValue(byteBuffer));
                case -125:
                    return PigeonPhoneMultiFactorAssertion.fromList((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b4, byteBuffer);
            }
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof AuthPigeonFirebaseApp) {
                byteArrayOutputStream.write(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
                writeValue(byteArrayOutputStream, ((AuthPigeonFirebaseApp) obj).toList());
                return;
            }
            if (obj instanceof PigeonMultiFactorInfo) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((PigeonMultiFactorInfo) obj).toList());
            } else if (obj instanceof PigeonMultiFactorSession) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((PigeonMultiFactorSession) obj).toList());
            } else if (!(obj instanceof PigeonPhoneMultiFactorAssertion)) {
                super.writeValue(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(131);
                writeValue(byteArrayOutputStream, ((PigeonPhoneMultiFactorAssertion) obj).toList());
            }
        }
    }

    public interface NullableResult<T> {
        void error(Throwable th);

        void success(T t4);
    }

    public static final class PigeonActionCodeInfo {
        private PigeonActionCodeInfoData data;
        private ActionCodeInfoOperation operation;

        public static final class Builder {
            private PigeonActionCodeInfoData data;
            private ActionCodeInfoOperation operation;

            public PigeonActionCodeInfo build() {
                PigeonActionCodeInfo pigeonActionCodeInfo = new PigeonActionCodeInfo();
                pigeonActionCodeInfo.setOperation(this.operation);
                pigeonActionCodeInfo.setData(this.data);
                return pigeonActionCodeInfo;
            }

            @CanIgnoreReturnValue
            public Builder setData(PigeonActionCodeInfoData pigeonActionCodeInfoData) {
                this.data = pigeonActionCodeInfoData;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setOperation(ActionCodeInfoOperation actionCodeInfoOperation) {
                this.operation = actionCodeInfoOperation;
                return this;
            }
        }

        public static PigeonActionCodeInfo fromList(ArrayList<Object> arrayList) {
            PigeonActionCodeInfo pigeonActionCodeInfo = new PigeonActionCodeInfo();
            pigeonActionCodeInfo.setOperation(ActionCodeInfoOperation.values()[((Integer) arrayList.get(0)).intValue()]);
            pigeonActionCodeInfo.setData((PigeonActionCodeInfoData) arrayList.get(1));
            return pigeonActionCodeInfo;
        }

        public PigeonActionCodeInfoData getData() {
            return this.data;
        }

        public ActionCodeInfoOperation getOperation() {
            return this.operation;
        }

        public void setData(PigeonActionCodeInfoData pigeonActionCodeInfoData) {
            if (pigeonActionCodeInfoData == null) {
                throw new IllegalStateException("Nonnull field \"data\" is null.");
            }
            this.data = pigeonActionCodeInfoData;
        }

        public void setOperation(ActionCodeInfoOperation actionCodeInfoOperation) {
            if (actionCodeInfoOperation == null) {
                throw new IllegalStateException("Nonnull field \"operation\" is null.");
            }
            this.operation = actionCodeInfoOperation;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            ActionCodeInfoOperation actionCodeInfoOperation = this.operation;
            arrayList.add(actionCodeInfoOperation == null ? null : Integer.valueOf(actionCodeInfoOperation.index));
            arrayList.add(this.data);
            return arrayList;
        }
    }

    public static final class PigeonActionCodeInfoData {
        private String email;
        private String previousEmail;

        public static final class Builder {
            private String email;
            private String previousEmail;

            public PigeonActionCodeInfoData build() {
                PigeonActionCodeInfoData pigeonActionCodeInfoData = new PigeonActionCodeInfoData();
                pigeonActionCodeInfoData.setEmail(this.email);
                pigeonActionCodeInfoData.setPreviousEmail(this.previousEmail);
                return pigeonActionCodeInfoData;
            }

            @CanIgnoreReturnValue
            public Builder setEmail(String str) {
                this.email = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPreviousEmail(String str) {
                this.previousEmail = str;
                return this;
            }
        }

        public static PigeonActionCodeInfoData fromList(ArrayList<Object> arrayList) {
            PigeonActionCodeInfoData pigeonActionCodeInfoData = new PigeonActionCodeInfoData();
            pigeonActionCodeInfoData.setEmail((String) arrayList.get(0));
            pigeonActionCodeInfoData.setPreviousEmail((String) arrayList.get(1));
            return pigeonActionCodeInfoData;
        }

        public String getEmail() {
            return this.email;
        }

        public String getPreviousEmail() {
            return this.previousEmail;
        }

        public void setEmail(String str) {
            this.email = str;
        }

        public void setPreviousEmail(String str) {
            this.previousEmail = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.email);
            arrayList.add(this.previousEmail);
            return arrayList;
        }
    }

    public static final class PigeonActionCodeSettings {
        private Boolean androidInstallApp;
        private String androidMinimumVersion;
        private String androidPackageName;
        private String dynamicLinkDomain;
        private Boolean handleCodeInApp;
        private String iOSBundleId;
        private String linkDomain;
        private String url;

        public static final class Builder {
            private Boolean androidInstallApp;
            private String androidMinimumVersion;
            private String androidPackageName;
            private String dynamicLinkDomain;
            private Boolean handleCodeInApp;
            private String iOSBundleId;
            private String linkDomain;
            private String url;

            public PigeonActionCodeSettings build() {
                PigeonActionCodeSettings pigeonActionCodeSettings = new PigeonActionCodeSettings();
                pigeonActionCodeSettings.setUrl(this.url);
                pigeonActionCodeSettings.setDynamicLinkDomain(this.dynamicLinkDomain);
                pigeonActionCodeSettings.setHandleCodeInApp(this.handleCodeInApp);
                pigeonActionCodeSettings.setIOSBundleId(this.iOSBundleId);
                pigeonActionCodeSettings.setAndroidPackageName(this.androidPackageName);
                pigeonActionCodeSettings.setAndroidInstallApp(this.androidInstallApp);
                pigeonActionCodeSettings.setAndroidMinimumVersion(this.androidMinimumVersion);
                pigeonActionCodeSettings.setLinkDomain(this.linkDomain);
                return pigeonActionCodeSettings;
            }

            @CanIgnoreReturnValue
            public Builder setAndroidInstallApp(Boolean bool) {
                this.androidInstallApp = bool;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAndroidMinimumVersion(String str) {
                this.androidMinimumVersion = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setAndroidPackageName(String str) {
                this.androidPackageName = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setDynamicLinkDomain(String str) {
                this.dynamicLinkDomain = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setHandleCodeInApp(Boolean bool) {
                this.handleCodeInApp = bool;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIOSBundleId(String str) {
                this.iOSBundleId = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setLinkDomain(String str) {
                this.linkDomain = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setUrl(String str) {
                this.url = str;
                return this;
            }
        }

        public static PigeonActionCodeSettings fromList(ArrayList<Object> arrayList) {
            PigeonActionCodeSettings pigeonActionCodeSettings = new PigeonActionCodeSettings();
            pigeonActionCodeSettings.setUrl((String) arrayList.get(0));
            pigeonActionCodeSettings.setDynamicLinkDomain((String) arrayList.get(1));
            pigeonActionCodeSettings.setHandleCodeInApp((Boolean) arrayList.get(2));
            pigeonActionCodeSettings.setIOSBundleId((String) arrayList.get(3));
            pigeonActionCodeSettings.setAndroidPackageName((String) arrayList.get(4));
            pigeonActionCodeSettings.setAndroidInstallApp((Boolean) arrayList.get(5));
            pigeonActionCodeSettings.setAndroidMinimumVersion((String) arrayList.get(6));
            pigeonActionCodeSettings.setLinkDomain((String) arrayList.get(7));
            return pigeonActionCodeSettings;
        }

        public Boolean getAndroidInstallApp() {
            return this.androidInstallApp;
        }

        public String getAndroidMinimumVersion() {
            return this.androidMinimumVersion;
        }

        public String getAndroidPackageName() {
            return this.androidPackageName;
        }

        public String getDynamicLinkDomain() {
            return this.dynamicLinkDomain;
        }

        public Boolean getHandleCodeInApp() {
            return this.handleCodeInApp;
        }

        public String getIOSBundleId() {
            return this.iOSBundleId;
        }

        public String getLinkDomain() {
            return this.linkDomain;
        }

        public String getUrl() {
            return this.url;
        }

        public void setAndroidInstallApp(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"androidInstallApp\" is null.");
            }
            this.androidInstallApp = bool;
        }

        public void setAndroidMinimumVersion(String str) {
            this.androidMinimumVersion = str;
        }

        public void setAndroidPackageName(String str) {
            this.androidPackageName = str;
        }

        public void setDynamicLinkDomain(String str) {
            this.dynamicLinkDomain = str;
        }

        public void setHandleCodeInApp(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"handleCodeInApp\" is null.");
            }
            this.handleCodeInApp = bool;
        }

        public void setIOSBundleId(String str) {
            this.iOSBundleId = str;
        }

        public void setLinkDomain(String str) {
            this.linkDomain = str;
        }

        public void setUrl(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"url\" is null.");
            }
            this.url = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(8);
            arrayList.add(this.url);
            arrayList.add(this.dynamicLinkDomain);
            arrayList.add(this.handleCodeInApp);
            arrayList.add(this.iOSBundleId);
            arrayList.add(this.androidPackageName);
            arrayList.add(this.androidInstallApp);
            arrayList.add(this.androidMinimumVersion);
            arrayList.add(this.linkDomain);
            return arrayList;
        }
    }

    public static final class PigeonAdditionalUserInfo {
        private String authorizationCode;
        private Boolean isNewUser;
        private Map<String, Object> profile;
        private String providerId;
        private String username;

        public static final class Builder {
            private String authorizationCode;
            private Boolean isNewUser;
            private Map<String, Object> profile;
            private String providerId;
            private String username;

            public PigeonAdditionalUserInfo build() {
                PigeonAdditionalUserInfo pigeonAdditionalUserInfo = new PigeonAdditionalUserInfo();
                pigeonAdditionalUserInfo.setIsNewUser(this.isNewUser);
                pigeonAdditionalUserInfo.setProviderId(this.providerId);
                pigeonAdditionalUserInfo.setUsername(this.username);
                pigeonAdditionalUserInfo.setAuthorizationCode(this.authorizationCode);
                pigeonAdditionalUserInfo.setProfile(this.profile);
                return pigeonAdditionalUserInfo;
            }

            @CanIgnoreReturnValue
            public Builder setAuthorizationCode(String str) {
                this.authorizationCode = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsNewUser(Boolean bool) {
                this.isNewUser = bool;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setProfile(Map<String, Object> map) {
                this.profile = map;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setProviderId(String str) {
                this.providerId = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setUsername(String str) {
                this.username = str;
                return this;
            }
        }

        public static PigeonAdditionalUserInfo fromList(ArrayList<Object> arrayList) {
            PigeonAdditionalUserInfo pigeonAdditionalUserInfo = new PigeonAdditionalUserInfo();
            pigeonAdditionalUserInfo.setIsNewUser((Boolean) arrayList.get(0));
            pigeonAdditionalUserInfo.setProviderId((String) arrayList.get(1));
            pigeonAdditionalUserInfo.setUsername((String) arrayList.get(2));
            pigeonAdditionalUserInfo.setAuthorizationCode((String) arrayList.get(3));
            pigeonAdditionalUserInfo.setProfile((Map) arrayList.get(4));
            return pigeonAdditionalUserInfo;
        }

        public String getAuthorizationCode() {
            return this.authorizationCode;
        }

        public Boolean getIsNewUser() {
            return this.isNewUser;
        }

        public Map<String, Object> getProfile() {
            return this.profile;
        }

        public String getProviderId() {
            return this.providerId;
        }

        public String getUsername() {
            return this.username;
        }

        public void setAuthorizationCode(String str) {
            this.authorizationCode = str;
        }

        public void setIsNewUser(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isNewUser\" is null.");
            }
            this.isNewUser = bool;
        }

        public void setProfile(Map<String, Object> map) {
            this.profile = map;
        }

        public void setProviderId(String str) {
            this.providerId = str;
        }

        public void setUsername(String str) {
            this.username = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.isNewUser);
            arrayList.add(this.providerId);
            arrayList.add(this.username);
            arrayList.add(this.authorizationCode);
            arrayList.add(this.profile);
            return arrayList;
        }
    }

    public static final class PigeonAuthCredential {
        private String accessToken;
        private Long nativeId;
        private String providerId;
        private String signInMethod;

        public static final class Builder {
            private String accessToken;
            private Long nativeId;
            private String providerId;
            private String signInMethod;

            public PigeonAuthCredential build() {
                PigeonAuthCredential pigeonAuthCredential = new PigeonAuthCredential();
                pigeonAuthCredential.setProviderId(this.providerId);
                pigeonAuthCredential.setSignInMethod(this.signInMethod);
                pigeonAuthCredential.setNativeId(this.nativeId);
                pigeonAuthCredential.setAccessToken(this.accessToken);
                return pigeonAuthCredential;
            }

            @CanIgnoreReturnValue
            public Builder setAccessToken(String str) {
                this.accessToken = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setNativeId(Long l4) {
                this.nativeId = l4;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setProviderId(String str) {
                this.providerId = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSignInMethod(String str) {
                this.signInMethod = str;
                return this;
            }
        }

        public static PigeonAuthCredential fromList(ArrayList<Object> arrayList) {
            Long lValueOf;
            PigeonAuthCredential pigeonAuthCredential = new PigeonAuthCredential();
            pigeonAuthCredential.setProviderId((String) arrayList.get(0));
            pigeonAuthCredential.setSignInMethod((String) arrayList.get(1));
            Object obj = arrayList.get(2);
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            pigeonAuthCredential.setNativeId(lValueOf);
            pigeonAuthCredential.setAccessToken((String) arrayList.get(3));
            return pigeonAuthCredential;
        }

        public String getAccessToken() {
            return this.accessToken;
        }

        public Long getNativeId() {
            return this.nativeId;
        }

        public String getProviderId() {
            return this.providerId;
        }

        public String getSignInMethod() {
            return this.signInMethod;
        }

        public void setAccessToken(String str) {
            this.accessToken = str;
        }

        public void setNativeId(Long l4) {
            if (l4 == null) {
                throw new IllegalStateException("Nonnull field \"nativeId\" is null.");
            }
            this.nativeId = l4;
        }

        public void setProviderId(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"providerId\" is null.");
            }
            this.providerId = str;
        }

        public void setSignInMethod(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"signInMethod\" is null.");
            }
            this.signInMethod = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            arrayList.add(this.providerId);
            arrayList.add(this.signInMethod);
            arrayList.add(this.nativeId);
            arrayList.add(this.accessToken);
            return arrayList;
        }
    }

    public static final class PigeonFirebaseAuthSettings {
        private Boolean appVerificationDisabledForTesting;
        private Boolean forceRecaptchaFlow;
        private String phoneNumber;
        private String smsCode;
        private String userAccessGroup;

        public static final class Builder {
            private Boolean appVerificationDisabledForTesting;
            private Boolean forceRecaptchaFlow;
            private String phoneNumber;
            private String smsCode;
            private String userAccessGroup;

            public PigeonFirebaseAuthSettings build() {
                PigeonFirebaseAuthSettings pigeonFirebaseAuthSettings = new PigeonFirebaseAuthSettings();
                pigeonFirebaseAuthSettings.setAppVerificationDisabledForTesting(this.appVerificationDisabledForTesting);
                pigeonFirebaseAuthSettings.setUserAccessGroup(this.userAccessGroup);
                pigeonFirebaseAuthSettings.setPhoneNumber(this.phoneNumber);
                pigeonFirebaseAuthSettings.setSmsCode(this.smsCode);
                pigeonFirebaseAuthSettings.setForceRecaptchaFlow(this.forceRecaptchaFlow);
                return pigeonFirebaseAuthSettings;
            }

            @CanIgnoreReturnValue
            public Builder setAppVerificationDisabledForTesting(Boolean bool) {
                this.appVerificationDisabledForTesting = bool;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setForceRecaptchaFlow(Boolean bool) {
                this.forceRecaptchaFlow = bool;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPhoneNumber(String str) {
                this.phoneNumber = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSmsCode(String str) {
                this.smsCode = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setUserAccessGroup(String str) {
                this.userAccessGroup = str;
                return this;
            }
        }

        public static PigeonFirebaseAuthSettings fromList(ArrayList<Object> arrayList) {
            PigeonFirebaseAuthSettings pigeonFirebaseAuthSettings = new PigeonFirebaseAuthSettings();
            pigeonFirebaseAuthSettings.setAppVerificationDisabledForTesting((Boolean) arrayList.get(0));
            pigeonFirebaseAuthSettings.setUserAccessGroup((String) arrayList.get(1));
            pigeonFirebaseAuthSettings.setPhoneNumber((String) arrayList.get(2));
            pigeonFirebaseAuthSettings.setSmsCode((String) arrayList.get(3));
            pigeonFirebaseAuthSettings.setForceRecaptchaFlow((Boolean) arrayList.get(4));
            return pigeonFirebaseAuthSettings;
        }

        public Boolean getAppVerificationDisabledForTesting() {
            return this.appVerificationDisabledForTesting;
        }

        public Boolean getForceRecaptchaFlow() {
            return this.forceRecaptchaFlow;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }

        public String getSmsCode() {
            return this.smsCode;
        }

        public String getUserAccessGroup() {
            return this.userAccessGroup;
        }

        public void setAppVerificationDisabledForTesting(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"appVerificationDisabledForTesting\" is null.");
            }
            this.appVerificationDisabledForTesting = bool;
        }

        public void setForceRecaptchaFlow(Boolean bool) {
            this.forceRecaptchaFlow = bool;
        }

        public void setPhoneNumber(String str) {
            this.phoneNumber = str;
        }

        public void setSmsCode(String str) {
            this.smsCode = str;
        }

        public void setUserAccessGroup(String str) {
            this.userAccessGroup = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.appVerificationDisabledForTesting);
            arrayList.add(this.userAccessGroup);
            arrayList.add(this.phoneNumber);
            arrayList.add(this.smsCode);
            arrayList.add(this.forceRecaptchaFlow);
            return arrayList;
        }
    }

    public static final class PigeonIdTokenResult {
        private Long authTimestamp;
        private Map<String, Object> claims;
        private Long expirationTimestamp;
        private Long issuedAtTimestamp;
        private String signInProvider;
        private String signInSecondFactor;
        private String token;

        public static final class Builder {
            private Long authTimestamp;
            private Map<String, Object> claims;
            private Long expirationTimestamp;
            private Long issuedAtTimestamp;
            private String signInProvider;
            private String signInSecondFactor;
            private String token;

            public PigeonIdTokenResult build() {
                PigeonIdTokenResult pigeonIdTokenResult = new PigeonIdTokenResult();
                pigeonIdTokenResult.setToken(this.token);
                pigeonIdTokenResult.setExpirationTimestamp(this.expirationTimestamp);
                pigeonIdTokenResult.setAuthTimestamp(this.authTimestamp);
                pigeonIdTokenResult.setIssuedAtTimestamp(this.issuedAtTimestamp);
                pigeonIdTokenResult.setSignInProvider(this.signInProvider);
                pigeonIdTokenResult.setClaims(this.claims);
                pigeonIdTokenResult.setSignInSecondFactor(this.signInSecondFactor);
                return pigeonIdTokenResult;
            }

            @CanIgnoreReturnValue
            public Builder setAuthTimestamp(Long l4) {
                this.authTimestamp = l4;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setClaims(Map<String, Object> map) {
                this.claims = map;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setExpirationTimestamp(Long l4) {
                this.expirationTimestamp = l4;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIssuedAtTimestamp(Long l4) {
                this.issuedAtTimestamp = l4;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSignInProvider(String str) {
                this.signInProvider = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSignInSecondFactor(String str) {
                this.signInSecondFactor = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setToken(String str) {
                this.token = str;
                return this;
            }
        }

        public static PigeonIdTokenResult fromList(ArrayList<Object> arrayList) {
            Long lValueOf;
            Long lValueOf2;
            PigeonIdTokenResult pigeonIdTokenResult = new PigeonIdTokenResult();
            pigeonIdTokenResult.setToken((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            Long lValueOf3 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            pigeonIdTokenResult.setExpirationTimestamp(lValueOf);
            Object obj2 = arrayList.get(2);
            if (obj2 == null) {
                lValueOf2 = null;
            } else {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            pigeonIdTokenResult.setAuthTimestamp(lValueOf2);
            Object obj3 = arrayList.get(3);
            if (obj3 != null) {
                lValueOf3 = Long.valueOf(obj3 instanceof Integer ? ((Integer) obj3).intValue() : ((Long) obj3).longValue());
            }
            pigeonIdTokenResult.setIssuedAtTimestamp(lValueOf3);
            pigeonIdTokenResult.setSignInProvider((String) arrayList.get(4));
            pigeonIdTokenResult.setClaims((Map) arrayList.get(5));
            pigeonIdTokenResult.setSignInSecondFactor((String) arrayList.get(6));
            return pigeonIdTokenResult;
        }

        public Long getAuthTimestamp() {
            return this.authTimestamp;
        }

        public Map<String, Object> getClaims() {
            return this.claims;
        }

        public Long getExpirationTimestamp() {
            return this.expirationTimestamp;
        }

        public Long getIssuedAtTimestamp() {
            return this.issuedAtTimestamp;
        }

        public String getSignInProvider() {
            return this.signInProvider;
        }

        public String getSignInSecondFactor() {
            return this.signInSecondFactor;
        }

        public String getToken() {
            return this.token;
        }

        public void setAuthTimestamp(Long l4) {
            this.authTimestamp = l4;
        }

        public void setClaims(Map<String, Object> map) {
            this.claims = map;
        }

        public void setExpirationTimestamp(Long l4) {
            this.expirationTimestamp = l4;
        }

        public void setIssuedAtTimestamp(Long l4) {
            this.issuedAtTimestamp = l4;
        }

        public void setSignInProvider(String str) {
            this.signInProvider = str;
        }

        public void setSignInSecondFactor(String str) {
            this.signInSecondFactor = str;
        }

        public void setToken(String str) {
            this.token = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(7);
            arrayList.add(this.token);
            arrayList.add(this.expirationTimestamp);
            arrayList.add(this.authTimestamp);
            arrayList.add(this.issuedAtTimestamp);
            arrayList.add(this.signInProvider);
            arrayList.add(this.claims);
            arrayList.add(this.signInSecondFactor);
            return arrayList;
        }
    }

    public static final class PigeonMultiFactorInfo {
        private String displayName;
        private Double enrollmentTimestamp;
        private String factorId;
        private String phoneNumber;
        private String uid;

        public static final class Builder {
            private String displayName;
            private Double enrollmentTimestamp;
            private String factorId;
            private String phoneNumber;
            private String uid;

            public PigeonMultiFactorInfo build() {
                PigeonMultiFactorInfo pigeonMultiFactorInfo = new PigeonMultiFactorInfo();
                pigeonMultiFactorInfo.setDisplayName(this.displayName);
                pigeonMultiFactorInfo.setEnrollmentTimestamp(this.enrollmentTimestamp);
                pigeonMultiFactorInfo.setFactorId(this.factorId);
                pigeonMultiFactorInfo.setUid(this.uid);
                pigeonMultiFactorInfo.setPhoneNumber(this.phoneNumber);
                return pigeonMultiFactorInfo;
            }

            @CanIgnoreReturnValue
            public Builder setDisplayName(String str) {
                this.displayName = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setEnrollmentTimestamp(Double d4) {
                this.enrollmentTimestamp = d4;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setFactorId(String str) {
                this.factorId = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPhoneNumber(String str) {
                this.phoneNumber = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setUid(String str) {
                this.uid = str;
                return this;
            }
        }

        public static PigeonMultiFactorInfo fromList(ArrayList<Object> arrayList) {
            PigeonMultiFactorInfo pigeonMultiFactorInfo = new PigeonMultiFactorInfo();
            pigeonMultiFactorInfo.setDisplayName((String) arrayList.get(0));
            pigeonMultiFactorInfo.setEnrollmentTimestamp((Double) arrayList.get(1));
            pigeonMultiFactorInfo.setFactorId((String) arrayList.get(2));
            pigeonMultiFactorInfo.setUid((String) arrayList.get(3));
            pigeonMultiFactorInfo.setPhoneNumber((String) arrayList.get(4));
            return pigeonMultiFactorInfo;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public Double getEnrollmentTimestamp() {
            return this.enrollmentTimestamp;
        }

        public String getFactorId() {
            return this.factorId;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }

        public String getUid() {
            return this.uid;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public void setEnrollmentTimestamp(Double d4) {
            if (d4 == null) {
                throw new IllegalStateException("Nonnull field \"enrollmentTimestamp\" is null.");
            }
            this.enrollmentTimestamp = d4;
        }

        public void setFactorId(String str) {
            this.factorId = str;
        }

        public void setPhoneNumber(String str) {
            this.phoneNumber = str;
        }

        public void setUid(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"uid\" is null.");
            }
            this.uid = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.displayName);
            arrayList.add(this.enrollmentTimestamp);
            arrayList.add(this.factorId);
            arrayList.add(this.uid);
            arrayList.add(this.phoneNumber);
            return arrayList;
        }
    }

    public static final class PigeonMultiFactorSession {
        private String id;

        public static final class Builder {
            private String id;

            public PigeonMultiFactorSession build() {
                PigeonMultiFactorSession pigeonMultiFactorSession = new PigeonMultiFactorSession();
                pigeonMultiFactorSession.setId(this.id);
                return pigeonMultiFactorSession;
            }

            @CanIgnoreReturnValue
            public Builder setId(String str) {
                this.id = str;
                return this;
            }
        }

        public static PigeonMultiFactorSession fromList(ArrayList<Object> arrayList) {
            PigeonMultiFactorSession pigeonMultiFactorSession = new PigeonMultiFactorSession();
            pigeonMultiFactorSession.setId((String) arrayList.get(0));
            return pigeonMultiFactorSession;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"id\" is null.");
            }
            this.id = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.id);
            return arrayList;
        }
    }

    public static final class PigeonPhoneMultiFactorAssertion {
        private String verificationCode;
        private String verificationId;

        public static final class Builder {
            private String verificationCode;
            private String verificationId;

            public PigeonPhoneMultiFactorAssertion build() {
                PigeonPhoneMultiFactorAssertion pigeonPhoneMultiFactorAssertion = new PigeonPhoneMultiFactorAssertion();
                pigeonPhoneMultiFactorAssertion.setVerificationId(this.verificationId);
                pigeonPhoneMultiFactorAssertion.setVerificationCode(this.verificationCode);
                return pigeonPhoneMultiFactorAssertion;
            }

            @CanIgnoreReturnValue
            public Builder setVerificationCode(String str) {
                this.verificationCode = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setVerificationId(String str) {
                this.verificationId = str;
                return this;
            }
        }

        public static PigeonPhoneMultiFactorAssertion fromList(ArrayList<Object> arrayList) {
            PigeonPhoneMultiFactorAssertion pigeonPhoneMultiFactorAssertion = new PigeonPhoneMultiFactorAssertion();
            pigeonPhoneMultiFactorAssertion.setVerificationId((String) arrayList.get(0));
            pigeonPhoneMultiFactorAssertion.setVerificationCode((String) arrayList.get(1));
            return pigeonPhoneMultiFactorAssertion;
        }

        public String getVerificationCode() {
            return this.verificationCode;
        }

        public String getVerificationId() {
            return this.verificationId;
        }

        public void setVerificationCode(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"verificationCode\" is null.");
            }
            this.verificationCode = str;
        }

        public void setVerificationId(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"verificationId\" is null.");
            }
            this.verificationId = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.verificationId);
            arrayList.add(this.verificationCode);
            return arrayList;
        }
    }

    public static final class PigeonSignInProvider {
        private Map<String, String> customParameters;
        private String providerId;
        private List<String> scopes;

        public static final class Builder {
            private Map<String, String> customParameters;
            private String providerId;
            private List<String> scopes;

            public PigeonSignInProvider build() {
                PigeonSignInProvider pigeonSignInProvider = new PigeonSignInProvider();
                pigeonSignInProvider.setProviderId(this.providerId);
                pigeonSignInProvider.setScopes(this.scopes);
                pigeonSignInProvider.setCustomParameters(this.customParameters);
                return pigeonSignInProvider;
            }

            @CanIgnoreReturnValue
            public Builder setCustomParameters(Map<String, String> map) {
                this.customParameters = map;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setProviderId(String str) {
                this.providerId = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setScopes(List<String> list) {
                this.scopes = list;
                return this;
            }
        }

        public static PigeonSignInProvider fromList(ArrayList<Object> arrayList) {
            PigeonSignInProvider pigeonSignInProvider = new PigeonSignInProvider();
            pigeonSignInProvider.setProviderId((String) arrayList.get(0));
            pigeonSignInProvider.setScopes((List) arrayList.get(1));
            pigeonSignInProvider.setCustomParameters((Map) arrayList.get(2));
            return pigeonSignInProvider;
        }

        public Map<String, String> getCustomParameters() {
            return this.customParameters;
        }

        public String getProviderId() {
            return this.providerId;
        }

        public List<String> getScopes() {
            return this.scopes;
        }

        public void setCustomParameters(Map<String, String> map) {
            this.customParameters = map;
        }

        public void setProviderId(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"providerId\" is null.");
            }
            this.providerId = str;
        }

        public void setScopes(List<String> list) {
            this.scopes = list;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.providerId);
            arrayList.add(this.scopes);
            arrayList.add(this.customParameters);
            return arrayList;
        }
    }

    public static final class PigeonTotpSecret {
        private Long codeIntervalSeconds;
        private Long codeLength;
        private Long enrollmentCompletionDeadline;
        private String hashingAlgorithm;
        private String secretKey;

        public static final class Builder {
            private Long codeIntervalSeconds;
            private Long codeLength;
            private Long enrollmentCompletionDeadline;
            private String hashingAlgorithm;
            private String secretKey;

            public PigeonTotpSecret build() {
                PigeonTotpSecret pigeonTotpSecret = new PigeonTotpSecret();
                pigeonTotpSecret.setCodeIntervalSeconds(this.codeIntervalSeconds);
                pigeonTotpSecret.setCodeLength(this.codeLength);
                pigeonTotpSecret.setEnrollmentCompletionDeadline(this.enrollmentCompletionDeadline);
                pigeonTotpSecret.setHashingAlgorithm(this.hashingAlgorithm);
                pigeonTotpSecret.setSecretKey(this.secretKey);
                return pigeonTotpSecret;
            }

            @CanIgnoreReturnValue
            public Builder setCodeIntervalSeconds(Long l4) {
                this.codeIntervalSeconds = l4;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setCodeLength(Long l4) {
                this.codeLength = l4;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setEnrollmentCompletionDeadline(Long l4) {
                this.enrollmentCompletionDeadline = l4;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setHashingAlgorithm(String str) {
                this.hashingAlgorithm = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSecretKey(String str) {
                this.secretKey = str;
                return this;
            }
        }

        public static PigeonTotpSecret fromList(ArrayList<Object> arrayList) {
            Long lValueOf;
            Long lValueOf2;
            PigeonTotpSecret pigeonTotpSecret = new PigeonTotpSecret();
            Object obj = arrayList.get(0);
            Long lValueOf3 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            pigeonTotpSecret.setCodeIntervalSeconds(lValueOf);
            Object obj2 = arrayList.get(1);
            if (obj2 == null) {
                lValueOf2 = null;
            } else {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            pigeonTotpSecret.setCodeLength(lValueOf2);
            Object obj3 = arrayList.get(2);
            if (obj3 != null) {
                lValueOf3 = Long.valueOf(obj3 instanceof Integer ? ((Integer) obj3).intValue() : ((Long) obj3).longValue());
            }
            pigeonTotpSecret.setEnrollmentCompletionDeadline(lValueOf3);
            pigeonTotpSecret.setHashingAlgorithm((String) arrayList.get(3));
            pigeonTotpSecret.setSecretKey((String) arrayList.get(4));
            return pigeonTotpSecret;
        }

        public Long getCodeIntervalSeconds() {
            return this.codeIntervalSeconds;
        }

        public Long getCodeLength() {
            return this.codeLength;
        }

        public Long getEnrollmentCompletionDeadline() {
            return this.enrollmentCompletionDeadline;
        }

        public String getHashingAlgorithm() {
            return this.hashingAlgorithm;
        }

        public String getSecretKey() {
            return this.secretKey;
        }

        public void setCodeIntervalSeconds(Long l4) {
            this.codeIntervalSeconds = l4;
        }

        public void setCodeLength(Long l4) {
            this.codeLength = l4;
        }

        public void setEnrollmentCompletionDeadline(Long l4) {
            this.enrollmentCompletionDeadline = l4;
        }

        public void setHashingAlgorithm(String str) {
            this.hashingAlgorithm = str;
        }

        public void setSecretKey(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"secretKey\" is null.");
            }
            this.secretKey = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.codeIntervalSeconds);
            arrayList.add(this.codeLength);
            arrayList.add(this.enrollmentCompletionDeadline);
            arrayList.add(this.hashingAlgorithm);
            arrayList.add(this.secretKey);
            return arrayList;
        }
    }

    public static final class PigeonUserCredential {
        private PigeonAdditionalUserInfo additionalUserInfo;
        private PigeonAuthCredential credential;
        private PigeonUserDetails user;

        public static final class Builder {
            private PigeonAdditionalUserInfo additionalUserInfo;
            private PigeonAuthCredential credential;
            private PigeonUserDetails user;

            public PigeonUserCredential build() {
                PigeonUserCredential pigeonUserCredential = new PigeonUserCredential();
                pigeonUserCredential.setUser(this.user);
                pigeonUserCredential.setAdditionalUserInfo(this.additionalUserInfo);
                pigeonUserCredential.setCredential(this.credential);
                return pigeonUserCredential;
            }

            @CanIgnoreReturnValue
            public Builder setAdditionalUserInfo(PigeonAdditionalUserInfo pigeonAdditionalUserInfo) {
                this.additionalUserInfo = pigeonAdditionalUserInfo;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setCredential(PigeonAuthCredential pigeonAuthCredential) {
                this.credential = pigeonAuthCredential;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setUser(PigeonUserDetails pigeonUserDetails) {
                this.user = pigeonUserDetails;
                return this;
            }
        }

        public static PigeonUserCredential fromList(ArrayList<Object> arrayList) {
            PigeonUserCredential pigeonUserCredential = new PigeonUserCredential();
            pigeonUserCredential.setUser((PigeonUserDetails) arrayList.get(0));
            pigeonUserCredential.setAdditionalUserInfo((PigeonAdditionalUserInfo) arrayList.get(1));
            pigeonUserCredential.setCredential((PigeonAuthCredential) arrayList.get(2));
            return pigeonUserCredential;
        }

        public PigeonAdditionalUserInfo getAdditionalUserInfo() {
            return this.additionalUserInfo;
        }

        public PigeonAuthCredential getCredential() {
            return this.credential;
        }

        public PigeonUserDetails getUser() {
            return this.user;
        }

        public void setAdditionalUserInfo(PigeonAdditionalUserInfo pigeonAdditionalUserInfo) {
            this.additionalUserInfo = pigeonAdditionalUserInfo;
        }

        public void setCredential(PigeonAuthCredential pigeonAuthCredential) {
            this.credential = pigeonAuthCredential;
        }

        public void setUser(PigeonUserDetails pigeonUserDetails) {
            this.user = pigeonUserDetails;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.user);
            arrayList.add(this.additionalUserInfo);
            arrayList.add(this.credential);
            return arrayList;
        }
    }

    public static final class PigeonUserDetails {
        private List<Map<Object, Object>> providerData;
        private PigeonUserInfo userInfo;

        public static final class Builder {
            private List<Map<Object, Object>> providerData;
            private PigeonUserInfo userInfo;

            public PigeonUserDetails build() {
                PigeonUserDetails pigeonUserDetails = new PigeonUserDetails();
                pigeonUserDetails.setUserInfo(this.userInfo);
                pigeonUserDetails.setProviderData(this.providerData);
                return pigeonUserDetails;
            }

            @CanIgnoreReturnValue
            public Builder setProviderData(List<Map<Object, Object>> list) {
                this.providerData = list;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setUserInfo(PigeonUserInfo pigeonUserInfo) {
                this.userInfo = pigeonUserInfo;
                return this;
            }
        }

        public static PigeonUserDetails fromList(ArrayList<Object> arrayList) {
            PigeonUserDetails pigeonUserDetails = new PigeonUserDetails();
            pigeonUserDetails.setUserInfo((PigeonUserInfo) arrayList.get(0));
            pigeonUserDetails.setProviderData((List) arrayList.get(1));
            return pigeonUserDetails;
        }

        public List<Map<Object, Object>> getProviderData() {
            return this.providerData;
        }

        public PigeonUserInfo getUserInfo() {
            return this.userInfo;
        }

        public void setProviderData(List<Map<Object, Object>> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"providerData\" is null.");
            }
            this.providerData = list;
        }

        public void setUserInfo(PigeonUserInfo pigeonUserInfo) {
            if (pigeonUserInfo == null) {
                throw new IllegalStateException("Nonnull field \"userInfo\" is null.");
            }
            this.userInfo = pigeonUserInfo;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.userInfo);
            arrayList.add(this.providerData);
            return arrayList;
        }
    }

    public static final class PigeonUserInfo {
        private Long creationTimestamp;
        private String displayName;
        private String email;
        private Boolean isAnonymous;
        private Boolean isEmailVerified;
        private Long lastSignInTimestamp;
        private String phoneNumber;
        private String photoUrl;
        private String providerId;
        private String refreshToken;
        private String tenantId;
        private String uid;

        public static final class Builder {
            private Long creationTimestamp;
            private String displayName;
            private String email;
            private Boolean isAnonymous;
            private Boolean isEmailVerified;
            private Long lastSignInTimestamp;
            private String phoneNumber;
            private String photoUrl;
            private String providerId;
            private String refreshToken;
            private String tenantId;
            private String uid;

            public PigeonUserInfo build() {
                PigeonUserInfo pigeonUserInfo = new PigeonUserInfo();
                pigeonUserInfo.setUid(this.uid);
                pigeonUserInfo.setEmail(this.email);
                pigeonUserInfo.setDisplayName(this.displayName);
                pigeonUserInfo.setPhotoUrl(this.photoUrl);
                pigeonUserInfo.setPhoneNumber(this.phoneNumber);
                pigeonUserInfo.setIsAnonymous(this.isAnonymous);
                pigeonUserInfo.setIsEmailVerified(this.isEmailVerified);
                pigeonUserInfo.setProviderId(this.providerId);
                pigeonUserInfo.setTenantId(this.tenantId);
                pigeonUserInfo.setRefreshToken(this.refreshToken);
                pigeonUserInfo.setCreationTimestamp(this.creationTimestamp);
                pigeonUserInfo.setLastSignInTimestamp(this.lastSignInTimestamp);
                return pigeonUserInfo;
            }

            @CanIgnoreReturnValue
            public Builder setCreationTimestamp(Long l4) {
                this.creationTimestamp = l4;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setDisplayName(String str) {
                this.displayName = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setEmail(String str) {
                this.email = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsAnonymous(Boolean bool) {
                this.isAnonymous = bool;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIsEmailVerified(Boolean bool) {
                this.isEmailVerified = bool;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setLastSignInTimestamp(Long l4) {
                this.lastSignInTimestamp = l4;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPhoneNumber(String str) {
                this.phoneNumber = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPhotoUrl(String str) {
                this.photoUrl = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setProviderId(String str) {
                this.providerId = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setRefreshToken(String str) {
                this.refreshToken = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setTenantId(String str) {
                this.tenantId = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setUid(String str) {
                this.uid = str;
                return this;
            }
        }

        public static PigeonUserInfo fromList(ArrayList<Object> arrayList) {
            Long lValueOf;
            PigeonUserInfo pigeonUserInfo = new PigeonUserInfo();
            pigeonUserInfo.setUid((String) arrayList.get(0));
            pigeonUserInfo.setEmail((String) arrayList.get(1));
            pigeonUserInfo.setDisplayName((String) arrayList.get(2));
            pigeonUserInfo.setPhotoUrl((String) arrayList.get(3));
            pigeonUserInfo.setPhoneNumber((String) arrayList.get(4));
            pigeonUserInfo.setIsAnonymous((Boolean) arrayList.get(5));
            pigeonUserInfo.setIsEmailVerified((Boolean) arrayList.get(6));
            pigeonUserInfo.setProviderId((String) arrayList.get(7));
            pigeonUserInfo.setTenantId((String) arrayList.get(8));
            pigeonUserInfo.setRefreshToken((String) arrayList.get(9));
            Object obj = arrayList.get(10);
            Long lValueOf2 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            pigeonUserInfo.setCreationTimestamp(lValueOf);
            Object obj2 = arrayList.get(11);
            if (obj2 != null) {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            pigeonUserInfo.setLastSignInTimestamp(lValueOf2);
            return pigeonUserInfo;
        }

        public Long getCreationTimestamp() {
            return this.creationTimestamp;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public String getEmail() {
            return this.email;
        }

        public Boolean getIsAnonymous() {
            return this.isAnonymous;
        }

        public Boolean getIsEmailVerified() {
            return this.isEmailVerified;
        }

        public Long getLastSignInTimestamp() {
            return this.lastSignInTimestamp;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }

        public String getPhotoUrl() {
            return this.photoUrl;
        }

        public String getProviderId() {
            return this.providerId;
        }

        public String getRefreshToken() {
            return this.refreshToken;
        }

        public String getTenantId() {
            return this.tenantId;
        }

        public String getUid() {
            return this.uid;
        }

        public void setCreationTimestamp(Long l4) {
            this.creationTimestamp = l4;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public void setEmail(String str) {
            this.email = str;
        }

        public void setIsAnonymous(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isAnonymous\" is null.");
            }
            this.isAnonymous = bool;
        }

        public void setIsEmailVerified(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isEmailVerified\" is null.");
            }
            this.isEmailVerified = bool;
        }

        public void setLastSignInTimestamp(Long l4) {
            this.lastSignInTimestamp = l4;
        }

        public void setPhoneNumber(String str) {
            this.phoneNumber = str;
        }

        public void setPhotoUrl(String str) {
            this.photoUrl = str;
        }

        public void setProviderId(String str) {
            this.providerId = str;
        }

        public void setRefreshToken(String str) {
            this.refreshToken = str;
        }

        public void setTenantId(String str) {
            this.tenantId = str;
        }

        public void setUid(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"uid\" is null.");
            }
            this.uid = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(12);
            arrayList.add(this.uid);
            arrayList.add(this.email);
            arrayList.add(this.displayName);
            arrayList.add(this.photoUrl);
            arrayList.add(this.phoneNumber);
            arrayList.add(this.isAnonymous);
            arrayList.add(this.isEmailVerified);
            arrayList.add(this.providerId);
            arrayList.add(this.tenantId);
            arrayList.add(this.refreshToken);
            arrayList.add(this.creationTimestamp);
            arrayList.add(this.lastSignInTimestamp);
            return arrayList;
        }
    }

    public static final class PigeonUserProfile {
        private String displayName;
        private Boolean displayNameChanged;
        private String photoUrl;
        private Boolean photoUrlChanged;

        public static final class Builder {
            private String displayName;
            private Boolean displayNameChanged;
            private String photoUrl;
            private Boolean photoUrlChanged;

            public PigeonUserProfile build() {
                PigeonUserProfile pigeonUserProfile = new PigeonUserProfile();
                pigeonUserProfile.setDisplayName(this.displayName);
                pigeonUserProfile.setPhotoUrl(this.photoUrl);
                pigeonUserProfile.setDisplayNameChanged(this.displayNameChanged);
                pigeonUserProfile.setPhotoUrlChanged(this.photoUrlChanged);
                return pigeonUserProfile;
            }

            @CanIgnoreReturnValue
            public Builder setDisplayName(String str) {
                this.displayName = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setDisplayNameChanged(Boolean bool) {
                this.displayNameChanged = bool;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPhotoUrl(String str) {
                this.photoUrl = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPhotoUrlChanged(Boolean bool) {
                this.photoUrlChanged = bool;
                return this;
            }
        }

        public static PigeonUserProfile fromList(ArrayList<Object> arrayList) {
            PigeonUserProfile pigeonUserProfile = new PigeonUserProfile();
            pigeonUserProfile.setDisplayName((String) arrayList.get(0));
            pigeonUserProfile.setPhotoUrl((String) arrayList.get(1));
            pigeonUserProfile.setDisplayNameChanged((Boolean) arrayList.get(2));
            pigeonUserProfile.setPhotoUrlChanged((Boolean) arrayList.get(3));
            return pigeonUserProfile;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public Boolean getDisplayNameChanged() {
            return this.displayNameChanged;
        }

        public String getPhotoUrl() {
            return this.photoUrl;
        }

        public Boolean getPhotoUrlChanged() {
            return this.photoUrlChanged;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public void setDisplayNameChanged(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"displayNameChanged\" is null.");
            }
            this.displayNameChanged = bool;
        }

        public void setPhotoUrl(String str) {
            this.photoUrl = str;
        }

        public void setPhotoUrlChanged(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"photoUrlChanged\" is null.");
            }
            this.photoUrlChanged = bool;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            arrayList.add(this.displayName);
            arrayList.add(this.photoUrl);
            arrayList.add(this.displayNameChanged);
            arrayList.add(this.photoUrlChanged);
            return arrayList;
        }
    }

    public static final class PigeonVerifyPhoneNumberRequest {
        private String autoRetrievedSmsCodeForTesting;
        private Long forceResendingToken;
        private String multiFactorInfoId;
        private String multiFactorSessionId;
        private String phoneNumber;
        private Long timeout;

        public static final class Builder {
            private String autoRetrievedSmsCodeForTesting;
            private Long forceResendingToken;
            private String multiFactorInfoId;
            private String multiFactorSessionId;
            private String phoneNumber;
            private Long timeout;

            public PigeonVerifyPhoneNumberRequest build() {
                PigeonVerifyPhoneNumberRequest pigeonVerifyPhoneNumberRequest = new PigeonVerifyPhoneNumberRequest();
                pigeonVerifyPhoneNumberRequest.setPhoneNumber(this.phoneNumber);
                pigeonVerifyPhoneNumberRequest.setTimeout(this.timeout);
                pigeonVerifyPhoneNumberRequest.setForceResendingToken(this.forceResendingToken);
                pigeonVerifyPhoneNumberRequest.setAutoRetrievedSmsCodeForTesting(this.autoRetrievedSmsCodeForTesting);
                pigeonVerifyPhoneNumberRequest.setMultiFactorInfoId(this.multiFactorInfoId);
                pigeonVerifyPhoneNumberRequest.setMultiFactorSessionId(this.multiFactorSessionId);
                return pigeonVerifyPhoneNumberRequest;
            }

            @CanIgnoreReturnValue
            public Builder setAutoRetrievedSmsCodeForTesting(String str) {
                this.autoRetrievedSmsCodeForTesting = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setForceResendingToken(Long l4) {
                this.forceResendingToken = l4;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMultiFactorInfoId(String str) {
                this.multiFactorInfoId = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setMultiFactorSessionId(String str) {
                this.multiFactorSessionId = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPhoneNumber(String str) {
                this.phoneNumber = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setTimeout(Long l4) {
                this.timeout = l4;
                return this;
            }
        }

        public static PigeonVerifyPhoneNumberRequest fromList(ArrayList<Object> arrayList) {
            Long lValueOf;
            PigeonVerifyPhoneNumberRequest pigeonVerifyPhoneNumberRequest = new PigeonVerifyPhoneNumberRequest();
            pigeonVerifyPhoneNumberRequest.setPhoneNumber((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            Long lValueOf2 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            pigeonVerifyPhoneNumberRequest.setTimeout(lValueOf);
            Object obj2 = arrayList.get(2);
            if (obj2 != null) {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            pigeonVerifyPhoneNumberRequest.setForceResendingToken(lValueOf2);
            pigeonVerifyPhoneNumberRequest.setAutoRetrievedSmsCodeForTesting((String) arrayList.get(3));
            pigeonVerifyPhoneNumberRequest.setMultiFactorInfoId((String) arrayList.get(4));
            pigeonVerifyPhoneNumberRequest.setMultiFactorSessionId((String) arrayList.get(5));
            return pigeonVerifyPhoneNumberRequest;
        }

        public String getAutoRetrievedSmsCodeForTesting() {
            return this.autoRetrievedSmsCodeForTesting;
        }

        public Long getForceResendingToken() {
            return this.forceResendingToken;
        }

        public String getMultiFactorInfoId() {
            return this.multiFactorInfoId;
        }

        public String getMultiFactorSessionId() {
            return this.multiFactorSessionId;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }

        public Long getTimeout() {
            return this.timeout;
        }

        public void setAutoRetrievedSmsCodeForTesting(String str) {
            this.autoRetrievedSmsCodeForTesting = str;
        }

        public void setForceResendingToken(Long l4) {
            this.forceResendingToken = l4;
        }

        public void setMultiFactorInfoId(String str) {
            this.multiFactorInfoId = str;
        }

        public void setMultiFactorSessionId(String str) {
            this.multiFactorSessionId = str;
        }

        public void setPhoneNumber(String str) {
            this.phoneNumber = str;
        }

        public void setTimeout(Long l4) {
            if (l4 == null) {
                throw new IllegalStateException("Nonnull field \"timeout\" is null.");
            }
            this.timeout = l4;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(6);
            arrayList.add(this.phoneNumber);
            arrayList.add(this.timeout);
            arrayList.add(this.forceResendingToken);
            arrayList.add(this.autoRetrievedSmsCodeForTesting);
            arrayList.add(this.multiFactorInfoId);
            arrayList.add(this.multiFactorSessionId);
            return arrayList;
        }
    }

    public interface Result<T> {
        void error(Throwable th);

        void success(T t4);
    }

    public interface VoidResult {
        void error(Throwable th);

        void success();
    }

    public static ArrayList<Object> wrapError(Throwable th) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            arrayList.add(flutterError.details);
            return arrayList;
        }
        arrayList.add(th.toString());
        arrayList.add(th.getClass().getSimpleName());
        arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return arrayList;
    }
}
