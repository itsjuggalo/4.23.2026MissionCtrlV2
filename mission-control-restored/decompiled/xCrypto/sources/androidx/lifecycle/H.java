package androidx.lifecycle;

import X2.AbstractC0765l;
import X2.AbstractC0768o;
import X2.AbstractC0769p;
import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f7641a = AbstractC0769p.j(Application.class, A.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f7642b = AbstractC0768o.b(A.class);

    public static final Constructor c(Class modelClass, List signature) {
        kotlin.jvm.internal.r.f(modelClass, "modelClass");
        kotlin.jvm.internal.r.f(signature, "signature");
        Constructor<?>[] constructors = modelClass.getConstructors();
        kotlin.jvm.internal.r.e(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            kotlin.jvm.internal.r.e(parameterTypes, "constructor.parameterTypes");
            List listJ0 = AbstractC0765l.j0(parameterTypes);
            if (kotlin.jvm.internal.r.b(signature, listJ0)) {
                kotlin.jvm.internal.r.d(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (signature.size() == listJ0.size() && listJ0.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final J d(Class modelClass, Constructor constructor, Object... params) {
        kotlin.jvm.internal.r.f(modelClass, "modelClass");
        kotlin.jvm.internal.r.f(constructor, "constructor");
        kotlin.jvm.internal.r.f(params, "params");
        try {
            return (J) constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Failed to access " + modelClass, e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e6.getCause());
        }
    }
}
