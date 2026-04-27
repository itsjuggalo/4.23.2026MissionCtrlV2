package w6;

import java.io.IOException;
import kotlin.jvm.internal.AbstractC2148j;
import w6.Q;

/* JADX INFO: renamed from: w6.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2798k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25129a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC2798k f25130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Q f25131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractC2798k f25132d;

    /* JADX INFO: renamed from: w6.k$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    static {
        AbstractC2798k c2805s;
        try {
            Class.forName("java.nio.file.Files");
            c2805s = new K();
        } catch (ClassNotFoundException unused) {
            c2805s = new C2805s();
        }
        f25130b = c2805s;
        Q.a aVar = Q.f25040b;
        String property = System.getProperty("java.io.tmpdir");
        kotlin.jvm.internal.r.e(property, "getProperty(\"java.io.tmpdir\")");
        f25131c = Q.a.e(aVar, property, false, 1, null);
        ClassLoader classLoader = x6.h.class.getClassLoader();
        kotlin.jvm.internal.r.e(classLoader, "ResourceFileSystem::class.java.classLoader");
        f25132d = new x6.h(classLoader, false);
    }

    public abstract void a(Q q7, Q q8);

    public final void b(Q dir, boolean z7) throws IOException {
        kotlin.jvm.internal.r.f(dir, "dir");
        x6.c.a(this, dir, z7);
    }

    public final void c(Q dir) {
        kotlin.jvm.internal.r.f(dir, "dir");
        d(dir, false);
    }

    public abstract void d(Q q7, boolean z7);

    public final void e(Q path) {
        kotlin.jvm.internal.r.f(path, "path");
        f(path, false);
    }

    public abstract void f(Q q7, boolean z7);

    public final boolean g(Q path) {
        kotlin.jvm.internal.r.f(path, "path");
        return x6.c.b(this, path);
    }

    public abstract C2797j h(Q q7);

    public abstract AbstractC2796i i(Q q7);

    public final AbstractC2796i j(Q file) {
        kotlin.jvm.internal.r.f(file, "file");
        return k(file, false, false);
    }

    public abstract AbstractC2796i k(Q q7, boolean z7, boolean z8);

    public abstract Z l(Q q7);
}
