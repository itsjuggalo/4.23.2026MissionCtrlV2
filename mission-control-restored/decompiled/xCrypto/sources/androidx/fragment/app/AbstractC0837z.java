package androidx.fragment.app;

import androidx.fragment.app.AbstractComponentCallbacksC0828p;
import u.C1859g;

/* JADX INFO: renamed from: androidx.fragment.app.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0837z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1859g f7615a = new C1859g();

    public static boolean b(ClassLoader classLoader, String str) {
        try {
            return AbstractComponentCallbacksC0828p.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        C1859g c1859g = f7615a;
        C1859g c1859g2 = (C1859g) c1859g.get(classLoader);
        if (c1859g2 == null) {
            c1859g2 = new C1859g();
            c1859g.put(classLoader, c1859g2);
        }
        Class cls = (Class) c1859g2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        c1859g2.put(str, cls2);
        return cls2;
    }

    public static Class d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e4) {
            throw new AbstractComponentCallbacksC0828p.l("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e4);
        } catch (ClassNotFoundException e5) {
            throw new AbstractComponentCallbacksC0828p.l("Unable to instantiate fragment " + str + ": make sure class name exists", e5);
        }
    }

    public abstract AbstractComponentCallbacksC0828p a(ClassLoader classLoader, String str);
}
