package Q0;

import I5.d;
import android.util.Log;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6645a = new a();

    public static final boolean e(String errorMessage, Function0 block) {
        StringBuilder sb;
        String str;
        AbstractC2304t.f(errorMessage, "errorMessage");
        AbstractC2304t.f(block, "block");
        try {
            boolean zBooleanValue = ((Boolean) block.invoke()).booleanValue();
            if (!zBooleanValue) {
                Log.e("ReflectionGuard", errorMessage);
            }
            return zBooleanValue;
        } catch (ClassNotFoundException unused) {
            sb = new StringBuilder();
            str = "ClassNotFound: ";
            sb.append(str);
            sb.append(errorMessage);
            Log.e("ReflectionGuard", sb.toString());
            return false;
        } catch (NoSuchFieldException unused2) {
            sb = new StringBuilder();
            str = "NoSuchField: ";
            sb.append(str);
            sb.append(errorMessage);
            Log.e("ReflectionGuard", sb.toString());
            return false;
        } catch (NoSuchMethodException unused3) {
            sb = new StringBuilder();
            str = "NoSuchMethod: ";
            sb.append(str);
            sb.append(errorMessage);
            Log.e("ReflectionGuard", sb.toString());
            return false;
        }
    }

    public final boolean a(Function0 classLoader) {
        AbstractC2304t.f(classLoader, "classLoader");
        try {
            classLoader.invoke();
            return true;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            return false;
        }
    }

    public final boolean b(Method method, d clazz) {
        AbstractC2304t.f(method, "<this>");
        AbstractC2304t.f(clazz, "clazz");
        return c(method, A5.a.b(clazz));
    }

    public final boolean c(Method method, Class clazz) {
        AbstractC2304t.f(method, "<this>");
        AbstractC2304t.f(clazz, "clazz");
        return method.getReturnType().equals(clazz);
    }

    public final boolean d(Method method) {
        AbstractC2304t.f(method, "<this>");
        return Modifier.isPublic(method.getModifiers());
    }
}
