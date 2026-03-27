package r5;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import r5.AbstractC2595k;
import r5.C2585a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class S {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2585a.c f22548b = C2585a.c.a("internal:health-checking-config");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b.C0348b f22549c = b.C0348b.b("internal:health-check-consumer-listener");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2585a.c f22550d = C2585a.c.a("internal:has-health-check-producer-listener");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2585a.c f22551e = C2585a.c.a("io.grpc.IS_PETIOLE_POLICY");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f22552f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22553a;

    public class a extends j {
        @Override // r5.S.j
        public f a(g gVar) {
            return f.g();
        }

        public String toString() {
            return "EMPTY_PICKER";
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f22554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2585a f22555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object[][] f22556c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f22557a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public C2585a f22558b = C2585a.f22601c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object[][] f22559c = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

            public a b(C0348b c0348b, Object obj) {
                H2.m.o(c0348b, SubscriberAttributeKt.JSON_NAME_KEY);
                H2.m.o(obj, "value");
                int length = 0;
                while (true) {
                    Object[][] objArr = this.f22559c;
                    if (length >= objArr.length) {
                        length = -1;
                        break;
                    }
                    if (c0348b.equals(objArr[length][0])) {
                        break;
                    }
                    length++;
                }
                if (length == -1) {
                    Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f22559c.length + 1, 2);
                    Object[][] objArr3 = this.f22559c;
                    System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                    this.f22559c = objArr2;
                    length = objArr2.length - 1;
                }
                this.f22559c[length] = new Object[]{c0348b, obj};
                return this;
            }

            public b c() {
                return new b(this.f22557a, this.f22558b, this.f22559c, null);
            }

            public final a d(Object[][] objArr) {
                Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, objArr.length, 2);
                this.f22559c = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                return this;
            }

            public a e(List list) {
                H2.m.e(!list.isEmpty(), "addrs is empty");
                this.f22557a = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public a f(C2585a c2585a) {
                this.f22558b = (C2585a) H2.m.o(c2585a, "attrs");
                return this;
            }
        }

        /* JADX INFO: renamed from: r5.S$b$b, reason: collision with other inner class name */
        public static final class C0348b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f22560a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Object f22561b;

            public C0348b(String str, Object obj) {
                this.f22560a = str;
                this.f22561b = obj;
            }

            public static C0348b b(String str) {
                H2.m.o(str, "debugString");
                return new C0348b(str, null);
            }

            public String toString() {
                return this.f22560a;
            }
        }

        public /* synthetic */ b(List list, C2585a c2585a, Object[][] objArr, a aVar) {
            this(list, c2585a, objArr);
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f22554a;
        }

        public C2585a b() {
            return this.f22555b;
        }

        public Object c(C0348b c0348b) {
            H2.m.o(c0348b, SubscriberAttributeKt.JSON_NAME_KEY);
            int i7 = 0;
            while (true) {
                Object[][] objArr = this.f22556c;
                if (i7 >= objArr.length) {
                    return c0348b.f22561b;
                }
                if (c0348b.equals(objArr[i7][0])) {
                    return this.f22556c[i7][1];
                }
                i7++;
            }
        }

        public a e() {
            return d().e(this.f22554a).f(this.f22555b).d(this.f22556c);
        }

        public String toString() {
            return H2.g.b(this).d("addrs", this.f22554a).d("attrs", this.f22555b).d("customOptions", Arrays.deepToString(this.f22556c)).toString();
        }

        public b(List list, C2585a c2585a, Object[][] objArr) {
            this.f22554a = (List) H2.m.o(list, "addresses are not set");
            this.f22555b = (C2585a) H2.m.o(c2585a, "attrs");
            this.f22556c = (Object[][]) H2.m.o(objArr, "customOptions");
        }
    }

    public static abstract class c {
        public abstract S a(e eVar);
    }

    public static final class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f22562a;

        public d(f fVar) {
            this.f22562a = (f) H2.m.o(fVar, "result");
        }

        @Override // r5.S.j
        public f a(g gVar) {
            return this.f22562a;
        }

        public String toString() {
            return "FixedResultPicker(" + this.f22562a + ")";
        }
    }

    public static abstract class e {
        public abstract i a(b bVar);

        public abstract AbstractC2590f b();

        public abstract ScheduledExecutorService c();

        public abstract p0 d();

        public abstract void e();

        public abstract void f(EnumC2600p enumC2600p, j jVar);
    }

    public static final class f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final f f22563e = new f(null, null, l0.f22705e, false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f22564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2595k.a f22565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l0 f22566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f22567d;

        public f(i iVar, AbstractC2595k.a aVar, l0 l0Var, boolean z7) {
            this.f22564a = iVar;
            this.f22565b = aVar;
            this.f22566c = (l0) H2.m.o(l0Var, "status");
            this.f22567d = z7;
        }

        public static f e(l0 l0Var) {
            H2.m.e(!l0Var.o(), "drop status shouldn't be OK");
            return new f(null, null, l0Var, true);
        }

        public static f f(l0 l0Var) {
            H2.m.e(!l0Var.o(), "error status shouldn't be OK");
            return new f(null, null, l0Var, false);
        }

        public static f g() {
            return f22563e;
        }

        public static f h(i iVar) {
            return i(iVar, null);
        }

        public static f i(i iVar, AbstractC2595k.a aVar) {
            return new f((i) H2.m.o(iVar, "subchannel"), aVar, l0.f22705e, false);
        }

        public l0 a() {
            return this.f22566c;
        }

        public AbstractC2595k.a b() {
            return this.f22565b;
        }

        public i c() {
            return this.f22564a;
        }

        public boolean d() {
            return this.f22567d;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return H2.i.a(this.f22564a, fVar.f22564a) && H2.i.a(this.f22566c, fVar.f22566c) && H2.i.a(this.f22565b, fVar.f22565b) && this.f22567d == fVar.f22567d;
        }

        public int hashCode() {
            return H2.i.b(this.f22564a, this.f22566c, this.f22565b, Boolean.valueOf(this.f22567d));
        }

        public String toString() {
            return H2.g.b(this).d("subchannel", this.f22564a).d("streamTracerFactory", this.f22565b).d("status", this.f22566c).e("drop", this.f22567d).toString();
        }
    }

    public static abstract class g {
        public abstract C2587c a();

        public abstract Z b();

        public abstract a0 c();
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f22568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2585a f22569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f22570c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f22571a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public C2585a f22572b = C2585a.f22601c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object f22573c;

            public h a() {
                return new h(this.f22571a, this.f22572b, this.f22573c, null);
            }

            public a b(List list) {
                this.f22571a = list;
                return this;
            }

            public a c(C2585a c2585a) {
                this.f22572b = c2585a;
                return this;
            }

            public a d(Object obj) {
                this.f22573c = obj;
                return this;
            }
        }

        public /* synthetic */ h(List list, C2585a c2585a, Object obj, a aVar) {
            this(list, c2585a, obj);
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f22568a;
        }

        public C2585a b() {
            return this.f22569b;
        }

        public Object c() {
            return this.f22570c;
        }

        public a e() {
            return d().b(this.f22568a).c(this.f22569b).d(this.f22570c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return H2.i.a(this.f22568a, hVar.f22568a) && H2.i.a(this.f22569b, hVar.f22569b) && H2.i.a(this.f22570c, hVar.f22570c);
        }

        public int hashCode() {
            return H2.i.b(this.f22568a, this.f22569b, this.f22570c);
        }

        public String toString() {
            return H2.g.b(this).d("addresses", this.f22568a).d("attributes", this.f22569b).d("loadBalancingPolicyConfig", this.f22570c).toString();
        }

        public h(List list, C2585a c2585a, Object obj) {
            this.f22568a = Collections.unmodifiableList(new ArrayList((Collection) H2.m.o(list, "addresses")));
            this.f22569b = (C2585a) H2.m.o(c2585a, "attributes");
            this.f22570c = obj;
        }
    }

    public static abstract class i {
        /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final r5.C2607x a() {
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
                H2.m.w(r3, r2, r0)
                java.lang.Object r0 = r0.get(r1)
                r5.x r0 = (r5.C2607x) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: r5.S.i.a():r5.x");
        }

        public abstract List b();

        public abstract C2585a c();

        public abstract AbstractC2590f d();

        public abstract Object e();

        public abstract void f();

        public abstract void g();

        public abstract void h(k kVar);

        public abstract void i(List list);
    }

    public interface k {
        void a(C2601q c2601q);
    }

    public l0 a(h hVar) {
        if (!hVar.a().isEmpty() || b()) {
            int i7 = this.f22553a;
            this.f22553a = i7 + 1;
            if (i7 == 0) {
                d(hVar);
            }
            this.f22553a = 0;
            return l0.f22705e;
        }
        l0 l0VarQ = l0.f22720t.q("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
        c(l0VarQ);
        return l0VarQ;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(l0 l0Var);

    public void d(h hVar) {
        int i7 = this.f22553a;
        this.f22553a = i7 + 1;
        if (i7 == 0) {
            a(hVar);
        }
        this.f22553a = 0;
    }

    public abstract void f();

    public static abstract class j {
        public abstract f a(g gVar);

        public void b() {
        }
    }

    public void e() {
    }
}
