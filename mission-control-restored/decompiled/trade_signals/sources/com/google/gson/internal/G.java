package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final G f16033a = c();

    public class a extends G {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f16034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f16035c;

        public a(Method method, Object obj) {
            this.f16034b = method;
            this.f16035c = obj;
        }

        @Override // com.google.gson.internal.G
        public Object d(Class cls) {
            G.b(cls);
            return this.f16034b.invoke(this.f16035c, cls);
        }
    }

    public class b extends G {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f16036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f16037c;

        public b(Method method, int i8) {
            this.f16036b = method;
            this.f16037c = i8;
        }

        @Override // com.google.gson.internal.G
        public Object d(Class cls) {
            G.b(cls);
            return this.f16036b.invoke(null, cls, Integer.valueOf(this.f16037c));
        }
    }

    public class c extends G {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f16038b;

        public c(Method method) {
            this.f16038b = method;
        }

        @Override // com.google.gson.internal.G
        public Object d(Class cls) {
            G.b(cls);
            return this.f16038b.invoke(null, cls, Object.class);
        }
    }

    public class d extends G {
        @Override // com.google.gson.internal.G
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

    public static G c() {
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
