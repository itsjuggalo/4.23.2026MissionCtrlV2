package L5;

import I5.i;
import I5.m;
import L5.AbstractC0677p;
import L5.a1;
import R5.InterfaceC0848e;
import R5.InterfaceC0856m;
import S5.h;
import a6.AbstractC1092o;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.AbstractC2291f;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.C2487o;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import o6.AbstractC2492a;
import p6.AbstractC2601d;
import p6.C2606i;
import u6.AbstractC2793h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class K0 extends A implements I5.m {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f5060m = new b(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f5061n = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AbstractC0654d0 f5062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f5063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f5064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f5065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final InterfaceC2483k f5066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a1.a f5067l;

    public static abstract class a extends A implements I5.h, m.a {
        @Override // L5.A
        public AbstractC0654d0 Q() {
            return m().Q();
        }

        @Override // L5.A
        public M5.h R() {
            return null;
        }

        @Override // L5.A
        public boolean V() {
            return m().V();
        }

        public abstract R5.Y X();

        /* JADX INFO: renamed from: Y */
        public abstract K0 m();

        @Override // I5.h
        public boolean isExternal() {
            return X().isExternal();
        }

        @Override // I5.h
        public boolean isInfix() {
            return X().isInfix();
        }

        @Override // I5.h
        public boolean isInline() {
            return X().isInline();
        }

        @Override // I5.h
        public boolean isOperator() {
            return X().isOperator();
        }

        @Override // I5.c
        public boolean isSuspend() {
            return X().isSuspend();
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static abstract class c extends a implements m.b {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ I5.m[] f5068i = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(c.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", 0))};

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a1.a f5069g = a1.c(new L0(this));

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final InterfaceC2483k f5070h = AbstractC2484l.b(EnumC2486n.f21975b, new M0(this));

        public static final M5.h b0(c cVar) {
            return P0.b(cVar, true);
        }

        public static final R5.a0 c0(c cVar) {
            R5.a0 a0VarD = cVar.m().X().d();
            if (a0VarD != null) {
                return a0VarD;
            }
            U5.L lD = AbstractC2793h.d(cVar.m().X(), S5.h.f7663J.b());
            AbstractC2304t.e(lD, "createDefaultGetter(...)");
            return lD;
        }

        @Override // L5.A
        public M5.h P() {
            return (M5.h) this.f5070h.getValue();
        }

        @Override // L5.K0.a
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public R5.a0 X() {
            Object objB = this.f5069g.b(this, f5068i[0]);
            AbstractC2304t.e(objB, "getValue(...)");
            return (R5.a0) objB;
        }

        public boolean equals(Object obj) {
            return (obj instanceof c) && AbstractC2304t.b(m(), ((c) obj).m());
        }

        @Override // I5.c
        public String getName() {
            return "<get-" + m().getName() + '>';
        }

        public int hashCode() {
            return m().hashCode();
        }

        public String toString() {
            return "getter of " + m();
        }
    }

    public static abstract class d extends a implements i.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ I5.m[] f5071i = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(d.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", 0))};

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a1.a f5072g = a1.c(new N0(this));

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final InterfaceC2483k f5073h = AbstractC2484l.b(EnumC2486n.f21975b, new O0(this));

        public static final M5.h b0(d dVar) {
            return P0.b(dVar, false);
        }

        public static final R5.b0 c0(d dVar) {
            R5.b0 b0VarH = dVar.m().X().h();
            if (b0VarH != null) {
                return b0VarH;
            }
            R5.Z zX = dVar.m().X();
            h.a aVar = S5.h.f7663J;
            U5.M mE = AbstractC2793h.e(zX, aVar.b(), aVar.b());
            AbstractC2304t.e(mE, "createDefaultSetter(...)");
            return mE;
        }

        @Override // L5.A
        public M5.h P() {
            return (M5.h) this.f5073h.getValue();
        }

        @Override // L5.K0.a
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public R5.b0 X() {
            Object objB = this.f5072g.b(this, f5071i[0]);
            AbstractC2304t.e(objB, "getValue(...)");
            return (R5.b0) objB;
        }

        public boolean equals(Object obj) {
            return (obj instanceof d) && AbstractC2304t.b(m(), ((d) obj).m());
        }

        @Override // I5.c
        public String getName() {
            return "<set-" + m().getName() + '>';
        }

        public int hashCode() {
            return m().hashCode();
        }

        public String toString() {
            return "setter of " + m();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public K0(AbstractC0654d0 container, R5.Z descriptor) {
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(descriptor, "descriptor");
        String strB = descriptor.getName().b();
        AbstractC2304t.e(strB, "asString(...)");
        this(container, strB, f1.f5170a.f(descriptor).a(), descriptor, AbstractC2291f.NO_RECEIVER);
    }

    public static final R5.Z X(K0 k02) {
        return k02.Q().C(k02.getName(), k02.f5064i);
    }

    public static final Field Y(K0 k02) {
        Class<?> enclosingClass;
        AbstractC0677p abstractC0677pF = f1.f5170a.f(k02.X());
        if (!(abstractC0677pF instanceof AbstractC0677p.c)) {
            if (abstractC0677pF instanceof AbstractC0677p.a) {
                return ((AbstractC0677p.a) abstractC0677pF).b();
            }
            if ((abstractC0677pF instanceof AbstractC0677p.b) || (abstractC0677pF instanceof AbstractC0677p.d)) {
                return null;
            }
            throw new C2487o();
        }
        AbstractC0677p.c cVar = (AbstractC0677p.c) abstractC0677pF;
        R5.Z zB = cVar.b();
        AbstractC2601d.a aVarD = C2606i.d(C2606i.f22422a, cVar.e(), cVar.d(), cVar.g(), false, 8, null);
        if (aVarD == null) {
            return null;
        }
        if (AbstractC1092o.e(zB) || C2606i.f(cVar.e())) {
            enclosingClass = k02.Q().e().getEnclosingClass();
        } else {
            InterfaceC0856m interfaceC0856mB = zB.b();
            enclosingClass = interfaceC0856mB instanceof InterfaceC0848e ? j1.q((InterfaceC0848e) interfaceC0856mB) : k02.Q().e();
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

    @Override // L5.A
    public M5.h P() {
        return f0().P();
    }

    @Override // L5.A
    public AbstractC0654d0 Q() {
        return this.f5062g;
    }

    @Override // L5.A
    public M5.h R() {
        return f0().R();
    }

    @Override // L5.A
    public boolean V() {
        return this.f5065j != AbstractC2291f.NO_RECEIVER;
    }

    public final Member b0() {
        if (!X().O()) {
            return null;
        }
        AbstractC0677p abstractC0677pF = f1.f5170a.f(X());
        if (abstractC0677pF instanceof AbstractC0677p.c) {
            AbstractC0677p.c cVar = (AbstractC0677p.c) abstractC0677pF;
            if (cVar.f().F()) {
                AbstractC2492a.c cVarA = cVar.f().A();
                if (!cVarA.A() || !cVarA.z()) {
                    return null;
                }
                return Q().B(cVar.d().b(cVarA.y()), cVar.d().b(cVarA.x()));
            }
        }
        return g0();
    }

    public final Object c0() {
        return M5.o.h(this.f5065j, X());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object d0(Member member, Object obj, Object obj2) throws J5.b {
        try {
            Object obj3 = f5061n;
            if ((obj == obj3 || obj2 == obj3) && X().l0() == null) {
                throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            Object objC0 = V() ? c0() : obj;
            if (objC0 == obj3) {
                objC0 = null;
            }
            if (!V()) {
                obj = obj2;
            }
            if (obj == obj3) {
                obj = null;
            }
            AccessibleObject accessibleObject = member instanceof AccessibleObject ? (AccessibleObject) member : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(K5.a.a(this));
            }
            if (member == 0) {
                return null;
            }
            if (member instanceof Field) {
                return ((Field) member).get(objC0);
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
                if (objC0 == null) {
                    Class<?> cls = ((Method) member).getParameterTypes()[0];
                    AbstractC2304t.e(cls, "get(...)");
                    objC0 = j1.g(cls);
                }
                return method.invoke(null, objC0);
            }
            if (length != 2) {
                throw new AssertionError("delegate method " + member + " should take 0, 1, or 2 parameters");
            }
            Method method2 = (Method) member;
            if (obj == null) {
                Class<?> cls2 = ((Method) member).getParameterTypes()[1];
                AbstractC2304t.e(cls2, "get(...)");
                obj = j1.g(cls2);
            }
            return method2.invoke(null, objC0, obj);
        } catch (IllegalAccessException e8) {
            throw new J5.b(e8);
        }
    }

    @Override // L5.A
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public R5.Z X() {
        Object objInvoke = this.f5067l.invoke();
        AbstractC2304t.e(objInvoke, "invoke(...)");
        return (R5.Z) objInvoke;
    }

    public boolean equals(Object obj) {
        K0 k0D = j1.d(obj);
        return k0D != null && AbstractC2304t.b(Q(), k0D.Q()) && AbstractC2304t.b(getName(), k0D.getName()) && AbstractC2304t.b(this.f5064i, k0D.f5064i) && AbstractC2304t.b(this.f5065j, k0D.f5065j);
    }

    public abstract c f0();

    public final Field g0() {
        return (Field) this.f5066k.getValue();
    }

    @Override // I5.c
    public String getName() {
        return this.f5063h;
    }

    public final String h0() {
        return this.f5064i;
    }

    public int hashCode() {
        return (((Q().hashCode() * 31) + getName().hashCode()) * 31) + this.f5064i.hashCode();
    }

    @Override // I5.c
    public boolean isSuspend() {
        return false;
    }

    public String toString() {
        return e1.f5164a.k(X());
    }

    public K0(AbstractC0654d0 abstractC0654d0, String str, String str2, R5.Z z7, Object obj) {
        this.f5062g = abstractC0654d0;
        this.f5063h = str;
        this.f5064i = str2;
        this.f5065j = obj;
        this.f5066k = AbstractC2484l.b(EnumC2486n.f21975b, new I0(this));
        a1.a aVarB = a1.b(z7, new J0(this));
        AbstractC2304t.e(aVarB, "lazySoft(...)");
        this.f5067l = aVarB;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public K0(AbstractC0654d0 container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(signature, "signature");
    }
}
