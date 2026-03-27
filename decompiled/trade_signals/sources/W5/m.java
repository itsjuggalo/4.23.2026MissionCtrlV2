package W5;

import X5.AbstractC0990f;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2288c;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f9305a = new m();

    public final String a(Constructor constructor) {
        AbstractC2304t.f(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Iterator itA = AbstractC2288c.a(constructor.getParameterTypes());
        while (itA.hasNext()) {
            Class cls = (Class) itA.next();
            AbstractC2304t.c(cls);
            sb.append(AbstractC0990f.f(cls));
        }
        sb.append(")V");
        String string = sb.toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }

    public final String b(Field field) {
        AbstractC2304t.f(field, "field");
        Class<?> type = field.getType();
        AbstractC2304t.e(type, "getType(...)");
        return AbstractC0990f.f(type);
    }

    public final String c(Method method) {
        AbstractC2304t.f(method, "method");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Iterator itA = AbstractC2288c.a(method.getParameterTypes());
        while (itA.hasNext()) {
            Class cls = (Class) itA.next();
            AbstractC2304t.c(cls);
            sb.append(AbstractC0990f.f(cls));
        }
        sb.append(")");
        Class<?> returnType = method.getReturnType();
        AbstractC2304t.e(returnType, "getReturnType(...)");
        sb.append(AbstractC0990f.f(returnType));
        String string = sb.toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }
}
