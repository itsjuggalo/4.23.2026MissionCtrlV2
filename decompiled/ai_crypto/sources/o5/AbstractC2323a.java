package o5;

import V4.a;
import V4.o;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import o5.AbstractC2323a;

/* JADX INFO: renamed from: o5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2323a {

    /* JADX INFO: renamed from: o5.a$a, reason: collision with other inner class name */
    public static final class C0332a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f20210a;

        public static C0332a a(ArrayList arrayList) {
            C0332a c0332a = new C0332a();
            c0332a.c((Boolean) arrayList.get(0));
            return c0332a;
        }

        public Boolean b() {
            return this.f20210a;
        }

        public void c(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"showTitle\" is null.");
            }
            this.f20210a = bool;
        }

        public ArrayList d() {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.f20210a);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0332a.class != obj.getClass()) {
                return false;
            }
            return this.f20210a.equals(((C0332a) obj).f20210a);
        }

        public int hashCode() {
            return Objects.hash(this.f20210a);
        }
    }

    /* JADX INFO: renamed from: o5.a$b */
    public static class b extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f20211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f20212b;

        public b(String str, String str2, Object obj) {
            super(str2);
            this.f20211a = str;
            this.f20212b = obj;
        }
    }

    /* JADX INFO: renamed from: o5.a$c */
    public static class c extends o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f20213d = new c();

        @Override // V4.o
        public Object g(byte b7, ByteBuffer byteBuffer) {
            return b7 != -127 ? b7 != -126 ? super.g(b7, byteBuffer) : C0332a.a((ArrayList) f(byteBuffer)) : e.a((ArrayList) f(byteBuffer));
        }

        @Override // V4.o
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof e) {
                byteArrayOutputStream.write(129);
                p(byteArrayOutputStream, ((e) obj).h());
            } else if (!(obj instanceof C0332a)) {
                super.p(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(130);
                p(byteArrayOutputStream, ((C0332a) obj).d());
            }
        }
    }

    /* JADX INFO: renamed from: o5.a$d */
    public interface d {
        static V4.h a() {
            return c.f20213d;
        }

        static void b(V4.b bVar, String str, final d dVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            V4.a aVar = new V4.a(bVar, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.canLaunchUrl" + str2, a());
            if (dVar != null) {
                aVar.e(new a.d() { // from class: o5.b
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2323a.d.d(this.f20217a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.launchUrl" + str2, a());
            if (dVar != null) {
                aVar2.e(new a.d() { // from class: o5.c
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2323a.d.g(this.f20218a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(bVar, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.openUrlInApp" + str2, a());
            if (dVar != null) {
                aVar3.e(new a.d() { // from class: o5.d
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2323a.d.i(this.f20219a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            V4.a aVar4 = new V4.a(bVar, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.supportsCustomTabs" + str2, a());
            if (dVar != null) {
                aVar4.e(new a.d() { // from class: o5.e
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2323a.d.l(this.f20220a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            V4.a aVar5 = new V4.a(bVar, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.closeWebView" + str2, a());
            if (dVar != null) {
                aVar5.e(new a.d() { // from class: o5.f
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2323a.d.n(this.f20221a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
        }

        static /* synthetic */ void d(d dVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, dVar.c((String) ((ArrayList) obj).get(0)));
            } catch (Throwable th) {
                arrayList = AbstractC2323a.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void g(d dVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, dVar.q((String) arrayList2.get(0), (Map) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = AbstractC2323a.a(th);
            }
            eVar.a(arrayList);
        }

        static void h(V4.b bVar, d dVar) {
            b(bVar, "", dVar);
        }

        static /* synthetic */ void i(d dVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, dVar.o((String) arrayList2.get(0), (Boolean) arrayList2.get(1), (e) arrayList2.get(2), (C0332a) arrayList2.get(3)));
            } catch (Throwable th) {
                arrayList = AbstractC2323a.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void l(d dVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, dVar.j());
            } catch (Throwable th) {
                arrayList = AbstractC2323a.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void n(d dVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                dVar.p();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = AbstractC2323a.a(th);
            }
            eVar.a(arrayList);
        }

        Boolean c(String str);

        Boolean j();

        Boolean o(String str, Boolean bool, e eVar, C0332a c0332a);

        void p();

        Boolean q(String str, Map map);
    }

    /* JADX INFO: renamed from: o5.a$e */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f20214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Boolean f20215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map f20216c;

        public static e a(ArrayList arrayList) {
            e eVar = new e();
            eVar.f((Boolean) arrayList.get(0));
            eVar.e((Boolean) arrayList.get(1));
            eVar.g((Map) arrayList.get(2));
            return eVar;
        }

        public Boolean b() {
            return this.f20215b;
        }

        public Boolean c() {
            return this.f20214a;
        }

        public Map d() {
            return this.f20216c;
        }

        public void e(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"enableDomStorage\" is null.");
            }
            this.f20215b = bool;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f20214a.equals(eVar.f20214a) && this.f20215b.equals(eVar.f20215b) && this.f20216c.equals(eVar.f20216c);
        }

        public void f(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"enableJavaScript\" is null.");
            }
            this.f20214a = bool;
        }

        public void g(Map map) {
            if (map == null) {
                throw new IllegalStateException("Nonnull field \"headers\" is null.");
            }
            this.f20216c = map;
        }

        public ArrayList h() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f20214a);
            arrayList.add(this.f20215b);
            arrayList.add(this.f20216c);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(this.f20214a, this.f20215b, this.f20216c);
        }
    }

    public static ArrayList a(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        if (th instanceof b) {
            b bVar = (b) th;
            arrayList.add(bVar.f20211a);
            arrayList.add(bVar.getMessage());
            arrayList.add(bVar.f20212b);
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        }
        return arrayList;
    }
}
