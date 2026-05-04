package n8;

import com.amazon.a.a.o.b;
import e8.d;
import e8.g;
import e8.j;
import e8.o;
import e8.q;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import m8.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentMap f16883a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: n8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0299a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f16884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Constructor f16885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f16886c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f16887d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map f16888e = new HashMap();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map f16890g = new HashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map f16889f = new HashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map f16891h = new HashMap();

        public C0299a(Class cls) {
            this.f16884a = cls;
            this.f16886c = cls.isAnnotationPresent(q.class);
            this.f16887d = !cls.isAnnotationPresent(j.class);
            Constructor constructor = null;
            try {
                Constructor declaredConstructor = cls.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                constructor = declaredConstructor;
            } catch (NoSuchMethodException unused) {
            }
            this.f16885b = constructor;
            for (Method method : cls.getMethods()) {
                if (i(method)) {
                    String strE = e(method);
                    a(strE);
                    method.setAccessible(true);
                    if (this.f16889f.containsKey(strE)) {
                        throw new d("Found conflicting getters for name: " + method.getName());
                    }
                    this.f16889f.put(strE, method);
                }
            }
            for (Field field : cls.getFields()) {
                if (h(field)) {
                    a(d(field));
                }
            }
            HashMap map = new HashMap();
            Class superclass = cls;
            do {
                for (Method method2 : superclass.getDeclaredMethods()) {
                    if (j(method2)) {
                        String strE2 = e(method2);
                        String str = (String) this.f16888e.get(strE2.toLowerCase(Locale.US));
                        if (str == null) {
                            continue;
                        } else {
                            if (!str.equals(strE2)) {
                                throw new d("Found setter with invalid case-sensitive name: " + method2.getName());
                            }
                            if (method2.isBridge()) {
                                map.put(strE2, method2);
                            } else {
                                Method method3 = (Method) this.f16890g.get(strE2);
                                Method method4 = (Method) map.get(strE2);
                                if (method3 == null) {
                                    method2.setAccessible(true);
                                    this.f16890g.put(strE2, method2);
                                } else if (!c(method2, method3) && (method4 == null || !c(method2, method4))) {
                                    throw new d("Found a conflicting setters with name: " + method2.getName() + " (conflicts with " + method3.getName() + " defined on " + method3.getDeclaringClass().getName() + ")");
                                }
                            }
                        }
                    }
                }
                for (Field field2 : superclass.getDeclaredFields()) {
                    String strD = d(field2);
                    if (this.f16888e.containsKey(strD.toLowerCase(Locale.US)) && !this.f16891h.containsKey(strD)) {
                        field2.setAccessible(true);
                        this.f16891h.put(strD, field2);
                    }
                }
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    break;
                }
            } while (!superclass.equals(Object.class));
            if (this.f16888e.isEmpty()) {
                throw new d("No properties to serialize found on class " + cls.getName());
            }
        }

        public static String b(AccessibleObject accessibleObject) {
            if (accessibleObject.isAnnotationPresent(o.class)) {
                return ((o) accessibleObject.getAnnotation(o.class)).value();
            }
            return null;
        }

        public static boolean c(Method method, Method method2) {
            m.g(method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()), "Expected override from a base class");
            Class<?> returnType = method.getReturnType();
            Class cls = Void.TYPE;
            m.g(returnType.equals(cls), "Expected void return type");
            m.g(method2.getReturnType().equals(cls), "Expected void return type");
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            m.g(parameterTypes.length == 1, "Expected exactly one parameter");
            m.g(parameterTypes2.length == 1, "Expected exactly one parameter");
            return method.getName().equals(method2.getName()) && parameterTypes[0].equals(parameterTypes2[0]);
        }

        public static String d(Field field) {
            String strB = b(field);
            return strB != null ? strB : field.getName();
        }

        public static String e(Method method) {
            String strB = b(method);
            return strB != null ? strB : g(method.getName());
        }

        public static String g(String str) {
            String[] strArr = {b.au, "set", "is"};
            String str2 = null;
            for (int i10 = 0; i10 < 3; i10++) {
                String str3 = strArr[i10];
                if (str.startsWith(str3)) {
                    str2 = str3;
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("Unknown Bean prefix for method: " + str);
            }
            char[] charArray = str.substring(str2.length()).toCharArray();
            for (int i11 = 0; i11 < charArray.length && Character.isUpperCase(charArray[i11]); i11++) {
                charArray[i11] = Character.toLowerCase(charArray[i11]);
            }
            return new String(charArray);
        }

        public static boolean h(Field field) {
            return (field.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(field.getModifiers()) || Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(field.getModifiers()) || field.isAnnotationPresent(g.class)) ? false : true;
        }

        public static boolean i(Method method) {
            return ((!method.getName().startsWith(b.au) && !method.getName().startsWith("is")) || method.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(method.getModifiers()) || Modifier.isStatic(method.getModifiers()) || method.getReturnType().equals(Void.TYPE) || method.getParameterTypes().length != 0 || method.isBridge() || method.isAnnotationPresent(g.class)) ? false : true;
        }

        public static boolean j(Method method) {
            return method.getName().startsWith("set") && !method.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(g.class);
        }

        public final void a(String str) {
            Map map = this.f16888e;
            Locale locale = Locale.US;
            String str2 = (String) map.put(str.toLowerCase(locale), str);
            if (str2 == null || str.equals(str2)) {
                return;
            }
            throw new d("Found two getters or fields with conflicting case sensitivity for property: " + str.toLowerCase(locale));
        }

        public Map f(Object obj) {
            Object objInvoke;
            if (!this.f16884a.isAssignableFrom(obj.getClass())) {
                throw new IllegalArgumentException("Can't serialize object of class " + obj.getClass() + " with BeanMapper for class " + this.f16884a);
            }
            HashMap map = new HashMap();
            for (String str : this.f16888e.values()) {
                if (this.f16889f.containsKey(str)) {
                    try {
                        objInvoke = ((Method) this.f16889f.get(str)).invoke(obj, null);
                    } catch (IllegalAccessException e10) {
                        throw new RuntimeException(e10);
                    } catch (InvocationTargetException e11) {
                        throw new RuntimeException(e11);
                    }
                } else {
                    Field field = (Field) this.f16891h.get(str);
                    if (field == null) {
                        throw new IllegalStateException("Bean property without field or getter:" + str);
                    }
                    try {
                        objInvoke = field.get(obj);
                    } catch (IllegalAccessException e12) {
                        throw new RuntimeException(e12);
                    }
                }
                map.put(str, a.e(objInvoke));
            }
            return map;
        }
    }

    public static Object b(Object obj) {
        return e(obj);
    }

    public static Map c(Map map) {
        Object objE = e(map);
        m.f(objE instanceof Map);
        return (Map) objE;
    }

    public static C0299a d(Class cls) {
        ConcurrentMap concurrentMap = f16883a;
        C0299a c0299a = (C0299a) concurrentMap.get(cls);
        if (c0299a != null) {
            return c0299a;
        }
        C0299a c0299a2 = new C0299a(cls);
        concurrentMap.put(cls, c0299a2);
        return c0299a2;
    }

    public static Object e(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            if ((obj instanceof Float) || (obj instanceof Double)) {
                Number number = (Number) obj;
                double dDoubleValue = number.doubleValue();
                return (dDoubleValue > 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d || Math.floor(dDoubleValue) != dDoubleValue) ? Double.valueOf(dDoubleValue) : Long.valueOf(number.longValue());
            }
            if ((obj instanceof Long) || (obj instanceof Integer)) {
                return obj;
            }
            throw new d(String.format("Numbers of type %s are not supported, please use an int, long, float or double", obj.getClass().getSimpleName()));
        }
        if ((obj instanceof String) || (obj instanceof Boolean)) {
            return obj;
        }
        if (obj instanceof Character) {
            throw new d("Characters are not supported, please use Strings");
        }
        if (obj instanceof Map) {
            HashMap map = new HashMap();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (!(key instanceof String)) {
                    throw new d("Maps with non-string keys are not supported");
                }
                map.put((String) key, e(entry.getValue()));
            }
            return map;
        }
        if (!(obj instanceof Collection)) {
            if (obj.getClass().isArray()) {
                throw new d("Serializing Arrays is not supported, please use Lists instead");
            }
            return obj instanceof Enum ? ((Enum) obj).name() : d(obj.getClass()).f(obj);
        }
        if (!(obj instanceof List)) {
            throw new d("Serializing Collections is not supported, please use Lists instead");
        }
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(e(it.next()));
        }
        return arrayList;
    }
}
