package n5;

import V4.a;
import V4.b;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import n5.AbstractC2268c;

/* JADX INFO: renamed from: n5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2268c {

    /* JADX INFO: renamed from: n5.c$a */
    public static class a extends V4.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f19860d = new a();

        @Override // V4.o
        public Object g(byte b7, ByteBuffer byteBuffer) {
            return super.g(b7, byteBuffer);
        }

        @Override // V4.o
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            super.p(byteArrayOutputStream, obj);
        }
    }

    /* JADX INFO: renamed from: n5.c$b */
    public interface b {
        static void A(V4.b bVar, String str, final b bVar2) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            b.c cVarC = bVar.c();
            V4.a aVar = new V4.a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.remove" + str2, a(), cVarC);
            if (bVar2 != null) {
                aVar.e(new a.d() { // from class: n5.d
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2268c.b.B(this.f19861a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setBool" + str2, a(), cVarC);
            if (bVar2 != null) {
                aVar2.e(new a.d() { // from class: n5.e
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2268c.b.i(this.f19862a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setString" + str2, a(), cVarC);
            if (bVar2 != null) {
                aVar3.e(new a.d() { // from class: n5.f
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2268c.b.c(this.f19863a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            V4.a aVar4 = new V4.a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setInt" + str2, a(), cVarC);
            if (bVar2 != null) {
                aVar4.e(new a.d() { // from class: n5.g
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2268c.b.k(this.f19864a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            V4.a aVar5 = new V4.a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setDouble" + str2, a(), cVarC);
            if (bVar2 != null) {
                aVar5.e(new a.d() { // from class: n5.h
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2268c.b.j(this.f19865a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
            V4.a aVar6 = new V4.a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setEncodedStringList" + str2, a(), cVarC);
            if (bVar2 != null) {
                aVar6.e(new a.d() { // from class: n5.i
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2268c.b.p(this.f19866a, obj, eVar);
                    }
                });
            } else {
                aVar6.e(null);
            }
            V4.a aVar7 = new V4.a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setDeprecatedStringList" + str2, a(), cVarC);
            if (bVar2 != null) {
                aVar7.e(new a.d() { // from class: n5.j
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2268c.b.n(this.f19867a, obj, eVar);
                    }
                });
            } else {
                aVar7.e(null);
            }
            V4.a aVar8 = new V4.a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.clear" + str2, a(), cVarC);
            if (bVar2 != null) {
                aVar8.e(new a.d() { // from class: n5.k
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2268c.b.C(this.f19868a, obj, eVar);
                    }
                });
            } else {
                aVar8.e(null);
            }
            V4.a aVar9 = new V4.a(bVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.getAll" + str2, a(), cVarC);
            if (bVar2 != null) {
                aVar9.e(new a.d() { // from class: n5.l
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2268c.b.y(this.f19869a, obj, eVar);
                    }
                });
            } else {
                aVar9.e(null);
            }
        }

        static /* synthetic */ void B(b bVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, bVar.remove((String) ((ArrayList) obj).get(0)));
            } catch (Throwable th) {
                arrayList = AbstractC2268c.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void C(b bVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.g((String) arrayList2.get(0), (List) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = AbstractC2268c.a(th);
            }
            eVar.a(arrayList);
        }

        static V4.h a() {
            return a.f19860d;
        }

        static void b(V4.b bVar, b bVar2) {
            A(bVar, "", bVar2);
        }

        static /* synthetic */ void c(b bVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.r((String) arrayList2.get(0), (String) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = AbstractC2268c.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void i(b bVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.w((String) arrayList2.get(0), (Boolean) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = AbstractC2268c.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void j(b bVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.x((String) arrayList2.get(0), (Double) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = AbstractC2268c.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void k(b bVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.o((String) arrayList2.get(0), (Long) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = AbstractC2268c.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void n(b bVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.t((String) arrayList2.get(0), (List) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = AbstractC2268c.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void p(b bVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.s((String) arrayList2.get(0), (String) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = AbstractC2268c.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void y(b bVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.d((String) arrayList2.get(0), (List) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = AbstractC2268c.a(th);
            }
            eVar.a(arrayList);
        }

        Map d(String str, List list);

        Boolean g(String str, List list);

        Boolean o(String str, Long l7);

        Boolean r(String str, String str2);

        Boolean remove(String str);

        Boolean s(String str, String str2);

        Boolean t(String str, List list);

        Boolean w(String str, Boolean bool);

        Boolean x(String str, Double d7);
    }

    public static ArrayList a(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(th.toString());
        arrayList.add(th.getClass().getSimpleName());
        arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return arrayList;
    }
}
