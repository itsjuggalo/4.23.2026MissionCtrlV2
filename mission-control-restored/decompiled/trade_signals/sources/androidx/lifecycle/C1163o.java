package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2594p;

/* JADX INFO: renamed from: androidx.lifecycle.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1163o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1163o f11994a = new C1163o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f11995b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f11996c = new HashMap();

    public static final String c(String className) {
        AbstractC2304t.f(className, "className");
        return V6.A.E(className, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    public static final InterfaceC1159k f(Object object) {
        AbstractC2304t.f(object, "object");
        boolean z7 = object instanceof InterfaceC1159k;
        boolean z8 = object instanceof DefaultLifecycleObserver;
        if (z7 && z8) {
            return new C1152d((DefaultLifecycleObserver) object, (InterfaceC1159k) object);
        }
        if (z8) {
            return new C1152d((DefaultLifecycleObserver) object, null);
        }
        if (z7) {
            return (InterfaceC1159k) object;
        }
        Class<?> cls = object.getClass();
        C1163o c1163o = f11994a;
        if (c1163o.d(cls) != 2) {
            return new w(object);
        }
        Object obj = f11996c.get(cls);
        AbstractC2304t.c(obj);
        List list = (List) obj;
        if (list.size() == 1) {
            c1163o.a((Constructor) list.get(0), object);
            return new I(null);
        }
        int size = list.size();
        InterfaceC1154f[] interfaceC1154fArr = new InterfaceC1154f[size];
        for (int i8 = 0; i8 < size; i8++) {
            f11994a.a((Constructor) list.get(i8), object);
            interfaceC1154fArr[i8] = null;
        }
        return new C1151c(interfaceC1154fArr);
    }

    public final InterfaceC1154f a(Constructor constructor, Object obj) {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            AbstractC2304t.e(objNewInstance, "{\n            constructo…tance(`object`)\n        }");
            android.support.v4.media.session.b.a(objNewInstance);
            return null;
        } catch (IllegalAccessException e8) {
            throw new RuntimeException(e8);
        } catch (InstantiationException e9) {
            throw new RuntimeException(e9);
        } catch (InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final Constructor b(Class cls) {
        try {
            Package r02 = cls.getPackage();
            String name = cls.getCanonicalName();
            String fullPackage = r02 != null ? r02.getName() : "";
            AbstractC2304t.e(fullPackage, "fullPackage");
            if (fullPackage.length() != 0) {
                AbstractC2304t.e(name, "name");
                name = name.substring(fullPackage.length() + 1);
                AbstractC2304t.e(name, "this as java.lang.String).substring(startIndex)");
            }
            AbstractC2304t.e(name, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String strC = c(name);
            if (fullPackage.length() != 0) {
                strC = fullPackage + com.amazon.a.a.o.c.a.b.f14112a + strC;
            }
            Class<?> cls2 = Class.forName(strC);
            AbstractC2304t.d(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e8) {
            throw new RuntimeException(e8);
        }
    }

    public final int d(Class cls) {
        Map map = f11995b;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    public final boolean e(Class cls) {
        return cls != null && InterfaceC1160l.class.isAssignableFrom(cls);
    }

    public final int g(Class cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorB = b(cls);
        if (constructorB != null) {
            f11996c.put(cls, AbstractC2594p.e(constructorB));
            return 2;
        }
        if (C1150b.f11957c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (e(superclass)) {
            AbstractC2304t.e(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            Object obj = f11996c.get(superclass);
            AbstractC2304t.c(obj);
            arrayList = new ArrayList((Collection) obj);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        AbstractC2304t.e(interfaces, "klass.interfaces");
        for (Class<?> intrface : interfaces) {
            if (e(intrface)) {
                AbstractC2304t.e(intrface, "intrface");
                if (d(intrface) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Object obj2 = f11996c.get(intrface);
                AbstractC2304t.c(obj2);
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f11996c.put(cls, arrayList);
        return 2;
    }
}
