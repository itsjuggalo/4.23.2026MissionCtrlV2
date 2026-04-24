package n4;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H f19641a = c();

    public class a extends H {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f19642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f19643c;

        public a(Method method, Object obj) {
            this.f19642b = method;
            this.f19643c = obj;
        }

        @Override // n4.H
        public Object d(Class cls) {
            H.b(cls);
            return this.f19642b.invoke(this.f19643c, cls);
        }
    }

    public class b extends H {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f19644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f19645c;

        public b(Method method, int i7) {
            this.f19644b = method;
            this.f19645c = i7;
        }

        @Override // n4.H
        public Object d(Class cls) {
            H.b(cls);
            return this.f19644b.invoke(null, cls, Integer.valueOf(this.f19645c));
        }
    }

    public class c extends H {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f19646b;

        public c(Method method) {
            this.f19646b = method;
        }

        @Override // n4.H
        public Object d(Class cls) {
            H.b(cls);
            return this.f19646b.invoke(null, cls, Object.class);
        }
    }

    public class d extends H {
        @Override // n4.H
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
