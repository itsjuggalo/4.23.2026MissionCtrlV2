package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f2413a = dd.r.n(Application.class, z.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f2414b = dd.q.e(z.class);

    public static final Constructor c(Class modelClass, List signature) {
        kotlin.jvm.internal.t.f(modelClass, "modelClass");
        kotlin.jvm.internal.t.f(signature, "signature");
        Constructor<?>[] constructors = modelClass.getConstructors();
        kotlin.jvm.internal.t.e(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            kotlin.jvm.internal.t.e(parameterTypes, "constructor.parameterTypes");
            List listZ0 = dd.n.z0(parameterTypes);
            if (kotlin.jvm.internal.t.b(signature, listZ0)) {
                kotlin.jvm.internal.t.d(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (signature.size() == listZ0.size() && listZ0.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final i0 d(Class modelClass, Constructor constructor, Object... params) {
        kotlin.jvm.internal.t.f(modelClass, "modelClass");
        kotlin.jvm.internal.t.f(constructor, "constructor");
        kotlin.jvm.internal.t.f(params, "params");
        try {
            return (i0) constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Failed to access " + modelClass, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e12.getCause());
        }
    }
}
