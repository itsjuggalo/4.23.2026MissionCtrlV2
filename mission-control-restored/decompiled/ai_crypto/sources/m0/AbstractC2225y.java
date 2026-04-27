package m0;

import m0.AbstractComponentCallbacksC2216p;

/* JADX INFO: renamed from: m0.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2225y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u.g f18935a = new u.g();

    public static boolean b(ClassLoader classLoader, String str) {
        try {
            return AbstractComponentCallbacksC2216p.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        u.g gVar = f18935a;
        u.g gVar2 = (u.g) gVar.get(classLoader);
        if (gVar2 == null) {
            gVar2 = new u.g();
            gVar.put(classLoader, gVar2);
        }
        Class cls = (Class) gVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        gVar2.put(str, cls2);
        return cls2;
    }

    public static Class d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e7) {
            throw new AbstractComponentCallbacksC2216p.h("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e7);
        } catch (ClassNotFoundException e8) {
            throw new AbstractComponentCallbacksC2216p.h("Unable to instantiate fragment " + str + ": make sure class name exists", e8);
        }
    }

    public abstract AbstractComponentCallbacksC2216p a(ClassLoader classLoader, String str);
}
