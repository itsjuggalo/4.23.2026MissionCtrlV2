package le;

import fe.v1;
import fe.w1;
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
import kotlin.jvm.internal.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends u implements j, a0, ve.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f15637a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a extends kotlin.jvm.internal.q implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15638a = new a();

        public a() {
            super(1, Member.class, "isSynthetic", "isSynthetic()Z", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Member p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return Boolean.valueOf(p02.isSynthetic());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b extends kotlin.jvm.internal.q implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f15639a = new b();

        public b() {
            super(1, t.class, "<init>", "<init>(Ljava/lang/reflect/Constructor;)V", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final t invoke(Constructor p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return new t(p02);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class c extends kotlin.jvm.internal.q implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f15640a = new c();

        public c() {
            super(1, Member.class, "isSynthetic", "isSynthetic()Z", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Member p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return Boolean.valueOf(p02.isSynthetic());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class d extends kotlin.jvm.internal.q implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f15641a = new d();

        public d() {
            super(1, w.class, "<init>", "<init>(Ljava/lang/reflect/Field;)V", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final w invoke(Field p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return new w(p02);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class e extends kotlin.jvm.internal.q implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f15642a = new e();

        public e() {
            super(1, z.class, "<init>", "<init>(Ljava/lang/reflect/Method;)V", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final z invoke(Method p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return new z(p02);
        }
    }

    public q(Class klass) {
        kotlin.jvm.internal.t.f(klass, "klass");
        this.f15637a = klass;
    }

    public static final boolean Q(Class cls) {
        String simpleName = cls.getSimpleName();
        kotlin.jvm.internal.t.e(simpleName, "getSimpleName(...)");
        return simpleName.length() == 0;
    }

    public static final ef.f R(Class cls) {
        String simpleName = cls.getSimpleName();
        if (!ef.f.m(simpleName)) {
            simpleName = null;
        }
        if (simpleName != null) {
            return ef.f.k(simpleName);
        }
        return null;
    }

    public static final boolean S(q qVar, Method method) {
        if (method.isSynthetic()) {
            return false;
        }
        if (!qVar.A()) {
            return true;
        }
        kotlin.jvm.internal.t.c(method);
        return !qVar.c0(method);
    }

    @Override // ve.g
    public boolean A() {
        return this.f15637a.isEnum();
    }

    @Override // ve.g
    public boolean D() throws IllegalAccessException, InvocationTargetException {
        Boolean boolF = le.b.f15595a.f(this.f15637a);
        if (boolF != null) {
            return boolF.booleanValue();
        }
        return false;
    }

    @Override // ve.g
    public boolean G() {
        return this.f15637a.isInterface();
    }

    @Override // ve.g
    public ve.d0 H() {
        return null;
    }

    @Override // ve.g
    public jg.h M() throws IllegalAccessException, InvocationTargetException {
        Class[] clsArrC = le.b.f15595a.c(this.f15637a);
        if (clsArrC != null) {
            ArrayList arrayList = new ArrayList(clsArrC.length);
            for (Class cls : clsArrC) {
                arrayList.add(new s(cls));
            }
            jg.h hVarQ = dd.a0.Q(arrayList);
            if (hVarQ != null) {
                return hVarQ;
            }
        }
        return jg.q.i();
    }

    @Override // ve.s
    public boolean P() {
        return Modifier.isStatic(getModifiers());
    }

    @Override // ve.g
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public List m() {
        Constructor<?>[] declaredConstructors = this.f15637a.getDeclaredConstructors();
        kotlin.jvm.internal.t.e(declaredConstructors, "getDeclaredConstructors(...)");
        return jg.t.M(jg.t.E(jg.t.y(dd.n.t(declaredConstructors), a.f15638a), b.f15639a));
    }

    @Override // le.j
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public Class v() {
        return this.f15637a;
    }

    @Override // ve.g
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public List C() {
        Field[] declaredFields = this.f15637a.getDeclaredFields();
        kotlin.jvm.internal.t.e(declaredFields, "getDeclaredFields(...)");
        return jg.t.M(jg.t.E(jg.t.y(dd.n.t(declaredFields), c.f15640a), d.f15641a));
    }

    @Override // ve.g
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public List J() {
        Class<?>[] declaredClasses = this.f15637a.getDeclaredClasses();
        kotlin.jvm.internal.t.e(declaredClasses, "getDeclaredClasses(...)");
        return jg.t.M(jg.t.F(jg.t.y(dd.n.t(declaredClasses), n.f15634a), o.f15635a));
    }

    @Override // ve.g
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public List L() {
        Method[] declaredMethods = this.f15637a.getDeclaredMethods();
        kotlin.jvm.internal.t.e(declaredMethods, "getDeclaredMethods(...)");
        return jg.t.M(jg.t.E(jg.t.x(dd.n.t(declaredMethods), new p(this)), e.f15642a));
    }

    @Override // ve.d
    public /* bridge */ /* synthetic */ ve.a b(ef.c cVar) {
        return b(cVar);
    }

    @Override // ve.g
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public q k() {
        Class<?> declaringClass = this.f15637a.getDeclaringClass();
        if (declaringClass != null) {
            return new q(declaringClass);
        }
        return null;
    }

    @Override // ve.g
    public Collection c() {
        Class cls;
        cls = Object.class;
        if (kotlin.jvm.internal.t.b(this.f15637a, cls)) {
            return dd.r.k();
        }
        r0 r0Var = new r0(2);
        Type genericSuperclass = this.f15637a.getGenericSuperclass();
        r0Var.a(genericSuperclass != null ? genericSuperclass : Object.class);
        r0Var.b(this.f15637a.getGenericInterfaces());
        List listN = dd.r.n(r0Var.d(new Type[r0Var.c()]));
        ArrayList arrayList = new ArrayList(dd.s.u(listN, 10));
        Iterator it = listN.iterator();
        while (it.hasNext()) {
            arrayList.add(new s((Type) it.next()));
        }
        return arrayList;
    }

    public final boolean c0(Method method) {
        String name = method.getName();
        if (kotlin.jvm.internal.t.b(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            kotlin.jvm.internal.t.e(parameterTypes, "getParameterTypes(...)");
            return parameterTypes.length == 0;
        }
        if (kotlin.jvm.internal.t.b(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    @Override // ve.g
    public ef.c e() {
        return f.e(this.f15637a).a();
    }

    public boolean equals(Object obj) {
        return (obj instanceof q) && kotlin.jvm.internal.t.b(this.f15637a, ((q) obj).f15637a);
    }

    @Override // ve.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // le.a0
    public int getModifiers() {
        return this.f15637a.getModifiers();
    }

    @Override // ve.t
    public ef.f getName() {
        if (!this.f15637a.isAnonymousClass()) {
            ef.f fVarK = ef.f.k(this.f15637a.getSimpleName());
            kotlin.jvm.internal.t.c(fVarK);
            return fVarK;
        }
        String name = this.f15637a.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        ef.f fVarK2 = ef.f.k(kg.c0.T0(name, ".", null, 2, null));
        kotlin.jvm.internal.t.c(fVarK2);
        return fVarK2;
    }

    @Override // ve.z
    public List getTypeParameters() {
        TypeVariable[] typeParameters = this.f15637a.getTypeParameters();
        kotlin.jvm.internal.t.e(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable typeVariable : typeParameters) {
            arrayList.add(new f0(typeVariable));
        }
        return arrayList;
    }

    @Override // ve.s
    public w1 getVisibility() {
        int modifiers = getModifiers();
        return Modifier.isPublic(modifiers) ? v1.h.f9535c : Modifier.isPrivate(modifiers) ? v1.e.f9532c : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? je.c.f14313c : je.b.f14312c : je.a.f14311c;
    }

    public int hashCode() {
        return this.f15637a.hashCode();
    }

    @Override // ve.s
    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // ve.s
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    @Override // ve.g
    public Collection l() {
        Object[] objArrD = le.b.f15595a.d(this.f15637a);
        if (objArrD == null) {
            objArrD = new Object[0];
        }
        ArrayList arrayList = new ArrayList(objArrD.length);
        for (Object obj : objArrD) {
            arrayList.add(new d0(obj));
        }
        return arrayList;
    }

    @Override // ve.d
    public boolean n() {
        return false;
    }

    @Override // ve.g
    public boolean q() {
        return this.f15637a.isAnnotation();
    }

    @Override // ve.g
    public boolean s() throws IllegalAccessException, InvocationTargetException {
        Boolean boolE = le.b.f15595a.e(this.f15637a);
        if (boolE != null) {
            return boolE.booleanValue();
        }
        return false;
    }

    @Override // ve.g
    public boolean t() {
        return false;
    }

    public String toString() {
        return q.class.getName() + ": " + this.f15637a;
    }

    @Override // le.j, ve.d
    public g b(ef.c fqName) {
        Annotation[] declaredAnnotations;
        kotlin.jvm.internal.t.f(fqName, "fqName");
        AnnotatedElement annotatedElementV = v();
        if (annotatedElementV == null || (declaredAnnotations = annotatedElementV.getDeclaredAnnotations()) == null) {
            return null;
        }
        return k.a(declaredAnnotations, fqName);
    }

    @Override // le.j, ve.d
    public List getAnnotations() {
        Annotation[] declaredAnnotations;
        List listB;
        AnnotatedElement annotatedElementV = v();
        return (annotatedElementV == null || (declaredAnnotations = annotatedElementV.getDeclaredAnnotations()) == null || (listB = k.b(declaredAnnotations)) == null) ? dd.r.k() : listB;
    }
}
