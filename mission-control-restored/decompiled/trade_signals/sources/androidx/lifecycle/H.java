package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;
import p5.AbstractC2594p;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
public abstract class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f11937a = AbstractC2595q.l(Application.class, A.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f11938b = AbstractC2594p.e(A.class);

    public static final Constructor c(Class modelClass, List signature) {
        AbstractC2304t.f(modelClass, "modelClass");
        AbstractC2304t.f(signature, "signature");
        Constructor<?>[] constructors = modelClass.getConstructors();
        AbstractC2304t.e(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            AbstractC2304t.e(parameterTypes, "constructor.parameterTypes");
            List listK0 = AbstractC2592n.k0(parameterTypes);
            if (AbstractC2304t.b(signature, listK0)) {
                AbstractC2304t.d(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (signature.size() == listK0.size() && listK0.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final J d(Class modelClass, Constructor constructor, Object... params) {
        AbstractC2304t.f(modelClass, "modelClass");
        AbstractC2304t.f(constructor, "constructor");
        AbstractC2304t.f(params, "params");
        try {
            return (J) constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("Failed to access " + modelClass, e8);
        } catch (InstantiationException e9) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e9);
        } catch (InvocationTargetException e10) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e10.getCause());
        }
    }
}
