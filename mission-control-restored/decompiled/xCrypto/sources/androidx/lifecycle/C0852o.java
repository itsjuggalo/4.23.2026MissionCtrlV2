package androidx.lifecycle;

import X2.AbstractC0768o;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0852o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0852o f7698a = new C0852o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f7699b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f7700c = new HashMap();

    public static final String c(String className) {
        kotlin.jvm.internal.r.f(className, "className");
        return r3.x.A(className, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    public static final InterfaceC0848k f(Object object) {
        kotlin.jvm.internal.r.f(object, "object");
        boolean z4 = object instanceof InterfaceC0848k;
        boolean z5 = object instanceof DefaultLifecycleObserver;
        if (z4 && z5) {
            return new C0841d((DefaultLifecycleObserver) object, (InterfaceC0848k) object);
        }
        if (z5) {
            return new C0841d((DefaultLifecycleObserver) object, null);
        }
        if (z4) {
            return (InterfaceC0848k) object;
        }
        Class<?> cls = object.getClass();
        C0852o c0852o = f7698a;
        if (c0852o.d(cls) != 2) {
            return new w(object);
        }
        Object obj = f7700c.get(cls);
        kotlin.jvm.internal.r.c(obj);
        List list = (List) obj;
        if (list.size() == 1) {
            c0852o.a((Constructor) list.get(0), object);
            return new I(null);
        }
        int size = list.size();
        InterfaceC0843f[] interfaceC0843fArr = new InterfaceC0843f[size];
        for (int i4 = 0; i4 < size; i4++) {
            f7698a.a((Constructor) list.get(i4), object);
            interfaceC0843fArr[i4] = null;
        }
        return new C0840c(interfaceC0843fArr);
    }

    public final InterfaceC0843f a(Constructor constructor, Object obj) {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            kotlin.jvm.internal.r.e(objNewInstance, "{\n            constructo…tance(`object`)\n        }");
            android.support.v4.media.session.b.a(objNewInstance);
            return null;
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }

    public final Constructor b(Class cls) {
        try {
            Package r02 = cls.getPackage();
            String name = cls.getCanonicalName();
            String fullPackage = r02 != null ? r02.getName() : "";
            kotlin.jvm.internal.r.e(fullPackage, "fullPackage");
            if (fullPackage.length() != 0) {
                kotlin.jvm.internal.r.e(name, "name");
                name = name.substring(fullPackage.length() + 1);
                kotlin.jvm.internal.r.e(name, "this as java.lang.String).substring(startIndex)");
            }
            kotlin.jvm.internal.r.e(name, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String strC = c(name);
            if (fullPackage.length() != 0) {
                strC = fullPackage + com.amazon.a.a.o.c.a.b.f8816a + strC;
            }
            Class<?> cls2 = Class.forName(strC);
            kotlin.jvm.internal.r.d(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException(e4);
        }
    }

    public final int d(Class cls) {
        Map map = f7699b;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    public final boolean e(Class cls) {
        return cls != null && InterfaceC0849l.class.isAssignableFrom(cls);
    }

    public final int g(Class cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorB = b(cls);
        if (constructorB != null) {
            f7700c.put(cls, AbstractC0768o.b(constructorB));
            return 2;
        }
        if (C0839b.f7661c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (e(superclass)) {
            kotlin.jvm.internal.r.e(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            Object obj = f7700c.get(superclass);
            kotlin.jvm.internal.r.c(obj);
            arrayList = new ArrayList((Collection) obj);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        kotlin.jvm.internal.r.e(interfaces, "klass.interfaces");
        for (Class<?> intrface : interfaces) {
            if (e(intrface)) {
                kotlin.jvm.internal.r.e(intrface, "intrface");
                if (d(intrface) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Object obj2 = f7700c.get(intrface);
                kotlin.jvm.internal.r.c(obj2);
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f7700c.put(cls, arrayList);
        return 2;
    }
}
