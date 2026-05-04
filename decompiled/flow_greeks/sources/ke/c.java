package ke;

import ce.o;
import dd.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import xe.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14829a = new c();

    public final lf.f a(Class cls) {
        int i10 = 0;
        while (cls.isArray()) {
            i10++;
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            if (t.b(cls, Void.TYPE)) {
                return new lf.f(ef.b.f8779d.c(o.a.f3983f.m()), i10);
            }
            ce.l lVarK = of.e.c(cls.getName()).k();
            t.e(lVarK, "getPrimitiveType(...)");
            return i10 > 0 ? new lf.f(ef.b.f8779d.c(lVarK.i()), i10 - 1) : new lf.f(ef.b.f8779d.c(lVarK.l()), i10);
        }
        ef.b bVarE = le.f.e(cls);
        ef.b bVarM = ee.c.f8681a.m(bVarE.a());
        if (bVarM != null) {
            bVarE = bVarM;
        }
        return new lf.f(bVarE, i10);
    }

    public final void b(Class klass, x.c visitor) {
        t.f(klass, "klass");
        t.f(visitor, "visitor");
        Iterator itA = kotlin.jvm.internal.c.a(klass.getDeclaredAnnotations());
        while (itA.hasNext()) {
            Annotation annotation = (Annotation) itA.next();
            t.c(annotation);
            f(visitor, annotation);
        }
        visitor.a();
    }

    public final void c(Class cls, x.d dVar) throws InvocationTargetException {
        Iterator itA = kotlin.jvm.internal.c.a(cls.getDeclaredConstructors());
        while (itA.hasNext()) {
            Constructor constructor = (Constructor) itA.next();
            ef.f fVar = ef.h.f8809j;
            m mVar = m.f14843a;
            t.c(constructor);
            x.e eVarA = dVar.a(fVar, mVar.a(constructor));
            if (eVarA != null) {
                Iterator itA2 = kotlin.jvm.internal.c.a(constructor.getDeclaredAnnotations());
                while (itA2.hasNext()) {
                    Annotation annotation = (Annotation) itA2.next();
                    t.c(annotation);
                    f(eVarA, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                t.c(parameterAnnotations);
                if (!(parameterAnnotations.length == 0)) {
                    int length = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length2 = parameterAnnotations.length;
                    for (int i10 = 0; i10 < length2; i10++) {
                        Iterator itA3 = kotlin.jvm.internal.c.a(parameterAnnotations[i10]);
                        while (itA3.hasNext()) {
                            Annotation annotation2 = (Annotation) itA3.next();
                            Class clsB = od.a.b(od.a.a(annotation2));
                            ef.b bVarE = le.f.e(clsB);
                            t.c(annotation2);
                            x.a aVarC = eVarA.c(i10 + length, bVarE, new b(annotation2));
                            if (aVarC != null) {
                                f14829a.h(aVarC, annotation2, clsB);
                            }
                        }
                    }
                }
                eVarA.a();
            }
        }
    }

    public final void d(Class cls, x.d dVar) throws InvocationTargetException {
        Iterator itA = kotlin.jvm.internal.c.a(cls.getDeclaredFields());
        while (itA.hasNext()) {
            Field field = (Field) itA.next();
            ef.f fVarK = ef.f.k(field.getName());
            t.e(fVarK, "identifier(...)");
            m mVar = m.f14843a;
            t.c(field);
            x.c cVarB = dVar.b(fVarK, mVar.b(field), null);
            if (cVarB != null) {
                Iterator itA2 = kotlin.jvm.internal.c.a(field.getDeclaredAnnotations());
                while (itA2.hasNext()) {
                    Annotation annotation = (Annotation) itA2.next();
                    t.c(annotation);
                    f(cVarB, annotation);
                }
                cVarB.a();
            }
        }
    }

    public final void e(Class cls, x.d dVar) throws InvocationTargetException {
        Iterator itA = kotlin.jvm.internal.c.a(cls.getDeclaredMethods());
        while (itA.hasNext()) {
            Method method = (Method) itA.next();
            ef.f fVarK = ef.f.k(method.getName());
            t.e(fVarK, "identifier(...)");
            m mVar = m.f14843a;
            t.c(method);
            x.e eVarA = dVar.a(fVarK, mVar.c(method));
            if (eVarA != null) {
                Iterator itA2 = kotlin.jvm.internal.c.a(method.getDeclaredAnnotations());
                while (itA2.hasNext()) {
                    Annotation annotation = (Annotation) itA2.next();
                    t.c(annotation);
                    f(eVarA, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                t.e(parameterAnnotations, "getParameterAnnotations(...)");
                Annotation[][] annotationArr = parameterAnnotations;
                int length = annotationArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    Iterator itA3 = kotlin.jvm.internal.c.a(annotationArr[i10]);
                    while (itA3.hasNext()) {
                        Annotation annotation2 = (Annotation) itA3.next();
                        Class clsB = od.a.b(od.a.a(annotation2));
                        ef.b bVarE = le.f.e(clsB);
                        t.c(annotation2);
                        x.a aVarC = eVarA.c(i10, bVarE, new b(annotation2));
                        if (aVarC != null) {
                            f14829a.h(aVarC, annotation2, clsB);
                        }
                    }
                }
                eVarA.a();
            }
        }
    }

    public final void f(x.c cVar, Annotation annotation) throws InvocationTargetException {
        Class clsB = od.a.b(od.a.a(annotation));
        x.a aVarB = cVar.b(le.f.e(clsB), new b(annotation));
        if (aVarB != null) {
            f14829a.h(aVarB, annotation, clsB);
        }
    }

    public final void g(x.a aVar, ef.f fVar, Object obj) throws InvocationTargetException {
        Class<?> enclosingClass = obj.getClass();
        if (t.b(enclosingClass, Class.class)) {
            t.d(obj, "null cannot be cast to non-null type java.lang.Class<*>");
            aVar.d(fVar, a((Class) obj));
            return;
        }
        if (i.f14836a.contains(enclosingClass)) {
            aVar.f(fVar, obj);
            return;
        }
        if (le.f.l(enclosingClass)) {
            if (!enclosingClass.isEnum()) {
                enclosingClass = enclosingClass.getEnclosingClass();
            }
            t.c(enclosingClass);
            ef.b bVarE = le.f.e(enclosingClass);
            t.d(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
            ef.f fVarK = ef.f.k(((Enum) obj).name());
            t.e(fVarK, "identifier(...)");
            aVar.c(fVar, bVarE, fVarK);
            return;
        }
        if (Annotation.class.isAssignableFrom(enclosingClass)) {
            Class<?>[] interfaces = enclosingClass.getInterfaces();
            t.e(interfaces, "getInterfaces(...)");
            Class cls = (Class) n.n0(interfaces);
            t.c(cls);
            x.a aVarB = aVar.b(fVar, le.f.e(cls));
            if (aVarB == null) {
                return;
            }
            t.d(obj, "null cannot be cast to non-null type kotlin.Annotation");
            h(aVarB, (Annotation) obj, cls);
            return;
        }
        if (!enclosingClass.isArray()) {
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + obj);
        }
        x.b bVarE2 = aVar.e(fVar);
        if (bVarE2 == null) {
            return;
        }
        Class<?> componentType = enclosingClass.getComponentType();
        int i10 = 0;
        if (componentType.isEnum()) {
            t.c(componentType);
            ef.b bVarE3 = le.f.e(componentType);
            t.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            while (i10 < length) {
                Object obj2 = objArr[i10];
                t.d(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                ef.f fVarK2 = ef.f.k(((Enum) obj2).name());
                t.e(fVarK2, "identifier(...)");
                bVarE2.e(bVarE3, fVarK2);
                i10++;
            }
        } else if (t.b(componentType, Class.class)) {
            t.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr2 = (Object[]) obj;
            int length2 = objArr2.length;
            while (i10 < length2) {
                Object obj3 = objArr2[i10];
                t.d(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                bVarE2.d(a((Class) obj3));
                i10++;
            }
        } else if (Annotation.class.isAssignableFrom(componentType)) {
            t.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr3 = (Object[]) obj;
            int length3 = objArr3.length;
            while (i10 < length3) {
                Object obj4 = objArr3[i10];
                t.c(componentType);
                x.a aVarB2 = bVarE2.b(le.f.e(componentType));
                if (aVarB2 != null) {
                    t.d(obj4, "null cannot be cast to non-null type kotlin.Annotation");
                    h(aVarB2, (Annotation) obj4, componentType);
                }
                i10++;
            }
        } else {
            t.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr4 = (Object[]) obj;
            int length4 = objArr4.length;
            while (i10 < length4) {
                bVarE2.c(objArr4[i10]);
                i10++;
            }
        }
        bVarE2.a();
    }

    public final void h(x.a aVar, Annotation annotation, Class cls) throws InvocationTargetException {
        Iterator itA = kotlin.jvm.internal.c.a(cls.getDeclaredMethods());
        while (itA.hasNext()) {
            Method method = (Method) itA.next();
            try {
                Object objInvoke = method.invoke(annotation, null);
                t.c(objInvoke);
                ef.f fVarK = ef.f.k(method.getName());
                t.e(fVarK, "identifier(...)");
                g(aVar, fVarK, objInvoke);
            } catch (IllegalAccessException unused) {
            }
        }
        aVar.a();
    }

    public final void i(Class klass, x.d memberVisitor) {
        t.f(klass, "klass");
        t.f(memberVisitor, "memberVisitor");
        e(klass, memberVisitor);
        c(klass, memberVisitor);
        d(klass, memberVisitor);
    }
}
