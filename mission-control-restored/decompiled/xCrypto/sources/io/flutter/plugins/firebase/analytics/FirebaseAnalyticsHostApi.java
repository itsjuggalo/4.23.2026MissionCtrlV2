package io.flutter.plugins.firebase.analytics;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public interface FirebaseAnalyticsHostApi {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final W2.j codec$delegate = W2.k.b(new Function0() { // from class: io.flutter.plugins.firebase.analytics.f
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

        public static /* synthetic */ void setUp$default(Companion companion, BinaryMessenger binaryMessenger, FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, String str, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                str = "";
            }
            companion.setUp(binaryMessenger, firebaseAnalyticsHostApi, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$12$lambda$11(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            firebaseAnalyticsHostApi.setAnalyticsCollectionEnabled(((Boolean) obj2).booleanValue(), new i3.k() { // from class: io.flutter.plugins.firebase.analytics.h
                @Override // i3.k
                public final Object invoke(Object obj3) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11$lambda$10(reply, (W2.p) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final W2.E setUp$lambda$12$lambda$11$lambda$10(BasicMessageChannel.Reply reply, W2.p pVar) {
            Throwable thE = W2.p.e(pVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return W2.E.f5463a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$15$lambda$14(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            firebaseAnalyticsHostApi.resetAnalyticsData(new i3.k() { // from class: io.flutter.plugins.firebase.analytics.e
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14$lambda$13(reply, (W2.p) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final W2.E setUp$lambda$15$lambda$14$lambda$13(BasicMessageChannel.Reply reply, W2.p pVar) {
            Throwable thE = W2.p.e(pVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return W2.E.f5463a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$18$lambda$17(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.Long");
            firebaseAnalyticsHostApi.setSessionTimeoutDuration(((Long) obj2).longValue(), new i3.k() { // from class: io.flutter.plugins.firebase.analytics.o
                @Override // i3.k
                public final Object invoke(Object obj3) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17$lambda$16(reply, (W2.p) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final W2.E setUp$lambda$18$lambda$17$lambda$16(BasicMessageChannel.Reply reply, W2.p pVar) {
            Throwable thE = W2.p.e(pVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return W2.E.f5463a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$21$lambda$20(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Boolean?>");
            firebaseAnalyticsHostApi.setConsent((Map) obj2, new i3.k() { // from class: io.flutter.plugins.firebase.analytics.k
                @Override // i3.k
                public final Object invoke(Object obj3) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20$lambda$19(reply, (W2.p) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final W2.E setUp$lambda$21$lambda$20$lambda$19(BasicMessageChannel.Reply reply, W2.p pVar) {
            Throwable thE = W2.p.e(pVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return W2.E.f5463a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$24$lambda$23(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            firebaseAnalyticsHostApi.setDefaultEventParameters((Map) ((List) obj).get(0), new i3.k() { // from class: io.flutter.plugins.firebase.analytics.g
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23$lambda$22(reply, (W2.p) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final W2.E setUp$lambda$24$lambda$23$lambda$22(BasicMessageChannel.Reply reply, W2.p pVar) {
            Throwable thE = W2.p.e(pVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return W2.E.f5463a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$27$lambda$26(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            firebaseAnalyticsHostApi.getAppInstanceId(new i3.k() { // from class: io.flutter.plugins.firebase.analytics.n
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26$lambda$25(reply, (W2.p) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final W2.E setUp$lambda$27$lambda$26$lambda$25(BasicMessageChannel.Reply reply, W2.p pVar) {
            Throwable thE = W2.p.e(pVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                Object objJ = pVar.j();
                if (W2.p.g(objJ)) {
                    objJ = null;
                }
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult((String) objJ));
            }
            return W2.E.f5463a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$3$lambda$2(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            firebaseAnalyticsHostApi.logEvent((Map) obj2, new i3.k() { // from class: io.flutter.plugins.firebase.analytics.i
                @Override // i3.k
                public final Object invoke(Object obj3) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2$lambda$1(reply, (W2.p) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final W2.E setUp$lambda$3$lambda$2$lambda$1(BasicMessageChannel.Reply reply, W2.p pVar) {
            Throwable thE = W2.p.e(pVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return W2.E.f5463a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$30$lambda$29(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            firebaseAnalyticsHostApi.getSessionId(new i3.k() { // from class: io.flutter.plugins.firebase.analytics.c
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29$lambda$28(reply, (W2.p) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final W2.E setUp$lambda$30$lambda$29$lambda$28(BasicMessageChannel.Reply reply, W2.p pVar) {
            Throwable thE = W2.p.e(pVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                Object objJ = pVar.j();
                if (W2.p.g(objJ)) {
                    objJ = null;
                }
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult((Long) objJ));
            }
            return W2.E.f5463a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$33$lambda$32(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String?>");
            firebaseAnalyticsHostApi.initiateOnDeviceConversionMeasurement((Map) obj2, new i3.k() { // from class: io.flutter.plugins.firebase.analytics.d
                @Override // i3.k
                public final Object invoke(Object obj3) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32$lambda$31(reply, (W2.p) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final W2.E setUp$lambda$33$lambda$32$lambda$31(BasicMessageChannel.Reply reply, W2.p pVar) {
            Throwable thE = W2.p.e(pVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return W2.E.f5463a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$6$lambda$5(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            firebaseAnalyticsHostApi.setUserId((String) ((List) obj).get(0), new i3.k() { // from class: io.flutter.plugins.firebase.analytics.m
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5$lambda$4(reply, (W2.p) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final W2.E setUp$lambda$6$lambda$5$lambda$4(BasicMessageChannel.Reply reply, W2.p pVar) {
            Throwable thE = W2.p.e(pVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return W2.E.f5463a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$9$lambda$8(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            firebaseAnalyticsHostApi.setUserProperty((String) obj2, (String) list.get(1), new i3.k() { // from class: io.flutter.plugins.firebase.analytics.j
                @Override // i3.k
                public final Object invoke(Object obj3) {
                    return FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8$lambda$7(reply, (W2.p) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final W2.E setUp$lambda$9$lambda$8$lambda$7(BasicMessageChannel.Reply reply, W2.p pVar) {
            Throwable thE = W2.p.e(pVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return W2.E.f5463a;
        }

        public final MessageCodec<Object> getCodec() {
            return (MessageCodec) codec$delegate.getValue();
        }

        public final void setUp(BinaryMessenger binaryMessenger, FirebaseAnalyticsHostApi firebaseAnalyticsHostApi) {
            kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
            setUp$default(this, binaryMessenger, firebaseAnalyticsHostApi, null, 4, null);
        }

        public final void setUp(BinaryMessenger binaryMessenger, final FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, String messageChannelSuffix) {
            String str;
            kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
            kotlin.jvm.internal.r.f(messageChannelSuffix, "messageChannelSuffix");
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

    void getAppInstanceId(i3.k kVar);

    void getSessionId(i3.k kVar);

    void initiateOnDeviceConversionMeasurement(Map<String, String> map, i3.k kVar);

    void logEvent(Map<String, ? extends Object> map, i3.k kVar);

    void resetAnalyticsData(i3.k kVar);

    void setAnalyticsCollectionEnabled(boolean z4, i3.k kVar);

    void setConsent(Map<String, Boolean> map, i3.k kVar);

    void setDefaultEventParameters(Map<String, ? extends Object> map, i3.k kVar);

    void setSessionTimeoutDuration(long j4, i3.k kVar);

    void setUserId(String str, i3.k kVar);

    void setUserProperty(String str, String str2, i3.k kVar);
}
