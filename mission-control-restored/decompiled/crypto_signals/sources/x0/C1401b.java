package x0;

import android.app.Activity;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import y0.C1415c;
import y0.C1416d;

/* JADX INFO: renamed from: x0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1401b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f11449a;

    public C1416d a(Object obj, e eVar, Activity activity, D0.b bVar) throws IllegalAccessException, InvocationTargetException {
        C1415c c1415c = new C1415c(eVar, bVar);
        Object objNewProxyInstance = Proxy.newProxyInstance(this.f11449a, new Class[]{b()}, c1415c);
        j.d(objNewProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        obj.getClass().getMethod("addWindowLayoutInfoListener", Activity.class, b()).invoke(obj, activity, objNewProxyInstance);
        return new C1416d(obj.getClass().getMethod("removeWindowLayoutInfoListener", b()), obj, objNewProxyInstance);
    }

    public Class b() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f11449a.loadClass("java.util.function.Consumer");
        j.d(clsLoadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return clsLoadClass;
    }
}
