package a5;

import V4.a;
import a5.InterfaceC0927y;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: a5.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC0927y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6394a = a.f6395a;

    /* JADX INFO: renamed from: a5.y$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f6395a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final E5.j f6396b = E5.k.b(new Function0() { // from class: a5.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InterfaceC0927y.a.x();
            }
        });

        public static /* synthetic */ void A(a aVar, V4.b bVar, InterfaceC0927y interfaceC0927y, String str, int i7, Object obj) {
            if ((i7 & 4) != 0) {
                str = "";
            }
            aVar.z(bVar, interfaceC0927y, str);
        }

        public static final void B(InterfaceC0927y interfaceC0927y, Object obj, final a.e reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            interfaceC0927y.b(((Boolean) obj2).booleanValue(), new Q5.k() { // from class: a5.i
                @Override // Q5.k
                public final Object invoke(Object obj3) {
                    return InterfaceC0927y.a.C(reply, (E5.p) obj3);
                }
            });
        }

        public static final E5.E C(a.e reply, E5.p pVar) {
            kotlin.jvm.internal.r.f(reply, "$reply");
            Throwable thE = E5.p.e(pVar.j());
            if (thE != null) {
                reply.a(Z.f6368a.b(thE));
            } else {
                reply.a(Z.f6368a.c(null));
            }
            return E5.E.f1657a;
        }

        public static final void D(InterfaceC0927y interfaceC0927y, Object obj, final a.e reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            interfaceC0927y.g(new Q5.k() { // from class: a5.g
                @Override // Q5.k
                public final Object invoke(Object obj2) {
                    return InterfaceC0927y.a.E(reply, (E5.p) obj2);
                }
            });
        }

        public static final E5.E E(a.e reply, E5.p pVar) {
            kotlin.jvm.internal.r.f(reply, "$reply");
            Throwable thE = E5.p.e(pVar.j());
            if (thE != null) {
                reply.a(Z.f6368a.b(thE));
            } else {
                reply.a(Z.f6368a.c(null));
            }
            return E5.E.f1657a;
        }

        public static final void F(InterfaceC0927y interfaceC0927y, Object obj, final a.e reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.Long");
            interfaceC0927y.d(((Long) obj2).longValue(), new Q5.k() { // from class: a5.p
                @Override // Q5.k
                public final Object invoke(Object obj3) {
                    return InterfaceC0927y.a.G(reply, (E5.p) obj3);
                }
            });
        }

        public static final E5.E G(a.e reply, E5.p pVar) {
            kotlin.jvm.internal.r.f(reply, "$reply");
            Throwable thE = E5.p.e(pVar.j());
            if (thE != null) {
                reply.a(Z.f6368a.b(thE));
            } else {
                reply.a(Z.f6368a.c(null));
            }
            return E5.E.f1657a;
        }

        public static final void H(InterfaceC0927y interfaceC0927y, Object obj, final a.e reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Boolean?>");
            interfaceC0927y.h((Map) obj2, new Q5.k() { // from class: a5.l
                @Override // Q5.k
                public final Object invoke(Object obj3) {
                    return InterfaceC0927y.a.I(reply, (E5.p) obj3);
                }
            });
        }

        public static final E5.E I(a.e reply, E5.p pVar) {
            kotlin.jvm.internal.r.f(reply, "$reply");
            Throwable thE = E5.p.e(pVar.j());
            if (thE != null) {
                reply.a(Z.f6368a.b(thE));
            } else {
                reply.a(Z.f6368a.c(null));
            }
            return E5.E.f1657a;
        }

        public static final void J(InterfaceC0927y interfaceC0927y, Object obj, final a.e reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            interfaceC0927y.j((Map) ((List) obj).get(0), new Q5.k() { // from class: a5.h
                @Override // Q5.k
                public final Object invoke(Object obj2) {
                    return InterfaceC0927y.a.K(reply, (E5.p) obj2);
                }
            });
        }

        public static final E5.E K(a.e reply, E5.p pVar) {
            kotlin.jvm.internal.r.f(reply, "$reply");
            Throwable thE = E5.p.e(pVar.j());
            if (thE != null) {
                reply.a(Z.f6368a.b(thE));
            } else {
                reply.a(Z.f6368a.c(null));
            }
            return E5.E.f1657a;
        }

        public static final void L(InterfaceC0927y interfaceC0927y, Object obj, final a.e reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            interfaceC0927y.k(new Q5.k() { // from class: a5.o
                @Override // Q5.k
                public final Object invoke(Object obj2) {
                    return InterfaceC0927y.a.M(reply, (E5.p) obj2);
                }
            });
        }

        public static final E5.E M(a.e reply, E5.p pVar) {
            kotlin.jvm.internal.r.f(reply, "$reply");
            Throwable thE = E5.p.e(pVar.j());
            if (thE != null) {
                reply.a(Z.f6368a.b(thE));
            } else {
                Object objJ = pVar.j();
                if (E5.p.g(objJ)) {
                    objJ = null;
                }
                reply.a(Z.f6368a.c((String) objJ));
            }
            return E5.E.f1657a;
        }

        public static final void N(InterfaceC0927y interfaceC0927y, Object obj, final a.e reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            interfaceC0927y.a((Map) obj2, new Q5.k() { // from class: a5.j
                @Override // Q5.k
                public final Object invoke(Object obj3) {
                    return InterfaceC0927y.a.O(reply, (E5.p) obj3);
                }
            });
        }

        public static final E5.E O(a.e reply, E5.p pVar) {
            kotlin.jvm.internal.r.f(reply, "$reply");
            Throwable thE = E5.p.e(pVar.j());
            if (thE != null) {
                reply.a(Z.f6368a.b(thE));
            } else {
                reply.a(Z.f6368a.c(null));
            }
            return E5.E.f1657a;
        }

        public static final void P(InterfaceC0927y interfaceC0927y, Object obj, final a.e reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            interfaceC0927y.e(new Q5.k() { // from class: a5.e
                @Override // Q5.k
                public final Object invoke(Object obj2) {
                    return InterfaceC0927y.a.Q(reply, (E5.p) obj2);
                }
            });
        }

        public static final E5.E Q(a.e reply, E5.p pVar) {
            kotlin.jvm.internal.r.f(reply, "$reply");
            Throwable thE = E5.p.e(pVar.j());
            if (thE != null) {
                reply.a(Z.f6368a.b(thE));
            } else {
                Object objJ = pVar.j();
                if (E5.p.g(objJ)) {
                    objJ = null;
                }
                reply.a(Z.f6368a.c((Long) objJ));
            }
            return E5.E.f1657a;
        }

        public static final void R(InterfaceC0927y interfaceC0927y, Object obj, final a.e reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String?>");
            interfaceC0927y.c((Map) obj2, new Q5.k() { // from class: a5.f
                @Override // Q5.k
                public final Object invoke(Object obj3) {
                    return InterfaceC0927y.a.S(reply, (E5.p) obj3);
                }
            });
        }

        public static final E5.E S(a.e reply, E5.p pVar) {
            kotlin.jvm.internal.r.f(reply, "$reply");
            Throwable thE = E5.p.e(pVar.j());
            if (thE != null) {
                reply.a(Z.f6368a.b(thE));
            } else {
                reply.a(Z.f6368a.c(null));
            }
            return E5.E.f1657a;
        }

        public static final void T(InterfaceC0927y interfaceC0927y, Object obj, final a.e reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            interfaceC0927y.f((String) ((List) obj).get(0), new Q5.k() { // from class: a5.n
                @Override // Q5.k
                public final Object invoke(Object obj2) {
                    return InterfaceC0927y.a.U(reply, (E5.p) obj2);
                }
            });
        }

        public static final E5.E U(a.e reply, E5.p pVar) {
            kotlin.jvm.internal.r.f(reply, "$reply");
            Throwable thE = E5.p.e(pVar.j());
            if (thE != null) {
                reply.a(Z.f6368a.b(thE));
            } else {
                reply.a(Z.f6368a.c(null));
            }
            return E5.E.f1657a;
        }

        public static final void V(InterfaceC0927y interfaceC0927y, Object obj, final a.e reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            interfaceC0927y.i((String) obj2, (String) list.get(1), new Q5.k() { // from class: a5.k
                @Override // Q5.k
                public final Object invoke(Object obj3) {
                    return InterfaceC0927y.a.W(reply, (E5.p) obj3);
                }
            });
        }

        public static final E5.E W(a.e reply, E5.p pVar) {
            kotlin.jvm.internal.r.f(reply, "$reply");
            Throwable thE = E5.p.e(pVar.j());
            if (thE != null) {
                reply.a(Z.f6368a.b(thE));
            } else {
                reply.a(Z.f6368a.c(null));
            }
            return E5.E.f1657a;
        }

        public static final Y x() {
            return new Y();
        }

        public final V4.h y() {
            return (V4.h) f6396b.getValue();
        }

        public final void z(V4.b binaryMessenger, final InterfaceC0927y interfaceC0927y, String messageChannelSuffix) {
            String str;
            kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
            kotlin.jvm.internal.r.f(messageChannelSuffix, "messageChannelSuffix");
            if (messageChannelSuffix.length() > 0) {
                str = "." + messageChannelSuffix;
            } else {
                str = "";
            }
            V4.a aVar = new V4.a(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.logEvent" + str, y());
            if (interfaceC0927y != null) {
                aVar.e(new a.d() { // from class: a5.m
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        InterfaceC0927y.a.N(interfaceC0927y, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setUserId" + str, y());
            if (interfaceC0927y != null) {
                aVar2.e(new a.d() { // from class: a5.r
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        InterfaceC0927y.a.T(interfaceC0927y, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setUserProperty" + str, y());
            if (interfaceC0927y != null) {
                aVar3.e(new a.d() { // from class: a5.s
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        InterfaceC0927y.a.V(interfaceC0927y, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            V4.a aVar4 = new V4.a(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setAnalyticsCollectionEnabled" + str, y());
            if (interfaceC0927y != null) {
                aVar4.e(new a.d() { // from class: a5.t
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        InterfaceC0927y.a.B(interfaceC0927y, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            V4.a aVar5 = new V4.a(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.resetAnalyticsData" + str, y());
            if (interfaceC0927y != null) {
                aVar5.e(new a.d() { // from class: a5.u
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        InterfaceC0927y.a.D(interfaceC0927y, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
            V4.a aVar6 = new V4.a(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setSessionTimeoutDuration" + str, y());
            if (interfaceC0927y != null) {
                aVar6.e(new a.d() { // from class: a5.v
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        InterfaceC0927y.a.F(interfaceC0927y, obj, eVar);
                    }
                });
            } else {
                aVar6.e(null);
            }
            V4.a aVar7 = new V4.a(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setConsent" + str, y());
            if (interfaceC0927y != null) {
                aVar7.e(new a.d() { // from class: a5.w
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        InterfaceC0927y.a.H(interfaceC0927y, obj, eVar);
                    }
                });
            } else {
                aVar7.e(null);
            }
            V4.a aVar8 = new V4.a(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setDefaultEventParameters" + str, y());
            if (interfaceC0927y != null) {
                aVar8.e(new a.d() { // from class: a5.x
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        InterfaceC0927y.a.J(interfaceC0927y, obj, eVar);
                    }
                });
            } else {
                aVar8.e(null);
            }
            V4.a aVar9 = new V4.a(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.getAppInstanceId" + str, y());
            if (interfaceC0927y != null) {
                aVar9.e(new a.d() { // from class: a5.c
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        InterfaceC0927y.a.L(interfaceC0927y, obj, eVar);
                    }
                });
            } else {
                aVar9.e(null);
            }
            V4.a aVar10 = new V4.a(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.getSessionId" + str, y());
            if (interfaceC0927y != null) {
                aVar10.e(new a.d() { // from class: a5.d
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        InterfaceC0927y.a.P(interfaceC0927y, obj, eVar);
                    }
                });
            } else {
                aVar10.e(null);
            }
            V4.a aVar11 = new V4.a(binaryMessenger, "dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.initiateOnDeviceConversionMeasurement" + str, y());
            if (interfaceC0927y != null) {
                aVar11.e(new a.d() { // from class: a5.q
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        InterfaceC0927y.a.R(interfaceC0927y, obj, eVar);
                    }
                });
            } else {
                aVar11.e(null);
            }
        }
    }

    void a(Map map, Q5.k kVar);

    void b(boolean z7, Q5.k kVar);

    void c(Map map, Q5.k kVar);

    void d(long j7, Q5.k kVar);

    void e(Q5.k kVar);

    void f(String str, Q5.k kVar);

    void g(Q5.k kVar);

    void h(Map map, Q5.k kVar);

    void i(String str, String str2, Q5.k kVar);

    void j(Map map, Q5.k kVar);

    void k(Q5.k kVar);
}
