package io.flutter.plugins.googlesignin;

import cd.h0;
import cd.r;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.googlesignin.GoogleSignInApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\n0\u0007H&¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b\u0012\u0004\u0012\u00020\n0\u0007H&¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b\u0012\u0004\u0012\u00020\n0\u0007H&¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00142\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b\u0012\u0004\u0012\u00020\n0\u0007H&¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00192\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\b\u0012\u0004\u0012\u00020\n0\u0007H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lio/flutter/plugins/googlesignin/GoogleSignInApi;", "", "", "getGoogleServicesJsonServerClientId", "()Ljava/lang/String;", "Lio/flutter/plugins/googlesignin/GetCredentialRequestParams;", "params", "Lkotlin/Function1;", "Lcd/r;", "Lio/flutter/plugins/googlesignin/GetCredentialResult;", "Lcd/h0;", "callback", "getCredential", "(Lio/flutter/plugins/googlesignin/GetCredentialRequestParams;Lpd/k;)V", "clearCredentialState", "(Lpd/k;)V", "token", "clearAuthorizationToken", "(Ljava/lang/String;Lpd/k;)V", "Lio/flutter/plugins/googlesignin/PlatformAuthorizationRequest;", "", "promptIfUnauthorized", "Lio/flutter/plugins/googlesignin/AuthorizeResult;", "authorize", "(Lio/flutter/plugins/googlesignin/PlatformAuthorizationRequest;ZLpd/k;)V", "Lio/flutter/plugins/googlesignin/PlatformRevokeAccessRequest;", "revokeAccess", "(Lio/flutter/plugins/googlesignin/PlatformRevokeAccessRequest;Lpd/k;)V", "Companion", "google_sign_in_android_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface GoogleSignInApi {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/flutter/plugins/googlesignin/GoogleSignInApi$Companion;", "", "<init>", "()V", "Lio/flutter/plugin/common/BinaryMessenger;", "binaryMessenger", "Lio/flutter/plugins/googlesignin/GoogleSignInApi;", "api", "", "messageChannelSuffix", "Lcd/h0;", "setUp", "(Lio/flutter/plugin/common/BinaryMessenger;Lio/flutter/plugins/googlesignin/GoogleSignInApi;Ljava/lang/String;)V", "Lio/flutter/plugin/common/MessageCodec;", "codec$delegate", "Lcd/k;", "getCodec", "()Lio/flutter/plugin/common/MessageCodec;", "codec", "google_sign_in_android_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: renamed from: codec$delegate, reason: from kotlin metadata */
        private static final cd.k codec = cd.l.b(new Function0() { // from class: io.flutter.plugins.googlesignin.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GoogleSignInApi.Companion.codec_delegate$lambda$0();
            }
        });

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MessagesPigeonCodec codec_delegate$lambda$0() {
            return new MessagesPigeonCodec();
        }

        public static /* synthetic */ void setUp$default(Companion companion, BinaryMessenger binaryMessenger, GoogleSignInApi googleSignInApi, String str, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                str = "";
            }
            companion.setUp(binaryMessenger, googleSignInApi, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$11$lambda$10(GoogleSignInApi googleSignInApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type kotlin.String");
            googleSignInApi.clearAuthorizationToken((String) obj2, new pd.k() { // from class: io.flutter.plugins.googlesignin.k
                @Override // pd.k
                public final Object invoke(Object obj3) {
                    return GoogleSignInApi.Companion.setUp$lambda$11$lambda$10$lambda$9(reply, (r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final h0 setUp$lambda$11$lambda$10$lambda$9(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapResult(null));
            }
            return h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$14$lambda$13(GoogleSignInApi googleSignInApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.googlesignin.PlatformAuthorizationRequest");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            googleSignInApi.authorize((PlatformAuthorizationRequest) obj2, ((Boolean) obj3).booleanValue(), new pd.k() { // from class: io.flutter.plugins.googlesignin.b
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return GoogleSignInApi.Companion.setUp$lambda$14$lambda$13$lambda$12(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final h0 setUp$lambda$14$lambda$13$lambda$12(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                Object objJ = rVar.j();
                if (r.g(objJ)) {
                    objJ = null;
                }
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapResult((AuthorizeResult) objJ));
            }
            return h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$17$lambda$16(GoogleSignInApi googleSignInApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.googlesignin.PlatformRevokeAccessRequest");
            googleSignInApi.revokeAccess((PlatformRevokeAccessRequest) obj2, new pd.k() { // from class: io.flutter.plugins.googlesignin.a
                @Override // pd.k
                public final Object invoke(Object obj3) {
                    return GoogleSignInApi.Companion.setUp$lambda$17$lambda$16$lambda$15(reply, (r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final h0 setUp$lambda$17$lambda$16$lambda$15(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapResult(null));
            }
            return h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$2$lambda$1(GoogleSignInApi googleSignInApi, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.t.f(reply, "reply");
            try {
                listWrapError = dd.q.e(googleSignInApi.getGoogleServicesJsonServerClientId());
            } catch (Throwable th) {
                listWrapError = MessagesPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$5$lambda$4(GoogleSignInApi googleSignInApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.googlesignin.GetCredentialRequestParams");
            googleSignInApi.getCredential((GetCredentialRequestParams) obj2, new pd.k() { // from class: io.flutter.plugins.googlesignin.j
                @Override // pd.k
                public final Object invoke(Object obj3) {
                    return GoogleSignInApi.Companion.setUp$lambda$5$lambda$4$lambda$3(reply, (r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final h0 setUp$lambda$5$lambda$4$lambda$3(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                Object objJ = rVar.j();
                if (r.g(objJ)) {
                    objJ = null;
                }
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapResult((GetCredentialResult) objJ));
            }
            return h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$8$lambda$7(GoogleSignInApi googleSignInApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            googleSignInApi.clearCredentialState(new pd.k() { // from class: io.flutter.plugins.googlesignin.c
                @Override // pd.k
                public final Object invoke(Object obj2) {
                    return GoogleSignInApi.Companion.setUp$lambda$8$lambda$7$lambda$6(reply, (r) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final h0 setUp$lambda$8$lambda$7$lambda$6(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(MessagesPigeonUtils.INSTANCE.wrapResult(null));
            }
            return h0.f3852a;
        }

        public final MessageCodec<Object> getCodec() {
            return (MessageCodec) codec.getValue();
        }

        public final void setUp(BinaryMessenger binaryMessenger, GoogleSignInApi googleSignInApi) {
            kotlin.jvm.internal.t.f(binaryMessenger, "binaryMessenger");
            setUp$default(this, binaryMessenger, googleSignInApi, null, 4, null);
        }

        public final void setUp(BinaryMessenger binaryMessenger, final GoogleSignInApi api, String messageChannelSuffix) {
            String str;
            kotlin.jvm.internal.t.f(binaryMessenger, "binaryMessenger");
            kotlin.jvm.internal.t.f(messageChannelSuffix, "messageChannelSuffix");
            if (messageChannelSuffix.length() > 0) {
                str = "." + messageChannelSuffix;
            } else {
                str = "";
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.getGoogleServicesJsonServerClientId" + str, getCodec());
            if (api != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.d
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GoogleSignInApi.Companion.setUp$lambda$2$lambda$1(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.getCredential" + str, getCodec());
            if (api != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.e
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GoogleSignInApi.Companion.setUp$lambda$5$lambda$4(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.clearCredentialState" + str, getCodec());
            if (api != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.f
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GoogleSignInApi.Companion.setUp$lambda$8$lambda$7(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.clearAuthorizationToken" + str, getCodec());
            if (api != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.g
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GoogleSignInApi.Companion.setUp$lambda$11$lambda$10(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.authorize" + str, getCodec());
            if (api != null) {
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.h
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GoogleSignInApi.Companion.setUp$lambda$14$lambda$13(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.revokeAccess" + str, getCodec());
            if (api != null) {
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.googlesignin.i
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        GoogleSignInApi.Companion.setUp$lambda$17$lambda$16(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
        }
    }

    void authorize(PlatformAuthorizationRequest params, boolean promptIfUnauthorized, pd.k callback);

    void clearAuthorizationToken(String token, pd.k callback);

    void clearCredentialState(pd.k callback);

    void getCredential(GetCredentialRequestParams params, pd.k callback);

    String getGoogleServicesJsonServerClientId();

    void revokeAccess(PlatformRevokeAccessRequest params, pd.k callback);
}
