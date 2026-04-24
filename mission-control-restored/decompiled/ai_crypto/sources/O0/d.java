package O0;

import E5.E;
import android.app.Activity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f4013a;

    public static final class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final X5.c f4014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Q5.k f4015b;

        public a(X5.c clazz, Q5.k consumer) {
            r.f(clazz, "clazz");
            r.f(consumer, "consumer");
            this.f4014a = clazz;
            this.f4015b = consumer;
        }

        public final void a(Object parameter) {
            r.f(parameter, "parameter");
            this.f4015b.invoke(parameter);
        }

        public final boolean b(Method method, Object[] objArr) {
            return r.b(method.getName(), "accept") && objArr != null && objArr.length == 1;
        }

        public final boolean c(Method method, Object[] objArr) {
            return r.b(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        public final boolean d(Method method, Object[] objArr) {
            return r.b(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        public final boolean e(Method method, Object[] objArr) {
            return r.b(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            r.f(obj, "obj");
            r.f(method, "method");
            if (b(method, objArr)) {
                a(X5.d.a(this.f4014a, objArr != null ? objArr[0] : null));
                return E.f1657a;
            }
            if (c(method, objArr)) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            }
            if (d(method, objArr)) {
                return Integer.valueOf(this.f4015b.hashCode());
            }
            if (e(method, objArr)) {
                return this.f4015b.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
    }

    public interface b {
        void a();
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f4016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f4017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f4018c;

        public c(Method method, Object obj, Object obj2) {
            this.f4016a = method;
            this.f4017b = obj;
            this.f4018c = obj2;
        }

        @Override // O0.d.b
        public void a() throws IllegalAccessException, InvocationTargetException {
            this.f4016a.invoke(this.f4017b, this.f4018c);
        }
    }

    public d(ClassLoader loader) {
        r.f(loader, "loader");
        this.f4013a = loader;
    }

    public final Object a(X5.c cVar, Q5.k kVar) {
        Object objNewProxyInstance = Proxy.newProxyInstance(this.f4013a, new Class[]{d()}, new a(cVar, kVar));
        r.e(objNewProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        return objNewProxyInstance;
    }

    public final Class b() {
        try {
            return d();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final b c(Object obj, X5.c clazz, String addMethodName, String removeMethodName, Activity activity, Q5.k consumer) throws IllegalAccessException, InvocationTargetException {
        r.f(obj, "obj");
        r.f(clazz, "clazz");
        r.f(addMethodName, "addMethodName");
        r.f(removeMethodName, "removeMethodName");
        r.f(activity, "activity");
        r.f(consumer, "consumer");
        Object objA = a(clazz, consumer);
        obj.getClass().getMethod(addMethodName, Activity.class, d()).invoke(obj, activity, objA);
        return new c(obj.getClass().getMethod(removeMethodName, d()), obj, objA);
    }

    public final Class d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f4013a.loadClass("java.util.function.Consumer");
        r.e(clsLoadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return clsLoadClass;
    }
}
