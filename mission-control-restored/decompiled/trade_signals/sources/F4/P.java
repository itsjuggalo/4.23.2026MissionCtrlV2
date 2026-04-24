package F4;

import F4.AbstractC0497k;
import F4.C0487a;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import v2.AbstractC2842h;
import v2.AbstractC2844j;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public abstract class P {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0487a.c f1647b = C0487a.c.a("internal:health-checking-config");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b.C0025b f1648c = b.C0025b.b("internal:health-check-consumer-listener");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0487a.c f1649d = C0487a.c.a("internal:has-health-check-producer-listener");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0487a.c f1650e = C0487a.c.a("io.grpc.IS_PETIOLE_POLICY");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f1651f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1652a;

    public class a extends j {
        @Override // F4.P.j
        public f a(g gVar) {
            return f.g();
        }

        public String toString() {
            return "EMPTY_PICKER";
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f1653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0487a f1654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object[][] f1655c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f1656a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public C0487a f1657b = C0487a.f1724c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object[][] f1658c = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

            public a b(C0025b c0025b, Object obj) {
                AbstractC2848n.o(c0025b, "key");
                AbstractC2848n.o(obj, "value");
                int length = 0;
                while (true) {
                    Object[][] objArr = this.f1658c;
                    if (length >= objArr.length) {
                        length = -1;
                        break;
                    }
                    if (c0025b.equals(objArr[length][0])) {
                        break;
                    }
                    length++;
                }
                if (length == -1) {
                    Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f1658c.length + 1, 2);
                    Object[][] objArr3 = this.f1658c;
                    System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                    this.f1658c = objArr2;
                    length = objArr2.length - 1;
                }
                this.f1658c[length] = new Object[]{c0025b, obj};
                return this;
            }

            public b c() {
                return new b(this.f1656a, this.f1657b, this.f1658c, null);
            }

            public final a d(Object[][] objArr) {
                Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, objArr.length, 2);
                this.f1658c = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                return this;
            }

            public a e(List list) {
                AbstractC2848n.e(!list.isEmpty(), "addrs is empty");
                this.f1656a = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public a f(C0487a c0487a) {
                this.f1657b = (C0487a) AbstractC2848n.o(c0487a, "attrs");
                return this;
            }
        }

        /* JADX INFO: renamed from: F4.P$b$b, reason: collision with other inner class name */
        public static final class C0025b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f1659a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Object f1660b;

            public C0025b(String str, Object obj) {
                this.f1659a = str;
                this.f1660b = obj;
            }

            public static C0025b b(String str) {
                AbstractC2848n.o(str, "debugString");
                return new C0025b(str, null);
            }

            public String toString() {
                return this.f1659a;
            }
        }

        public b(List list, C0487a c0487a, Object[][] objArr) {
            this.f1653a = (List) AbstractC2848n.o(list, "addresses are not set");
            this.f1654b = (C0487a) AbstractC2848n.o(c0487a, "attrs");
            this.f1655c = (Object[][]) AbstractC2848n.o(objArr, "customOptions");
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f1653a;
        }

        public C0487a b() {
            return this.f1654b;
        }

        public Object c(C0025b c0025b) {
            AbstractC2848n.o(c0025b, "key");
            int i8 = 0;
            while (true) {
                Object[][] objArr = this.f1655c;
                if (i8 >= objArr.length) {
                    return c0025b.f1660b;
                }
                if (c0025b.equals(objArr[i8][0])) {
                    return this.f1655c[i8][1];
                }
                i8++;
            }
        }

        public a e() {
            return d().e(this.f1653a).f(this.f1654b).d(this.f1655c);
        }

        public String toString() {
            return AbstractC2842h.b(this).d("addrs", this.f1653a).d("attrs", this.f1654b).d("customOptions", Arrays.deepToString(this.f1655c)).toString();
        }

        public /* synthetic */ b(List list, C0487a c0487a, Object[][] objArr, a aVar) {
            this(list, c0487a, objArr);
        }
    }

    public static abstract class c {
        public abstract P a(e eVar);
    }

    public static final class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f1661a;

        public d(f fVar) {
            this.f1661a = (f) AbstractC2848n.o(fVar, "result");
        }

        @Override // F4.P.j
        public f a(g gVar) {
            return this.f1661a;
        }

        public String toString() {
            return "FixedResultPicker(" + this.f1661a + ")";
        }
    }

    public static abstract class e {
        public abstract i a(b bVar);

        public abstract AbstractC0492f b();

        public abstract ScheduledExecutorService c();

        public abstract n0 d();

        public abstract void e();

        public abstract void f(EnumC0502p enumC0502p, j jVar);
    }

    public static final class f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final f f1662e = new f(null, null, j0.f1797e, false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f1663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC0497k.a f1664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final j0 f1665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f1666d;

        public f(i iVar, AbstractC0497k.a aVar, j0 j0Var, boolean z7) {
            this.f1663a = iVar;
            this.f1664b = aVar;
            this.f1665c = (j0) AbstractC2848n.o(j0Var, "status");
            this.f1666d = z7;
        }

        public static f e(j0 j0Var) {
            AbstractC2848n.e(!j0Var.p(), "drop status shouldn't be OK");
            return new f(null, null, j0Var, true);
        }

        public static f f(j0 j0Var) {
            AbstractC2848n.e(!j0Var.p(), "error status shouldn't be OK");
            return new f(null, null, j0Var, false);
        }

        public static f g() {
            return f1662e;
        }

        public static f h(i iVar) {
            return i(iVar, null);
        }

        public static f i(i iVar, AbstractC0497k.a aVar) {
            return new f((i) AbstractC2848n.o(iVar, "subchannel"), aVar, j0.f1797e, false);
        }

        public j0 a() {
            return this.f1665c;
        }

        public AbstractC0497k.a b() {
            return this.f1664b;
        }

        public i c() {
            return this.f1663a;
        }

        public boolean d() {
            return this.f1666d;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return AbstractC2844j.a(this.f1663a, fVar.f1663a) && AbstractC2844j.a(this.f1665c, fVar.f1665c) && AbstractC2844j.a(this.f1664b, fVar.f1664b) && this.f1666d == fVar.f1666d;
        }

        public int hashCode() {
            return AbstractC2844j.b(this.f1663a, this.f1665c, this.f1664b, Boolean.valueOf(this.f1666d));
        }

        public String toString() {
            return AbstractC2842h.b(this).d("subchannel", this.f1663a).d("streamTracerFactory", this.f1664b).d("status", this.f1665c).e("drop", this.f1666d).toString();
        }
    }

    public static abstract class g {
        public abstract C0489c a();

        public abstract X b();

        public abstract Y c();
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f1667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0487a f1668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f1669c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List f1670a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public C0487a f1671b = C0487a.f1724c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object f1672c;

            public h a() {
                return new h(this.f1670a, this.f1671b, this.f1672c, null);
            }

            public a b(List list) {
                this.f1670a = list;
                return this;
            }

            public a c(C0487a c0487a) {
                this.f1671b = c0487a;
                return this;
            }

            public a d(Object obj) {
                this.f1672c = obj;
                return this;
            }
        }

        public h(List list, C0487a c0487a, Object obj) {
            this.f1667a = Collections.unmodifiableList(new ArrayList((Collection) AbstractC2848n.o(list, "addresses")));
            this.f1668b = (C0487a) AbstractC2848n.o(c0487a, "attributes");
            this.f1669c = obj;
        }

        public static a d() {
            return new a();
        }

        public List a() {
            return this.f1667a;
        }

        public C0487a b() {
            return this.f1668b;
        }

        public Object c() {
            return this.f1669c;
        }

        public a e() {
            return d().b(this.f1667a).c(this.f1668b).d(this.f1669c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return AbstractC2844j.a(this.f1667a, hVar.f1667a) && AbstractC2844j.a(this.f1668b, hVar.f1668b) && AbstractC2844j.a(this.f1669c, hVar.f1669c);
        }

        public int hashCode() {
            return AbstractC2844j.b(this.f1667a, this.f1668b, this.f1669c);
        }

        public String toString() {
            return AbstractC2842h.b(this).d("addresses", this.f1667a).d("attributes", this.f1668b).d("loadBalancingPolicyConfig", this.f1669c).toString();
        }

        public /* synthetic */ h(List list, C0487a c0487a, Object obj, a aVar) {
            this(list, c0487a, obj);
        }
    }

    public static abstract class i {
        /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final F4.C0509x a() {
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
                v2.AbstractC2848n.x(r3, r2, r0)
                java.lang.Object r0 = r0.get(r1)
                F4.x r0 = (F4.C0509x) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: F4.P.i.a():F4.x");
        }

        public abstract List b();

        public abstract C0487a c();

        public abstract AbstractC0492f d();

        public abstract Object e();

        public abstract void f();

        public abstract void g();

        public abstract void h(k kVar);

        public abstract void i(List list);
    }

    public static abstract class j {
        public abstract f a(g gVar);
    }

    public interface k {
        void a(C0503q c0503q);
    }

    public j0 a(h hVar) {
        if (!hVar.a().isEmpty() || b()) {
            int i8 = this.f1652a;
            this.f1652a = i8 + 1;
            if (i8 == 0) {
                d(hVar);
            }
            this.f1652a = 0;
            return j0.f1797e;
        }
        j0 j0VarR = j0.f1812t.r("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
        c(j0VarR);
        return j0VarR;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(j0 j0Var);

    public void d(h hVar) {
        int i8 = this.f1652a;
        this.f1652a = i8 + 1;
        if (i8 == 0) {
            a(hVar);
        }
        this.f1652a = 0;
    }

    public abstract void f();

    public void e() {
    }
}
