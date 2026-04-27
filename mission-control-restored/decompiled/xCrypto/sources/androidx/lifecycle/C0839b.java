package androidx.lifecycle;

import androidx.lifecycle.AbstractC0846i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0839b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C0839b f7661c = new C0839b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7662a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f7663b = new HashMap();

    /* JADX INFO: renamed from: androidx.lifecycle.b$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f7664a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f7665b;

        public a(Map map) {
            this.f7665b = map;
            for (Map.Entry entry : map.entrySet()) {
                AbstractC0846i.a aVar = (AbstractC0846i.a) entry.getValue();
                List arrayList = (List) this.f7664a.get(aVar);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f7664a.put(aVar, arrayList);
                }
                arrayList.add((C0109b) entry.getKey());
            }
        }

        public static void b(List list, InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0109b) list.get(size)).a(interfaceC0850m, aVar, obj);
                }
            }
        }

        public void a(InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar, Object obj) {
            b((List) this.f7664a.get(aVar), interfaceC0850m, aVar, obj);
            b((List) this.f7664a.get(AbstractC0846i.a.ON_ANY), interfaceC0850m, aVar, obj);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    public static final class C0109b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f7667b;

        public C0109b(int i4, Method method) {
            this.f7666a = i4;
            this.f7667b = method;
            method.setAccessible(true);
        }

        public void a(InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar, Object obj) {
            try {
                int i4 = this.f7666a;
                if (i4 == 0) {
                    this.f7667b.invoke(obj, new Object[0]);
                } else if (i4 == 1) {
                    this.f7667b.invoke(obj, interfaceC0850m);
                } else {
                    if (i4 != 2) {
                        return;
                    }
                    this.f7667b.invoke(obj, interfaceC0850m, aVar);
                }
            } catch (IllegalAccessException e4) {
                throw new RuntimeException(e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Failed to call observer method", e5.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0109b)) {
                return false;
            }
            C0109b c0109b = (C0109b) obj;
            return this.f7666a == c0109b.f7666a && this.f7667b.getName().equals(c0109b.f7667b.getName());
        }

        public int hashCode() {
            return (this.f7666a * 31) + this.f7667b.getName().hashCode();
        }
    }

    public final a a(Class cls, Method[] methodArr) {
        int i4;
        a aVarC;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f7665b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f7665b.entrySet()) {
                e(map, (C0109b) entry.getKey(), (AbstractC0846i.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z4 = false;
        for (Method method : methodArr) {
            t tVar = (t) method.getAnnotation(t.class);
            if (tVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i4 = 0;
                } else {
                    if (!InterfaceC0850m.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i4 = 1;
                }
                AbstractC0846i.a aVarValue = tVar.value();
                if (parameterTypes.length > 1) {
                    if (!AbstractC0846i.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != AbstractC0846i.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i4 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new C0109b(i4, method), aVarValue, cls);
                z4 = true;
            }
        }
        a aVar = new a(map);
        this.f7662a.put(cls, aVar);
        this.f7663b.put(cls, Boolean.valueOf(z4));
        return aVar;
    }

    public final Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e4) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e4);
        }
    }

    public a c(Class cls) {
        a aVar = (a) this.f7662a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean d(Class cls) {
        Boolean bool = (Boolean) this.f7663b.get(cls);
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
        this.f7663b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map map, C0109b c0109b, AbstractC0846i.a aVar, Class cls) {
        AbstractC0846i.a aVar2 = (AbstractC0846i.a) map.get(c0109b);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(c0109b, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0109b.f7667b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }
}
