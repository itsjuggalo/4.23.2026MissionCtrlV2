package a6;

import kotlin.jvm.internal.AbstractC2304t;
import q6.b;

/* JADX INFO: loaded from: classes2.dex */
public final class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H f10020a = new H();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q6.c f10021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q6.b f10022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q6.b f10023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q6.b f10024e;

    static {
        q6.c cVar = new q6.c("kotlin.jvm.JvmField");
        f10021b = cVar;
        b.a aVar = q6.b.f22655d;
        f10022c = aVar.c(cVar);
        f10023d = aVar.c(new q6.c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        f10024e = b.a.b(aVar, "kotlin/jvm/internal/RepeatableContainer", false, 2, null);
    }

    public static final String b(String propertyName) {
        AbstractC2304t.f(propertyName, "propertyName");
        if (f(propertyName)) {
            return propertyName;
        }
        return com.amazon.a.a.o.b.au + Q6.a.a(propertyName);
    }

    public static final boolean c(String name) {
        AbstractC2304t.f(name, "name");
        return V6.A.G(name, com.amazon.a.a.o.b.au, false, 2, null) || V6.A.G(name, "is", false, 2, null);
    }

    public static final boolean d(String name) {
        AbstractC2304t.f(name, "name");
        return V6.A.G(name, "set", false, 2, null);
    }

    public static final String e(String propertyName) {
        String strA;
        AbstractC2304t.f(propertyName, "propertyName");
        StringBuilder sb = new StringBuilder();
        sb.append("set");
        if (f(propertyName)) {
            strA = propertyName.substring(2);
            AbstractC2304t.e(strA, "substring(...)");
        } else {
            strA = Q6.a.a(propertyName);
        }
        sb.append(strA);
        return sb.toString();
    }

    public static final boolean f(String name) {
        AbstractC2304t.f(name, "name");
        if (!V6.A.G(name, "is", false, 2, null) || name.length() == 2) {
            return false;
        }
        char cCharAt = name.charAt(2);
        return AbstractC2304t.g(97, cCharAt) > 0 || AbstractC2304t.g(cCharAt, 122) > 0;
    }

    public final q6.b a() {
        return f10024e;
    }
}
