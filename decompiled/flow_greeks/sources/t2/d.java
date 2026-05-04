package t2;

import android.app.Activity;
import cd.h0;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f20641a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final wd.d f20642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final pd.k f20643b;

        public a(wd.d clazz, pd.k consumer) {
            t.f(clazz, "clazz");
            t.f(consumer, "consumer");
            this.f20642a = clazz;
            this.f20643b = consumer;
        }

        public final void a(Object parameter) {
            t.f(parameter, "parameter");
            this.f20643b.invoke(parameter);
        }

        public final boolean b(Method method, Object[] objArr) {
            return t.b(method.getName(), "accept") && objArr != null && objArr.length == 1;
        }

        public final boolean c(Method method, Object[] objArr) {
            return t.b(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        public final boolean d(Method method, Object[] objArr) {
            return t.b(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        public final boolean e(Method method, Object[] objArr) {
            return t.b(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            t.f(obj, "obj");
            t.f(method, "method");
            if (b(method, objArr)) {
                a(wd.e.a(this.f20642a, objArr != null ? objArr[0] : null));
                return h0.f3852a;
            }
            if (c(method, objArr)) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            }
            if (d(method, objArr)) {
                return Integer.valueOf(this.f20643b.hashCode());
            }
            if (e(method, objArr)) {
                return this.f20643b.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        void dispose();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f20644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f20645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f20646c;

        public c(Method method, Object obj, Object obj2) {
            this.f20644a = method;
            this.f20645b = obj;
            this.f20646c = obj2;
        }

        @Override // t2.d.b
        public void dispose() throws IllegalAccessException, InvocationTargetException {
            this.f20644a.invoke(this.f20645b, this.f20646c);
        }
    }

    public d(ClassLoader loader) {
        t.f(loader, "loader");
        this.f20641a = loader;
    }

    public final Object a(wd.d dVar, pd.k kVar) {
        Object objNewProxyInstance = Proxy.newProxyInstance(this.f20641a, new Class[]{d()}, new a(dVar, kVar));
        t.e(objNewProxyInstance, "newProxyInstance(...)");
        return objNewProxyInstance;
    }

    public final Class b() {
        try {
            return d();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final b c(Object obj, wd.d clazz, String addMethodName, String removeMethodName, Activity activity, pd.k consumer) throws IllegalAccessException, InvocationTargetException {
        t.f(obj, "obj");
        t.f(clazz, "clazz");
        t.f(addMethodName, "addMethodName");
        t.f(removeMethodName, "removeMethodName");
        t.f(activity, "activity");
        t.f(consumer, "consumer");
        Object objA = a(clazz, consumer);
        obj.getClass().getMethod(addMethodName, Activity.class, d()).invoke(obj, activity, objA);
        return new c(obj.getClass().getMethod(removeMethodName, d()), obj, objA);
    }

    public final Class d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f20641a.loadClass("java.util.function.Consumer");
        t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }
}
