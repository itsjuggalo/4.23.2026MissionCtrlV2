package zd;

import ae.n;
import fe.b;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import wd.l;
import zd.z2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x1 implements wd.l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f25892f = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(x1.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(x1.class, "annotations", "getAnnotations()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f25893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l.a f25895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z2.a f25896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z2.a f25897e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Type {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type[] f25898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f25899b;

        public a(Type[] types) {
            kotlin.jvm.internal.t.f(types, "types");
            this.f25898a = types;
            this.f25899b = Arrays.hashCode(types);
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && Arrays.equals(this.f25898a, ((a) obj).f25898a);
        }

        @Override // java.lang.reflect.Type
        public String getTypeName() {
            return dd.n.i0(this.f25898a, ", ", "[", "]", 0, null, null, 56, null);
        }

        public int hashCode() {
            return this.f25899b;
        }

        public String toString() {
            return getTypeName();
        }
    }

    public x1(a0 callable, int i10, l.a kind, Function0 computeDescriptor) {
        kotlin.jvm.internal.t.f(callable, "callable");
        kotlin.jvm.internal.t.f(kind, "kind");
        kotlin.jvm.internal.t.f(computeDescriptor, "computeDescriptor");
        this.f25893a = callable;
        this.f25894b = i10;
        this.f25895c = kind;
        this.f25896d = z2.c(computeDescriptor);
        this.f25897e = z2.c(new v1(this));
    }

    public static final Type e(x1 x1Var) {
        List listY0;
        fe.v0 v0VarT = x1Var.t();
        if ((v0VarT instanceof fe.b1) && kotlin.jvm.internal.t.b(i3.i(x1Var.f25893a.W()), v0VarT) && x1Var.f25893a.W().h() == b.a.FAKE_OVERRIDE) {
            fe.m mVarB = x1Var.f25893a.W().b();
            kotlin.jvm.internal.t.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class clsQ = i3.q((fe.e) mVarB);
            if (clsQ != null) {
                return clsQ;
            }
            throw new x2("Cannot determine receiver Java type of inherited declaration: " + v0VarT);
        }
        ae.h hVarO = x1Var.f25893a.O();
        if (!(hVarO instanceof ae.n)) {
            if (!(hVarO instanceof n.b)) {
                return (Type) hVarO.a().get(x1Var.getIndex());
            }
            Class[] clsArr = (Class[]) ((Collection) ((n.b) hVarO).e().get(x1Var.getIndex())).toArray(new Class[0]);
            return x1Var.r((Type[]) Arrays.copyOf(clsArr, clsArr.length));
        }
        if (x1Var.f25893a.U()) {
            ae.n nVar = (ae.n) hVarO;
            vd.g gVarF = nVar.f(x1Var.getIndex() + 1);
            int iF = nVar.f(0).f() + 1;
            listY0 = dd.a0.y0(nVar.a(), new vd.g(gVarF.e() - iF, gVarF.f() - iF));
        } else {
            ae.n nVar2 = (ae.n) hVarO;
            listY0 = dd.a0.y0(nVar2.a(), nVar2.f(x1Var.getIndex()));
        }
        Type[] typeArr = (Type[]) listY0.toArray(new Type[0]);
        return x1Var.r((Type[]) Arrays.copyOf(typeArr, typeArr.length));
    }

    public static final List q(x1 x1Var) {
        return i3.e(x1Var.t());
    }

    @Override // wd.l
    public boolean a() {
        fe.v0 v0VarT = t();
        return (v0VarT instanceof fe.s1) && ((fe.s1) v0VarT).j0() != null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x1)) {
            return false;
        }
        x1 x1Var = (x1) obj;
        return kotlin.jvm.internal.t.b(this.f25893a, x1Var.f25893a) && getIndex() == x1Var.getIndex();
    }

    @Override // wd.l
    public int getIndex() {
        return this.f25894b;
    }

    @Override // wd.l
    public String getName() {
        fe.v0 v0VarT = t();
        fe.s1 s1Var = v0VarT instanceof fe.s1 ? (fe.s1) v0VarT : null;
        if (s1Var == null || s1Var.b().H()) {
            return null;
        }
        ef.f name = s1Var.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        if (name.l()) {
            return null;
        }
        return name.b();
    }

    @Override // wd.l
    public wd.q getType() {
        xf.r0 type = t().getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        return new t2(type, new w1(this));
    }

    @Override // wd.l
    public l.a h() {
        return this.f25895c;
    }

    public int hashCode() {
        return (this.f25893a.hashCode() * 31) + Integer.hashCode(getIndex());
    }

    @Override // wd.l
    public boolean p() {
        fe.v0 v0VarT = t();
        fe.s1 s1Var = v0VarT instanceof fe.s1 ? (fe.s1) v0VarT : null;
        if (s1Var != null) {
            return nf.e.f(s1Var);
        }
        return false;
    }

    public final Type r(Type... typeArr) {
        int length = typeArr.length;
        if (length != 0) {
            return length != 1 ? new a(typeArr) : (Type) dd.n.n0(typeArr);
        }
        throw new od.b("Expected at least 1 type for compound type");
    }

    public final a0 s() {
        return this.f25893a;
    }

    public final fe.v0 t() {
        Object objB = this.f25896d.b(this, f25892f[0]);
        kotlin.jvm.internal.t.e(objB, "getValue(...)");
        return (fe.v0) objB;
    }

    public String toString() {
        return d3.f25708a.j(this);
    }
}
