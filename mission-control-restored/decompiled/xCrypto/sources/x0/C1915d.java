package x0;

import W2.E;
import android.app.Activity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.r;
import p3.InterfaceC1716c;

/* JADX INFO: renamed from: x0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1915d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f15698a;

    /* JADX INFO: renamed from: x0.d$a */
    public static final class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC1716c f15699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i3.k f15700b;

        public a(InterfaceC1716c clazz, i3.k consumer) {
            r.f(clazz, "clazz");
            r.f(consumer, "consumer");
            this.f15699a = clazz;
            this.f15700b = consumer;
        }

        public final void a(Object parameter) {
            r.f(parameter, "parameter");
            this.f15700b.invoke(parameter);
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
                a(p3.d.a(this.f15699a, objArr != null ? objArr[0] : null));
                return E.f5463a;
            }
            if (c(method, objArr)) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            }
            if (d(method, objArr)) {
                return Integer.valueOf(this.f15700b.hashCode());
            }
            if (e(method, objArr)) {
                return this.f15700b.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
    }

    /* JADX INFO: renamed from: x0.d$b */
    public interface b {
        void dispose();
    }

    /* JADX INFO: renamed from: x0.d$c */
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f15701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f15702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f15703c;

        public c(Method method, Object obj, Object obj2) {
            this.f15701a = method;
            this.f15702b = obj;
            this.f15703c = obj2;
        }

        @Override // x0.C1915d.b
        public void dispose() throws IllegalAccessException, InvocationTargetException {
            this.f15701a.invoke(this.f15702b, this.f15703c);
        }
    }

    public C1915d(ClassLoader loader) {
        r.f(loader, "loader");
        this.f15698a = loader;
    }

    public final Object a(InterfaceC1716c interfaceC1716c, i3.k kVar) {
        Object objNewProxyInstance = Proxy.newProxyInstance(this.f15698a, new Class[]{d()}, new a(interfaceC1716c, kVar));
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

    public final b c(Object obj, InterfaceC1716c clazz, String addMethodName, String removeMethodName, Activity activity, i3.k consumer) throws IllegalAccessException, InvocationTargetException {
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
        Class<?> clsLoadClass = this.f15698a.loadClass("java.util.function.Consumer");
        r.e(clsLoadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return clsLoadClass;
    }
}
