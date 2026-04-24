package W0;

import X5.c;
import android.util.Log;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5359a = new a();

    public static final boolean e(String str, Function0 block) {
        r.f(block, "block");
        try {
            boolean zBooleanValue = ((Boolean) block.invoke()).booleanValue();
            if (!zBooleanValue && str != null) {
                Log.e("ReflectionGuard", str);
            }
            return zBooleanValue;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("ClassNotFound: ");
            if (str == null) {
                str = "";
            }
            sb.append(str);
            Log.e("ReflectionGuard", sb.toString());
            return false;
        } catch (NoSuchMethodException unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NoSuchMethod: ");
            if (str == null) {
                str = "";
            }
            sb2.append(str);
            Log.e("ReflectionGuard", sb2.toString());
            return false;
        }
    }

    public final boolean a(Function0 classLoader) {
        r.f(classLoader, "classLoader");
        try {
            classLoader.invoke();
            return true;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            return false;
        }
    }

    public final boolean b(Method method, c clazz) {
        r.f(method, "<this>");
        r.f(clazz, "clazz");
        return c(method, P5.a.a(clazz));
    }

    public final boolean c(Method method, Class clazz) {
        r.f(method, "<this>");
        r.f(clazz, "clazz");
        return method.getReturnType().equals(clazz);
    }

    public final boolean d(Method method) {
        r.f(method, "<this>");
        return Modifier.isPublic(method.getModifiers());
    }
}
