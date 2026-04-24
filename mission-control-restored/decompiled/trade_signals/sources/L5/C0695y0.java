package L5;

import I5.l;
import L5.a1;
import M5.n;
import R5.InterfaceC0845b;
import R5.InterfaceC0848e;
import R5.InterfaceC0856m;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;
import y6.AbstractC2996e;

/* JADX INFO: renamed from: L5.y0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0695y0 implements I5.l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f5257f = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(C0695y0.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(C0695y0.class, "annotations", "getAnnotations()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f5258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l.a f5260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a1.a f5261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a1.a f5262e;

    /* JADX INFO: renamed from: L5.y0$a */
    public static final class a implements Type {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type[] f5263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5264b;

        public a(Type[] types) {
            AbstractC2304t.f(types, "types");
            this.f5263a = types;
            this.f5264b = Arrays.hashCode(types);
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && Arrays.equals(this.f5263a, ((a) obj).f5263a);
        }

        @Override // java.lang.reflect.Type
        public String getTypeName() {
            return AbstractC2592n.U(this.f5263a, ", ", "[", "]", 0, null, null, 56, null);
        }

        public int hashCode() {
            return this.f5264b;
        }

        public String toString() {
            return getTypeName();
        }
    }

    public C0695y0(A callable, int i8, l.a kind, Function0 computeDescriptor) {
        AbstractC2304t.f(callable, "callable");
        AbstractC2304t.f(kind, "kind");
        AbstractC2304t.f(computeDescriptor, "computeDescriptor");
        this.f5258a = callable;
        this.f5259b = i8;
        this.f5260c = kind;
        this.f5261d = a1.c(computeDescriptor);
        this.f5262e = a1.c(new C0691w0(this));
    }

    public static final Type e(C0695y0 c0695y0) {
        List listX0;
        R5.W wU = c0695y0.u();
        if ((wU instanceof R5.c0) && AbstractC2304t.b(j1.i(c0695y0.f5258a.X()), wU) && c0695y0.f5258a.X().i() == InterfaceC0845b.a.FAKE_OVERRIDE) {
            InterfaceC0856m interfaceC0856mB = c0695y0.f5258a.X().b();
            AbstractC2304t.d(interfaceC0856mB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Class clsQ = j1.q((InterfaceC0848e) interfaceC0856mB);
            if (clsQ != null) {
                return clsQ;
            }
            throw new Y0("Cannot determine receiver Java type of inherited declaration: " + wU);
        }
        M5.h hVarP = c0695y0.f5258a.P();
        if (!(hVarP instanceof M5.n)) {
            if (!(hVarP instanceof n.b)) {
                return (Type) hVarP.a().get(c0695y0.g());
            }
            Class[] clsArr = (Class[]) ((Collection) ((n.b) hVarP).e().get(c0695y0.g())).toArray(new Class[0]);
            return c0695y0.p((Type[]) Arrays.copyOf(clsArr, clsArr.length));
        }
        M5.n nVar = (M5.n) hVarP;
        if (c0695y0.f5258a.V()) {
            H5.d dVarF = nVar.f(c0695y0.g() + 1);
            int iF = nVar.f(0).f() + 1;
            listX0 = p5.z.x0(nVar.a(), new H5.d(dVarF.e() - iF, dVarF.f() - iF));
        } else {
            listX0 = p5.z.x0(nVar.a(), nVar.f(c0695y0.g()));
        }
        Type[] typeArr = (Type[]) listX0.toArray(new Type[0]);
        return c0695y0.p((Type[]) Arrays.copyOf(typeArr, typeArr.length));
    }

    public static final List n(C0695y0 c0695y0) {
        return j1.e(c0695y0.u());
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0695y0) {
            C0695y0 c0695y0 = (C0695y0) obj;
            if (AbstractC2304t.b(this.f5258a, c0695y0.f5258a) && g() == c0695y0.g()) {
                return true;
            }
        }
        return false;
    }

    @Override // I5.l
    public int g() {
        return this.f5259b;
    }

    @Override // I5.l
    public String getName() {
        R5.W wU = u();
        R5.t0 t0Var = wU instanceof R5.t0 ? (R5.t0) wU : null;
        if (t0Var == null || t0Var.b().G()) {
            return null;
        }
        q6.f name = t0Var.getName();
        AbstractC2304t.e(name, "getName(...)");
        if (name.m()) {
            return null;
        }
        return name.b();
    }

    @Override // I5.l
    public I5.q getType() {
        I6.S type = u().getType();
        AbstractC2304t.e(type, "getType(...)");
        return new U0(type, new C0693x0(this));
    }

    public int hashCode() {
        return (this.f5258a.hashCode() * 31) + Integer.hashCode(g());
    }

    @Override // I5.l
    public l.a i() {
        return this.f5260c;
    }

    @Override // I5.l
    public boolean j() {
        R5.W wU = u();
        return (wU instanceof R5.t0) && ((R5.t0) wU).k0() != null;
    }

    @Override // I5.l
    public boolean k() {
        R5.W wU = u();
        R5.t0 t0Var = wU instanceof R5.t0 ? (R5.t0) wU : null;
        if (t0Var != null) {
            return AbstractC2996e.f(t0Var);
        }
        return false;
    }

    public final Type p(Type... typeArr) {
        int length = typeArr.length;
        if (length != 0) {
            return length != 1 ? new a(typeArr) : (Type) AbstractC2592n.Y(typeArr);
        }
        throw new A5.b("Expected at least 1 type for compound type");
    }

    public final A t() {
        return this.f5258a;
    }

    public String toString() {
        return e1.f5164a.j(this);
    }

    public final R5.W u() {
        Object objB = this.f5261d.b(this, f5257f[0]);
        AbstractC2304t.e(objB, "getValue(...)");
        return (R5.W) objB;
    }
}
