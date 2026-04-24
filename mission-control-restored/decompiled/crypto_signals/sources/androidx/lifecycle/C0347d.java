package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0347d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0347d f4673c = new C0347d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f4674a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f4675b = new HashMap();

    public static void b(HashMap map, C0346c c0346c, EnumC0356m enumC0356m, Class cls) {
        EnumC0356m enumC0356m2 = (EnumC0356m) map.get(c0346c);
        if (enumC0356m2 == null || enumC0356m == enumC0356m2) {
            if (enumC0356m2 == null) {
                map.put(c0346c, enumC0356m);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0346c.f4672b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + enumC0356m2 + ", new value " + enumC0356m);
    }

    public final C0345b a(Class cls, Method[] methodArr) {
        int i;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.f4674a;
        if (superclass != null) {
            C0345b c0345bA = (C0345b) map2.get(superclass);
            if (c0345bA == null) {
                c0345bA = a(superclass, null);
            }
            map.putAll(c0345bA.f4670b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            C0345b c0345bA2 = (C0345b) map2.get(cls2);
            if (c0345bA2 == null) {
                c0345bA2 = a(cls2, null);
            }
            for (Map.Entry entry : c0345bA2.f4670b.entrySet()) {
                b(map, (C0346c) entry.getKey(), (EnumC0356m) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z6 = false;
        for (Method method : methodArr) {
            D d4 = (D) method.getAnnotation(D.class);
            if (d4 != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!InterfaceC0362t.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                EnumC0356m enumC0356mValue = d4.value();
                if (parameterTypes.length > 1) {
                    if (!EnumC0356m.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (enumC0356mValue != EnumC0356m.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                b(map, new C0346c(i, method), enumC0356mValue, cls);
                z6 = true;
            }
        }
        C0345b c0345b = new C0345b(map);
        map2.put(cls, c0345b);
        this.f4675b.put(cls, Boolean.valueOf(z6));
        return c0345b;
    }
}
