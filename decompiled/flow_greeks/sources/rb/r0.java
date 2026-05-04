package rb;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import rb.a;
import rb.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.c f19691b = a.c.a("internal:health-checking-config");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b.C0345b f19692c = b.C0345b.b("internal:health-check-consumer-listener");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a.c f19693d = a.c.a("internal:has-health-check-producer-listener");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a.c f19694e = a.c.a("io.grpc.IS_PETIOLE_POLICY");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f19695f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19696a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends j {
        @Override // rb.r0.j
        public f a(g gVar) {
            return f.g();
        }

        public String toString() {
            return "EMPTY_PICKER";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f19697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rb.a f19698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object[][] f19699c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f19700a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public rb.a f19701b = rb.a.f19462c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object[][] f19702c = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

            public a b(C0345b c0345b, Object obj) {
                p6.n.o(c0345b, "key");
                p6.n.o(obj, "value");
                int length = 0;
                while (true) {
                    Object[][] objArr = this.f19702c;
                    if (length >= objArr.length) {
                        length = -1;
                        break;
                    }
                    if (c0345b.equals(objArr[length][0])) {
                        break;
                    }
                    length++;
                }
                if (length == -1) {
                    Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f19702c.length + 1, 2);
                    Object[][] objArr3 = this.f19702c;
                    System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                    this.f19702c = objArr2;
                    length = objArr2.length - 1;
                }
                this.f19702c[length] = new Object[]{c0345b, obj};
                return this;
            }

            public b c() {
                return new b(this.f19700a, this.f19701b, this.f19702c, null);
            }

            public final a d(Object[][] objArr) {
                Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, objArr.length, 2);
                this.f19702c = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                return this;
            }

            public a e(List list) {
                p6.n.e(!list.isEmpty(), "addrs is empty");
                this.f19700a = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public a f(rb.a aVar) {
                this.f19701b = (rb.a) p6.n.o(aVar, "attrs");
                return this;
            }
        }

        /* JADX INFO: renamed from: rb.r0$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0345b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f19703a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Object f19704b;

            public C0345b(String str, Object obj) {
                this.f19703a = str;
                this.f19704b = obj;
            }

            public static C0345b b(String str) {
                p6.n.o(str, "debugString");
                return new C0345b(str, null);
            }

            public String toString() {
                return this.f19703a;
            }
        }

        public /* synthetic */ b(List list, rb.a aVar, Object[][] objArr, a aVar2) {
            this(list, aVar, objArr);
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f19697a;
        }

        public rb.a b() {
            return this.f19698b;
        }

        public Object c(C0345b c0345b) {
            p6.n.o(c0345b, "key");
            int i10 = 0;
            while (true) {
                Object[][] objArr = this.f19699c;
                if (i10 >= objArr.length) {
                    return c0345b.f19704b;
                }
                if (c0345b.equals(objArr[i10][0])) {
                    return this.f19699c[i10][1];
                }
                i10++;
            }
        }

        public a e() {
            return d().e(this.f19697a).f(this.f19698b).d(this.f19699c);
        }

        public String toString() {
            return p6.h.b(this).d("addrs", this.f19697a).d("attrs", this.f19698b).d("customOptions", Arrays.deepToString(this.f19699c)).toString();
        }

        public b(List list, rb.a aVar, Object[][] objArr) {
            this.f19697a = (List) p6.n.o(list, "addresses are not set");
            this.f19698b = (rb.a) p6.n.o(aVar, "attrs");
            this.f19699c = (Object[][]) p6.n.o(objArr, "customOptions");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class c {
        public abstract r0 a(e eVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f19705a;

        public d(f fVar) {
            this.f19705a = (f) p6.n.o(fVar, "result");
        }

        @Override // rb.r0.j
        public f a(g gVar) {
            return this.f19705a;
        }

        public String toString() {
            return "FixedResultPicker(" + this.f19705a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class e {
        public abstract i a(b bVar);

        public abstract rb.f b();

        public abstract ScheduledExecutorService c();

        public abstract o1 d();

        public abstract void e();

        public abstract void f(p pVar, j jVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final f f19706e = new f(null, null, k1.f19592e, false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f19707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k.a f19708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k1 f19709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f19710d;

        public f(i iVar, k.a aVar, k1 k1Var, boolean z10) {
            this.f19707a = iVar;
            this.f19708b = aVar;
            this.f19709c = (k1) p6.n.o(k1Var, "status");
            this.f19710d = z10;
        }

        public static f e(k1 k1Var) {
            p6.n.e(!k1Var.p(), "drop status shouldn't be OK");
            return new f(null, null, k1Var, true);
        }

        public static f f(k1 k1Var) {
            p6.n.e(!k1Var.p(), "error status shouldn't be OK");
            return new f(null, null, k1Var, false);
        }

        public static f g() {
            return f19706e;
        }

        public static f h(i iVar) {
            return i(iVar, null);
        }

        public static f i(i iVar, k.a aVar) {
            return new f((i) p6.n.o(iVar, "subchannel"), aVar, k1.f19592e, false);
        }

        public k1 a() {
            return this.f19709c;
        }

        public k.a b() {
            return this.f19708b;
        }

        public i c() {
            return this.f19707a;
        }

        public boolean d() {
            return this.f19710d;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return p6.j.a(this.f19707a, fVar.f19707a) && p6.j.a(this.f19709c, fVar.f19709c) && p6.j.a(this.f19708b, fVar.f19708b) && this.f19710d == fVar.f19710d;
        }

        public int hashCode() {
            return p6.j.b(this.f19707a, this.f19709c, this.f19708b, Boolean.valueOf(this.f19710d));
        }

        public String toString() {
            return p6.h.b(this).d("subchannel", this.f19707a).d("streamTracerFactory", this.f19708b).d("status", this.f19709c).e("drop", this.f19710d).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class g {
        public abstract rb.c a();

        public abstract y0 b();

        public abstract z0 c();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f19711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rb.a f19712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f19713c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f19714a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public rb.a f19715b = rb.a.f19462c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object f19716c;

            public h a() {
                return new h(this.f19714a, this.f19715b, this.f19716c, null);
            }

            public a b(List list) {
                this.f19714a = list;
                return this;
            }

            public a c(rb.a aVar) {
                this.f19715b = aVar;
                return this;
            }

            public a d(Object obj) {
                this.f19716c = obj;
                return this;
            }
        }

        public /* synthetic */ h(List list, rb.a aVar, Object obj, a aVar2) {
            this(list, aVar, obj);
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f19711a;
        }

        public rb.a b() {
            return this.f19712b;
        }

        public Object c() {
            return this.f19713c;
        }

        public a e() {
            return d().b(this.f19711a).c(this.f19712b).d(this.f19713c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return p6.j.a(this.f19711a, hVar.f19711a) && p6.j.a(this.f19712b, hVar.f19712b) && p6.j.a(this.f19713c, hVar.f19713c);
        }

        public int hashCode() {
            return p6.j.b(this.f19711a, this.f19712b, this.f19713c);
        }

        public String toString() {
            return p6.h.b(this).d("addresses", this.f19711a).d("attributes", this.f19712b).d("loadBalancingPolicyConfig", this.f19713c).toString();
        }

        public h(List list, rb.a aVar, Object obj) {
            this.f19711a = Collections.unmodifiableList(new ArrayList((Collection) p6.n.o(list, "addresses")));
            this.f19712b = (rb.a) p6.n.o(aVar, "attributes");
            this.f19713c = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class i {
        /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final rb.x a() {
            /*
                r4 = this;
                java.util.List r0 = r4.b()
                r1 = 0
                if (r0 == 0) goto Lf
                int r2 = r0.size()
                r3 = 1
                if (r2 != r3) goto Lf
                goto L10
            Lf:
                r3 = r1
            L10:
                java.lang.String r2 = "%s does not have exactly one group"
                p6.n.x(r3, r2, r0)
                java.lang.Object r0 = r0.get(r1)
                rb.x r0 = (rb.x) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rb.r0.i.a():rb.x");
        }

        public abstract List b();

        public abstract rb.a c();

        public abstract rb.f d();

        public abstract Object e();

        public abstract void f();

        public abstract void g();

        public abstract void h(k kVar);

        public abstract void i(List list);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface k {
        void a(q qVar);
    }

    public k1 a(h hVar) {
        if (!hVar.a().isEmpty() || b()) {
            int i10 = this.f19696a;
            this.f19696a = i10 + 1;
            if (i10 == 0) {
                d(hVar);
            }
            this.f19696a = 0;
            return k1.f19592e;
        }
        k1 k1VarR = k1.f19607t.r("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
        c(k1VarR);
        return k1VarR;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(k1 k1Var);

    public void d(h hVar) {
        int i10 = this.f19696a;
        this.f19696a = i10 + 1;
        if (i10 == 0) {
            a(hVar);
        }
        this.f19696a = 0;
    }

    public abstract void f();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class j {
        public abstract f a(g gVar);

        public void b() {
        }
    }

    public void e() {
    }
}
