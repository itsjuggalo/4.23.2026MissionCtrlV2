package c5;

import V4.a;
import android.util.Log;
import c5.m;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f9444c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f9445d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f9446e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f9447f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f9448g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f9449h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f9450i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f9451j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f9452k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f9453l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f9454m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f9455n;

        /* JADX INFO: renamed from: c5.m$a$a, reason: collision with other inner class name */
        public static final class C0161a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f9456a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f9457b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f9458c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f9459d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f9460e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public String f9461f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public String f9462g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f9463h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public String f9464i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public String f9465j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public String f9466k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public String f9467l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public String f9468m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public String f9469n;

            public a a() {
                a aVar = new a();
                aVar.k(this.f9456a);
                aVar.m(this.f9457b);
                aVar.t(this.f9458c);
                aVar.u(this.f9459d);
                aVar.n(this.f9460e);
                aVar.o(this.f9461f);
                aVar.v(this.f9462g);
                aVar.s(this.f9463h);
                aVar.w(this.f9464i);
                aVar.p(this.f9465j);
                aVar.j(this.f9466k);
                aVar.r(this.f9467l);
                aVar.q(this.f9468m);
                aVar.l(this.f9469n);
                return aVar;
            }

            public C0161a b(String str) {
                this.f9456a = str;
                return this;
            }

            public C0161a c(String str) {
                this.f9457b = str;
                return this;
            }

            public C0161a d(String str) {
                this.f9461f = str;
                return this;
            }

            public C0161a e(String str) {
                this.f9458c = str;
                return this;
            }

            public C0161a f(String str) {
                this.f9459d = str;
                return this;
            }

            public C0161a g(String str) {
                this.f9462g = str;
                return this;
            }

            public C0161a h(String str) {
                this.f9464i = str;
                return this;
            }
        }

        public static a a(ArrayList arrayList) {
            a aVar = new a();
            aVar.k((String) arrayList.get(0));
            aVar.m((String) arrayList.get(1));
            aVar.t((String) arrayList.get(2));
            aVar.u((String) arrayList.get(3));
            aVar.n((String) arrayList.get(4));
            aVar.o((String) arrayList.get(5));
            aVar.v((String) arrayList.get(6));
            aVar.s((String) arrayList.get(7));
            aVar.w((String) arrayList.get(8));
            aVar.p((String) arrayList.get(9));
            aVar.j((String) arrayList.get(10));
            aVar.r((String) arrayList.get(11));
            aVar.q((String) arrayList.get(12));
            aVar.l((String) arrayList.get(13));
            return aVar;
        }

        public String b() {
            return this.f9442a;
        }

        public String c() {
            return this.f9443b;
        }

        public String d() {
            return this.f9446e;
        }

        public String e() {
            return this.f9447f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9442a.equals(aVar.f9442a) && this.f9443b.equals(aVar.f9443b) && this.f9444c.equals(aVar.f9444c) && this.f9445d.equals(aVar.f9445d) && Objects.equals(this.f9446e, aVar.f9446e) && Objects.equals(this.f9447f, aVar.f9447f) && Objects.equals(this.f9448g, aVar.f9448g) && Objects.equals(this.f9449h, aVar.f9449h) && Objects.equals(this.f9450i, aVar.f9450i) && Objects.equals(this.f9451j, aVar.f9451j) && Objects.equals(this.f9452k, aVar.f9452k) && Objects.equals(this.f9453l, aVar.f9453l) && Objects.equals(this.f9454m, aVar.f9454m) && Objects.equals(this.f9455n, aVar.f9455n);
        }

        public String f() {
            return this.f9444c;
        }

        public String g() {
            return this.f9445d;
        }

        public String h() {
            return this.f9448g;
        }

        public int hashCode() {
            return Objects.hash(this.f9442a, this.f9443b, this.f9444c, this.f9445d, this.f9446e, this.f9447f, this.f9448g, this.f9449h, this.f9450i, this.f9451j, this.f9452k, this.f9453l, this.f9454m, this.f9455n);
        }

        public String i() {
            return this.f9450i;
        }

        public void j(String str) {
            this.f9452k = str;
        }

        public void k(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"apiKey\" is null.");
            }
            this.f9442a = str;
        }

        public void l(String str) {
            this.f9455n = str;
        }

        public void m(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"appId\" is null.");
            }
            this.f9443b = str;
        }

        public void n(String str) {
            this.f9446e = str;
        }

        public void o(String str) {
            this.f9447f = str;
        }

        public void p(String str) {
            this.f9451j = str;
        }

        public void q(String str) {
            this.f9454m = str;
        }

        public void r(String str) {
            this.f9453l = str;
        }

        public void s(String str) {
            this.f9449h = str;
        }

        public void t(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"messagingSenderId\" is null.");
            }
            this.f9444c = str;
        }

        public void u(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"projectId\" is null.");
            }
            this.f9445d = str;
        }

        public void v(String str) {
            this.f9448g = str;
        }

        public void w(String str) {
            this.f9450i = str;
        }

        public ArrayList x() {
            ArrayList arrayList = new ArrayList(14);
            arrayList.add(this.f9442a);
            arrayList.add(this.f9443b);
            arrayList.add(this.f9444c);
            arrayList.add(this.f9445d);
            arrayList.add(this.f9446e);
            arrayList.add(this.f9447f);
            arrayList.add(this.f9448g);
            arrayList.add(this.f9449h);
            arrayList.add(this.f9450i);
            arrayList.add(this.f9451j);
            arrayList.add(this.f9452k);
            arrayList.add(this.f9453l);
            arrayList.add(this.f9454m);
            arrayList.add(this.f9455n);
            return arrayList;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f9471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f9472c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map f9473d;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f9474a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public a f9475b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Boolean f9476c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Map f9477d;

            public b a() {
                b bVar = new b();
                bVar.c(this.f9474a);
                bVar.d(this.f9475b);
                bVar.b(this.f9476c);
                bVar.e(this.f9477d);
                return bVar;
            }

            public a b(Boolean bool) {
                this.f9476c = bool;
                return this;
            }

            public a c(String str) {
                this.f9474a = str;
                return this;
            }

            public a d(a aVar) {
                this.f9475b = aVar;
                return this;
            }

            public a e(Map map) {
                this.f9477d = map;
                return this;
            }
        }

        public static b a(ArrayList arrayList) {
            b bVar = new b();
            bVar.c((String) arrayList.get(0));
            bVar.d((a) arrayList.get(1));
            bVar.b((Boolean) arrayList.get(2));
            bVar.e((Map) arrayList.get(3));
            return bVar;
        }

        public void b(Boolean bool) {
            this.f9472c = bool;
        }

        public void c(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"name\" is null.");
            }
            this.f9470a = str;
        }

        public void d(a aVar) {
            if (aVar == null) {
                throw new IllegalStateException("Nonnull field \"options\" is null.");
            }
            this.f9471b = aVar;
        }

        public void e(Map map) {
            if (map == null) {
                throw new IllegalStateException("Nonnull field \"pluginConstants\" is null.");
            }
            this.f9473d = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f9470a.equals(bVar.f9470a) && this.f9471b.equals(bVar.f9471b) && Objects.equals(this.f9472c, bVar.f9472c) && this.f9473d.equals(bVar.f9473d);
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(this.f9470a);
            arrayList.add(this.f9471b);
            arrayList.add(this.f9472c);
            arrayList.add(this.f9473d);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(this.f9470a, this.f9471b, this.f9472c, this.f9473d);
        }
    }

    public interface c {

        public class a implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f9478a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f9479b;

            public a(ArrayList arrayList, a.e eVar) {
                this.f9478a = arrayList;
                this.f9479b = eVar;
            }

            @Override // c5.m.g
            public void a() {
                this.f9478a.add(0, null);
                this.f9479b.a(this.f9478a);
            }

            @Override // c5.m.g
            public void b(Throwable th) {
                this.f9479b.a(m.a(th));
            }
        }

        public class b implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f9480a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f9481b;

            public b(ArrayList arrayList, a.e eVar) {
                this.f9480a = arrayList;
                this.f9481b = eVar;
            }

            @Override // c5.m.g
            public void a() {
                this.f9480a.add(0, null);
                this.f9481b.a(this.f9480a);
            }

            @Override // c5.m.g
            public void b(Throwable th) {
                this.f9481b.a(m.a(th));
            }
        }

        /* JADX INFO: renamed from: c5.m$c$c, reason: collision with other inner class name */
        public class C0162c implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f9482a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f9483b;

            public C0162c(ArrayList arrayList, a.e eVar) {
                this.f9482a = arrayList;
                this.f9483b = eVar;
            }

            @Override // c5.m.g
            public void a() {
                this.f9482a.add(0, null);
                this.f9483b.a(this.f9482a);
            }

            @Override // c5.m.g
            public void b(Throwable th) {
                this.f9483b.a(m.a(th));
            }
        }

        static V4.h a() {
            return e.f9490d;
        }

        static /* synthetic */ void f(c cVar, Object obj, a.e eVar) {
            cVar.p((String) ((ArrayList) obj).get(0), new C0162c(new ArrayList(), eVar));
        }

        static /* synthetic */ void i(c cVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.r((String) arrayList.get(0), (Boolean) arrayList.get(1), new b(new ArrayList(), eVar));
        }

        static void j(V4.b bVar, c cVar) {
            w(bVar, "", cVar);
        }

        static /* synthetic */ void k(c cVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.m((String) arrayList.get(0), (Boolean) arrayList.get(1), new a(new ArrayList(), eVar));
        }

        static void w(V4.b bVar, String str, final c cVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            V4.a aVar = new V4.a(bVar, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseAppHostApi.setAutomaticDataCollectionEnabled" + str2, a());
            if (cVar != null) {
                aVar.e(new a.d() { // from class: c5.n
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        m.c.k(this.f9491a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseAppHostApi.setAutomaticResourceManagementEnabled" + str2, a());
            if (cVar != null) {
                aVar2.e(new a.d() { // from class: c5.o
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        m.c.i(this.f9492a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(bVar, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseAppHostApi.delete" + str2, a());
            if (cVar != null) {
                aVar3.e(new a.d() { // from class: c5.p
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        m.c.f(this.f9493a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
        }

        void m(String str, Boolean bool, g gVar);

        void p(String str, g gVar);

        void r(String str, Boolean bool, g gVar);
    }

    public interface d {

        public class a implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f9484a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f9485b;

            public a(ArrayList arrayList, a.e eVar) {
                this.f9484a = arrayList;
                this.f9485b = eVar;
            }

            @Override // c5.m.f
            public void b(Throwable th) {
                this.f9485b.a(m.a(th));
            }

            @Override // c5.m.f
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(b bVar) {
                this.f9484a.add(0, bVar);
                this.f9485b.a(this.f9484a);
            }
        }

        public class b implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f9486a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f9487b;

            public b(ArrayList arrayList, a.e eVar) {
                this.f9486a = arrayList;
                this.f9487b = eVar;
            }

            @Override // c5.m.f
            public void b(Throwable th) {
                this.f9487b.a(m.a(th));
            }

            @Override // c5.m.f
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(List list) {
                this.f9486a.add(0, list);
                this.f9487b.a(this.f9486a);
            }
        }

        public class c implements f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f9488a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f9489b;

            public c(ArrayList arrayList, a.e eVar) {
                this.f9488a = arrayList;
                this.f9489b = eVar;
            }

            @Override // c5.m.f
            public void b(Throwable th) {
                this.f9489b.a(m.a(th));
            }

            @Override // c5.m.f
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a aVar) {
                this.f9488a.add(0, aVar);
                this.f9489b.a(this.f9488a);
            }
        }

        static V4.h a() {
            return e.f9490d;
        }

        static void g(V4.b bVar, d dVar) {
            q(bVar, "", dVar);
        }

        static /* synthetic */ void l(d dVar, Object obj, a.e eVar) {
            dVar.e(new b(new ArrayList(), eVar));
        }

        static /* synthetic */ void n(d dVar, Object obj, a.e eVar) {
            dVar.b(new c(new ArrayList(), eVar));
        }

        static void q(V4.b bVar, String str, final d dVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            V4.a aVar = new V4.a(bVar, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseCoreHostApi.initializeApp" + str2, a());
            if (dVar != null) {
                aVar.e(new a.d() { // from class: c5.q
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        m.d.t(this.f9494a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseCoreHostApi.initializeCore" + str2, a());
            if (dVar != null) {
                aVar2.e(new a.d() { // from class: c5.r
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        m.d.l(this.f9495a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(bVar, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseCoreHostApi.optionsFromResource" + str2, a());
            if (dVar != null) {
                aVar3.e(new a.d() { // from class: c5.s
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        m.d.n(this.f9496a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
        }

        static /* synthetic */ void t(d dVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            dVar.d((String) arrayList.get(0), (a) arrayList.get(1), new a(new ArrayList(), eVar));
        }

        void b(f fVar);

        void d(String str, a aVar, f fVar);

        void e(f fVar);
    }

    public static class e extends V4.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f9490d = new e();

        @Override // V4.o
        public Object g(byte b7, ByteBuffer byteBuffer) {
            return b7 != -127 ? b7 != -126 ? super.g(b7, byteBuffer) : b.a((ArrayList) f(byteBuffer)) : a.a((ArrayList) f(byteBuffer));
        }

        @Override // V4.o
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof a) {
                byteArrayOutputStream.write(129);
                p(byteArrayOutputStream, ((a) obj).x());
            } else if (!(obj instanceof b)) {
                super.p(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(130);
                p(byteArrayOutputStream, ((b) obj).f());
            }
        }
    }

    public interface f {
        void a(Object obj);

        void b(Throwable th);
    }

    public interface g {
        void a();

        void b(Throwable th);
    }

    public static ArrayList a(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(th.toString());
        arrayList.add(th.getClass().getSimpleName());
        arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return arrayList;
    }
}
