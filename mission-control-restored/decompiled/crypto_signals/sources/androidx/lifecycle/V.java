package androidx.lifecycle;

import android.app.Application;
import d0.C0520b;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class V extends X {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static V f4665c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Application f4666b;

    public V(Application application) {
        this.f4666b = application;
    }

    @Override // androidx.lifecycle.X, androidx.lifecycle.W
    public final T a(Class cls) {
        Application application = this.f4666b;
        if (application != null) {
            return b(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    public final T b(Class cls, Application application) {
        if (!AbstractC0344a.class.isAssignableFrom(cls)) {
            return super.a(cls);
        }
        try {
            T t6 = (T) cls.getConstructor(Application.class).newInstance(application);
            kotlin.jvm.internal.j.d(t6, "{\n                try {\n…          }\n            }");
            return t6;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("Cannot create an instance of " + cls, e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException("Cannot create an instance of " + cls, e7);
        }
    }

    @Override // androidx.lifecycle.W
    public final T f(Class cls, C0520b c0520b) {
        if (this.f4666b != null) {
            return a(cls);
        }
        Application application = (Application) ((LinkedHashMap) c0520b.f1130a).get(U.f4663a);
        if (application != null) {
            return b(cls, application);
        }
        if (AbstractC0344a.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return super.a(cls);
    }
}
