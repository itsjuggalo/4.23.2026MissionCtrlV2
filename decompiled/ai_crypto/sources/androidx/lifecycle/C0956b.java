package androidx.lifecycle;

import androidx.lifecycle.AbstractC0963i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0956b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C0956b f7759c = new C0956b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f7760a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f7761b = new HashMap();

    /* JADX INFO: renamed from: androidx.lifecycle.b$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f7762a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f7763b;

        public a(Map map) {
            this.f7763b = map;
            for (Map.Entry entry : map.entrySet()) {
                AbstractC0963i.a aVar = (AbstractC0963i.a) entry.getValue();
                List arrayList = (List) this.f7762a.get(aVar);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f7762a.put(aVar, arrayList);
                }
                arrayList.add((C0131b) entry.getKey());
            }
        }

        public static void b(List list, InterfaceC0967m interfaceC0967m, AbstractC0963i.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0131b) list.get(size)).a(interfaceC0967m, aVar, obj);
                }
            }
        }

        public void a(InterfaceC0967m interfaceC0967m, AbstractC0963i.a aVar, Object obj) {
            b((List) this.f7762a.get(aVar), interfaceC0967m, aVar, obj);
            b((List) this.f7762a.get(AbstractC0963i.a.ON_ANY), interfaceC0967m, aVar, obj);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    public static final class C0131b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f7765b;

        public C0131b(int i7, Method method) {
            this.f7764a = i7;
            this.f7765b = method;
            method.setAccessible(true);
        }

        public void a(InterfaceC0967m interfaceC0967m, AbstractC0963i.a aVar, Object obj) {
            try {
                int i7 = this.f7764a;
                if (i7 == 0) {
                    this.f7765b.invoke(obj, null);
                } else if (i7 == 1) {
                    this.f7765b.invoke(obj, interfaceC0967m);
                } else {
                    if (i7 != 2) {
                        return;
                    }
                    this.f7765b.invoke(obj, interfaceC0967m, aVar);
                }
            } catch (IllegalAccessException e7) {
                throw new RuntimeException(e7);
            } catch (InvocationTargetException e8) {
                throw new RuntimeException("Failed to call observer method", e8.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0131b)) {
                return false;
            }
            C0131b c0131b = (C0131b) obj;
            return this.f7764a == c0131b.f7764a && this.f7765b.getName().equals(c0131b.f7765b.getName());
        }

        public int hashCode() {
            return (this.f7764a * 31) + this.f7765b.getName().hashCode();
        }
    }

    public final a a(Class cls, Method[] methodArr) {
        int i7;
        a aVarC;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f7763b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f7763b.entrySet()) {
                e(map, (C0131b) entry.getKey(), (AbstractC0963i.a) entry.getValue(), cls);
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
                    i7 = 0;
                } else {
                    if (!InterfaceC0967m.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i7 = 1;
                }
                AbstractC0963i.a aVarValue = tVar.value();
                if (parameterTypes.length > 1) {
                    if (!AbstractC0963i.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != AbstractC0963i.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i7 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new C0131b(i7, method), aVarValue, cls);
                z7 = true;
            }
        }
        a aVar = new a(map);
        this.f7760a.put(cls, aVar);
        this.f7761b.put(cls, Boolean.valueOf(z7));
        return aVar;
    }

    public final Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e7) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e7);
        }
    }

    public a c(Class cls) {
        a aVar = (a) this.f7760a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean d(Class cls) {
        Boolean bool = (Boolean) this.f7761b.get(cls);
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
        this.f7761b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map map, C0131b c0131b, AbstractC0963i.a aVar, Class cls) {
        AbstractC0963i.a aVar2 = (AbstractC0963i.a) map.get(c0131b);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(c0131b, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0131b.f7765b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }
}
