package l5;

import V4.a;
import V4.b;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import l5.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f18462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f18463b;

        /* JADX INFO: renamed from: l5.q$a$a, reason: collision with other inner class name */
        public static final class C0304a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f18464a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f18465b;

            public a a() {
                a aVar = new a();
                aVar.b(this.f18464a);
                aVar.c(this.f18465b);
                return aVar;
            }

            public C0304a b(String str) {
                this.f18464a = str;
                return this;
            }

            public C0304a c(String str) {
                this.f18465b = str;
                return this;
            }
        }

        public static a a(ArrayList arrayList) {
            a aVar = new a();
            aVar.b((String) arrayList.get(0));
            aVar.c((String) arrayList.get(1));
            return aVar;
        }

        public void b(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"code\" is null.");
            }
            this.f18462a = str;
        }

        public void c(String str) {
            this.f18463b = str;
        }

        public ArrayList d() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f18462a);
            arrayList.add(this.f18463b);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f18462a.equals(aVar.f18462a) && Objects.equals(this.f18463b, aVar.f18463b);
        }

        public int hashCode() {
            return Objects.hash(this.f18462a, this.f18463b);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f18466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f18467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f18468c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public c f18469a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public a f18470b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public List f18471c;

            public b a() {
                b bVar = new b();
                bVar.d(this.f18469a);
                bVar.b(this.f18470b);
                bVar.c(this.f18471c);
                return bVar;
            }

            public a b(a aVar) {
                this.f18470b = aVar;
                return this;
            }

            public a c(List list) {
                this.f18471c = list;
                return this;
            }

            public a d(c cVar) {
                this.f18469a = cVar;
                return this;
            }
        }

        public static b a(ArrayList arrayList) {
            b bVar = new b();
            bVar.d((c) arrayList.get(0));
            bVar.b((a) arrayList.get(1));
            bVar.c((List) arrayList.get(2));
            return bVar;
        }

        public void b(a aVar) {
            this.f18467b = aVar;
        }

        public void c(List list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"paths\" is null.");
            }
            this.f18468c = list;
        }

        public void d(c cVar) {
            if (cVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f18466a = cVar;
        }

        public ArrayList e() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f18466a);
            arrayList.add(this.f18467b);
            arrayList.add(this.f18468c);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f18466a.equals(bVar.f18466a) && Objects.equals(this.f18467b, bVar.f18467b) && this.f18468c.equals(bVar.f18468c);
        }

        public int hashCode() {
            return Objects.hash(this.f18466a, this.f18467b, this.f18468c);
        }
    }

    public enum c {
        IMAGE(0),
        VIDEO(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18475a;

        c(int i7) {
            this.f18475a = i7;
        }
    }

    public static class d extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f18477b;

        public d(String str, String str2, Object obj) {
            super(str2);
            this.f18476a = str;
            this.f18477b = obj;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f18478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Boolean f18479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f18480c;

        public static e a(ArrayList arrayList) {
            e eVar = new e();
            eVar.e((Boolean) arrayList.get(0));
            eVar.g((Boolean) arrayList.get(1));
            eVar.f((Long) arrayList.get(2));
            return eVar;
        }

        public Boolean b() {
            return this.f18478a;
        }

        public Long c() {
            return this.f18480c;
        }

        public Boolean d() {
            return this.f18479b;
        }

        public void e(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"allowMultiple\" is null.");
            }
            this.f18478a = bool;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f18478a.equals(eVar.f18478a) && this.f18479b.equals(eVar.f18479b) && Objects.equals(this.f18480c, eVar.f18480c);
        }

        public void f(Long l7) {
            this.f18480c = l7;
        }

        public void g(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"usePhotoPicker\" is null.");
            }
            this.f18479b = bool;
        }

        public ArrayList h() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f18478a);
            arrayList.add(this.f18479b);
            arrayList.add(this.f18480c);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(this.f18478a, this.f18479b, this.f18480c);
        }
    }

    public interface f {

        public class a implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f18481a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f18482b;

            public a(ArrayList arrayList, a.e eVar) {
                this.f18481a = arrayList;
                this.f18482b = eVar;
            }

            @Override // l5.q.j
            public void b(Throwable th) {
                this.f18482b.a(q.a(th));
            }

            @Override // l5.q.j
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(List list) {
                this.f18481a.add(0, list);
                this.f18482b.a(this.f18481a);
            }
        }

        public class b implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f18483a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f18484b;

            public b(ArrayList arrayList, a.e eVar) {
                this.f18483a = arrayList;
                this.f18484b = eVar;
            }

            @Override // l5.q.j
            public void b(Throwable th) {
                this.f18484b.a(q.a(th));
            }

            @Override // l5.q.j
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(List list) {
                this.f18483a.add(0, list);
                this.f18484b.a(this.f18483a);
            }
        }

        public class c implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f18485a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f18486b;

            public c(ArrayList arrayList, a.e eVar) {
                this.f18485a = arrayList;
                this.f18486b = eVar;
            }

            @Override // l5.q.j
            public void b(Throwable th) {
                this.f18486b.a(q.a(th));
            }

            @Override // l5.q.j
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(List list) {
                this.f18485a.add(0, list);
                this.f18486b.a(this.f18485a);
            }
        }

        static V4.h a() {
            return i.f18491d;
        }

        static void e(V4.b bVar, f fVar) {
            i(bVar, "", fVar);
        }

        static /* synthetic */ void h(f fVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            fVar.n((l) arrayList.get(0), (g) arrayList.get(1), (e) arrayList.get(2), new a(new ArrayList(), eVar));
        }

        static void i(V4.b bVar, String str, final f fVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            b.c cVarC = bVar.c();
            V4.a aVar = new V4.a(bVar, "dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickImages" + str2, a(), cVarC);
            if (fVar != null) {
                aVar.e(new a.d() { // from class: l5.r
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        q.f.h(this.f18503a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickVideos" + str2, a(), cVarC);
            if (fVar != null) {
                aVar2.e(new a.d() { // from class: l5.s
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        q.f.j(this.f18504a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(bVar, "dev.flutter.pigeon.image_picker_android.ImagePickerApi.pickMedia" + str2, a());
            if (fVar != null) {
                aVar3.e(new a.d() { // from class: l5.t
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        q.f.m(this.f18505a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            V4.a aVar4 = new V4.a(bVar, "dev.flutter.pigeon.image_picker_android.ImagePickerApi.retrieveLostResults" + str2, a(), cVarC);
            if (fVar != null) {
                aVar4.e(new a.d() { // from class: l5.u
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        q.f.k(this.f18506a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
        }

        static /* synthetic */ void j(f fVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            fVar.d((l) arrayList.get(0), (n) arrayList.get(1), (e) arrayList.get(2), new b(new ArrayList(), eVar));
        }

        static /* synthetic */ void k(f fVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(0, fVar.f());
            } catch (Throwable th) {
                arrayList = q.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void m(f fVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            fVar.b((h) arrayList.get(0), (e) arrayList.get(1), new c(new ArrayList(), eVar));
        }

        void b(h hVar, e eVar, j jVar);

        void d(l lVar, n nVar, e eVar, j jVar);

        b f();

        void n(l lVar, g gVar, e eVar, j jVar);
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f18487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f18488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f18489c;

        public static g a(ArrayList arrayList) {
            g gVar = new g();
            gVar.f((Double) arrayList.get(0));
            gVar.e((Double) arrayList.get(1));
            gVar.g((Long) arrayList.get(2));
            return gVar;
        }

        public Double b() {
            return this.f18488b;
        }

        public Double c() {
            return this.f18487a;
        }

        public Long d() {
            return this.f18489c;
        }

        public void e(Double d7) {
            this.f18488b = d7;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || g.class != obj.getClass()) {
                return false;
            }
            g gVar = (g) obj;
            return Objects.equals(this.f18487a, gVar.f18487a) && Objects.equals(this.f18488b, gVar.f18488b) && this.f18489c.equals(gVar.f18489c);
        }

        public void f(Double d7) {
            this.f18487a = d7;
        }

        public void g(Long l7) {
            if (l7 == null) {
                throw new IllegalStateException("Nonnull field \"quality\" is null.");
            }
            this.f18489c = l7;
        }

        public ArrayList h() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f18487a);
            arrayList.add(this.f18488b);
            arrayList.add(this.f18489c);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(this.f18487a, this.f18488b, this.f18489c);
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f18490a;

        public static h a(ArrayList arrayList) {
            h hVar = new h();
            hVar.c((g) arrayList.get(0));
            return hVar;
        }

        public g b() {
            return this.f18490a;
        }

        public void c(g gVar) {
            if (gVar == null) {
                throw new IllegalStateException("Nonnull field \"imageSelectionOptions\" is null.");
            }
            this.f18490a = gVar;
        }

        public ArrayList d() {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.f18490a);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || h.class != obj.getClass()) {
                return false;
            }
            return this.f18490a.equals(((h) obj).f18490a);
        }

        public int hashCode() {
            return Objects.hash(this.f18490a);
        }
    }

    public static class i extends V4.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final i f18491d = new i();

        @Override // V4.o
        public Object g(byte b7, ByteBuffer byteBuffer) {
            switch (b7) {
                case -127:
                    Object objF = f(byteBuffer);
                    if (objF == null) {
                        return null;
                    }
                    return k.values()[((Long) objF).intValue()];
                case -126:
                    Object objF2 = f(byteBuffer);
                    if (objF2 == null) {
                        return null;
                    }
                    return m.values()[((Long) objF2).intValue()];
                case -125:
                    Object objF3 = f(byteBuffer);
                    if (objF3 == null) {
                        return null;
                    }
                    return c.values()[((Long) objF3).intValue()];
                case -124:
                    return e.a((ArrayList) f(byteBuffer));
                case -123:
                    return g.a((ArrayList) f(byteBuffer));
                case -122:
                    return h.a((ArrayList) f(byteBuffer));
                case -121:
                    return n.a((ArrayList) f(byteBuffer));
                case -120:
                    return l.a((ArrayList) f(byteBuffer));
                case -119:
                    return a.a((ArrayList) f(byteBuffer));
                case -118:
                    return b.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b7, byteBuffer);
            }
        }

        @Override // V4.o
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof k) {
                byteArrayOutputStream.write(129);
                p(byteArrayOutputStream, obj != null ? Integer.valueOf(((k) obj).f18495a) : null);
                return;
            }
            if (obj instanceof m) {
                byteArrayOutputStream.write(130);
                p(byteArrayOutputStream, obj != null ? Integer.valueOf(((m) obj).f18501a) : null);
                return;
            }
            if (obj instanceof c) {
                byteArrayOutputStream.write(131);
                p(byteArrayOutputStream, obj != null ? Integer.valueOf(((c) obj).f18475a) : null);
                return;
            }
            if (obj instanceof e) {
                byteArrayOutputStream.write(132);
                p(byteArrayOutputStream, ((e) obj).h());
                return;
            }
            if (obj instanceof g) {
                byteArrayOutputStream.write(133);
                p(byteArrayOutputStream, ((g) obj).h());
                return;
            }
            if (obj instanceof h) {
                byteArrayOutputStream.write(134);
                p(byteArrayOutputStream, ((h) obj).d());
                return;
            }
            if (obj instanceof n) {
                byteArrayOutputStream.write(135);
                p(byteArrayOutputStream, ((n) obj).d());
                return;
            }
            if (obj instanceof l) {
                byteArrayOutputStream.write(136);
                p(byteArrayOutputStream, ((l) obj).f());
            } else if (obj instanceof a) {
                byteArrayOutputStream.write(137);
                p(byteArrayOutputStream, ((a) obj).d());
            } else if (!(obj instanceof b)) {
                super.p(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(138);
                p(byteArrayOutputStream, ((b) obj).e());
            }
        }
    }

    public interface j {
        void a(Object obj);

        void b(Throwable th);
    }

    public enum k {
        REAR(0),
        FRONT(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18495a;

        k(int i7) {
            this.f18495a = i7;
        }
    }

    public static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f18496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public k f18497b;

        public static l a(ArrayList arrayList) {
            l lVar = new l();
            lVar.e((m) arrayList.get(0));
            lVar.d((k) arrayList.get(1));
            return lVar;
        }

        public k b() {
            return this.f18497b;
        }

        public m c() {
            return this.f18496a;
        }

        public void d(k kVar) {
            this.f18497b = kVar;
        }

        public void e(m mVar) {
            if (mVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f18496a = mVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || l.class != obj.getClass()) {
                return false;
            }
            l lVar = (l) obj;
            return this.f18496a.equals(lVar.f18496a) && Objects.equals(this.f18497b, lVar.f18497b);
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f18496a);
            arrayList.add(this.f18497b);
            return arrayList;
        }

        public int hashCode() {
            return Objects.hash(this.f18496a, this.f18497b);
        }
    }

    public enum m {
        CAMERA(0),
        GALLERY(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18501a;

        m(int i7) {
            this.f18501a = i7;
        }
    }

    public static final class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f18502a;

        public static n a(ArrayList arrayList) {
            n nVar = new n();
            nVar.c((Long) arrayList.get(0));
            return nVar;
        }

        public Long b() {
            return this.f18502a;
        }

        public void c(Long l7) {
            this.f18502a = l7;
        }

        public ArrayList d() {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.f18502a);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || n.class != obj.getClass()) {
                return false;
            }
            return Objects.equals(this.f18502a, ((n) obj).f18502a);
        }

        public int hashCode() {
            return Objects.hash(this.f18502a);
        }
    }

    public static ArrayList a(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        if (th instanceof d) {
            d dVar = (d) th;
            arrayList.add(dVar.f18476a);
            arrayList.add(dVar.getMessage());
            arrayList.add(dVar.f18477b);
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        }
        return arrayList;
    }
}
