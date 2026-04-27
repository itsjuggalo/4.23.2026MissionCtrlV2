package u5;

import p0.C0899k;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f10543a;

    static {
        s sVar;
        try {
            Class.forName("java.nio.file.Files");
            sVar = new t();
        } catch (ClassNotFoundException unused) {
            sVar = new s();
        }
        f10543a = sVar;
        String str = v.f10549b;
        String property = System.getProperty("java.io.tmpdir");
        kotlin.jvm.internal.j.d(property, "getProperty(\"java.io.tmpdir\")");
        C0899k.h(property, false);
        ClassLoader classLoader = v5.d.class.getClassLoader();
        kotlin.jvm.internal.j.d(classLoader, "ResourceFileSystem::class.java.classLoader");
        new v5.d(classLoader);
    }

    public final boolean a(v path) {
        kotlin.jvm.internal.j.e(path, "path");
        return b(path) != null;
    }

    public abstract m b(v vVar);
}
