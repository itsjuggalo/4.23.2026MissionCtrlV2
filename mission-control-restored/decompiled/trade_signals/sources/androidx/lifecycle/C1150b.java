package androidx.lifecycle;

import androidx.lifecycle.AbstractC1157i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1150b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C1150b f11957c = new C1150b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11958a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f11959b = new HashMap();

    /* JADX INFO: renamed from: androidx.lifecycle.b$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f11960a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f11961b;

        public a(Map map) {
            this.f11961b = map;
            for (Map.Entry entry : map.entrySet()) {
                AbstractC1157i.a aVar = (AbstractC1157i.a) entry.getValue();
                List arrayList = (List) this.f11960a.get(aVar);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f11960a.put(aVar, arrayList);
                }
                arrayList.add((C0192b) entry.getKey());
            }
        }

        public static void b(List list, InterfaceC1161m interfaceC1161m, AbstractC1157i.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0192b) list.get(size)).a(interfaceC1161m, aVar, obj);
                }
            }
        }

        public void a(InterfaceC1161m interfaceC1161m, AbstractC1157i.a aVar, Object obj) {
            b((List) this.f11960a.get(aVar), interfaceC1161m, aVar, obj);
            b((List) this.f11960a.get(AbstractC1157i.a.ON_ANY), interfaceC1161m, aVar, obj);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    public static final class C0192b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f11963b;

        public C0192b(int i8, Method method) {
            this.f11962a = i8;
            this.f11963b = method;
            method.setAccessible(true);
        }

        public void a(InterfaceC1161m interfaceC1161m, AbstractC1157i.a aVar, Object obj) {
            try {
                int i8 = this.f11962a;
                if (i8 == 0) {
                    this.f11963b.invoke(obj, null);
                } else if (i8 == 1) {
                    this.f11963b.invoke(obj, interfaceC1161m);
                } else {
                    if (i8 != 2) {
                        return;
                    }
                    this.f11963b.invoke(obj, interfaceC1161m, aVar);
                }
            } catch (IllegalAccessException e8) {
                throw new RuntimeException(e8);
            } catch (InvocationTargetException e9) {
                throw new RuntimeException("Failed to call observer method", e9.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0192b)) {
                return false;
            }
            C0192b c0192b = (C0192b) obj;
            return this.f11962a == c0192b.f11962a && this.f11963b.getName().equals(c0192b.f11963b.getName());
        }

        public int hashCode() {
            return (this.f11962a * 31) + this.f11963b.getName().hashCode();
        }
    }

    public final a a(Class cls, Method[] methodArr) {
        int i8;
        a aVarC;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f11961b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f11961b.entrySet()) {
                e(map, (C0192b) entry.getKey(), (AbstractC1157i.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z7 = false;
        for (Method method : methodArr) {
            t tVar = (t) method.getAnnotation(t.class);
            if (tVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i8 = 0;
                } else {
                    if (!InterfaceC1161m.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i8 = 1;
                }
                AbstractC1157i.a aVarValue = tVar.value();
                if (parameterTypes.length > 1) {
                    if (!AbstractC1157i.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != AbstractC1157i.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i8 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new C0192b(i8, method), aVarValue, cls);
                z7 = true;
            }
        }
        a aVar = new a(map);
        this.f11958a.put(cls, aVar);
        this.f11959b.put(cls, Boolean.valueOf(z7));
        return aVar;
    }

    public final Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e8) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e8);
        }
    }

    public a c(Class cls) {
        a aVar = (a) this.f11958a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean d(Class cls) {
        Boolean bool = (Boolean) this.f11959b.get(cls);
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
        this.f11959b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map map, C0192b c0192b, AbstractC1157i.a aVar, Class cls) {
        AbstractC1157i.a aVar2 = (AbstractC1157i.a) map.get(c0192b);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(c0192b, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0192b.f11963b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }
}
