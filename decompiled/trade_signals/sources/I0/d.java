package I0;

import android.app.Activity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f4027a;

    public static final class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final I5.d f4028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final B5.k f4029b;

        public a(I5.d clazz, B5.k consumer) {
            AbstractC2304t.f(clazz, "clazz");
            AbstractC2304t.f(consumer, "consumer");
            this.f4028a = clazz;
            this.f4029b = consumer;
        }

        public final void a(Object parameter) {
            AbstractC2304t.f(parameter, "parameter");
            this.f4029b.invoke(parameter);
        }

        public final boolean b(Method method, Object[] objArr) {
            return AbstractC2304t.b(method.getName(), "accept") && objArr != null && objArr.length == 1;
        }

        public final boolean c(Method method, Object[] objArr) {
            return AbstractC2304t.b(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        public final boolean d(Method method, Object[] objArr) {
            return AbstractC2304t.b(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        public final boolean e(Method method, Object[] objArr) {
            return AbstractC2304t.b(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            AbstractC2304t.f(obj, "obj");
            AbstractC2304t.f(method, "method");
            if (b(method, objArr)) {
                a(I5.e.a(this.f4028a, objArr != null ? objArr[0] : null));
                return C2470H.f21956a;
            }
            if (c(method, objArr)) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            }
            if (d(method, objArr)) {
                return Integer.valueOf(this.f4029b.hashCode());
            }
            if (e(method, objArr)) {
                return this.f4029b.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
    }

    public interface b {
        void dispose();
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f4030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f4031b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f4032c;

        public c(Method method, Object obj, Object obj2) {
            this.f4030a = method;
            this.f4031b = obj;
            this.f4032c = obj2;
        }

        @Override // I0.d.b
        public void dispose() throws IllegalAccessException, InvocationTargetException {
            this.f4030a.invoke(this.f4031b, this.f4032c);
        }
    }

    public d(ClassLoader loader) {
        AbstractC2304t.f(loader, "loader");
        this.f4027a = loader;
    }

    public final Object a(I5.d dVar, B5.k kVar) {
        Object objNewProxyInstance = Proxy.newProxyInstance(this.f4027a, new Class[]{d()}, new a(dVar, kVar));
        AbstractC2304t.e(objNewProxyInstance, "newProxyInstance(...)");
        return objNewProxyInstance;
    }

    public final Class b() {
        try {
            return d();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final b c(Object obj, I5.d clazz, String addMethodName, String removeMethodName, Activity activity, B5.k consumer) throws IllegalAccessException, InvocationTargetException {
        AbstractC2304t.f(obj, "obj");
        AbstractC2304t.f(clazz, "clazz");
        AbstractC2304t.f(addMethodName, "addMethodName");
        AbstractC2304t.f(removeMethodName, "removeMethodName");
        AbstractC2304t.f(activity, "activity");
        AbstractC2304t.f(consumer, "consumer");
        Object objA = a(clazz, consumer);
        obj.getClass().getMethod(addMethodName, Activity.class, d()).invoke(obj, activity, objA);
        return new c(obj.getClass().getMethod(removeMethodName, d()), obj, objA);
    }

    public final Class d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f4027a.loadClass("java.util.function.Consumer");
        AbstractC2304t.e(clsLoadClass, "loadClass(...)");
        return clsLoadClass;
    }
}
