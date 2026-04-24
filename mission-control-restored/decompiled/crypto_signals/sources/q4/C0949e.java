package q4;

import N1.C0146y;
import java.util.List;
import s3.AbstractC1024h;
import s3.B0;
import s3.I0;

/* JADX INFO: renamed from: q4.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0949e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ C0949e f9329a = new C0949e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final G4.j f9330b = F1.h.B(new N3.a(1));

    public static Z3.m a() {
        return (Z3.m) f9330b.getValue();
    }

    public static void b(Z3.f binaryMessenger, final InterfaceC0950f interfaceC0950f, String str) {
        kotlin.jvm.internal.j.e(binaryMessenger, "binaryMessenger");
        String strConcat = str.length() > 0 ? ".".concat(str) : "";
        C0146y c0146yD = binaryMessenger.d();
        e3.w wVar = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setBool", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i = 6;
            wVar.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar.L(null);
        }
        e3.w wVar2 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setString", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i6 = 12;
            wVar2.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i6) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar2.L(null);
        }
        e3.w wVar3 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setInt", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i7 = 13;
            wVar3.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i7) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar3.L(null);
        }
        e3.w wVar4 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setDouble", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i8 = 14;
            wVar4.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i8) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar4.L(null);
        }
        e3.w wVar5 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setEncodedStringList", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i9 = 0;
            wVar5.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i9) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar5.L(null);
        }
        e3.w wVar6 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setDeprecatedStringList", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i10 = 1;
            wVar6.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i10) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar6.L(null);
        }
        e3.w wVar7 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getString", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i11 = 2;
            wVar7.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i11) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar7.L(null);
        }
        e3.w wVar8 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getBool", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i12 = 3;
            wVar8.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i12) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar8.L(null);
        }
        e3.w wVar9 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getDouble", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i13 = 4;
            wVar9.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i13) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar9.L(null);
        }
        e3.w wVar10 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getInt", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i14 = 5;
            wVar10.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i14) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar10.L(null);
        }
        e3.w wVar11 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getPlatformEncodedStringList", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i15 = 7;
            wVar11.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i15) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar11.L(null);
        }
        e3.w wVar12 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getStringList", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i16 = 8;
            wVar12.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i16) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar12.L(null);
        }
        e3.w wVar13 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.clear", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i17 = 9;
            wVar13.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i17) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar13.L(null);
        }
        e3.w wVar14 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getAll", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f != null) {
            final int i18 = 10;
            wVar14.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i18) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        } else {
            wVar14.L(null);
        }
        e3.w wVar15 = new e3.w(13, AbstractC1024h.b("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getKeys", strConcat), binaryMessenger, a(), c0146yD);
        if (interfaceC0950f == null) {
            wVar15.L(null);
        } else {
            final int i19 = 11;
            wVar15.L(new Z3.b() { // from class: q4.d
                @Override // Z3.b
                public final void d(Object obj, Y3.d dVar) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i19) {
                        case 0:
                            InterfaceC0950f interfaceC0950f2 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            kotlin.jvm.internal.j.c(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            kotlin.jvm.internal.j.c(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            kotlin.jvm.internal.j.c(obj4, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f2.w(str2, str3, (C0951g) obj4);
                                listA = y5.a.D(null);
                            } catch (Throwable th) {
                                listA = s3.D.a(th);
                            }
                            dVar.f(listA);
                            break;
                        case 1:
                            InterfaceC0950f interfaceC0950f3 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            kotlin.jvm.internal.j.c(obj5, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            kotlin.jvm.internal.j.c(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            kotlin.jvm.internal.j.c(obj7, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f3.i(str4, list3, (C0951g) obj7);
                                listA2 = y5.a.D(null);
                            } catch (Throwable th2) {
                                listA2 = s3.D.a(th2);
                            }
                            dVar.f(listA2);
                            break;
                        case 2:
                            InterfaceC0950f interfaceC0950f4 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            kotlin.jvm.internal.j.c(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            kotlin.jvm.internal.j.c(obj9, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA3 = y5.a.D(interfaceC0950f4.o(str5, (C0951g) obj9));
                            } catch (Throwable th3) {
                                listA3 = s3.D.a(th3);
                            }
                            dVar.f(listA3);
                            break;
                        case 3:
                            InterfaceC0950f interfaceC0950f5 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            kotlin.jvm.internal.j.c(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            kotlin.jvm.internal.j.c(obj11, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA4 = y5.a.D(interfaceC0950f5.l(str6, (C0951g) obj11));
                            } catch (Throwable th4) {
                                listA4 = s3.D.a(th4);
                            }
                            dVar.f(listA4);
                            break;
                        case 4:
                            InterfaceC0950f interfaceC0950f6 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            kotlin.jvm.internal.j.c(obj12, "null cannot be cast to non-null type kotlin.String");
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            kotlin.jvm.internal.j.c(obj13, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA5 = y5.a.D(interfaceC0950f6.c(str7, (C0951g) obj13));
                            } catch (Throwable th5) {
                                listA5 = s3.D.a(th5);
                            }
                            dVar.f(listA5);
                            break;
                        case 5:
                            InterfaceC0950f interfaceC0950f7 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            kotlin.jvm.internal.j.c(obj14, "null cannot be cast to non-null type kotlin.String");
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            kotlin.jvm.internal.j.c(obj15, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA6 = y5.a.D(interfaceC0950f7.v(str8, (C0951g) obj15));
                            } catch (Throwable th6) {
                                listA6 = s3.D.a(th6);
                            }
                            dVar.f(listA6);
                            break;
                        case 6:
                            InterfaceC0950f interfaceC0950f8 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            kotlin.jvm.internal.j.c(obj16, "null cannot be cast to non-null type kotlin.String");
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            kotlin.jvm.internal.j.c(obj17, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            kotlin.jvm.internal.j.c(obj18, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f8.b(str9, zBooleanValue, (C0951g) obj18);
                                listA7 = y5.a.D(null);
                            } catch (Throwable th7) {
                                listA7 = s3.D.a(th7);
                            }
                            dVar.f(listA7);
                            break;
                        case 7:
                            InterfaceC0950f interfaceC0950f9 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            kotlin.jvm.internal.j.c(obj19, "null cannot be cast to non-null type kotlin.String");
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            kotlin.jvm.internal.j.c(obj20, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA8 = y5.a.D(interfaceC0950f9.k(str10, (C0951g) obj20));
                            } catch (Throwable th8) {
                                listA8 = s3.D.a(th8);
                            }
                            dVar.f(listA8);
                            break;
                        case 8:
                            InterfaceC0950f interfaceC0950f10 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            kotlin.jvm.internal.j.c(obj21, "null cannot be cast to non-null type kotlin.String");
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            kotlin.jvm.internal.j.c(obj22, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA9 = y5.a.D(interfaceC0950f10.h(str11, (C0951g) obj22));
                            } catch (Throwable th9) {
                                listA9 = s3.D.a(th9);
                            }
                            dVar.f(listA9);
                            break;
                        case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            InterfaceC0950f interfaceC0950f11 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            kotlin.jvm.internal.j.c(obj23, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f11.r(list12, (C0951g) obj23);
                                listA10 = y5.a.D(null);
                            } catch (Throwable th10) {
                                listA10 = s3.D.a(th10);
                            }
                            dVar.f(listA10);
                            break;
                        case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            InterfaceC0950f interfaceC0950f12 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            kotlin.jvm.internal.j.c(obj24, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA11 = y5.a.D(interfaceC0950f12.f(list14, (C0951g) obj24));
                            } catch (Throwable th11) {
                                listA11 = s3.D.a(th11);
                            }
                            dVar.f(listA11);
                            break;
                        case 11:
                            InterfaceC0950f interfaceC0950f13 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            kotlin.jvm.internal.j.c(obj25, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                listA12 = y5.a.D(interfaceC0950f13.s(list16, (C0951g) obj25));
                            } catch (Throwable th12) {
                                listA12 = s3.D.a(th12);
                            }
                            dVar.f(listA12);
                            break;
                        case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            InterfaceC0950f interfaceC0950f14 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            kotlin.jvm.internal.j.c(obj26, "null cannot be cast to non-null type kotlin.String");
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            kotlin.jvm.internal.j.c(obj27, "null cannot be cast to non-null type kotlin.String");
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            kotlin.jvm.internal.j.c(obj28, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f14.p(str12, str13, (C0951g) obj28);
                                listA13 = y5.a.D(null);
                            } catch (Throwable th13) {
                                listA13 = s3.D.a(th13);
                            }
                            dVar.f(listA13);
                            break;
                        case 13:
                            InterfaceC0950f interfaceC0950f15 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            kotlin.jvm.internal.j.c(obj29, "null cannot be cast to non-null type kotlin.String");
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            kotlin.jvm.internal.j.c(obj30, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            kotlin.jvm.internal.j.c(obj31, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f15.g(str14, jLongValue, (C0951g) obj31);
                                listA14 = y5.a.D(null);
                            } catch (Throwable th14) {
                                listA14 = s3.D.a(th14);
                            }
                            dVar.f(listA14);
                            break;
                        default:
                            InterfaceC0950f interfaceC0950f16 = interfaceC0950f;
                            kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            kotlin.jvm.internal.j.c(obj32, "null cannot be cast to non-null type kotlin.String");
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            kotlin.jvm.internal.j.c(obj33, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            kotlin.jvm.internal.j.c(obj34, "null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions");
                            try {
                                interfaceC0950f16.j(str15, dDoubleValue, (C0951g) obj34);
                                listA15 = y5.a.D(null);
                            } catch (Throwable th15) {
                                listA15 = s3.D.a(th15);
                            }
                            dVar.f(listA15);
                            break;
                    }
                }
            });
        }
    }
}
