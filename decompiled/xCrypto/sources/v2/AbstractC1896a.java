package v2;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import q2.k;
import s2.G;

/* JADX INFO: renamed from: v2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1896a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f15313a;

    /* JADX INFO: renamed from: v2.a$b */
    public static abstract class b {
        public b() {
        }

        public abstract Method a(Class cls, Field field);

        public abstract Constructor b(Class cls);

        public abstract String[] c(Class cls);

        public abstract boolean d(Class cls);
    }

    /* JADX INFO: renamed from: v2.a$c */
    public static class c extends b {
        public c() {
            super();
        }

        @Override // v2.AbstractC1896a.b
        public Method a(Class cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // v2.AbstractC1896a.b
        public Constructor b(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // v2.AbstractC1896a.b
        public String[] c(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // v2.AbstractC1896a.b
        public boolean d(Class cls) {
            return false;
        }
    }

    /* JADX INFO: renamed from: v2.a$d */
    public static class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f15314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f15315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f15316c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Method f15317d;

        @Override // v2.AbstractC1896a.b
        public Method a(Class cls, Field field) {
            try {
                return cls.getMethod(field.getName(), new Class[0]);
            } catch (ReflectiveOperationException e4) {
                throw AbstractC1896a.d(e4);
            }
        }

        @Override // v2.AbstractC1896a.b
        public Constructor b(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f15315b.invoke(cls, new Object[0]);
                Class<?>[] clsArr = new Class[objArr.length];
                for (int i4 = 0; i4 < objArr.length; i4++) {
                    clsArr[i4] = (Class) this.f15317d.invoke(objArr[i4], new Object[0]);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e4) {
                throw AbstractC1896a.d(e4);
            }
        }

        @Override // v2.AbstractC1896a.b
        public String[] c(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f15315b.invoke(cls, new Object[0]);
                String[] strArr = new String[objArr.length];
                for (int i4 = 0; i4 < objArr.length; i4++) {
                    strArr[i4] = (String) this.f15316c.invoke(objArr[i4], new Object[0]);
                }
                return strArr;
            } catch (ReflectiveOperationException e4) {
                throw AbstractC1896a.d(e4);
            }
        }

        @Override // v2.AbstractC1896a.b
        public boolean d(Class cls) {
            try {
                return ((Boolean) this.f15314a.invoke(cls, new Object[0])).booleanValue();
            } catch (ReflectiveOperationException e4) {
                throw AbstractC1896a.d(e4);
            }
        }

        public d() throws ClassNotFoundException {
            super();
            this.f15314a = Class.class.getMethod("isRecord", new Class[0]);
            this.f15315b = Class.class.getMethod("getRecordComponents", new Class[0]);
            Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
            this.f15316c = cls.getMethod("getName", new Class[0]);
            this.f15317d = cls.getMethod("getType", new Class[0]);
        }
    }

    static {
        b cVar;
        try {
            cVar = new d();
        } catch (ReflectiveOperationException unused) {
            cVar = new c();
        }
        f15313a = cVar;
    }

    public static void b(AccessibleObject accessibleObject, StringBuilder sb) {
        sb.append('(');
        Class<?>[] parameterTypes = accessibleObject instanceof Method ? ((Method) accessibleObject).getParameterTypes() : ((Constructor) accessibleObject).getParameterTypes();
        for (int i4 = 0; i4 < parameterTypes.length; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i4].getSimpleName());
        }
        sb.append(')');
    }

    public static String c(Constructor constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        b(constructor, sb);
        return sb.toString();
    }

    public static RuntimeException d(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.12.0). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException e(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.12.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String f(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static String g(AccessibleObject accessibleObject, boolean z4) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + f((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            b(method, sb);
            str = "method '" + method.getDeclaringClass().getName() + "#" + sb.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + c((Constructor) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (!z4 || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static Method h(Class cls, Field field) {
        return f15313a.a(cls, field);
    }

    public static Constructor i(Class cls) {
        return f15313a.b(cls);
    }

    public static String j(Exception exc) {
        if (!exc.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
            return "";
        }
        String message = exc.getMessage();
        return "\nSee " + G.a((message == null || !message.contains("to module com.google.gson")) ? "reflection-inaccessible" : "reflection-inaccessible-to-module-gson");
    }

    public static String[] k(Class cls) {
        return f15313a.c(cls);
    }

    public static boolean l(Class cls) {
        if (n(cls)) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    public static boolean m(Class cls) {
        return f15313a.d(cls);
    }

    public static boolean n(Class cls) {
        return Modifier.isStatic(cls.getModifiers());
    }

    public static void o(AccessibleObject accessibleObject) {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e4) {
            throw new k("Failed making " + g(accessibleObject, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type." + j(e4), e4);
        }
    }

    public static String p(Constructor constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e4) {
            return "Failed making constructor '" + c(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e4.getMessage() + j(e4);
        }
    }
}
