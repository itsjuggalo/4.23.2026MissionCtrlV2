package androidx.lifecycle;

import androidx.lifecycle.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f2385c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2386a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2387b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f2388a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f2389b;

        public a(Map map) {
            this.f2389b = map;
            for (Map.Entry entry : map.entrySet()) {
                i.a aVar = (i.a) entry.getValue();
                List arrayList = (List) this.f2388a.get(aVar);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f2388a.put(aVar, arrayList);
                }
                arrayList.add((C0030b) entry.getKey());
            }
        }

        public static void b(List list, m mVar, i.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0030b) list.get(size)).a(mVar, aVar, obj);
                }
            }
        }

        public void a(m mVar, i.a aVar, Object obj) {
            b((List) this.f2388a.get(aVar), mVar, aVar, obj);
            b((List) this.f2388a.get(i.a.ON_ANY), mVar, aVar, obj);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0030b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f2391b;

        public C0030b(int i10, Method method) {
            this.f2390a = i10;
            this.f2391b = method;
            method.setAccessible(true);
        }

        public void a(m mVar, i.a aVar, Object obj) {
            try {
                int i10 = this.f2390a;
                if (i10 == 0) {
                    this.f2391b.invoke(obj, null);
                } else if (i10 == 1) {
                    this.f2391b.invoke(obj, mVar);
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    this.f2391b.invoke(obj, mVar, aVar);
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to call observer method", e11.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0030b)) {
                return false;
            }
            C0030b c0030b = (C0030b) obj;
            return this.f2390a == c0030b.f2390a && this.f2391b.getName().equals(c0030b.f2391b.getName());
        }

        public int hashCode() {
            return (this.f2390a * 31) + this.f2391b.getName().hashCode();
        }
    }

    public final a a(Class cls, Method[] methodArr) {
        int i10;
        a aVarC;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f2389b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f2389b.entrySet()) {
                e(map, (C0030b) entry.getKey(), (i.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            t tVar = (t) method.getAnnotation(t.class);
            if (tVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else {
                    if (!m.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i10 = 1;
                }
                i.a aVarValue = tVar.value();
                if (parameterTypes.length > 1) {
                    if (!i.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != i.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i10 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new C0030b(i10, method), aVarValue, cls);
                z10 = true;
            }
        }
        a aVar = new a(map);
        this.f2386a.put(cls, aVar);
        this.f2387b.put(cls, Boolean.valueOf(z10));
        return aVar;
    }

    public final Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
        }
    }

    public a c(Class cls) {
        a aVar = (a) this.f2386a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean d(Class cls) {
        Boolean bool = (Boolean) this.f2387b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((t) method.getAnnotation(t.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f2387b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map map, C0030b c0030b, i.a aVar, Class cls) {
        i.a aVar2 = (i.a) map.get(c0030b);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(c0030b, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0030b.f2391b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }
}
