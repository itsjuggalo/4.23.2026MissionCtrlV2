package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class X implements W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static X f4667a;

    @Override // androidx.lifecycle.W
    public T a(Class cls) throws InvocationTargetException {
        try {
            Object objNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            kotlin.jvm.internal.j.d(objNewInstance, "{\n                modelC…wInstance()\n            }");
            return (T) objNewInstance;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("Cannot create an instance of " + cls, e6);
        }
    }
}
