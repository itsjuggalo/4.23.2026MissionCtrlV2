package ce;

import ce.o;
import dd.a0;
import fe.h0;
import fe.l1;
import fe.m0;
import fe.y;
import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import xf.j1;
import xf.q1;
import xf.r0;
import xf.u0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f3936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cd.k f3937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f3938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f3939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f3940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f3941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f3942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f3943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f3944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f3945j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f3935l = {n0.g(new g0(n.class, "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), n0.g(new g0(n.class, "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), n0.g(new g0(n.class, "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), n0.g(new g0(n.class, "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), n0.g(new g0(n.class, "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), n0.g(new g0(n.class, "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), n0.g(new g0(n.class, "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), n0.g(new g0(n.class, "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0))};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f3934k = new b(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3946a;

        public a(int i10) {
            this.f3946a = i10;
        }

        public final fe.e a(n types, wd.m property) {
            t.f(types, "types");
            t.f(property, "property");
            return types.c(fg.a.a(property.getName()), this.f3946a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final r0 a(h0 module) {
            t.f(module, "module");
            fe.e eVarB = y.b(module, o.a.f4018w0);
            if (eVarB == null) {
                return null;
            }
            q1 q1VarK = q1.f25042b.k();
            List parameters = eVarB.k().getParameters();
            t.e(parameters, "getParameters(...)");
            Object objV0 = a0.v0(parameters);
            t.e(objV0, "single(...)");
            return u0.h(q1VarK, eVarB, dd.q.e(new j1((l1) objV0)));
        }

        public b() {
        }
    }

    public n(h0 module, m0 notFoundClasses) {
        t.f(module, "module");
        t.f(notFoundClasses, "notFoundClasses");
        this.f3936a = notFoundClasses;
        this.f3937b = cd.l.a(cd.n.f3864b, new m(module));
        this.f3938c = new a(1);
        this.f3939d = new a(1);
        this.f3940e = new a(1);
        this.f3941f = new a(2);
        this.f3942g = new a(3);
        this.f3943h = new a(1);
        this.f3944i = new a(2);
        this.f3945j = new a(3);
    }

    public static final qf.k f(h0 h0Var) {
        return h0Var.I0(o.f3970x).q();
    }

    public final fe.e c(String str, int i10) {
        ef.f fVarK = ef.f.k(str);
        t.e(fVarK, "identifier(...)");
        fe.h hVarE = e().e(fVarK, ne.d.f17041h);
        fe.e eVar = hVarE instanceof fe.e ? (fe.e) hVarE : null;
        return eVar == null ? this.f3936a.d(new ef.b(o.f3970x, fVarK), dd.q.e(Integer.valueOf(i10))) : eVar;
    }

    public final fe.e d() {
        return this.f3938c.a(this, f3935l[0]);
    }

    public final qf.k e() {
        return (qf.k) this.f3937b.getValue();
    }
}
