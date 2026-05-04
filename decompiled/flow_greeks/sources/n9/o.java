package n9;

import android.net.Uri;
import d9.i1;
import d9.p1;
import d9.q0;
import d9.r0;
import d9.u1;
import d9.y1;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentMap f16947a = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f16948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Constructor f16949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f16950c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f16951d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map f16952e = new HashMap();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map f16954g = new HashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Map f16953f = new HashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map f16955h = new HashMap();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final HashSet f16956i = new HashSet();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final HashSet f16957j = new HashSet();

        public a(Class cls) {
            this.f16948a = cls;
            this.f16950c = cls.isAnnotationPresent(u1.class);
            this.f16951d = !cls.isAnnotationPresent(r0.class);
            Constructor constructor = null;
            try {
                Constructor declaredConstructor = cls.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                constructor = declaredConstructor;
            } catch (NoSuchMethodException unused) {
            }
            this.f16949b = constructor;
            for (Method method : cls.getMethods()) {
                if (n(method)) {
                    String strJ = j(method);
                    b(strJ);
                    method.setAccessible(true);
                    if (this.f16953f.containsKey(strJ)) {
                        throw new RuntimeException("Found conflicting getters for name " + method.getName() + " on class " + cls.getName());
                    }
                    this.f16953f.put(strJ, method);
                    e(method);
                }
            }
            for (Field field : cls.getFields()) {
                if (m(field)) {
                    b(i(field));
                    d(field);
                }
            }
            HashMap map = new HashMap();
            Class superclass = cls;
            do {
                for (Method method2 : superclass.getDeclaredMethods()) {
                    if (o(method2)) {
                        String strJ2 = j(method2);
                        String str = (String) this.f16952e.get(strJ2.toLowerCase(Locale.US));
                        if (str == null) {
                            continue;
                        } else {
                            if (!str.equals(strJ2)) {
                                throw new RuntimeException("Found setter on " + superclass.getName() + " with invalid case-sensitive name: " + method2.getName());
                            }
                            if (method2.isBridge()) {
                                map.put(strJ2, method2);
                            } else {
                                Method method3 = (Method) this.f16954g.get(strJ2);
                                Method method4 = (Method) map.get(strJ2);
                                if (method3 == null) {
                                    method2.setAccessible(true);
                                    this.f16954g.put(strJ2, method2);
                                    f(method2);
                                } else if (!h(method2, method3) && (method4 == null || !h(method2, method4))) {
                                    if (superclass == cls) {
                                        throw new RuntimeException("Class " + cls.getName() + " has multiple setter overloads with name " + method2.getName());
                                    }
                                    throw new RuntimeException("Found conflicting setters with name: " + method2.getName() + " (conflicts with " + method3.getName() + " defined on " + method3.getDeclaringClass().getName() + ")");
                                }
                            }
                        }
                    }
                }
                for (Field field2 : superclass.getDeclaredFields()) {
                    String strI = i(field2);
                    if (this.f16952e.containsKey(strI.toLowerCase(Locale.US)) && !this.f16955h.containsKey(strI)) {
                        field2.setAccessible(true);
                        this.f16955h.put(strI, field2);
                        d(field2);
                    }
                }
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    break;
                }
            } while (!superclass.equals(Object.class));
            if (this.f16952e.isEmpty()) {
                throw new RuntimeException("No properties to serialize found on class " + cls.getName());
            }
            for (String str2 : this.f16957j) {
                if (!this.f16954g.containsKey(str2) && !this.f16955h.containsKey(str2)) {
                    throw new RuntimeException("@DocumentId is annotated on property " + str2 + " of class " + cls.getName() + " but no field or public setter was found");
                }
            }
        }

        public static String c(AccessibleObject accessibleObject) {
            if (accessibleObject.isAnnotationPresent(i1.class)) {
                return ((i1) accessibleObject.getAnnotation(i1.class)).value();
            }
            return null;
        }

        public static boolean h(Method method, Method method2) {
            o.d(method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()), "Expected override from a base class");
            Class<?> returnType = method.getReturnType();
            Class cls = Void.TYPE;
            o.d(returnType.equals(cls), "Expected void return type");
            o.d(method2.getReturnType().equals(cls), "Expected void return type");
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            o.d(parameterTypes.length == 1, "Expected exactly one parameter");
            o.d(parameterTypes2.length == 1, "Expected exactly one parameter");
            return method.getName().equals(method2.getName()) && parameterTypes[0].equals(parameterTypes2[0]);
        }

        public static String i(Field field) {
            String strC = c(field);
            return strC != null ? strC : field.getName();
        }

        public static String j(Method method) {
            String strC = c(method);
            return strC != null ? strC : l(method.getName());
        }

        public static String l(String str) {
            String[] strArr = {com.amazon.a.a.o.b.au, "set", "is"};
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

        public static boolean m(Field field) {
            return (field.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(field.getModifiers()) || Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(field.getModifiers()) || field.isAnnotationPresent(d9.s.class)) ? false : true;
        }

        public static boolean n(Method method) {
            return ((!method.getName().startsWith(com.amazon.a.a.o.b.au) && !method.getName().startsWith("is")) || method.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(method.getModifiers()) || Modifier.isStatic(method.getModifiers()) || method.getReturnType().equals(Void.TYPE) || method.getParameterTypes().length != 0 || method.isBridge() || method.isAnnotationPresent(d9.s.class)) ? false : true;
        }

        public static boolean o(Method method) {
            return method.getName().startsWith("set") && !method.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(d9.s.class);
        }

        public final void b(String str) {
            Map map = this.f16952e;
            Locale locale = Locale.US;
            String str2 = (String) map.put(str.toLowerCase(locale), str);
            if (str2 == null || str.equals(str2)) {
                return;
            }
            throw new RuntimeException("Found two getters or fields with conflicting case sensitivity for property: " + str.toLowerCase(locale));
        }

        public final void d(Field field) {
            if (field.isAnnotationPresent(p1.class)) {
                Class<?> type = field.getType();
                if (type != Date.class && type != a7.s.class) {
                    throw new IllegalArgumentException("Field " + field.getName() + " is annotated with @ServerTimestamp but is " + type + " instead of Date or Timestamp.");
                }
                this.f16956i.add(i(field));
            }
            if (field.isAnnotationPresent(d9.h.class)) {
                g("Field", "is", field.getType());
                this.f16957j.add(i(field));
            }
        }

        public final void e(Method method) {
            if (method.isAnnotationPresent(p1.class)) {
                Class<?> returnType = method.getReturnType();
                if (returnType != Date.class && returnType != a7.s.class) {
                    throw new IllegalArgumentException("Method " + method.getName() + " is annotated with @ServerTimestamp but returns " + returnType + " instead of Date or Timestamp.");
                }
                this.f16956i.add(j(method));
            }
            if (method.isAnnotationPresent(d9.h.class)) {
                g("Method", "returns", method.getReturnType());
                this.f16957j.add(j(method));
            }
        }

        public final void f(Method method) {
            if (method.isAnnotationPresent(p1.class)) {
                throw new IllegalArgumentException("Method " + method.getName() + " is annotated with @ServerTimestamp but should not be. @ServerTimestamp can only be applied to fields and getters, not setters.");
            }
            if (method.isAnnotationPresent(d9.h.class)) {
                g("Method", "accepts", method.getParameterTypes()[0]);
                this.f16957j.add(j(method));
            }
        }

        public final void g(String str, String str2, Type type) {
            if (type == String.class || type == com.google.firebase.firestore.c.class) {
                return;
            }
            throw new IllegalArgumentException(str + " is annotated with @DocumentId but " + str2 + " " + type + " instead of String or DocumentReference.");
        }

        public Map k(Object obj, b bVar) {
            Object objA;
            if (!this.f16948a.isAssignableFrom(obj.getClass())) {
                throw new IllegalArgumentException("Can't serialize object of class " + obj.getClass() + " with BeanMapper for class " + this.f16948a);
            }
            HashMap map = new HashMap();
            for (String str : this.f16952e.values()) {
                if (!this.f16957j.contains(str)) {
                    if (this.f16953f.containsKey(str)) {
                        objA = n9.a.a((Method) this.f16953f.get(str), obj, new Object[0]);
                    } else {
                        Field field = (Field) this.f16955h.get(str);
                        if (field == null) {
                            throw new IllegalStateException("Bean property without field or getter: " + str);
                        }
                        try {
                            objA = field.get(obj);
                        } catch (IllegalAccessException e10) {
                            throw new RuntimeException(e10);
                        }
                    }
                    map.put(str, (this.f16956i.contains(str) && objA == null) ? d9.u.g() : o.g(objA, bVar.a(str)));
                }
            }
            return map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f16958d = new b(null, null, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f16960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f16961c;

        public b(b bVar, String str, int i10) {
            this.f16960b = bVar;
            this.f16961c = str;
            this.f16959a = i10;
        }

        public b a(String str) {
            return new b(this, str, this.f16959a + 1);
        }

        public int b() {
            return this.f16959a;
        }

        public String toString() {
            int i10 = this.f16959a;
            if (i10 == 0) {
                return "";
            }
            if (i10 == 1) {
                return this.f16961c;
            }
            return this.f16960b.toString() + "." + this.f16961c;
        }
    }

    public static Object c(Object obj) {
        return f(obj);
    }

    public static void d(boolean z10, String str) {
        if (z10) {
            return;
        }
        throw new RuntimeException("Hard assert failed: " + str);
    }

    public static a e(Class cls) {
        ConcurrentMap concurrentMap = f16947a;
        a aVar = (a) concurrentMap.get(cls);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(cls);
        concurrentMap.put(cls, aVar2);
        return aVar2;
    }

    public static Object f(Object obj) {
        return g(obj, b.f16958d);
    }

    public static Object g(Object obj, b bVar) {
        if (bVar.b() > 500) {
            throw h(bVar, "Exceeded maximum depth of 500, which likely indicates there's an object cycle");
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            if ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) {
                return obj;
            }
            throw h(bVar, String.format("Numbers of type %s are not supported, please use an int, long, float or double", obj.getClass().getSimpleName()));
        }
        if ((obj instanceof String) || (obj instanceof Boolean)) {
            return obj;
        }
        if (obj instanceof Character) {
            throw h(bVar, "Characters are not supported, please use Strings");
        }
        if (obj instanceof Map) {
            HashMap map = new HashMap();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (!(key instanceof String)) {
                    throw h(bVar, "Maps with non-string keys are not supported");
                }
                String str = (String) key;
                map.put(str, g(entry.getValue(), bVar.a(str)));
            }
            return map;
        }
        if (!(obj instanceof Collection)) {
            if (obj.getClass().isArray()) {
                throw h(bVar, "Serializing Arrays is not supported, please use Lists instead");
            }
            if (!(obj instanceof Enum)) {
                return ((obj instanceof Date) || (obj instanceof a7.s) || (obj instanceof q0) || (obj instanceof d9.e) || (obj instanceof com.google.firebase.firestore.c) || (obj instanceof d9.u) || (obj instanceof y1)) ? obj : ((obj instanceof Uri) || (obj instanceof URI) || (obj instanceof URL)) ? obj.toString() : e(obj.getClass()).k(obj, bVar);
            }
            String strName = ((Enum) obj).name();
            try {
                return a.i(obj.getClass().getField(strName));
            } catch (NoSuchFieldException unused) {
                return strName;
            }
        }
        if (!(obj instanceof List)) {
            throw h(bVar, "Serializing Collections is not supported, please use Lists instead");
        }
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            arrayList.add(g(list.get(i10), bVar.a("[" + i10 + "]")));
        }
        return arrayList;
    }

    public static IllegalArgumentException h(b bVar, String str) {
        String str2 = "Could not serialize object. " + str;
        if (bVar.b() > 0) {
            str2 = str2 + " (found in field '" + bVar.toString() + "')";
        }
        return new IllegalArgumentException(str2);
    }
}
