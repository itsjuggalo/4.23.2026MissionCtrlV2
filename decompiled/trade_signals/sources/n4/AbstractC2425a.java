package n4;

import com.google.gson.internal.F;
import com.google.gson.j;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: renamed from: n4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2425a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f21615a;

    /* JADX INFO: renamed from: n4.a$b */
    public static abstract class b {
        public b() {
        }

        public abstract Method a(Class cls, Field field);

        public abstract Constructor b(Class cls);

        public abstract String[] c(Class cls);

        public abstract boolean d(Class cls);
    }

    /* JADX INFO: renamed from: n4.a$c */
    public static class c extends b {
        public c() {
            super();
        }

        @Override // n4.AbstractC2425a.b
        public Method a(Class cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // n4.AbstractC2425a.b
        public Constructor b(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // n4.AbstractC2425a.b
        public String[] c(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // n4.AbstractC2425a.b
        public boolean d(Class cls) {
            return false;
        }
    }

    /* JADX INFO: renamed from: n4.a$d */
    public static class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f21616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f21617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f21618c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Method f21619d;

        public d() throws ClassNotFoundException {
            super();
            this.f21616a = Class.class.getMethod("isRecord", null);
            this.f21617b = Class.class.getMethod("getRecordComponents", null);
            Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
            this.f21618c = cls.getMethod("getName", null);
            this.f21619d = cls.getMethod("getType", null);
        }

        @Override // n4.AbstractC2425a.b
        public Method a(Class cls, Field field) {
            try {
                return cls.getMethod(field.getName(), null);
            } catch (ReflectiveOperationException e8) {
                throw AbstractC2425a.d(e8);
            }
        }

        @Override // n4.AbstractC2425a.b
        public Constructor b(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f21617b.invoke(cls, null);
                Class<?>[] clsArr = new Class[objArr.length];
                for (int i8 = 0; i8 < objArr.length; i8++) {
                    clsArr[i8] = (Class) this.f21619d.invoke(objArr[i8], null);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e8) {
                throw AbstractC2425a.d(e8);
            }
        }

        @Override // n4.AbstractC2425a.b
        public String[] c(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f21617b.invoke(cls, null);
                String[] strArr = new String[objArr.length];
                for (int i8 = 0; i8 < objArr.length; i8++) {
                    strArr[i8] = (String) this.f21618c.invoke(objArr[i8], null);
                }
                return strArr;
            } catch (ReflectiveOperationException e8) {
                throw AbstractC2425a.d(e8);
            }
        }

        @Override // n4.AbstractC2425a.b
        public boolean d(Class cls) {
            try {
                return ((Boolean) this.f21616a.invoke(cls, null)).booleanValue();
            } catch (ReflectiveOperationException e8) {
                throw AbstractC2425a.d(e8);
            }
        }
    }

    static {
        b cVar;
        try {
            cVar = new d();
        } catch (ReflectiveOperationException unused) {
            cVar = new c();
        }
        f21615a = cVar;
    }

    public static void b(AccessibleObject accessibleObject, StringBuilder sb) {
        sb.append('(');
        Class<?>[] parameterTypes = accessibleObject instanceof Method ? ((Method) accessibleObject).getParameterTypes() : ((Constructor) accessibleObject).getParameterTypes();
        for (int i8 = 0; i8 < parameterTypes.length; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i8].getSimpleName());
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String g(java.lang.reflect.AccessibleObject r4, boolean r5) {
        /*
            boolean r0 = r4 instanceof java.lang.reflect.Field
            java.lang.String r1 = "'"
            if (r0 == 0) goto L21
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "field '"
            r0.append(r2)
            java.lang.reflect.Field r4 = (java.lang.reflect.Field) r4
            java.lang.String r4 = f(r4)
        L16:
            r0.append(r4)
            r0.append(r1)
        L1c:
            java.lang.String r4 = r0.toString()
            goto L83
        L21:
            boolean r0 = r4 instanceof java.lang.reflect.Method
            if (r0 == 0) goto L5c
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = r4.getName()
            r0.<init>(r2)
            b(r4, r0)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "method '"
            r2.append(r3)
            java.lang.Class r4 = r4.getDeclaringClass()
            java.lang.String r4 = r4.getName()
            r2.append(r4)
            java.lang.String r4 = "#"
            r2.append(r4)
            r2.append(r0)
            r2.append(r1)
            java.lang.String r4 = r2.toString()
            goto L83
        L5c:
            boolean r0 = r4 instanceof java.lang.reflect.Constructor
            if (r0 == 0) goto L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "constructor '"
            r0.append(r2)
            java.lang.reflect.Constructor r4 = (java.lang.reflect.Constructor) r4
            java.lang.String r4 = c(r4)
            goto L16
        L71:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "<unknown AccessibleObject> "
            r0.append(r1)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            goto L1c
        L83:
            if (r5 == 0) goto Lac
            r5 = 0
            char r0 = r4.charAt(r5)
            boolean r0 = java.lang.Character.isLowerCase(r0)
            if (r0 == 0) goto Lac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r5 = r4.charAt(r5)
            char r5 = java.lang.Character.toUpperCase(r5)
            r0.append(r5)
            r5 = 1
            java.lang.String r4 = r4.substring(r5)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
        Lac:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.AbstractC2425a.g(java.lang.reflect.AccessibleObject, boolean):java.lang.String");
    }

    public static Method h(Class cls, Field field) {
        return f21615a.a(cls, field);
    }

    public static Constructor i(Class cls) {
        return f21615a.b(cls);
    }

    public static String j(Exception exc) {
        if (!exc.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
            return "";
        }
        String message = exc.getMessage();
        return "\nSee " + F.a((message == null || !message.contains("to module com.google.gson")) ? "reflection-inaccessible" : "reflection-inaccessible-to-module-gson");
    }

    public static String[] k(Class cls) {
        return f21615a.c(cls);
    }

    public static boolean l(Class cls) {
        return !n(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public static boolean m(Class cls) {
        return f21615a.d(cls);
    }

    public static boolean n(Class cls) {
        return Modifier.isStatic(cls.getModifiers());
    }

    public static void o(AccessibleObject accessibleObject) {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e8) {
            throw new j("Failed making " + g(accessibleObject, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type." + j(e8), e8);
        }
    }

    public static String p(Constructor constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e8) {
            return "Failed making constructor '" + c(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e8.getMessage() + j(e8);
        }
    }
}
