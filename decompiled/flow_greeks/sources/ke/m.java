package ke;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f14843a = new m();

    public final String a(Constructor constructor) {
        t.f(constructor, "constructor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        Iterator itA = kotlin.jvm.internal.c.a(constructor.getParameterTypes());
        while (itA.hasNext()) {
            Class cls = (Class) itA.next();
            t.c(cls);
            sb2.append(le.f.f(cls));
        }
        sb2.append(")V");
        String string = sb2.toString();
        t.e(string, "toString(...)");
        return string;
    }

    public final String b(Field field) {
        t.f(field, "field");
        Class<?> type = field.getType();
        t.e(type, "getType(...)");
        return le.f.f(type);
    }

    public final String c(Method method) {
        t.f(method, "method");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        Iterator itA = kotlin.jvm.internal.c.a(method.getParameterTypes());
        while (itA.hasNext()) {
            Class cls = (Class) itA.next();
            t.c(cls);
            sb2.append(le.f.f(cls));
        }
        sb2.append(")");
        Class<?> returnType = method.getReturnType();
        t.e(returnType, "getReturnType(...)");
        sb2.append(le.f.f(returnType));
        String string = sb2.toString();
        t.e(string, "toString(...)");
        return string;
    }
}
