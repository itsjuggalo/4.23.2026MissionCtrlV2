package k5;

import V4.a;
import V4.b;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k5.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    public static class a extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f18168b;

        public a(String str, String str2, Object obj) {
            super(str2);
            this.f18167a = str;
            this.f18168b = obj;
        }
    }

    public interface b {

        public class a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f18169a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f18170b;

            public a(ArrayList arrayList, a.e eVar) {
                this.f18169a = arrayList;
                this.f18170b = eVar;
            }

            @Override // k5.g.e
            public void b(Throwable th) {
                this.f18170b.a(g.a(th));
            }

            @Override // k5.g.e
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(C0297g c0297g) {
                this.f18169a.add(0, c0297g);
                this.f18170b.a(this.f18169a);
            }
        }

        /* JADX INFO: renamed from: k5.g$b$b, reason: collision with other inner class name */
        public class C0296b implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f18171a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f18172b;

            public C0296b(ArrayList arrayList, a.e eVar) {
                this.f18171a = arrayList;
                this.f18172b = eVar;
            }

            @Override // k5.g.e
            public void b(Throwable th) {
                this.f18172b.a(g.a(th));
            }

            @Override // k5.g.e
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(C0297g c0297g) {
                this.f18171a.add(0, c0297g);
                this.f18172b.a(this.f18171a);
            }
        }

        public class c implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f18173a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f18174b;

            public c(ArrayList arrayList, a.e eVar) {
                this.f18173a = arrayList;
                this.f18174b = eVar;
            }

            @Override // k5.g.e
            public void b(Throwable th) {
                this.f18174b.a(g.a(th));
            }

            @Override // k5.g.e
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f18173a.add(0, str);
                this.f18174b.a(this.f18173a);
            }
        }

        public class d implements h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f18175a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f18176b;

            public d(ArrayList arrayList, a.e eVar) {
                this.f18175a = arrayList;
                this.f18176b = eVar;
            }

            @Override // k5.g.h
            public void a() {
                this.f18175a.add(0, null);
                this.f18176b.a(this.f18175a);
            }

            @Override // k5.g.h
            public void b(Throwable th) {
                this.f18176b.a(g.a(th));
            }
        }

        public class e implements h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f18177a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f18178b;

            public e(ArrayList arrayList, a.e eVar) {
                this.f18177a = arrayList;
                this.f18178b = eVar;
            }

            @Override // k5.g.h
            public void a() {
                this.f18177a.add(0, null);
                this.f18178b.a(this.f18177a);
            }

            @Override // k5.g.h
            public void b(Throwable th) {
                this.f18178b.a(g.a(th));
            }
        }

        public class f implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f18179a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f18180b;

            public f(ArrayList arrayList, a.e eVar) {
                this.f18179a = arrayList;
                this.f18180b = eVar;
            }

            @Override // k5.g.e
            public void b(Throwable th) {
                this.f18180b.a(g.a(th));
            }

            @Override // k5.g.e
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Boolean bool) {
                this.f18179a.add(0, bool);
                this.f18180b.a(this.f18179a);
            }
        }

        static /* synthetic */ void B(b bVar, Object obj, a.e eVar) {
            bVar.n(new e(new ArrayList(), eVar));
        }

        static V4.h a() {
            return d.f18188d;
        }

        static /* synthetic */ void b(b bVar, Object obj, a.e eVar) {
            bVar.y(new d(new ArrayList(), eVar));
        }

        static /* synthetic */ void c(b bVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            bVar.f((String) arrayList.get(0), (Boolean) arrayList.get(1), new c(new ArrayList(), eVar));
        }

        static void d(V4.b bVar, String str, final b bVar2) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            b.c cVarC = bVar.c();
            V4.a aVar = new V4.a(bVar, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.init" + str2, a());
            if (bVar2 != null) {
                aVar.e(new a.d() { // from class: k5.h
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        g.b.o(this.f18205a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.signInSilently" + str2, a());
            if (bVar2 != null) {
                aVar2.e(new a.d() { // from class: k5.i
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        g.b.j(this.f18206a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(bVar, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.signIn" + str2, a());
            if (bVar2 != null) {
                aVar3.e(new a.d() { // from class: k5.j
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        g.b.h(this.f18207a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            V4.a aVar4 = new V4.a(bVar, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.getAccessToken" + str2, a(), cVarC);
            if (bVar2 != null) {
                aVar4.e(new a.d() { // from class: k5.k
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        g.b.c(this.f18208a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            V4.a aVar5 = new V4.a(bVar, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.signOut" + str2, a());
            if (bVar2 != null) {
                aVar5.e(new a.d() { // from class: k5.l
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        g.b.b(this.f18209a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
            V4.a aVar6 = new V4.a(bVar, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.disconnect" + str2, a());
            if (bVar2 != null) {
                aVar6.e(new a.d() { // from class: k5.m
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        g.b.B(this.f18210a, obj, eVar);
                    }
                });
            } else {
                aVar6.e(null);
            }
            V4.a aVar7 = new V4.a(bVar, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.isSignedIn" + str2, a());
            if (bVar2 != null) {
                aVar7.e(new a.d() { // from class: k5.n
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        g.b.w(this.f18211a, obj, eVar);
                    }
                });
            } else {
                aVar7.e(null);
            }
            V4.a aVar8 = new V4.a(bVar, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.clearAuthCache" + str2, a(), cVarC);
            if (bVar2 != null) {
                aVar8.e(new a.d() { // from class: k5.o
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        g.b.s(this.f18212a, obj, eVar);
                    }
                });
            } else {
                aVar8.e(null);
            }
            V4.a aVar9 = new V4.a(bVar, "dev.flutter.pigeon.google_sign_in_android.GoogleSignInApi.requestScopes" + str2, a());
            if (bVar2 != null) {
                aVar9.e(new a.d() { // from class: k5.p
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        g.b.q(this.f18213a, obj, eVar);
                    }
                });
            } else {
                aVar9.e(null);
            }
        }

        static /* synthetic */ void h(b bVar, Object obj, a.e eVar) {
            bVar.i(new C0296b(new ArrayList(), eVar));
        }

        static /* synthetic */ void j(b bVar, Object obj, a.e eVar) {
            bVar.A(new a(new ArrayList(), eVar));
        }

        static /* synthetic */ void o(b bVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                bVar.p((c) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = g.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void q(b bVar, Object obj, a.e eVar) {
            bVar.r((List) ((ArrayList) obj).get(0), new f(new ArrayList(), eVar));
        }

        static /* synthetic */ void s(b bVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                bVar.D((String) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = g.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void w(b bVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, bVar.m());
            } catch (Throwable th) {
                arrayList = g.a(th);
            }
            eVar.a(arrayList);
        }

        static void x(V4.b bVar, b bVar2) {
            d(bVar, "", bVar2);
        }

        void A(e eVar);

        void D(String str);

        void f(String str, Boolean bool, e eVar);

        void i(e eVar);

        Boolean m();

        void n(h hVar);

        void p(c cVar);

        void r(List list, e eVar);

        void y(h hVar);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f18181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f f18182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f18183c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f18184d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f18185e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f18186f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f18187g;

        public static c a(ArrayList arrayList) {
            c cVar = new c();
            cVar.m((List) arrayList.get(0));
            cVar.o((f) arrayList.get(1));
            cVar.l((String) arrayList.get(2));
            cVar.i((String) arrayList.get(3));
            cVar.n((String) arrayList.get(4));
            cVar.k((Boolean) arrayList.get(5));
            cVar.j((String) arrayList.get(6));
            return cVar;
        }

        public String b() {
            return this.f18184d;
        }

        public String c() {
            return this.f18187g;
        }

        public Boolean d() {
            return this.f18186f;
        }

        public String e() {
            return this.f18183c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f18181a.equals(cVar.f18181a) && this.f18182b.equals(cVar.f18182b) && Objects.equals(this.f18183c, cVar.f18183c) && Objects.equals(this.f18184d, cVar.f18184d) && Objects.equals(this.f18185e, cVar.f18185e) && this.f18186f.equals(cVar.f18186f) && Objects.equals(this.f18187g, cVar.f18187g);
        }

        public List f() {
            return this.f18181a;
        }

        public String g() {
            return this.f18185e;
        }

        public f h() {
            return this.f18182b;
        }

        public int hashCode() {
            return Objects.hash(this.f18181a, this.f18182b, this.f18183c, this.f18184d, this.f18185e, this.f18186f, this.f18187g);
        }

        public void i(String str) {
            this.f18184d = str;
        }

        public void j(String str) {
            this.f18187g = str;
        }

        public void k(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"forceCodeForRefreshToken\" is null.");
            }
            this.f18186f = bool;
        }

        public void l(String str) {
            this.f18183c = str;
        }

        public void m(List list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"scopes\" is null.");
            }
            this.f18181a = list;
        }

        public void n(String str) {
            this.f18185e = str;
        }

        public void o(f fVar) {
            if (fVar == null) {
                throw new IllegalStateException("Nonnull field \"signInType\" is null.");
            }
            this.f18182b = fVar;
        }

        public ArrayList p() {
            ArrayList arrayList = new ArrayList(7);
            arrayList.add(this.f18181a);
            arrayList.add(this.f18182b);
            arrayList.add(this.f18183c);
            arrayList.add(this.f18184d);
            arrayList.add(this.f18185e);
            arrayList.add(this.f18186f);
            arrayList.add(this.f18187g);
            return arrayList;
        }
    }

    public static class d extends V4.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f18188d = new d();

        @Override // V4.o
        public Object g(byte b7, ByteBuffer byteBuffer) {
            switch (b7) {
                case -127:
                    Object objF = f(byteBuffer);
                    if (objF == null) {
                        return null;
                    }
                    return f.values()[((Long) objF).intValue()];
                case -126:
                    return c.a((ArrayList) f(byteBuffer));
                case -125:
                    return C0297g.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b7, byteBuffer);
            }
        }

        @Override // V4.o
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof f) {
                byteArrayOutputStream.write(129);
                p(byteArrayOutputStream, obj == null ? null : Integer.valueOf(((f) obj).f18192a));
            } else if (obj instanceof c) {
                byteArrayOutputStream.write(130);
                p(byteArrayOutputStream, ((c) obj).p());
            } else if (!(obj instanceof C0297g)) {
                super.p(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(131);
                p(byteArrayOutputStream, ((C0297g) obj).h());
            }
        }
    }

    public interface e {
        void a(Object obj);

        void b(Throwable th);
    }

    public enum f {
        STANDARD(0),
        GAMES(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18192a;

        f(int i7) {
            this.f18192a = i7;
        }
    }

    /* JADX INFO: renamed from: k5.g$g, reason: collision with other inner class name */
    public static final class C0297g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f18193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f18194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f18195c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f18196d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f18197e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f18198f;

        /* JADX INFO: renamed from: k5.g$g$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f18199a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f18200b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f18201c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f18202d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f18203e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public String f18204f;

            public C0297g a() {
                C0297g c0297g = new C0297g();
                c0297g.b(this.f18199a);
                c0297g.c(this.f18200b);
                c0297g.d(this.f18201c);
                c0297g.f(this.f18202d);
                c0297g.e(this.f18203e);
                c0297g.g(this.f18204f);
                return c0297g;
            }

            public a b(String str) {
                this.f18199a = str;
                return this;
            }

            public a c(String str) {
                this.f18200b = str;
                return this;
            }

            public a d(String str) {
                this.f18201c = str;
                return this;
            }

            public a e(String str) {
                this.f18203e = str;
                return this;
            }

            public a f(String str) {
                this.f18202d = str;
                return this;
            }

            public a g(String str) {
                this.f18204f = str;
                return this;
            }
        }

        public static C0297g a(ArrayList arrayList) {
            C0297g c0297g = new C0297g();
            c0297g.b((String) arrayList.get(0));
            c0297g.c((String) arrayList.get(1));
            c0297g.d((String) arrayList.get(2));
            c0297g.f((String) arrayList.get(3));
            c0297g.e((String) arrayList.get(4));
            c0297g.g((String) arrayList.get(5));
            return c0297g;
        }

        public void b(String str) {
            this.f18193a = str;
        }

        public void c(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"email\" is null.");
            }
            this.f18194b = str;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"id\" is null.");
            }
            this.f18195c = str;
        }

        public void e(String str) {
            this.f18197e = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0297g.class != obj.getClass()) {
                return false;
            }
            C0297g c0297g = (C0297g) obj;
            return Objects.equals(this.f18193a, c0297g.f18193a) && this.f18194b.equals(c0297g.f18194b) && this.f18195c.equals(c0297g.f18195c) && Objects.equals(this.f18196d, c0297g.f18196d) && Objects.equals(this.f18197e, c0297g.f18197e) && Objects.equals(this.f18198f, c0297g.f18198f);
        }

        public void f(String str) {
            this.f18196d = str;
        }

        public void g(String str) {
            this.f18198f = str;
        }

        public ArrayList h() {
            ArrayList arrayList = new ArrayList(6);
            arrayList.add(this.f18193a);
            arrayList.add(this.f18194b);
            arrayList.add(this.f18195c);
            arrayList.add(this.f18196d);
            arrayList.add(this.f18197e);
            arrayList.add(this.f18198f);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(this.f18193a, this.f18194b, this.f18195c, this.f18196d, this.f18197e, this.f18198f);
        }
    }

    public interface h {
        void a();

        void b(Throwable th);
    }

    public static ArrayList a(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        if (th instanceof a) {
            a aVar = (a) th;
            arrayList.add(aVar.f18167a);
            arrayList.add(aVar.getMessage());
            arrayList.add(aVar.f18168b);
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        }
        return arrayList;
    }
}
