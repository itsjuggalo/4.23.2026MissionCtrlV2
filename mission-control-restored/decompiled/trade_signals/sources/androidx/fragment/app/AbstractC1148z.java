package androidx.fragment.app;

import androidx.fragment.app.AbstractComponentCallbacksC1139p;

/* JADX INFO: renamed from: androidx.fragment.app.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1148z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w.i f11911a = new w.i();

    public static boolean b(ClassLoader classLoader, String str) {
        try {
            return AbstractComponentCallbacksC1139p.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        w.i iVar = f11911a;
        w.i iVar2 = (w.i) iVar.get(classLoader);
        if (iVar2 == null) {
            iVar2 = new w.i();
            iVar.put(classLoader, iVar2);
        }
        Class cls = (Class) iVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        iVar2.put(str, cls2);
        return cls2;
    }

    public static Class d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e8) {
            throw new AbstractComponentCallbacksC1139p.l("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e8);
        } catch (ClassNotFoundException e9) {
            throw new AbstractComponentCallbacksC1139p.l("Unable to instantiate fragment " + str + ": make sure class name exists", e9);
        }
    }

    public abstract AbstractComponentCallbacksC1139p a(ClassLoader classLoader, String str);
}
