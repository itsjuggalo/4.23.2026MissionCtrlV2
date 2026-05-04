package zd;

import cf.a;
import df.d;
import ge.h;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import wd.i;
import wd.m;
import zd.p;
import zd.z2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j2 extends a0 implements wd.m {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f25754m = new b(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f25755n = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c1 f25756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f25757h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f25758i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f25759j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final cd.k f25760k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final z2.a f25761l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a extends a0 implements wd.h, m.a {
        @Override // zd.a0
        public c1 P() {
            return o().P();
        }

        @Override // zd.a0
        public ae.h Q() {
            return null;
        }

        @Override // zd.a0
        public boolean U() {
            return o().U();
        }

        public abstract fe.x0 W();

        /* JADX INFO: renamed from: X */
        public abstract j2 o();

        @Override // wd.h
        public boolean isExternal() {
            return W().isExternal();
        }

        @Override // wd.h
        public boolean isInfix() {
            return W().isInfix();
        }

        @Override // wd.h
        public boolean isInline() {
            return W().isInline();
        }

        @Override // wd.h
        public boolean isOperator() {
            return W().isOperator();
        }

        @Override // wd.c, wd.h
        public boolean isSuspend() {
            return W().isSuspend();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class c extends a implements m.b {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ wd.m[] f25762i = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(c.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", 0))};

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final z2.a f25763g = z2.c(new k2(this));

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final cd.k f25764h = cd.l.a(cd.n.f3864b, new l2(this));

        public static final ae.h a0(c cVar) {
            return o2.b(cVar, true);
        }

        public static final fe.z0 b0(c cVar) {
            fe.z0 z0VarD = cVar.o().W().d();
            if (z0VarD != null) {
                return z0VarD;
            }
            ie.l0 l0VarD = jf.h.d(cVar.o().W(), ge.h.L.b());
            kotlin.jvm.internal.t.e(l0VarD, "createDefaultGetter(...)");
            return l0VarD;
        }

        @Override // zd.a0
        public ae.h O() {
            return (ae.h) this.f25764h.getValue();
        }

        @Override // zd.j2.a
        /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public fe.z0 W() {
            Object objB = this.f25763g.b(this, f25762i[0]);
            kotlin.jvm.internal.t.e(objB, "getValue(...)");
            return (fe.z0) objB;
        }

        public boolean equals(Object obj) {
            return (obj instanceof c) && kotlin.jvm.internal.t.b(o(), ((c) obj).o());
        }

        @Override // wd.c
        public String getName() {
            return "<get-" + o().getName() + '>';
        }

        public int hashCode() {
            return o().hashCode();
        }

        public String toString() {
            return "getter of " + o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class d extends a implements i.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ wd.m[] f25765i = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(d.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", 0))};

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final z2.a f25766g = z2.c(new m2(this));

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final cd.k f25767h = cd.l.a(cd.n.f3864b, new n2(this));

        public static final ae.h a0(d dVar) {
            return o2.b(dVar, false);
        }

        public static final fe.a1 b0(d dVar) {
            fe.a1 a1VarG = dVar.o().W().g();
            if (a1VarG != null) {
                return a1VarG;
            }
            fe.y0 y0VarW = dVar.o().W();
            h.a aVar = ge.h.L;
            ie.m0 m0VarE = jf.h.e(y0VarW, aVar.b(), aVar.b());
            kotlin.jvm.internal.t.e(m0VarE, "createDefaultSetter(...)");
            return m0VarE;
        }

        @Override // zd.a0
        public ae.h O() {
            return (ae.h) this.f25767h.getValue();
        }

        @Override // zd.j2.a
        /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
        public fe.a1 W() {
            Object objB = this.f25766g.b(this, f25765i[0]);
            kotlin.jvm.internal.t.e(objB, "getValue(...)");
            return (fe.a1) objB;
        }

        public boolean equals(Object obj) {
            return (obj instanceof d) && kotlin.jvm.internal.t.b(o(), ((d) obj).o());
        }

        @Override // wd.c
        public String getName() {
            return "<set-" + o().getName() + '>';
        }

        public int hashCode() {
            return o().hashCode();
        }

        public String toString() {
            return "setter of " + o();
        }
    }

    public j2(c1 c1Var, String str, String str2, fe.y0 y0Var, Object obj) {
        this.f25756g = c1Var;
        this.f25757h = str;
        this.f25758i = str2;
        this.f25759j = obj;
        this.f25760k = cd.l.a(cd.n.f3864b, new h2(this));
        z2.a aVarB = z2.b(y0Var, new i2(this));
        kotlin.jvm.internal.t.e(aVarB, "lazySoft(...)");
        this.f25761l = aVarB;
    }

    public static final fe.y0 W(j2 j2Var) {
        return j2Var.P().B(j2Var.getName(), j2Var.f25758i);
    }

    public static final Field X(j2 j2Var) {
        Class<?> enclosingClass;
        p pVarF = e3.f25716a.f(j2Var.W());
        if (!(pVarF instanceof p.c)) {
            if (pVarF instanceof p.a) {
                return ((p.a) pVarF).b();
            }
            if ((pVarF instanceof p.b) || (pVarF instanceof p.d)) {
                return null;
            }
            throw new cd.o();
        }
        p.c cVar = (p.c) pVarF;
        fe.y0 y0VarB = cVar.b();
        d.a aVarD = df.i.d(df.i.f8111a, cVar.e(), cVar.d(), cVar.g(), false, 8, null);
        if (aVarD == null) {
            return null;
        }
        if (oe.o.e(y0VarB) || df.i.f(cVar.e())) {
            enclosingClass = j2Var.P().e().getEnclosingClass();
        } else {
            fe.m mVarB = y0VarB.b();
            enclosingClass = mVarB instanceof fe.e ? i3.q((fe.e) mVarB) : j2Var.P().e();
        }
        if (enclosingClass == null) {
            return null;
        }
        try {
            return enclosingClass.getDeclaredField(aVarD.e());
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    @Override // zd.a0
    public ae.h O() {
        return e0().O();
    }

    @Override // zd.a0
    public c1 P() {
        return this.f25756g;
    }

    @Override // zd.a0
    public ae.h Q() {
        return e0().Q();
    }

    @Override // zd.a0
    public boolean U() {
        return this.f25759j != kotlin.jvm.internal.f.NO_RECEIVER;
    }

    public final Member a0() {
        if (!W().Q()) {
            return null;
        }
        p pVarF = e3.f25716a.f(W());
        if (pVarF instanceof p.c) {
            p.c cVar = (p.c) pVarF;
            if (cVar.f().E()) {
                a.c cVarZ = cVar.f().z();
                if (!cVarZ.z() || !cVarZ.y()) {
                    return null;
                }
                return P().A(cVar.d().getString(cVarZ.x()), cVar.d().getString(cVarZ.w()));
            }
        }
        return f0();
    }

    public final Object b0() {
        return ae.o.h(this.f25759j, W());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c0(Member member, Object obj, Object obj2) throws xd.b {
        try {
            Object obj3 = f25755n;
            if ((obj == obj3 || obj2 == obj3) && W().k0() == null) {
                throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            Object objB0 = U() ? b0() : obj;
            if (objB0 == obj3) {
                objB0 = null;
            }
            if (!U()) {
                obj = obj2;
            }
            if (obj == obj3) {
                obj = null;
            }
            AccessibleObject accessibleObject = member instanceof AccessibleObject ? (AccessibleObject) member : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(yd.a.a(this));
            }
            if (member == 0) {
                return null;
            }
            if (member instanceof Field) {
                return ((Field) member).get(objB0);
            }
            if (!(member instanceof Method)) {
                throw new AssertionError("delegate field/method " + member + " neither field nor method");
            }
            int length = ((Method) member).getParameterTypes().length;
            if (length == 0) {
                return ((Method) member).invoke(null, null);
            }
            if (length == 1) {
                Method method = (Method) member;
                if (objB0 == null) {
                    Class<?> cls = ((Method) member).getParameterTypes()[0];
                    kotlin.jvm.internal.t.e(cls, "get(...)");
                    objB0 = i3.g(cls);
                }
                return method.invoke(null, objB0);
            }
            if (length != 2) {
                throw new AssertionError("delegate method " + member + " should take 0, 1, or 2 parameters");
            }
            Method method2 = (Method) member;
            if (obj == null) {
                Class<?> cls2 = ((Method) member).getParameterTypes()[1];
                kotlin.jvm.internal.t.e(cls2, "get(...)");
                obj = i3.g(cls2);
            }
            return method2.invoke(null, objB0, obj);
        } catch (IllegalAccessException e10) {
            throw new xd.b(e10);
        }
    }

    @Override // zd.a0
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public fe.y0 W() {
        Object objInvoke = this.f25761l.invoke();
        kotlin.jvm.internal.t.e(objInvoke, "invoke(...)");
        return (fe.y0) objInvoke;
    }

    public abstract c e0();

    public boolean equals(Object obj) {
        j2 j2VarD = i3.d(obj);
        return j2VarD != null && kotlin.jvm.internal.t.b(P(), j2VarD.P()) && kotlin.jvm.internal.t.b(getName(), j2VarD.getName()) && kotlin.jvm.internal.t.b(this.f25758i, j2VarD.f25758i) && kotlin.jvm.internal.t.b(this.f25759j, j2VarD.f25759j);
    }

    public final Field f0() {
        return (Field) this.f25760k.getValue();
    }

    public final String g0() {
        return this.f25758i;
    }

    @Override // wd.c
    public String getName() {
        return this.f25757h;
    }

    public int hashCode() {
        return (((P().hashCode() * 31) + getName().hashCode()) * 31) + this.f25758i.hashCode();
    }

    @Override // wd.c, wd.h
    public boolean isSuspend() {
        return false;
    }

    public String toString() {
        return d3.f25708a.k(W());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j2(c1 container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public j2(c1 container, fe.y0 descriptor) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        String strB = descriptor.getName().b();
        kotlin.jvm.internal.t.e(strB, "asString(...)");
        this(container, strB, e3.f25716a.f(descriptor).a(), descriptor, kotlin.jvm.internal.f.NO_RECEIVER);
    }
}
