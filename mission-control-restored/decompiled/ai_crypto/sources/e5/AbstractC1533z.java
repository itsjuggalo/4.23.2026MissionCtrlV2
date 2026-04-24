package e5;

import V4.a;
import android.util.Log;
import e5.AbstractC1533z;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: e5.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1533z {

    /* JADX INFO: renamed from: e5.z$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f13736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13737b;

        public static a a(ArrayList arrayList) {
            a aVar = new a();
            aVar.e(d.values()[((Integer) arrayList.get(0)).intValue()]);
            aVar.d((String) arrayList.get(1));
            return aVar;
        }

        public String b() {
            return this.f13737b;
        }

        public d c() {
            return this.f13736a;
        }

        public void d(String str) {
            this.f13737b = str;
        }

        public void e(d dVar) {
            if (dVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f13736a = dVar;
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(2);
            d dVar = this.f13736a;
            arrayList.add(dVar == null ? null : Integer.valueOf(dVar.f13751a));
            arrayList.add(this.f13737b);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e5.z$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f13738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Double f13740c;

        /* JADX INFO: renamed from: e5.z$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public d f13741a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f13742b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Double f13743c;

            public b a() {
                b bVar = new b();
                bVar.c(this.f13741a);
                bVar.b(this.f13742b);
                bVar.d(this.f13743c);
                return bVar;
            }

            public a b(String str) {
                this.f13742b = str;
                return this;
            }

            public a c(d dVar) {
                this.f13741a = dVar;
                return this;
            }

            public a d(Double d7) {
                this.f13743c = d7;
                return this;
            }
        }

        public static b a(ArrayList arrayList) {
            b bVar = new b();
            bVar.c(d.values()[((Integer) arrayList.get(0)).intValue()]);
            bVar.b((String) arrayList.get(1));
            bVar.d((Double) arrayList.get(2));
            return bVar;
        }

        public void b(String str) {
            this.f13739b = str;
        }

        public void c(d dVar) {
            if (dVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f13738a = dVar;
        }

        public void d(Double d7) {
            this.f13740c = d7;
        }

        public ArrayList e() {
            ArrayList arrayList = new ArrayList(3);
            d dVar = this.f13738a;
            arrayList.add(dVar == null ? null : Integer.valueOf(dVar.f13751a));
            arrayList.add(this.f13739b);
            arrayList.add(this.f13740c);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e5.z$c */
    public enum c {
        SERVER(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13746a;

        c(int i7) {
            this.f13746a = i7;
        }
    }

    /* JADX INFO: renamed from: e5.z$d */
    public enum d {
        COUNT(0),
        SUM(1),
        AVERAGE(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13751a;

        d(int i7) {
            this.f13751a = i7;
        }
    }

    /* JADX INFO: renamed from: e5.z$e */
    public enum e {
        ADDED(0),
        MODIFIED(1),
        REMOVED(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13756a;

        e(int i7) {
            this.f13756a = i7;
        }
    }

    /* JADX INFO: renamed from: e5.z$f */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f13758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public n f13759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public EnumC0237z f13760d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public y f13761e;

        public static f a(ArrayList arrayList) {
            f fVar = new f();
            fVar.i((String) arrayList.get(0));
            fVar.g((Map) arrayList.get(1));
            Object obj = arrayList.get(2);
            fVar.h(obj == null ? null : n.a((ArrayList) obj));
            Object obj2 = arrayList.get(3);
            fVar.k(obj2 == null ? null : EnumC0237z.values()[((Integer) obj2).intValue()]);
            Object obj3 = arrayList.get(4);
            fVar.j(obj3 != null ? y.values()[((Integer) obj3).intValue()] : null);
            return fVar;
        }

        public Map b() {
            return this.f13758b;
        }

        public n c() {
            return this.f13759c;
        }

        public String d() {
            return this.f13757a;
        }

        public y e() {
            return this.f13761e;
        }

        public EnumC0237z f() {
            return this.f13760d;
        }

        public void g(Map map) {
            this.f13758b = map;
        }

        public void h(n nVar) {
            this.f13759c = nVar;
        }

        public void i(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"path\" is null.");
            }
            this.f13757a = str;
        }

        public void j(y yVar) {
            this.f13761e = yVar;
        }

        public void k(EnumC0237z enumC0237z) {
            this.f13760d = enumC0237z;
        }

        public ArrayList l() {
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(this.f13757a);
            arrayList.add(this.f13758b);
            n nVar = this.f13759c;
            arrayList.add(nVar == null ? null : nVar.f());
            EnumC0237z enumC0237z = this.f13760d;
            arrayList.add(enumC0237z == null ? null : Integer.valueOf(enumC0237z.f13888a));
            y yVar = this.f13761e;
            arrayList.add(yVar != null ? Integer.valueOf(yVar.f13883a) : null);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e5.z$g */
    public interface g {

        /* JADX INFO: renamed from: e5.z$g$a */
        public class a implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13762a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13763b;

            public a(ArrayList arrayList, a.e eVar) {
                this.f13762a = arrayList;
                this.f13763b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13763b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f13762a.add(0, str);
                this.f13763b.a(this.f13762a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$b */
        public class b implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13764a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13765b;

            public b(ArrayList arrayList, a.e eVar) {
                this.f13764a = arrayList;
                this.f13765b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13765b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f13764a.add(0, str);
                this.f13765b.a(this.f13764a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$c */
        public class c implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13766a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13767b;

            public c(ArrayList arrayList, a.e eVar) {
                this.f13766a = arrayList;
                this.f13767b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13767b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f13766a.add(0, null);
                this.f13767b.a(this.f13766a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$d */
        public class d implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13768a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13769b;

            public d(ArrayList arrayList, a.e eVar) {
                this.f13768a = arrayList;
                this.f13769b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13769b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(o oVar) {
                this.f13768a.add(0, oVar);
                this.f13769b.a(this.f13768a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$e */
        public class e implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13770a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13771b;

            public e(ArrayList arrayList, a.e eVar) {
                this.f13770a = arrayList;
                this.f13771b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13771b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f13770a.add(0, null);
                this.f13771b.a(this.f13770a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$f */
        public class f implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13772a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13773b;

            public f(ArrayList arrayList, a.e eVar) {
                this.f13772a = arrayList;
                this.f13773b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13773b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f13772a.add(0, null);
                this.f13773b.a(this.f13772a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$g, reason: collision with other inner class name */
        public class C0236g implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13774a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13775b;

            public C0236g(ArrayList arrayList, a.e eVar) {
                this.f13774a = arrayList;
                this.f13775b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13775b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(o oVar) {
                this.f13774a.add(0, oVar);
                this.f13775b.a(this.f13774a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$h */
        public class h implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13776a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13777b;

            public h(ArrayList arrayList, a.e eVar) {
                this.f13776a = arrayList;
                this.f13777b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13777b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f13776a.add(0, null);
                this.f13777b.a(this.f13776a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$i */
        public class i implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13778a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13779b;

            public i(ArrayList arrayList, a.e eVar) {
                this.f13778a = arrayList;
                this.f13779b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13779b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(s sVar) {
                this.f13778a.add(0, sVar);
                this.f13779b.a(this.f13778a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$j */
        public class j implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13780a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13781b;

            public j(ArrayList arrayList, a.e eVar) {
                this.f13780a = arrayList;
                this.f13781b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13781b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(List list) {
                this.f13780a.add(0, list);
                this.f13781b.a(this.f13780a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$k */
        public class k implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13782a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13783b;

            public k(ArrayList arrayList, a.e eVar) {
                this.f13782a = arrayList;
                this.f13783b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13783b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f13782a.add(0, str);
                this.f13783b.a(this.f13782a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$l */
        public class l implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13784a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13785b;

            public l(ArrayList arrayList, a.e eVar) {
                this.f13784a = arrayList;
                this.f13785b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13785b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f13784a.add(0, null);
                this.f13785b.a(this.f13784a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$m */
        public class m implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13786a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13787b;

            public m(ArrayList arrayList, a.e eVar) {
                this.f13786a = arrayList;
                this.f13787b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13787b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f13786a.add(0, str);
                this.f13787b.a(this.f13786a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$n */
        public class n implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13788a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13789b;

            public n(ArrayList arrayList, a.e eVar) {
                this.f13788a = arrayList;
                this.f13789b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13789b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f13788a.add(0, str);
                this.f13789b.a(this.f13788a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$o */
        public class o implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13790a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13791b;

            public o(ArrayList arrayList, a.e eVar) {
                this.f13790a = arrayList;
                this.f13791b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13791b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f13790a.add(0, null);
                this.f13791b.a(this.f13790a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$p */
        public class p implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13792a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13793b;

            public p(ArrayList arrayList, a.e eVar) {
                this.f13792a = arrayList;
                this.f13793b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13793b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(s sVar) {
                this.f13792a.add(0, sVar);
                this.f13793b.a(this.f13792a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$q */
        public class q implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13794a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13795b;

            public q(ArrayList arrayList, a.e eVar) {
                this.f13794a = arrayList;
                this.f13795b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13795b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f13794a.add(0, null);
                this.f13795b.a(this.f13794a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$r */
        public class r implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13796a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13797b;

            public r(ArrayList arrayList, a.e eVar) {
                this.f13796a = arrayList;
                this.f13797b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13797b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f13796a.add(0, null);
                this.f13797b.a(this.f13796a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$s */
        public class s implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13798a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13799b;

            public s(ArrayList arrayList, a.e eVar) {
                this.f13798a = arrayList;
                this.f13799b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13799b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f13798a.add(0, null);
                this.f13799b.a(this.f13798a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$t */
        public class t implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13800a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13801b;

            public t(ArrayList arrayList, a.e eVar) {
                this.f13800a = arrayList;
                this.f13801b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13801b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f13800a.add(0, null);
                this.f13801b.a(this.f13800a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$u */
        public class u implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13802a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13803b;

            public u(ArrayList arrayList, a.e eVar) {
                this.f13802a = arrayList;
                this.f13803b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13803b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f13802a.add(0, null);
                this.f13803b.a(this.f13802a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$v */
        public class v implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13804a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13805b;

            public v(ArrayList arrayList, a.e eVar) {
                this.f13804a = arrayList;
                this.f13805b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13805b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f13804a.add(0, null);
                this.f13805b.a(this.f13804a);
            }
        }

        /* JADX INFO: renamed from: e5.z$g$w */
        public class w implements x {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13806a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f13807b;

            public w(ArrayList arrayList, a.e eVar) {
                this.f13806a = arrayList;
                this.f13807b = eVar;
            }

            @Override // e5.AbstractC1533z.x
            public void b(Throwable th) {
                this.f13807b.a(AbstractC1533z.a(th));
            }

            @Override // e5.AbstractC1533z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r32) {
                this.f13806a.add(0, null);
                this.f13807b.a(this.f13806a);
            }
        }

        static /* synthetic */ void B(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.a0((i) arrayList.get(0), (f) arrayList.get(1), new C0236g(new ArrayList(), eVar));
        }

        static /* synthetic */ void E(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.u((i) arrayList.get(0), (List) arrayList.get(1), new l(new ArrayList(), eVar));
        }

        static /* synthetic */ void I(g gVar, Object obj, a.e eVar) {
            gVar.h((i) ((ArrayList) obj).get(0), new q(new ArrayList(), eVar));
        }

        static /* synthetic */ void J(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            i iVar = (i) arrayList2.get(0);
            Number number = (Number) arrayList2.get(1);
            Number number2 = (Number) arrayList2.get(2);
            gVar.s(iVar, number == null ? null : Long.valueOf(number.longValue()), number2 != null ? Long.valueOf(number2.longValue()) : null, new b(arrayList, eVar));
        }

        static /* synthetic */ void Q(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.l0((i) arrayList.get(0), (String) arrayList.get(1), (r) arrayList.get(2), c.values()[((Integer) arrayList.get(3)).intValue()], (List) arrayList.get(4), (Boolean) arrayList.get(5), new j(new ArrayList(), eVar));
        }

        static /* synthetic */ void S(g gVar, Object obj, a.e eVar) {
            gVar.y((i) ((ArrayList) obj).get(0), new r(new ArrayList(), eVar));
        }

        static /* synthetic */ void T(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.p((i) arrayList.get(0), l.values()[((Integer) arrayList.get(1)).intValue()], new o(new ArrayList(), eVar));
        }

        static /* synthetic */ void Z(g gVar, Object obj, a.e eVar) {
            gVar.c0((Boolean) ((ArrayList) obj).get(0), new w(new ArrayList(), eVar));
        }

        static V4.h a() {
            return h.f13808e;
        }

        static /* synthetic */ void b(g gVar, Object obj, a.e eVar) {
            gVar.R((i) ((ArrayList) obj).get(0), new u(new ArrayList(), eVar));
        }

        static void b0(V4.b bVar, final g gVar) {
            V4.a aVar = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.loadBundle", a());
            if (gVar != null) {
                aVar.e(new a.d() { // from class: e5.A
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.k0(this.f13635a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.namedQueryGet", a());
            if (gVar != null) {
                aVar2.e(new a.d() { // from class: e5.C
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.i0(this.f13637a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.clearPersistence", a());
            if (gVar != null) {
                aVar3.e(new a.d() { // from class: e5.G
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.I(this.f13641a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            V4.a aVar4 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.disableNetwork", a());
            if (gVar != null) {
                aVar4.e(new a.d() { // from class: e5.H
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.S(this.f13642a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            V4.a aVar5 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.enableNetwork", a());
            if (gVar != null) {
                aVar5.e(new a.d() { // from class: e5.I
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.o(this.f13643a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
            V4.a aVar6 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.terminate", a());
            if (gVar != null) {
                aVar6.e(new a.d() { // from class: e5.J
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.w(this.f13644a, obj, eVar);
                    }
                });
            } else {
                aVar6.e(null);
            }
            V4.a aVar7 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.waitForPendingWrites", a());
            if (gVar != null) {
                aVar7.e(new a.d() { // from class: e5.K
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.b(this.f13645a, obj, eVar);
                    }
                });
            } else {
                aVar7.e(null);
            }
            V4.a aVar8 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.setIndexConfiguration", a());
            if (gVar != null) {
                aVar8.e(new a.d() { // from class: e5.M
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.j(this.f13647a, obj, eVar);
                    }
                });
            } else {
                aVar8.e(null);
            }
            V4.a aVar9 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.setLoggingEnabled", a());
            if (gVar != null) {
                aVar9.e(new a.d() { // from class: e5.N
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.Z(this.f13648a, obj, eVar);
                    }
                });
            } else {
                aVar9.e(null);
            }
            V4.a aVar10 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.snapshotsInSyncSetup", a());
            if (gVar != null) {
                aVar10.e(new a.d() { // from class: e5.O
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.q0(this.f13649a, obj, eVar);
                    }
                });
            } else {
                aVar10.e(null);
            }
            V4.a aVar11 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.transactionCreate", a());
            if (gVar != null) {
                aVar11.e(new a.d() { // from class: e5.L
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.J(this.f13646a, obj, eVar);
                    }
                });
            } else {
                aVar11.e(null);
            }
            V4.a aVar12 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.transactionStoreResult", a());
            if (gVar != null) {
                aVar12.e(new a.d() { // from class: e5.P
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.j0(this.f13650a, obj, eVar);
                    }
                });
            } else {
                aVar12.e(null);
            }
            V4.a aVar13 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.transactionGet", a());
            if (gVar != null) {
                aVar13.e(new a.d() { // from class: e5.Q
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.e0(this.f13651a, obj, eVar);
                    }
                });
            } else {
                aVar13.e(null);
            }
            V4.a aVar14 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.documentReferenceSet", a());
            if (gVar != null) {
                aVar14.e(new a.d() { // from class: e5.S
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.m(this.f13652a, obj, eVar);
                    }
                });
            } else {
                aVar14.e(null);
            }
            V4.a aVar15 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.documentReferenceUpdate", a());
            if (gVar != null) {
                aVar15.e(new a.d() { // from class: e5.T
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.g(this.f13653a, obj, eVar);
                    }
                });
            } else {
                aVar15.e(null);
            }
            V4.a aVar16 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.documentReferenceGet", a());
            if (gVar != null) {
                aVar16.e(new a.d() { // from class: e5.U
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.B(this.f13654a, obj, eVar);
                    }
                });
            } else {
                aVar16.e(null);
            }
            V4.a aVar17 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.documentReferenceDelete", a());
            if (gVar != null) {
                aVar17.e(new a.d() { // from class: e5.V
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.x(this.f13655a, obj, eVar);
                    }
                });
            } else {
                aVar17.e(null);
            }
            V4.a aVar18 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.queryGet", a());
            if (gVar != null) {
                aVar18.e(new a.d() { // from class: e5.W
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.n(this.f13656a, obj, eVar);
                    }
                });
            } else {
                aVar18.e(null);
            }
            V4.a aVar19 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.aggregateQuery", a());
            if (gVar != null) {
                aVar19.e(new a.d() { // from class: e5.X
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.Q(this.f13657a, obj, eVar);
                    }
                });
            } else {
                aVar19.e(null);
            }
            V4.a aVar20 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.writeBatchCommit", a());
            if (gVar != null) {
                aVar20.e(new a.d() { // from class: e5.B
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.E(this.f13636a, obj, eVar);
                    }
                });
            } else {
                aVar20.e(null);
            }
            V4.a aVar21 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.querySnapshot", a());
            if (gVar != null) {
                aVar21.e(new a.d() { // from class: e5.D
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.z(this.f13638a, obj, eVar);
                    }
                });
            } else {
                aVar21.e(null);
            }
            V4.a aVar22 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.documentReferenceSnapshot", a());
            if (gVar != null) {
                aVar22.e(new a.d() { // from class: e5.E
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.q(this.f13639a, obj, eVar);
                    }
                });
            } else {
                aVar22.e(null);
            }
            V4.a aVar23 = new V4.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.persistenceCacheIndexManagerRequest", a());
            if (gVar != null) {
                aVar23.e(new a.d() { // from class: e5.F
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1533z.g.T(this.f13640a, obj, eVar);
                    }
                });
            } else {
                aVar23.e(null);
            }
        }

        static /* synthetic */ void e0(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.P((i) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new d(new ArrayList(), eVar));
        }

        static /* synthetic */ void g(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.m0((i) arrayList.get(0), (f) arrayList.get(1), new f(new ArrayList(), eVar));
        }

        static /* synthetic */ void i0(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.A((i) arrayList.get(0), (String) arrayList.get(1), (q) arrayList.get(2), new p(new ArrayList(), eVar));
        }

        static /* synthetic */ void j(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.M((i) arrayList.get(0), (String) arrayList.get(1), new v(new ArrayList(), eVar));
        }

        static /* synthetic */ void j0(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.X((String) arrayList.get(0), v.values()[((Integer) arrayList.get(1)).intValue()], (List) arrayList.get(2), new c(new ArrayList(), eVar));
        }

        static /* synthetic */ void k0(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.K((i) arrayList.get(0), (byte[]) arrayList.get(1), new k(new ArrayList(), eVar));
        }

        static /* synthetic */ void m(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.r0((i) arrayList.get(0), (f) arrayList.get(1), new e(new ArrayList(), eVar));
        }

        static /* synthetic */ void n(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.e((i) arrayList.get(0), (String) arrayList.get(1), (Boolean) arrayList.get(2), (r) arrayList.get(3), (q) arrayList.get(4), new i(new ArrayList(), eVar));
        }

        static /* synthetic */ void o(g gVar, Object obj, a.e eVar) {
            gVar.C((i) ((ArrayList) obj).get(0), new s(new ArrayList(), eVar));
        }

        static /* synthetic */ void q(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.V((i) arrayList.get(0), (f) arrayList.get(1), (Boolean) arrayList.get(2), k.values()[((Integer) arrayList.get(3)).intValue()], new n(new ArrayList(), eVar));
        }

        static /* synthetic */ void q0(g gVar, Object obj, a.e eVar) {
            gVar.H((i) ((ArrayList) obj).get(0), new a(new ArrayList(), eVar));
        }

        static /* synthetic */ void w(g gVar, Object obj, a.e eVar) {
            gVar.W((i) ((ArrayList) obj).get(0), new t(new ArrayList(), eVar));
        }

        static /* synthetic */ void x(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.p0((i) arrayList.get(0), (f) arrayList.get(1), new h(new ArrayList(), eVar));
        }

        static /* synthetic */ void z(g gVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.Y((i) arrayList.get(0), (String) arrayList.get(1), (Boolean) arrayList.get(2), (r) arrayList.get(3), (q) arrayList.get(4), (Boolean) arrayList.get(5), k.values()[((Integer) arrayList.get(6)).intValue()], new m(new ArrayList(), eVar));
        }

        void A(i iVar, String str, q qVar, x xVar);

        void C(i iVar, x xVar);

        void H(i iVar, x xVar);

        void K(i iVar, byte[] bArr, x xVar);

        void M(i iVar, String str, x xVar);

        void P(i iVar, String str, String str2, x xVar);

        void R(i iVar, x xVar);

        void V(i iVar, f fVar, Boolean bool, k kVar, x xVar);

        void W(i iVar, x xVar);

        void X(String str, v vVar, List list, x xVar);

        void Y(i iVar, String str, Boolean bool, r rVar, q qVar, Boolean bool2, k kVar, x xVar);

        void a0(i iVar, f fVar, x xVar);

        void c0(Boolean bool, x xVar);

        void e(i iVar, String str, Boolean bool, r rVar, q qVar, x xVar);

        void h(i iVar, x xVar);

        void l0(i iVar, String str, r rVar, c cVar, List list, Boolean bool, x xVar);

        void m0(i iVar, f fVar, x xVar);

        void p(i iVar, l lVar, x xVar);

        void p0(i iVar, f fVar, x xVar);

        void r0(i iVar, f fVar, x xVar);

        void s(i iVar, Long l7, Long l8, x xVar);

        void u(i iVar, List list, x xVar);

        void y(i iVar, x xVar);
    }

    /* JADX INFO: renamed from: e5.z$h */
    public static class h extends C1510c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final h f13808e = new h();

        @Override // e5.C1510c, V4.o
        public Object g(byte b7, ByteBuffer byteBuffer) {
            switch (b7) {
                case -128:
                    return a.a((ArrayList) f(byteBuffer));
                case -127:
                    return b.a((ArrayList) f(byteBuffer));
                case -126:
                    return f.a((ArrayList) f(byteBuffer));
                case -125:
                    return i.a((ArrayList) f(byteBuffer));
                case -124:
                    return m.a((ArrayList) f(byteBuffer));
                case -123:
                    return n.a((ArrayList) f(byteBuffer));
                case -122:
                    return o.a((ArrayList) f(byteBuffer));
                case -121:
                    return p.a((ArrayList) f(byteBuffer));
                case -120:
                    return q.a((ArrayList) f(byteBuffer));
                case -119:
                    return r.a((ArrayList) f(byteBuffer));
                case -118:
                    return s.a((ArrayList) f(byteBuffer));
                case -117:
                    return t.a((ArrayList) f(byteBuffer));
                case -116:
                    return u.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b7, byteBuffer);
            }
        }

        @Override // e5.C1510c, V4.o
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof a) {
                byteArrayOutputStream.write(128);
                p(byteArrayOutputStream, ((a) obj).f());
                return;
            }
            if (obj instanceof b) {
                byteArrayOutputStream.write(129);
                p(byteArrayOutputStream, ((b) obj).e());
                return;
            }
            if (obj instanceof f) {
                byteArrayOutputStream.write(130);
                p(byteArrayOutputStream, ((f) obj).l());
                return;
            }
            if (obj instanceof i) {
                byteArrayOutputStream.write(131);
                p(byteArrayOutputStream, ((i) obj).h());
                return;
            }
            if (obj instanceof m) {
                byteArrayOutputStream.write(132);
                p(byteArrayOutputStream, ((m) obj).f());
                return;
            }
            if (obj instanceof n) {
                byteArrayOutputStream.write(133);
                p(byteArrayOutputStream, ((n) obj).f());
                return;
            }
            if (obj instanceof o) {
                byteArrayOutputStream.write(134);
                p(byteArrayOutputStream, ((o) obj).e());
                return;
            }
            if (obj instanceof p) {
                byteArrayOutputStream.write(135);
                p(byteArrayOutputStream, ((p) obj).k());
                return;
            }
            if (obj instanceof q) {
                byteArrayOutputStream.write(136);
                p(byteArrayOutputStream, ((q) obj).f());
                return;
            }
            if (obj instanceof r) {
                byteArrayOutputStream.write(137);
                p(byteArrayOutputStream, ((r) obj).t());
                return;
            }
            if (obj instanceof s) {
                byteArrayOutputStream.write(138);
                p(byteArrayOutputStream, ((s) obj).e());
            } else if (obj instanceof t) {
                byteArrayOutputStream.write(139);
                p(byteArrayOutputStream, ((t) obj).d());
            } else if (!(obj instanceof u)) {
                super.p(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(140);
                p(byteArrayOutputStream, ((u) obj).j());
            }
        }
    }

    /* JADX INFO: renamed from: e5.z$i */
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p f13810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13811c;

        public static i a(ArrayList arrayList) {
            i iVar = new i();
            iVar.e((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            iVar.g(obj == null ? null : p.a((ArrayList) obj));
            iVar.f((String) arrayList.get(2));
            return iVar;
        }

        public String b() {
            return this.f13809a;
        }

        public String c() {
            return this.f13811c;
        }

        public p d() {
            return this.f13810b;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"appName\" is null.");
            }
            this.f13809a = str;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"databaseURL\" is null.");
            }
            this.f13811c = str;
        }

        public void g(p pVar) {
            if (pVar == null) {
                throw new IllegalStateException("Nonnull field \"settings\" is null.");
            }
            this.f13810b = pVar;
        }

        public ArrayList h() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f13809a);
            p pVar = this.f13810b;
            arrayList.add(pVar == null ? null : pVar.k());
            arrayList.add(this.f13811c);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e5.z$j */
    public static class j extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f13813b;

        public j(String str, String str2, Object obj) {
            super(str2);
            this.f13812a = str;
            this.f13813b = obj;
        }
    }

    /* JADX INFO: renamed from: e5.z$k */
    public enum k {
        DEFAULT_SOURCE(0),
        CACHE(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13817a;

        k(int i7) {
            this.f13817a = i7;
        }
    }

    /* JADX INFO: renamed from: e5.z$l */
    public enum l {
        ENABLE_INDEX_AUTO_CREATION(0),
        DISABLE_INDEX_AUTO_CREATION(1),
        DELETE_ALL_INDEXES(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13822a;

        l(int i7) {
            this.f13822a = i7;
        }
    }

    /* JADX INFO: renamed from: e5.z$m */
    public static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f13823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o f13824b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f13825c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f13826d;

        /* JADX INFO: renamed from: e5.z$m$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public e f13827a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public o f13828b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Long f13829c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Long f13830d;

            public m a() {
                m mVar = new m();
                mVar.e(this.f13827a);
                mVar.b(this.f13828b);
                mVar.d(this.f13829c);
                mVar.c(this.f13830d);
                return mVar;
            }

            public a b(o oVar) {
                this.f13828b = oVar;
                return this;
            }

            public a c(Long l7) {
                this.f13830d = l7;
                return this;
            }

            public a d(Long l7) {
                this.f13829c = l7;
                return this;
            }

            public a e(e eVar) {
                this.f13827a = eVar;
                return this;
            }
        }

        public static m a(ArrayList arrayList) {
            Long lValueOf;
            m mVar = new m();
            mVar.e(e.values()[((Integer) arrayList.get(0)).intValue()]);
            Object obj = arrayList.get(1);
            Long lValueOf2 = null;
            mVar.b(obj == null ? null : o.a((ArrayList) obj));
            Object obj2 = arrayList.get(2);
            if (obj2 == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            mVar.d(lValueOf);
            Object obj3 = arrayList.get(3);
            if (obj3 != null) {
                lValueOf2 = Long.valueOf(obj3 instanceof Integer ? ((Integer) obj3).intValue() : ((Long) obj3).longValue());
            }
            mVar.c(lValueOf2);
            return mVar;
        }

        public void b(o oVar) {
            if (oVar == null) {
                throw new IllegalStateException("Nonnull field \"document\" is null.");
            }
            this.f13824b = oVar;
        }

        public void c(Long l7) {
            if (l7 == null) {
                throw new IllegalStateException("Nonnull field \"newIndex\" is null.");
            }
            this.f13826d = l7;
        }

        public void d(Long l7) {
            if (l7 == null) {
                throw new IllegalStateException("Nonnull field \"oldIndex\" is null.");
            }
            this.f13825c = l7;
        }

        public void e(e eVar) {
            if (eVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f13823a = eVar;
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(4);
            e eVar = this.f13823a;
            arrayList.add(eVar == null ? null : Integer.valueOf(eVar.f13756a));
            o oVar = this.f13824b;
            arrayList.add(oVar != null ? oVar.e() : null);
            arrayList.add(this.f13825c);
            arrayList.add(this.f13826d);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e5.z$n */
    public static final class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f13831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f13832b;

        public static n a(ArrayList arrayList) {
            n nVar = new n();
            nVar.d((Boolean) arrayList.get(0));
            nVar.e((List) arrayList.get(1));
            return nVar;
        }

        public Boolean b() {
            return this.f13831a;
        }

        public List c() {
            return this.f13832b;
        }

        public void d(Boolean bool) {
            this.f13831a = bool;
        }

        public void e(List list) {
            this.f13832b = list;
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f13831a);
            arrayList.add(this.f13832b);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e5.z$o */
    public static final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f13834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public t f13835c;

        /* JADX INFO: renamed from: e5.z$o$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f13836a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Map f13837b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public t f13838c;

            public o a() {
                o oVar = new o();
                oVar.d(this.f13836a);
                oVar.b(this.f13837b);
                oVar.c(this.f13838c);
                return oVar;
            }

            public a b(Map map) {
                this.f13837b = map;
                return this;
            }

            public a c(t tVar) {
                this.f13838c = tVar;
                return this;
            }

            public a d(String str) {
                this.f13836a = str;
                return this;
            }
        }

        public static o a(ArrayList arrayList) {
            o oVar = new o();
            oVar.d((String) arrayList.get(0));
            oVar.b((Map) arrayList.get(1));
            Object obj = arrayList.get(2);
            oVar.c(obj == null ? null : t.a((ArrayList) obj));
            return oVar;
        }

        public void b(Map map) {
            this.f13834b = map;
        }

        public void c(t tVar) {
            if (tVar == null) {
                throw new IllegalStateException("Nonnull field \"metadata\" is null.");
            }
            this.f13835c = tVar;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"path\" is null.");
            }
            this.f13833a = str;
        }

        public ArrayList e() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f13833a);
            arrayList.add(this.f13834b);
            t tVar = this.f13835c;
            arrayList.add(tVar == null ? null : tVar.d());
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e5.z$p */
    public static final class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f13839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f13841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f13842d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Boolean f13843e;

        public static p a(ArrayList arrayList) {
            Long lValueOf;
            p pVar = new p();
            pVar.i((Boolean) arrayList.get(0));
            pVar.g((String) arrayList.get(1));
            pVar.j((Boolean) arrayList.get(2));
            Object obj = arrayList.get(3);
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            pVar.f(lValueOf);
            pVar.h((Boolean) arrayList.get(4));
            return pVar;
        }

        public Long b() {
            return this.f13842d;
        }

        public String c() {
            return this.f13840b;
        }

        public Boolean d() {
            return this.f13839a;
        }

        public Boolean e() {
            return this.f13841c;
        }

        public void f(Long l7) {
            this.f13842d = l7;
        }

        public void g(String str) {
            this.f13840b = str;
        }

        public void h(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"ignoreUndefinedProperties\" is null.");
            }
            this.f13843e = bool;
        }

        public void i(Boolean bool) {
            this.f13839a = bool;
        }

        public void j(Boolean bool) {
            this.f13841c = bool;
        }

        public ArrayList k() {
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(this.f13839a);
            arrayList.add(this.f13840b);
            arrayList.add(this.f13841c);
            arrayList.add(this.f13842d);
            arrayList.add(this.f13843e);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e5.z$q */
    public static final class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EnumC0237z f13844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public y f13845b;

        public static q a(ArrayList arrayList) {
            q qVar = new q();
            qVar.e(EnumC0237z.values()[((Integer) arrayList.get(0)).intValue()]);
            qVar.d(y.values()[((Integer) arrayList.get(1)).intValue()]);
            return qVar;
        }

        public y b() {
            return this.f13845b;
        }

        public EnumC0237z c() {
            return this.f13844a;
        }

        public void d(y yVar) {
            if (yVar == null) {
                throw new IllegalStateException("Nonnull field \"serverTimestampBehavior\" is null.");
            }
            this.f13845b = yVar;
        }

        public void e(EnumC0237z enumC0237z) {
            if (enumC0237z == null) {
                throw new IllegalStateException("Nonnull field \"source\" is null.");
            }
            this.f13844a = enumC0237z;
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(2);
            EnumC0237z enumC0237z = this.f13844a;
            arrayList.add(enumC0237z == null ? null : Integer.valueOf(enumC0237z.f13888a));
            y yVar = this.f13845b;
            arrayList.add(yVar != null ? Integer.valueOf(yVar.f13883a) : null);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e5.z$r */
    public static final class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f13846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f13847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f13848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f13849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f13850e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f13851f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f13852g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List f13853h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Map f13854i;

        public static r a(ArrayList arrayList) {
            Long lValueOf;
            r rVar = new r();
            rVar.s((List) arrayList.get(0));
            rVar.p((List) arrayList.get(1));
            Object obj = arrayList.get(2);
            Long lValueOf2 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            rVar.n(lValueOf);
            Object obj2 = arrayList.get(3);
            if (obj2 != null) {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            rVar.o(lValueOf2);
            rVar.r((List) arrayList.get(4));
            rVar.q((List) arrayList.get(5));
            rVar.k((List) arrayList.get(6));
            rVar.l((List) arrayList.get(7));
            rVar.m((Map) arrayList.get(8));
            return rVar;
        }

        public List b() {
            return this.f13852g;
        }

        public List c() {
            return this.f13853h;
        }

        public Map d() {
            return this.f13854i;
        }

        public Long e() {
            return this.f13848c;
        }

        public Long f() {
            return this.f13849d;
        }

        public List g() {
            return this.f13847b;
        }

        public List h() {
            return this.f13851f;
        }

        public List i() {
            return this.f13850e;
        }

        public List j() {
            return this.f13846a;
        }

        public void k(List list) {
            this.f13852g = list;
        }

        public void l(List list) {
            this.f13853h = list;
        }

        public void m(Map map) {
            this.f13854i = map;
        }

        public void n(Long l7) {
            this.f13848c = l7;
        }

        public void o(Long l7) {
            this.f13849d = l7;
        }

        public void p(List list) {
            this.f13847b = list;
        }

        public void q(List list) {
            this.f13851f = list;
        }

        public void r(List list) {
            this.f13850e = list;
        }

        public void s(List list) {
            this.f13846a = list;
        }

        public ArrayList t() {
            ArrayList arrayList = new ArrayList(9);
            arrayList.add(this.f13846a);
            arrayList.add(this.f13847b);
            arrayList.add(this.f13848c);
            arrayList.add(this.f13849d);
            arrayList.add(this.f13850e);
            arrayList.add(this.f13851f);
            arrayList.add(this.f13852g);
            arrayList.add(this.f13853h);
            arrayList.add(this.f13854i);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e5.z$s */
    public static final class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f13855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f13856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public t f13857c;

        /* JADX INFO: renamed from: e5.z$s$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f13858a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List f13859b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public t f13860c;

            public s a() {
                s sVar = new s();
                sVar.c(this.f13858a);
                sVar.b(this.f13859b);
                sVar.d(this.f13860c);
                return sVar;
            }

            public a b(List list) {
                this.f13859b = list;
                return this;
            }

            public a c(List list) {
                this.f13858a = list;
                return this;
            }

            public a d(t tVar) {
                this.f13860c = tVar;
                return this;
            }
        }

        public static s a(ArrayList arrayList) {
            s sVar = new s();
            sVar.c((List) arrayList.get(0));
            sVar.b((List) arrayList.get(1));
            Object obj = arrayList.get(2);
            sVar.d(obj == null ? null : t.a((ArrayList) obj));
            return sVar;
        }

        public void b(List list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"documentChanges\" is null.");
            }
            this.f13856b = list;
        }

        public void c(List list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"documents\" is null.");
            }
            this.f13855a = list;
        }

        public void d(t tVar) {
            if (tVar == null) {
                throw new IllegalStateException("Nonnull field \"metadata\" is null.");
            }
            this.f13857c = tVar;
        }

        public ArrayList e() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f13855a);
            arrayList.add(this.f13856b);
            t tVar = this.f13857c;
            arrayList.add(tVar == null ? null : tVar.d());
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e5.z$t */
    public static final class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f13861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Boolean f13862b;

        /* JADX INFO: renamed from: e5.z$t$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Boolean f13863a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Boolean f13864b;

            public t a() {
                t tVar = new t();
                tVar.b(this.f13863a);
                tVar.c(this.f13864b);
                return tVar;
            }

            public a b(Boolean bool) {
                this.f13863a = bool;
                return this;
            }

            public a c(Boolean bool) {
                this.f13864b = bool;
                return this;
            }
        }

        public static t a(ArrayList arrayList) {
            t tVar = new t();
            tVar.b((Boolean) arrayList.get(0));
            tVar.c((Boolean) arrayList.get(1));
            return tVar;
        }

        public void b(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"hasPendingWrites\" is null.");
            }
            this.f13861a = bool;
        }

        public void c(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isFromCache\" is null.");
            }
            this.f13862b = bool;
        }

        public ArrayList d() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f13861a);
            arrayList.add(this.f13862b);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e5.z$u */
    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w f13865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map f13867c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public n f13868d;

        public static u a(ArrayList arrayList) {
            u uVar = new u();
            uVar.i(w.values()[((Integer) arrayList.get(0)).intValue()]);
            uVar.h((String) arrayList.get(1));
            uVar.f((Map) arrayList.get(2));
            Object obj = arrayList.get(3);
            uVar.g(obj == null ? null : n.a((ArrayList) obj));
            return uVar;
        }

        public Map b() {
            return this.f13867c;
        }

        public n c() {
            return this.f13868d;
        }

        public String d() {
            return this.f13866b;
        }

        public w e() {
            return this.f13865a;
        }

        public void f(Map map) {
            this.f13867c = map;
        }

        public void g(n nVar) {
            this.f13868d = nVar;
        }

        public void h(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"path\" is null.");
            }
            this.f13866b = str;
        }

        public void i(w wVar) {
            if (wVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f13865a = wVar;
        }

        public ArrayList j() {
            ArrayList arrayList = new ArrayList(4);
            w wVar = this.f13865a;
            arrayList.add(wVar == null ? null : Integer.valueOf(wVar.f13878a));
            arrayList.add(this.f13866b);
            arrayList.add(this.f13867c);
            n nVar = this.f13868d;
            arrayList.add(nVar != null ? nVar.f() : null);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: e5.z$v */
    public enum v {
        SUCCESS(0),
        FAILURE(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13872a;

        v(int i7) {
            this.f13872a = i7;
        }
    }

    /* JADX INFO: renamed from: e5.z$w */
    public enum w {
        GET(0),
        UPDATE(1),
        SET(2),
        DELETE_TYPE(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13878a;

        w(int i7) {
            this.f13878a = i7;
        }
    }

    /* JADX INFO: renamed from: e5.z$x */
    public interface x {
        void a(Object obj);

        void b(Throwable th);
    }

    /* JADX INFO: renamed from: e5.z$y */
    public enum y {
        NONE(0),
        ESTIMATE(1),
        PREVIOUS(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13883a;

        y(int i7) {
            this.f13883a = i7;
        }
    }

    /* JADX INFO: renamed from: e5.z$z, reason: collision with other inner class name */
    public enum EnumC0237z {
        SERVER_AND_CACHE(0),
        SERVER(1),
        CACHE(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13888a;

        EnumC0237z(int i7) {
            this.f13888a = i7;
        }
    }

    public static ArrayList a(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        if (th instanceof j) {
            j jVar = (j) th;
            arrayList.add(jVar.f13812a);
            arrayList.add(jVar.getMessage());
            arrayList.add(jVar.f13813b);
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        }
        return arrayList;
    }
}
