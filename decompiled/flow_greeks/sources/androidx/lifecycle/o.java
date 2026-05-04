package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f2459a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f2460b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f2461c = new HashMap();

    public static final String c(String className) {
        kotlin.jvm.internal.t.f(className, "className");
        return kg.z.F(className, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    public static final k f(Object object) {
        kotlin.jvm.internal.t.f(object, "object");
        boolean z10 = object instanceof k;
        boolean z11 = object instanceof DefaultLifecycleObserver;
        if (z10 && z11) {
            return new d((DefaultLifecycleObserver) object, (k) object);
        }
        if (z11) {
            return new d((DefaultLifecycleObserver) object, null);
        }
        if (z10) {
            return (k) object;
        }
        Class<?> cls = object.getClass();
        o oVar = f2459a;
        if (oVar.d(cls) != 2) {
            return new w(object);
        }
        Object obj = f2461c.get(cls);
        kotlin.jvm.internal.t.c(obj);
        List list = (List) obj;
        if (list.size() == 1) {
            oVar.a((Constructor) list.get(0), object);
            return new h0(null);
        }
        int size = list.size();
        f[] fVarArr = new f[size];
        for (int i10 = 0; i10 < size; i10++) {
            f2459a.a((Constructor) list.get(i10), object);
            fVarArr[i10] = null;
        }
        return new c(fVarArr);
    }

    public final f a(Constructor constructor, Object obj) {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            kotlin.jvm.internal.t.e(objNewInstance, "{\n            constructo…tance(`object`)\n        }");
            android.support.v4.media.session.b.a(objNewInstance);
            return null;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    public final Constructor b(Class cls) {
        try {
            Package r02 = cls.getPackage();
            String name = cls.getCanonicalName();
            String fullPackage = r02 != null ? r02.getName() : "";
            kotlin.jvm.internal.t.e(fullPackage, "fullPackage");
            if (fullPackage.length() != 0) {
                kotlin.jvm.internal.t.e(name, "name");
                name = name.substring(fullPackage.length() + 1);
                kotlin.jvm.internal.t.e(name, "this as java.lang.String).substring(startIndex)");
            }
            kotlin.jvm.internal.t.e(name, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String strC = c(name);
            if (fullPackage.length() != 0) {
                strC = fullPackage + com.amazon.a.a.o.c.a.b.f4610a + strC;
            }
            Class<?> cls2 = Class.forName(strC);
            kotlin.jvm.internal.t.d(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final int d(Class cls) {
        Map map = f2460b;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    public final boolean e(Class cls) {
        return cls != null && l.class.isAssignableFrom(cls);
    }

    public final int g(Class cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorB = b(cls);
        if (constructorB != null) {
            f2461c.put(cls, dd.q.e(constructorB));
            return 2;
        }
        if (b.f2385c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (e(superclass)) {
            kotlin.jvm.internal.t.e(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            Object obj = f2461c.get(superclass);
            kotlin.jvm.internal.t.c(obj);
            arrayList = new ArrayList((Collection) obj);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        kotlin.jvm.internal.t.e(interfaces, "klass.interfaces");
        for (Class<?> intrface : interfaces) {
            if (e(intrface)) {
                kotlin.jvm.internal.t.e(intrface, "intrface");
                if (d(intrface) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Object obj2 = f2461c.get(intrface);
                kotlin.jvm.internal.t.c(obj2);
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f2461c.put(cls, arrayList);
        return 2;
    }
}
