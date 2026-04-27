package io.flutter.plugins.firebase.firebaseremoteconfig;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.firebase.firebaseremoteconfig.FirebaseRemoteConfigHostApi;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.C2470H;
import o5.C2490r;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes.dex */
public interface FirebaseRemoteConfigHostApi {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final InterfaceC2483k codec$delegate = AbstractC2484l.a(new Function0() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FirebaseRemoteConfigHostApi.Companion.codec_delegate$lambda$0();
            }
        });

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final GeneratedAndroidFirebaseRemoteConfigPigeonCodec codec_delegate$lambda$0() {
            return new GeneratedAndroidFirebaseRemoteConfigPigeonCodec();
        }

        public static /* synthetic */ void setUp$default(Companion companion, BinaryMessenger binaryMessenger, FirebaseRemoteConfigHostApi firebaseRemoteConfigHostApi, String str, int i8, Object obj) {
            if ((i8 & 4) != 0) {
                str = "";
            }
            companion.setUp(binaryMessenger, firebaseRemoteConfigHostApi, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$12$lambda$11(FirebaseRemoteConfigHostApi firebaseRemoteConfigHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = list.get(1);
            AbstractC2304t.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.firebase.firebaseremoteconfig.RemoteConfigPigeonSettings");
            firebaseRemoteConfigHostApi.setConfigSettings((String) obj2, (RemoteConfigPigeonSettings) obj3, new B5.k() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.g
                @Override // B5.k
                public final Object invoke(Object obj4) {
                    return FirebaseRemoteConfigHostApi.Companion.setUp$lambda$12$lambda$11$lambda$10(reply, (C2490r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$12$lambda$11$lambda$10(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$15$lambda$14(FirebaseRemoteConfigHostApi firebaseRemoteConfigHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = list.get(1);
            AbstractC2304t.d(obj3, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            firebaseRemoteConfigHostApi.setDefaults((String) obj2, (Map) obj3, new B5.k() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.b
                @Override // B5.k
                public final Object invoke(Object obj4) {
                    return FirebaseRemoteConfigHostApi.Companion.setUp$lambda$15$lambda$14$lambda$13(reply, (C2490r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$15$lambda$14$lambda$13(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$18$lambda$17(FirebaseRemoteConfigHostApi firebaseRemoteConfigHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.String");
            firebaseRemoteConfigHostApi.ensureInitialized((String) obj2, new B5.k() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.f
                @Override // B5.k
                public final Object invoke(Object obj3) {
                    return FirebaseRemoteConfigHostApi.Companion.setUp$lambda$18$lambda$17$lambda$16(reply, (C2490r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$18$lambda$17$lambda$16(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$21$lambda$20(FirebaseRemoteConfigHostApi firebaseRemoteConfigHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = list.get(1);
            AbstractC2304t.d(obj3, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            firebaseRemoteConfigHostApi.setCustomSignals((String) obj2, (Map) obj3, new B5.k() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.i
                @Override // B5.k
                public final Object invoke(Object obj4) {
                    return FirebaseRemoteConfigHostApi.Companion.setUp$lambda$21$lambda$20$lambda$19(reply, (C2490r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$21$lambda$20$lambda$19(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$24$lambda$23(FirebaseRemoteConfigHostApi firebaseRemoteConfigHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.String");
            firebaseRemoteConfigHostApi.getAll((String) obj2, new B5.k() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.h
                @Override // B5.k
                public final Object invoke(Object obj3) {
                    return FirebaseRemoteConfigHostApi.Companion.setUp$lambda$24$lambda$23$lambda$22(reply, (C2490r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$24$lambda$23$lambda$22(BasicMessageChannel.Reply reply, C2490r c2490r) {
            List<Object> listWrapResult;
            Throwable thE = C2490r.e(c2490r.j());
            if (thE != null) {
                listWrapResult = GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapError(thE);
            } else {
                Object objJ = c2490r.j();
                if (C2490r.g(objJ)) {
                    objJ = null;
                }
                listWrapResult = GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapResult((Map) objJ);
            }
            reply.reply(listWrapResult);
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$27$lambda$26(FirebaseRemoteConfigHostApi firebaseRemoteConfigHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.String");
            firebaseRemoteConfigHostApi.getProperties((String) obj2, new B5.k() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.e
                @Override // B5.k
                public final Object invoke(Object obj3) {
                    return FirebaseRemoteConfigHostApi.Companion.setUp$lambda$27$lambda$26$lambda$25(reply, (C2490r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$27$lambda$26$lambda$25(BasicMessageChannel.Reply reply, C2490r c2490r) {
            List<Object> listWrapResult;
            Throwable thE = C2490r.e(c2490r.j());
            if (thE != null) {
                listWrapResult = GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapError(thE);
            } else {
                Object objJ = c2490r.j();
                if (C2490r.g(objJ)) {
                    objJ = null;
                }
                listWrapResult = GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapResult((Map) objJ);
            }
            reply.reply(listWrapResult);
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$3$lambda$2(FirebaseRemoteConfigHostApi firebaseRemoteConfigHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.String");
            firebaseRemoteConfigHostApi.fetch((String) obj2, new B5.k() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.j
                @Override // B5.k
                public final Object invoke(Object obj3) {
                    return FirebaseRemoteConfigHostApi.Companion.setUp$lambda$3$lambda$2$lambda$1(reply, (C2490r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$3$lambda$2$lambda$1(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$6$lambda$5(FirebaseRemoteConfigHostApi firebaseRemoteConfigHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.String");
            firebaseRemoteConfigHostApi.fetchAndActivate((String) obj2, new B5.k() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.d
                @Override // B5.k
                public final Object invoke(Object obj3) {
                    return FirebaseRemoteConfigHostApi.Companion.setUp$lambda$6$lambda$5$lambda$4(reply, (C2490r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$6$lambda$5$lambda$4(BasicMessageChannel.Reply reply, C2490r c2490r) {
            List<Object> listWrapResult;
            Throwable thE = C2490r.e(c2490r.j());
            if (thE != null) {
                listWrapResult = GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapError(thE);
            } else {
                Object objJ = c2490r.j();
                if (C2490r.g(objJ)) {
                    objJ = null;
                }
                listWrapResult = GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapResult((Boolean) objJ);
            }
            reply.reply(listWrapResult);
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$9$lambda$8(FirebaseRemoteConfigHostApi firebaseRemoteConfigHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.String");
            firebaseRemoteConfigHostApi.activate((String) obj2, new B5.k() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.s
                @Override // B5.k
                public final Object invoke(Object obj3) {
                    return FirebaseRemoteConfigHostApi.Companion.setUp$lambda$9$lambda$8$lambda$7(reply, (C2490r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$9$lambda$8$lambda$7(BasicMessageChannel.Reply reply, C2490r c2490r) {
            List<Object> listWrapResult;
            Throwable thE = C2490r.e(c2490r.j());
            if (thE != null) {
                listWrapResult = GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapError(thE);
            } else {
                Object objJ = c2490r.j();
                if (C2490r.g(objJ)) {
                    objJ = null;
                }
                listWrapResult = GeneratedAndroidFirebaseRemoteConfigPigeonUtils.INSTANCE.wrapResult((Boolean) objJ);
            }
            reply.reply(listWrapResult);
            return C2470H.f21956a;
        }

        public final MessageCodec<Object> getCodec() {
            return (MessageCodec) codec$delegate.getValue();
        }

        public final void setUp(BinaryMessenger binaryMessenger, FirebaseRemoteConfigHostApi firebaseRemoteConfigHostApi) {
            AbstractC2304t.f(binaryMessenger, "binaryMessenger");
            setUp$default(this, binaryMessenger, firebaseRemoteConfigHostApi, null, 4, null);
        }

        public final void setUp(BinaryMessenger binaryMessenger, final FirebaseRemoteConfigHostApi firebaseRemoteConfigHostApi, String messageChannelSuffix) {
            String str;
            AbstractC2304t.f(binaryMessenger, "binaryMessenger");
            AbstractC2304t.f(messageChannelSuffix, "messageChannelSuffix");
            if (messageChannelSuffix.length() > 0) {
                str = "." + messageChannelSuffix;
            } else {
                str = "";
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_remote_config_platform_interface.FirebaseRemoteConfigHostApi.fetch" + str, getCodec());
            if (firebaseRemoteConfigHostApi != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.a
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseRemoteConfigHostApi.Companion.setUp$lambda$3$lambda$2(firebaseRemoteConfigHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_remote_config_platform_interface.FirebaseRemoteConfigHostApi.fetchAndActivate" + str, getCodec());
            if (firebaseRemoteConfigHostApi != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.k
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseRemoteConfigHostApi.Companion.setUp$lambda$6$lambda$5(firebaseRemoteConfigHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_remote_config_platform_interface.FirebaseRemoteConfigHostApi.activate" + str, getCodec());
            if (firebaseRemoteConfigHostApi != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.l
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseRemoteConfigHostApi.Companion.setUp$lambda$9$lambda$8(firebaseRemoteConfigHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_remote_config_platform_interface.FirebaseRemoteConfigHostApi.setConfigSettings" + str, getCodec());
            if (firebaseRemoteConfigHostApi != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.m
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseRemoteConfigHostApi.Companion.setUp$lambda$12$lambda$11(firebaseRemoteConfigHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_remote_config_platform_interface.FirebaseRemoteConfigHostApi.setDefaults" + str, getCodec());
            if (firebaseRemoteConfigHostApi != null) {
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.n
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseRemoteConfigHostApi.Companion.setUp$lambda$15$lambda$14(firebaseRemoteConfigHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_remote_config_platform_interface.FirebaseRemoteConfigHostApi.ensureInitialized" + str, getCodec());
            if (firebaseRemoteConfigHostApi != null) {
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.o
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseRemoteConfigHostApi.Companion.setUp$lambda$18$lambda$17(firebaseRemoteConfigHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_remote_config_platform_interface.FirebaseRemoteConfigHostApi.setCustomSignals" + str, getCodec());
            if (firebaseRemoteConfigHostApi != null) {
                basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.p
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseRemoteConfigHostApi.Companion.setUp$lambda$21$lambda$20(firebaseRemoteConfigHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel7.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_remote_config_platform_interface.FirebaseRemoteConfigHostApi.getAll" + str, getCodec());
            if (firebaseRemoteConfigHostApi != null) {
                basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.q
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseRemoteConfigHostApi.Companion.setUp$lambda$24$lambda$23(firebaseRemoteConfigHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel8.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_remote_config_platform_interface.FirebaseRemoteConfigHostApi.getProperties" + str, getCodec());
            if (firebaseRemoteConfigHostApi != null) {
                basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.firebaseremoteconfig.r
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseRemoteConfigHostApi.Companion.setUp$lambda$27$lambda$26(firebaseRemoteConfigHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel9.setMessageHandler(null);
            }
        }
    }

    void activate(String str, B5.k kVar);

    void ensureInitialized(String str, B5.k kVar);

    void fetch(String str, B5.k kVar);

    void fetchAndActivate(String str, B5.k kVar);

    void getAll(String str, B5.k kVar);

    void getProperties(String str, B5.k kVar);

    void setConfigSettings(String str, RemoteConfigPigeonSettings remoteConfigPigeonSettings, B5.k kVar);

    void setCustomSignals(String str, Map<String, ? extends Object> map, B5.k kVar);

    void setDefaults(String str, Map<String, ? extends Object> map, B5.k kVar);
}
