package androidx.lifecycle;

import F5.AbstractC0555m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0969o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0969o f7796a = new C0969o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f7797b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f7798c = new HashMap();

    public static final String c(String className) {
        kotlin.jvm.internal.r.f(className, "className");
        return Z5.t.w(className, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    public static final InterfaceC0965k f(Object object) {
        kotlin.jvm.internal.r.f(object, "object");
        boolean z7 = object instanceof InterfaceC0965k;
        boolean z8 = object instanceof DefaultLifecycleObserver;
        if (z7 && z8) {
            return new C0958d((DefaultLifecycleObserver) object, (InterfaceC0965k) object);
        }
        if (z8) {
            return new C0958d((DefaultLifecycleObserver) object, null);
        }
        if (z7) {
            return (InterfaceC0965k) object;
        }
        Class<?> cls = object.getClass();
        C0969o c0969o = f7796a;
        if (c0969o.d(cls) != 2) {
            return new w(object);
        }
        Object obj = f7798c.get(cls);
        kotlin.jvm.internal.r.c(obj);
        List list = (List) obj;
        if (list.size() == 1) {
            c0969o.a((Constructor) list.get(0), object);
            return new I(null);
        }
        int size = list.size();
        InterfaceC0960f[] interfaceC0960fArr = new InterfaceC0960f[size];
        for (int i7 = 0; i7 < size; i7++) {
            f7796a.a((Constructor) list.get(i7), object);
            interfaceC0960fArr[i7] = null;
        }
        return new C0957c(interfaceC0960fArr);
    }

    public final InterfaceC0960f a(Constructor constructor, Object obj) {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            kotlin.jvm.internal.r.e(objNewInstance, "{\n            constructo…tance(`object`)\n        }");
            android.support.v4.media.session.b.a(objNewInstance);
            return null;
        } catch (IllegalAccessException e7) {
            throw new RuntimeException(e7);
        } catch (InstantiationException e8) {
            throw new RuntimeException(e8);
        } catch (InvocationTargetException e9) {
            throw new RuntimeException(e9);
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
                strC = fullPackage + com.amazon.a.a.o.c.a.b.f10001a + strC;
            }
            Class<?> cls2 = Class.forName(strC);
            kotlin.jvm.internal.r.d(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException(e7);
        }
    }

    public final int d(Class cls) {
        Map map = f7797b;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    public final boolean e(Class cls) {
        return cls != null && InterfaceC0966l.class.isAssignableFrom(cls);
    }

    public final int g(Class cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorB = b(cls);
        if (constructorB != null) {
            f7798c.put(cls, AbstractC0555m.b(constructorB));
            return 2;
        }
        if (C0956b.f7759c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (e(superclass)) {
            kotlin.jvm.internal.r.e(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            Object obj = f7798c.get(superclass);
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
                Object obj2 = f7798c.get(intrface);
                kotlin.jvm.internal.r.c(obj2);
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f7798c.put(cls, arrayList);
        return 2;
    }
}
