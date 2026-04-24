package io.flutter.plugins.googlesignin;

import android.util.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.googlesignin.Messages;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class Messages {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface CanIgnoreReturnValue {
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

    public interface GoogleSignInApi {
        static /* synthetic */ void a(GoogleSignInApi googleSignInApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            googleSignInApi.disconnect(new VoidResult() { // from class: io.flutter.plugins.googlesignin.Messages.GoogleSignInApi.5
                @Override // io.flutter.plugins.googlesignin.Messages.VoidResult
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.googlesignin.Messages.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void b(GoogleSignInApi googleSignInApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, googleSignInApi.isSignedIn());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void c(GoogleSignInApi googleSignInApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                googleSignInApi.clearAuthCache((String) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static /* synthetic */ void d(GoogleSignInApi googleSignInApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            googleSignInApi.signInSilently(new Result<UserData>() { // from class: io.flutter.plugins.googlesignin.Messages.GoogleSignInApi.1
                @Override // io.flutter.plugins.googlesignin.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.googlesignin.Messages.Result
                public void success(UserData userData) {
                    arrayList.add(0, userData);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void e(GoogleSignInApi googleSignInApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            googleSignInApi.requestScopes((List) ((ArrayList) obj).get(0), new Result<Boolean>() { // from class: io.flutter.plugins.googlesignin.Messages.GoogleSignInApi.6
                @Override // io.flutter.plugins.googlesignin.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.googlesignin.Messages.Result
                public void success(Boolean bool) {
                    arrayList.add(0, bool);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void f(GoogleSignInApi googleSignInApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            googleSignInApi.signIn(new Result<UserData>() { // from class: io.flutter.plugins.googlesignin.Messages.GoogleSignInApi.2
                @Override // io.flutter.plugins.googlesignin.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.googlesignin.Messages.Result
                public void success(UserData userData) {
                    arrayList.add(0, userData);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void g(GoogleSignInApi googleSignInApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            googleSignInApi.getAccessToken((String) arrayList2.get(0), (Boolean) arrayList2.get(1), new Result<String>() { // from class: io.flutter.plugins.googlesignin.Messages.GoogleSignInApi.3
                @Override // io.flutter.plugins.googlesignin.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.googlesignin.Messages.Result
                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }
            });
        }

        static MessageCodec<Object> getCodec() {
            return PigeonCodec.INSTANCE;
        }

        static /* synthetic */ void h(GoogleSignInApi googleSignInApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            googleSignInApi.signOut(new VoidResult() { // from class: io.flutter.plugins.googlesignin.Messages.GoogleSignInApi.4
                @Override // io.flutter.plugins.googlesignin.Messages.VoidResult
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.googlesignin.Messages.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static /* synthetic */ void i(GoogleSignInApi googleSignInApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                googleSignInApi.init((InitParams) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static void setUp(BinaryMessenger binaryMessenger, GoogleSignInApi googleSignInApi) {
            setUp(binaryMessenger, "", googleSignInApi);
        }

        void clearAuthCache(String str);

        void disconnect(VoidResult voidResult);

        void getAccessToken(String str, Boolean bool, Result<String> result);

        void init(InitParams initParams);

        Boolean isSignedIn();

        void requestScopes(List<String> list, Result<Boolean> result);

        void signIn(Result<UserData> result);

        void signInSilently(Result<UserData> result);

        void signOut(VoidResult voidResult);

        static void setUp(BinaryMessenger binaryMessenger, String str, final GoogleSignInApi googleSignInApi) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            BinaryMessenger.TaskQueue taskQueueMakeBackgroundTaskQueue = binaryMessenger.makeBackgroundTaskQueue();
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.init" + str2, getCodec());
            if (googleSignInApi != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.e
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.GoogleSignInApi.i(this.f12762a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.signInSilently" + str2, getCodec());
            if (googleSignInApi != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.f
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.GoogleSignInApi.d(this.f12763a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.signIn" + str2, getCodec());
            if (googleSignInApi != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.g
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.GoogleSignInApi.f(this.f12764a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.getAccessToken" + str2, getCodec(), taskQueueMakeBackgroundTaskQueue);
            if (googleSignInApi != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.h
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.GoogleSignInApi.g(this.f12765a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.signOut" + str2, getCodec());
            if (googleSignInApi != null) {
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.i
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.GoogleSignInApi.h(this.f12766a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.disconnect" + str2, getCodec());
            if (googleSignInApi != null) {
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.j
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.GoogleSignInApi.a(this.f12767a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.isSignedIn" + str2, getCodec());
            if (googleSignInApi != null) {
                basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.k
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.GoogleSignInApi.b(this.f12768a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel7.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.clearAuthCache" + str2, getCodec(), taskQueueMakeBackgroundTaskQueue);
            if (googleSignInApi != null) {
                basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.l
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.GoogleSignInApi.c(this.f12769a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel8.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.requestScopes" + str2, getCodec());
            if (googleSignInApi != null) {
                basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.m
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        Messages.GoogleSignInApi.e(this.f12770a, obj, reply);
                    }
                });
            } else {
                basicMessageChannel9.setMessageHandler(null);
            }
        }
    }

    public static final class InitParams {
        private String clientId;
        private String forceAccountName;
        private Boolean forceCodeForRefreshToken;
        private String hostedDomain;
        private List<String> scopes;
        private String serverClientId;
        private SignInType signInType;

        public static final class Builder {
            private String clientId;
            private String forceAccountName;
            private Boolean forceCodeForRefreshToken;
            private String hostedDomain;
            private List<String> scopes;
            private String serverClientId;
            private SignInType signInType;

            public InitParams build() {
                InitParams initParams = new InitParams();
                initParams.setScopes(this.scopes);
                initParams.setSignInType(this.signInType);
                initParams.setHostedDomain(this.hostedDomain);
                initParams.setClientId(this.clientId);
                initParams.setServerClientId(this.serverClientId);
                initParams.setForceCodeForRefreshToken(this.forceCodeForRefreshToken);
                initParams.setForceAccountName(this.forceAccountName);
                return initParams;
            }

            @CanIgnoreReturnValue
            public Builder setClientId(String str) {
                this.clientId = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setForceAccountName(String str) {
                this.forceAccountName = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setForceCodeForRefreshToken(Boolean bool) {
                this.forceCodeForRefreshToken = bool;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setHostedDomain(String str) {
                this.hostedDomain = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setScopes(List<String> list) {
                this.scopes = list;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setServerClientId(String str) {
                this.serverClientId = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setSignInType(SignInType signInType) {
                this.signInType = signInType;
                return this;
            }
        }

        public static InitParams fromList(ArrayList<Object> arrayList) {
            InitParams initParams = new InitParams();
            initParams.setScopes((List) arrayList.get(0));
            initParams.setSignInType((SignInType) arrayList.get(1));
            initParams.setHostedDomain((String) arrayList.get(2));
            initParams.setClientId((String) arrayList.get(3));
            initParams.setServerClientId((String) arrayList.get(4));
            initParams.setForceCodeForRefreshToken((Boolean) arrayList.get(5));
            initParams.setForceAccountName((String) arrayList.get(6));
            return initParams;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && InitParams.class == obj.getClass()) {
                InitParams initParams = (InitParams) obj;
                if (this.scopes.equals(initParams.scopes) && this.signInType.equals(initParams.signInType) && Objects.equals(this.hostedDomain, initParams.hostedDomain) && Objects.equals(this.clientId, initParams.clientId) && Objects.equals(this.serverClientId, initParams.serverClientId) && this.forceCodeForRefreshToken.equals(initParams.forceCodeForRefreshToken) && Objects.equals(this.forceAccountName, initParams.forceAccountName)) {
                    return true;
                }
            }
            return false;
        }

        public String getClientId() {
            return this.clientId;
        }

        public String getForceAccountName() {
            return this.forceAccountName;
        }

        public Boolean getForceCodeForRefreshToken() {
            return this.forceCodeForRefreshToken;
        }

        public String getHostedDomain() {
            return this.hostedDomain;
        }

        public List<String> getScopes() {
            return this.scopes;
        }

        public String getServerClientId() {
            return this.serverClientId;
        }

        public SignInType getSignInType() {
            return this.signInType;
        }

        public int hashCode() {
            return Objects.hash(this.scopes, this.signInType, this.hostedDomain, this.clientId, this.serverClientId, this.forceCodeForRefreshToken, this.forceAccountName);
        }

        public void setClientId(String str) {
            this.clientId = str;
        }

        public void setForceAccountName(String str) {
            this.forceAccountName = str;
        }

        public void setForceCodeForRefreshToken(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"forceCodeForRefreshToken\" is null.");
            }
            this.forceCodeForRefreshToken = bool;
        }

        public void setHostedDomain(String str) {
            this.hostedDomain = str;
        }

        public void setScopes(List<String> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"scopes\" is null.");
            }
            this.scopes = list;
        }

        public void setServerClientId(String str) {
            this.serverClientId = str;
        }

        public void setSignInType(SignInType signInType) {
            if (signInType == null) {
                throw new IllegalStateException("Nonnull field \"signInType\" is null.");
            }
            this.signInType = signInType;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(7);
            arrayList.add(this.scopes);
            arrayList.add(this.signInType);
            arrayList.add(this.hostedDomain);
            arrayList.add(this.clientId);
            arrayList.add(this.serverClientId);
            arrayList.add(this.forceCodeForRefreshToken);
            arrayList.add(this.forceAccountName);
            return arrayList;
        }
    }

    public interface NullableResult<T> {
        void error(Throwable th);

        void success(T t4);
    }

    public static class PigeonCodec extends StandardMessageCodec {
        public static final PigeonCodec INSTANCE = new PigeonCodec();

        private PigeonCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b4, ByteBuffer byteBuffer) {
            switch (b4) {
                case -127:
                    Object value = readValue(byteBuffer);
                    if (value == null) {
                        return null;
                    }
                    return SignInType.values()[((Long) value).intValue()];
                case -126:
                    return InitParams.fromList((ArrayList) readValue(byteBuffer));
                case -125:
                    return UserData.fromList((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b4, byteBuffer);
            }
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof SignInType) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, obj == null ? null : Integer.valueOf(((SignInType) obj).index));
            } else if (obj instanceof InitParams) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((InitParams) obj).toList());
            } else if (!(obj instanceof UserData)) {
                super.writeValue(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(131);
                writeValue(byteArrayOutputStream, ((UserData) obj).toList());
            }
        }
    }

    public interface Result<T> {
        void error(Throwable th);

        void success(T t4);
    }

    public enum SignInType {
        STANDARD(0),
        GAMES(1);

        final int index;

        SignInType(int i4) {
            this.index = i4;
        }
    }

    public static final class UserData {
        private String displayName;
        private String email;
        private String id;
        private String idToken;
        private String photoUrl;
        private String serverAuthCode;

        public static final class Builder {
            private String displayName;
            private String email;
            private String id;
            private String idToken;
            private String photoUrl;
            private String serverAuthCode;

            public UserData build() {
                UserData userData = new UserData();
                userData.setDisplayName(this.displayName);
                userData.setEmail(this.email);
                userData.setId(this.id);
                userData.setPhotoUrl(this.photoUrl);
                userData.setIdToken(this.idToken);
                userData.setServerAuthCode(this.serverAuthCode);
                return userData;
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
            public Builder setId(String str) {
                this.id = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setIdToken(String str) {
                this.idToken = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setPhotoUrl(String str) {
                this.photoUrl = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder setServerAuthCode(String str) {
                this.serverAuthCode = str;
                return this;
            }
        }

        public static UserData fromList(ArrayList<Object> arrayList) {
            UserData userData = new UserData();
            userData.setDisplayName((String) arrayList.get(0));
            userData.setEmail((String) arrayList.get(1));
            userData.setId((String) arrayList.get(2));
            userData.setPhotoUrl((String) arrayList.get(3));
            userData.setIdToken((String) arrayList.get(4));
            userData.setServerAuthCode((String) arrayList.get(5));
            return userData;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && UserData.class == obj.getClass()) {
                UserData userData = (UserData) obj;
                if (Objects.equals(this.displayName, userData.displayName) && this.email.equals(userData.email) && this.id.equals(userData.id) && Objects.equals(this.photoUrl, userData.photoUrl) && Objects.equals(this.idToken, userData.idToken) && Objects.equals(this.serverAuthCode, userData.serverAuthCode)) {
                    return true;
                }
            }
            return false;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public String getEmail() {
            return this.email;
        }

        public String getId() {
            return this.id;
        }

        public String getIdToken() {
            return this.idToken;
        }

        public String getPhotoUrl() {
            return this.photoUrl;
        }

        public String getServerAuthCode() {
            return this.serverAuthCode;
        }

        public int hashCode() {
            return Objects.hash(this.displayName, this.email, this.id, this.photoUrl, this.idToken, this.serverAuthCode);
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public void setEmail(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"email\" is null.");
            }
            this.email = str;
        }

        public void setId(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"id\" is null.");
            }
            this.id = str;
        }

        public void setIdToken(String str) {
            this.idToken = str;
        }

        public void setPhotoUrl(String str) {
            this.photoUrl = str;
        }

        public void setServerAuthCode(String str) {
            this.serverAuthCode = str;
        }

        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(6);
            arrayList.add(this.displayName);
            arrayList.add(this.email);
            arrayList.add(this.id);
            arrayList.add(this.photoUrl);
            arrayList.add(this.idToken);
            arrayList.add(this.serverAuthCode);
            return arrayList;
        }
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
