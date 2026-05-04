package b3;

import android.util.Log;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.t;
import wd.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2934a = new a();

    public static final boolean e(String errorMessage, Function0 block) {
        t.f(errorMessage, "errorMessage");
        t.f(block, "block");
        try {
            boolean zBooleanValue = ((Boolean) block.invoke()).booleanValue();
            if (!zBooleanValue) {
                Log.e("ReflectionGuard", errorMessage);
            }
            return zBooleanValue;
        } catch (ClassNotFoundException unused) {
            Log.e("ReflectionGuard", "ClassNotFound: " + errorMessage);
            return false;
        } catch (NoSuchFieldException unused2) {
            Log.e("ReflectionGuard", "NoSuchField: " + errorMessage);
            return false;
        } catch (NoSuchMethodException unused3) {
            Log.e("ReflectionGuard", "NoSuchMethod: " + errorMessage);
            return false;
        }
    }

    public final boolean a(Function0 classLoader) {
        t.f(classLoader, "classLoader");
        try {
            classLoader.invoke();
            return true;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            return false;
        }
    }

    public final boolean b(Method method, Class clazz) {
        t.f(method, "<this>");
        t.f(clazz, "clazz");
        return method.getReturnType().equals(clazz);
    }

    public final boolean c(Method method, d clazz) {
        t.f(method, "<this>");
        t.f(clazz, "clazz");
        return b(method, od.a.b(clazz));
    }

    public final boolean d(Method method) {
        t.f(method, "<this>");
        return Modifier.isPublic(method.getModifiers());
    }
}
