package K2;

import K2.AbstractC0363k;
import K2.C0353a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public abstract class S {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0353a.c f1058b = C0353a.c.a("internal:health-checking-config");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b.C0028b f1059c = b.C0028b.b("internal:health-check-consumer-listener");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0353a.c f1060d = C0353a.c.a("internal:has-health-check-producer-listener");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0353a.c f1061e = C0353a.c.a("io.grpc.IS_PETIOLE_POLICY");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f1062f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1063a;

    public class a extends j {
        @Override // K2.S.j
        public f a(g gVar) {
            return f.g();
        }

        public String toString() {
            return "EMPTY_PICKER";
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f1064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0353a f1065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object[][] f1066c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f1067a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public C0353a f1068b = C0353a.f1111c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object[][] f1069c = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

            public a b(C0028b c0028b, Object obj) {
                Z1.m.o(c0028b, "key");
                Z1.m.o(obj, "value");
                int length = 0;
                while (true) {
                    Object[][] objArr = this.f1069c;
                    if (length >= objArr.length) {
                        length = -1;
                        break;
                    }
                    if (c0028b.equals(objArr[length][0])) {
                        break;
                    }
                    length++;
                }
                if (length == -1) {
                    Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f1069c.length + 1, 2);
                    Object[][] objArr3 = this.f1069c;
                    System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                    this.f1069c = objArr2;
                    length = objArr2.length - 1;
                }
                this.f1069c[length] = new Object[]{c0028b, obj};
                return this;
            }

            public b c() {
                return new b(this.f1067a, this.f1068b, this.f1069c, null);
            }

            public final a d(Object[][] objArr) {
                Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, objArr.length, 2);
                this.f1069c = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                return this;
            }

            public a e(List list) {
                Z1.m.e(!list.isEmpty(), "addrs is empty");
                this.f1067a = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public a f(C0353a c0353a) {
                this.f1068b = (C0353a) Z1.m.o(c0353a, "attrs");
                return this;
            }
        }

        /* JADX INFO: renamed from: K2.S$b$b, reason: collision with other inner class name */
        public static final class C0028b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f1070a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Object f1071b;

            public C0028b(String str, Object obj) {
                this.f1070a = str;
                this.f1071b = obj;
            }

            public static C0028b b(String str) {
                Z1.m.o(str, "debugString");
                return new C0028b(str, null);
            }

            public String toString() {
                return this.f1070a;
            }
        }

        public /* synthetic */ b(List list, C0353a c0353a, Object[][] objArr, a aVar) {
            this(list, c0353a, objArr);
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f1064a;
        }

        public C0353a b() {
            return this.f1065b;
        }

        public Object c(C0028b c0028b) {
            Z1.m.o(c0028b, "key");
            int i4 = 0;
            while (true) {
                Object[][] objArr = this.f1066c;
                if (i4 >= objArr.length) {
                    return c0028b.f1071b;
                }
                if (c0028b.equals(objArr[i4][0])) {
                    return this.f1066c[i4][1];
                }
                i4++;
            }
        }

        public a e() {
            return d().e(this.f1064a).f(this.f1065b).d(this.f1066c);
        }

        public String toString() {
            return Z1.g.b(this).d("addrs", this.f1064a).d("attrs", this.f1065b).d("customOptions", Arrays.deepToString(this.f1066c)).toString();
        }

        public b(List list, C0353a c0353a, Object[][] objArr) {
            this.f1064a = (List) Z1.m.o(list, "addresses are not set");
            this.f1065b = (C0353a) Z1.m.o(c0353a, "attrs");
            this.f1066c = (Object[][]) Z1.m.o(objArr, "customOptions");
        }
    }

    public static abstract class c {
        public abstract S a(e eVar);
    }

    public static final class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f1072a;

        public d(f fVar) {
            this.f1072a = (f) Z1.m.o(fVar, "result");
        }

        @Override // K2.S.j
        public f a(g gVar) {
            return this.f1072a;
        }

        public String toString() {
            return "FixedResultPicker(" + this.f1072a + ")";
        }
    }

    public static abstract class e {
        public abstract i a(b bVar);

        public abstract AbstractC0358f b();

        public abstract ScheduledExecutorService c();

        public abstract p0 d();

        public abstract void e();

        public abstract void f(EnumC0368p enumC0368p, j jVar);
    }

    public static final class f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final f f1073e = new f(null, null, l0.f1215e, false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f1074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC0363k.a f1075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l0 f1076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f1077d;

        public f(i iVar, AbstractC0363k.a aVar, l0 l0Var, boolean z4) {
            this.f1074a = iVar;
            this.f1075b = aVar;
            this.f1076c = (l0) Z1.m.o(l0Var, "status");
            this.f1077d = z4;
        }

        public static f e(l0 l0Var) {
            Z1.m.e(!l0Var.o(), "drop status shouldn't be OK");
            return new f(null, null, l0Var, true);
        }

        public static f f(l0 l0Var) {
            Z1.m.e(!l0Var.o(), "error status shouldn't be OK");
            return new f(null, null, l0Var, false);
        }

        public static f g() {
            return f1073e;
        }

        public static f h(i iVar) {
            return i(iVar, null);
        }

        public static f i(i iVar, AbstractC0363k.a aVar) {
            return new f((i) Z1.m.o(iVar, "subchannel"), aVar, l0.f1215e, false);
        }

        public l0 a() {
            return this.f1076c;
        }

        public AbstractC0363k.a b() {
            return this.f1075b;
        }

        public i c() {
            return this.f1074a;
        }

        public boolean d() {
            return this.f1077d;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return Z1.i.a(this.f1074a, fVar.f1074a) && Z1.i.a(this.f1076c, fVar.f1076c) && Z1.i.a(this.f1075b, fVar.f1075b) && this.f1077d == fVar.f1077d;
        }

        public int hashCode() {
            return Z1.i.b(this.f1074a, this.f1076c, this.f1075b, Boolean.valueOf(this.f1077d));
        }

        public String toString() {
            return Z1.g.b(this).d("subchannel", this.f1074a).d("streamTracerFactory", this.f1075b).d("status", this.f1076c).e("drop", this.f1077d).toString();
        }
    }

    public static abstract class g {
        public abstract C0355c a();

        public abstract Z b();

        public abstract a0 c();
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f1078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0353a f1079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f1080c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f1081a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public C0353a f1082b = C0353a.f1111c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object f1083c;

            public h a() {
                return new h(this.f1081a, this.f1082b, this.f1083c, null);
            }

            public a b(List list) {
                this.f1081a = list;
                return this;
            }

            public a c(C0353a c0353a) {
                this.f1082b = c0353a;
                return this;
            }

            public a d(Object obj) {
                this.f1083c = obj;
                return this;
            }
        }

        public /* synthetic */ h(List list, C0353a c0353a, Object obj, a aVar) {
            this(list, c0353a, obj);
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f1078a;
        }

        public C0353a b() {
            return this.f1079b;
        }

        public Object c() {
            return this.f1080c;
        }

        public a e() {
            return d().b(this.f1078a).c(this.f1079b).d(this.f1080c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Z1.i.a(this.f1078a, hVar.f1078a) && Z1.i.a(this.f1079b, hVar.f1079b) && Z1.i.a(this.f1080c, hVar.f1080c);
        }

        public int hashCode() {
            return Z1.i.b(this.f1078a, this.f1079b, this.f1080c);
        }

        public String toString() {
            return Z1.g.b(this).d("addresses", this.f1078a).d("attributes", this.f1079b).d("loadBalancingPolicyConfig", this.f1080c).toString();
        }

        public h(List list, C0353a c0353a, Object obj) {
            this.f1078a = Collections.unmodifiableList(new ArrayList((Collection) Z1.m.o(list, "addresses")));
            this.f1079b = (C0353a) Z1.m.o(c0353a, "attributes");
            this.f1080c = obj;
        }
    }

    public static abstract class i {
        /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final K2.C0375x a() {
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
                Z1.m.w(r3, r2, r0)
                java.lang.Object r0 = r0.get(r1)
                K2.x r0 = (K2.C0375x) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: K2.S.i.a():K2.x");
        }

        public abstract List b();

        public abstract C0353a c();

        public abstract AbstractC0358f d();

        public abstract Object e();

        public abstract void f();

        public abstract void g();

        public abstract void h(k kVar);

        public abstract void i(List list);
    }

    public interface k {
        void a(C0369q c0369q);
    }

    public l0 a(h hVar) {
        if (!hVar.a().isEmpty() || b()) {
            int i4 = this.f1063a;
            this.f1063a = i4 + 1;
            if (i4 == 0) {
                d(hVar);
            }
            this.f1063a = 0;
            return l0.f1215e;
        }
        l0 l0VarQ = l0.f1230t.q("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
        c(l0VarQ);
        return l0VarQ;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(l0 l0Var);

    public void d(h hVar) {
        int i4 = this.f1063a;
        this.f1063a = i4 + 1;
        if (i4 == 0) {
            a(hVar);
        }
        this.f1063a = 0;
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
