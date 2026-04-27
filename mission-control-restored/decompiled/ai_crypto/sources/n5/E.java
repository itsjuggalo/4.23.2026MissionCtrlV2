package n5;

import F5.AbstractC0555m;
import V4.a;
import V4.b;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import n5.E;

/* JADX INFO: loaded from: classes2.dex */
public interface E {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f19712b = a.f19713a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f19713a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final E5.j f19714b = E5.k.b(new Function0() { // from class: n5.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return E.a.q();
            }
        });

        public static final void A(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                listB = AbstractC0555m.b(e7.e(str, (H) obj3));
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final void B(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                listB = AbstractC0555m.b(e7.n(str, (H) obj3));
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final void C(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            List list2 = (List) list.get(0);
            Object obj2 = list.get(1);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                e7.k(list2, (H) obj2);
                listB = AbstractC0555m.b(null);
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final void D(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            List list2 = (List) list.get(0);
            Object obj2 = list.get(1);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                listB = AbstractC0555m.b(e7.c(list2, (H) obj2));
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final void E(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            List list2 = (List) list.get(0);
            Object obj2 = list.get(1);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                listB = AbstractC0555m.b(e7.b(list2, (H) obj2));
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final void F(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) obj3;
            Object obj4 = list.get(2);
            kotlin.jvm.internal.r.d(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                e7.l(str, str2, (H) obj4);
                listB = AbstractC0555m.b(null);
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final void G(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj3).longValue();
            Object obj4 = list.get(2);
            kotlin.jvm.internal.r.d(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                e7.f(str, jLongValue, (H) obj4);
                listB = AbstractC0555m.b(null);
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final void H(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.Double");
            double dDoubleValue = ((Double) obj3).doubleValue();
            Object obj4 = list.get(2);
            kotlin.jvm.internal.r.d(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                e7.h(str, dDoubleValue, (H) obj4);
                listB = AbstractC0555m.b(null);
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final C2278m q() {
            return new C2278m();
        }

        public static final void t(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) obj3;
            Object obj4 = list.get(2);
            kotlin.jvm.internal.r.d(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                e7.j(str, str2, (H) obj4);
                listB = AbstractC0555m.b(null);
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final void u(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            List list2 = (List) obj3;
            Object obj4 = list.get(2);
            kotlin.jvm.internal.r.d(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                e7.a(str, list2, (H) obj4);
                listB = AbstractC0555m.b(null);
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final void v(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                listB = AbstractC0555m.b(e7.g(str, (H) obj3));
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final void w(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                listB = AbstractC0555m.b(e7.m(str, (H) obj3));
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final void x(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                listB = AbstractC0555m.b(e7.o(str, (H) obj3));
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final void y(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) obj3).booleanValue();
            Object obj4 = list.get(2);
            kotlin.jvm.internal.r.d(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                e7.d(str, zBooleanValue, (H) obj4);
                listB = AbstractC0555m.b(null);
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public static final void z(E e7, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
            try {
                listB = AbstractC0555m.b(e7.i(str, (H) obj3));
            } catch (Throwable th) {
                listB = n.b(th);
            }
            reply.a(listB);
        }

        public final V4.h r() {
            return (V4.h) f19714b.getValue();
        }

        public final void s(V4.b binaryMessenger, final E e7, String messageChannelSuffix) {
            String str;
            kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
            kotlin.jvm.internal.r.f(messageChannelSuffix, "messageChannelSuffix");
            if (messageChannelSuffix.length() > 0) {
                str = "." + messageChannelSuffix;
            } else {
                str = "";
            }
            b.c cVarC = binaryMessenger.c();
            V4.a aVar = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setBool" + str, r(), cVarC);
            if (e7 != null) {
                aVar.e(new a.d() { // from class: n5.v
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.y(e7, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setString" + str, r(), cVarC);
            if (e7 != null) {
                aVar2.e(new a.d() { // from class: n5.B
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.F(e7, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setInt" + str, r(), cVarC);
            if (e7 != null) {
                aVar3.e(new a.d() { // from class: n5.C
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.G(e7, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            V4.a aVar4 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setDouble" + str, r(), cVarC);
            if (e7 != null) {
                aVar4.e(new a.d() { // from class: n5.D
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.H(e7, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            V4.a aVar5 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setEncodedStringList" + str, r(), cVarC);
            if (e7 != null) {
                aVar5.e(new a.d() { // from class: n5.p
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.t(e7, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
            V4.a aVar6 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setDeprecatedStringList" + str, r(), cVarC);
            if (e7 != null) {
                aVar6.e(new a.d() { // from class: n5.q
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.u(e7, obj, eVar);
                    }
                });
            } else {
                aVar6.e(null);
            }
            V4.a aVar7 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getString" + str, r(), cVarC);
            if (e7 != null) {
                aVar7.e(new a.d() { // from class: n5.r
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.v(e7, obj, eVar);
                    }
                });
            } else {
                aVar7.e(null);
            }
            V4.a aVar8 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getBool" + str, r(), cVarC);
            if (e7 != null) {
                aVar8.e(new a.d() { // from class: n5.s
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.w(e7, obj, eVar);
                    }
                });
            } else {
                aVar8.e(null);
            }
            V4.a aVar9 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getDouble" + str, r(), cVarC);
            if (e7 != null) {
                aVar9.e(new a.d() { // from class: n5.t
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.x(e7, obj, eVar);
                    }
                });
            } else {
                aVar9.e(null);
            }
            V4.a aVar10 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getInt" + str, r(), cVarC);
            if (e7 != null) {
                aVar10.e(new a.d() { // from class: n5.u
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.z(e7, obj, eVar);
                    }
                });
            } else {
                aVar10.e(null);
            }
            V4.a aVar11 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getPlatformEncodedStringList" + str, r(), cVarC);
            if (e7 != null) {
                aVar11.e(new a.d() { // from class: n5.w
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.A(e7, obj, eVar);
                    }
                });
            } else {
                aVar11.e(null);
            }
            V4.a aVar12 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getStringList" + str, r(), cVarC);
            if (e7 != null) {
                aVar12.e(new a.d() { // from class: n5.x
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.B(e7, obj, eVar);
                    }
                });
            } else {
                aVar12.e(null);
            }
            V4.a aVar13 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.clear" + str, r(), cVarC);
            if (e7 != null) {
                aVar13.e(new a.d() { // from class: n5.y
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.C(e7, obj, eVar);
                    }
                });
            } else {
                aVar13.e(null);
            }
            V4.a aVar14 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getAll" + str, r(), cVarC);
            if (e7 != null) {
                aVar14.e(new a.d() { // from class: n5.z
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.D(e7, obj, eVar);
                    }
                });
            } else {
                aVar14.e(null);
            }
            V4.a aVar15 = new V4.a(binaryMessenger, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getKeys" + str, r(), cVarC);
            if (e7 != null) {
                aVar15.e(new a.d() { // from class: n5.A
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        E.a.E(e7, obj, eVar);
                    }
                });
            } else {
                aVar15.e(null);
            }
        }
    }

    void a(String str, List list, H h7);

    List b(List list, H h7);

    Map c(List list, H h7);

    void d(String str, boolean z7, H h7);

    List e(String str, H h7);

    void f(String str, long j7, H h7);

    String g(String str, H h7);

    void h(String str, double d7, H h7);

    Long i(String str, H h7);

    void j(String str, String str2, H h7);

    void k(List list, H h7);

    void l(String str, String str2, H h7);

    Boolean m(String str, H h7);

    M n(String str, H h7);

    Double o(String str, H h7);
}
