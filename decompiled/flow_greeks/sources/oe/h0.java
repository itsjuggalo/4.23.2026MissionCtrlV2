package oe;

import ef.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f17975a = new h0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ef.c f17976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ef.b f17977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ef.b f17978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ef.b f17979e;

    static {
        ef.c cVar = new ef.c("kotlin.jvm.JvmField");
        f17976b = cVar;
        b.a aVar = ef.b.f8779d;
        f17977c = aVar.c(cVar);
        f17978d = aVar.c(new ef.c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        f17979e = b.a.b(aVar, "kotlin/jvm/internal/RepeatableContainer", false, 2, null);
    }

    public static final String b(String propertyName) {
        kotlin.jvm.internal.t.f(propertyName, "propertyName");
        if (f(propertyName)) {
            return propertyName;
        }
        return com.amazon.a.a.o.b.au + fg.a.a(propertyName);
    }

    public static final boolean c(String name) {
        kotlin.jvm.internal.t.f(name, "name");
        return kg.z.J(name, com.amazon.a.a.o.b.au, false, 2, null) || kg.z.J(name, "is", false, 2, null);
    }

    public static final boolean d(String name) {
        kotlin.jvm.internal.t.f(name, "name");
        return kg.z.J(name, "set", false, 2, null);
    }

    public static final String e(String propertyName) {
        String strA;
        kotlin.jvm.internal.t.f(propertyName, "propertyName");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("set");
        if (f(propertyName)) {
            strA = propertyName.substring(2);
            kotlin.jvm.internal.t.e(strA, "substring(...)");
        } else {
            strA = fg.a.a(propertyName);
        }
        sb2.append(strA);
        return sb2.toString();
    }

    public static final boolean f(String name) {
        kotlin.jvm.internal.t.f(name, "name");
        if (!kg.z.J(name, "is", false, 2, null) || name.length() == 2) {
            return false;
        }
        char cCharAt = name.charAt(2);
        return kotlin.jvm.internal.t.g(97, cCharAt) > 0 || kotlin.jvm.internal.t.g(cCharAt, 122) > 0;
    }

    public final ef.b a() {
        return f17979e;
    }
}
