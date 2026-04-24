package s2;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H f14612a = c();

    public class a extends H {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f14613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f14614c;

        public a(Method method, Object obj) {
            this.f14613b = method;
            this.f14614c = obj;
        }

        @Override // s2.H
        public Object d(Class cls) {
            H.b(cls);
            return this.f14613b.invoke(this.f14614c, cls);
        }
    }

    public class b extends H {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f14615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f14616c;

        public b(Method method, int i4) {
            this.f14615b = method;
            this.f14616c = i4;
        }

        @Override // s2.H
        public Object d(Class cls) {
            H.b(cls);
            return this.f14615b.invoke(null, cls, Integer.valueOf(this.f14616c));
        }
    }

    public class c extends H {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f14617b;

        public c(Method method) {
            this.f14617b = method;
        }

        @Override // s2.H
        public Object d(Class cls) {
            H.b(cls);
            return this.f14617b.invoke(null, cls, Object.class);
        }
    }

    public class d extends H {
        @Override // s2.H
        public Object d(Class cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    public static void b(Class cls) {
        String strS = u.s(cls);
        if (strS == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + strS);
    }

    public static H c() {
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    return new d();
                }
            } catch (Exception unused2) {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                return new c(declaredMethod);
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            return new b(declaredMethod3, iIntValue);
        }
    }

    public abstract Object d(Class cls);
}
