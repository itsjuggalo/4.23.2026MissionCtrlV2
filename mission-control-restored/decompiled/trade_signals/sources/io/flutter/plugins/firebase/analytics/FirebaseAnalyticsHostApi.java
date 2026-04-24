package io.flutter.plugins.firebase.analytics;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.C2470H;
import o5.C2490r;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes.dex */
public interface FirebaseAnalyticsHostApi {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final InterfaceC2483k codec$delegate = AbstractC2484l.a(new Function0() { // from class: io.flutter.plugins.firebase.analytics.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FirebaseAnalyticsHostApi.Companion.codec_delegate$lambda$0();
            }
        });

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final GeneratedAndroidFirebaseAnalyticsPigeonCodec codec_delegate$lambda$0() {
            return new GeneratedAndroidFirebaseAnalyticsPigeonCodec();
        }

        public static /* synthetic */ void setUp$default(Companion companion, BinaryMessenger binaryMessenger, FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, String str, int i8, Object obj) {
            if ((i8 & 4) != 0) {
                str = "";
            }
            companion.setUp(binaryMessenger, firebaseAnalyticsHostApi, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$12$lambda$11(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            firebaseAnalyticsHostApi.setAnalyticsCollectionEnabled(((Boolean) obj2).booleanValue(), new B5.k() { // from class: io.flutter.plugins.firebase.analytics.h
                @Override // B5.k
                public final Object invoke(Object obj3) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11$lambda$10(reply, (C2490r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$12$lambda$11$lambda$10(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$15$lambda$14(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            firebaseAnalyticsHostApi.resetAnalyticsData(new B5.k() { // from class: io.flutter.plugins.firebase.analytics.e
                @Override // B5.k
                public final Object invoke(Object obj2) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14$lambda$13(reply, (C2490r) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$15$lambda$14$lambda$13(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$18$lambda$17(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.Long");
            firebaseAnalyticsHostApi.setSessionTimeoutDuration(((Long) obj2).longValue(), new B5.k() { // from class: io.flutter.plugins.firebase.analytics.o
                @Override // B5.k
                public final Object invoke(Object obj3) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17$lambda$16(reply, (C2490r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$18$lambda$17$lambda$16(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$21$lambda$20(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Boolean?>");
            firebaseAnalyticsHostApi.setConsent((Map) obj2, new B5.k() { // from class: io.flutter.plugins.firebase.analytics.k
                @Override // B5.k
                public final Object invoke(Object obj3) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20$lambda$19(reply, (C2490r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$21$lambda$20$lambda$19(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$24$lambda$23(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            firebaseAnalyticsHostApi.setDefaultEventParameters((Map) ((List) obj).get(0), new B5.k() { // from class: io.flutter.plugins.firebase.analytics.g
                @Override // B5.k
                public final Object invoke(Object obj2) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23$lambda$22(reply, (C2490r) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$24$lambda$23$lambda$22(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$27$lambda$26(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            firebaseAnalyticsHostApi.getAppInstanceId(new B5.k() { // from class: io.flutter.plugins.firebase.analytics.n
                @Override // B5.k
                public final Object invoke(Object obj2) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26$lambda$25(reply, (C2490r) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$27$lambda$26$lambda$25(BasicMessageChannel.Reply reply, C2490r c2490r) {
            List<Object> listWrapResult;
            Throwable thE = C2490r.e(c2490r.j());
            if (thE != null) {
                listWrapResult = GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE);
            } else {
                Object objJ = c2490r.j();
                if (C2490r.g(objJ)) {
                    objJ = null;
                }
                listWrapResult = GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult((String) objJ);
            }
            reply.reply(listWrapResult);
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$3$lambda$2(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            firebaseAnalyticsHostApi.logEvent((Map) obj2, new B5.k() { // from class: io.flutter.plugins.firebase.analytics.i
                @Override // B5.k
                public final Object invoke(Object obj3) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2$lambda$1(reply, (C2490r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$3$lambda$2$lambda$1(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$30$lambda$29(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            firebaseAnalyticsHostApi.getSessionId(new B5.k() { // from class: io.flutter.plugins.firebase.analytics.c
                @Override // B5.k
                public final Object invoke(Object obj2) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29$lambda$28(reply, (C2490r) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$30$lambda$29$lambda$28(BasicMessageChannel.Reply reply, C2490r c2490r) {
            List<Object> listWrapResult;
            Throwable thE = C2490r.e(c2490r.j());
            if (thE != null) {
                listWrapResult = GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE);
            } else {
                Object objJ = c2490r.j();
                if (C2490r.g(objJ)) {
                    objJ = null;
                }
                listWrapResult = GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult((Long) objJ);
            }
            reply.reply(listWrapResult);
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$33$lambda$32(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String?>");
            firebaseAnalyticsHostApi.initiateOnDeviceConversionMeasurement((Map) obj2, new B5.k() { // from class: io.flutter.plugins.firebase.analytics.d
                @Override // B5.k
                public final Object invoke(Object obj3) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32$lambda$31(reply, (C2490r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$33$lambda$32$lambda$31(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$6$lambda$5(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            firebaseAnalyticsHostApi.setUserId((String) ((List) obj).get(0), new B5.k() { // from class: io.flutter.plugins.firebase.analytics.m
                @Override // B5.k
                public final Object invoke(Object obj2) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5$lambda$4(reply, (C2490r) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$6$lambda$5$lambda$4(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$9$lambda$8(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.String");
            firebaseAnalyticsHostApi.setUserProperty((String) obj2, (String) list.get(1), new B5.k() { // from class: io.flutter.plugins.firebase.analytics.j
                @Override // B5.k
                public final Object invoke(Object obj3) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8$lambda$7(reply, (C2490r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C2470H setUp$lambda$9$lambda$8$lambda$7(BasicMessageChannel.Reply reply, C2490r c2490r) {
            Throwable thE = C2490r.e(c2490r.j());
            reply.reply(thE != null ? GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE) : GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            return C2470H.f21956a;
        }

        public final MessageCodec<Object> getCodec() {
            return (MessageCodec) codec$delegate.getValue();
        }

        public final void setUp(BinaryMessenger binaryMessenger, FirebaseAnalyticsHostApi firebaseAnalyticsHostApi) {
            AbstractC2304t.f(binaryMessenger, "binaryMessenger");
            setUp$default(this, binaryMessenger, firebaseAnalyticsHostApi, null, 4, null);
        }

        public final void setUp(BinaryMessenger binaryMessenger, final FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, String messageChannelSuffix) {
            String str;
            AbstractC2304t.f(binaryMessenger, "binaryMessenger");
            AbstractC2304t.f(messageChannelSuffix, "messageChannelSuffix");
            if (messageChannelSuffix.length() > 0) {
                str = "." + messageChannelSuffix;
            } else {
                str = "";
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.logEvent" + str, getCodec());
            if (firebaseAnalyticsHostApi != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.a
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2(firebaseAnalyticsHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setUserId" + str, getCodec());
            if (firebaseAnalyticsHostApi != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.p
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5(firebaseAnalyticsHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setUserProperty" + str, getCodec());
            if (firebaseAnalyticsHostApi != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.q
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8(firebaseAnalyticsHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setAnalyticsCollectionEnabled" + str, getCodec());
            if (firebaseAnalyticsHostApi != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.r
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11(firebaseAnalyticsHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.resetAnalyticsData" + str, getCodec());
            if (firebaseAnalyticsHostApi != null) {
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.s
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14(firebaseAnalyticsHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setSessionTimeoutDuration" + str, getCodec());
            if (firebaseAnalyticsHostApi != null) {
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.t
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17(firebaseAnalyticsHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setConsent" + str, getCodec());
            if (firebaseAnalyticsHostApi != null) {
                basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.u
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20(firebaseAnalyticsHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel7.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setDefaultEventParameters" + str, getCodec());
            if (firebaseAnalyticsHostApi != null) {
                basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.v
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23(firebaseAnalyticsHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel8.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.getAppInstanceId" + str, getCodec());
            if (firebaseAnalyticsHostApi != null) {
                basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26(firebaseAnalyticsHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel9.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.getSessionId" + str, getCodec());
            if (firebaseAnalyticsHostApi != null) {
                basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.b
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29(firebaseAnalyticsHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel10.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.initiateOnDeviceConversionMeasurement" + str, getCodec());
            if (firebaseAnalyticsHostApi != null) {
                basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.l
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32(firebaseAnalyticsHostApi, obj, reply);
                    }
                });
            } else {
                basicMessageChannel11.setMessageHandler(null);
            }
        }
    }

    void getAppInstanceId(B5.k kVar);

    void getSessionId(B5.k kVar);

    void initiateOnDeviceConversionMeasurement(Map<String, String> map, B5.k kVar);

    void logEvent(Map<String, ? extends Object> map, B5.k kVar);

    void resetAnalyticsData(B5.k kVar);

    void setAnalyticsCollectionEnabled(boolean z7, B5.k kVar);

    void setConsent(Map<String, Boolean> map, B5.k kVar);

    void setDefaultEventParameters(Map<String, ? extends Object> map, B5.k kVar);

    void setSessionTimeoutDuration(long j8, B5.k kVar);

    void setUserId(String str, B5.k kVar);

    void setUserProperty(String str, String str2, B5.k kVar);
}
