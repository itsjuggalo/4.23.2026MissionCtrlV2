package X5;

import R5.w0;
import R5.x0;
import h6.EnumC1891D;
import h6.InterfaceC1892a;
import h6.InterfaceC1898g;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.T;
import p5.AbstractC2592n;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends u implements j, A, InterfaceC1898g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f9438a;

    public /* synthetic */ class a extends AbstractC2302q implements B5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9439a = new a();

        public a() {
            super(1, Member.class, "isSynthetic", "isSynthetic()Z", 0);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Member p02) {
            AbstractC2304t.f(p02, "p0");
            return Boolean.valueOf(p02.isSynthetic());
        }
    }

    public /* synthetic */ class b extends AbstractC2302q implements B5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9440a = new b();

        public b() {
            super(1, t.class, "<init>", "<init>(Ljava/lang/reflect/Constructor;)V", 0);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final t invoke(Constructor p02) {
            AbstractC2304t.f(p02, "p0");
            return new t(p02);
        }
    }

    public /* synthetic */ class c extends AbstractC2302q implements B5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f9441a = new c();

        public c() {
            super(1, Member.class, "isSynthetic", "isSynthetic()Z", 0);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Member p02) {
            AbstractC2304t.f(p02, "p0");
            return Boolean.valueOf(p02.isSynthetic());
        }
    }

    public /* synthetic */ class d extends AbstractC2302q implements B5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f9442a = new d();

        public d() {
            super(1, w.class, "<init>", "<init>(Ljava/lang/reflect/Field;)V", 0);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final w invoke(Field p02) {
            AbstractC2304t.f(p02, "p0");
            return new w(p02);
        }
    }

    public /* synthetic */ class e extends AbstractC2302q implements B5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f9443a = new e();

        public e() {
            super(1, z.class, "<init>", "<init>(Ljava/lang/reflect/Method;)V", 0);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final z invoke(Method p02) {
            AbstractC2304t.f(p02, "p0");
            return new z(p02);
        }
    }

    public q(Class klass) {
        AbstractC2304t.f(klass, "klass");
        this.f9438a = klass;
    }

    public static final boolean R(Class cls) {
        String simpleName = cls.getSimpleName();
        AbstractC2304t.e(simpleName, "getSimpleName(...)");
        return simpleName.length() == 0;
    }

    public static final q6.f S(Class cls) {
        String simpleName = cls.getSimpleName();
        if (!q6.f.n(simpleName)) {
            simpleName = null;
        }
        if (simpleName != null) {
            return q6.f.l(simpleName);
        }
        return null;
    }

    public static final boolean T(q qVar, Method method) {
        if (method.isSynthetic()) {
            return false;
        }
        if (qVar.z()) {
            AbstractC2304t.c(method);
            if (qVar.d0(method)) {
                return false;
            }
        }
        return true;
    }

    @Override // X5.A
    public int C() {
        return this.f9438a.getModifiers();
    }

    @Override // h6.InterfaceC1898g
    public boolean D() throws IllegalAccessException, InvocationTargetException {
        Boolean boolF = C0986b.f9410a.f(this.f9438a);
        if (boolF != null) {
            return boolF.booleanValue();
        }
        return false;
    }

    @Override // h6.InterfaceC1898g
    public boolean H() {
        return this.f9438a.isInterface();
    }

    @Override // h6.InterfaceC1898g
    public EnumC1891D I() {
        return null;
    }

    @Override // h6.InterfaceC1898g
    public U6.h N() throws IllegalAccessException, InvocationTargetException {
        Class[] clsArrC = C0986b.f9410a.c(this.f9438a);
        if (clsArrC != null) {
            ArrayList arrayList = new ArrayList(clsArrC.length);
            for (Class cls : clsArrC) {
                arrayList.add(new s(cls));
            }
            U6.h hVarP = p5.z.P(arrayList);
            if (hVarP != null) {
                return hVarP;
            }
        }
        return U6.o.g();
    }

    @Override // h6.s
    public boolean Q() {
        return Modifier.isStatic(C());
    }

    @Override // h6.InterfaceC1898g
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public List n() {
        Constructor<?>[] declaredConstructors = this.f9438a.getDeclaredConstructors();
        AbstractC2304t.e(declaredConstructors, "getDeclaredConstructors(...)");
        return U6.r.J(U6.r.B(U6.r.v(AbstractC2592n.t(declaredConstructors), a.f9439a), b.f9440a));
    }

    @Override // X5.j
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public Class u() {
        return this.f9438a;
    }

    @Override // h6.InterfaceC1898g
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public List B() {
        Field[] declaredFields = this.f9438a.getDeclaredFields();
        AbstractC2304t.e(declaredFields, "getDeclaredFields(...)");
        return U6.r.J(U6.r.B(U6.r.v(AbstractC2592n.t(declaredFields), c.f9441a), d.f9442a));
    }

    @Override // h6.InterfaceC1898g
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public List K() {
        Class<?>[] declaredClasses = this.f9438a.getDeclaredClasses();
        AbstractC2304t.e(declaredClasses, "getDeclaredClasses(...)");
        return U6.r.J(U6.r.C(U6.r.v(AbstractC2592n.t(declaredClasses), n.f9435a), o.f9436a));
    }

    @Override // X5.j, h6.InterfaceC1895d
    public C0991g b(q6.c fqName) {
        Annotation[] declaredAnnotations;
        AbstractC2304t.f(fqName, "fqName");
        AnnotatedElement annotatedElementU = u();
        if (annotatedElementU == null || (declaredAnnotations = annotatedElementU.getDeclaredAnnotations()) == null) {
            return null;
        }
        return k.a(declaredAnnotations, fqName);
    }

    @Override // h6.InterfaceC1898g
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public List M() {
        Method[] declaredMethods = this.f9438a.getDeclaredMethods();
        AbstractC2304t.e(declaredMethods, "getDeclaredMethods(...)");
        return U6.r.J(U6.r.B(U6.r.u(AbstractC2592n.t(declaredMethods), new p(this)), e.f9443a));
    }

    @Override // h6.InterfaceC1898g
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public q g() {
        Class<?> declaringClass = this.f9438a.getDeclaringClass();
        if (declaringClass != null) {
            return new q(declaringClass);
        }
        return null;
    }

    public final boolean d0(Method method) {
        String name = method.getName();
        if (AbstractC2304t.b(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            AbstractC2304t.e(parameterTypes, "getParameterTypes(...)");
            return parameterTypes.length == 0;
        }
        if (AbstractC2304t.b(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    @Override // h6.InterfaceC1898g
    public q6.c e() {
        return AbstractC0990f.e(this.f9438a).a();
    }

    public boolean equals(Object obj) {
        return (obj instanceof q) && AbstractC2304t.b(this.f9438a, ((q) obj).f9438a);
    }

    @Override // h6.InterfaceC1895d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // h6.t
    public q6.f getName() {
        String simpleName;
        if (this.f9438a.isAnonymousClass()) {
            String name = this.f9438a.getName();
            AbstractC2304t.e(name, "getName(...)");
            simpleName = V6.C.G0(name, ".", null, 2, null);
        } else {
            simpleName = this.f9438a.getSimpleName();
        }
        q6.f fVarL = q6.f.l(simpleName);
        AbstractC2304t.c(fVarL);
        return fVarL;
    }

    @Override // h6.z
    public List getTypeParameters() {
        TypeVariable[] typeParameters = this.f9438a.getTypeParameters();
        AbstractC2304t.e(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable typeVariable : typeParameters) {
            arrayList.add(new F(typeVariable));
        }
        return arrayList;
    }

    @Override // h6.s
    public x0 getVisibility() {
        int iC = C();
        return Modifier.isPublic(iC) ? w0.h.f7285c : Modifier.isPrivate(iC) ? w0.e.f7282c : Modifier.isProtected(iC) ? Modifier.isStatic(iC) ? V5.c.f8951c : V5.b.f8950c : V5.a.f8949c;
    }

    @Override // h6.InterfaceC1898g
    public Collection h() {
        Object[] objArrD = C0986b.f9410a.d(this.f9438a);
        if (objArrD == null) {
            objArrD = new Object[0];
        }
        ArrayList arrayList = new ArrayList(objArrD.length);
        for (Object obj : objArrD) {
            arrayList.add(new D(obj));
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f9438a.hashCode();
    }

    @Override // h6.InterfaceC1895d
    public boolean i() {
        return false;
    }

    @Override // h6.s
    public boolean isAbstract() {
        return Modifier.isAbstract(C());
    }

    @Override // h6.s
    public boolean isFinal() {
        return Modifier.isFinal(C());
    }

    @Override // h6.InterfaceC1898g
    public boolean o() {
        return this.f9438a.isAnnotation();
    }

    @Override // h6.InterfaceC1898g
    public boolean q() throws IllegalAccessException, InvocationTargetException {
        Boolean boolE = C0986b.f9410a.e(this.f9438a);
        if (boolE != null) {
            return boolE.booleanValue();
        }
        return false;
    }

    @Override // h6.InterfaceC1898g
    public Collection r() {
        Class cls;
        cls = Object.class;
        if (AbstractC2304t.b(this.f9438a, cls)) {
            return AbstractC2595q.i();
        }
        T t8 = new T(2);
        Type genericSuperclass = this.f9438a.getGenericSuperclass();
        t8.a(genericSuperclass != null ? genericSuperclass : Object.class);
        t8.b(this.f9438a.getGenericInterfaces());
        List listL = AbstractC2595q.l(t8.d(new Type[t8.c()]));
        ArrayList arrayList = new ArrayList(p5.r.s(listL, 10));
        Iterator it = listL.iterator();
        while (it.hasNext()) {
            arrayList.add(new s((Type) it.next()));
        }
        return arrayList;
    }

    @Override // h6.InterfaceC1898g
    public boolean s() {
        return false;
    }

    public String toString() {
        return q.class.getName() + ": " + this.f9438a;
    }

    @Override // h6.InterfaceC1898g
    public boolean z() {
        return this.f9438a.isEnum();
    }

    @Override // h6.InterfaceC1895d
    public /* bridge */ /* synthetic */ InterfaceC1892a b(q6.c cVar) {
        return b(cVar);
    }

    @Override // X5.j, h6.InterfaceC1895d
    public List getAnnotations() {
        Annotation[] declaredAnnotations;
        List listB;
        AnnotatedElement annotatedElementU = u();
        return (annotatedElementU == null || (declaredAnnotations = annotatedElementU.getDeclaredAnnotations()) == null || (listB = k.b(declaredAnnotations)) == null) ? AbstractC2595q.i() : listB;
    }
}
